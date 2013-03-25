package world.items;

import java.util.ArrayList;
import java.util.Iterator;

public class GeneralContainer extends GeneralItem implements Container {

	private int itemMaximumCapacity = 0;
	private ItemType allowedItemType = null;

	private ArrayList<Item> itemsList = null; 

	private void internalsSetup(int maximumCapacity, ItemType allowedItemType){
		this.itemMaximumCapacity = maximumCapacity;
		this.allowedItemType = allowedItemType;
		this.itemsList = new ArrayList<Item>(itemMaximumCapacity);
	}

	public GeneralContainer(String itemName, int itemMaximumCapacity){
		super(itemName, ItemSize.NORMAL, ItemType.CONTAINER);
		internalsSetup(itemMaximumCapacity, ItemType.ANY);
	}

	public GeneralContainer(String itemName, int itemMaximumCapacity, ItemType allowedItemType) {
		super(itemName, ItemSize.NORMAL, ItemType.CONTAINER);
		internalsSetup(itemMaximumCapacity, allowedItemType);		
	}

	@Override
	public void insert(Item item) throws Throwable {
		if (itemsList.size() == itemMaximumCapacity) {
			throw new Exception("Container "+ itemName() +" is already full.");
		}

		if (item.itemType().equals(allowedItemType) || allowedItemType.equals(ItemType.ANY)){
			itemsList.add(item);
		} else {
			throw new IllegalArgumentException("Container "+ itemName() +" can hold only "+ allowedItemType +" items.");
		}		
	}

	@Override
	public int numberOfItems() {
		return itemsList.size();
	}

	@Override
	public Item remove(String itemName) throws Throwable {
		Item item = null;
		try {
			item = find(itemName);
		} catch (Throwable t){
			throw new Exception(itemName() +" does not contain "+ itemName +" to remove.");
		}

		if (itemsList.remove(item)){
			return item;
		} else {
			throw new Exception("Error while trying to remove "+ itemName +" from "+ itemName());
		}
	}

	
	@Override
	public Item remove() throws Throwable {
		Item item = null;
		
		if (!itemsList.isEmpty()) {
			item = itemsList.remove(0);
		} else {
			throw new Exception(itemName() +" is empty.");
		}
		
		return item;
	}	
	
	@Override
	public void removeAllItems() {
		itemsList.clear();
	}

	@Override
	public Item find(String itemName) throws Throwable {
		for (Item item: itemsList){
			if (item.itemName().equals(itemName)){
				return item;
			}
		}

		throw new Exception("Item "+ itemName +" not found in "+ itemName());
	}

	public Iterator<Item> iterator(){
		return this.itemsList.iterator();
	}
}
