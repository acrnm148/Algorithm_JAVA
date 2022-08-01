package lambda;

@FunctionalInterface
public interface MyFuncIF {
	int proc1(int n1, int n2);
	//int proc2(int n1, int n2);//FunctionalInterface 자격요건은 메소드1개이므로 오류남
	
	default int proc2(int n1, int n2) {
		return n1 - n2;
	}; //이럴경우 됨
}
