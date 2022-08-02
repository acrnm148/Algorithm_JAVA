package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// ArrayList ��� <= �ӵ� ���� X, ������ �� �ɸ���.
// BufferedReader ���
public class SW_1208Flatten_prof3 {
	
	static ArrayList<Integer> floor;
	static int dump, minIdx, maxIdx;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));
		//Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long start = System.nanoTime(); //���� �ð� ����
		
		for (int t = 1; t <= 10; t++) {
			dump = Integer.parseInt(br.readLine());
			floor = new ArrayList<>(); //ArrayList�� Ŭ�����̹Ƿ� �����ڷ� �����
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 100; i++) {
				floor.add(Integer.parseInt(st.nextToken()));
			}
			
			minIdx = 0;
			maxIdx = 0;
			
			for (int i = 0; i < dump; i++) {
				//�ִ�, �ּ� �ε���
				reset();
				//�ִ�, �ּ� ���� ��
				int gap = floor.get(maxIdx) - floor.get(minIdx);
				if (gap == 0 || gap == 1) break;
				//��źȭ�۾�
				floor.set(maxIdx, floor.get(maxIdx) - 1);
				floor.set(minIdx, floor.get(minIdx)+1);
			}
			
			reset(); //�������� min, max�� index ���
			int result = floor.get(maxIdx) - floor.get(minIdx);
			
			System.out.println("#" + t + " " + result);
		}
		
		long end = System.nanoTime(); //���� �ð� ���� (nanosecond : 10����� 1��)
		System.out.println("duration : " + (end-start));
	}
	
	static void reset() {
		for (int i = 0; i < 100; i++) {
			if (floor.get(i) < floor.get(minIdx)) minIdx = i;
			if (floor.get(i) > floor.get(maxIdx)) maxIdx = i;
		}
	}
}
