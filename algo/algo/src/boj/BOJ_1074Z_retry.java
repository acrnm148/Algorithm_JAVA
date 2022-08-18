package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 분할정복
 * */
public class BOJ_1074Z_retry {
	
	static int N, r, c, cnt;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		N = (int)Math.pow(2, N); //pow의 리턴타입은 double. int로 타입캐스팅 해줘야함
		find(0, 0, N);
		
	}
	
	static void find(int y, int x, int size) { //y,x는 각 구역 시작위치
		if (size == 1) { //size가 1인 동시에 r,c 위치
			System.out.println(cnt);
			return;
		}
		
		size /= 2;
		
		//1. 사분면 찾기
		//1구역
		if (r < y + size && c < x+size) { 
			find(y, x, size);
		}
				
		//2구역
		if (r < y + size && c >= x+size) { 
			cnt = cnt + size*size;
			find(y, x+size, size); //시작점을 구역의 첫점으로 설정
		}	
				
		//3구역
		if (r >= y + size && c < x+size) { 
			cnt = cnt + size*size * 2;
			find(y+size, x, size);
		}	
				
		//4구역
		if (r >= y + size && c >= x+size) { 
			cnt = cnt + size*size * 3;
			find(y+size, x+size, size);
		}		
		
	}

}


