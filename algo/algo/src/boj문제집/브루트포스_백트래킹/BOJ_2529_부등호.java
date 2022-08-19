package boj문제집.브루트포스_백트래킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BOJ_2529_부등호 {
	
	static int[] tgt;
	static boolean[] isSelected;
	static List<Character> sign = new ArrayList<>(); //부등호 ArrayList
	static List<String> ans = new ArrayList<> (); //정답 순열 ArrayList
	static int k; //부등호 몇 개
	static int cnt;  // 정수 최소값, 정수 최대값
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		String str = br.readLine();
		int strlen = str.length();
		for (int i = 0; i < strlen; i++) {
			if (i %2 ==0) sign.add(str.charAt(i));
		}
		
		isSelected = new boolean[10];
		tgt = new int[k+1];
		
		perm(0); //순열 자리 시작인덱스(0~k+1) , 숫자 시작 인덱스(0~9)

		//문제읽자.. 전체를 출력하는게 아니라 최소 정수 하나 최대 정수 하나 출력이다;;
		System.out.println(ans.get(ans.size()-1));
		System.out.println(ans.get(0));
		
	}
	
	
	
	
	//조합이 아니라 순열이었음 => 자리가 달라지면 값도 달라짐 => 순서가 중요
	static void perm(int tgtIdx) {
		if (tgtIdx == k + 1) { // 조합 하나 완성
			if (check(tgt)) { //최소일때 혹은 최대일 때
				cnt++;
				String num = "";
				for (int i : tgt) num += (char) (i+'0');  // String에 for문으로 하나하나 붙여줌
				ans.add(num);						// 만든 String을 ans에 넣어줌
			}
			return;
		}
		
		for (int i = 0; i <= 9; i++) {
			if (isSelected[i]) continue;
			tgt[tgtIdx] = i;
			isSelected[i] = true;
			perm(tgtIdx+1);
			isSelected[i] = false;
		}
	}
	
	static boolean check(int[] arr) {
		for (int i = 0; i < k; i++) {
			int num1 = arr[i];
			int num2 = arr[i+1];
			switch (sign.get(i)) {
			case '<': if (num1 >= num2) return false; break;
			case '>': if (num1 <= num2) return false; break;
			}
		}
		return true;
	}
}










