import java.util.Arrays;

public class Exercise3 {


    public static boolean unique1(int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = i + 1; j < data.length; j++) {
                if (data[i] == data[j]) {
                    return false;
                }
            }
        }
        return true;
    }


    public static boolean unique2(int[] data) {
        Arrays.sort(data);
        for (int i = 0; i < data.length - 1; i++) {
            if (data[i] == data[i + 1]) {
                return false;
            }
        }
        return true;
    }



    private static double timeInSeconds(Runnable task) {
        long start = System.nanoTime();
        task.run();
        long end = System.nanoTime();
        return (end - start) / 1_000_000_000.0;
    }


    private static int findMaxN(boolean useSlowVersion) {


        int n = 1000;
        while (true) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = i;
            }

            double t = timeInSeconds(() -> {
                if (useSlowVersion) {
                    unique1(arr);
                } else {
                    unique2(arr);
                }
            });

            System.out.printf("n = %-10d time = %.3f seconds%n", n, t);

            if (t > 60) {
                break;
            }

            if (n > 200_000) {
                break;
            }

            n *= 2;
        }


        int low = n / 2;
        int high = n;


        while (low < high - 1) {
            int mid = (low + high) / 2;

            int[] arr = new int[mid];
            for (int i = 0; i < mid; i++) {
                arr[i] = i;
            }

            double t = timeInSeconds(() -> {
                if (useSlowVersion) {
                    unique1(arr);
                } else {
                    unique2(arr);
                }
            });

            System.out.printf(" testing mid = %-10d time = %.3f seconds%n", mid, t);

            if (t <= 60) {
                low = mid; // mid still works
            } else {
                high = mid; // mid too slow
            }
        }

        return low;
    }


    public static void main(String[] args) {

        System.out.println("=== Testing unique1 (O(n^2)) ===");
        int max1 = findMaxN(true);
        System.out.println("Largest n for unique1 within 60 seconds: " + max1);

        System.out.println("\n=== Testing unique2 (O(n log n)) ===");
        int max2 = findMaxN(false);
        System.out.println("Largest n for unique2 within 60 seconds: " + max2);
    }
}
