package dayilt0324;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class list1 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("kim");
		list.add("lee");
		list.add("park");

		Iterator<String> iterator = list.iterator();

		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println("-----------------");

		for (String name : list) {
			System.out.println(name);
		}

		System.out.println("------------------");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		// TODO Auto-generated method stub

	}

}
