package dayilt0324;

import java.util.ArrayList;
import java.util.Collections;

public class array5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> name = new ArrayList<String>();
		name.add("kim");
		name.add("lee");
		name.add("john");
		
		System.out.println(name);
		System.out.println(name.size());
		System.out.println(name.get(2));
		
		name.remove(1);
		System.out.println(name);
		
		name.set(1, "park");
		System.out.println(name);
		System.out.println(name.size());
		
		name.add(1, "park");
		System.out.println(name);
		
		Collections.sort(name);
		System.out.println(name);
		
		Collections.reverse(name);
		System.out.println(name);
	}

}
