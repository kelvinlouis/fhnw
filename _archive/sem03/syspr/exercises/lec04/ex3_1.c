#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/stat.h>
#include <sys/types.h>
#include <fcntl.h>

int mv(char source[], char dest[]);
int rm(char file[]);
int op(char file[], int flags);
void cpbuf(int sd, int dd, int bs);

int main(int argc, char const *argv[])
{
  if (argc == 1) {
    printf("Source and Destination missing\n");
    exit(EXIT_FAILURE);
  }

  if (argc == 2) {
    printf("Destination missing\n");
    exit(EXIT_FAILURE);
  }

  mv(argv[1], argv[2]);

  return 0;
}

int mv(char source[], char dest[])
{
  int sd;
  int dd;

  // Opening files
  sd = op(source, O_RDONLY);
  dd = op(dest, O_WRONLY | O_CREAT);
  
  // Copying content
  cpbuf(sd, dd, 150);
  close(sd);
  close(dd);

  // Deleting the source
  if (unlink(source) == -1) {
    printf("Couldn't delete source: %s\n", source);
    exit(EXIT_FAILURE);
  }

  return 0;
}

void cpbuf(int sd, int dd, int bs)
{
  char content[bs];

  while(read(sd, content, bs) != 0) {
    write(dd, content, bs);
  }
}

int op(char file[], int flags)
{
  int desc;

  desc = open(file, flags);

  if (desc == -1) {
    printf("File not found: %s\n", file);
    exit(EXIT_FAILURE);
  }

  return desc;
}