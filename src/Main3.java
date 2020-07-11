import java.util.Arrays;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int left = 0;
        int right = 0;
        for (int j = 1; j < n; j++) {
            left = left ^ arr[0] ^ arr[j];
        }
        for (int j = 1; j < n - 1; j++) {
            right = right ^ arr[arr.length - 1] ^ arr[j];
        }
        System.out.println(left ^ right);
    }
}
