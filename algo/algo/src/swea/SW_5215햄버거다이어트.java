package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 부분집합?
 * */
public class SW_5215햄버거다이어트 {

	static List<Integer> part = new ArrayList<>();
	static int T, N, L, max, totalScore, calSum, maxScore;
	static int[] cal, score;
	static boolean[] isSelected;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			max = 0; totalScore = 0; calSum = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			score = new int[N];
			cal = new int[N];
			isSelected = new boolean[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				score[i] = Integer.parseInt(st.nextToken());
				cal[i] = Integer.parseInt(st.nextToken());
			}
			
			//부분집합
			subset(0);
			System.out.println("#" + t + " " + max);
		}
	}
	
	static void subset(int i) {
		if (i == N) {
			for (int n = 0; n < N; n++) {
				if (isSelected[n]) calSum += cal[n];
			}
			if (calSum <= L) { //칼로리 이내일 때
				for (int n = 0; n < N; n++) {
					if (isSelected[n]) totalScore += score[n];
				}
			}
			if (max < totalScore) {
				max = totalScore;
			}
			calSum = 0;
			totalScore = 0;
			return;
		}
		
		isSelected[i] = true;
		subset(i+1);
		isSelected[i] = false;
		//subset(i+1);
		
	}
}
