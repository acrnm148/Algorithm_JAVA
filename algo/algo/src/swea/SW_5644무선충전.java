package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * !! 구하고싶은 것 : 모든 사용자가 충전한 양의 합의 최댓값
 * 
 * 1. 매 초마다 이동, 충전 범위에 들어오면 충전. -> 충전양 = bc 성능
 * 2. 한 충전기 범위에 A,B 둘다 존재? 그럼 A충전양
 * 
 * 
 * 
 * 
 * 
 * */
public class SW_5644무선충전 {

	static int time, bcCnt, range;
	static int[][] map = new int[11][11];
	static int[][] bc;
	static int[] A, B;
	static int[] dy  = {0, 1, 0, -1, 0}; // 이동X-상-우-하-좌
	static int[] dx  = {0, 0, 1, 0, -1}; // 이동X-상-우-하-좌
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		time = Integer.parseInt(st.nextToken());  //이동시간
		bcCnt = Integer.parseInt(st.nextToken()); //충전기 개수
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < time; i++) { //사용자A
			A[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < time; i++) { //사용자B
			B[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < bcCnt; i++) { //충전기
			st = new StringTokenizer(br.readLine());
			bc[i][0] = Integer.parseInt(st.nextToken()); //x
			bc[i][1] = Integer.parseInt(st.nextToken()); //y
			bc[i][2] = Integer.parseInt(st.nextToken()); //충전범위
			bc[i][3] = Integer.parseInt(st.nextToken()); //처리량
			int x = bc[i][0];
			int y = bc[i][1];
			map[y][x] = i+1;
			
		}
		
		//지도에 bc의 충전 범위 색칠해둠
//		int[] tmpy = {1,-1,0,0}; //상-하-좌-우
//		int[] tmpx = {1,-1,0,0}; //상-하-좌-우
		
		for (int i = 1; i <= 10; i++) {
			for (int j = 1; j <= 10; j++) {
				check(i, j); //한 지점마다 3번씩 체크->사정권 안에 있으면 체크해라
				//여기까지 했으면 map에 bc색칠돼있음
			}
		}
		
		//move
		move();
	
	}
	
	static void check(int i, int j) {
		
		int[] tmpy = {1,-1,0,0}; //상-하-좌-우
		int[] tmpx = {1,-1,0,0}; //상-하-좌-우
		int gap = 0; // 현재 지점(map[][])과 주위에 bc들 거리 계산했을 때 범위 안에 있으면 색칠해라
		
		for (int c = 0; i < bcCnt; i++) {

			int x = bc[i][0];
			int y = bc[i][1];
			gap = Math.abs(i - x) + Math.abs(j - y);
			if (gap <= bc[i][2]) {
				if(map[i][j] == 0) map[i][j] = bc[i][2];
				else {
					map[i][j] = -1; //일단 -1 넣어둠 중복된다는 표시
				}
			}
		}
		
	}
	
	static void move() {
		boolean s_a = false;
		boolean s_b = false;
		int aX = 1, aY = 1; 
		int bX = 10, bY = 10;
		for (int i = 0; i <time; i++) {
			//A
			int naY = aY+dy[A[i]];
			int naX = aX+dx[A[i]];
			if (!(naY <= 0 || naY > 10 || naX <= 0 || naX > 10)) {
				//할일
				if (map[naY][naX] != 0) {
					s_a = true;
					
					
				}
			}
			//B
			int nbY = bY+dy[B[i]];
			int nbX = bX+dx[B[i]];
			if (!(nbY <= 0 || nbY > 10 || nbX <= 0 || nbX > 10)) {
				//할일
				if (map[nbY][nbX] != 0) {
					s_b = true;
					
					
				}
			}
			
			
		}
		
		
	}
	
}
