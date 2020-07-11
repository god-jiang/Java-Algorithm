package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 * @author god-jiang
 * @date 2020/3/7  13:38
 */
public class BucketSort {
    public static double[] bucketSort(double[] array) {
        double max = Double.MIN_VALUE;
        double min = Double.MAX_EXPONENT;
        //求出array数组的最大值和最小值
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            } else if (array[i] < min) {
                min = array[i];
            }
        }
        //计算出差值
        double d = max - min;
        //初始化桶
        int bucketNum = array.length;
        ArrayList<LinkedList<Double>> bucketList = new ArrayList<>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            bucketList.add(new LinkedList<>());
        }

        for (int i = 0; i < array.length; i++) {
            int num = (int) ((array[i] - min) * (bucketNum - 1) / d);
            bucketList.get(num).add(array[i]);
        }

        //JDK底层采用了归并排序或归并的优化版本进行排序
        for (int i = 0; i < bucketList.size(); i++) {
            Collections.sort(bucketList.get(i));
        }

        //输出结果
        double[] sortedArray = new double[array.length];
        int index = 0;
        for (LinkedList<Double> list : bucketList) {
            for (double element : list) {
                sortedArray[index++] = element;
            }
        }
        return sortedArray;
    }

    //主函数
    public static void main(String[] args) {
        double[] array = new double[]{3.14, 0.002, 6.6, 3.0, 10.01, 8.8, 4.55, 7.89};
        double[] sortedArray = bucketSort(array);
        System.out.println(Arrays.toString(sortedArray));
    }
}
