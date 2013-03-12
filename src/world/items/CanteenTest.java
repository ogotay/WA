package world.items;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class CanteenTest {
	private static final int ZERO = 0;
	private Canteen canteen = null;
	private Canteen canteen2 = null;
	private final int MAXIMUM_NUMBER_OF_WATER_RATIONS = 4;
	
	private List<Item> createWaterRations(int numberOfWaterRationsToCreate){
		final String RATION_NAME = "Water ration"; 
		List<Item> rations = new ArrayList<Item>(numberOfWaterRationsToCreate);
		
		
		for (int i=0; i<numberOfWaterRationsToCreate; i++){
			Item item = new GeneralItem(RATION_NAME, ItemSize.SMALL, ItemType.WATER);
			rations.add(item);
		}
		
		return rations;
	}
	
	@Before
	public void setUp() throws Throwable {
		canteen = new Canteen();
		canteen2 = new Canteen();
		
		for (Item ration: createWaterRations(4)){
			canteen.insert(ration);
		}
			
		for (Item ration: createWaterRations(1)){
			canteen2.insert(ration);
		}		
	}
	
	@Test
	public void shouldSetInternalAttributes(){
		
		assertThat(canteen.numberOfItems(), is(equalTo(4)));
		assertThat(canteen2.numberOfItems(), is(equalTo(1)));
	}
	
	@Test
	public void shouldHaveName(){
		assertThat(canteen.itemName().length(), is(greaterThan(ZERO)));
	}

	@Test
	public void shouldBeRefilledBySpecifiedNumberOfWaterRations() throws Throwable {
		int numberOfWaterRations = 5;
		int numberOfWaterRations2 = 3;
		
		int originalNumberOfWaterRations = canteen.numberOfItems();
		int originalNumberOfWaterRations2 = canteen2.numberOfItems();
		
		canteen.refillBy(createWaterRations(numberOfWaterRations));
		canteen2.refillBy(createWaterRations(numberOfWaterRations));
		
		assertThat(canteen.numberOfItems(), anyOf(equalTo(originalNumberOfWaterRations + numberOfWaterRations), equalTo(MAXIMUM_NUMBER_OF_WATER_RATIONS)));
		assertThat(canteen2.numberOfItems(), anyOf(equalTo(originalNumberOfWaterRations2 + numberOfWaterRations), equalTo(MAXIMUM_NUMBER_OF_WATER_RATIONS)));
		
		canteen.refillBy(createWaterRations(numberOfWaterRations2));
		canteen2.refillBy(createWaterRations(numberOfWaterRations2));
		
		assertThat(canteen.numberOfItems(), anyOf(equalTo(originalNumberOfWaterRations + numberOfWaterRations + numberOfWaterRations2),equalTo(MAXIMUM_NUMBER_OF_WATER_RATIONS)));
		assertThat(canteen2.numberOfItems(), anyOf(equalTo(originalNumberOfWaterRations2 + numberOfWaterRations + numberOfWaterRations2), equalTo(MAXIMUM_NUMBER_OF_WATER_RATIONS)));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldThrowExceptionWhenRefilledByNumberOfWaterRationsEqualToZero() throws Throwable {
		int numberOfWaterRations = 0;
		canteen.refillBy(createWaterRations(numberOfWaterRations));		
	}

	public void shouldThrowExceptionWhenTryToUseUpMoreThanCurrentNumberOfWaterRations() throws Throwable {
		int numberOfUnits = canteen.numberOfItems();
		canteen.useUp(numberOfUnits + 1);		
	}
	
	@Test
	public void shouldUseUpSpecifiedNumberOfWaterRations() throws Throwable{
		int numberOfWaterRations = 1;
		int numberOfWaterRations2 = 3;
		
		int originalNumberOfUnits = canteen.numberOfItems();
		int originalNumberOfUnits2 = canteen2.numberOfItems();
		
		try {
			canteen.useUp(numberOfWaterRations);
			canteen2.useUp(numberOfWaterRations);
		} catch (Throwable e) {

		}
		
		assertThat(canteen.numberOfItems(), anyOf(equalTo(originalNumberOfUnits - numberOfWaterRations), equalTo(ZERO)));
		assertThat(canteen2.numberOfItems(), anyOf(equalTo(originalNumberOfUnits2 - numberOfWaterRations), equalTo(ZERO)));
		
		try {
			canteen.useUp(numberOfWaterRations2);
			canteen2.useUp(numberOfWaterRations2);
		} catch (Throwable e) {

		}
		
		assertThat(canteen.numberOfItems(), anyOf(equalTo(originalNumberOfUnits - numberOfWaterRations - numberOfWaterRations2), equalTo(ZERO)));
		assertThat(canteen2.numberOfItems(), anyOf(equalTo(originalNumberOfUnits2 - numberOfWaterRations - numberOfWaterRations2), equalTo(ZERO)));
	}
	
	@Test
	public void shouldNotChangeNumberOfWaterRationsAboveCanteenSize() throws Throwable {
		int numberOfWaterRations = 1;
		int numberOfWaterRations2 = 2;
		
		canteen.refillBy(createWaterRations(numberOfWaterRations));
		canteen2.refillBy(createWaterRations(numberOfWaterRations));
		canteen.refillBy(createWaterRations(numberOfWaterRations2));
		canteen2.refillBy(createWaterRations(numberOfWaterRations2));
		
		assertThat(canteen.numberOfItems(), is(lessThanOrEqualTo(MAXIMUM_NUMBER_OF_WATER_RATIONS)));
		assertThat(canteen2.numberOfItems(), is(lessThanOrEqualTo(MAXIMUM_NUMBER_OF_WATER_RATIONS)));
	}
	
	@Test
	public void shouldNotChangeNumberOfWaterRationsBelowZero() throws Throwable{
		int numberOfWaterRations = 1;
		int numberOfWaterRations2 = 4;
		
		
		try {
			canteen.useUp(numberOfWaterRations);
			canteen2.useUp(numberOfWaterRations);
			canteen.useUp(numberOfWaterRations2);
			canteen2.useUp(numberOfWaterRations2);
		} catch (Throwable e) {
			
		}
		
		assertThat(canteen.numberOfItems(), is(greaterThanOrEqualTo(ZERO)));
		assertThat(canteen2.numberOfItems(), is(greaterThanOrEqualTo(ZERO)));
	}
}
