package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 순열 + 조합
 * 가지치기
 * 
 * */
public class SW_3234_준환이의양팔저울 {
	
	static int[] tgt, src, tgt2; //tgt자체가 right라면?
	static boolean[] isSelected, isSelected2;
	static int N, left, right, sum, tmpsum, ans, cnt, perm2cnt;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			isSelected = new boolean[N];
			src = new int[N];
			//tgt = new int[N];
			
			for (int i = 0; i < N; i++) {
				src[i] = Integer.parseInt(st.nextToken());
				sum += src[i];
			}
			//Arrays.sort(src);
			
			for (int i = 0; i < src.length; i++) {
				tmpsum = 0;
				cnt = 0;
				tgt = new int[i];
				perm(0);
			}
			
			System.out.println("#" + tc+ " " + ans);
		}
	}

	static void perm(int tgtIdx) { //가지치기 넣어라
		if (tgtIdx == tgt.length) {
			cnt++;
			
			cnt에 나머지애들 팩토리얼 곱해보셈
			
//			for (int i = 0 ; i < tgtIdx; i++) System.out.print(tgt[i] + " ");
//			System.out.println("=======");
			//나머지애들 줄세우는 횟수를 구해야함
//			isSelected2 = new boolean[src.length - tgtIdx];
//			tgt2 = new int[src.length - tgtIdx];
//			perm2(0, tgtIdx);
			
			//ans += cnt * perm2cnt;
			
			return;
		}
		
		//가지치기
		if (tmpsum > sum - tmpsum) {
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (isSelected[i]) continue;
			
			isSelected[i] = true;
			tgt[tgtIdx] = src[i];
			tmpsum += src[i];
			
			perm(tgtIdx + 1);
			tmpsum -= src[i];
			isSelected[i] = false;
		}
		
	}
	
	static void perm2(int tgtIdx, int len) {
		if (tgtIdx == len) {
			perm2cnt++;
			return;
		}
		
		for (int i = 0; i < len; i++) {
			if (isSelected2[i]) continue;
			isSelected2[i] = true;
			tgt2[tgtIdx] = i;
			perm(tgtIdx + 1);
			isSelected2[i] = false;
		}
		
	}
	
}















