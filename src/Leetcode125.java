public class Leetcode125 {
    //给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
    public static void main(String[] args) {
        String a = "A man,a plan,a canal:Panama";
        String b = "race a car";
        System.out.println(isPalindrome(b));
    }

    public static boolean isPalindrome(String s) {
        int len = s.length();
        s = s.toLowerCase();
        int i = 0;
        int j = len - 1;
        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while (i < j && !Character.isLetterOrDigit((s.charAt(j)))) {
                j--;
            }
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
