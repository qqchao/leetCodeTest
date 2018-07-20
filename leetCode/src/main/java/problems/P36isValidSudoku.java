package problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 *
 *
 * 上图是一个部分填充的有效的数独。
 *
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   ["5","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: true
 * 示例 2:
 *
 * 输入:
 * [
 *   ["8","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: false
 * 解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
 *      但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
 * 说明:
 *
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 给定数独序列只包含数字 1-9 和字符 '.' 。
 * 给定数独永远是 9x9 形式的。
 */
public class P36isValidSudoku {
    public static void main(String[] args) {
        char[][] sudoku = new char[][]{
                {'9','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
            };

        System.out.println(isValidSudoku(sudoku));
        System.out.println(isValidSudoku2(sudoku));
    }

    public static boolean isValidSudoku(char[][] board) {
        List<Set<Character>> sets = new ArrayList<Set<Character>>();
        for(int i = 0; i < 9; i++){
            Set<Character> set1 = new HashSet<Character>();
            Set<Character> set2 = new HashSet<Character>();
            for(int j = 0; j < 9; j++){
                if(set1.contains(board[i][j])){
                    return false;
                }
                if(set2.contains(board[j][i])){
                    return false;
                }
                if(i%3==0 && j%3==0){
                    sets.add(new HashSet<Character>());
                }else if(sets.get(i/3*3 + j/3).contains(board[i][j])){
                    return false;
                }
                if(board[i][j] != '.'){
                    set1.add(board[i][j]);
                    sets.get(i/3*3 + j/3).add(board[i][j]);
                }
                if(board[j][i] != '.') {
                    set2.add(board[j][i]);
                }
            }

        }

        return true;
    }


    public static boolean isValidSudoku2(char[][] board) {

        //横向纵向
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                for(int k = j+1; k < 9; k++){
                    if(board[i][j] == board[i][k] && board[i][j] != '.') return false;
                    if(board[j][i] == board[k][i] && board[j][i] != '.') return false;
                }
            }
        }

        //九宫格内
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                for (int k = 0; k < 9; k++){
                    for(int l = k+1; l < 9; l++){
                        if(board[j*3+k%3][i*3+k/3] == board[j*3+l%3][i*3+l/3] && board[j*3+k%3][i*3+k/3] != '.'){
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}
