import java.math.BigInteger;

public class Leetcode172 {
    public static void main(String[] args) {
        System.out.println(trailingZeroes(13));
    }

    //能解决问题，但是超过限定时间
/*    public static int trailingZeroes(int n) {
        BigInteger result=new BigInteger("1");
        int count=0;
        for(int i=1;i<=n;i++){
            result=result.multiply(BigInteger.valueOf(i));
        }
        String str = result.toString();
        for(int i=str.length()-1;i>=0;i--){
            if(str.charAt(i)=='0'){
                count++;
            }else{
                return count;
            }
        }
        return 0;
    }*/

    public static int trailingZeroes(int n){
        int result=0;
        while(n>0){
            result+=n/5;
            n/=5;
        }
        return result;
    }
}
