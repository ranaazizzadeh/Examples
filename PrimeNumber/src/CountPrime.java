import java.util.Random;
import java.util.Scanner;

public class CountPrime {

    public static void main(String[] args) {

        System.out.println("please enter the number to see the number of prime numbers less than it");
        Scanner scanner = new Scanner(System.in);
        Integer n = scanner.nextInt();
        System.out.println("number of prime numbers less than " + n+ " is: " + countPrimes(n));
    }

    public static int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i < n; i++) {
            if (!isPrime[i]) continue;
            for (int j = i * i; j < n; j += i) {
                isPrime[j] = false;
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) count++;
        }
        return count;
    }
}

