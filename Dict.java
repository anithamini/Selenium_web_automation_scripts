package sel;

import java.util.List;
import java.util.*;

public class Dict {
	
	

	public static void main(String[] args) {

		 Map<String,String> map = new LinkedHashMap<String,String>();  
		String[] keys= {"a","b","c"};
		String[] values= {"1","2","3"};
		  List<String> names = Arrays.asList("apple,orange,pear".split(",")); 
		  List<String> things = Arrays.asList("123,456,789".split(","));
		  System.out.println(names);
		  System.out.println(things);
		/*ArrayList myList1 = new ArrayList();
		for(String s : keys)
			myList1.add(s);
		ArrayList myList2 = new ArrayList();
		for(String s : values)
			myList2.add(s);*/
		Iterator<String> i1 = names.iterator();
		Iterator<String> i2 = things.iterator();
		while (i1.hasNext() && i2.hasNext()) {
		    map.put(i1.next(), i2.next());
		}
		System.out.println(map);
		
	}
}
