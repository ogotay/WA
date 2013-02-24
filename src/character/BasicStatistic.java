package character;

public class BasicStatistic {
	private int minimumValue = 0;
	private int maximumValue = 0;
	private int currentValue = 0;
	private String statisticName = "";
	
	
	public BasicStatistic(int minimumValue, int maximumValue, int currentValue, String statisticName) {
		this.minimumValue = minimumValue;
		this.maximumValue = maximumValue;
		this.currentValue = currentValue;
		this.statisticName = statisticName;
	}

	public int getMinimumValue() {
		return minimumValue;
	}

	public int getMaximumValue() {
		return maximumValue;
	}

	public int getCurrentValue() {
		return currentValue;
	}

	public void changeCurrentValueBy(int modificator) {
		currentValue = currentValue + modificator;
		
		if (currentValue < minimumValue){
			currentValue = minimumValue;
		}
		
		if (currentValue > maximumValue){
			currentValue = maximumValue;
		}
		
	}

	public void increaseMaximumValueBy(int modificator) {
		if (modificator > 0){
			maximumValue = maximumValue + modificator;
		}
	}

	public String getName() {
		return statisticName;
	}
   
}
