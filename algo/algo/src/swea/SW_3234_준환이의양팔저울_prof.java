package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 시간초과남~~
 * 
 * */
public class SW_3234_준환이의양팔저울_prof {
	
	static int[] choo; //tgt자체가 right라면?
	static boolean[] select;
	static int N, T, ans;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			select = new boolean[N];
			choo = new int[N];
			
			for (int i = 0; i < N; i++) {
				choo[i] = Integer.parseInt(st.nextToken());
			}
			ans = 0;
			perm(0, 0, 0);
			
			System.out.println("#" + tc+ " " + ans);
		}
	}

	static void perm(int tgtIdx, int leftSum, int rightSum) { //가지치기 넣어라
		if (tgtIdx == N) {
			ans++;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (select[i]) continue;
			select[i] = true;
			//2가지 재귀호출
			//#1 왼쪽에 추를 올리는 경우
			perm(tgtIdx + 1, leftSum+choo[i], rightSum);
			
			
			//#2 오른쪽에 추를 올리는 경우
			if (leftSum >= rightSum + choo[i]) {
				perm(tgtIdx + 1, leftSum, rightSum+choo[i]);
			}
			select[i] = false;
		}
		
	}
	
}















