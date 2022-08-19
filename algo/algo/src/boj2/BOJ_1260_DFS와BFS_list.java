package boj2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 인접행렬
 * */
public class BOJ_1260_DFS와BFS_list {

	static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>> ();
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

		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<Integer>()); //각각 원소를 모두 객체 생성 해줘야함
		}
		visited = new boolean[N + 1];

		for (int i = 0; i < M; i++) { // 간선 개수 만큼
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);  //두 인덱스에 서로 다 넣어줘야함. 왜? 방향이 없기 때문 "입력으로 주어지는 간선은 양방향이다."
		}

		//리스트를 한번 정렬해주고 시작해야한다. 
		for (int i = 0; i < list.size(); i++) {
			Collections.sort(list.get(i));
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

			int size = list.get(front).size();
			for (int x = 0; x < size; x++) { //i에서 갈 수 있는 자식 노드 방문
				int v = list.get(front).get(x);  //v:인접 노드 
				if (visited[v]) continue; 	 //인접노드 중에서 && 이미 방문하지 않았으면
				
				visited[v] = true;
				queue.offer(v);
			}
		}

	}

	static void dfs(int i) {
		visited[i] = true;
		ans.append(i).append(" "); //마지막원소에도 공백 같이들어가니까 setCharAt으로 마지막 공백을 줄바꿈으로 바꿔줬음
		
		int size = list.get(i).size();
		for (int x = 1; x < size; x++) { //i에서 갈 수 있는 자식 노드 방문
			int v = list.get(i).get(x);  //v:인접 노드 
			if (visited[v]) continue; 	 //인접노드 중에서 && 이미 방문하지 않았으면
			visited[v] = true;
			dfs(v);
		}
	}

}
