package source.leetcode.esay.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
 * @author Jinx
 * @Date 2021/3/27
 */
public class Generate {
	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> res = new ArrayList<>();
		for (int i = 0; i <numRows ; i++) {
			List<Integer> row = new ArrayList<>();
			if (i==0){
				row.add(1);
				res.add(row);
				continue;
			}
			if (i==1){
				row.add(1);
				row.add(1);
				res.add(row);
				continue;
			}
			for (int j = 0; j <= i; j++) {
				if (j==0){
					row.add(1);
				}else if (j==i){
					row.add(1);
				}else{
					row.add(res.get(i-1).get(j-1)+res.get(i-1).get(j));
				}
			}
			res.add(row);
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(generate(3));
	}
}
