/**
 * @class			: MyListImpl
 * @interface		: MyList
 * @author	 		: Ons mlouki
 * 					  Ons.mlouki@gmail.com
 * 					  
 * 
 * @summary			:  linkedList object 
 * 						based on "external reference" 
 */
package main;

public class MyListImpl implements MyList{
	private Elem start;
	private Elem current;
	private int size;
	
	
	
	public MyListImpl() {
		super();
		start = null;
		current = start;
		size = -1;
	}


	public void add(int e) {
		Elem newElem = new Elem(e, null);
		if(start == null) {
			start = newElem;
			current = start;
		} else {
			current.setNext(newElem);
			current = newElem;
		}
		size++;
	}
	

	public void removeAt(int pos) {
		if (pos > size) {
			throw new ArrayIndexOutOfBoundsException("La taille est " + size + "l'element " + pos + "n'existe donc pas");
		}
		Elem previous = start;
		Elem toRemove = previous;
		if(pos == 0) {
			toRemove = start;
			start=start.getNext();
		} else {
			while(pos-- > 1) 
				previous = previous.getNext();
			toRemove = previous.getNext();
			previous.setNext(toRemove.getNext());
		}
		size--;
	}
	

	public int removeItem(int item) {
		Elem previous = null;
		Elem toRemove = start;
		boolean found = false;
		if(start != null && start.getContent()==item) {
			found = true;
			toRemove = start;
			start=start.getNext();
			size--;
		}
		else {
			while(!found && toRemove != null) {
				previous = toRemove;
				toRemove = toRemove.getNext();
				if(toRemove.getContent()==item) {
					found = true;
                                }
			}
			previous.setNext(toRemove.getNext());
			size--;
		}
		return (toRemove == null) ? null :toRemove.getContent();
			
	}
	
	
	public void setAt(int item, int pos) {
		if(pos > size) {
			throw new ArrayIndexOutOfBoundsException("La taille est " + size + " l'element " + pos + " n'existe donc pas");
		}
		Elem current = start;
		while(pos-- > 0) current = current.getNext();
		current.setContent(item);
	}
	

	
	public int getAt(int pos) {
		if(pos > size) {
			throw new ArrayIndexOutOfBoundsException("La taille est " + size + " l'element " + pos + " n'existe donc pas");
		}
		Elem current = start;
		while(pos-- > 0) current = current.getNext();
		return current.getContent();
	}
	

	
	public int getSize() {
		return size+1;
	}
	
	class Elem {
		private int content;
		private Elem next;
		
		public Elem(int content, Elem next) {
			super();
			this.content = content;
			this.next = next;
		}
		
		public int getContent() {
			return content;
		}
		
		public Elem getNext() {
			return next;
		}
		
		public void setNext(Elem n) {
			next = n;
		}
		
		public void setContent(int c) {
			content = c;
		}
		
	}

	
	public void reset() {
		size = -1;
		start  = null;
		current = start;
	}

}
