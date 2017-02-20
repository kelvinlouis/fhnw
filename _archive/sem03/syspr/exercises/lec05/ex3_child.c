#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h>

int main(int argc, char const *argv[])
{
  int pid = getpid();

  sleep(rand() % 10);
  printf("child: %s (pid: %d)\n", argv[0], pid);
  return 0;
}