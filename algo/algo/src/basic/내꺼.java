package basic;

import java.util.ArrayDeque;
import java.util.Queue;

import basic.BASIC_BFS_DFS.Node;

/*
 * 
문제입니다!

N*N 크기의 판에 먹이가 있다.
돼지의 위치는 -1로 주어진다.
돼지는 밥을 최대 10번 먹을 수 있다.
상하좌우로만 움직일 수 있을때 최대로 먹을수 있는 먹이의 양은??
좌표는 1x1부터 시작한다.
N = 7
1 <= 먹이의 양 < 100
 * */
public class 내꺼 {

	static int sum, ny, nx;
	static int[][] map = { 
			{ 0, 0, 0, 0, 0, 0, 0 }, // 0 dummy
			{ 0, 41, 21, 34, 53, 23, 12 }, // row 1
			{ 0, 13, 51, 31, 60, 30, 23 }, // row 2
			{ 0, 61, 31, 51, -1, 73, 34 }, 
			{ 0, 34, 36, 71, 23, 35, 7 }, 
			{ 0, 51, 52, 53, 30, 55, 61 },
			{ 0, 51, 32, 63, 71, 35, 32 },
			// 1 2 3 4 5 6 // 0 dummy
	};
	
	static int[] dir_y = {-1, 1, 0, 0}; //상 하 좌 우
	static int[] dir_x = {0, 0, -1, 1}; //상 하 좌 우
	static boolean[][] visited = new boolean[7][7];
	static int COUNT;
	public static void main(String[] args) {
		int y = 0;
		int x = 0;
		for (int i = 1; i < 7; i++ ) {
			for (int j = 1; j < 7; j++ ) {
				if (map[i][j] == -1) { //돼지 위치 먼저 알아야
					y = i;
					x = j;
				}
			}
		}
		bfs(y,x); // 사방을 비교해야하므로 bfs
		System.out.println(sum);
	}
	
	static void bfs(int y, int x) {
		//1. 큐 생성
		Queue<Node> queue = new ArrayDeque<>();
		int max = 0;
		int maxX = 0; // 사방비교해서 큰 값이면 좌표 저장
		int maxY = 0;
		//2. 자기자신 방문
		visited[y][x] = true;
		queue.offer(new Node(y,x));
		//3. 탐색
		while (!queue.isEmpty()) {//큐가 비지 않을 때까지
			COUNT++;
			if (COUNT == 10) break;
			//4. 맨 앞에 애 먼저 뺌
			Node front = queue.poll();
			max = 0;
			for (int i = 0; i < 4; i++) {
				nx = front.x + dir_x[i];
				ny = front.y + dir_y[i];
				if (!(ny <= 0 || ny >= 7 || nx <= 0 || nx >= 7 || visited[ny][nx])) {
				if (map[ny][nx] > max) {
					max = map[ny][nx];
					maxX = nx;
					maxY = ny;
				}
			}
			System.out.println(COUNT + " : "+map[ny][nx] + " max: "+ max);
			sum += max;
			queue.offer(new Node(maxY, maxX));
			visited[maxY][maxX] = true;
			}
		}
	}
	static class Node {
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
