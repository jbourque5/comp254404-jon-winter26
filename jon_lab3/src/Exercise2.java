import java.util.Scanner;

public class Exercise2 {
    public static boolean whatIsAPalidrome(String s) {
        if (s.length() <= 1) return true;
        if (s.charAt(0) != s.charAt(s.length() - 1)) return false;
        return whatIsAPalidrome(s.substring(1, s.length() - 1));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a word, please be mindful of capitals: ");
        String input = sc.nextLine(); System.out.println(whatIsAPalidrome(input) ? "Hello good Sir, this here would be a palindrome" : "Clearly you can't spell backwards.");
    }

}
