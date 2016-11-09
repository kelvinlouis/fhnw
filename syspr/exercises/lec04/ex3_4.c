#include <sys/types.h>
#include <dirent.h>
#include <errno.h>
#include <string.h>
#include <stdlib.h>

int myls(const char *dname, int level);
int dotdir(char str[]);

int main(int argc, char const *argv[])
{
  myls(".", 0);
  printf("\n");
  return 0;
}

int myls(const char *dname, int level)
{
  DIR *pdir;
  struct dirent *dirent;
  char path[256];
  short i;

  pdir = opendir(dname);

  if (pdir == -1) {
    printf("Couldn't open dir\n");
    return;
  }

  while ((dirent = readdir(pdir)) != NULL) {
    if (level > 0 && dotdir(dirent->d_name) == 1)
      continue;

    printf("+ %s\n", dirent->d_name);

    for(i = 0; i < level; i++) {
      printf("\t");
    }

    if (dirent->d_type == DT_DIR && dotdir(dirent->d_name) == 0) {
      // Concat prev path with filename
      snprintf(path, sizeof(path)-1, "%s/%s", dname, dirent->d_name);

      printf("|------");
      myls(path, level + 1);
    }
  }

  closedir(pdir);
  return;
}

int dotdir(char str[])
{
  return str[0] == '.';
}