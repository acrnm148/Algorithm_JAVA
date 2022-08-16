package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 백트래킹?
 * */
public class BOJ_2839설탕배달 {

	static int tmp = 0;
	static int num, N, min;
	static int result = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		//way1();
		comb(0,0);
		min = 5000;
		System.out.println(min);
	}
	
	static void way1() {
		num = N;
		if (N % 15 == 0) result = N / 5;
		else if (N >= 5) {
			for (int i = 1; i <= N / 5; i++) {
				num = num - 5;
				if (num % 3 == 0) tmp = num;
			}
			result = tmp / 3 + (N - tmp) / 5;
			if (tmp == 0) {
				if (N % 3 == 0) result = N / 3;
				else if (N % 5 == 0) result = N / 5;
				else result = -1;
			}
		}
		else if (N == 3) result = 1;
		else result = -1;

		System.out.println(result);
	}
	
	//완전탐색
	static void comb(int five, int three) {
		int sum = five*5 + three*3;
		if (sum == N) {
			min = Math.min(min, five+three);
			return;
		} 
		if (sum > N) {
			return;
		}
		
		comb(five+1, three);
		comb(five, three+1);
	}
}
