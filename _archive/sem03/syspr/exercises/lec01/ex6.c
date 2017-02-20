#include <stdio.h>

void oddFor();
void oddWhile();
void oddDoWhile();
void oddEfficient();
void oddMsb();

char mod(char n);

void main() {
  // oddFor();
  // oddWhile();
  // oddDoWhile();
  // oddEfficient();
  oddMsb();
}

void oddFor() {
  char d = 1;

  for ( ; d <= 100; d++) {
    if (mod(d))
      printf("%d\n", d);
  }
}

void oddWhile() {
  char d = 1;

  while (d <= 100) {
    if (mod(d))
      printf("%d\n", d);
    
    d++;
  }
}

void oddDoWhile() {
  char d = 1;

  do {
    if (mod(d))
      printf("%d\n", d);
    d++;
  } while (d <= 100);
}

void oddEfficient() {
  char d = 1;

  for ( ; d < 100; d += 2) {
    printf("%d\n", d);
  }
}

void oddMsb() {
  char d = 1;

  for ( ; d < 100; d++) {
    if ( d & 1 == 1 )
      printf("%d\n", d);
  }
}

char mod(char n) {
  return n % 2 == 1;
}