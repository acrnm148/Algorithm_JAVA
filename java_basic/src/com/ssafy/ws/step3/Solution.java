package com.ssafy.ws.step3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	// static => 가독성
	// static을 통해서 전역처럼 쓸 수 있다
	static int[] dir_y = { 1, 1, 0, -1, -1, -1, 0, 1 };
	static int[] dir_x = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			char[][] arr = new char[50][50];
			int[][] height = new int[50][50];

			// input
			for (int y = 1; y <= N; y++) {
				for (int x = 1; x <= N; x++) {
					arr[y][x] = sc.next().charAt(0);
				}
			}
			// find
			int Bcnt = 0;
			for (int y = 1; y <= N; y++) {
				for (int x = 1; x <= N; x++) {
					Bcnt = 0;
					for (int i = 0; i < 8; i++) {
						int new_y = y + dir_y[i];
						int new_x = x + dir_x[i];
						if (arr[new_y][new_x] == 'G' && arr[y][x] != 'G') {
							height[y][x] = 2;
							break;
						} 
						else if (arr[new_y][new_x] != 'G' && arr[y][x] != 'G') {
							Bcnt++;
							if (Bcnt == 8) {
								// 가로
								for (int wid = 1; wid <= N; wid++) {
									if (arr[y][wid] == 'B')
										height[y][x]++;
								}
								// 세로
								for (int hei = 1; hei <= N; hei++) {
									if (arr[hei][x] == 'B')
										height[y][x]++;
								}
								if (arr[y][x] == 'B')
									height[y][x]--;
							}
						}
					}
				}
			}
			// output
			int max = 0;
			for (int y = 1; y <= N; y++) {
				for (int x = 1; x <= N; x++) {
					if (max < height[y][x])
						max = height[y][x];
				}
			}
			System.out.println("#" + t + " " + max);

		}
		sc.close();
	}
}
