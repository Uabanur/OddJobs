#include "sensor.h"
#include "filters.h"
#include "qsr.h"
#include <stdio.h>
#include <stdlib.h>

//Dette er udgaven MED comments



void printAllArrays();
void printArray(int * array);
void printStructParams(QRS_params qsr_params);
void filterData();

const int arrayLength = 33, N = 30;

    //Initialize data arrays to zero.
int originalArray[arrayLength] = {0};
int afterLowPass[arrayLength] = {0};
int afterHighPass[arrayLength] = {0};
int afterDerivAndSquare[arrayLength] = {0};

    //int afterSquare[arrayLength] = {0}; //Not used, as it is integrated in derivative filter

int filteredData[arrayLength] = {0};
int peaks[arrayLength] = {0};
int counter = 1;


int main()
{
    
    QRS_params qsr_params = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, {0}, {0}, {0}};
   
    qsr_params.THRESHOLD1 = 4000;
    
    
    FILE* file = openfile("/Users/Roar/Documents/workspaceX/A1_IndSys/ECG.txt"); // Pointer to a file object
    

    
    
    
    /////// While fscanf haven't got an EOF (end of file) keep iterating (until end of file)
        /////// while checking if the fscanf is an EOF it also adds the new value to our originalArray, meaning that the original
        /////// is not shiftet before the end of the loop. If the original array was shiftet in the begining of the loop the two
        /////// two first elements would always be equal and therefore messing up the filters.
    
    
    while(fscanf(file, " %i", &originalArray[arrayLength - 1]) != EOF && counter <= 10000){

        //printf("Iteration #%i\n", counter); //Prints current iteration
        counter++;
        qsr_params.lastPeak++;
        //printStructParams(qsr_params);
        //printf("\n");
        
        filterData();
        
        //printAllArrays();
        
        
        peakDetection(&qsr_params, peaks, filteredData, arrayLength);
        
        
        shiftArray(originalArray, arrayLength); //Shift array, so it's ready for the new data from the while-loop-check.
    }
     
    
    printStructParams(qsr_params);
    printf("\nPeaks array: \n\n\t");
    printArray(peaks);
    printf("\n\n\n");
    
        return 0;
    
}



void filterData(){
    
    shiftArray(afterLowPass, arrayLength); //Shifts array
    
    // Calculate new datapoint from LowPass filter
    
    //Pass by values
    //afterLowPass[arrayLength - 1] = lowPassFilter(afterLowPass[arrayLength - 2], afterLowPass[arrayLength - 3], originalArray[arrayLength - 1], originalArray[arrayLength - 7], originalArray[arrayLength - 13]);
    
    //Pass by reference
    afterLowPass[arrayLength-1] = lowFilter(afterLowPass, originalArray, arrayLength);
    
    
    shiftArray(afterHighPass, arrayLength);
    
    // Calculate new datapoint from HighPass filter
    
    //Pass by values
    //afterHighPass[arrayLength - 1] = highPassFilter(afterHighPass[arrayLength - 2],afterLowPass[arrayLength - 1], afterLowPass[arrayLength - 17], afterLowPass[arrayLength - 18], afterLowPass[arrayLength - 33]);
    
    //Pass by reference
    afterHighPass[arrayLength - 1] = highFilter(afterHighPass, afterLowPass, arrayLength);
    
    
    shiftArray(afterDerivAndSquare, arrayLength);
    
    // Calculate new datapoint from Derivative filter !and Square filter! NEW
    
    //Pass by value
    //afterDerivative[arrayLength - 1] = derivativeFilter(afterHighPass[arrayLength - 1], afterHighPass[arrayLength - 2],
    //                                                   afterHighPass[arrayLength - 4], afterHighPass[arrayLength - 5]);
    
    //Pass by reference
    afterDerivAndSquare[arrayLength - 1] = derivAndSquareFilter(afterHighPass, arrayLength);
    //Since the square filter is too redundant for its own function and data array, it is merged in the Derirative filter
    
    
    
    //Deleted section as it is merged in the Derirative filter!!!
    // shiftArray(afterSquare);
    
    // Calculate the new datapoint from Square filter
    
    //afterSquare[arrayLength - 1] = squareFilter(afterDerivative[arrayLength - 1]);
    
    
    
    shiftArray(filteredData, arrayLength);
    
    // Calculate the new datapoint from the Moving Window Integration filter
    //Pass by reference
    filteredData[arrayLength - 1] = windowFilter(afterDerivAndSquare, N, arrayLength - 1);
    

    
}

void printAllArrays(){
    
    /////// print all data
    
    printArray(originalArray);
    printArray(afterLowPass);
    printArray(afterHighPass);
    printArray(afterDerivAndSquare);
    //printArray(afterSquare);
    printArray(filteredData);
    printArray(peaks);
    printf("\n");
    
}

void printArray(int * array){
    
    for(int i = 0; i < arrayLength; i++){
        printf("%i ", array[i]);
    }
    
    printf("\n");
    
}

void printStructParams(QRS_params qsr_params){
    //Printing out QRS_params struct.
    printf("\n\nStruct parameters: \n");
    printf("\n\tNPKF: %f \n\tSPKF: %f \n\tRR_AVERAGE1: %f \n\tRR_AVERAGE2: %f \n\tRR_HIGH: %f \n\tRR_LOW: %f \n\tRR_MISS: %f \n\tTHRESHOLD1: %f \n\tTHRESHOLD2: %f\n\tRR: %i\n\tRpeakCounter: %i\n",
           qsr_params.NPKF, qsr_params.SPKF, qsr_params.RR_AVERAGE1, qsr_params.RR_AVERAGE2, qsr_params.RR_HIGH, qsr_params.RR_LOW, qsr_params.RR_MISS, qsr_params.THRESHOLD1, qsr_params.THRESHOLD2, qsr_params.RR, qsr_params.RpeakCounter);
    printf("\nRecentRR:\n\n\t");
    for(int i = 0; i < 8; i++){
        printf("%i ", qsr_params.RecentRR[i]);
    }
    
    printf("\n");
    
    printf("\nRecentRR_OK:\n\n\t");
    for(int i = 0; i < 8; i++){
        printf("%i ", qsr_params.RecentRR_OK[i]);
    }
    
    printf("\n");
    
    printf("\nRpeak:\n\n\t");
    for(int i = 0; i < 33; i++){
        printf("%i ", qsr_params.Rpeak[i]);
    }
    
    printf("\n");
    
}

void shiftArray(int * array, int arrayLength){
    
    for(int i = 0; i < arrayLength - 1;i++ )
        array[i] = array[i+1];
    
}
