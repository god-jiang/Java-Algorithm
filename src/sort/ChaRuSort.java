package sort;

import java.util.Arrays;

/**
 * @author god-jiang
 * @date 2020/2/27  14:22
 */
public class ChaRuSort {
    //插入排序，跟打扑克牌一样
    //时间复杂度O(n^2) 空间复杂度O(1)  稳定排序
    public static void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i - 1; j >= 0 && array[j] > array[j + 1]; j--) {
                swap(array, j, j + 1);
            }
        }
    }

    //交换两数
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 5, 6, 1, 4, 9, 7, 8, 3};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
