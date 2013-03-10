package world.items;

import java.util.Collection;

public class FirstAidKit extends GeneralContainer {
	private final static String FIRST_AID_KIT_NAME = "Apteczka";
	private final static int FIRST_AID_KIT_MAXIMUM_CAPACITY = 12;
	
	
	public FirstAidKit() {
		super(FIRST_AID_KIT_NAME, FIRST_AID_KIT_MAXIMUM_CAPACITY, ItemType.MEDICINE);
	}


	public void refillBy(Collection<Item> medicineUnits) throws Throwable {
		if (medicineUnits.size() <= 0) {
			throw new IllegalArgumentException("Cannot refill first aid kit by number of units lower than or equal to zero: "+ Integer.toString(medicineUnits.size()));
		}
		
		for (Item item: medicineUnits){
			if (this.numberOfItems() < FIRST_AID_KIT_MAXIMUM_CAPACITY)
			  insert(item);
		}		
	}


	public void useUp(int numberOfMedicineUnits) throws Throwable {
		for (int i=numberOfMedicineUnits; i>0; i--){
			this.remove();
		}
		
	}
}
