package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_1210Ladder1_prof {
	
	//�� - �� - ��
	static int[] dy = {0,0,-1};
	static int[] dx = {-1,1,0};
	static int[][] ladder = new int[100][100];
	
	static int sy, sx, ans;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= 10; t++) {
			//ladder �ʱ�ȭ �ʿ�X => �Ź� ���� ó�� �� �Է����� �ٽ� �ʱ�ȭ �ڵ�����
			//ù��° ���ɹ�ȣ�� ������. �Ľ��� �ʿ䵵 ����
			br.readLine();
			
			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					ladder[i][j] = Integer.parseInt(st.nextToken());
//					ladder[i][j] = st.nextToken().charAt(0) - '0'; //�ӵ� ���
		
				}
			}
			
			//sy, sx�� ���� ladder���� ã�� ���
			sy = 99;
			for (int i = 0; i < 100; i++) {
				if (ladder[99][i] == 2) sx = i;
			}
			
			//Ž�� ���� - ���۹����� ���ΰ��� ��.
			//���۹����� ��
			int dir = 2;
			
			while (true) {
				//���� Ž���� ���, ��,�� �켱 - ��,�� �̵��� �� ������ ��� ��
				if (dir == 2) {
					for (int d = 0; d < 3; d++) {
						int ny = sy + dy[d];
						int nx = sx + dx[d];
						
						if (ny >= 0 && nx >= 0 && nx < 100 && ladder[ny][nx] == 1) {
							sy = ny;
							sx = nx;
							dir = d; //������ȯ(�״���ϼ���) �����������
							break; //�� for�� �ݺ��� �ʿ� X
						} 
					}
				}
				//���� �Ǵ� ���������� Ž���� ���, �� �켱, ���� �̵��� �� ������ ��� ��, �� �������� �̵�
				else if (dir == 0 || dir == 1) {
					// �� �켱
					int ny = sy + dy[2];
					int nx = sx + dx[2];
					if (ny >= 0 && ladder[ny][nx] == 1) { // ���� �� �� ������
						sy = ny;
						sx = nx;
						dir = 2;
					} else {
						sy = sy + dy[dir];
						sx = sx + dx[dir];
					}
				}
				if (sy == 0) {
					ans = sx;
					break;
				}
				
			} //while
			
			System.out.println("#" + t + " " + ans);
		}
	}
	
}
