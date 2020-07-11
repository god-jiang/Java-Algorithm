package sort;

import java.util.Arrays;

/**
 * @author god-jiang
 * @date 2020/2/27  14:02
 */
public class BubbleSort {
    //冒泡排序，两两比较，小的往左边，大的往右边
    //时间复杂度O(n^2)  稳定排序  空间复杂度O(1)
    private static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            //避免已经排好序了还要继续循环下次
            boolean isSorded = true;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    isSorded = false;
                }
            }
            if (isSorded) {
                break;
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
        int[] array = new int[]{5, 2, 8, 1, 3, 4, 9, 7, 6};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
