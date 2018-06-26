#ifndef FILTERS_H

#define FILTERS_H



// Feel free to change return statement and arguments

int lowPassFilter(int ynMinus1, int ynMinus2, int xn, int xnMinus6, int xnMinus12);

int lowFilter(int * yArray, int * xArray, int arrayLength);


int highPassFilter(int ynMinus1, int xn, int xnMinus16, int xnMinus17, int xnMinus32);

int highFilter(int * yArray, int * xArray, int arrayLength);


int derivativeFilter(int xn, int xnMinus1, int xnMinus3, int xnMinus4);

int derivAndSquareFilter(int * xArray, int arrayLength);

int squareFilter(int xn);

int windowFilter(int * xn, int N, int arrayElements);



#endif // FILTERS_H

