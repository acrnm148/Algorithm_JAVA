package collections.set;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


public class Test {

	public static void main(String[] args) {
		// String 
		// set 순서 유지X, 중복X
		/*
		{
			Set<String> set = new HashSet<>();
			set.add("ssafy");
			set.add("Hello");
			set.add("World");
			set.add("Hello");
			set.add("World");
			
			for (String s : set) {
				System.out.println(s);
			}
			//4개를 넣었는데 3개만 나오네! 중복을 제거했군
			//ssafy를 먼저 넣었는데도 뒤로오네, 순서가 보장X!
		}
		*/
		
		{
			Set<MyClass> set = new HashSet<>();
			set.add(new MyClass(7,3,3));
			set.add(new MyClass(2,4,3));
			set.add(new MyClass(7,3,3)); //같은데, 같다는 판단을 하지 못한다. -> equals() override
			set.add(new MyClass(1,6,9));
			
			for (MyClass s : set) {
				System.out.println(s);
			}
			//4개 넣었는데 다 나옴. 중복 허용
			//Set 입장에서는 MyClass는 내맘대로 만든 클래스
			//같은녀석인지 다른녀석인지 판단할 수 있는 근거가 없음
			
		}
	}
	
	static class MyClass {
		int y;
		int x;
		int c;
		
		public MyClass(int y, int x, int c) {
			this.y = y;
			this.x = x;
			this.c = c;
		}

		@Override
		public String toString() {
			return "MyClass [y=" + y + ", x=" + x + ", c=" + c + "]";
		}
		
		@Override
		public boolean equals(Object o) {
			if (o != null && o instanceof MyClass) {
				MyClass mc = (MyClass) o; //MyClass를 캐스팅
				if (this.y == mc.y && this.x == mc.x && this.c == mc.c)
					return true;
			}
			return false;
		}
		//이렇게 해도 구분을 못함. hashCode() 오버라이딩 해야함
		//hashCode() 오버라이드 하면 먹음
		
		@Override
		public int hashCode() {
			return Objects.hash(this.y, this.x, this.c);
		}
		
		@Override
		public int compareTo(MyClass m) {
			return this.x - m.y;
		}
	}
	
}
