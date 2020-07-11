public class Leetcode204 {
    public static void main(String[] args) {
        System.out.println(countPrimes(10));
    }

    //统计小于n的质数有多少个
/*    public static int countPrimes(int n){
        int i=2;
        int count=0;
        while(i<n){
            boolean flag=true;
            for(int j=2;j<=Math.sqrt(i);j++){
                if(i%j==0){
                    flag=false;
                    break;
                }
            }
            if(flag){
//                System.out.println(i);
                count++;
            }
            i++;
        }
        return count;
    }*/

    //厄拉多赛筛法求质数
    public static int countPrimes(int n) {
        int count=0;
        int[] nums=new int[n];
        for(int i=0;i<nums.length;i++){
            //质数全部标成1
            nums[i]=1;
        }
        for(int i=2;i<n;i++){
            if(nums[i]==1){
                for(int j=2;i*j<n;j++){
                    nums[i*j]=0;
                }
            }
        }
        for(int i=2;i<n;i++){
            if(nums[i]==1){
                count++;
            }
        }
        return count;
    }
}
