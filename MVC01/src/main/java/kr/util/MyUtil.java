package kr.util;

public class MyUtil {
	public int hapN(int n) {
		int sum = 0;
		for(int i = 1; i <= n; i++) {
			sum += i;
		}
		return sum;
	}
	
	public int hapN(int n1, int n2) {
		int sum = 0;
		if (n1 > n2) {
			int temp = n1;
			n1 = n2;
			n2 = temp;
		}
		
		for(int i = n1; i <= n2; i++) {
			sum += i;
		}
		return sum;
	}
}
