package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 조합
 * */
public class BOJ_17135캐슬디펜스 {

	static int N, M, limit, max, cnt; // cnt:죽인횟수
	static int[][] map;
	static int[] tgt, src;
	static boolean isFinish; //공격이 끝났나?
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		limit = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][M];
		for (int i = 0; i < N; i++) { //성 줄에는 아직 아무것도 없음
			if (i < N) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
		}
		
		//성 칸 M칸 중 k 칸 선택
		comb(0, 0);
		protect(  );
	}
	
	static void comb(int srcIdx, int tgtIdx) {
		//1. 기저조건 - tgt이 다 찼을 때
		if (tgtIdx == tgt.length) {
			return;
		}
		//2. 기저조건 - src를 다 봤을 때
		if (srcIdx == src.length) return;
		
		//3. tgt에 src 넣어줌
		tgt[tgtIdx] = srcIdx;
		
		//4. 선택이냐 선택아니냐
		comb(srcIdx + 1, tgtIdx + 1); //선택
		comb(srcIdx + 1, tgtIdx); // 선택아니냐
	}
	
	static void protect() {
		//1. 궁수 위치 set 해줌, 궁수:2
		for (int i = 0; i < tgt.length; i++) {
			int idx = tgt[i];
			map[N][idx] = 2;
		}
		
		//공격시작
		for(int i = N-1; i >= 0; i--) { //map에 적이 없을 때 return
			//rule
			
			for (int j = 0; j < M; j++) { //기준 : 적
				if (map[i][j] == 1) {
					for (int tgtIdx = 0; tgtIdx < 3; tgtIdx++) { //궁수 3명과의 거리 탐색
						int dist = Math.abs(N - i) + Math.abs(tgt[tgtIdx] - j);
						if (dist <= limit) { //한번이라도 거리 안에 궁수가 있으면 죽음
							map[i][j] = 0;
							cnt++;
						}
					}
				}
				
			}
			
			//map change
			if (i-1 >= 0) { //i==0이면 마지막판이라서 for문도 끝난다
				map[i] = map[i-1]; //공격 한번 끝 -> 적 한칸 아래로 이동
				for (int j = 0; j < M; j++) {
					map[i-1][j] = 0;
				}
			}
		}
		
	}
}
