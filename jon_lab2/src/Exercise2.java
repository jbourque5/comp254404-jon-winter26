public class Exercise2 {

    public static double[] prefixAverage1(double[] x) {
        int n = x.length;
        double[] a = new double[n];
        for (int i = 0; i < n; i++) {
            double total = 0;
            for (int j = 0; j <= i; j++)
                total += x[j];
            a[i] = total / (i + 1);
        }
        return a;
    }


    public static double[] prefixAverage2(double[] x) {
        int n = x.length; double[] a = new double[n];
        double total = 0;
        for (int i = 0; i < n; i++) {
            total += x[i];
            a[i] = total / (i + 1);
        }
        return a;
    }


    public static void main(String[] args) {
        int[] sizes = {1000, 2000, 4000, 8000, 16000, 32000};

        System.out.printf("%-10s %-20s %-20s%n", "n", "prefixAverage1 (ms)", "prefixAverage2 (ms)");
        System.out.println("---------------------------------------------------------------");

        for (int n : sizes) {

            double[] arr = new double[n];
            for (int i = 0; i < n; i++)
                arr[i] = Math.random();

            long start1 = System.nanoTime();
            prefixAverage1(arr);
            long end1 = System.nanoTime();
            double time1 = (end1 - start1) / 1e6;

            long start2 = System.nanoTime();
            prefixAverage2(arr);
            long end2 = System.nanoTime();
            double time2 = (end2 - start2) / 1e6;

            System.out.printf("%-10d %-20.3f %-20.3f%n", n, time1, time2);
        }
    }

}
