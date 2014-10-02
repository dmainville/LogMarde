package main;

public interface MyList{
	
	void add(int e);
	void removeAt(int pos);
	int removeItem(int item);
	void setAt(int item, int pos);
	int getAt(int pos);
	int getSize();
	void reset();
	
}
