package boj2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 인접행렬
 * */
public class BOJ_1260_DFS와BFS {

	static int[][] matrix; //이차원배열 -> 방문할 수 있는 정점 관계
	static boolean[] visited;
	static int N, M, start;
	static Queue<Integer> queue = new ArrayDeque<>();
	static StringBuilder ans = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 노드 개수
		M = Integer.parseInt(st.nextToken()); // 간선 개수
		start = Integer.parseInt(st.nextToken()); // 시작점

		matrix = new int[N + 1][N + 1];
		visited = new boolean[N + 1];

		for (int i = 0; i < M; i++) { // 간선 개수 만큼
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			matrix[a][b] = 1; // 인접해있으면 1
			matrix[b][a] = 1;
		}

		// dfs
		dfs(start);
		ans.setCharAt(ans.length()-1, '\n'); //스트링빌더에 들어있는 마지막 원소를 줄바꿈으로 바꾸겠다? => 이러면 마지막 원소가 바뀌는거 아님?
		//아니다. 뒤에 공백까지 같이넣어줬잖음
		
		// bfs
		visited = new boolean[N + 1]; //visited 재활용할거니까 초기화. for문으로 원소 하나하나  false로 바꿔줘도 된다.
		bfs();
		
		//출력할 때 줄바꿈 한번 더 들어감 -> 스트링빌더로 마지막 문자 제거하는 방법
		ans.setLength(ans.length()-1);
		
		System.out.println(ans);
	}

	static void bfs() {

		visited[start] = true;
		queue.offer(start);

		while (!queue.isEmpty()) {
			int front = queue.poll();
			ans.append(front).append(" ");

			for (int i = 1; i <= N; i++) {
				if (!visited[i] && matrix[front][i] != 0) {
					visited[i] = true;
					queue.offer(i);
				}
			}
		}

	}

	static void dfs(int i) {
		visited[i] = true;
		ans.append(i).append(" "); //마지막원소에도 공백 같이들어가니까 setCharAt으로 마지막 공백을 줄바꿈으로 바꿔줬음
		
		for (int x = 1; x <= N; x++) { //i에서 갈 수 있는 자식 노드 방문
			if (!visited[x] && matrix[i][x] != 0) //인접노드 중에서 && 이미 방문하지 않았으면
				dfs(x);
		}
	}

}
