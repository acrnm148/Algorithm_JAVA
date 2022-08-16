package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백트래킹
 * 1. 한 점 한 점 탐색, 가로를 먼저 쭉 본다
 * 2. 가로에 1을 만날 때마다 범위체크-가로세로체크 후 색종이 큰순서부터 넣어본다
 * 3. 색종이 붙였으면 2, 뗐으면 다시 1
 * 4. 가로줄 다 봤으면 다음줄로 내려가서 반복.
 * 5. 마지막점 도달했을 때 끝
 * */
public class BOJ_17136색종이붙이기 {

	static int[][] map = new int[10][10];
	static int min, size;
	static int[] paper = {0,5,5,5,5,5};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//탐색
		min = Integer.MAX_VALUE;
		dfs(0, 0, 0);
		if (min == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);
	}	
	
	static void dfs(int y, int x, int cnt) {
		//1. 기저조건 - 끝점일 때 =>끝점일 때를 먼저 봐야함
		if (y == 9 && x == 10) {
			min = Math.min(min, cnt);
			return;
		}
		// 2. 기저조건 - 가로를 다 봤을 때
		if (x == 10) {
			//test---
			System.out.println("------"); //리턴 안해주면 계속 x+1번 돈다
			
			//---
			dfs(y + 1, 0, cnt);
			return; //return 안했을 때 문제가 되는 이유는
			//위에서 x=0 으로 set해주고 한줄 한줄 넘어간다. 잘 넘어감 문제없음. 하지만 y==9가되어 위에서 리턴이 되면
			//아직 끝나지 않았던 x==10인 dfs()가 아래로 넘어가서 x+1을 실행하게 된다. 바로 런타임오류남
		}
		// 3. 기저조건 - 색종이 개수가 min보다 크거나 같을 때 => 더 볼 필요도 없다. 그 조합 죽여
		if (cnt >= min) {
			return;
		}
		
		if (map[y][x] == 1) {
			for (size = 5; size >= 1; size--) {
				if (isAttach(y, x, size) && paper[size] > 0) { //한 점 한 점 사각형 검사
					//색종이 붙이기 - 붙이면 상태 2
					attach(y, x, size, 2); //붙임
					paper[size]--; //한장 썼다
					
					dfs(y, x+1, cnt+1); //색종이 개수+1, 가로로 쭉
					//다 붙여서 (9,9) 콩 찍고오거나 조건에 안맞아서 return되어 다시 돌아왔을 때,
					//색종이를 다시 떼줌

					attach(y, x, size, 1); //다시 뗌 -> 다시 떼보고 - 그상태로 돌려보고/다시 떼보고 - 그상태로 돌려보고/다시 떼보고 - 그상태로 돌려보고...반복
					paper[size]++;
				}
			}
		}
		else
			dfs(y, x+1, cnt); //1이 아니면 그냥 오른쪽으로 쭉 넘어감 //여기서는 선택을 하냐 안하냐가 아니라 그냥 오른쪽으로 이동
		
	}
	
	static boolean isAttach(int y, int x, int size) {
		for (int i = y; i < y + size; i++) {
			for (int j = x; j < x+size; j++) {
				if (i < 0 || i >= 10 || j < 0 || j >= 10 || map[i][j] != 1) 
					return false;
			}
		}
		return true;
	}
	
	static void attach(int y, int x, int size, int state) {
		for (int i = y; i < y + size; i++) {
			for (int j = x; j < x+size; j++) {
				map[i][j] = state;
			}
		}
	}
	
}

















