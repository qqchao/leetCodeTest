package cn.qqchao.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 上图为 8 皇后问题的一种解法。
 *
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 *
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 *
 *
 * 示例：
 *
 * 输入：4
 * 输出：[
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 *
 *
 *
 * 提示：
 *
 *     皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P51solveNQueens {
    public static void main(String[] args) {
        System.out.println(solveNQueens(4).toString());

//        setRows(6);
//        System.out.println(rows.toString());
    }

    public static List<List<Integer>> indexArr;
    public static List<String> rows;

    public static List<List<String>> solveNQueens(int n) {
        indexArr = new ArrayList<>();
        getQueensCoordinates(new ArrayList<>(), n);
        setRows(n);
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < indexArr.size(); i++) {
            List<Integer> solution = indexArr.get(i);
            List<String> graph = new ArrayList<>();
            for (int j = 0; j < solution.size(); j++) {
                graph.add(rows.get(solution.get(j)));
            }
            result.add(graph);
        }
        return result;
    }

    private static void getQueensCoordinates(ArrayList<Integer> preCoordinate, int n){
        int current = preCoordinate.size();
        if (current == n){
            indexArr.add(preCoordinate);
        } else {
            for (int i = 0; i < n; i++) {
                boolean rightIndex = true;
                for (int j = 0; j < preCoordinate.size(); j++) {
                    if (i+current == j+preCoordinate.get(j) || i-current == preCoordinate.get(j)-j || i == preCoordinate.get(j)){
                        rightIndex = false;
                        break;
                    }
                }
                if (rightIndex) {
                    ArrayList cloneList = (ArrayList) preCoordinate.clone();
                    cloneList.add(i);
                    getQueensCoordinates(cloneList, n);
                }
            }
        }
    }

    static void setRows(int n){
        rows = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (j == i){
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            rows.add(sb.toString());
        }
    }
}
