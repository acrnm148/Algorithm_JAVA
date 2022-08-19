package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 성공코드
 * 
 * */
public class SW_3234_준환이의양팔저울_prof_비트마스킹 {
	
	static int N, T, ans;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int[] choo = new int[N];
			boolean[] select = new boolean[N];
			
			for (int i = 0; i < N; i++) {
				choo[i] = Integer.parseInt(st.nextToken());
			}
			ans = 0;
			perm(choo, select, 0, 0, 0);
			
			System.out.println("#" + tc+ " " + ans);
		}
	}

	static void perm(int[] choo, boolean[] select, int tgtIdx, int leftSum, int rightSum) { //가지치기 넣어라
		if (rightSum > leftSum) return;
		if (tgtIdx == N) {
			ans++;
			return;
		}
		
		for (int i = 0; i < choo.length; i++) { //N하니까 시간초과 => choo.length로 변경
			if (select[i]) continue;
			select[i] = true;
			//2가지 재귀호출
			//#1 왼쪽에 추를 올리는 경우
			perm(choo, select, tgtIdx + 1, leftSum+choo[i], rightSum);
			
			
			//#2 오른쪽에 추를 올리는 경우
			perm(choo, select, tgtIdx + 1, leftSum, rightSum+choo[i]);
			
			select[i] = false;
		}
		
	}
	
}















