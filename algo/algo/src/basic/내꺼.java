package basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 내꺼 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		Solution s = new Solution();
		System.out.println(s.solution(str));
	}
}

class Solution {
    public int solution(String s) {
        int answer = 0;
        //String str = s.substring(5, s.length() - 1);
        String str = s;
        
		int[] num = new int[10];
		int cnt = 1;
		int check = str.charAt(0);
		int len = str.length();
		
		for (int i = 1; i < len; i++) {
			if (str.charAt(i) == check) 
				cnt++;
			else 
				cnt = 1;
			check = str.charAt(i);
			if (cnt == 3) num[check-'0']++;
		}

		int max = -1;
		for (int i = 0; i < 10; i++) {
			if (num[i] != 0) {
				if (max < i) max = i;
			}
		}
		if (!(max == 0 || max == -1)) {
			max += max * 100 + max * 10;
		}
		
		answer = max;
        return answer;
    }
}