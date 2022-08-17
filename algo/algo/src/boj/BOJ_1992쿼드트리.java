package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1992쿼드트리 {

	static int N;
	static int[][] map;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		//입력끝
		
		check();
		
		
	}

	
	static void check() {
		
		
	}
}
