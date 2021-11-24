package Exercice3;

public class Fibonacci {
    public static int fibo(int n) throws IllegalArgumentException {
        if (n < 0) {
            throw new IllegalArgumentException();
        } else {
            int f_n_1 = 1;
            int f_n = 0;
            int tmp;
            for (int i=0; i<n; i++) {
                tmp = f_n;
                f_n = f_n + f_n_1;
                f_n_1 = tmp;
            }
            return f_n;
        }
    }
}
