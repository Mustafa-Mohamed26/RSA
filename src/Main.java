import java.math.BigInteger;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

// hello
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter TWO distinct upper limits for the tow primes p , q: ");
        System.out.print("Upper limit for p: ");
        int x = sc.nextInt();
        System.out.print("Upper limit for q: ");
        int y = sc.nextInt();

        int p = findClosestPrime(x);
        System.out.println("p= " + p);
        int q = findClosestPrime(y);
        System.out.println("q= " + q);

        int n = p * q;
        System.out.println("n= " + n);
        int m = (p - 1) * (q - 1);
        System.out.println("m= " + m);

        int e;
        for (e = 2; e < m; e++) {
            if (gcd(e, m) == 1) {
                break;
            }
        }
        System.out.println("e= " + e);

        int i1 = 0;
        int d = 0;
        for (int i = 0; i <= m; i++) {
            i1 = (m * i + 1);
            if (i1 % e == 0) {
                d = i1 / e;
                break;
            }
        }
        System.out.println("d= " + d);

        System.out.print("Enter original Message: ");
        sc.nextLine();
        String message = sc.nextLine();

        System.out.print("Cipher Message: ");
        char[] array = new char[message.length()];
        int[] intArray = new int[array.length];
        String line1 = "";
        for (int i = 0; i < message.length(); i++) {
            array[i] = message.charAt(i);
            int z = (int) (Math.pow(array[i], e) % n);
            line1 += (char) z;

            intArray[i] = z;
        }
        System.out.print(line1);

        System.out.println();

        System.out.println(" (the Decrypted Message will take a few seconds, please wait) ");
        System.out.print("Decrypted Message: ");
        String line2 = "";
        for (int i = 0; i < intArray.length; i++) {
            int c = intArray[i];
            BigInteger B1 = new BigInteger(String.valueOf(c));
            BigInteger B2 = new BigInteger(String.valueOf(n));
            BigInteger Decrypt = (B1.pow(d)).mod(B2);
            int l = Decrypt.intValue();
            line2 += (char) l;

        }
        System.out.print(line2);

    }

    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int findClosestPrime(int n) {
        if (isPrime(n)) {
            return n;
        }
        int smaller = n - 1;
        int larger = n + 1;
        while (true) {
            if (isPrime(smaller)) {
                return smaller;
            } else if (isPrime(larger)) {
                return larger;
            }
            smaller--;
            larger++;
        }
    }

    public static int gcd(int e, int m) {
        if (e == 0) return m;
        else return gcd(m % e, e);
    }
}