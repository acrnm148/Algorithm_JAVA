package boj2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * (+) 비트마스킹 활용
 * 알파벳 체킹을 비트마스킹으로 하면?
 * (+) BFS
 * 메모리초과 - bfs는 적절하지 않다.
 * 
 * 
 * 백트래킹
 * 처음에 bfs => 왔던길이 잘못됐을 때, 다시 돌아가는 작업이 까다롭다. 큐에 담을 때부터 지금까지의 정보를 넣어줘야함.. => 다시 돌아가는 재귀가 필요했음
 * 그래서 dfs로 바꿈 => dfs가 끝나고, 함수 밑에 원상복구해주면(늘렸던거 줄여주고 됨)
 * */
public class BOJ_1987_알파벳 {
	
	static boolean[] alpha; //visited로 썼음
	static int X, Y, cnt, max; //cnt:bfs돈 횟수
	static char[][] map;
	static int[][] map_bit; //비트마스킹 용 map
	static int[] dy = {1,-1,0,0}; //상하좌우
	static int[] dx = {0,0,-1,1};
	static Queue<Node> queue = new ArrayDeque<> (); 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		map = new char[Y][]; // new char[Y][X] 안해줘도 됨. 왜? 어차피 map[Y] 에 br.readLine().toCharArray()로 넣어줄거니까
		
		map_bit = new int[Y][X];
		for (int i = 0; i < Y; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < X; j++) {
				map_bit[i][j] = temp[j] - 'A';
			}
		}
		
		alpha = new boolean[26];
		for (int y = 0; y < Y; y++) {
			map[y] = br.readLine().toCharArray();
		}
		max = Integer.MIN_VALUE;
		bfs();
		//dfs(0,0);
		//dfs_prof(0,0, 1);
		
		//dfs -> 비트마스킹 사용
		//map_bit[0][0] --> 어떤 integer 값이 있을건데 그 값을 1을 << 연산 수행
		//map_bit[0][0] = D라면 3, 3이면, 1<<3 : 1000
		//dfs_bit(0, 0, 1, 1<<map_bit[0][0]);
		
		System.out.println(max);
	}
	
	
	static void bfs() {
		queue.add(new Node(0,0, 1, 1 <<map_bit[0][0])); //큐에 넣고 시작
		
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			max = Math.max(max, node.cnt);
			for (int i = 0; i < 4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				if (nx < 0 || nx >= X || ny < 0 || ny >= Y || (node.visit & 1<<map_bit[ny][nx]) != 0) continue; //(visit & 1<<map[ny][nx]) != 0 -> 이미 방문했다
				queue.offer(new Node(ny, nx, cnt+1, node.visit | 1<<map_bit[ny][nx]));
			}
		}
	}
	
	
	//dfs -> cnt 매개변수x
	static void dfs(int y, int x) {
		
		alpha[map[y][x] - 'A'] = true;
		cnt++; // for문 안에 있으면 마지막 dfs 호출됐을 때 마지막 한번 안돌게된다.
		if (cnt > max) max = cnt;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || nx >= X || ny < 0 || ny >= Y || alpha[map[ny][nx] - 'A']) continue;
			dfs(ny, nx);
			alpha[map[ny][nx] - 'A'] = false;
			cnt--; //이거를 그냥 매개변수에 넣어버리자, 그럼 매번 원상복구 안해줘도 된다. 이것이 dfs...
		}
		
	}
	
	//dfs -> cnt 매개변수 o
	static void dfs_prof(int y, int x, int cnt2) {

		max = Math.max(max, cnt2);
		alpha[map[y][x] - 'A'] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || nx >= X || ny < 0 || ny >= Y || alpha[map[ny][nx] - 'A']) continue;
			dfs_prof(ny, nx, cnt2+1);
			alpha[map[ny][nx] - 'A'] = false; //for문 끝나면 원상복구!!!
			//cnt--; //이거를 그냥 매개변수에 넣어버리자, 그럼 매번 원상복구 안해줘도 된다. 이것이 dfs...
		}
		
	}
	
	//비트마스킹-----------------------------------------
	static void dfs_bit(int y, int x, int cnt2, int visit) {
		
		max = Math.max(max, cnt2);
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			// 3 : 1<<3 => 000000001000
			// visit	=> 100010001001
			if (nx < 0 || nx >= X || ny < 0 || ny >= Y || (visit & 1<<map_bit[ny][nx]) != 0) continue; //(visit & 1<<map[ny][nx]) != 0 -> 이미 방문했다
			dfs_bit(ny, nx, cnt2+1, visit | 1<<map_bit[ny][nx]);
		}
		
	}
	//-----------------------------------------
	
	
	static class Node {
		int y, x, cnt, visit;
		public Node(int y, int x,  int cnt, int visit) {
			this.y = y;
			this.x = x;
			this.cnt = cnt;
			this.visit = visit;
		}
	}
}
