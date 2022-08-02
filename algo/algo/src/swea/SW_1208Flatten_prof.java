package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Array���
// BufferedReader ���
public class SW_1208Flatten_prof {
	
	static int[] floor;
	static int dump, minIdx, maxIdx;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));
		//Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long start = System.nanoTime(); //���� �ð� ����
		
		for (int t = 1; t <= 10; t++) {
			dump = Integer.parseInt(br.readLine());
			floor = new int[100];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 100; i++) {
				floor[i] = Integer.parseInt(st.nextToken());
			}
			
			minIdx = 0;
			maxIdx = 0;
			
			for (int i = 0; i < dump; i++) {
				//�ִ�, �ּ� �ε���
				reset();
				//�ִ�, �ּ� ���� ��
				int gap = floor[maxIdx] - floor[minIdx];
				if (gap == 0 || gap == 1) break;
				//��źȭ�۾�
				floor[maxIdx]--;
				floor[minIdx]++;
			}
			
			reset(); //�������� min, max�� index ���
			int result = floor[maxIdx] - floor[minIdx];
			
			System.out.println("#" + t + " " + result);
		}
		
		long end = System.nanoTime(); //���� �ð� ���� (nanosecond : 10����� 1��)
		System.out.println("duration : " + (end-start));
	}
	
	static void reset() {
		for (int i = 0; i < 100; i++) {
			if (floor[i] < floor[minIdx]) minIdx = i;
			if (floor[i] > floor[maxIdx]) maxIdx = i;
		}
	}
}
