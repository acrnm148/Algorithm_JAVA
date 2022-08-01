package lambda;

public class LambdaExpressionTest {
	public static void main(String[] args) { //람다식의 위치는 메인~
//		{
//			UseFuncIF.exec1( () -> {System.out.println("Hello");} ); // 파라미터로 인터페이스를 구현한 객체가 오면 된다!!! => 그 객체를 표현하는게 람다식.
//			//UseFuncIF.exec1( () -> {return "Hello";} ); //오류발생. void인데 return 하고있네
//			UseFuncIF.exec1( () -> { } );
//			
//			/*
//			 * 파라미터가 없을 때의 람다식 : ()-> {
//			 		아무코드~~
//				}
//			*/
//			//람다식도 객체다.
//			//람다익스프레션이 최종적으로 도달하는 것은 객체다. 그 인터페이스를 구현하는 로직(객체)만 있으면 끝이다.
//		}
		
//		{
//			UseFuncIF.exec2( () -> {return 10;} ); 
//			UseFuncIF.exec2( () -> 10 );  
//			UseFuncIF.exec2( () -> {
//				int n1 = 10, n2 = 20;
//				return n1 + n2;
//			} );
//										   // 1 중괄호 + 리턴 / 2 리턴문빼고 중괄호 / 3 리턴문 중괄호 다 빼고 -> 가능.
//										   // 중괄호 빼고 리턴문은 안됨!!!
//			//즉, 람다식 == 인터페이스를 구현한 객체!!! 구현을 여기서 직접한다!!! 더 직관적
//		
//			
//			UseFuncIF.exec2( () -> sm1() );  //4 메소드를 호출할 수도 있다.
//		}
		
//		{
//			UseFuncIF.exec3( (n) -> "Hello" ); //매개변수int, 리턴값 String
//			UseFuncIF.exec3( (n) -> "입력값에 10을 더하면 : " + (n + 10) );
//			UseFuncIF.exec3( n -> "입력값에 10을 더하면 : " + (n + 10) ); //파라미터가 1개일 때만 소괄호 생략 가능
//			UseFuncIF.exec3( n -> {
//				if (n % 2 == 0) return "짝수입니다.";
//				else return "홀수입니다.";
//			} );
//		}
		
//		{
//			UseFuncIF.exec4((n1, n2) -> n1 + n2);
//			UseFuncIF.exec4((n1, n2) -> //리턴문빼고 중괄호 왜안되지???
//				Math.min(n1, n2)
//			);
//			UseFuncIF.exec4(10, 20, (n1, n2) -> {return Math.max(n1, n2);}); // 1 중괄호 + 리턴
//			//UseFuncIF.exec4(10, 20, (n1, n2) -> { Math.max(n1, n2);}); // 2 리턴문빼고 중괄호
//			UseFuncIF.exec4(10, 20, (n1, n2) -> Math.max(n1, n2)); // 3 리턴문 중괄호 다 빼고
//			//UseFuncIF.exec4(10, 20, (n1, n2) -> return Math.max(n1, n2)); //중괄호 빼고 리턴문은 안됨 !!
//		}
		
		{
			//두 객체의  y, x 좌표 중 y가 큰 객체를 리턴한다.
			//7,2와 3,9
			UseFuncIF.exec5( new MyClass(7,2), new MyClass(3,9), (mc1, mc2) -> {
				//mc1.y > mc2.y ? mc1 : mc2
				if (mc1.y > mc2.y)
					return mc1;
				return mc2;
			});
			
			//두 객체의 y + x 합이 더 큰 객체를 return
			UseFuncIF.exec5(new MyClass(7,2), new MyClass(3,9), (m1, m2) -> m1.x + m1.y > m2.x + m2.y ? m1 : m2);
		}
	}
	
	
	
	//* 인터페이스는 제공자가 아니다. 제공자와 사용자 사이의 약속이다.
	// 누군가가 아래의 Interface를 구현한 객체를 필요로 한다.
	static interface FuncIF1 { void m(); } //파라미터X, 리턴타입 X functional Interface
	static interface FuncIF2 { int m(); } //파라미터X, int를 리턴
	static interface FuncIF3 { String m(int n); }
	static interface FuncIF4 { int m(int n1, int n2); } //파라미터 2개, 리턴 int
	static interface FuncIF5 { MyClass m(MyClass mc1, MyClass mc2); }
	
	static int sm1() {return 1;}
	
	// 사용자 : 누군가가 바로 나다.
	static class UseFuncIF {
		public static void exec1(FuncIF1 funcIFImpl) {
			funcIFImpl.m();
		}
		
		public static void exec2(FuncIF2 funcIFImpl) {
			System.out.println( funcIFImpl.m() ); //리턴결과를 출력
		}
		
		public static void exec3(FuncIF3 funcIFImpl) {
			System.out.println( funcIFImpl.m(5) ); //파라미터 및 리턴결과를 출력
		}
		
		public static void exec4(FuncIF4 funcIFImpl) {
			System.out.println( funcIFImpl.m(7, 2) ); //파라미터 및 리턴결과를 출력
		}
		
		public static void exec4(int n1, int n2, FuncIF4 funcIFImpl) { //오버로딩이 가능하다~~~
			System.out.println( funcIFImpl.m(n1, n2) ); 
		}
		
		public static void exec5(MyClass mc1, MyClass mc2, FuncIF5 funcIFImpl) { //오버로딩이 가능하다~~~
			System.out.println( funcIFImpl.m(mc1, mc2) ); 
		}
	}
	
	static class MyClass {
		int y;
		int x;
		
		public MyClass(int y, int x) {
			this.y = y;
			this.x = x;
		}

		@Override
		public String toString() {
			return "MyClass [y=" + y + ", x=" + x + "]";
		}
		
	}
}
