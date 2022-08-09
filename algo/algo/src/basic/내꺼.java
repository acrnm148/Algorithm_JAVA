package basic;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 완전탐색
 * */
public class 내꺼 {

	static int N, M, TC, s1, s2; // 과자봉지N개, 최대무게, 테스트케이스, 과자1, 과자2
	static int[] snack; // 마트의 과자들

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TC = Integer.parseInt(br.readLine());

		// 탐색
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			snack = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++)
				snack[i] = Integer.parseInt(st.nextToken());

			// 정렬 후 - 뒤에서부터 완전탐색
			int idx = N - 1;
			int ans = -1;
			Arrays.sort(snack);
			
			while (idx > 0) {
				
				s1 = snack[idx]; // 제일 무거운 과자 하나
				if (s1 < M) { // 제일 무거운게 M보다 작아야함
					for (int i = idx - 1; i >= 0; i--) { // 그다음 무거운 과자 하나 - 차례로 뽑음
						s2 = snack[i];
						if (s1 + s2 <= M) { //합이 최대무게보다 작거나 같을 때
							if (ans < s1+s2)
								ans = s1 + s2; //답 설정
						}
					}
				}
				idx--;
			}
			System.out.println("#" + tc + " " + ans);
		}
	}
}
