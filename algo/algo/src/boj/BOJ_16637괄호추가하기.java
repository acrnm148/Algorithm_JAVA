package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
 * dfs, 백트래킹
 * */
public class BOJ_16637괄호추가하기 {

	static int N, max;
	static List<Integer> num = new ArrayList<>();
	static List<Character> op = new ArrayList<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		max = Integer.MIN_VALUE;
		
		N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		for (int i = 0; i < N; i++) {
			if (i % 2 == 0) //짝수 자리일 때 -> 숫자
				num.add(str.charAt(i) - '0');
			else
				op.add(str.charAt(i));
		}
		
		dfs(0, num.get(0));
		System.out.println(max);
		
	}

	static void dfs(int opIdx, int sum) {
		//1. 기저조건
		if (opIdx >= op.size()) {
			max = Math.max(max, sum);
			return;
		}
		
		//2. 선택이냐 선택아니냐 - 괄호쓰냐 괄호안쓰냐
		
		//괄호 쓸 경우
		if (opIdx+2 < num.size()) {
			int bracket = calc(num.get(opIdx+1), num.get(opIdx+2), op.get(opIdx+1));
			int res2 = calc(sum, bracket, op.get(opIdx));
			//test output------
			//System.out.println(num.get(opIdx+1) + ""+ op.get(opIdx+1) + ""+num.get(opIdx+2)+"="+bracket);
			//System.out.println(sum + ""+op.get(opIdx) + ""+bracket+"="+res2);
			//-----------------
			dfs(opIdx+2, res2);
		}
		//괄호 안쓸 경우 - 왼쪽에서 검사
				int res1 = calc(sum, num.get(opIdx+1), op.get(opIdx));
				//test output------
				//System.out.println(sum + ""+op.get(opIdx) + ""+num.get(opIdx+1)+"="+res1);
				//-----------------
				dfs(opIdx+1, res1);
	}
	
	static int calc(int num1, int num2, char op) {
		switch (op) {
		case '+':
			return num1 + num2;
		case '-':
			return num1 - num2;
		case '*':
			return num1 * num2;
		}
		return 0;
	}
}
