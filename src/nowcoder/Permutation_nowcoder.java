package nowcoder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author god-jiang
 * @date 2020/1/18  20:43
 */
public class Permutation_nowcoder {
    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if (str != null && str.length() > 0) {
            permutation(str.toCharArray(), 0, list);
            Collections.sort(list);
        }
        return list;
    }

    public static void permutation(char[] arr, int i, ArrayList<String> list) {
        if (i == arr.length - 1) {
            list.add(String.valueOf(arr[i]));
        } else {
            Set<Character> set = new HashSet<>();
            for (int j = i; j < arr.length; j++) {
                if (j == i || !set.contains(arr[j])) {
                    set.add(arr[j]);
                    swap(arr, i, j);
                    permutation(arr, i + 1, list);
                    swap(arr, j, i);
                }
            }
        }
    }

    public static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
