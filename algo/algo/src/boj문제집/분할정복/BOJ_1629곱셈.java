package boj문제집.분할정복;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 지수법칙, 모듈러연산
 * 1. 지수법칙 	: a^(n+m) = a^n*a^m
 * 2. 모듈러연산 	: (a*b)mod c = (a mod c * b mod c) mod c
 * */
public class BOJ_1629곱셈 {

	static int A, B, C, ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		calc(A, 0);
		System.out.println(ans);
	}
	
	static void calc(int num, int cnt) {
		if (cnt == C) {
			ans = num;
			return;
		}
		
		calc((A%C*num%C)%C, cnt+1);
	}
}
