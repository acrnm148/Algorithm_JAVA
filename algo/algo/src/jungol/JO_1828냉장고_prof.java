package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 끝나는 시간으로 정렬
 * */
public class JO_1828냉장고_prof {

	static int N, max, cnt; // max : 높은온도
	static int[][] input; //input[i][0]:i원소의 최저온도, input[i][1] :i원소의 최고온도
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		input = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			input[i][0] = Integer.parseInt(st.nextToken()); //최저
			input[i][1] = Integer.parseInt(st.nextToken()); //최고
			
		}
		
		//회의실과 같은 문제로 Greedy하게 해결 => 최고 온도로 오름차순 정렬
		Arrays.sort(input, (o1, o2) -> o1[1]-o2[1]);
		//이차원 배열을 만들어 줄 필요가 없다
		
		//max, cnt 초기화
		max = Integer.MIN_VALUE;
		cnt = 0;
		
		//순회하면서 최저온도가 현재 max(최고온도 의미) 보다 더 높으면 같이 보관X -> 냉장고 추가 필요
		for (int i = 0; i < N; i++) {
			if (input[i][0] > max) {
				max = input[i][1]; //이전 원소의 최고온도 set -> 새로운 냉장고에서 보관할 가장 높은 온도로 저장
				cnt++;
			}
			
		}
		System.out.println(cnt);
	}

}
