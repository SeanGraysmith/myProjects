// Copyright 2026 sgraysmith
#include<iostream>
using std::cin;
using std::cout;
using std::endl;

// Determine if a factor input is a prime number
bool IsPrime(int n) {
  if (n <= 1)
    return false;
  if (n <= 3)
    return true;

  if (n % 2 == 0 || n % 3 == 0)
    return false;

  for (int i = 5; i * i <= n; i += 6) {  // loops through all values up to
                                       // sqrt(n) increments by 6
                                       // because all prime numbers
                                       // greater than 3 follow
                                       // the pattern 6k +- 1
    if (n % i == 0 || n % (i + 2) == 0)  // checks 6k - 1 then checks 6k + 1
      return false;
  }
  return true;
}


// The variables are passed into the function using &
// This function multiplies the product stream by
// base^exponent and will set valid to
// False if nonZeroInt is exceeded.
void MultiplyThroughExponent(int base,
                             int exponent,
                             int& streamProduct,
                             bool& validFactor,
                             int nonZeroInt) {
  for (int i = 0; i < exponent; i++) {
    streamProduct *= base;
    if ( (streamProduct > 0 &&
        streamProduct > nonZeroInt) ||
       (streamProduct < 0 &&
       streamProduct < nonZeroInt) )
      validFactor = false;
  }
}

void OutputFactors(int nonZeroInt) {
  int numb = nonZeroInt;
  int sign = 1;

  // sets sign to negative if numb is negative, reverses sign of numb
  if (numb < 0) {
    sign = -1;
    numb = -numb;
  }

  // start output stream for factors
  cout << nonZeroInt << " = " << sign;

  // next factor out any 2s
  int count = 0;
  while (numb % 2 == 0) {
    count++;
    numb /= 2;
  }
  // output
  if (count > 0) {
    cout << " * 2^" << count;
  }

  // find odd factors 3+, up to sqaure root (numb)
  for (int i = 3; i*i <= numb; i+=2) {
    count = 0;
    while (numb % i == 0) {
      count++;
      numb/=i;
    }
    if (count > 0) {
      cout << " * " << i << "^" << count;
    }
  }

  // now if numb is > 1, it is a prime factor
  if (numb > 1) {
    cout << " * " << numb << "^1";
  }
  cout << endl;
}

int main() {
  int nonZeroInt, sign, base, exponent;
  char equals, asterisk, expSymbol, programStopSymbol;

  cin >> nonZeroInt >> equals >>
  sign >> asterisk >> base >> expSymbol >>
  exponent;
  // compound if to check if input matches contraints
  if (nonZeroInt == 0 ||
     equals != '=' ||
     (sign != -1 && sign != 1) ||
     asterisk != '*' ||
     expSymbol != '^') {
    cout << "Invalid input format." << endl;
    return 0;
  }

  int streamProduct = sign;  // this will hold the total product
                             // of the factors as the program runs

  bool validFactor = true;

  if (!IsPrime(base)) {
    cout << "Invalid input format." << endl;
    return 0;
  }

  MultiplyThroughExponent(base, exponent,
                          streamProduct, validFactor,
                          nonZeroInt);

  // read the rest of the factors and compute if input is valid
  while (cin >> programStopSymbol) {
    if (programStopSymbol == '?')
      break;
    if (programStopSymbol != '*')
      validFactor = false;

    cin >> base >> expSymbol >> exponent;

    if (expSymbol != '^')  // checking input
      validFactor = false;

    if (!IsPrime(base)) {
      cout << "Invalid input format." << endl;
      return 0;
    }

    MultiplyThroughExponent(base, exponent,
                            streamProduct,
                            validFactor,
                            nonZeroInt);
  }

  if (validFactor && streamProduct == nonZeroInt) {
    cout << "Correct!" << endl;
  } else {
    cout << "Incorrect. ";
    OutputFactors(nonZeroInt);
  }
  return 0;
}
