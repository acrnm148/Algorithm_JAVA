package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1992쿼드트리 {

	static int N, state;
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
		//1. 맨 처음 체크 먼저 해줘야함
		state = check(0, 0, N);
		if (state == 0) System.out.print(0);
		else if (state == 1) System.out.print(1); 
		else zip(0, 0, N);
		
	}

	
	static void zip(int y, int x, int size) {
		if (size == 1) {
			//끝
			return;
		}
		
		size /= 2;
		
		System.out.print("(");
		//1구역
		state = check(y, x, size);
		if (state == 0) System.out.print(0);
		if (state == 1) System.out.print(1); 
		if (state == 2) zip(y, x, size); //1구역 보낸다 
		
		//2구역
		state = check(y, x+size, size);
		if (state == 0) System.out.print(0);
		if (state == 1) System.out.print(1); 
		if (state == 2) zip(y, x+size, size); //2구역 보낸다
		
		//3구역
		state = check(y+size, x, size);
		if (state == 0) System.out.print(0);
		if (state == 1) System.out.print(1); 
		if (state == 2) zip(y+size, x, size); //3구역 보낸다
		
		//4구역
		state = check(y+size, x+size, size);
		if (state == 0) System.out.print(0);
		if (state == 1) System.out.print(1); 
		if (state == 2) zip(y+size, x+size, size); //4구역 보낸다
		
		System.out.print(")");
	}
	
	static int check(int y, int x, int size) {
		boolean is0 = false;
		boolean is1 = false;
		int res = -1;
		for (int i = y; i < y+size; i++) {
			for (int j = x; j < x+size; j++) {
				if (map[i][j] == 0) is0 = true;
				if (map[i][j] == 1) is1 = true;
			}
		}
		if (is0 && is1) res = 2; //0과 1이 섞였다
		else if (is0 && !is1) res = 0; //0만 있다
		else if (!is0 && is1) res = 1; //1만 있다
		return res;
	}
	
}
















