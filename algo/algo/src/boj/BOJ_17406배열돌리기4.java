package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17406배열돌리기4 {

	static int N, M, K, r, c, s;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(br.readLine());
		c = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		for (int i = 1; i <= r; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int y = r - s - 1; y < r + s; y++) {
			for (int x = c - s - 1; x < c + s; x++) {

			}
		}

	}

	// 1회 회전
	static void rotate() {
		int sy = 0, ey = N - 1; // sy : 시작y, ey : 종료y
		int sx = 0, ex = M - 1; // sx : 시작x, ex : 종료x

		while (true) {
			// 기저조건
			if (ey - sy < 1 || ex - sx < 1)
				return;

			// 반시계 방향으로 이동
			int temp = map[sy][sx]; // 첫 좌표 복사

			// top 우로 이동 (왼쪽의 값이 오른쪽의 값으로 이동)
			for (int i = sx; i < ex; i++) {
				map[sy][i + 1] = map[sy][i];
			}
			// right 하로 이동 (위의 값이 밑으로 이동)
			for (int i = 0; i < ey; i++) {
				map[i][ex] = map[i + 1][ex]; // 오른쪽 끝 x고정
			}
			// bottom 우로 이동 (왼쪽의 값이 오른쪽으로 이동)
			for (int i = ex; i > sx; i--) {
				map[ey][i] = map[ey][i - 1];
			}
			// left 하로 이동 (위의 값이 밑으로 이동)
			for (int i = ey; i > sy; i--) {
				map[i][sx] = map[i - 1][sx];
			}
			map[sy + 1][sx] = temp;

			// sy,ey, sx, ex
			sy += 1;
			sx += 1;
			ey -= 1;
			ex -= 1;
		}

	}
}
