package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 순열 문제
 * */
public class SW_1247_최적경로 {

	static int[] tgt;
	static boolean[] isSelected;
	static Pos[] cusList;
	static int N, min; //고객 수
	static Pos home, company; //집, 회사 좌표
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine()); //고객의 수
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			company = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())); //회사좌표
			home = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())); //집좌표
			
			cusList = new Pos[N];
			isSelected = new boolean[N];
			tgt = new int[N];
			
			for (int i = 0; i<N; i++) {
				cusList[i] = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			//입력 끝
			
			min = Integer.MAX_VALUE;
			//1. 순열 -> 모든 경우를 생각
			perm(0);
			
			System.out.println("#" + tc + " " + min);
		}

	}
	
	//기저조건에서 순열담은 tgt배열 초기화 안해줘도 됨!! 순열은 백트래킹이다!!!
	static void perm(int srcIdx) {
		if (srcIdx == N) {
			//2. 모든 거리 탐색
			check();
			return;
		}
		for (int i = 0; i < N; i++) {
			if (isSelected[i]) continue;
			
			isSelected[i] = true;
			tgt[srcIdx] = i;
			perm(srcIdx + 1);
			isSelected[i] = false;
		}
	}
	
	static void check() {
		int sum = 0;
		int sX = company.x;
		int sY = company.y;
		for (int i = 0; i < N; i++) {
			int idx = tgt[i];
			sum += Math.abs(cusList[idx].x - sX) + Math.abs(cusList[idx].y - sY);
			sX = cusList[idx].x;
			sY = cusList[idx].y;
		}
		//집이랑 거리
		sum += Math.abs(home.x - sX) + Math.abs(home.y - sY);
		min = Math.min(min, sum);
	}
	
	static class Pos{
		int y, x;
		public Pos(int x, int y) {
			this.y = y;
			this.x = x;
		}
	}
	
}
