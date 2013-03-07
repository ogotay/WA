package world.items;

public class GeneralContainer extends GeneralItem {

	private int itemMaximumCapacity = 0;
	
	public GeneralContainer(String itemName, int itemMaximumCapacity){
		super(itemName, ItemSize.NORMAL, ItemType.CONTAINTER);
		this.itemMaximumCapacity = itemMaximumCapacity;
		
	}
}
