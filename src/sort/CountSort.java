package sort;

import java.util.Arrays;

/**
 * @author god-jiang
 * @date 2020/3/6  19:36
 */
public class CountSort {
    public static int[] countSort(int[] array) {
        //求Array数组的最大值
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        //创建一个长度为max+1的countArray数组
        int[] countArray = new int[max + 1];
        //计数排序
        for (int i = 0; i < array.length; i++) {
            countArray[array[i]]++;
        }

        int index = 0;
        int[] sortedArray = new int[array.length];
        for (int i = 0; i < countArray.length; i++) {
            for (int j = 0; j < countArray[i]; j++) {
                sortedArray[index++] = i;
            }
        }
        return sortedArray;
    }

    //主函数入口
    public static void main(String[] args) {
        int[] array = new int[]{0, 2, 4, 4, 1, 1, 6, 5, 8, 9, 9, 6};
        int[] sortedArray = countSort(array);
        System.out.println(Arrays.toString(sortedArray));
    }
}
