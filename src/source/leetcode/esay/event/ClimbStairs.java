package source.leetcode.esay.event;

/**
 * 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * @author Jinx
 * @Date 2021/3/26
 */
public class ClimbStairs {
	/**
	 * 第n个台阶只能从第n-1或者n-2个上来。
	 * 到第n-1个台阶的走法 + 第n-2个台阶的走法 = 到第n个台阶的走法，已经知道了第1个和第2个台阶的走法，一路加上去。
	 */
	public static int climbStairs(int n) {
		if(n<=2){
			return n;
		}
		int i1 = 1;
		int i2 = 2;
		for(int i=3;i<=n;i++){
			int temp = i1+i2;
			i1 = i2;
			i2 = temp;
		}
		return i2;
	}

	public static void main(String[] args) {
		System.out.println(climbStairs(4));
	}
}
