package basic;

public class BASIC_Array_Circular {

	public static void main(String[] args) {
		char[] input = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
		int n = input.length;
		
		//normal
//		{
//			for (int i = 0; i < n; i++) {
//				System.out.printf("%2s", input[i]);
//			}
//		}
		
		//normal * 2
//		{
//			for (int i = 0; i < n * 2; i++) {
//				System.out.printf("%2s", input[i]);
//			}
//		}
		
//		{
//			for (int i = 0; i < n * 2; i++) {
//				System.out.printf("%2s", input[i%n]);
//			}
//		}
		
//		{
//			for (int i = 0; i < n * 2 + 5; i++) {
//				System.out.printf("%2s", input[i%n]);
//			}
//		}
		
		//while
//		{
//			int cnt = 0;
//			int i = 0;
//			while (true) {
//				if (cnt == 20)
//					break;
//				System.out.printf("%2s", input[i%n]);
//				cnt++;
//				i++;
//			}
//		}
		
		{
		    int [][] intArray = 
		        { { 1, 2, 3, 4, 5 },
		          { 6, 7, 8, 9,10 },
		          {11,12,13,14,15 },
		          {16,17,18,19,20 },
		          } ;
		    for (int i = 0; i < intArray.length; i += 5) {
		    	for (int j = i; j >= 0; j-=4) {
		    		System.out.print(intArray[j] + " ");
		    	}
		    	System.out.println();
		    }
		}
		

	}

}
