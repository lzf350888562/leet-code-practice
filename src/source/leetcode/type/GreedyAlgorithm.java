package source.leetcode.type;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 贪心算法
 * 455 分发饼干 Easy
 * 135 分发糖果 Hard
 * 435 无重叠区间 Middle
 * 605 种花问题 Easy
 * 452 用最少数量的箭引爆气球 Middle
 * 122 买卖股票 Easy
 * 406 根据身高重建队列 Middle
 * 665 非递减数列 Middle
 */
public class GreedyAlgorithm {
    /**
     * 455. 分发饼干
     * 有一群孩子和一堆饼干，每个孩子有一个饥饿度，每个饼干都有一个大小。
     * 每个孩子只能吃最多一个饼干，且只有饼干的大小大于孩子的饥饿度时，这个孩子才能吃饱。求解最多有多少孩子可以吃饱。
     * <p>
     * 贪心策略: 给剩余孩子里最小饥饿度的孩子分配最小的能饱腹的饼干
     *
     * @param g 每个孩子的胃口值
     * @param s 每个饼干的尺寸
     * @return 最多满足孩子数量
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g); //孩子
        Arrays.sort(s); //饼干
        int count = 0;
        for (int i = 0, j = 0; i < g.length && j < s.length; ) {
            if (g[i] <= s[j]) {
                count++;
                i++;
                j++;
            } else {
                j++;
            }
        }
        return count;
    }

    /**
     * 135. 分发糖果
     * 一群孩子站成一排，每一个孩子有自己的评分。
     * 现在需要给这些孩子发糖果，规则是如果一个孩子的评分比自己身旁的一个孩子要高，那么这个孩子就必须得到比身旁孩子更多的糖果；
     * 所有孩子至少要有一个糖果。求解最少需要多少个糖果。
     * <p>
     * 贪心策略: 在每次遍历中，只考虑并更新相邻一侧的大小关系。
     *
     * @param ratings 每个孩子的评分
     * @return 最少需要糖果
     */
    public int candy(int[] ratings) {
        int[] res = new int[ratings.length];
        Arrays.fill(res, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                res[i] = res[i - 1] + 1;
            }
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                //需要判断
                if (res[i] > res[i + 1]) {
                    continue;
                }
                res[i] = res[i + 1] + 1;
            }
        }
        return Arrays.stream(res).sum();
    }

    /**
     * 435. 无重叠区间
     * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
     * 注意:
     * 可以认为区间的终点总是大于它的起点。
     * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
     * <p>
     * 贪心策略: 优先保留结尾小且不相交的区间。
     *
     * @param intervals 区间集合
     * @return 次数
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        //区间需要根据尾结点排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        int total = 0, prev = intervals[0][1];
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] < prev) {
                ++total;
            } else {
                prev = intervals[i][1];
            }
        }
        return total;
    }

    /**
     * 605. 种花问题
     * 长花坛, 花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
     * 给你一个整数数组flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。
     * 能否在不打破种植规则的情况下种入n朵花？能则返回 true ，不能则返回 false。
     * <p>
     * 空闲区间能种 (interval-1)/2朵花 (开始和结尾0区间除外interval/2),  可通过前后补0实现;
     * 或者
     * 贪心策略: 能种就种,优先往前面种
     *
     * @param flowerbed 花坛
     * @param n         花
     * @return 能否种下
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
//        int interval = 0;
//        int count = 0;
//        //处理前面为多个0的情况
//        for (int i = 0; i < flowerbed.length; i++) {
//            if (flowerbed[i] == 0) {
//                interval++;
//                if(i == 0){
//                    interval++;//相当于前面补0
//                }
//                if(i == flowerbed.length-1){
//                    interval++;//相当于后面补0
//                    count += (interval - 1) / 2; //解决0结尾不会计算的问题
//                }
//            } else {
//                count += (interval - 1) / 2;
//                interval = 0;
//            }
//        }
//        return count >= n;
        /**
         * 我们的主角是贪心算法------------------------
         */
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            //至少需要3空地  或者左头+右空地 或者右尾+左空地
            if(flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i + 1 == flowerbed.length || flowerbed[i + 1] == 0) ){
                flowerbed[i] = 1;
                count++;
            }
        }
        return count >= n;
    }

    /**
     * 452. 用最少数量的箭引爆气球
     * 在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。
     * 由于它是水平的，所以纵坐标并不重要，因此只要知道开始和结束的横坐标就足够了。开始坐标总是小于结束坐标。
     *
     * 一支弓箭可以沿着 x 轴从不同点完全垂直地射出。
     * 在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足xstart≤ x ≤ xend，则该气球会被引爆。
     * 可以射出的弓箭的数量没有限制。 弓箭一旦被射出之后，可以无限地前进。我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。
     *  类似435
     * @param points points [i] = [xstart,xend]
     * @return 引爆所有气球所必须射出的最小弓箭数。
     */
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0 ){    //为空的情况排除 接下来最少需要一支箭 total = 1
            return 0;
        }
        int n = points.length;
        //区间需要根据尾结点排序
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        int total = 1, prev = points[0][1];
        boolean flag = false;
        for (int i = 1; i < n; i++) {
            if (points[i][0] <= prev) {  //加=  [1,2][2,3] 也可以用一支箭
                if(!flag){
                    flag = true;
                }
            } else {
                prev = points[i][1];
                flag = false;
                ++total;
            }
        }
        return total;
    }


    public static void main(String[] args) {
//        System.out.println(new GreedyAlgorithm().candy(new int[]{1, 3, 4, 5, 2}));
        System.out.println(new GreedyAlgorithm().canPlaceFlowers(new int[]{1, 0, 0, 0, 1},2));
    }
}
