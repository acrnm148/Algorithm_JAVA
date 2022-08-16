package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1074Z {

	static int N, Y, X, cnt;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		int end = 2^N;
		
		divide(0, 0, end);
	}
	
	static void divide( int y, int x, int size) {
		if (size == 1) {
			System.out.println(cnt);
			return;
		}
		int newSize = size/2;
		if (Y < y + newSize && X < x + newSize) {
			divide(y, x, newSize);
		}
		if (Y < y + newSize && X >= x + newSize) {
			divide(y, x, newSize);
		}
		if (Y < y + newSize && X < x + newSize) {
			divide(y, x, newSize);
		}
		if (Y < y + newSize && X < x + newSize) {
			divide(y, x, newSize);
		}
		
	}
}
