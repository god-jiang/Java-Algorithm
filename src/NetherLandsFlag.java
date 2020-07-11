/**
 * @author god-jiang
 * @date 2019/12/26
 */

import java.util.Arrays;

/**
 * 给定一个数组arr和一个数num，请把小于num的数放在数组的左边，等于num的数放在数组的中间，
 * 大于num的数放在数组的右边。
 * 要求额外空间复杂度为O(1)，时间复杂度为O(N)
 */
public class NetherLandsFlag {
    public static int[] partition(int[] arr, int L, int R, int num) {
        int less = L - 1;//小于区域的边界
        int more = R + 1;//大于区域的边界
        int cur = 0;
        while (cur < more) {
            if (arr[cur] < num) {
                swap(arr, ++less, cur++);
            } else if (arr[cur] > num) {
                swap(arr, --more, cur);
            } else {
                cur++;
            }
        }
        return arr;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{7, 2, 9, 3, 5, 8, 8, 5, 1, 6, 6, 4};
        int[] res = partition(arr, 0, arr.length - 1, 5);
        System.out.println(Arrays.toString(res));
    }
}
