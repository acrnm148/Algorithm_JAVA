package basic;

import java.io.Serializable;

/*
 * 클래스를 직렬화 가능하게 하는 방법
 * implements Serializable
 * 끝.
 * Serializable을 implements해줬으면 serialVersionUID 선언해주는게 좋다. 없으면 컴파일러가 새로 생성하는데 수정 시 직렬화가 안될수도있다?
 * */
// TODO: Person 을 직렬화 가능하도록 처리하시오.
//@SuppressWarnings("serial") //최대한 안쓰는게 낫다
public class Person implements Serializable{	//직렬화 하는 방법 : implements Serializble 해주면 끝.
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
    private transient String pass; // 민감한 데이터
    private Address addr; // has a 관계의 다른 객체

    public Person(String id, String pass, String zipCode, String city) {
        this.id = id;
        this.pass = pass;
        this.addr = new Address(zipCode, city);
    }

    @Override
    public String toString() {
        return "[id=" + id + ", pass=" + pass + ", addr=" + addr + "]";
    }

     class Address implements Serializable{
        private String zipCode;
        private String city;

        public Address(String zipCode, String city) {
            this.zipCode = zipCode;
            this.city = city;
        }

        public String toString() {
            return "Address [zipCode=" + zipCode + ", city=" + city + "]";
        }
    }
}