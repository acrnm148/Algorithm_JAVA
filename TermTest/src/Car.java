public class Car {
	private String brand;
	private int cost;
	private char colour;
	
	private Car () {
	}
	
	private Car (String brand) {
		this.brand=brand;
		System.out.println("1번 호출");
	}
	
	private Car (String brand, int cost) {
		this(brand); // -------(3)
		System.out.println("2번 호출");
	}
	
	public Car (String brand, int cost, char colour) {
		this(brand, cost);
		this.colour=colour;
		System.out.println("3번 호출");
	}
}
