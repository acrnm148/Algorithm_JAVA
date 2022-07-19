package com.ssafy.ws.step3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * B구획의 빌딩 최고 높이 구하기
 */ 
public class BuildingTest_BR {

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("input.txt")); // throws Exception 사용
		//Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine()); //한글자 입력받으면 숫자로 바꿔서 변수에 들어감
		//br.readLine() 빨간줄 : 너 이거 오류나면 어떻게할거야 => 해결방법 : throws Exception
		
		for(int t = 1; t <= TC; t++){
			int N = Integer.parseInt(br.readLine());	// 라인으로 읽어옴 =>char를 짤라줘야함
			char[][] area=new char[N][N];	
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());//스트링을 토큰으로 쪼개줌\
				for(int j=0; j<N; j++) {
					//area[i][j] = st.nextToken().charAt(0);
				}
			}
			int ans=0;
			for(int i=0; i<N; i++) {     	//신도시 부지의 모든 구획을 검색
				for(int j=0; j<N; j++) {
					int bCount=0;			// 가능한 빌딩 크기 변수
					boolean isPark=false;	// 8방에 공원이 있는 지 여부 변수
					
					if(area[i][j]=='B')	{   // 현구획이 빌딩이면
						// 8방이 경계내에 있고  해당 방향이 공원(G)인지 확인
						if(i-1>=0 && area[i-1][j]=='G') 				isPark=true; //상 
						else if(i-1>=0 && j+1<N && area[i-1][j+1]=='G')	isPark=true; //우상
						else if(j+1<N && area[i][j+1]=='G')				isPark=true; //우
						else if(i+1<N && j+1<N &&area[i+1][j+1]=='G')	isPark=true; //우하
						else if(i+1<N && area[i+1][j]=='G')				isPark=true; //하
						else if(i+1<N && j-1>=0 && area[i+1][j-1]=='G')	isPark=true; //좌하
						else if(j-1>=0 && area[i][j-1]=='G')			isPark=true; //좌
						else if(i-1>=0 && j-1>=0 && area[i-1][j-1]=='G')isPark=true; //좌상

						if(!isPark){				// 8방 내에 공원이 없다면  가로행, 세로열에 있는 B구획을 count
							for(int k=0; k<N; k++){ // 세로열 B구획 세기
								if(area[k][j]=='B'){
									bCount++;
								}
								if(area[i][k]=='B'){// 가로행 B구획 세기
									bCount++;
								}
							}
							bCount--;				// 자신 중복제거
						}else {						// 8방 내에 공원이 있다면 가능한 빌딩 높이는 2
							bCount = 2;
						}
						if(bCount>ans) ans=bCount;	// 최대값 갱신
					}
					
				}
			}
			System.out.println("#"+t+" "+ans);
		}
	}
}