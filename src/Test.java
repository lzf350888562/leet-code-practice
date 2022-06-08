import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BinaryOperator;

/**
 * @author hunnu/lzf
 * @Date 2021/3/10
 */
public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int[] array1 = new int[n1];
		for(int i = 0; i < n1; i++){
			array1[i] = sc.nextInt();
		}
		int n2 = sc.nextInt();
		int[] array2 = new int[n2];
		for(int i = 0; i < n2; i++){
			array2[i] = sc.nextInt();
		}
		int k = sc.nextInt();
		int side = 0;
		int minSum = 0;
		for(int i1=0,i2=0; i1<n1&&i2<n2; ){
			minSum += array1[i1] + array2[i2];
			if(side != 0){
				if(side == 1){
					i1++;
					side = 2;
				}else{
					i2++;
					side = 1;
				}
			} else{
				if(array1[i1+1] <= array2[i2+1]){
					i1++;
					side = 1;
				}else{
					i2++;
					side = 2;
				}
			}
		}
		 String a = "adsad";

	}
}
