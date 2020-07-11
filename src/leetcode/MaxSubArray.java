package leetcode;

import java.util.Scanner;

/**
 * @author god-jiang
 * @date 2020/1/22  13:45
 */
public class MaxSubArray {
    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int curSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curSum = Math.max(nums[i], curSum + nums[i]);
            max = Math.max(max, curSum);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int max = maxSubArray(nums);
        System.out.println(max);
//        Scanner sc = new Scanner(System.in);
//        int i = sc.nextInt();
//        System.out.println(i);
    }
}
