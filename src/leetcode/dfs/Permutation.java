package leetcode.dfs;

import java.util.*;

/**
 * 回溯算法08，有重复字符串的排列组合
 * 有重复字符串的排列组合，编写一种方法，计算某字符串的所有排列组合。
 *
 * @author god-jiang
 */
public class Permutation {
    Set<String> list = new HashSet<>();

    public String[] permutation(String S) {
        dfs(S.toCharArray(), 0);
        String[] s = new String[list.size()];
        Iterator<String> iterator = list.iterator();
        int index = 0;
        while (iterator.hasNext()) {
            s[index++] = iterator.next();
        }
        return s;
    }

    public void dfs(char[] S, int st) {
        if (st == S.length) {
            // st等于长度或者长度-1都是一样的
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < S.length; i++) {
                sb.append(S[i]);
            }
            list.add(sb.toString());
        } else {
            for (int i = st; i < S.length; i++) {
                swap(S, st, i);
                dfs(S, st + 1);
                swap(S, st, i);
            }
        }
    }

    public void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}
