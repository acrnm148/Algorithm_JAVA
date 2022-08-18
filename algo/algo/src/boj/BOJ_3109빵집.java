package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;


/*
 * 연결할 수 있는걸 우선 연결해놓고 
 * 그다음으로 연결해야 함
 * 가짓수가 아니라, 하나를 놓고 동시에 연속적으로 설치하는 문제
 * */
public class BOJ_3109빵집 {
	
	static HashSet<Integer> arr = new HashSet<>();
	static int[] dy = {-1, 0, 1}; //오위대-오-오밑대 => 방문의 순서가 중요함
	static int[] dx = {1, 1, 1}; 
	static boolean[][] visited;
	static char[][] map;
	static int X, Y, cnt;
	static boolean state;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		map = new char[Y][X];
		visited = new boolean[Y][X];
		for (int i = 0; i < Y; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for (int i = 0; i < Y; i++) {
			dfs(i, 0);
			//dfs2(i, 0);
		}
		
		System.out.println(cnt);
	}
	
	
	//왜 이렇게 해야하는거??
	static boolean dfs(int y, int x) {
		//가위
		if (x == X-1) {
			cnt++;
			return true;
		}
		
		for (int i = 0; i < 3; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny < 0 || ny >= Y || nx < 0 || nx >= X || map[ny][nx] == 'x') continue;
			map[ny][nx] = 'x'; //실패했어도 방문기록 남는다. => 다시 방문해도 실패할 것이기 때문에.
			
			if (dfs(ny, nx)) return true; //dfs가 true를 리턴하면 가지치기도 더 이상 보지 않는다 => 다음 y줄로 넘어감
		}
		return false;
	}
	
	
	//이 코드가 통과할 수 없는 이유 : 가지치기하고 계속 돌아감
	 static void dfs2(int y, int x) {
		//가위
		if (x == X-1) {
			cnt++;
			return;
		}
		
		for (int i = 0; i < 3; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny < 0 || ny >= Y || nx < 0 || nx >= X || map[ny][nx] == 'x') continue;
			map[ny][nx] = 'x';
			dfs2(ny, nx);
			if (map[ny][nx] == 'x') return;
		}
		
	}
	
}
 