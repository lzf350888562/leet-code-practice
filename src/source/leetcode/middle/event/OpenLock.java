package source.leetcode.middle.event;

import java.util.*;

/**
 * 752. 打开转盘锁 给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。
 * 不考虑限制条件: 只转⼀下锁，共有 4 个位置，每个位置可以向上转，也可以向下转，也就是有 8 种可能
 * 这就可以抽象成⼀幅以 0000 为起点的图，每个节点有 8 个相邻的节点，求最短距离，这就是典型的 BFS.
 *
 * 如果明确终点在哪, 可以使用双向BFS, 同时从起点终点进行扩散
 */
public class OpenLock {
    //单向BFS解法
    public int openLock(String[] deadends, String target) {
        // 记录需要跳过的死亡密码
        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        // 记录已经穷举过的密码，防⽌⾛回头路
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        // 从起点开始启动⼴度优先搜索
        int step = 0;
        q.offer("0000");
        visited.add("0000");
        while (!q.isEmpty()) {
            int sz = q.size();
            // 将当前队列中的所有节点向周围扩散
            for (int i = 0; i < sz; i++) {
                String cur = q.poll();
                // 判断是否到达终点
                if (deads.contains(cur))
                    continue;
                if (cur.equals(target))
                    return step;
                // 将⼀个节点的未遍历相邻节点加⼊队列
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    if (!visited.contains(up)) {
                        q.offer(up);
                        visited.add(up);
                    }
                    String down = minusOne(cur, j);
                    if (!visited.contains(down)) {
                        q.offer(down);
                        visited.add(down);
                    }
                }
            }
            // 在这⾥增加步数
            step++;
        }
        // 如果穷举完都没找到⽬标密码，那就是找不到了
        return -1;
    }


    // 将 s[j] 向上拨动⼀次
    String plusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '9')
            ch[j] = '0';
        else
            ch[j] += 1;
        return new String(ch);
    }
    // 将 s[i] 向下拨动⼀次
    String minusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '0')
            ch[j] = '9';
        else
            ch[j] -= 1;
        return new String(ch);
    }

    /**
     *  不考虑限制条件BST求图的最短路径
     *  存在问题:1.走回头路 2.没有终止条件3.没有对deadends处理
     *  在该代码上修复这些问题即可
     */
//    // BFS 框架，打印出所有可能的密码
//    void BFS(String target) {
//        Queue<String> q = new LinkedList<>();
//        q.offer("0000");
//        while (!q.isEmpty()) {
//            int sz = q.size();
//            for (int i = 0; i < sz; i++) {
//                String cur = q.poll();
//                System.out.println(cur);
//                for (int j = 0; j < 4; j++) {
//                    String up = plusOne(cur, j);
//                    String down = minusOne(cur, j);
//                    q.offer(up);
//                    q.offer(down);
//                }
//            }
//        }
//        return;
//    }

    public static void main(String[] args) {
//        new OpenLock().BFS("xxx");
    }
}
