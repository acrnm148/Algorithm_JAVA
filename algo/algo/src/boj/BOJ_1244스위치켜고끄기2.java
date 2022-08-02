package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// �Է��� �����鼭 ó���� �� �ִ� ������ �ݵ�� �׷��� ó�� ( �Է��� ���� �ڷᱸ���� ���� �ʿ� X )
// switches : int -> boolean
// 0, 1 �� �ٲ��ִ� �ڵ带 ���̴µ� ����
public class BOJ_1244����ġ�Ѱ����2 {

	
	static int N, COUNT;
	static boolean[] switches;  // ����ġ�迭
	static int gender, num; // ����, �ο����� ���� <= local �����ص� ����
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		switches = new boolean[N + 1]; // 0 dummy, ������ ��ȣ�� 1���� ����
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			if (switches[i] = st.nextToken().equals("1"))
				switches[i] = true; //else 0�� ���� �ʿ� ����. boolean�� ����Ʈ�� false�̱� ����
		}
		
		COUNT = Integer.parseInt(br.readLine());
		for (int i = 0; i < COUNT; i++) {
			st = new StringTokenizer(br.readLine());
			gender = Integer.parseInt(st.nextToken()); //���� ����
			num = Integer.parseInt(st.nextToken());	   //���� ���� ��ȣ
			
			if (gender == 1) {
				male();
			} else if (gender == 2) {
				female();
			}
		}
		
		//������
		for (int i = 1; i <= N; i++) {
			System.out.print(switches[i]? 1 : 0); //booleanŸ�� ��� �״�� �ϸ� true, flase�� ����
			if (i != N) {
				if (i % 20 == 0) {
					System.out.println();
				}
				else {
					System.out.print(" ");
				}
			}
		}
		
	}
	

	static void male() {
		for (int i = num; i <= N; i +=num) { 
			switches[i] = !switches[i]; //���׿����� ���� �ʿ���� �ڱ��ڽ� �ݴ븦 �־��ָ� �ȴ�
		}
	}
	
	static void female() {
		switches[num] = !switches[num];
		int left = num - 1;
		int right = num + 1;
		while (left >= 1 && right <= N) { //������
			if (switches[left] == switches[right]) {
				switches[left] = !switches[left];
				switches[right] = switches[left];
				
				//�̷��Ե� �Ѵ�
				//switches[right] = switches[left] = !switches[left];
				
			} else { //�ٸ���
				break;
			}
			left--;
			right++;
		}
	}

}