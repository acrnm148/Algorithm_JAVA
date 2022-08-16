package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 백트래킹?
 * */
public class BOJ_2839설탕배달2 {

	static int N, cnt;
	static int result = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		cnt = 0;
		while (true) {
			if (N < 0) {
				System.out.println(-1);
				break;
			}
			if (N % 5 == 0) {
				System.out.println(N/5 + cnt);
				return;
			}
			else {
				N -=3;
				cnt++;
			}
		}

		
	}
	
}
