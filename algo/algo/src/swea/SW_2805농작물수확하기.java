package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_2805농작물수확하기 {

	static int[][] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			
			//입력부
			int N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				char[] temp = br.readLine().toCharArray();
				for (int j = 0; j < N; j++) {
					arr[i][j] = temp[j] - '0';
				}
			}
			
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < N; x++) {
					System.out.print(arr[y][x]);
					
				}
				System.out.println();
			}
			
			//탐색
			int start = 0;
			int end = 0;
			int sum = 0;
			int cnt = 0;
			int midX = N/2;
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < N; x++) {
					while (y < N/2) {
						start = midX - cnt;
						end = midX + cnt;
						cnt++;
					}
					cnt--;
					while (y >= N/2 && y < N && cnt >= 0) {
						start = midX - cnt;
						end = midX + cnt;
						cnt--;
					}
				}
				
			}
			System.out.println("#" + tc + " " + cnt);
		}
	}

}
