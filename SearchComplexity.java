import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SearchComplexity {

    // Add Iteration Count to Linear Search:
    // Linear Search Method
    public static int linearSearch(int[] array, int target) {
        int iterations = 0; // Initialize iteration count
        for (int i = 0; i < array.length; i++) {
            iterations++; // Increment iteration count
            if (array[i] == target) {
                System.out.println("Linear search iterations: " + iterations);
                return i;  // Returns index of found element
            }
        }
        System.out.println("Linear search iterations: " + iterations);
        return -1;  // Target not found
    }

    // Implement a Recursive Version of Binary Search
    // Recursive Binary Search Method
    public static int recursiveBinarySearch(int[] array, int target, int left, int right) {
        if (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                return mid; // Target found
            }

            if (array[mid] < target) {
                return recursiveBinarySearch(array, target, mid + 1, right); // Search in the right half
            } else {
                return recursiveBinarySearch(array, target, left, mid - 1); // Search in the left half
            }
        }

        return -1; // Target not found
    }

    // Error Handling
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter number of elements in array:");
            int n = scanner.nextInt();
            if (n <= 0) {
                System.out.println("Array size must be greater than 0.");
                return;
            }
            int[] array = new int[n];

            System.out.println("Enter elements:");
            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextInt();
            }

            System.out.println("Enter target number to search:");
            int target = scanner.nextInt();

            // Performance Comparison
            // Linear Search
            long startTime = System.nanoTime();
            int linearResult = linearSearch(array, target);
            long endTime = System.nanoTime();
            double linearTime = (endTime - startTime) / 1e6; // Convert nanoseconds to milliseconds
            System.out.println((linearResult == -1) ? "Target not found by linear search." :
                    "Target found by linear search at index: " + linearResult);
            System.out.println("Linear search execution time: " + linearTime + " milliseconds");

            // Binary Search (Array must be sorted)
            Arrays.sort(array);
            startTime = System.nanoTime();
            int binaryResult = binarySearch(array, target);
            endTime = System.nanoTime();
            double binaryTime = (endTime - startTime) / 1e6; // Convert nanoseconds to milliseconds
            System.out.println((binaryResult == -1) ? "Target not found by binary search." :
                    "Target found by binary search at index: " + binaryResult);
            System.out.println("Binary search execution time: " + binaryTime + " milliseconds");

            // Recursive Binary Search
            startTime = System.nanoTime();
            int recursiveBinaryResult = recursiveBinarySearch(array, target, 0, array.length - 1);
            endTime = System.nanoTime();
            double recursiveBinaryTime = (endTime - startTime) / 1e6; // Convert nanoseconds to milliseconds
            System.out.println((recursiveBinaryResult == -1) ? "Target not found by recursive binary search." :
                    "Target found by recursive binary search at index: " + recursiveBinaryResult);
            System.out.println("Recursive binary search execution time: " + recursiveBinaryTime + " milliseconds");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter integers only.");
        } finally {
            scanner.close();
        }
    }

    // Binary Search Method
    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        int iterations = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            iterations++;

            if (array[mid] == target) {
                System.out.println("Binary search iterations: " + iterations);
                return mid;
            }

            if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println("Binary search iterations: " + iterations);
        return -1;  // Target not found
    }
}
