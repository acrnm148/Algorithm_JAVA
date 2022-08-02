package boj;

import java.util.Scanner;

public class BOJ_17478����Լ���������_prof {
	
	static int N;
	static String[] MSG_ARRAY = {
			"\"�� ����. �������� �� �� ����⿡ �̼��� ��� ������ ����� ������ �־���.",
			"���� ������� ��� �� ���ο��� ������ ������ �߰�, ��� �����Ӱ� ����� �־���.",
			"���� ���� ��κ� �ǾҴٰ� �ϳ�. �׷��� ��� ��, �� ���ο��� �� ���� ã�ƿͼ� ������.\""
	};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		System.out.println("��� �� ��ǻ�Ͱ��а� �л��� ������ �������� ã�ư� ������.");
		chatbot(0);
	}
	
	static void chatbot(int depth) {

		// 0. �ؾ��� ��
		for (int j = 0; j < depth; j++) System.out.print("____");
		System.out.println("\"����Լ��� ������?\"");
		
		// 1. ���� ����========
		if (depth == N) {
			//complete code
			for (int j = 0; j < depth; j++) System.out.print("____");
			System.out.println("\"����Լ��� �ڱ� �ڽ��� ȣ���ϴ� �Լ����\"");
			for (int j = 0; j < depth; j++) System.out.print("____");
			System.out.println("��� �亯�Ͽ���.");
			return;
		}
		
		// 2. �ؾ��� ��========
		for (int i = 0; i < MSG_ARRAY.length; i++) {
			for (int j = 0; j < depth; j++) System.out.print("____");
			System.out.println(MSG_ARRAY[i]);
		}
		
		// 3. ��� ȣ��========
		chatbot(depth + 1);
		
		// 4. �ؾ��� ��
		for (int j = 0; j < depth; j++) System.out.print("____");
		System.out.println("��� �亯�Ͽ���.");
	}
}
