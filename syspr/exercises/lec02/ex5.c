#include <stdio.h>
#include <string.h>

typedef short bool;
#define false 0
#define true 1

typedef struct Person {
  char firstName[25];
  char lastName[25];
  short age;
  bool married;
} Person;

int populatePersonArr(Person* p);
void printArr(Person* p, int len);
int createPerson(Person* p, int insertAt);

void main()
{
  struct Person arr[5];
  short len = sizeof(arr) / sizeof(arr[0]);
  int nrOfCreatedPersons;

  nrOfCreatedPersons = populatePersonArr(arr);
  printArr(arr, nrOfCreatedPersons);
  nrOfCreatedPersons = createPerson(arr, nrOfCreatedPersons);
  printArr(arr, nrOfCreatedPersons);
}

int populatePersonArr(Person* p)
{
  // Person 1
  struct Person p1 = { "Kelvin", "Louis", 27, false };
  struct Person p2 = { "Hasan", "Kara", 5, false };

  *p = p1;
  p++;
  *p = p2;

  return 2;
}

int createPerson(Person* p, int insertAt)
{
  struct Person person;

  char firstName[25];
  char lastName[25];
  short age;
  bool married = false;

  char enteredMarried;

  printf("Enter firstname: ");
  scanf("%s", firstName);

  printf("\nEnter lastname: ");
  scanf("%s", lastName);

  printf("\nEnter your age: ");
  scanf("%d", &age);
  // age = atoi(enteredAge);

  printf("\nAre you married (y/n): ");
  scanf(" %c", &enteredMarried);
  married = (enteredMarried == 'y' || enteredMarried == 'Y') ? true : false;

  p += insertAt;

  strcpy(person.firstName, firstName);
  strcpy(person.lastName, lastName);
  person.age = age;
  person.married = married;

  *p = person;

  return insertAt + 1;
}

void printArr(Person* p, int len)
{
  int i = 0;
  printf("\n");
  
  for( ; i < len; i++ ) {
    if (p->firstName)
    printf("%s %s: Age %d / Married: %s\n", 
      p->firstName,
      p->lastName,
      p->age,
      p->married == false ? "No" : "Yes" 
    );
    p++;
  }
  
  printf("\n");
}