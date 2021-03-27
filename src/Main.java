import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;


/**
 * 一圈n个人 数到m的退出
 * 求最后退出的人
 */
public class Main {
	public static void main(String[] args) {
		System.out.println(fun(4, 3));
	}

	public static int fun(int n, int m) {
		BitSet bitSet = new BitSet();
		for (int i = 1; i <= n; i++) {
			bitSet.set(i);
		}
		int nums = n;
		for (int i = 1, m1 = 1; nums == 1; ) {
			if (m1 == m) {
				nums--;
				bitSet.clear(i);
			}
			i++;
			if (i > n) {
				i = i % n;
			}
			while (!bitSet.get(i)) {
				i++;
				if (i > n) {
					i = i % n;
				}
			}
			m1++;
			if (m1 > m) {
				m1 = 1;
			}
		}
		int index = 0;
		for (int i = 1; i <= n; i++) {
			if (bitSet.get(i)) {
				index = i;
				break;
			}
		}
		return index;
	}
}
