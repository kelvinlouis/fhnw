#include <stdio.h>
#include <sys/stat.h>
#include <sys/types.h>

int main(int argc, char const *argv[])
{
  if (argc == 1) {
    printf("Name of directory missing\n");
    return -1;
  }

  if (mkdir(argv[1], 0777) == -1) {
    printf("Couldn't create directory\n");
    return -1;
  }

  getchar();

  if (rmdir(argv[1]) == -1) {
    printf("Couldn't delete directory\n");
    return -1;
  }

  return 0;
}