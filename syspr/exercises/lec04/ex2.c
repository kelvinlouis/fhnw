#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/stat.h>
#include <sys/types.h>
#include <fcntl.h>

#define DEBUG 1

void cp(char source[], char dest[]);
void cpbuffer(int sd, int dd, int bs);
int fexists(char file[]);
int op(char file[], int flags);

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

  cp(argv[1], argv[2]);

  return 0;
}

void cp(char source[], char dest[])
{
  int sd;
  int dd;

  if (fexists(dest)) {
    printf("Abort: Destination already exists\n");
    exit(EXIT_FAILURE);
  }

  if (DEBUG) {
    printf("source: %s\n", source);
    printf("destination: %s\n", dest);
  }

  sd = op(source, O_RDONLY);
  dd = op(dest, O_WRONLY | O_CREAT);

  //cpbuffer(sd, dd, 1);
  //cpbuffer(sd, dd, 5);
  cpbuffer(sd, dd, 150);

  close(sd);
  close(dd);
}

int fexists(char file[])
{
  int d;

  d = open(file, O_RDONLY);

  if (d != -1) {
    close(d);
    return 1;
  }

  return 0;
}

void cpbuffer(int sd, int dd, int bs)
{
  char content[bs];
  int i;

  // init buffer (necessary?)
  for (i = 0; i < bs; i++)
    content[i] = '\0';

  // Reads one byte at a time
  while(read(sd, content, bs) != 0) {
    write(dd, &content, bs);
  }
}

int op(char file[], int flags)
{
  int fd;

  fd = open(file, flags);

  if (fd == -1) {
    printf("Couldn't open file %s\n", file);
    exit(EXIT_FAILURE);
  }

  if (DEBUG)
    printf("op/file descriptor: %d\n", fd);

  return fd;
}