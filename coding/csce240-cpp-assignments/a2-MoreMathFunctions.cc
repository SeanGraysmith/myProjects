// Copyright 2026 sgraysmith
// Various math functions
#include"program2functions.h"

// finds the sum of all digits in the
// absolute value of an int
int SumDigits(int number) {
  // where the sum will be stored
  int sum = 0;

  // switches sign if number is negative
  int temp = number;
  if (temp < 0) temp = -temp;

  // handle 0 case
  if (temp == 0) return 0;

  // isolate each digit and add it to the sum
  while (temp > 0) {
    sum += temp % 10;
    temp /= 10;
  }
  return sum;
}

// determines if the absolute value
// of an int is a palindrome
bool IsPalindrome(int number) {
  // switches sign if number is negative
  int temp = number;
  if (temp < 0) temp = -temp;

  // handle single digits (always palindromes)
  if (temp < 10) return true;

  const int originalOrder = temp;

  // will contain the reversed version of the number
  int newOrder = 0;

  // isolates digits and adds them to newOrder in reverse order
  while (temp > 0) {
    newOrder = newOrder * 10 + temp % 10;
    temp /= 10;
  }
  return newOrder == originalOrder;
}

// counts the amount of times a specified
// digit is in the absolute value of an int
int CountDigitMatch(int numberToSearch, int numberToCount) {
  // validating numberToCount is within parameters
  if (numberToCount < 0 || numberToCount > 9) return -1;

  // switching sign if needed
  int temp = numberToSearch;
  if (temp < 0) temp = -temp;

  // handle 0 case
  // returns 1 if numberToCount is 0, and 0 if not.
  if (temp == 0) return (numberToCount == 0) ? 1 : 0;

  // counts by:
  // isolating each digit and determining if it is
  // equal to numberToCount
  int count = 0;
  while (temp > 0) {
    if (temp % 10 == numberToCount) count++;
    temp /= 10;
  }
  return count;
}

// determines if two ints are
// made of the same digits
bool SameDigits(int number1, int number2) {
  // reversing signs if needed
  int num1 = number1;
  int num2 = number2;
  if (num1 < 0) num1 = -num1;
  if (num2 < 0) num2 = -num2;

  // for all digits 0-9, count the
  // number of times the digit occurs
  // check if they match
  for (int digit = 0; digit <= 9; digit++) {
    int count1 = 0;
    int count2 = 0;

    int temp1 = num1;
    int temp2 = num2;

    // handle 0 case
    if (temp1 == 0 && digit == 0) count1++;
    if (temp2 == 0 && digit == 0) count2++;

    // count occurences in each number
    while (temp1 > 0) {
      if (temp1 % 10 == digit) count1++;
      temp1 /= 10;
    }
    while (temp2 > 0) {
      if (temp2 % 10 == digit) count2++;
      temp2 /= 10;
    }
    if (count1 != count2) return false;
  }
  // only returns true if all digits pass count check
  return true;
}

// converts a minutes in double form to
// minutes and seconds in int form
// passed argument ints are assigned
void DoubleMinToIntMinSec(double realMin, int& intMin, int& intSec) {
  // negative minutes are not real
  if (realMin < 0) {
    intMin = 0;
    intSec = 0;
    return;
  }

  // static casting to int for min
  intMin = static_cast<int>(realMin);

  // using static cast of min
  // to calculate seconds then casting again
  // the + 0.5 rounds the number to the nearest second
  intSec = static_cast<int>((realMin - intMin) * 60 + 0.5);
}

// determines if a given number is perfect
bool IsPerfect(int number) {
  // handle 0 and negative case
  if (number <= 0) return false;

  int sum = 0;

  // find divisors and adds them to sum
  for (int divisor = 1; divisor < number; divisor++) {
    if (number % divisor == 0) sum += divisor;
  }
  return sum == number;
}

// determines whether the third argument is a sum,difference
// product, or quotient of the first two arguments
// returns a char that represents each case
char WhichOp(int number1, int number2, int toCheck) {
  // order means that + is prioritized etc
  if (number1 + number2 == toCheck) return '+';

  // subtraction is not commutativ so
  // we need to check for both directions
  if (number1 - number2 == toCheck || number2 - number1 == toCheck) return '-';

  if (number1 * number2 == toCheck) return '*';

  // as long as the divisor is not 0,
  // check each quotient case
  if ((number2 != 0 && number1 / number2 == toCheck) ||
      (number1 != 0 && number2 / number1 == toCheck))
        return '/';
  return '!';
}
