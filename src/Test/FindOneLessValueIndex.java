package Test;

/**
 * @author god-jiang
 * @date 2020/1/11
 */
public class FindOneLessValueIndex {

    public static int getLessIndex(int[] arr) {
        //如果不存在直接return -1
        if (arr == null || arr.length == 0) {
            return -1;
        }
        //先看arr[0]和arr[N-1]是不是局部最小，是的话直接返回即可
        if (arr.length == 1 || arr[0] < arr[1]) {
            return 0;
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }

        //然后中间部分使用二分
        int left = 1;
        int right = arr.length - 2;
        int mid = 0;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (arr[mid] > arr[mid - 1]) {
                right = mid - 1;
            } else if (arr[mid] > arr[mid + 1]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {6, 5, 3, 4, 6, 7, 8};
        printArray(arr);
        int index = getLessIndex(arr);
        System.out.println("index: " + index + ", value: " + arr[index]);
    }
}
