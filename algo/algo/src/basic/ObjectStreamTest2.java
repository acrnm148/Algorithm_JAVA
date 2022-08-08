package basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectStreamTest2 {

	public static void main(String[] args) {
		write(); //직렬화 Serialization : 객체 => 바이트
		read();	//역직렬화 Deserialization : 바이트 => 객체
	}
	
	private static File target = new File("c:/Temp/serialization_test.dat");
	
	//Serialization 직렬화
	private static void write() {
		//1. 객체 생성
		Person2 per = new Person2();
		per.setId(1);
		per.setPw(1);
		//2. byte에 객체를 넣어줌 - try-with-resources 사용, 다쓰면 알아서 close()해주기 때문
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(target))){
			oos.writeObject(per); //ObjectOutputStream에 Person2객체를 보내서 객체 바이트로 만들어줌 : writeObject
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Deserialization 역직렬화
	private static void read() {
		//try-with-resources 사용
		//1. writeObject()해서 byte가 된 녀석을 다시 클래스화 할것이다. 먼저 byte된 아이를 받아옴
		try( ObjectInputStream ois = new ObjectInputStream(new FileInputStream(target))) {
			Object obj = ois.readObject();	//1. 먼저 객체에 넣어줌!!!
			if (obj != null && obj instanceof Person2) { //equals에서 걸러줄 때랑 똑같이 해줌
				Person2 p = (Person2)obj;
				System.out.println(p);
			}
		} catch(IOException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}
