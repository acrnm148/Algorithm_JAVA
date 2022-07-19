package basic;

import java.util.*;
import java.util.Arrays;
import java.util.Collections;

public class BASIC_Array {
	public static void main(String[] args) {
		//빈도수 출력
		/*
		{
			int [] alphaCnt = new int[26]; // index 0 : a에 대한 빈도수, 1: b에 대한 빈도수 //default : 0
			String str = "abbcccddddeeeeeffffggghhiabbcccddddeeeeeffffggghhi";
			
			int strLength = str.length();
			for (int i = 0; i < strLength; i++) { //문자열 순회 (처음 -> 끝)
				alphaCnt[str.charAt(i) - 'a']++;
			}
			
			//출력
			for(int i = 0; i < 26; i++) {
				System.out.println((char)(i + 'a') + " : " + alphaCnt[i]); // a : 3
			}
		}
		*/
		
		/*
		{
			//규칙이 다른 경우확인
			//세자리 수가 각각 곱셈을 표현 236(O) 333(X)
			int[] intArray = {3,2,6, 3,4,4, 1,4,2, 2,3,6, 1,3,5, 1,5,1, 1,1,1, 2,4,2, 2,2,4};
			int wrongCnt = 0;
			int intLength = intArray.length - 2;
			for (int i = 0; i < intArray.length; i+=3) {
				if (intArray[i] * intArray[i + 1] != intArray[i+2])
					wrongCnt++;
			}
			System.out.println(wrongCnt);
		}
		*/
		
		//뒤집기1
		/*
		{
			int[] intArray = {3,2,6, 3,4,4, 1,4,2, 2,3,6, 1,3,5, 1,5,1, 1,1,1, 2,4,2, 2,2,4};
			for (int i = 0; i < intArray.length / 2; i++) {
				int tmp = intArray[i];
				intArray[i] = intArray[intArray.length - 1 - i];
				intArray[intArray.length - 1 - i] = tmp;
			}
			for (int i= 0; i < intArray.length; i++) {
				System.out.println(intArray[i]);
			}
		}
		*/
		
		//뒤집기2
		{
			//String[] strArray = {"111", "222", "333", "444", "555", "666"};
			String[] strArray = {"111", "222", "333", "444", "555", "666", "777"};
			int center = strArray.length / 2;
			
			for (int left = 0, right = strArray.length - 1; left < center; left++, right--) {
				String temp = strArray[left];
				strArray[left] = strArray[right];
				strArray[right] = temp;
			}
			System.out.println(Arrays.toString(strArray));
		}
		
		//뒤집기3
		{
			String[] strArray = {"111", "222", "333", "444", "555", "666"};
//			String[] strArray = {"111", "222", "333", "444", "555", "666", "777"};
			List<String> strList = Arrays.asList(strArray);
			Collections.reverse(strList);
			//T : 제네릭 generic
			
			System.out.println(Arrays.toString(strArray));
		}
		
	}
}
