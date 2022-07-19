package basic;

public class BASIC_Delta { //델타?
	//상-하-좌-우
	static int[] dir_y = {-1, 1, 0, 0}; 
	static int[] dir_x = {0, 0, -1, 1};
	//static으로 해준 이유가 있나?
	//static을 쓰는 이유와 동일하다. 1)가독성을 위해서, 2)"변할 수도 있지만 잘 안변하는" 값이니까.
	
	public static void main(String[] args) {
		int[][] input = {
				{ 1, 2, 3, 4},
				{ 5,6, 7, 8},
				{ 9,-1,11,12},
				{13,14,15,16}
		};
		
		//요소가 -1일 때 사방탐색해서 인접 요소 값을 출력
		for (int  y = 0; y < 4; y++) {
			for (int x = 0; x < 4; x++) {
				if (input[y][x] == -1) {
					//4방 탐색
					//i, j에 대해서 row, col 변화를 주는 행위
					System.out.println("y : " + y + "x : " + x);
					
					for (int d = 0; d < 4; d++) {
						int new_y = y;
						int new_x = x;
						
						while (true) { //경계를 만날 때까지 무한루프
							new_y = new_y + dir_y[d];
							new_x = new_x + dir_x[d];
							
							//사용하기 전!! 무조건 범위 체크 먼저!
							if (new_y < 0 || new_x < 0 || new_y >= 4 || new_x >= 4) break;
							System.out.printf("%3d", input[new_y][new_x]);
						}
						System.out.println();
					}
				}
			}
		}
		
		
//		for (int  y = 0; y < 4; y++) {
//			for (int x = 0; x < 4; x++) {
//				if (input[y][x] == -1) {
//					//4방 탐색
//					//i, j에 대해서 row, col 변화를 주는 행위
//					System.out.println("y : " + y + "x : " + x);
//					
//					for (int d = 0; d < 4; d++) {
//						int new_y = y + dir_y[d];
//						int new_x = x + dir_x[d];
//						//사용하기 전!! 무조건 범위 체크 먼저!
//						if (new_y < 0 || new_x < 0 || new_y >= 4 || new_x >= 4) continue;
//						
//						System.out.println("new_y : " + new_y + "new_x : " +new_x);
//					}
//					
//					
//				}
//			}
//		}
		
		
		
	}
}
