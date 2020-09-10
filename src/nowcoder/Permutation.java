package nowcoder;

/**
 * @author god-jiang
 * @date 2020/3/23  14:31
 */
public class Permutation {
    /**
     * 全排列
     * @param arr
     * @param start
     * @param len
     */
    public static void perm(char[] arr, int start, int len) {
        if (start == len - 1) {
            for (int i = 0; i < len; i++) {
                System.out.print(arr[i]);
            }
            System.out.println();
        } else {
            for (int i = start; i < len; i++) {
                swap(arr, start, i);
                perm(arr, start + 1, len);
                swap(arr, start, i);
            }
        }
    }

    /**
     * 交换两个数
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        char[] arr = "123".toCharArray();
        perm(arr, 0, arr.length);
    }
}
