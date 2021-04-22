public class MaximumInt {
    int p = 1;
    int n = -1;

    public void run () {
        while (p > 0) {
            p = p + p;
            System.out.println(p - 1);
            }
        
        while (n < 0) {
            n = n + n;
            System.out.println(n);
        }

    }

    public static void main(final String[] a) {
        (new MaximumInt()).run();
    } 
}
