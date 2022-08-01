package collections.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Test {

	public static void main(String[] args) {
//		{
//			ArrayList al  = new ArrayList(); //제네릭 경고
//		}
//		
//		//add, remove 
//		{
//			//ArrayList<String> al = new ArrayList<>(); //=> 밑에가 더 일반적인 형태
//			List<String> al = new ArrayList<>(); 
//			//왼쪽 List 인터페이스타입(원하는 기능)
//			//오른쪽은 기능을 구현한 객체
//			
//			al.add("손흥민");
//			al.add("이강인");
//			al.add("이승우");
//			System.out.println(al);
//			
//			al.add("이강인");
//			System.out.println(al);
//			
//			//by index 인덱스로 삭제
//			al.remove(0); 
//			System.out.println(al);
//			
//			//by Object object로 삭제
//			al.remove("이승우");
//			System.out.println(al);
//			
//			//by Object object로 삭제
//			al.remove("이강인");
//			System.out.println(al);
//			
//			//by Object object로 삭제
//			al.remove("이강인");
//			System.out.println(al);
//			//빈 배열이 출력된다
//			
//			//by Object object로 삭제
//			al.remove("이강인");
//			System.out.println(al);
//			// index를 직접제어하는 array보다 편리
//			
//			//wrapper클래스의 integer로 수정
//			al.add("손흥민");
//			al.add("이강인");
//			al.add("이승우");
//			System.out.println(al);
//			al.add(2, "강수나");
//			System.out.println(al);
//			
//		}
		
		//순회
//		{
//			List<String> al = new ArrayList<>(); 
//			al.add("손흥민");
//			al.add("이강인");
//			al.add("이승우");
//			al.add("이강인");
//			
//			//#1 for ========================================
//			for (int i = 0; i < al.size(); i ++) { //list의 사이즈는 al.size()
//				
//				String s = al.get(i); //꺼낼 때는 string으로 받아줌
//				System.out.print(s+" ");
//			}
//
//			//#2 for each ======================================
//			System.out.println();
//			//인덱스가 사라짐
//			for (String s : al) {
//				System.out.print(s + " ");
//				
//			}
//			// 결론 : for 말고 for each를 써라
//			
//			
//
//			//#3 Iterator =========================================
//			System.out.println();
//			//컬렉션을 쓸 때는 이터레이터를 써라
//			Iterator<String> itr = al.iterator();
//			while(itr.hasNext()) { //.hasNext() 다음것이 존재하나?
//				String s = itr.next();
//				System.out.print(s + " ");
//			}
//			
//		}
		
		
		//순회 후 삭제
		{
//			List<String> al = new ArrayList<>(); 
//			al.add("손흥민");
//			al.add("이강인");
//			al.add("이강인");
//			al.add("이승우");
//			System.out.println(al);
			//[손흥민, 이강인, 이강인, 이강인]
			
			/*
			//for문 돌면서 삭제 => 문제 있음(remove하면 size 계속 변동됨)
			for (int i = 0; i < al.size(); i++) {
				String s = al.get(i);
				if (s.equals("이강인")) {
					al.remove(i);
				}
				//사이즈가 삭제되면 인덱스가 주니까
				//"누락"
			}
			System.out.println(al); 
			//[손흥민, 이강인]으로 뜬다. 왜?
			*/
			
			/*
			//for문 돌면서 삭제 => 문제 있음(remove하면 size 계속 변동됨)
			int size = al.size();
			for (int i = 0; i < size; i++) {
				String s = al.get(i);
				if (s.equals("이강인")) {
					al.remove(i);
				}
				//사이즈가 삭제되면 인덱스가 주니까
				//"누락"
			}
			System.out.println(al); 
			*/
			
			
			/*
			//즉 뒤쪽부터 도는게 해결방법이다.
			for (int i = al.size() - 1; i >= 0; i--) {
				String s = al.get(i);
				if (s.equals("이강인")) {
					al.remove(i);
				}
			}
			System.out.println(al); 
			*/
			
			/* 4
			//Iterator 사용
			Iterator<String> itr = al.iterator();
			while (itr.hasNext()) {
				String s = itr.next();
				if (s.equals("이강인")) {
					//remove할 때 itr로 remove!!!!!
					itr.remove();
				}
			}
			System.out.println(al); 
			//이터레이터가 순회도 순회지만 삭제도 가능하다.
			*/
			
			/*
			//5 forEach2버전
			for (String s : al) {
				if (s.equals("이강인")) al.remove(s);
			}
			//배열을 순회하는 녀석과 삭제하는 녀석과의 충돌이 일어남?
			//그게먼솔 아아이해함
			System.out.println(al); //오류남 : java.util.ConcurrentModificationException
			*/
			
			/*
			al.removeIf(el -> el.equals("이강인"));
			//el -> el.equals("이강인") 이게 true이면 remove해달라는 뜻.
			//equals는 true, false 리턴
			System.out.println(al);
			*/
		}

		//sort
		{
			List<String> al = new ArrayList<>(); 
			al.add("a");
			al.add("c");
			al.add("b");
			al.add("d");
			System.out.println(al);
			Collections.sort(al);
			System.out.println(al);
		}
	}

}








