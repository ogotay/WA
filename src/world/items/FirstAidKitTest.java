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

public class FirstAidKitTest {

	private static final int ZERO = 0;
	private FirstAidKit firstAidKit = null;
	private FirstAidKit firstAidKit2 = null;
	private final static int FIRST_AID_KIT_MAXIMUM_CAPACITY = 12;
	
	private List<Item> createMedicines(int numberOfMedicineUnitsToCreate){
		final String MEDICINE_NAME = "Pill"; 
		List<Item> medicines = new ArrayList<Item>(numberOfMedicineUnitsToCreate);
		
		
		for (int i=0; i<numberOfMedicineUnitsToCreate; i++){
			Item item = new GeneralItem(MEDICINE_NAME, ItemSize.SMALL, ItemType.MEDICINE);
			medicines.add(item);
		}
		
		return medicines;
	}
	
	@Before
	public void setUp() throws Throwable{
		firstAidKit = new FirstAidKit();
		firstAidKit2 = new FirstAidKit();
		
		for (Item medicine: createMedicines(11)){
			firstAidKit.insert(medicine);
		}
			
		for (Item medicine: createMedicines(2)){
			firstAidKit2.insert(medicine);
		}
	}

	@Test
	public void shouldSetInternalAttributes(){
		assertThat(firstAidKit.numberOfItems(), is(equalTo(11)));
		assertThat(firstAidKit2.numberOfItems(), is(equalTo(2)));
	}
		
	@Test
	public void shouldHaveName(){
		assertThat(firstAidKit.itemName().length(), is(greaterThan(ZERO)));
	}
	
	@Test
	public void shouldBeRefilledBySpecifiedUnitsCount() throws Throwable {
		int numberOfUnits = 5;
		int numberOfUnits2 = 3;
		
		int originalNumberOfUnits = firstAidKit.numberOfItems();
		int originalNumberOfUnits2 = firstAidKit2.numberOfItems();
				
		firstAidKit.refillBy(createMedicines(numberOfUnits));
		firstAidKit2.refillBy(createMedicines(numberOfUnits));
		
		assertThat(firstAidKit.numberOfItems(), anyOf(equalTo(originalNumberOfUnits + numberOfUnits), equalTo(FIRST_AID_KIT_MAXIMUM_CAPACITY)));
		assertThat(firstAidKit2.numberOfItems(), anyOf(equalTo(originalNumberOfUnits2 + numberOfUnits), equalTo(FIRST_AID_KIT_MAXIMUM_CAPACITY)));
		
		firstAidKit.refillBy(createMedicines(numberOfUnits2));
		firstAidKit2.refillBy(createMedicines(numberOfUnits2));
		
		assertThat(firstAidKit.numberOfItems(), anyOf(equalTo(originalNumberOfUnits + numberOfUnits + numberOfUnits2),equalTo(FIRST_AID_KIT_MAXIMUM_CAPACITY)));
		assertThat(firstAidKit2.numberOfItems(), anyOf(equalTo(originalNumberOfUnits2 + numberOfUnits + numberOfUnits2), equalTo(FIRST_AID_KIT_MAXIMUM_CAPACITY)));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldThrowExceptionWhenRefilledByNumberOfUnitsEqualToZero() throws Throwable {
		int numberOfUnits = 0;
		firstAidKit.refillBy(createMedicines(numberOfUnits));		
	}	
	
	@Test
	public void shouldUseUpSpecifiedNumberOfUnits() {
		int numberOfUnits = 1;
		int numberOfUnits2 = 3;
		
		int originalNumberOfUnits = firstAidKit.numberOfItems();
		int originalNumberOfUnits2 = firstAidKit2.numberOfItems();
		
		try {
			firstAidKit.useUp(numberOfUnits);
			firstAidKit2.useUp(numberOfUnits);
		} catch (Throwable e){
			
		}
		
		assertThat(firstAidKit.numberOfItems(), anyOf(equalTo(originalNumberOfUnits - numberOfUnits), equalTo(ZERO)));
		assertThat(firstAidKit2.numberOfItems(), anyOf(equalTo(originalNumberOfUnits2 - numberOfUnits), equalTo(ZERO)));
		
		try {
			firstAidKit.useUp(numberOfUnits2);
			firstAidKit2.useUp(numberOfUnits2);
		} catch (Throwable e) {
			
		}
		
		assertThat(firstAidKit.numberOfItems(), anyOf(equalTo(originalNumberOfUnits - numberOfUnits - numberOfUnits2), equalTo(ZERO)));
		assertThat(firstAidKit2.numberOfItems(), anyOf(equalTo(originalNumberOfUnits2 - numberOfUnits - numberOfUnits2), equalTo(ZERO)));
	}
	
	@Test
	public void shouldNotChangeNumberOfUnitsAboveFirstAidKitSize() throws Throwable {
		int numberOfUnits = 7;
		int numberOfUnits2 = 5;
		
		firstAidKit.refillBy(createMedicines(numberOfUnits));
		firstAidKit2.refillBy(createMedicines(numberOfUnits));
		firstAidKit.refillBy(createMedicines(numberOfUnits2));
		firstAidKit2.refillBy(createMedicines(numberOfUnits2));
		
		assertThat(firstAidKit.numberOfItems(), is(lessThanOrEqualTo(FIRST_AID_KIT_MAXIMUM_CAPACITY)));
		assertThat(firstAidKit2.numberOfItems(), is(lessThanOrEqualTo(FIRST_AID_KIT_MAXIMUM_CAPACITY)));
	}
	
	@Test
	public void shouldNotChangeNumberOfUnitsBelowZero() {
		int numberOfUnits = 7;
		int numberOfUnits2 = 5;

		try {
			firstAidKit.useUp(numberOfUnits);
			firstAidKit2.useUp(numberOfUnits);
			firstAidKit.useUp(numberOfUnits2);
			firstAidKit2.useUp(numberOfUnits2);
		} catch (Throwable e){
			
		}
		
		assertThat(firstAidKit.numberOfItems(), is(greaterThanOrEqualTo(ZERO)));
		assertThat(firstAidKit2.numberOfItems(), is(greaterThanOrEqualTo(ZERO)));
	}	
	
}
