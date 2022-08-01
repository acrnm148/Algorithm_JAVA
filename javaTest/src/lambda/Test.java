package lambda;

public class Test {

	public static void main(String[] args) {
		int n1 = 10;
		int n2 = 20;

		// #1. 인터페이스를 구현한 클래스를 사용 - MyFuncIFImpl
//		{
//			MyFuncIF func = new MyFuncIFImpl();
//			int result = func.proc1(n1, n2);
//			System.out.println(result);
//		}

		// #2. 인터페이스를 구현한 익명클래스(어나니머스)를 사용 - MyFuncIFImpl 사용 X
		// 첫번째 코드의 간소화 - 생략 : MyFuncIFImpl
		// 좀 더 다이나믹한 코딩이 가능 -> 내용 고칠 때 다른클래스 안가고 코드안에서 고칠 수 있다.
//		{
//			MyFuncIF func = new MyFuncIF() {
//				@Override
//				public int proc1(int n1, int n2) {
//					return n1 + n2; // 더하기
//				}
//			};
//			
//			int result = func.proc1(n1, n2);
//			System.out.println(result);
//		}
		
		
		//Functional Interface 가 무엇인가?========================
		//Functional Interface 가 아닌 경우 여러 개의 추상 메소드를 구현
//		{
//			MyFuncIF2 func = new MyFuncIF2() {
//				@Override
//				public int proc1(int n1, int n2) {
//					return n1 + n2; // 더하기
//				}
//				
//				@Override
//				public int proc2(int n1, int n2) {
//					return n1 - n2; // 빼기
//				}
//			};
//			
//			//func.proc1(), func.proc2() 모두 호출이 가능 <= 선택적이다 == 결정적이 아니다.
//			int result = func.proc1(n1, n2); 
//			result = func.proc2(n1, n2);
//			System.out.println(result);
//		}
//		
		
		// #3. lambda first
		// Functional Interface를 구현한 객체는 오직 한 가지만 호출할 수 있다 == 결정적이다.
		// 즉, lambda는 전제조건이 functional Interface를 구현한 객체로만 사용될 수 있다!!!
		{
			MyFuncIF func = (i, j) -> i + j; // (i, j) -> return(i + j); 의 생략
			//임의의 파라미터 2개에 대해서 
			
			int result = func.proc1(n1, n2);
			System.out.println(result);
		}
		
		//#4. lambda second
		{
//			MyFuncIF func = (i, j) -> i + j;  //람다식을 가지고와서
//			MyFunc.m(func);					  //전달을 하겠다
			
			//인터페이스를 안쓰고 바로 파라미터로 집어넣겠다 => 파라미터가 람다식? 람다식 == 객체(functional interface를 구현한 객체)
			MyFunc.m((i, j) -> i + j);		  //한줄요약
			MyFunc.m((i, j) -> i - j);		  //연산 가능
			
			//파라미터로 받아서 호출.
		}
		
	}

	static class MyFunc {
		static void m(MyFuncIF func) { //m() 메소드는 파라미터로 Functional Interface를 구현한 객체를 받는다.
			//...
			System.out.println(func.proc1(5, 3));
		}
	}
	
}
