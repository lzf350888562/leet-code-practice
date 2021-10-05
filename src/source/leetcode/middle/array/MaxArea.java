package source.leetcode.middle.array;

/**
 * 盛水最多的容器
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * @author lzf
 * @date 2021/10/5
 */
public class MaxArea {
    public int maxArea(int[] height) {
        int area = 0;
        for (int i = 0,j = height.length-1; i < j ; ) {
            int h = Math.min(height[i],height[j]);
            area = Math.max(area,h*(j-i));
            if(height[i] < height[j]){
                i++;
            }else {
                j--;
            }
        }
        return area;
    }
    
    public static void main(String[] args) {
        System.out.println(new MaxArea().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
