package basic;

public class test {

	static int[][] map = { { 0, 0, 0, 0, 0, 0, 0 }, // 0 dummy
			{ 0, 41, 21, 34, 53, 23, 12 }, // row 1
			{ 0, 13, 51, 31, 60, 30, 23 }, // row 2
			{ 0, 61, 31, 51, -1, 73, 34 }, { 0, 34, 36, 71, 23, 35, 7 }, { 0, 51, 52, 53, 30, 55, 61 },
			{ 0, 51, 32, 63, 71, 35, 32 }, };
//static int[][] map = {
//        {0,  0,  0,  0,  0,  0,  0}, // 0 dummy
//        {0, 60, 60, 60, 10, 23, 12}, // row 1
//        {0, 60, 60, 60, 60, 30, 23}, // row 2
//        {0, 60, 60, 60, -1, 1, 34},
//        {0, 60, 1, 70, 70, 70, 7},
//        {0, 1, 52, 53, 30, 1, 61},
//        {0, 1, 32, 1, 1, 35, 32},
//};
	static int x, y, N = 7;
	static int ans = 0;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static boolean[][] visit = new boolean[N][N];

	static void dfs(int x, int y, int sum, int move) {
		ans = Math.max(sum, ans);

		if (move == 10) {
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (0 < nx && nx < N && 0 < ny && ny < N) {
				if (visit[nx][ny]) {
					dfs(nx, ny, sum, move + 1);
				} else {
					visit[nx][ny] = true;
					dfs(nx, ny, sum + map[nx][ny], move + 1);
					visit[nx][ny] = false;
				}
			}
		}
	}

	public static void main(String[] args) {
		for (int i = 1; i < N; i++) {
			for (int j = 1; j < N; j++) {
				if (map[i][j] == -1) {
					x = i;
					y = j;
					map[i][j] = 0;
				}
			}
		}

		dfs(x, y, 0, 0);
		System.out.println(ans);
	}

}