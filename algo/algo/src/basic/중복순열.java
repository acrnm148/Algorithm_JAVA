package basic;

import java.util.Arrays;

public class 중복순열 {
	
	static int totalCnt, len;
	static int[] input = {1,2,3,4,5};
	static int[] tmp = new int[3];
	//static boolean[] selected = new boolean[input.length];
	
	public static void main(String[] args) {
		perm(0);
		System.out.println("총 경우의 수 : " + totalCnt);
	}
	
	static void perm(int idx) {
		//기저조건
		if (idx == tmp.length) {
			totalCnt++;
			System.out.println(Arrays.toString(tmp));
			return;
		}
		
		for (int i = 0; i < input.length; i++) {
			tmp[idx] = input[i];
			
			perm(idx + 1);
			
		}
		
	}
}
