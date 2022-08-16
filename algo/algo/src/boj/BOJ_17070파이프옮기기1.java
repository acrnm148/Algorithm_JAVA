package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17070파이프옮기기1 {

	static int[] dy = {0, 1, 1}; //오른쪽-오른쪽아래-아래
	static int[] dx = {1, 1, 0};
	static int[][] map;
	static boolean[][] visited;
	static int N, ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//dfs
		dfs(0, 1, 0); //0,1부터 시작
		
		//bfs
		bfs();
		
		System.out.println(ans);
	}
	
	static void dfs(int y, int x, int d) {
		if (y == N-1 && x == N-1) { //사실 있으나 마나한 기저조건이지만, 밑에 다 보고 종료되므로 어차피 종료될 상황이니 여기서 컷
			ans++;
			return;
			//return 없으면 1.605ms
			//return 있으면 0.9056ms ==> 확실히 덜 돌아서 시간복잡도 덜 나옴
		}
		
		for (int i = 0; i < 3; i++) {
			if ((d == 0 && i == 2) || (d == 2 && i == 0)) continue; //방향 제한
			
			//벽 조건
			if (i == 1) { //대각선 방향일 때
				if (x+1 < N && map[y][x+1] == 1) continue; //오른쪽에 벽
				if (y+1 < N && map[y+1][x] == 1) continue; //아래에 벽
			}
			
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny < 0 || ny >= N || nx < 0 || nx >= N || map[ny][nx] == 1) continue; //갈 곳에 벽있으면 넘김
			dfs(ny, nx, i);
		}
	}
}
