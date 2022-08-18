package _연습;

import java.util.Arrays;

// nPr, nCr, 2^n
// 다음주 월요일 과목평가 4문제 중 마지막 문제로 나올 수도
// 각각의 예를 잘 파악해야함
public class 순조부 {
	static int N = 4, R = 3, C = 0;
	static int[] a = { 1, 2, 3, 4 }, b = new int[R];
	static boolean[] v = new boolean[N];

	public static void main(String[] args) throws Exception {
		perm(0); // 순열 4P3 = 4 x 3 x 2 = 24
		perm2(0); // 중복순열 4ㅠ3 = 4^3 = 64
		comb(0, 0); // 조합 4C3 = 4
		comb2(0, 0); // 중복조합 4H3 = 4+3-1C3 = 6C3 = 20
		subs(0); // 부분잡헙 2^4 = 14
		System.out.println(C);

	}

	static void subs(int depth) {
		// 기저조건
		if (depth == N) {
			for (int i = 0; i < N; i++) {
				System.out.print(v[i] ? a[i] : "X");
			}
			System.out.println();
			C++;
			return;
		}

		// 선택함
		v[depth] = true;
		subs(depth + 1);

		// 선택안함
		v[depth] = false;
		subs(depth + 1);
	}

	static void comb(int depth, int start) {
		// 기저조건
		if (depth == R) {
			System.out.println(Arrays.toString(b));
			C++;
			return;
		}

		for (int i = start; i < N; i++) {
			b[depth] = a[i];
			comb(depth + 1, i + 1);
		}
	}

	static void comb2(int depth, int start) { //중복조합
		// 기저조건
		if (depth == R) {
			System.out.println(Arrays.toString(b));
			C++;
			return;
		}

		for (int i = start; i < N; i++) {
			b[depth] = a[i];
			comb2(depth + 1, i); // i를 한번 더 중복적으로 사용
		}
	}

	static void perm(int depth) {
		// 기저조건
		if (depth == R) {
			System.out.println(Arrays.toString(b));
			C++;
			return;
		}

		for (int i = 0; i < N; i++) {
			if (v[i])
				continue;

			v[i] = true; // 방문 처리
			b[depth] = a[i];
			perm(depth + 1);
			v[i] = false; // 원상복귀
		}
	}

// 중복순열 - 방문처리 X
	static void perm2(int depth) {
		// 기저조건
		if (depth == R) {
			System.out.println(Arrays.toString(b));
			C++;
			return;
		}

		for (int i = 0; i < N; i++) {
			b[depth] = a[i];
			perm(depth + 1);
		}
	}
}