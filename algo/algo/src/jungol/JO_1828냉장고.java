package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/*
 * sort할 때 array가 레퍼런스 타입이면 클래스에 implements Comparable<클래스> 해줘야함
 * */
public class JO_1828냉장고 {

	static int N;
	static Node[] ref;
	static List<Node> result = new ArrayList<>(); 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ref = new Node[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			ref[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
		}
		Arrays.sort(ref, (o1, o2) -> o1.end - o2.end);
		result.add(ref[0]);
		
		for (int idx = 1; idx < ref.length; idx++) {
			if (result.get(result.size()-1).end <= ref[idx].start) {
				result.add(ref[idx]);
			}
		}
		System.out.println(result.size());
	}
	static class Node  implements Comparable<Node>{
		int start, end;
		public Node(int start, int end) {
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(Node o) {
			return this.end != o.end? this.end-o.end : this.start-o.start;
		}
	}
	
}
