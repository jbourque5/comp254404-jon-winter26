
public class Main {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        int[] arr2 = {1, 2, 3, 4, 5};

        System.out.println("example1: " + Exercise1.example1(arr));
        System.out.println("example2: " + Exercise1.example2(arr));
        System.out.println("example3: " + Exercise1.example3(arr));
        System.out.println("example4: " + Exercise1.example4(arr));
        System.out.println("example5: " + Exercise1.example5(arr, arr2));

        System.out.println("\n=== Exercise 2 ===");
        Exercise2.main(null);

        System.out.println("\n=== Exercise 3 ===");
        Exercise3.main(null);

    }
}