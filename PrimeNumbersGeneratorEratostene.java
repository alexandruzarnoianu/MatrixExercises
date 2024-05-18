import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimeNumbersGeneratorEratostene {

    private static ArrayList<Integer> eratostene(int limit) {
        int[] array = new int[limit + 1];
        for (int i = 2; i < array.length; i++) {
            array[i] = 1;
        }
        ArrayList<Integer> primeNumbers = new ArrayList<>();
        for (int i = 2; i < array.length; i++) {
            if (array[i] != 0) {
                primeNumbers.add(i);
                int nextIndex = i * i;
                for (int j = nextIndex; j < array.length; j += i) {
                    array[j] = 0;
                }
            }
        }
        return primeNumbers;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int limit = scanner.nextInt();
        List<Integer> primes = eratostene(limit);
        System.out.println(primes);
    }
}