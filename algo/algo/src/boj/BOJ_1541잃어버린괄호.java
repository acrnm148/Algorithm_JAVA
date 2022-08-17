package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 이 문제는 괄호 안에 수가 여러개가 올 수 있다. 그래서 백트래킹으로 풀 수 없다.
 * 백트래킹말고 다른 방법을 쓰자
 * 
 * */
public class BOJ_1541잃어버린괄호 {

	static List<Character> op = new ArrayList<>();  //연산자 담는 리스트
	static List<Integer> num = new ArrayList<>();	//숫자 담는 리스트
	static int min, N;
	public static void main(String[] args) throws Exception{
		//입력받아서 연산자, 숫자 각각 리스트에 따로 담아줌
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String[] tmp = str.split("-|\\+");
		String[] tmp2 = str.split("[0-9]");
		int len = str.length();
		for (String t : tmp) {
			num.add(Integer.parseInt(t));
		}
		for (int i = 0; i < len; i++) {
			if (str.charAt(i) == '-' || str.charAt(i) == '+') {
				op.add(str.charAt(i));
			}
		}
		//입력 끝
		
		min = Integer.MAX_VALUE;
		dfs(0, num.get(0));
		System.out.println(min);
	}
	
	
	static void dfs(int i, int ans) {
		if (i >= op.size()) { // 더이상 수식이 없을 경우
			min = Math.min(min, ans);
			return;
		}
		
		//1. 괄호 없을 경우
		int res1 = calc(ans, num.get(i+1), op.get(i)); // ans:이전값 / num.get(i+1): 다음값
		dfs(i+1, res1);
		
		//2. 괄호 있을 경우
		if (i+2 < num.size()) {
			int tmp = calc(num.get(i+1), num.get(i+2), op.get(i+1)); //괄호 계산한 값
			int res2 = calc(ans, tmp, op.get(i)); //ans(이전값) + tmp(괄호계산한 값)
			dfs(i+2, res2); //i+1번째 연산자는 괄호로 계산했으므로 i+2
		}
	}
	
	static int calc(int num1, int num2, char op) {
		switch (op) {
		case '-' : return num1 - num2;
		case '+' : return num1 + num2;
		}
		return 0;
	}
}















