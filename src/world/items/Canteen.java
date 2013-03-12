package world.items;

import java.util.Collection;

public class Canteen extends GeneralContainer {
	private static final int MAXIMUM_NUMBER_OF_WATER_RATIONS = 4;
	private static final String CANTEEN_NAME = "Manierka";
		
	public Canteen() {
		super(CANTEEN_NAME, MAXIMUM_NUMBER_OF_WATER_RATIONS, ItemType.WATER);		
	}

	public void useUp(int numberOfWaterRations) throws Throwable {
		for (int i=numberOfWaterRations; i>0; i--){
			this.remove();
		}		
	}

	public void refillBy(Collection<Item> waterRations) throws Throwable {
		if (waterRations.size() <= 0) {
			throw new IllegalArgumentException("Cannot refill canteen by number of water rations lower than or equal to zero: "+ Integer.toString(waterRations.size()));
		}
		
		for (Item item: waterRations){
			if (this.numberOfItems() < MAXIMUM_NUMBER_OF_WATER_RATIONS)
			  insert(item);
		}		
	}

}
