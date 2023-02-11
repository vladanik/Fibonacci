import java.util.Scanner;
import java.lang.Math;

public class Fibonacci {

    static Scanner scan = new Scanner(System.in);
    static long start, end, time;

    public static void main(String[] args) {
        int k = scan.nextInt();
        if (k < 0) {
            System.out.println("Dlaczego ujemna?!");
        } else if (k > 92) {
            System.out.println("Liczba wychodzi poza zakres long!");
        } else {
            System.out.println("Fib(" + k + "):\n");
            start = System.currentTimeMillis();
            System.out.println("Iter: " + wypiszIteracyjnie(k));
            end = System.currentTimeMillis();
            time = end - start;
            System.out.println("Czas: " + time + "ms\n");

            start = System.currentTimeMillis();
            System.out.println("Rec: " + wypiszRekurencyjnie(k));
            end = System.currentTimeMillis();
            time = end - start;
            System.out.println("Czas: " + time + "ms\n");

            start = System.currentTimeMillis();
            System.out.println("Binet: " + wypiszBinet(k));
            end = System.currentTimeMillis();
            time = end - start;
            System.out.println("Czas: " + time + "ms\n");
        }

        long l = scan.nextLong();
        if (l < 0) {
            System.out.println("Dlaczego ujemna?!");
        } else if (l > 9223372036854775807L) {
            System.out.println("Liczba wychodzi poza zakres long!");
        } else {
            leqFibo(l);
        }

        //rozklad(0);
    }

    public static long wypiszIteracyjnie(int k) {
        if (k == 0) {
            return 0;
        }
        if (k == 1 || k == 2) {
            return 1;
        }

        long poprzednia = -1;
        long liczba = 1;

        for (int i = 0; i <= k; i++) {
            long fib = liczba + poprzednia;
            poprzednia = liczba;
            liczba = fib;
        }
        return liczba;
    }

    public static long wypiszRekurencyjnie(int k) {
        if (k == 0) {
            return 0;
        }
        if (k == 1 || k == 2) {
            return 1;
        }
        return wypiszRekurencyjnie(k-1) + wypiszRekurencyjnie(k-2);
    }

    public static long wypiszBinet(int k) {
        double s5 = Math.sqrt(5);
        double f1 = (1 + s5) / 2;
        double f2 = (1 - s5) / 2;
        double k1 = Math.pow(f1, k);
        double k2 = Math.pow(f2, k);
        double res = (k1 - k2) / s5;
        return (long)res;
    }

    public static void leqFibo(long k) {
        long tab[] = new long[92];
        tab[0] = 0;
        tab[1] = 1;
        if (k == 0) {
            System.out.println("0: 0\n0: 0");
        } else if (k == 1) {
            System.out.println("1: 1\n2: 1");
        } else {
            for (int i = 2; i < tab.length; i++) {
                tab[i] = tab[i-1] + tab[i-2];
                if (k > tab[i-1] && k < tab[i]) {
                    System.out.println(i-1 + ": " + tab[i-1]);
                    System.out.println(i + ": " + tab[i]);
                } else if (k == tab[i]) {
                    System.out.println(i + ": " + tab[i]);
                    System.out.println(i + ": " + tab[i]);
                } else {
                    continue;
                }
            }
        }
    }

    /*public static void rozklad(int k) {
        int j = 0;
        long tab[] = new long[90];
        tab[0] = 0;
        tab[1] = 1;
        for (int i = 2; i < tab.length; i++) {
            tab[i] = tab[i-1] + tab[i-2];
        }
        for (int i = 0; i < tab.length; i++) {
            System.out.print("Fib(" + i + ") = " + tab[i] + " = ");
            while (j != i) {
                j = 1;
                for (int l = 1; l < i; l++) {
                    if (tab[i] % l == 0) {
                        tab[i] /= l;
                        System.out.println(tab[i]);
                        break;
                    }
                }



//              if (tab[i] == tab[j]) {
//                  System.out.println(tab[i]);
//                  break;
//              } else {
//                  System.out.println("_" + tab[i] + "_");
//                  break;
//              }
            }
        }
    }*/
}
