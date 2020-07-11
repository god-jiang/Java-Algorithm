package sort;

import java.util.Arrays;

/**
 * @author god-jiang
 * @date 2020/2/27  14:11
 */
public class SelectionSort {
    //选择排序
    //思路：从数组第一个数开始跟后面的数比较，最小和第一个交换，循环进行
    //时间复杂度：O(n^2)  空间复杂度O(1)  不稳定排序
    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                minIndex = array[minIndex] > array[j] ? j : minIndex;
            }
            swap(array, i, minIndex);
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
        selectionSort(array);
        System.out.println(Arrays.toString(array));
    }
}
