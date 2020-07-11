package Test;

/**
 * @author god-jiang
 * @date 2020/1/12  15:17
 */
public class LongestPalindrome_BAOLI {
    //判断是否为回文串
    public static boolean isPalindrome(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static String longestPalindrome(String s) {
        int len = s.length();
        String ans = "";
        int max = -1;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                String test = s.substring(i, j);
                if (isPalindrome(test) && test.length() > max) {
                    ans=test;
                    max=test.length();
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        //substring(a, b)是[a,b)
//        String substring = x.substring(0, 2);
//        System.out.println(substring);
        String x = "babad";
        String s = longestPalindrome(x);
        System.out.println(s);

    }
}
