package com.ssafy.ws07;

public class Magazine extends Book{
	private int year;
	private int month;
	
	public Magazine() {}
	public Magazine(String isbn, String title, String author, String publisher, int price, String desc, 
			int year, int month, int quantity) {
		//super.isbn = isbn;
		super(); // 생성자로 값 set String isbn, String title, String author, String publisher, int price, String desc, int quantity
		this.year = year;
		this.month = month;
	}
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	@Override
	public String toString() {
		return super.toString() + "Magazine [year=" + year + ", month=" + month + "]";
		//return "Magazine [isbn=" + super.getIsbn()
	}
	
	
}
