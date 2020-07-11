public class Leetcode191 {
    public static void main(String[] args) {
        int n=1011;
        System.out.println(hammingWeight(n));
    }
    //算出1的个数
/*    public static int hammingWeight(int n){
        int count=0;
        String str = Integer.toString(n);
        System.out.println(str);
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='1'){
                count++;
            }
        }
        return count;
    }*/
    //毫无意义的一道题还有解法
    public static int hammingWeight(int n){
        int count=0;
        while(n!=0){
            count++;
            n&=(n-1);
        }
        return count;
    }
}
