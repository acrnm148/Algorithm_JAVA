package basic.chap2;

import java.util.Arrays;

//부분집합
public class BASIC_Subset {
	
	static int cnt = 0;
	static int[] src = {1,2,3,4,5};
	//					o o
	//					o x
	//					x o
	//					x x
	//각 자리수(각 idx)의 수를 선택, 비선택 모두 따져주면 된다 <= select 배열
	//tgt 없다
	
	static boolean[] select = new boolean[src.length];
	
	public static void main(String[] args) {
		
		subset(0); 
		System.out.println(cnt);
	}
	
	static void subset(int srcIdx) {
		//기저조건
		if (srcIdx == src.length) {
			//complete code <= select 배열의 현재 상태
			printSubset();
			cnt++;
			return;
		}
		
		select[srcIdx] = true; //선택
		subset(srcIdx + 1);		//다음선택
		
		
		select[srcIdx] = false; //비선택
		subset(srcIdx + 1);		//다음선택
		
	}
	
	static void printSubset() {
		System.out.print("{");
		for (int i = 0; i < select.length; i++) {
			if (select[i]) System.out.print(src[i] + " ");
		}
		System.out.print("}");
		System.out.println();
	}
}
