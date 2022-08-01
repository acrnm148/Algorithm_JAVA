package collections.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class ItemSortTest {
	
	
	public static void main(String[] args) {
		
		//#1 Item Class에 Comparable Interface 구현
		{
//			List<Item> al = new ArrayList<Item>();
//			al.add(new Item(1, "item1"));
//			al.add(new Item(3, "item3"));
//			al.add(new Item(2, "item2"));
//			al.add(new Item(2, "item9"));
//			System.out.println(al);
//			
//			Collections.sort(al);
//			//arrList를 소팅하려고 한다. 
//			//Comparable 인터페이스를 implements하지 않아서 안된다
//			System.out.println(al);
		}	
		
		//#2 Comparator Interface 사용
		{
			List<Item> al = new ArrayList<Item>();
			al.add(new Item(1, "item1"));
			al.add(new Item(3, "item3"));
			al.add(new Item(2, "item2"));
			al.add(new Item(2, "item9"));
			System.out.println(al);
//			Collections.sort(al, new Comparator<Item>() { //#2-1 이름이 없는 어나니머스 객체를 만드는 방법
//				@Override
//				public int compare(Item o1, Item o2) {
//					return o1.itemId == o2.itemId? o1.itemNm.compareTo(o2.itemNm) : o1.itemId - o2.itemId;
//				}
//			});
			//즉, 어나니머스 방식으로 하면 따로 하나를 더 만들 필요가 없다. 
			
			
			//#3 람다 lamda - 과감한 생략
			//나머지는 컴파일러가 알아서 할게 , 어차피 니가 뻔한거 할거면 과감히 생략해도 괜찮아
			Collections.sort(al, (o1, o2) -> o1.itemId == o2.itemId? o1.itemNm.compareTo(o2.itemNm) : o1.itemId - o2.itemId);
			
			System.out.println(al);
		}
			
	}
	
	
	//#2를 위해 필요, 그런데 만드는게 많아 복잡 -> #2-1 어나니머스를 써보자.
//	static class ComparatorImpl implements Comparator<Item> {
//
//		@Override
//		public int compare(Item o1, Item o2) {
//			return o1.itemId == o2.itemId? o1.itemNm.compareTo(o2.itemNm) : o1.itemId - o2.itemId;
//		}
//		
//	}
	
	//#1에서 필요====================================================================
	// 이 녀석을 가지는 컬렉션들은 정렬이 가능하고,
	//정렬의 기준은 compareTo
	static class Item { //Comparable is a raw type. =>타입이 제너릭으로 지정되지 않았다.
		int itemId;
		String itemNm;
		
		public Item(int itemId, String itemNm) {
			this.itemId = itemId;
			this.itemNm = itemNm;
		}

		@Override
		public String toString() {
			return "Item [itemId=" + itemId + ", itemNm=" + itemNm + "]";
		}
		
		
		//equals 오버라이딩하니까 먹음
		@Override
		public boolean equals(Object o) {
			if (o != null && o instanceof Item) {
				Item item = (Item) o;
				if (this.itemId == item.itemId && this.itemNm.equals(item.itemNm)) {
					return true;
				}
				return false;
			}
			return false;
		}
		
		@Override
		public int hashCode() {
			return Objects.hash(itemId, itemNm);
		}
		
		//#1에서 필요====================================================================
//		@Override
//		public int compareTo(Item o) { //두개를 비교하고 int를 리턴
//			//1) itemId만으로 정렬을 해보자
//			//natural ordering / 작은거에서 큰걸로 정렬
//			//return this.itemId - o.itemId; //오름차순
//			
//			//2) ItemNm으로 정렬을 해보자
//			return this.itemId == o.itemId? this.itemNm.compareTo(o.itemNm) : this.itemId - o.itemId;
//		}
	}
}
