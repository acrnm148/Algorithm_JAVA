package boj문제집.브루트포스_백트래킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15649_N과M1 {

	static int[] tgt;
	static boolean[] isSelected;
	static int N, M;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		isSelected = new boolean[N+1];
		tgt = new int[M];
		perm(0);
		
	}
	
	static void perm(int tgtIdx) {
		if (tgtIdx == M) {
			int idx = 0;
			for (int i = 0; i < M; i++) {
				System.out.print(tgt[i] + " ");
			}
			System.out.println();
			return;
		}
		
		
		//줄세우기
		for (int i = 1; i <= N; i++) {
			if (isSelected[i]) continue; //이미 쓰고있는 수면 넘기고
			tgt[tgtIdx] = i;
			isSelected[i] = true; //사용중
			
			perm(tgtIdx+1);
			isSelected[i] = false;
		}
		
	}
}
