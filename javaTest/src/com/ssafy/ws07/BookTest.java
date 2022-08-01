package com.ssafy.ws07;

public class BookTest {

	public static void main(String[] args) throws ISBNNotFoundException {
		IBookManager manager = BookManagerImpl.getInstance(); //인터페이스 타입으로 선언, 만드는건 Impl의 getInstance로
		
		manager.add(new Book("1111", "Java", "홍길동", "홍출판", 50000, "Java 관련", 10));
		manager.add(new Book("2222", "OOP", "오길동", " 오출판", 60000, "OOP 관련", 20));
		manager.add(new Magazine("5555", "SSAFY3잡지", "사길동", "사출판", 70000, "Java 관련", 2022, 8, 0));
		manager.add(new Book("3333", "SSAFY", "사길동", "사출판", 70000, "Java 관련", 50));
		manager.add(new Magazine("4444", "SSAFY2잡지", "사길동", "사출판", 70000, "Java 관련", 2022, 7, 0));

		
		System.out.println("***도서 목록***");
		for (Book book : manager.getList()) {
			System.out.println(book);
		}
		
		
		System.out.println("***도서 조회***");
		Book b = manager.searchByIsbn("3333");
		System.out.println(b);
		
		
		System.out.println("***도서 삭제***");
		manager.remove("1111");
		System.out.println(manager.getSize());

		
		System.out.println("***도서 목록***");
		for (Book book : manager.getList()) {
			System.out.println(book);
		}
		
		//add
		System.out.println("***도서구매***");
		try {
			manager.buy("6666", 20);
		} catch (ISBNNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("***도서판매***");
		try {
			manager.sell("1111", 20);
		} catch (QuantityException| ISBNNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
