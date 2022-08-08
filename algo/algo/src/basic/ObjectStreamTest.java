package basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
 * 직렬화 방법
 * */
public class ObjectStreamTest {
    public static void main(String[] args) {
        write(); //직렬화 Serializable
        read();	 //역직렬화 Deserializable
    }
    
    private static File target = new File("c:/Temp/objPerson.dat");
    //.dat : byte로 저장된 파일
    
    //직렬화 Serialization ==> 바이트화
    private static void write() {
    	//1. 객체 생성
        Person person = new Person("홍길동2", "pass1234", "123-456", "seoul");
        // TODO: person을 target에 저장하시오. 
        
        //2. 객체를 byte파일(.dat)에 저장 - try-catch(IOException e)
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(target))) {
        	out.writeObject(person);
        	System.out.println("");
        } catch (IOException e) {
        	e.printStackTrace();
        }
        // END:
    }
    
    //역직렬화 Deserialization ==> 객체화
    private static void read() {
        // TODO: target에서 person을 읽어서 내용을 출력하시오.
    	
    	//1. byte파일에서 객체 읽어옴, instanceof 검사 후 사용. try-catch(IOException, ClassNotFoundException)
    	try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(target));){
    		Object obj = in.readObject();
    		if (obj != null && obj instanceof Person) {
    			Person p = (Person) obj;
    			System.out.println(p);
    		}
    	} catch (IOException e) {
    		e.printStackTrace();
    	}catch (ClassNotFoundException e) {
    		e.printStackTrace();
    	}
        // END:
    }
}