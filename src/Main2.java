import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Scanner;

/**
 * @author hunnu/lzf
 * @Date 2021/3/10
 */
public class Main2 {
	private final static int N=200;
	private static BitSet bitSet;

	public static void main(String[] args) {
		try(Scanner in = new Scanner(System.in)){
			String string = in.next();
			int c = string.indexOf(",");
			int[][] matrix = new int[c][c];
			for (int i = 0; i < c; i++) {
				for (int j = 0; j <c ; j++) {
					matrix[i][j]=Integer.parseInt(string.substring(i*(c+1)+j,i*(c+1)+j+1));
				}
			}
			setRound(matrix,c);
			int maxN=fun(matrix,c);
			System.out.println(maxN);
		}
	}
	private static int fun(int[][] matrix,int c){
		int n=0;
		for (int i = 0; i < c; i++) {
			if (!bitSet.get(i)){
				n++;
				bitSet.set(i);
			}
		}
		return n;
	}
	private static void setRound(int[][] matrix,int c) {
		for (int i = 0; i < c; i++) {
			for (int j = 0; j < c; j++) {
				
			}
		}
	}
}
