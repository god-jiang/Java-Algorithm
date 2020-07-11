import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] p = new double[n];
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = sc.nextDouble();
        }
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        double maxP = 0;
        int maxA = 0;
        double max = -1;
        double temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= n; j++) {
                temp += Math.pow(p[i], j - i) * a[i];
            }
            if (temp > max) {
                maxP = p[i];
                maxA = a[i];
            }
        }
        max = 0;
        for (int i = 0; i < n; i++) {
            max += Math.pow(maxP, i + 1) * maxA;
        }
        System.out.println(String.format("%.2f", max));
    }
}
