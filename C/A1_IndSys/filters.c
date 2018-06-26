#include "filters.h"



int lowPassFilter(int ynMinus1, int ynMinus2, int xn, int xnMinus6, int xnMinus12)
{

return 2*ynMinus1 - ynMinus2 + (xn - 2*xnMinus6 + xnMinus12)/32;

}

int lowFilter(int * yArray, int * xArray, int arrayLength){
    
    return 2*yArray[arrayLength-2] - yArray[arrayLength-3] + (xArray[arrayLength-1] - 2*xArray[arrayLength-7] + xArray[arrayLength-13])/32;
}


int highPassFilter(int ynMinus1, int xn, int xnMinus16, int xnMinus17, int xnMinus32){

return ynMinus1 - xn/32 + xnMinus16 - xnMinus17 + xnMinus32/32;

}

int highFilter(int * yArray, int * xArray, int arrayLength){
    
    return yArray[arrayLength-2] - xArray[arrayLength-1]/32 + xArray[arrayLength-17] - xArray[arrayLength-18] + xArray[arrayLength - 33]/32;
}


int derivativeFilter(int xn, int xnMinus1, int xnMinus3, int xnMinus4){

    
return (2*xn + xnMinus1 - xnMinus3-2*xnMinus4)/8;

}

int derivAndSquareFilter(int * xArray, int arrayLength){
    
    int result = (2*xArray[arrayLength-1] + xArray[arrayLength-2] - xArray[arrayLength-4] - 2*xArray[arrayLength-5])/8;
    
    return result * result;
}

int squareFilter(int xn){

return xn*xn;

}

int windowFilter(int * xn, int N, int arrayElements){
    int windowSum = 0;
    for(int i = 0; i < N; i++){
        windowSum+=xn[arrayElements-i];
    }

return windowSum/N;
}


