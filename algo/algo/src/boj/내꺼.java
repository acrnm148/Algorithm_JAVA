import java.util.Scanner;

public class Solution {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int[][] arr = new int[16][16];
			//판 입력
			int N = sc.nextInt();
			int M = sc.nextInt();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			//완전탐색
			int max = 0;
			for (int y = 0; y <= N - M; y++) {
				for (int x = 0; x <= N - M; x++) {
					int sum = 0;
					for (int i = 0; i < M; i++) {
						for (int j = 0; j < M; j++) {
							sum += arr[y+i][x+j];
						}
					}
					if (max < sum)
						max = sum;
				}
			}
			System.out.println("#"+t+" "+max);
		}
	}
}
