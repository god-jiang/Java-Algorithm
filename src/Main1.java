import java.util.Arrays;
import java.util.Scanner;

/**
 * @author god-jiang
 * @date 2020/3/14  17:11
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long m = sc.nextLong();
        Long[] arr = new Long[(int) n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
            sum += arr[i];
        }
        long index = m / sum;
        m -= index * sum;
        int count = 1;
        while (m > 0) {
            if (m > arr[(int) (count % n)]) {
                m -= arr[(int) (count % n)];
                count++;
            } else {
                break;
            }
        }
        System.out.println(index * n + count);
    }
}
