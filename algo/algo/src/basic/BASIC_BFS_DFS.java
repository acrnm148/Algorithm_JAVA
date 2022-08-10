package basic;

import java.util.ArrayDeque;
import java.util.Queue;

public class BASIC_BFS_DFS {

	static int[][] map = {
			  	{0,  0,  0,  0,  0,  0,  0}, //row0
		        {0, 11, 12, 13, 14, 15, 16}, //row1
		        {0, 21, 22, 23, 24, 25, 26},
		        {0, 31, 32, 33, 34, 35, 36},
		        {0, 41, 42, 43, 44, 45, 46},
		        {0, 51, 52, 53, 54, 55, 56},
		        {0, 61, 62, 63, 64, 65, 66}, //0 dummy
	};
	
	//delta : 상-하-좌-우
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	//visited 재방문 체크
	static boolean[][] visit;
	static int COUNT;
	public static void main(String[] args) {
		//bfs 초기화하고 시작해도 됨
		//bfs(1, 1);
		
		visit = new boolean[7][7];
		dfs(1, 1);
		System.out.println("cnt:"+COUNT);
	}
	
	static void dfs(int y, int x) {
		//메소드 밖에서 초기화해야함.
		
		//1. 방문표시 남기고 시작
		visit[y][x] = true; 
		//출력
		System.out.println(map[y][x]);
		COUNT++;
		
		//1- 노드의 4방 방문 시도
		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			
			//2- 범위체크, 방문여부 체크(true면 방문한거)
			if (ny < 1 || nx < 1 || ny >= 7 ||nx >=7 || visit[ny][nx]) continue; //범위체크
			//3- 방문 가능 => queue에 담는다
			dfs(ny, nx);
			
		}
	}
	
	static void bfs(int y, int x) { //for bfs
		//1. 초기화 - bfs()호출 전에도 가능
		visit = new boolean[7][7];
		COUNT = 0;
		//2. 자료구조 생성 - bfs()와 무관하게 별도로 미리 구성해도 좋다
		//자료구조에 담을 데이터 => y,x 좌표 필요
		Queue<Node> queue = new ArrayDeque<>();
		//3. 방문
		// 1- 시작점을 queue에 담고 방문 시작
		queue.offer(new Node(y, x));
		visit[y][x] = true; //시작점 방문하고 시작
		
		while (!queue.isEmpty()) { //큐가 비지 않을 때까지
			Node node = queue.poll(); //1- 큐 맨 앞 노드 꺼낸다
			//테스트 출력
			System.out.println(node);
			COUNT++;
			
			//1- 꺼낸 노드의 4방 방문 시도
			for (int d = 0; d < 4; d++) {
				int ny = node.y + dy[d];
				int nx = node.x + dx[d];
				
				//2- 범위체크, 방문여부 체크(true면 방문한거)
				if (ny < 1 || nx < 1 || ny >= 7 ||nx >=7 || visit[ny][nx]) continue; //범위체크
				//3- 방문 가능 => queue에 담는다
				queue.offer(new Node(ny, nx));
				visit[ny][nx] = true;
				
			}
		}
	}
	
	static class Node { //자바 구조체는 그냥 클래스임
		int y, x;
		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
		@Override
		public String toString() {
			return "Node [y=" + y + ", x=" + x + "]";
		}
		
	}
}
