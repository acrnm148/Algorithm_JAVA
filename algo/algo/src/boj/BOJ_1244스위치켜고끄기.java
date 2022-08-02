package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// �Է��� �����鼭 ó���� �� �ִ� ������ �ݵ�� �׷��� ó�� ( �Է��� ���� �ڷᱸ���� ���� �ʿ� X )
public class BOJ_1244����ġ�Ѱ���� {

	
	static int N, COUNT;
	static int[] switches;  // ����ġ�迭
	static int gender, num; // ����, �ο����� ���� <= local �����ص� ����
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		switches = new int[N + 1]; // 0 dummy, ������ ��ȣ�� 1���� ����
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			switches[i] = Integer.parseInt(st.nextToken());
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
			System.out.print(switches[i]);
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
	
	// �ڱⰡ ���� ��ȣ�� ����� �ٲ���Ѵ�.
	// 1 2 3 4 5 6 7 8 
	// num == 3
	static void male() {
//		for (int i = 1; i <= N; i++) {
//			if (i % num == 0) { //����ġ ��ȣ�� N�� ����̸�
//				switches[i] = switches[i] == 0? 1 : 0; //���׿�����
//			}
//		}
		
		// new
		for (int i = num; i <= N; i +=num) { // ù��° �̵� - ��� �ε����� ã�� ����
			// if �� X �� ��° �̵�
			switches[i] = switches[i] == 0? 1 : 0; //���׿�����
		}
	}
	
	static void female() {
		//�ڽ��� ���� ��ȣ�� ����ġ�� �켱 ����
		//�ڽ� �¿� ��Ī�� ���� ã�� ����
		switches[num] = switches[num] == 0? 1:0;
		
		//before
//		int cnt = 1;
//		while (num - cnt >= 1 && num + cnt <= N) { //������
//			if (switches[num-cnt] == switches[num+cnt]) {
//				switches[num-cnt] = switches[num-cnt] == 0? 1:0;
//				switches[num+cnt] = switches[num+cnt] == 0? 1:0;
//			} else { //�ٸ���
//				break;
//			}
//			cnt++;
//		}
		
		int left = num - 1;
		int right = num + 1;
		while (left >= 1 && right <= N) { //������
			if (switches[left] == switches[right]) {
				switches[left] = switches[left] == 0? 1:0;
				switches[right] = switches[left];
				
				//�̷��Ե� �Ѵ�
				//switches[right] = switches[left] = switches[left] == 0? 1:0;
				
			} else { //�ٸ���
				break;
			}
			left--;
			right++;
		}
	}

}