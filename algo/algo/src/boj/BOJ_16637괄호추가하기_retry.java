package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
 * 백트래킹 - 하나하나씩 괄호 넣었다 뺐다 해보기
 * */
public class BOJ_16637괄호추가하기_retry {

	static int len, max;
	static List<Character> op = new ArrayList<>();
	static List<Integer> num = new ArrayList<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		len = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		for (int i = 0; i < len; i++) {
			if (i % 2 == 0) num.add(str.charAt(i) - '0');
			else op.add(str.charAt(i));
		}
		
		comb(0, 0);
	}

	static void comb(int i, int res) {
		if (i == len) {
			max = Math.max(max, res);
			return;
		}
		
		int tmp = calc(op.get(i), num.get(i+1));
		comb(i);
		
		
	}
}
