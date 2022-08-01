package com.ssafy.ws07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookManagerImpl  implements IBookManager{
//	private static int MAX_SIZE = 100;
//	private Book[] books = new Book[MAX_SIZE];
	
	private List<Book> books = new ArrayList<>();
//	private int size = 0; 
	
	private static IBookManager instance = new BookManagerImpl();
	private BookManagerImpl() {}
	public static IBookManager getInstance() {
		return instance;
	}
	
	//====================================
	
	public int getSize() {
		return books.size();
	}
	
	@Override
	public void add(Book book) {
//		if (size < MAX_SIZE) {
//			books.add(book);
//		}
//		else
//			System.out.println("Full");
		books.add(book);
	}
	@Override
	public void remove(String isbn) {
		
//		for (int i = 0; i < size; i++) {
////			if (books[i].getIsbn().equals(isbn)) {
////				books[i] = books[size - 1];
////				books[size - 1] = null;
////				size--;
////				break;
////			}
//			if (books.get(i).getIsbn().equals(isbn)) {
//				books.add(i, books.getsize - 1]);
//				books[size - 1] = null;
//				size--;
//				break;
//			}
//		}
		
		int size = books.size();
		for (int i = 0; i < size; i++) {
			if (books.get(i).getIsbn().equals(isbn)) {
				books.remove(i); // 중복이 허용되지 않으므로 그냥 break로 나와라
				break;
			}
		}
	}
	
	@Override
	public Book[] getList() { // ???
		//return Arrays.copyOfRange(books, 0, size);
		Book[] result = new Book[books.size()];
		return books.toArray(result); // arrayList -> array(배열) 바꿔주는 메소드
	}
	
	@Override
	public Book searchByIsbn(String isbn) {
//		for (int i = 0; i < size; i++) {
//			if (books[i].getIsbn().equals(isbn)) {
//				return books[i];
//			}
//		}
		for (Book book : books) {
			if (book.getIsbn().equals(isbn)) return book;
		}
		return null; //없다는 거니까
	}
	
	@Override
	public Book[] searchByTitle(String title) {
//		int count = 0;
//		for (int i = 0; i < size; i++) {
//			if (books[i].getTitle().contains(title)) { 
//				count++;
//			}
//		}
//		Book[] result = new Book[count];
//		int idx = 0;
//		for (int i = 0; i < size; i++) {
//			if (books[i].getTitle().contains(title)) {
//				result[idx++] = books[i];
//			}
//		}
//		return result;
		ArrayList<Book> temp = new ArrayList<> ();
		for (Book book : books) {
			if (book.getTitle().contains(title)) temp.add(book);
		}
		
		Book[] result = new Book[temp.size()];
		return temp.toArray(result);
	}
	@Override
	public Magazine[] getMagazines() {
//		int count = 0;
//		for (int i = 0; i < size; i++) {
//			if (books[i] instanceof Magazine) { //contains : 내용을 포함한다
//				count++;
//			}
//		}
//		Magazine[] result = new Magazine[count];
//		
//		int idx = 0;
//		for (int i = 0; i < size; i++) {
//			if (books[i] instanceof Magazine) {
//				result[idx++] = (Magazine)books[i];
//			}
//		}
//		return result;
		ArrayList<Magazine> tmp = new ArrayList<>();
		for (Book book : books) {
			if (book instanceof Magazine) {
				tmp.add((Magazine)book); //이게 가능함..?
			}
		}
		
		Magazine[] result = new Magazine[tmp.size()];
		return tmp.toArray(result);
	}
	
	
	@Override
	public Book[] getBooks() {
//		int count = 0;
//		for (int i = 0; i < size; i++) {
//			if (!(books[i] instanceof Magazine)) { //contains : 내용을 포함한다
//				count++;
//			}
//		}
//		Book[] result = new Book[count];
//		
//		int idx = 0;
//		for (int i = 0; i < size; i++) {
//			if (!(books[i] instanceof Magazine)) {
//				result[idx++] = books[i]; 
//			}
//		}
//		return result;
		ArrayList<Book> tmp = new ArrayList<>();
		for (Book book : books) {
			if (!(book instanceof Magazine)) {
				tmp.add(book); //이게 가능함..?
			}
		}
		
		Book[] result = new Book[tmp.size()];
		return tmp.toArray(result);
	}
	
	
	@Override
	public int getTotalPrice() {
		int total = 0;
//		for (int i = 0; i < size; i++) {
//			total += books[i].getPrice();
//		}
		for (Book book : books) {
			total += book.getPrice();
		}
		return total;
	}
	
	
	@Override
	public double getPriceAvg() {
		return getTotalPrice() / books.size();
	}
	@Override
	public void sell(String isbn, int quantity) throws ISBNNotFoundException, QuantityException { // 인터페이스에서도 throws 추가해줘야함
		Book book = searchByIsbn(isbn);
		if (book == null) {
			throw new ISBNNotFoundException(isbn);
		}
		int res = book.getQuantity() - quantity;
		if (res < 0) {
			throw new QuantityException();
		}
		
		book.setQuantity(res);
	}
	@Override
	public void buy(String isbn, int quantity)  throws ISBNNotFoundException{
		Book book = searchByIsbn(isbn);
		if (book == null) {
			throw new ISBNNotFoundException(isbn);
		}
		book.setQuantity(book.getQuantity() + quantity);
		
	}
}
