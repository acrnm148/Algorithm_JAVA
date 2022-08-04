package basic;

import java.util.Arrays;

public class BASIC_Perm {
	
	static int cnt = 0;
	static int[] src = {1,2,3,4,5};
	static int[] tgt = new int[3]; //
	
	//중복 허용안함
	//tgt에 중복이 생기지 않도록
	static boolean[] select = new boolean[src.length];
	public static void main(String[] args) {
		
		perm(0);
		System.out.println(cnt);
	}
	
	static void perm(int tgtIdx) {
		//순열 완성(기저조건)
		//현재 호출 전까지 이미 마무리
		if (tgtIdx == tgt.length) {
			System.out.println(Arrays.toString(tgt));
			cnt++;
			return;
		}
		
		//tgt는 현재 tgtIdx에, src는 모든 수를 고려 0 ~ src.length - 1
		for (int i = 0; i < src.length; i++) {
			//이미 이전tgt에 선택된 인덱스는 제외
			if (select[i]) continue;
			//선택
			tgt[tgtIdx] = src[i];
			select[i] = true;
			//다음 자리 tgt 채우기
			perm(tgtIdx + 1); //이 재귀호출이 끝나면 for문의 다음 i로 이동
			select[i] = false; //다음 i의 src를 고려하기 위해 
		}
	}
}
