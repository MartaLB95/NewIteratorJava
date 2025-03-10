package m2_07_Marta_Laveda_Box;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

/**Creamos una clase Bag con un array con genérico T */

public class Bag<T> implements Iterable<T>{

	
public T arrayBag[];
	
	/**Método para añadir un elemento T a la bolsa*/
	
	int index=0;
	
	public void add(T elemento) {
	if(index<arrayBag.length){
		arrayBag[index]=elemento;
		System.out.println(arrayBag[index]);
		index++;
	}else {
		System.out.println("La bolsa está llena");
	}
	}
	

	
	/**Método para saber si un elemento está en la bolsa o no*/
	
	public boolean contains (T elemento) {
		if (isEmpty()) {
	   		 return false;
		}else {
		for(int index3=0;index3<index;index3++) {
		if(arrayBag[index3].equals(elemento)) {
			System.out.println("La bolsa contiene "+ elemento);
			return true;
		}else {
			System.out.println("La bolsa no contiene " + elemento);
		}
		}
		}
		return false;
		
	}
	
	/**Método para saber si la bolsa está vacía o no*/
	
	public boolean isEmpty() {
		if(index==0) {
			System.out.println("La bolsa esta vacía.");
			return true;
		}else {
			System.out.println("La bolsa no está vacía.");
			return false;
		}
	}
	
	/*Método para obtener la cantidad de elementos que contiene la bolsa*/
	
	public int size() {
		
		if(index==1) {
			System.out.println("La bolsa contiene "+arrayBag.length+ " elemento.");
		}else {
		System.out.println("La bolsa contiene "+arrayBag.length+" elementos.");
	}
		return index;
	}
	
	/**Método para vaciar la bolsa*/
	
	public void clear() {
		Arrays.fill(arrayBag, null);
		index=0;
		System.out.println("Hemos vaciado la bolsa");
		}

	/**Método para extraer un elemento aleatorio T de la bolsa (siempre que la bolsa no esté vacía).*/
	
	
	public T extract() { 
    	
   	 if (isEmpty()) {
   		 return null;
   	}else{
   		Random random=new Random();
   		int randomNumber=random.nextInt(index);
   		T elemento=arrayBag[randomNumber];
   		
   	/**Al tratarse de un array, debo asegurarme de que el elemento no se tiene en cuenta, puesto que
   	 * no existe la opción remove del arrayList. También debo desplazar los demás elementos a la izquierda.
   	 */
   		
   		
   		for (int i=randomNumber; i<index-1;i++) {
   			arrayBag[i]=arrayBag[i+1];	
   		}
   		arrayBag[index-1]=null;
   		index--;
   		System.out.println("El elemento extraído es: "+ elemento);
   	
   		
   		return elemento;
   	}
   	
	}
	@Override
	public  BagIterator iterator(){
		return new BagIterator();
	}
	
	public class BagIterator implements Iterator<T>{
		
		int i=0;
		
		@Override 
		
		public boolean hasNext(){
			
			if (i<index) {
			return true;
		}else{
			return false;
		}
		}
		
		@Override
		
		public T next() {
			if(hasNext()) {
				T elemento=arrayBag[i];
					i++;
					return elemento;
				}else{
					throw new IllegalStateException("No hay más elementos");
				}
			
	}

}
	
}