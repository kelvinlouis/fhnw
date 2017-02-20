#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h>

void spawnChild()
{
  pid_t cpid;

  cpid = fork();

  if (cpid == 0) {
    char *const args[] = { "./ex3_child", NULL };
    execv(args[0], args);
  }
}

int main(int argc, char const *argv[])
{
  int pid = getpid();

  printf("parent: %s (pid: %d)\n", argv[0], pid);

  int i;

  for (i = 0; i < 3; i++) {
    spawnChild();
  }

  printf("parent executing...\n");


  printf("parent waiting...\n");
  for(i = 0; i < 3; i++) {
    int cid;

    cid = wait(NULL);
    printf("child done: %d\n", cid);
  }

  printf("children finished...\n");

  return 0;
}