package lambda;

public class MyFuncIFImpl implements MyFuncIF{
	
	@Override
	public int proc1(int n1, int n2) {
		return n1 + n2; // 더하기
	}
}
