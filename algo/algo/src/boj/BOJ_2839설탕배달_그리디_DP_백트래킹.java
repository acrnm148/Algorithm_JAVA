package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2839설탕배달_그리디_DP_백트래킹 {

	/*
	 * 1. 조합(백트래킹)
	 * 2. 그리디
	 * 3. DP
	 * */
	static int N, min;
	static int[]dp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		min = Integer.MAX_VALUE;
		/*
		//1. 조합 => 조합으로 풀면 시간초과 난다.
		comb(0, 0);
		if (min == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);
		*/
		
		/*
		//2. 그리디
		greedy();
		*/
		
		//3. dp
		dynamic();
	}
	
	//1. 조합
	static void comb(int cnt5, int cnt3) {
		int num = N - (cnt5 * 5 + cnt3 * 3);
		if (num == 0) { //성공
			min = Math.min(min, cnt3+cnt5);
			return;
		}
		if (num < 0) { //조합 실패
			return;
		}
		comb(cnt5 + 1, cnt3);	
		comb(cnt5, cnt3 + 1);
	}
	
	//2. 그리디
	static void greedy() {
		min = 0;
		while (true) {
			if (N < 0) {
				min = -1;
				break;
			}
			if (N==0) break;
			if (N % 5 == 0) {
				min = N/5 + min;
				break;
			}
			N-=3;
			min++;
		}
		System.out.println(min);
	}
	
	//3. dp
	static void dynamic() {
		//0. 준비운동---
		if (N <= 5) {
			if (N==3 || N==5) {
				System.out.println(1);
			}
			else System.out.println(-1);
		}
		dp = new int[N+1];
		Arrays.fill(dp, 5000);
		
		//1. 초기값 set
		dp[3] = 1;
		dp[5] = 1;
		//2. 반복문 안에 점화식 - 시작값 끝값 중요
		for (int i = 6; i <= N; i++) {
			dp[i] = Math.min(dp[i-3] +1, dp[i-5] +1);
		}
		//3. 출력
		if (dp[N] == 5000) System.out.println(-1);
		else System.out.println(dp[N]);
	}
	
}










