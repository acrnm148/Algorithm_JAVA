package basic.chap2;

import java.util.Arrays;

public class BASIC_Comb2 {
	
	static int cnt = 0;
	static int[] src = {1,2,3,4,5};
	static int[] tgt = new int[3]; //
	
	public static void main(String[] args) {
		
		comb(0, 0); // 앞src, 뒤tgt
		System.out.println(cnt);
	}
	
	static void comb(int srcIdx, int tgtIdx) { //srcIdx = tgtIdx에 선택, 비선택 2가지 경우
		//기저조건 tgt
		if (tgtIdx == tgt.length) {
			System.out.println(Arrays.toString(tgt));
			cnt++;
			return;
		}
		
		//기저조건 src
		if (srcIdx == src.length) return;
		
		//선택
		tgt[tgtIdx] = src[srcIdx];
		
		comb(srcIdx + 1, tgtIdx + 1); //현재 선택(tgtIdx <- srcIdx)을 만족하고 다음 선택을 하러 재귀
		comb(srcIdx + 1, tgtIdx); // 현재 선택 (tgtIdx <- srcIdx) 만족x, 여전히 tgtIdx <- srcIdx+1
	}
	
}
