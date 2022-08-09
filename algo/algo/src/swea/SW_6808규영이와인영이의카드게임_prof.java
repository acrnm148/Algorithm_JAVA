package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 순열
 * 
 * 순서를 가진다
 * 
 * 
 * */
public class SW_6808규영이와인영이의카드게임_prof {
	
	static int T, win, lose, N = 9;
	static int[] input = new int[19];
	static int[] guCard = new int[9]; //테케에서 고정
	static int[] inCard = new int[9]; //guCard에 없는 번호 입력 <= 순열을 만들기 위해 선택할 수 있는 src
	static int[] tgt = new int[9];
	static boolean[] select = new boolean[9];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= N; tc++) { 
			//초기화
			win = 0;
			lose = 0;
			Arrays.fill(input, 0);

			StringTokenizer st = new StringTokenizer(br.readLine());
			
			//규영이 카드
			int num = 0;
			for (int i = 0; i < N; i++) {
				num = Integer.parseInt(st.nextToken());
				guCard[i] = num;
				input[num] = 1;
			}
			//인영이카드
			num = 0;
			for (int i = 1; i <= 18; i++) {
				if (input[i] == 0) inCard[num] = i;
			}
			perm(0);
			System.out.println("#"+tc+" " + win + " " + lose);

		}
	}
	
	static void perm(int tgtIdx) {
		//기저조건
		if (tgtIdx == N) {
			//complete code
			//규영이카드로부터 임의의카드를 순열로 완성한 경우
			check();
			return ;
		}
		for (int i = 0; i < N; i++) {
			//이미 선택된 i 제외
			if (select[i]) continue; // 이미사용됐다
			tgt[tgtIdx] = inCard[i];
			select[i] = true;
			perm(tgtIdx + 1); // 현재 i를 선택해서 모든 경우의 순열을 따져 본 후에 return 돼서 돌아오면 다음 i 선택
			select[i] = false;
			
		}
	}
	static void check() {
		int guSum = 0;
		int inSum = 0;
		for (int i = 0; i < N; i++) {
			if (guCard[i] > tgt[i]) {
				guSum += guCard[i] + tgt[i]; // 두 점수 다가져감
			}
			else { //서로 다르니까 같을 수가 없다
				inSum += guCard[i] + tgt[i];
			}
		}
		if (guSum > inSum) win++;
		else if (guSum < inSum) lose++; //sum은 같을 수 있으므로 같을 경우는 빼줘야함
		
	}
}
