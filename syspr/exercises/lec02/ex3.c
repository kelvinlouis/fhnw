#include <stdio.h>

#define DEBUG 1

void fillArrayRandomly(int arr[], int len, int min, int end);
void printArr(int arr[], int len);
void insertionSort(int arr[], int len);
void reverseArr(int arr[], int len);
void moveArr(int arr[], int len, int moveBy);
int pseudo(int n, int min, int max);

void main() 
{
  int arr[5];
  int len = sizeof(arr)/sizeof(arr[0]);

  fillArrayRandomly(arr, len, 1, 100);

  if (DEBUG)
    printArr(arr, len);

  insertionSort(arr, len);

  if (DEBUG)
    printArr(arr, len);

  reverseArr(arr, len);

  if (DEBUG)
    printArr(arr, len);

  moveArr(arr, len, 3);

  if (DEBUG)
    printArr(arr, len);
}

void fillArrayRandomly(int arr[], int len, int min, int end) 
{
  int s = 0;
  for (; s < len; s++) {
    arr[s] = rand() % (end + 1 - min) + min;
    // arr[s] = pseudo(s, min, end);
  }
}

void insertionSort(int arr[], int len)
{
  int i = 1;

  for (; i < len; i++) {
    int j = i;

    // traverse back
    while (j > 0 && arr[j-1] > arr[j]) {
      int x = arr[j-1];
      
      // swap
      arr[j-1] = arr[j];
      arr[j] = x;
      
      j--;
    }
  }
}

void reverseArr(int arr[], int len)
{
  int l = 0;
  int r = len - 1;

  while (l < r) {
    int d = arr[r];

    // swap
    arr[r] = arr[l];
    arr[l] = d;

    l++;
    r = len - (l + 1);

  }
}

void moveArr(int arr[], int len, int moveBy)
{
  int val = arr[0];
  int nextPos = (0 + moveBy) % len;
  int nextVal;

  if (len == moveBy)
    return;

  while (nextPos != 0) {
    nextVal = arr[nextPos];
    arr[nextPos] = val;
    val = nextVal;
    nextPos = (nextPos + moveBy) % len;
  }

  arr[0] = nextVal;
}

void printArr(int arr[], int len)
{
  printf("\n");

  int i = 0;
  for ( ; i < len ; i++) {
    printf("arr[%d] = %d\n", i, arr[i]);
  }
}

int pseudo(int n, int min, int max)
{
  if (n == 0)
    return min;

  return (17 * pseudo(n-1, min, max)) % (max + 1 - min) + min;
}
