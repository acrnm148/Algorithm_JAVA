package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

//DP => Memoization + 점화식
//int[] memoi => 문제를 풀어나가는 과정에서 갱신(케바케 상황에 따라 갱신)
//int[] dp => 초기값(점화식 0일 때, 1일때...) dp[0] = ? 
//	=> dp에 점화식을 적용, 초기값이 존재하므로, 초기값 이후의 값은 점화식을 반복적용하면서 채워나간다
//	문제가 N일 때 얼마?? 0 또는 1 부터 쭉 N까지 채워 나가면 끝난다.
//	dp문제의 특징
//	1. 코드가 간결하다.
//	2. 매우 안정적 (실수가 거의 없다)
//	3. 정말 빠르다!!! O(n)으로 바로 끝남

//문제가 있다면? 점화식을 만들어 내는 것이 매우 어렵다

public class BOJ_2839설탕배달_DP {

	static int N;
	static int[] dp; //어떤 값을 만드는데 필요한 봉투의 수 저장 // dp[x] = y 의미는 x무게를 y만큼의 봉투를 사용한다.
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		//1,2,3,4,5는 값을 미리 알 수 있다.
		if (N <= 5) {
			if (N == 3 || N == 5) System.out.println(1);
			else System.out.println(-1);
			return;
		}
		
		//6이상
		dp = new int[N+1]; //0 dummy
		// 보정
		Arrays.fill(dp, 5000); //충분히 큰 수로 채운다. => 최솟값을 선택하기 위해
		
		//초기 인덱스의 값 (점화식 적용 전)
		dp[3] = 1;
		dp[5] = 1;
		
		for (int i = 6; i <= N; i++) { //dp[N]까지 만들고 싶다.
			//점화식 - 최솟값 이용
			//i kg을 완성하는데 몇 개의 봉투가 필요한가 <= 이전 dp에 의존
			//i가 10kg 이라고 가정 - i[10] <= 이전 단계 + 3kg 1봉투 추가 / 이전 단계 + 5kg 1봉투 추가
			dp[i] = Math.min(dp[i-3] + 1, dp[i-5] + 1);
					//이전 것 어떤 것들 중 최솟값 선택
		}
		if (dp[N] > 5000) {
			System.out.println(-1);
		} else {
			System.out.println(dp[N]);
		}
		
	}
	
}










