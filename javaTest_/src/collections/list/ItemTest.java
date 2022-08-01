package collections.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class ItemTest {
	
	
	public static void main(String[] args) {
		{
			//ArrayList<Item> al = new ArrayList<Item>();
//			List<Item> al = new ArrayList<Item>();
//			al.add(new Item(1, "item1"));
//			al.add(new Item(2, "item2"));
//			al.add(new Item(3, "item3"));
//			System.out.println(al);
			
//			//1for
//			for (int i = 0; i < al.size(); i++) {
//				Item item = al.get(i);
//				System.out.println(item);
//			}
//			//2Iterator
//			Iterator<Item> itr = al.iterator();
//			while (itr.hasNext()) {
//				Item item = itr.next();
//				System.out.println(item);
//			}
//			//3for - each
//			for (Item item : al) {
//				System.out.println(item);
//			}
			
			//4단순순회 - lambda
//			al.forEach(item -> System.out.println(item));
		}
		
		
		{
			List<Item> al = new ArrayList<Item>();
			al.add(new Item(1, "item1"));
			al.add(new Item(2, "item2"));
			al.add(new Item(2, "item2")); //하나 더 (별개의 객체)
			al.add(new Item(3, "item3"));
			System.out.println(al);
			
			Item item2 = new Item(2, "item2");
			
//			for (int i = 0; i < al.size(); i++) {
//				Item item = al.get(i);
//				if (item.equals(item2)) { //equals가 안먹네? 오버라이딩 안해줬기 때문
//					al.remove(i);
//				}
//			}
			
			
			// Iterator
//			Iterator<Item> itr = al.iterator();
//			while (itr.hasNext()) {
//				Item item = itr.next();
//				if (item.equals(item2)) {
//					itr.remove();
//				}
//			}
			
			//lambda removeIf
			al.removeIf(el -> el.equals(item2));
			
			System.out.println(al);
			
		}
	}
	static class Item {
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
	}
}
