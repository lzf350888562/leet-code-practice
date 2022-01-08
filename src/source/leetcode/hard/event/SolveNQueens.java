package source.leetcode.hard.event;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 51. N 皇后
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 皇后可以攻击同⼀⾏、同⼀列、左上左下右上右下四个⽅向的任意单位。
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 */
public class SolveNQueens {
    //回溯法, 与全排列类似

    public List<List<String>> solveNQueens(int n) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> tmp = new LinkedList<>();
        doSolve(res, tmp,n);
        char[] chars = new char[n];
        for (int i = 0; i < n; i++) {
            chars[i] = '.';
        }
        System.out.println(res);
        return  res.stream().map((item) -> item.stream().map(index -> {
            char[] t = Arrays.copyOf(chars,n);
            t[index]='Q';
            return new String(t);
        }).collect(Collectors.toList())).collect(Collectors.toList());
    }

    private void doSolve(List<List<Integer>> res, LinkedList<Integer> tmp, int n) {
        if(n == tmp.size()){

            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < n; i++) {
            //同一列是否存在  并且 斜线上是否存在
            if(!tmp.contains(i) && isValid(tmp,i)){
               tmp.add(i);
               doSolve(res,tmp,n);
               tmp.removeLast();
           }
        }
    }
    //验证斜线上是否存在
    private boolean isValid(LinkedList<Integer> tmp, int x){
        int y = tmp.size();
        for (int i = 1; i <= tmp.size(); i++) {
            if(Math.abs(tmp.get(tmp.size()-i)-(x-i))==0 || Math.abs(tmp.get(tmp.size()-i)-(x+i))==0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SolveNQueens solveNQueens = new SolveNQueens();
        System.out.println(solveNQueens.solveNQueens(5));
    }
}
