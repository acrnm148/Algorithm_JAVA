package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SW_1210Ladder1 {

	static int ansX = 0;
	static int[] dir_x = {-1,0, 1}; //좌, 상, 우 
	static int[] dir_y = {0,-1, 0}; //좌, 상, 우
	static int[][] arr = new int[100][100];
	static int startX, startY; 
	//바닥에 도착하면 멈춘다
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc = 1; tc <= 10; tc++) {
			int num = Integer.parseInt(br.readLine());
			StringTokenizer st;

			//입력부
//			arr = new int[100][100];
//			for (int i = 0; i < 100; i++) {
//				st = new StringTokenizer(br.readLine());
//				for (int j = 0; j < 100; j++) {
//					arr[i][j] = Integer.parseInt(st.nextToken());
//					if (arr[i][j] == 2)
//						start = j;
//				}
//			}
			arr = new int[10][10];
			for (int i = 0; i < 10; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 10; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if (arr[i][j] == 2) {
						startY = i;
						startX = j;
					}
				}
			}
			
			//탐색
			//find(99,start);
			//find(9,start);
			while (true) {
				for (int i = 0; i < 3; i++) {
					int nextY = startY + dir_y[i];
					int nextX = startX + dir_x[i];
//					if (nextY >= 0 && nextY < 100 && nextX >= 0 && nextX < 100) {
					if (nextY >= 0 && nextX >= 0 && nextX < 10 && arr[nextY][nextX] == 1) {
						
							
					}
				}
				
			}
			
			System.out.println("#"+tc + " " + ansX);
		}
	}
	
	
	static void find(int startY, int startX) {
		
		//1. 기저조건
//		if (startY == 0) {
//			ansX = startX;
//			System.out.println(ansX);
//			return;
//		}
		
		//2. 재귀
		for (int i = 0; i < 3; i++) {
			int nextY = startY + dir_y[i];
			int nextX = startX + dir_x[i];
//			if (nextY >= 0 && nextY < 100 && nextX >= 0 && nextX < 100) {
			if (nextY >= 0 && nextY < 10 && nextX >= 0 && nextX < 10) {
				if (arr[nextY][nextX] == 1)
					find(nextY, nextX);
			}
		}
	}

}
