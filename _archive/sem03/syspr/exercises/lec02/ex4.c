#include <stdio.h>

void str2Upper(char* p);
int strLen(char* p);
void initStr(char arr[], int len, char symbols[]);

void main()
{
  char str[] = "my nAmE IS KelvIn 123!";
  char emptyStr[4];
  int len = sizeof(emptyStr) / sizeof(emptyStr[0]);

  printf("%s\n", str);
  str2Upper(str);
  printf("%s\n", str);

  printf("strlen(str) = %d\n", strLen(str));

  initStr(emptyStr, len, "AB!");
  printf("%s\n", emptyStr);
}

void str2Upper(char* p)
{
  while(*p != '\0') {
    char c = *p;

    if (c > 97 && c < 123) {
      *p = c - 32;
    }

    p++;
  }
}

int strLen(char* p)
{
  int c = 0;

  for (; *p  != '\0'; c++)
    p++;

  return c;
}

void initStr(char arr[], int len, char symbols[])
{
  int i = 0;
  int j = 0;

  while(i < len) {
    if (symbols[j] == '\0')
      j = 0;

    arr[i++] = symbols[j++];
  }
  arr[i] = '\0';
}