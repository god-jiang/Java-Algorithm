package leetcode.days;

/**
 * 941. 有效的山脉数组
 *
 * @author god-jiang
 */
public class ValidMountainArray {
    public boolean validMountainArray(int[] A) {
        int i = 0;
        int n = A.length;
        while (i + 1 < n && A[i] < A[i + 1]) {
            i++;
        }
        if (i == 0 || i == n - 1) {
            return false;
        }
        while (i + 1 < n && A[i] > A[i + 1]) {
            i++;
        }
        return i == n - 1;
    }
}
