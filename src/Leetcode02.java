import java.util.ArrayList;
import java.util.List;

public class Leetcode02 {
    static List<List<Integer>> list = new ArrayList<>();

    public static List<List<Integer>> permute(int[] nums) {
        perm(nums, 0, nums.length);
        return list;
    }

    public static void perm(int[] arr, int st, int len) {
        if (st == len - 1) {
            List<Integer> ll = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                ll.add(arr[i]);
//                System.out.print(arr[i]+" ");
            }
//            System.out.println();
            list.add(ll);
        } else {
            for (int i = st; i < len; i++) {
                swap(arr, st, i);
                perm(arr, st + 1, len);
                swap(arr, st, i);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3};
        List<List<Integer>> p = permute(a);
        System.out.println(p.toString());
    }
}
