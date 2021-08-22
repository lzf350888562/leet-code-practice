package source.leetcode.esay.string;

import java.lang.ref.SoftReference;

/**
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * @author Jinx
 * @Date 2021/3/26
 */
public class AddBinary {
	public static String addBinary(String a, String b) {
//		Long a1 = Long.valueOf(a, 2);
//		Long b1 = Long.valueOf(b, 2);
//		Long sum = a1+b1;
//		String string = Long.toBinaryString(sum);
//		return string;

		boolean flag = false;
		int i=a.length()-1;
		int j=b.length()-1;
		StringBuilder res = new StringBuilder();
		while(i>=0&&j>=0){
			if (a.charAt(i)=='0'&&b.charAt(j)=='0'){
				if (flag){
					res.insert(0,'1');
					flag = false;
				}else {
					res.insert(0,'0');
				}
			}else if(a.charAt(i)=='1'&&b.charAt(j)=='1'){
				if (flag){
					res.insert(0,'1');
				}else {
					res.insert(0,'0');
				}
				flag=true;
			}else {
				if (flag){
					res.insert(0,'0');
					flag=true;
				}else {
					res.insert(0,'1');
				}
			}
			i--;j--;
		}
		while (i>=0){
			if(a.charAt(i)=='0'){
				if (flag){
					res.insert(0,'1');
					flag=false;
				}else {
					res.insert(0,'0');
				}
			}else {
				if (flag){
					res.insert(0,'0');
				}else {
					res.insert(0,'1');
				}

			}
			i--;
		}
		while (j>=0){
			if(b.charAt(j)=='0'){
				if (flag){
					res.insert(0,'1');
					flag=false;
				}else {
					res.insert(0,'0');
				}
			}else {
				if (flag){
					res.insert(0,'0');
				}else {
					res.insert(0,'1');
				}
			}
			j--;
		}
		if (flag){
			res.insert(0,'1');
		}
		return  res.toString();
	}

	public static void main(String[] args) {
//		System.out.println(addBinary("100", "110010"));
//		System.out.println(addBinary("11", "1"));
//		System.out.println(addBinary("1", "111"));
		System.out.println(addBinary("1", "111"));
	}
}
