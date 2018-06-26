#include "qsr.h"
#include <stdio.h>
#include <stdlib.h>

void peakDetection(QRS_params *params, int * peaks, int * filteredData, int arrayLength){
    
    
    if(filteredData[arrayLength-3] < filteredData[arrayLength-2]  && filteredData[arrayLength-2] >= filteredData[arrayLength-1]){
        shiftArray(peaks, arrayLength);
        peaks[arrayLength-1] = filteredData[arrayLength-2];
        
        if(peaks[arrayLength-1] > params->THRESHOLD1){
            
            calculateRR(params, peaks, arrayLength);
            
        } else {
            
            //printf("PEAK LOWER THAN THRESHOLD1!\n");
            updateThreshold1(params, peaks, arrayLength);
        }
        
    }
    
}


void updateThreshold1(QRS_params *params, int * peaks, int arrayLength){
    
    params->NPKF = 0.125*peaks[arrayLength-1]+0.875*params->NPKF;
    params->THRESHOLD1 = params->NPKF + 0.25*(params->SPKF-params->NPKF);
    params->THRESHOLD2 = 0.5*params->THRESHOLD1;
    
    //printf("\nThreshold1: %f \nThreshold2: %f \nNPKF: %f\n\n", params->THRESHOLD1, params->THRESHOLD2, params->NPKF);
    
}


void calculateRR(QRS_params *params, int * peaks, int arrayLength){
   
    params->RR=params->lastPeak;
    
    updateRR1(params, peaks, arrayLength);
    
}


void updateRR1(QRS_params *params, int * peaks, int arrayLength){
    
    if(params->RR_LOW < params-> RR && params->RR < params->RR_HIGH){
        
        shiftArray(params->Rpeak, 33);
        params->Rpeak[33-1] = peaks[arrayLength-1];
        params->lastPeak=0;
        params->RpeakCounter++;
        
        printf("\nNew Rpeak found: %i\n", params->Rpeak[33-1]);
        
        params->SPKF = 0.125*peaks[arrayLength-1] + 0.875*params->SPKF;
        
        shiftArray(params->RecentRR_OK, 8);
        params->RecentRR_OK[8-1] = params->RR;
        //printf("\nRecentRR_OK UPPDATED!\n");
        
        shiftArray(params->RecentRR, 8);
        params->RecentRR[8-1] = params->RR;
        //printf("RecentRR UPPDATED!\n\n");
        
        params->RR_AVERAGE2 = findAverageRR(params->RecentRR_OK);
        params->RR_AVERAGE1 = findAverageRR(params->RecentRR);
        params->RR_LOW = 0.92 * params->RR_AVERAGE2;
        params->RR_HIGH = 1.16 * params->RR_AVERAGE2;
        params->RR_MISS = 1.66 * params->RR_AVERAGE2;
        params->THRESHOLD1 = params->NPKF + 0.25*(params->SPKF-params->NPKF);
        params->THRESHOLD2 = 0.5*params->THRESHOLD1;
        
        
    } else if(params->RR > params->RR_MISS){
        searchBackwards(params, peaks, arrayLength);
    
    }
    
    
}

void searchBackwards(QRS_params * params, int * peaks, int arrayLength){
    
    for(int i = arrayLength-1; peaks[i] != params->Rpeak[33-1]; i--){
         if(peaks[i] > params->THRESHOLD2){
            printf("\nFound peak2: %i\n", peaks[i]);
            //printf("Time since last Rpeak %i\n", params->lastPeak);
            //printf("Between %.1f and %.1f\n", params->RR_LOW, params->RR_HIGH);
            //printf("RR_MISS: %.1f\n", params->RR_MISS);
            
            int peak2 = peaks[i];
            
            updateRR2(params, peak2);
            break;
            
        }

    }
}

void updateRR2(QRS_params *params, int peak2){
    
    
    shiftArray(params->Rpeak, 33);
    params->Rpeak[33-1] = peak2;
    params->lastPeak=0;
    params->RpeakCounter++;
    
    params->SPKF = 0.25*peak2 + 0.75*params->SPKF;
    
    shiftArray(params->RecentRR, 8);
    params->RecentRR[8-1] = params->RR;
    
    params->RR_AVERAGE1 = findAverageRR(params->RecentRR);
    params->RR_LOW = 0.92 * params->RR_AVERAGE1;
    params->RR_HIGH = 1.16 * params->RR_AVERAGE1;
    params->RR_MISS = 1.66 * params->RR_AVERAGE1;
    params->THRESHOLD1 = params->NPKF + 0.25*(params->SPKF-params->NPKF);
    params->THRESHOLD2 = 0.5*params->THRESHOLD1;
    
    
}




double findAverageRR(int * array){
    
    double sum = 0;
    for(int i = 0; i < 8; i++){
        sum+=array[i];
    }
        
    return sum/8;
}



