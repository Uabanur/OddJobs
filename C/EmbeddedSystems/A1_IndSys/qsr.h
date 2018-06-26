#ifndef QSR_H
#define QSR_H

// Header file for QRS functionality 
// it is recommended to use the structure "QRS_parameters"
// to organize all variables and parameters

typedef struct QRS_params
{ // Structure for QRS parameters
    double SPKF;
    double NPKF;
    double THRESHOLD1;
    double THRESHOLD2;
    double RR_AVERAGE1;
    double RR_AVERAGE2;
    double RR_LOW;
    double RR_HIGH;
    double RR_MISS;
    int RR;
    int RpeakCounter;
    int lastPeak;
    int RecentRR[8];
    int RecentRR_OK[8];
    int Rpeak[33];
   
} QRS_params;

// Feel free to change and add methods
void peakDetection(QRS_params *params, int * peaks, int * filteredData, int arrayLength);

void updateThreshold1(QRS_params *params, int * peaks, int arrayLength);

void shiftArray(int * array, int arrayLength);

void calculateRR(QRS_params *params, int * peaks, int arrayLength);

void updateRR1(QRS_params *params, int * peaks, int arrayLength);

void searchBackwards(QRS_params * params, int * peaks, int arrayLength);

void updateRR2(QRS_params *params, int peak2);

double findAverageRR(int * array);


#endif // QSR_H
