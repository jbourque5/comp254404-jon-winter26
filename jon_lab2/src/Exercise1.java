public class Exercise1 {
    /**
     *  Big-O: O(n)
     * Explanation: A single loop runs from 0 to n−1, doing constant work each time.
     * Therefore the running time grows linearly with n.
     */
    public static int example1(int[] arr) {
        int n = arr.length, total = 0;
        for (int j = 0; j < n; j++)
            total += arr[j];
        return total;
    }

    /**
     * Big-O: 0(n)
     * Explanation: Loop runs n/2 times because j increases by 2.
     * Constants are ignored in Big-O, so the complexity is still linear
     */
    public static int example2(int[] arr) {
        int n = arr.length, total = 0;
        for (int j = 0; j < n; j += 2)
            total += arr[j];
        return total;
    }


    /**
     * Big-O: O(n^2)
     * Explanation: Nested loops. Outer loop runs n times.
     * Inner loop runs j+1 times. Total work = 1 + 2 + ... + n = n(n+1)/2.
     * This simplifies to O(n^2).
     */
    public static int example3(int[] arr) {
        int n = arr.length, total = 0;
        for (int j = 0; j < n; j++)
            for (int k = 0; k<= j; k++)
                total += arr[j];
        return total;
    }


    /**
     * Big-O: O(n)
     * Explanation: Only one loop from 0 to n−1, and each iteration does constant work.
     * Therefore the running time is linear.
     */
    public static int example4(int[] arr) {
        int n = arr.length, prefix = 0, total = 0;
        for (int j = 0 ; j < n; j++) {
            prefix += arr[j];
            total += prefix;
        }
        return total;
    }

    /**
     * Big-O: O(n^3)
     * Explanation: Outer loop runs n times.
     * Inside it, there is a nested pair of loops that run in O(n^2).
     * Total time = n * n^2 = O(n^3).
     */
    public static int example5(int[] first, int[] second) {
        int n = first.length, count = 0;
        for (int i = 0; i < n; i++) {
            int total = 0;
            for (int j = 0; j < n; j++)
                for (int k = 0; k<= j; k++)
                    total += first[k];
            if (second[i] == total) count++;
        }
        return count;
    }
}


