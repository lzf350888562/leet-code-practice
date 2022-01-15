package source.leetcode.type.dp;

import java.util.Arrays;

/**
 * 887. 鸡蛋掉落
 * 给你 k 枚相同的鸡蛋，并可以使用一栋从第 1 层到第 n 层共有 n 层楼的建筑。
 * 已知存在楼层 f ，满足0 <= f <= n ，任何从 高于 f 的楼层落下的鸡蛋都会碎，从 f 楼层或比它低的楼层落下的鸡蛋都不会破。
 * 每次操作，你可以取一枚没有碎的鸡蛋并把它从任一楼层 x 扔下（满足1 <= x <= n）。如果鸡蛋碎了，你就不能再次使用它。如果某枚鸡蛋扔下后没有摔碎，则可以在之后的操作中 重复使用 这枚鸡蛋。
 * 请你计算并返回要确定 f 确切的值 的 最小操作次数 是多少？
 *
 * 类似问题有扔杯子,扔碗等
 * 这里给你了鸡蛋个数的限制 K ，不能使用二分
 */
public class SuperEggDrop {
    /**
     * 动态规划
     * 状态: 当前拥有的鸡蛋数K和需要测试的楼层数N
     * 选择: 去选择哪层楼扔鸡蛋
     */
    public int superEggDrop(int k, int n) {
        int[][] forget = new int[k+1][n+1];
        for (int i = 0; i < forget.length; i++) {
            Arrays.fill(forget[i],Integer.MAX_VALUE);
        }
        return dp(k,n,forget);
    }
    private int dp(int k, int n,int[][] forget){
        //base case
        if( k == 1) return n; //当鸡蛋数K为 1 时，只能线性扫描所有楼层
        if( n == 0) return 0;//当楼层数N等于 0 时，不需要扔
        if(forget[k][n] != Integer.MIN_VALUE){ //避免重复执行子任务
            return forget[k][n];
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < n + 1; i++) {
            res = Math.min(res,Math.max(dp(k,n-i,forget),dp(k-1,i-1,forget))+1);
        }
        if(res != Integer.MAX_VALUE){   //备忘
            forget[k][n] = res;
        }
        return res;
    }
}
