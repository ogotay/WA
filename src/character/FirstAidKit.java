package character;

public class FirstAidKit {
	private static final String FIRST_AID_KIT_NAME = "Apteczka";
	private static final int MAXIMUM_NUMBER_OF_UNITS = 12;
	private BasicStatistic units = null;
	
	public FirstAidKit(int numberOfUnits) {
		units = new BasicStatistic(0, MAXIMUM_NUMBER_OF_UNITS, numberOfUnits, FIRST_AID_KIT_NAME);
	}

	public int maximumNumberOfUnits() {
		return MAXIMUM_NUMBER_OF_UNITS;
	}
	
	public int numberOfUnits() {
		return units.getCurrentValue();
	}

	public void refillBy(int numberOfUnits) {
		units.changeCurrentValueBy(numberOfUnits);		
	}

	public void useUp(int numberOfUnits) {
		units.changeCurrentValueBy(Math.abs(numberOfUnits) * -1);		
	}
	
	

	

}