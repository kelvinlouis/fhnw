#include <stdio.h>
#define MAX(A, B) ((A) > (B) ? (A) : (B))

int max(int a, int b);

void main(int argc, char const *argv[])
{
  printf("%d\n", max(1,2)); 
  printf("%d\n", MAX(6,1000)) ;
}

int max(int a, int b) {
  return a > b ? a : b;
}