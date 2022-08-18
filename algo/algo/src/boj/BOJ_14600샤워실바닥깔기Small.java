package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 분할정복
 * */
public class BOJ_14600샤워실바닥깔기Small {

	static int N, Y, X, num;
	static int[][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		X = Integer.parseInt(st.nextToken())-1;
		Y = Integer.parseInt(st.nextToken())-1;
		//N = (int)Math.pow(2, N); 
		N = 1<<N;
		map = new int[N+1][N+1];
		
		//초기값
		num = 1;
		map[Y][X] = -1;
		
		//0 dummy, 탐색 시작점:(1, y+size)
		divide2(1,1,N);
		
		//출력
		for (int i = 1; i <= N; i++) {
			for (int j  = 1; j <= N; j++)
				System.out.print(map[i][j]);
			System.out.println();
		}
	}
	
	//정사각형이 모두 비어있는지를 체크
	static boolean check (int y, int x, int size) {
		
		for (int i = y; i < y+size; i++) {
			for (int j = x; j < x+size; j++) {
				if (map[i][j] != 0) return false;
			}
		}
		return true;
	}
	//분할정복
//	static void divide(int y, int x, int size) {
//		size/=2;
//		//사각형이 모두 비어있다면, 한 칸 제외
//		if (check(y, x, size)) map[y+size-1][x+size-1] = num; //왜 이 칸을 제외하지?
//		if (check(y, x+size, size)) map[y+size-1][x+size-1] = num;
//		if (check(y+size, x, size)) map[y+size-1][x+size-1] = num;
//		if (check(y+size, x+size, size)) map[y+size-1][x+size-1] = num;
//		
//		if (size == 2) return;
//		
//		divide(y, x, size);
//		
//	}
	
	
	static void divide2(int y, int x, int s) {
		int size = s/2;
		num++;
		
		if (check(y, x, size)) map[y+size-1][x+size-1] = num; //1구역
		if (check(y, x+size, size)) map[y+size-1][x+size] = num; //2구역
		if (check(y+size, x, size)) map[y+size][x+size-1] = num; //3구역
		if (check(y+size, x+size, size)) map[y+size][x+size] = num; //4구역

		if (size == 2) return;
		
		divide2(y, x, size);
		divide2(y, x+size, size);
		divide2(y+size, x, size);
		divide2(y+size, x+size, size);
	}
	
	
}



















