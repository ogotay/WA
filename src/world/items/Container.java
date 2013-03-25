package world.items;

public interface Container extends Item {	
	int numberOfItems();
	
	void insert(Item item) throws Throwable;
	Item find(String itemName) throws Throwable;
	Item remove(String itemName) throws Throwable;
	Item remove() throws Throwable;
	void removeAllItems();	
}
