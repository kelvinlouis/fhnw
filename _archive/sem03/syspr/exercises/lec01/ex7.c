#include <stdio.h>

short sum(short n);
short sumEfficient(short n);
short sumPointer(short n);

void main() {
  // printf("%d\n", sum(100));
  printf("%d\n", sumEfficient(100));
}

short sum(short n) {
  short sum = 0;

  for (; n >= 0; n--) {
    sum += n;
  }

  return sum;
}

short sumEfficient(short n) {
  return (n/2) * (n+1);
}