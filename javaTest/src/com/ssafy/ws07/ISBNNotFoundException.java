package com.ssafy.ws07;

public class ISBNNotFoundException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//isbn 관리
	private String ISBN;
	public ISBNNotFoundException(String ISBN) {
		super(ISBN + " 도서가 존재하지 않습니다");
		this.ISBN = ISBN;
	}
	public String getIsbn() {
		return this.ISBN;
	}
}
