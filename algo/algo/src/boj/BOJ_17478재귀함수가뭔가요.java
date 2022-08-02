package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_17478����Լ��������� {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		System.out.println("��� �� ��ǻ�Ͱ��а� �л��� ������ �������� ã�ư� ������.");
		recursive(N);
	}
	
	
	static int cnt = 0;
	static void recursive(int N) {
		String str="";
		for (int i = 1; i <= cnt; i++) str += "____";
		
		System.out.print(str);
		System.out.println("\"����Լ��� ������?\"");
		
		//1. ��������
		if (N == 0) {
			System.out.print(str);
			System.out.println("\"����Լ��� �ڱ� �ڽ��� ȣ���ϴ� �Լ����\"");
			System.out.print(str);
			System.out.println("��� �亯�Ͽ���.");
			return;
		}
		
		//2. �ϰ���� ��
		System.out.print(str);
		System.out.println("\"�� ����. �������� �� �� ����⿡ �̼��� ��� ������ ����� ������ �־���.");
		System.out.print(str);
		System.out.println("���� ������� ��� �� ���ο��� ������ ������ �߰�, ��� �����Ӱ� ����� �־���.");
		System.out.print(str);
		System.out.println("���� ���� ��κ� �ǾҴٰ� �ϳ�. �׷��� ��� ��, �� ���ο��� �� ���� ã�ƿͼ� ������.\"");
		
		//3. ����Լ�
		cnt++;
		recursive(N - 1);
		
		System.out.print(str);
		System.out.println("��� �亯�Ͽ���.");
		cnt--;
	}
	
}
