import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int cnt, stuCnt, sex, num;
	static int[] light = new int[101];
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//����ġ ���� �Է�
		cnt = Integer.parseInt(br.readLine());
		//����ġ ���� �Է�
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= cnt; i++) {
			light[i] = Integer.parseInt(st.nextToken());
		}
		
		//�л� �� �Է�
		stuCnt = Integer.parseInt(br.readLine());
		//����, ��ȣ �Է�
		for (int i = 0; i < stuCnt; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			sex = Integer.parseInt(st2.nextToken());
			num = Integer.parseInt(st2.nextToken());
			
			//����ġ ���� ����
			//����
			if (sex == 1) {
				for (int n = num; n <= cnt; n+=num) {
					if (light[n] == 0) light[n] = 1;
					else if (light[n] == 1) light[n] = 0;
				}
			}
			else if (sex == 2) {
				int pre = num - 1;
				int next = num + 1;
				while ((pre >= 1 && next <= cnt) && (light[pre] == light[next])) {
					if (light[pre] == 0 && light[next] == 0) {
						light[pre] = 1;
						light[next] = 1;
					}
					else if (light[pre] == 1 && light[next] == 1) {
						light[pre] = 0;
						light[next] = 0;
					}
					pre--;
					next++;
				}
				if (light[num] == 0) light[num] = 1;
				else if (light[num] == 1) light[num] = 0;
			}
			
		}
		
		
		//����ġ ���� ���
		for (int i = 1; i <= cnt; i++) {
			System.out.print(light[i]+" ");
			if (i % 20 == 0) System.out.println();
		}
	}
}