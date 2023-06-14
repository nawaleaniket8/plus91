import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // test cases

        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            int[] weights = new int[N];

            for (int j = 0; j < N; j++) {
                weights[j] = scanner.nextInt();
            }

            int maxDifference = maximumWeightDifference(N, K, weights);
            System.out.println(maxDifference);
        }


        scanner.close();
    }

    // Function to calculate the maximum possible difference.
    public static int maximumWeightDifference(int N, int K, int[] weights) {
        Arrays.sort(weights); // Sort the weights in non-decreasing order

        int sonSum = 0;
        for (int i = 0; i < K; i++) {
            sonSum += weights[i];
        }

        int totalSum = 0;
        for (int i = 0; i < N; i++) {
            totalSum += weights[i];
        }

        int chefSum = 0;
        for (int i = N - K; i < N; i++) {
            chefSum += weights[i];
        }

        return Math.max(totalSum - sonSum, chefSum - sonSum);
    }
}
