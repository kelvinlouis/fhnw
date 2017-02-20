#include <stdio.h>
#include <stdlib.h>

int main(int argc, char const *argv[])
{
  int i = atoi(argv[0]);
  printf("child process: %d \n", i);
  sleep(3);

  return 33;
}