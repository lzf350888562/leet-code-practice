package source.leetcode.esay.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 获取杨辉三角形指定行
 * @author Jinx
 * @Date 2021/3/27
 */
public class GenerateRow {
	public List<Integer> getRow(int rowIndex) {
		List<Integer> res = new ArrayList<>(rowIndex + 1);
		long cur = 1;
		for (int i = 0; i <= rowIndex; i++) {
			res.add((int) cur);
			cur = cur * (rowIndex-i)/(i+1);
		}
		return res;
	}
}
