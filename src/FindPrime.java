import java.util.ArrayList;
import java.util.List;

public class FindPrime {

    public static void main(String[] args) {
        FindPrime findPrime = new FindPrime();

        // Declare ArrayList
        ArrayList<Integer> arrayList = new ArrayList<>(
                List.of(3, 32, 5, 354, 139, 2345, 113));

        findPrime.findPrimeInArray(arrayList);
    }

    public boolean isPrime(int dividend, int divisor) {
        // Base case
        if (dividend <= 2) {
            return (dividend == 2) ? true : false;
        }
        // If dividend is divided into any number which is bigger than 1, then the dividend is not a prime number
        if (dividend % divisor == 0) {
            return false;
        }
        // If dividend is small enough which is smaller than square of divisor, also all below conditions are passed (therefore, it reaches to the below condition), then that means it's prime number
        if (divisor * divisor > dividend) {
            return true;
        }

        // if given dividend doesn't meet all required condition, recursion occurs
        return isPrime(dividend, divisor + 1);
    }

    public void findPrimeInArray(ArrayList<Integer> arrayList) {
        ArrayList primeList = new ArrayList<>();

        // If prime number is found in for-loop iteration, it is added as element of primeList
        for (int i = 0; i < arrayList.size(); i++) {
            if (isPrime(arrayList.get(i), 2) == true) {
                primeList.add(arrayList.get(i));
            }
        }
        for (Object prime : primeList) {
            System.out.print(prime + " ");
        }
    }
}
