package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * map[][] 필요없다 계산만 하면됨
 * */
public class BOJ_1074Z {

	static int N, Y, X, cnt, size;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		size = (int) Math.pow(2,N); // ==> Math.pow() 의 리턴타입은 double이므로 int 로 타입캐스팅 해줘야함
		
		//me - 재귀
		divide(0, 0);
		
		/*
		//prof
		int y = 0;
		int x = 0;
		int ans = 0;
		N = (int) Math.pow(2,N);
		while (N>1) {
			//가로, 세로를 반으로 나눠서 4분할
			N/=2;
			//r,c가 4공간 중 어느 곳에 해당하는지를 먼저 판단
			//각 공간에서 r,c값에 따라 ans갱신
			//원점 보정
			if (Y < y + N && X <x + N) { //1구역
				
			} else if (Y < y+N && X >= x + N) { //2구역
				ans += N*N*1;
				x+=N;
			} else if (Y >= y+N && X < x + N) { //3구역
				ans += N*N*2;
				y+=N;
			} else if (Y >= y+N && X >= x + N) { //4구역
				ans += N*N*3;
				y+=N;
				x+=N;
			}
		}
		System.out.println(ans);
		*/
	}
	
	//각 재귀에서 시작값을 정해준다
	static void divide( int y, int x) { //y, x : 사분면의 시작점
		if (size == 1) {
			//개수 출력
			System.out.println(cnt);
			return;
		}
		
		//제일 중요한 코드
		size /=2;
		
		// Y, X 가 있는 사분면만 보면 된다
		//0자리 - y,x set (y,x)
		if (Y < y+size  && X < x + size) { //Y,X가 1구역에 있을 때
			divide(y, x); // y,x: 왼쪽 꼭짓점 시작 위치 size/2:정사각형길이
		}
		// 4자리 - y,x set (y,x+size)
		else if (Y < y+size  && X >= x + size) {
			cnt += (size * size) * 1;
			divide(y, x+size);
		}
		// 8자리 - y,x set (y+size,x)
		else if (Y >= y+size  && X < x + size) {
			cnt += size * size * 2;
			divide(y+size, x);
		}
		// 12자리 - y,x set (y+size,x+size)
		else if (Y >= y+size  && X >= x + size) {
			cnt += size * size * 3;
			divide(y+size, x+size);
		}
	}
}











