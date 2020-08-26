package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode17题，电话号码的字母组合
 *
 * @author mac
 */
public class LetterCombinations {
    private String[] letterMap = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    private ArrayList<String> res;

    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        if (digits.equals("")) {
            return res;
        }

        findCombination(digits, 0, "");
        return res;
    }

    private void findCombination(String digits, int index, String str) {
        if (index == digits.length()) {
            res.add(str);
            return;
        }

        Character c = digits.charAt(index);
        String letters = letterMap[c - '0'];
        for (int i = 0; i < letters.length(); i++) {
            findCombination(digits, index + 1, str + letters.charAt(i));
        }

        return;
    }
}
