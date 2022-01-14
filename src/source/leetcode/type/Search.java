package source.leetcode.type;

import source.leetcode.esay.tree.TreeNode;

import java.util.List;

/**
 * 深度优先搜索 (回溯法)
 * 695. 岛屿的最大面积
 * 257. 二叉树的所有路径
 * 47. 全排列 II
 *
 * 广度优先搜索  队列
 * 51.n皇后
 * 934. 最短的桥
 *
 * 126. 单词接龙 II
 * 130. 被围绕的区域
 * 37. 解数独
 * 40. 组合总和 II
 * 310. 最小高度树
 */
public class Search {

    /**
     * 695. 岛屿的最大面积
     * 给定一个二维的 0-1 矩阵，其中 0 表示海洋，1 表示陆地。单独的或相邻的陆地可以形成岛屿，
     * 每个格子只与其上下左右四个格子相邻。求最大的岛屿面积。
     */
    public int maxAreaOfIsland(int[][] grid) {
        return 0;
    }

    /**
     *934. 最短的桥
     * 在给定的二维二进制数组A中，存在两座岛。（岛是由四面相连的 1 形成的一个最大组。）
     * 现在，我们可以将0变为1，以使两座岛连接起来，变成一座岛。
     * 返回必须翻转的0 的最小数目。（可以保证答案至少是 1 。）
     */
    public int shortestBridge(int[][] grid) {
        return 0;
    }

    /**
     * 126. 单词接龙 II
     * 给定一个起始字符串和一个终止字符串，以及一个单词表，求是否可以将起始字符串每次改一个字符，
     * 直到改成终止字符串，且所有中间的修改过程表示的字符串都可以在单词表里找到。
     * 若存在，输出需要修改次数最少的所有更改方式。
     */
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        return null;
    }

    /**
     * 130. 被围绕的区域
     * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的'O' 用 'X' 填充。
     */
    public void solve(char[][] board) {

    }

    /**
     * 257. 二叉树的所有路径
     * 输入：root = [1,2,3,null,5]
     * 输出：["1->2->5","1->3"]
     */
    public List<String> binaryTreePaths(TreeNode root) {
        return null;
    }

    /**
     * 47. 全排列 II
     * 处理重复
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        return null;
    }

    /**
     * 40. 组合总和 II
     * 给你一个由候选元素组成的集合 candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
     * candidates 中的每个元素在每个组合中只能使用 一次 。
     * 解集不能包含重复的组合。
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        return null;
    }

    /**
     * 37. 解数独
     * 编写一个程序，通过填充空格来解决数独问题。
     * 数字 1-9 在每一行只能出现一次。
     * 数字 1-9 在每一列只能出现一次。
     * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
     * 数独部分空格内已填入了数字，空白格用 '.' 表示。
     */
    public void solveSudoku(char[][] board) {

    }

    /**
     * 310. 最小高度树
     */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        return null;
    }
}
