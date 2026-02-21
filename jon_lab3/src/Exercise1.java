public class Exercise1 {

    public static int linearSum(int m, int n) {
        if (n == 0)
            return 0;
        else
            return m + linearSum(m, n-1);
    }

    public static void main(String[] args){
        System.out.println(linearSum(11, 3));
    }

}
