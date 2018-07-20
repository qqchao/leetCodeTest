package problems;

/**
 * 给定一个 n × n 的二维矩阵表示一个图像。
 *
 * 将图像顺时针旋转 90 度。
 *
 * 说明：
 *
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 *
 * 示例 1:
 *
 * 给定 matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 * 示例 2:
 *
 * 给定 matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 */
public class P48rotateII {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {9,3,1,2},
                {6,5,5,1},
                {4,9,8,4},
                {8,2,7,0}
        };

//        rotate(matrix);
        rotate2(matrix);

        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix.length; j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void rotate(int[][] matrix) {
        //上下互换
        int[] temp;
        for (int i = 0; i < matrix.length / 2; i++){
            temp = matrix[i];
            matrix[i] = matrix[matrix.length-1-i];
            matrix[matrix.length-1-i] = temp;
        }
        //对角线互换
        int tem;
        for (int i = 0; i < matrix.length-1; i++){
            for (int j = i + 1; j < matrix.length; j++){
                tem = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tem;
            }
        }
    }

    /**
     * 逆时针
     */
    public static void rotate2(int[][] matrix) {
        //对角线互换
        int tem;
        for (int i = 0; i < matrix.length-1; i++){
            for (int j = i + 1; j < matrix.length; j++){
                tem = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tem;
            }
        }
        //上下互换
        int[] temp;
        for (int i = 0; i < matrix.length / 2; i++){
            temp = matrix[i];
            matrix[i] = matrix[matrix.length-1-i];
            matrix[matrix.length-1-i] = temp;
        }
    }
}
