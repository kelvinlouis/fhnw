#include <stdio.h>

void printASCII();

void main() {
	printASCII();
}

void printASCIIHeader() {
	short s;
	
	for (s=1;s<=2;s++) {
		printf("Dec\tHex\tOct\tChar\t|\t");
	}

	printf("\n---------------------------------------------------------------------------\n");
}

void printASCII() {
	
	printASCIIHeader();	

	char s;

	for (s=33; s <= 64; s++) {
		char so = s + 32;

		printf("%d\t%x\t%o\t%c\t|\t", s, s, s, s);
		printf("%d\t%x\t%o\t%c\n", so, so, so, so);
	}
}
