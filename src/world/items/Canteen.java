package world.items;

import world.BasicStatistic;

public class Canteen extends GeneralItem {
	private static final int MAXIMUM_NUMBER_OF_RATIONS = 4;
	private static final String CANTEEN_NAME = "Manierka";
	private static final String CANTEEN_RATIONS_NAME = "Racje wody";
	
	private BasicStatistic waterRations = null;
		
	public Canteen(int numberOfWaterRations) {
		super(CANTEEN_NAME);
		waterRations = new BasicStatistic(0, MAXIMUM_NUMBER_OF_RATIONS, numberOfWaterRations, CANTEEN_RATIONS_NAME);
	}

	public int numberOfWaterRations() {
		return waterRations.getCurrentValue();
	}

	public void refillBy(int numberOfWaterRations) {
		if (numberOfWaterRations <= 0){
			throw new IllegalArgumentException("Cannot refill canteen by number of water rations lower than or equal to zero: "+ Integer.toString(numberOfWaterRations)+".");
		}
		
		waterRations.changeCurrentValueBy(numberOfWaterRations);		
	}

	public int maximumNumberOfWaterRations() {
		return MAXIMUM_NUMBER_OF_RATIONS;
	}

	public void useUp(int numberOfWaterRations) {
		waterRations.changeCurrentValueBy(Math.abs(numberOfWaterRations) * -1);		
	}

	public String getName() {
		return CANTEEN_NAME;
	}

}
