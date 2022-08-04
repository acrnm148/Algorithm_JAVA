package basic.chap2;

import java.util.Arrays;

public class BASIC_Comb {
	
	static int cnt = 0;
	static int[] src = {1,2,3,4,5};
	static int[] tgt = new int[3]; //
	
	public static void main(String[] args) {
		
		comb(0, 0); // 앞src, 뒤tgt
		System.out.println(cnt);
	}
	
	static void comb(int srcIdx, int tgtIdx) {
		//기저조건
		if (tgtIdx == tgt.length) {
			System.out.println(Arrays.toString(tgt));
			cnt++;
			return;
		}
		
		//현재 srcIdx 수 부터 남은 수 체크
		//현재 srcIdx 수를 tgt에 넣을것인가 말것인가
		for (int i = srcIdx; i < src.length; i++) { //srcIdx가 2 => 3, 4, 5
			tgt[tgtIdx] = src[i]; //선택
			comb(i+1, tgtIdx+1); //다음수
			
			//for문 반복 과정에서 src는 선택과 비선택이 반복 => i가 증가하면서 이전 i의 선택이 취소됨
		}
	}
	
}
