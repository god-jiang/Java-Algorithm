package zhihu;

/**
 * @author god-jiang
 * @date 2020/2/17  18:49
 */
public class DP {
    public static int minPathSum(int[][] matrix, int i, int j) {
        //base case走到最后一格了
        if (i == matrix.length - 1 && j == matrix[0].length - 1) {
            return matrix[i][j];
        }
        //最后一行，只能向右走
        if (i == matrix.length - 1) {
            return matrix[i][j] + minPathSum(matrix, i, j + 1);
        }
        //最后一列，只能向下走
        if (j == matrix[0].length - 1) {
            return matrix[i][j] + minPathSum(matrix, i + 1, j);
        }
        //其他情况
        int right = minPathSum(matrix, i, j + 1);
        int down = minPathSum(matrix, i + 1, j);
        return matrix[i][j] + Math.min(right, down);
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(minPathSum(matrix, 0, 0));
    }


}
