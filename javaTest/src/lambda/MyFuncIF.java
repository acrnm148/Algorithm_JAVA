package lambda;

@FunctionalInterface
public interface MyFuncIF { //인터페이스에는 바디가 없다. 그래서 메소드이름으로 구분함. 메소드이름 중요함!!
	int proc1(int n1, int n2);
	//int proc2(int n1, int n2);//FunctionalInterface 자격요건은 메소드1개이므로 오류남
	
	default int proc2(int n1, int n2) {
		return n1 - n2;
	}; //이럴경우 됨
}
