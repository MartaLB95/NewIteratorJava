package m2_07_Marta_Laveda_Box;

import java.util.Iterator;

public class Aplicacion {

	public static <T> void main(String[] args) {
		// TODO Auto-generated method stub

		Bag<String> bag = (Bag<String>) new Bag<T>();
		bag.arrayBag = new String[10];
		
		bag.add("aguacate");
		bag.add("kiwi");
		bag.add("queso de cabra");
		bag.clear();
		bag.add("arroz");
		bag.add("canela");
		bag.extract();
		bag.add("pasta");
		bag.add("mantequilla");
		bag.add("patatas");
		bag.size();
		bag.isEmpty();
		
		
		for (Iterator <String> s=bag.iterator();s.hasNext();){
			System.out.println(s.next());
		}
	
	
		for(String s:bag) {
			System.out.println(s);
		}
		
		while(bag.isEmpty()==false){
			System.out.println(bag.extract());
		}
	}

}
