#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h>

int main(int argc, char const *argv[])
{
  pid_t cpid;

  cpid = fork();

  if (cpid == -1) {
    printf("fork() didn't work\n");
  } else if (cpid == 0) {
    char *args[] = { "./sleepy", "2", NULL };
    execv(args[0], args);
  }

  printf("parent executing\n");

  int status;

  printf("parent waiting on child process\n");
  wait(&status);
  printf("child finished: %d\n", WEXITSTATUS(status));
  return 0;
}