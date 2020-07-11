package Test;

import com.sun.org.apache.xml.internal.security.utils.HelperNodeList;

import java.util.ArrayList;

/**
 * @author god-jiang
 * @date 2020/1/17  20:58
 */
public class Solution {
    static ArrayList<Integer> resList = new ArrayList<>();

    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        int x1 = 0;
        int y1 = 0;
        int x2 = matrix.length - 1;
        int y2 = matrix[0].length - 1;
        while (x1 <= x2 && y1 <= y2) {
            helpPrintMatrix(matrix, x1++, y1++, x2--, y2--);
        }
        return resList;
    }

    public static void helpPrintMatrix(int[][] matrix, int x1, int y1, int x2, int y2) {
        if (x1 == x2) {
            for (int i = y1; i <= y2; i++) {
                resList.add(matrix[x1][i]);
            }
        } else if (y1 == y2) {
            for (int i = x1; i <= x2; i++) {
                resList.add(matrix[i][y1]);
            }
        } else {
            int curX = x1;
            int curY = y1;
            while (curY != y2) {
                resList.add(matrix[x1][curY]);
                curY++;
            }
            while (curX != x2) {
                resList.add(matrix[curX][y2]);
                curX++;
            }
            while (curY != y1) {
                resList.add(matrix[x2][curY]);
                curY--;
            }
            while (curX != x1) {
                resList.add(matrix[curX][y1]);
                curX--;
            }
        }
    }
}
