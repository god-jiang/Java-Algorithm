package leetcode;

/**
 * @author god-jiang
 * @date 2020/3/10  19:41
 */
public class Power {
    public double myPow(double x, int n) {
        //避免当n为最大值时，进行n=-n时数据越界出错
        long exponent = n;
        if (n < 0) {
            x = 1 / x;
            exponent = -exponent;
        }
        double res = 1.0;
        while (exponent != 0) {
            //奇数多出了一项x
            if ((exponent & 1) == 1) {
                res = res * x;
            }
            //二分操作
            x = x * x;
            exponent = exponent >> 1;
        }
        return res;
    }
}
