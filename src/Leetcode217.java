import java.util.*;

public class Leetcode217 {
    public static void main(String[] args) {

    }

    public static boolean containsDuplicate(int[] nums){
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1])
                return true;
        }
        return false;
    }
}
