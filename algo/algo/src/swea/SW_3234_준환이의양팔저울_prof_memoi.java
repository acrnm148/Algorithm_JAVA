package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* memoi
 * 순열의 경우의수를 계산
 * 1,2,3,4,5,6 수가 있다고 가정
 * - 왼쪽에 1,2,3이 올라가면 오른쪽: 456, 465, 546, 564, 645, 654 = 3*2*1 = 6
 * - 왼쪽에 1,3,2 = 6
 * */
public class SW_3234_준환이의양팔저울_prof_memoi {
	
	static int N, T, ans;
	static int[] choo;
	static int[][] memoi;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			choo = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int sum = 0;
			for (int i = 0; i < N; i++) {
				choo[i] = Integer.parseInt(st.nextToken());
				sum+= choo[i];
			}
			
			//memoi 구성
			memoi = new int[sum+1][1<<N]; //1<<N 어떤 추가 사용이 되었다
			
			ans = perm(0, 0, 0, 0);
			
			System.out.println("#" + tc+ " " + ans);
		}
	}

	//memoi에 저장을 하는 구조
	static int perm(int tgtIdx, int leftSum, int rightSum, int mask) { //가지치기 넣어라
		if (tgtIdx == N) {
			return 1;
		}
		
		if (memoi[leftSum][mask] != 0) return memoi[leftSum][mask]; //ex> memoi[6][000111]
		
		int cnt = 0;
		
		for (int i = 0; i < N; i++) {
			//이미 사용한 추 제외
			if ((mask & 1 << i) != 0) continue;
			//2가지 재귀호출
			//#1 왼쪽에 추를 올리는 경우
			cnt += perm(tgtIdx + 1, leftSum+choo[i], rightSum, mask|1<<i);
			
			
			//#2 오른쪽에 추를 올리는 경우 - 가지치기
			if (leftSum >= rightSum + choo[i])
				cnt += perm(tgtIdx + 1, leftSum, rightSum+choo[i], mask|1<<i);
		}
		
		memoi[leftSum][mask] = cnt; //비트마스크를 만드는데 있어서 cnt만큼이 필요하다
		return cnt;
		
	}
	
}















