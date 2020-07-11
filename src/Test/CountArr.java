package Test;

/**
 * @author god-jiang
 * @date 2020/1/22  17:30
 */
public class CountArr {
    public static void work(int[] arr, int n) {
        int index = 0;
        while (index < n) {
            //因为数组都是从0开始的，所以arr[index]得减1才可以找到对应的元素，否则会数组越界
            int temp = arr[index] - 1;
            if (temp < 0) {
                index++;
                continue;
            }
            if (arr[temp] > 0) {
                arr[index] = arr[temp];
                arr[temp] = -1;
            } else {
                arr[temp]--;
                arr[index] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 5, 5, 2, 3};
        work(arr, arr.length);
        int index = 1;
        for (int countResult : arr
        ) {
            System.out.println(index++ + "出现了" + (-1) * countResult + "次");
        }
    }
}
