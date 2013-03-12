package world.items;

public class Backpack extends GeneralContainer {
	private static final String BACKPACK_NAME = "Plecak";
	private static final int MAXIMUM_NUMBER_OF_ITEMS = 10;
	
	public Backpack() {
		super(BACKPACK_NAME, MAXIMUM_NUMBER_OF_ITEMS, ItemType.ANY);		
	}
}
