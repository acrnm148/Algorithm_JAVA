package basic;

import java.io.Serializable;

/*
 * 직렬화 하는법
 * 1) byte변환을 원하는 클래스에 implements Serializable (import 해줘야함)
 * */
public class Person2 implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private int pw;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPw() {
		return pw;
	}
	public void setPw(int pw) {
		this.pw = pw;
	}
	@Override
	public String toString() {
		return "Person2 [id=" + id + ", pw=" + pw + "]";
	}
	
}
