package nowcoder;

import java.util.HashMap;
import java.util.Map;

/**
 * @author god-jiang
 * @date 2020/1/27  16:39
 */

//一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
public class FindNumsAppearOnce {
    //HashMap解法
    public static void findNumsAppearOnce(int[] array, int num1[], int num2[]) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                map.put(array[i], 2);
            } else {
                map.put(array[i], 1);
            }
        }
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (map.get(array[i]) == 1) {
                if (count == 0) {
                    num1[0] = array[i];
                    count++;
                } else {
                    num2[0] = array[i];
                }
            }
        }
    }


    //异或解法
    public static void findNumsAppearOnce1(int[] array, int num1[], int num2[]) {
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            temp = temp ^ array[i];
        }
        int index = 1;
        //找到异或结果第一位为1的位置
        while ((index & temp) == 0) {
            index = index << 1;
        }
        int result1 = 0;
        int result2 = 0;
        for (int i = 0; i < array.length; i++) {
            if ((index & array[i]) == 0) {
                result1 = result1 ^ array[i];
            } else {
                result2 = result2 ^ array[i];
            }
        }
        num1[0] = result1;
        num2[0] = result2;
    }
}
