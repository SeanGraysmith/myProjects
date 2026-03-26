// Copyright 2026 sgraysmith
// Various computation functions based on arrays.
#include"program3functions.h"


// Counts the number of times searchDigit appears in
// the searchArray.
int Count(const int searchArray[], int size, int searchDigit) {
  int count = 0;
  for (int i = 0; i < size; i++) {
    if (searchArray[i] == searchDigit) {
      count++;
    }
  }
  return count;
}

// Finds range between the largest and
// smallest values in the rangeArray
double Range(const double rangeArray[], int size) {
  double min = rangeArray[0];
  double max = rangeArray[0];

  // iterate through the array and keep track
  // of the max/min values
  for (int i = 1; i < size; i++) {
    if (rangeArray[i] < min) {  // min
      min = rangeArray[i];
    }

    if (rangeArray[i] > max) {  // max
      max = rangeArray[i];
    }
  }
  return max - min;
}

// takes array of char that holds a null-terminated character
// string. Replaces searchChar with replaceChar and returns the
// number of characters replaced.
int FindAndReplace(char charString[], char searchChar, char replaceChar) {
  int count = 0;
  for (int i = 0; charString[i] != '\0'; i++) {
    if (charString[i] == searchChar) {
      charString[i] = replaceChar;
      count++;
    }
  }
  return count;
}

// Takes array of characters holding null-terminated char string
// and a char to remove. Removes specified char and returns the
// number of chars removed
int Collapse(char charString[], char removeChar) {
  int count = 0;

  // holds the position where kept characters are placed
  int keepPosition = 0;

  // iterate to the null termination
  // at every position, if the character should be
  // replaced, advance count and leave keepPosition.
  // if it should be kept, place it at keepPosition,
  // and advance the keepPosition.
  for (int i = 0; charString[i] != '\0'; i++) {
    if (charString[i] == removeChar) {
      count++;
    } else {
      charString[keepPosition] = charString[i];
      keepPosition++;
    }
  }
  // terminate when we have kept chars we need to keep
  charString[keepPosition] = '\0';
  return count;
}

// finds the number of distinct characters
// up to the null termination in the charString
int Distinct(const char charString[]) {
  int count = 0;  // num of distinct chars

  for (int i = 0; charString[i] != '\0'; i++) {
    bool counted = false;
    for (int j = 0; j < i; j++) {  // checks previous chars
      if (charString[j] == charString[i]) {
        counted = true;
        break;
      }
    }
    if (!counted) {
      count++;
    }
  }
  return count;
}

// returns position of first occurence of mode
// when there are <= 2 modes. If there are > 2
// returns -1.
int Mode(const int modeArray[], int size) {
  int maxFreq = 0;
  int modeCount = 0;
  int modePosition = -1;

  // count frequency
  for (int i = 0; i < size; i++) {
    bool first = true;
    for (int j = 0; j < i; j++) {
      if (modeArray[j] == modeArray[i]) {
        first = false;
        break;
      }
    }
    // count frequency for this value
    if (!first) continue;
    int count = 0;
    for (int k = 0; k < size; k++) {
      if (modeArray[k] == modeArray[i]) {
        count++;
      }
    }

    // update max frequency
    if (count > maxFreq) {
      maxFreq = count;
      modeCount = 1;
      modePosition = i;
    } else if (count == maxFreq) {
      modeCount++;
    }
  }

  // -1 if more than 2 nodes, position otherwise.
  return (modeCount > 2) ? -1 : modePosition;
}

// takes two arrays of doubles, performs the provided
// operation and places the results in the first array
// returns true when done or false if invalid values
bool ArithmeticAssignment(double arrayOne[], const double arrayTwo[],
                          int size, char operation) {
  // determine the operation and complete it,
  // or return false if invalid
  switch (operation) {
    case '+':
      for (int i = 0; i < size; i++) {
        arrayOne[i] = arrayOne[i] + arrayTwo[i];
      }
      break;
    case '-':
      for (int i = 0; i < size; i++) {
        arrayOne[i] = arrayOne[i] - arrayTwo[i];
      }
      break;
    case '*':
      for (int i = 0; i < size; i++) {
        arrayOne[i] = arrayOne[i] * arrayTwo[i];
      }
      break;
    case '/':
      // first check for 0 values before operating
      for (int i = 0; i < size; i++) {
        if (arrayTwo[i] == 0.0) {
          return false;
        }
      }
      // if no zeroes are found, continue with operation
      for (int i = 0; i < size; i++) {
        arrayOne[i] = arrayOne[i] / arrayTwo[i];
      }
      break;
    default:  // if the operation isn't valid
      return false;
  }
  return true;
}
