// Schreiben Sie eine Funktion, welche eine Binärzahl in die 
// entsprechende Dezimalzahl umwandelt. Die Binärzahl soll 
// dabei wie folgt deklariert und initialisiert werden:
//
// int binNumber = 1011;
// static int toDecNumber (int binNumber) {
// lokale Variablen...
// Anweisungen...
// }

public class Assignment2 {
    public static void main(String[] args) {
        int binNumber = 1011;

        System.out.println(toDecNumber1(binNumber));
        System.out.println(toDecNumber2(binNumber));
        System.out.println(toDecNumber3(binNumber));
        System.out.println(toDecNumber4(binNumber));
    }

    // With using Math
    static int toDecNumber1(int number) {
        int decNumber = 0,
            x = 0;

        while (number > 0) {
            decNumber += (number % 10) * (int) Math.pow(2,x++);
            number /= 10;
        }

        return decNumber;
    }

    // Without using Math (left shift = 2^x)
    static int toDecNumber2(int binNumber) {
        int decimal = 0,
            x = 0;

        while (binNumber > 0) {
            decimal += (binNumber % 10) * 1 << x++;
            binNumber /= 10;
        }

        return decimal;
    }

    // Lazy String Conversion
    static int toDecNumber3(int binNumber) {
        return Integer.parseInt(Integer.toString(binNumber),2);
    }

    // Not using loops, but recursion and overloading instead.
    static int toDecNumber4(int binNumber) {
        return toDecNumber4(binNumber,0);
    }

    static int toDecNumber4(int binNumber, int x) {
        return binNumber > 0 ? ( (binNumber%10) * 1 << x++ ) + toDecNumber4(binNumber/10,x) : 0;
    }
}
