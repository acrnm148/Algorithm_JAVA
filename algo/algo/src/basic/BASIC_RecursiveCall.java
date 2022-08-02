package basic;

public class BASIC_RecursiveCall {
	
	public static void main(String[] args) {
//		m1();
//		m2();
//		m2_correct();
//		m2_correct2();
//		m3(5);
		m4(0);
	}
	
	static int m1_cnt = 10;;
	static void m1() {
//		{
//			System.out.println("m1()");
//			m1();
//		}
//		{
//			//local 변수는 항상 새롭게 만들어진다
//			int i = 10;
//			System.out.println("m1 : i " + i++); //++의미없다
//			m1();
//		}
		{
			//static 변수는 
			System.out.println("m1 : m1_cnt " + m1_cnt++); //++의미없다
			m1();
			
		}
	}
	
//	static int m2_cnt = 5;
//	static void m2() {
//		System.out.println("1번호출 m2_cnt : " + m2_cnt);
//		
//		if (m2_cnt > 0) {
//			m2_cnt--;
//			m2();
//		}
//		System.out.println("2번호출 m2_cnt : " + m2_cnt);
//		
//	}
	
	// 시작 log가 한번 더 실행된다
	// 5-4-3-2-1 - 1-2-3-4-5 출력하고싶은데 뒷부분이 0-0-0-0-0 출력된다.
//	static int m2_correct_cnt = 5;
//	static void m2_correct() {
//		//끝내는 조건 앞에 있는 코드는 한번더 실행된다
//		System.out.println("1번호출 m2_correct_cnt : " + m2_correct_cnt);
//		
//		if (m2_correct_cnt == 0) { //끝내는 조건
//			return;
//		}
//		
//		m2_correct_cnt--;
//		m2_correct();
//		
//		//끝내는 조건 위에 있는 코드는 필요한 만큼 실행된다
//		System.out.println("2번호출 m2_correct_cnt : " + m2_correct_cnt);
//		
//	}
	
//	static int m2_correct2_cnt = 5;
//	static void m2_correct2() {
//		// 기저조건이 맨 위로
//		if (m2_correct2_cnt == 0) { //끝내는 조건 (기저조건)
//			return;
//		}
//		
//		//끝내는 조건 앞에 있는 코드는 한번더 실행된다
//		System.out.println("1번호출 m2_correct_cnt : " + m2_correct2_cnt);
//		
//		m2_correct2_cnt--;
//		m2_correct2();
//		m2_correct2_cnt++;//호출다끝나면 실행
//		
//		//끝내는 조건 위에 있는 코드는 필요한 만큼 실행된다
//		System.out.println("2번호출 m2_correct_cnt : " + m2_correct2_cnt);
//		
//	}


	static void m3(int m3_cnt) {
		//파라미터의 m3_cnt 값은 재귀호출을 하면서 계속 감소해서 전달될 것이다
		
		// 기저조건이 맨 위로
		if (m3_cnt == 0) { //끝내는 조건 (기저조건)
			return;
		}
		
		//기저조건끝내고 하고싶은거 한다
		//끝내는 조건 앞에 있는 코드는 한번더 실행된다
		System.out.println("1번호출 m3_cnt : " + m3_cnt);

		//1번 방법 - 잘된다.
//		m3_cnt--;
//		m3(m3_cnt); //===============끝나는 시점
//		m3_cnt++;//호출다끝나면 실행
		
		//2번 방법
//		m3(--m3_cnt); //=============끝나는 시점
//		m3_cnt++;
		
		//3번 방법
		m3(m3_cnt - 1); //=============끝나는 시점
		
//		//끝내는 조건 위에 있는 코드는 필요한 만큼 실행된다
//		System.out.println("2번호출 m3_cnt : " + m3_cnt);
		
	}
	
	static int[] m4_intArray = {1,2,3,4,5,6,7,8,9,10};
	static int m4_even_cnt = 0;
	static int m4_even_sum = 0;
	//미션 : m4_event_cnt, m4_even_sum 출력
	//시작은 0부터 파라미터 전달
	static void m4(int m4_cnt) {
		
		
		//1. 기저조건 (탈출하기 위한 조건)
		if (m4_cnt == m4_intArray.length) { 
			
			//complete code
			System.out.println(m4_even_cnt);
			System.out.println(m4_even_sum);
			return;
		}
		
		//2. 하고싶은 일 : 짝수 cnt, sum 계산
		if (m4_intArray[m4_cnt] % 2 == 0) {
			m4_even_cnt++;
			m4_even_sum += m4_intArray[m4_cnt];
		}
		//3. 재귀호출
		m4(m4_cnt + 1);
	}
}
