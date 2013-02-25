package character;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import org.junit.Before;
import org.junit.Test;

public class FirstAidKitTest {
	private static final int ZERO = 0;
	private FirstAidKit firstAidKit = null;
	private FirstAidKit firstAidKit2 = null;
	
	@Before
	public void setup(){
		firstAidKit = new FirstAidKit(11);
		firstAidKit2 = new FirstAidKit(2);
	}
	
	@Test
	public void shouldSetInternalAttributes(){
		assertThat(firstAidKit.numberOfUnits(), is(equalTo(11)));
		assertThat(firstAidKit2.numberOfUnits(), is(equalTo(2)));
	}
		
	@Test
	public void shouldHaveName(){
		assertThat(firstAidKit.getName().length(), is(greaterThan(ZERO)));
	}
	
	@Test
	public void shouldBeRefilledBySpecifiedUnitsCount(){
		int numberOfUnits = 5;
		int numberOfUnits2 = 3;
		
		int originalNumberOfUnits = firstAidKit.numberOfUnits();
		int originalNumberOfUnits2 = firstAidKit2.numberOfUnits();
		
		firstAidKit.refillBy(numberOfUnits);
		firstAidKit2.refillBy(numberOfUnits);
		
		assertThat(firstAidKit.numberOfUnits(), anyOf(equalTo(originalNumberOfUnits + numberOfUnits), equalTo(firstAidKit.maximumNumberOfUnits())));
		assertThat(firstAidKit2.numberOfUnits(), anyOf(equalTo(originalNumberOfUnits2 + numberOfUnits), equalTo(firstAidKit2.maximumNumberOfUnits())));
		
		firstAidKit.refillBy(numberOfUnits2);
		firstAidKit2.refillBy(numberOfUnits2);
		
		assertThat(firstAidKit.numberOfUnits(), anyOf(equalTo(originalNumberOfUnits + numberOfUnits + numberOfUnits2),equalTo(firstAidKit.maximumNumberOfUnits())));
		assertThat(firstAidKit2.numberOfUnits(), anyOf(equalTo(originalNumberOfUnits2 + numberOfUnits + numberOfUnits2), equalTo(firstAidKit2.maximumNumberOfUnits())));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldThrowExceptionWhenRefilledByNumberOfUnitsLowerThanZero(){
		int numberOfUnits = -1;
		firstAidKit.refillBy(numberOfUnits);		
	}	
	
	@Test
	public void shouldUseUpSpecifiedNumberOfUnits(){
		int numberOfUnits = 1;
		int numberOfUnits2 = 3;
		
		int originalNumberOfUnits = firstAidKit.numberOfUnits();
		int originalNumberOfUnits2 = firstAidKit2.numberOfUnits();
		
		firstAidKit.useUp(numberOfUnits);
		firstAidKit2.useUp(numberOfUnits);
		
		assertThat(firstAidKit.numberOfUnits(), anyOf(equalTo(originalNumberOfUnits - numberOfUnits), equalTo(ZERO)));
		assertThat(firstAidKit2.numberOfUnits(), anyOf(equalTo(originalNumberOfUnits2 - numberOfUnits), equalTo(ZERO)));
		
		firstAidKit.useUp(numberOfUnits2);
		firstAidKit2.useUp(numberOfUnits2);
		
		assertThat(firstAidKit.numberOfUnits(), anyOf(equalTo(originalNumberOfUnits - numberOfUnits - numberOfUnits2), equalTo(ZERO)));
		assertThat(firstAidKit2.numberOfUnits(), anyOf(equalTo(originalNumberOfUnits2 - numberOfUnits - numberOfUnits2), equalTo(ZERO)));
	}
	
	@Test
	public void shouldNotChangeNumberOfUnitsAboveFirstAidKitSize(){
		int numberOfUnits = 7;
		int numberOfUnits2 = 5;
		
		firstAidKit.refillBy(numberOfUnits);
		firstAidKit2.refillBy(numberOfUnits);
		firstAidKit.refillBy(numberOfUnits2);
		firstAidKit2.refillBy(numberOfUnits2);
		
		assertThat(firstAidKit.numberOfUnits(), is(lessThanOrEqualTo(firstAidKit.maximumNumberOfUnits())));
		assertThat(firstAidKit2.numberOfUnits(), is(lessThanOrEqualTo(firstAidKit2.maximumNumberOfUnits())));
	}
	
	@Test
	public void shouldNotChangeNumberOfUnitsBelowZero(){
		int numberOfUnits = 7;
		int numberOfUnits2 = 5;
		
		firstAidKit.useUp(numberOfUnits);
		firstAidKit2.useUp(numberOfUnits);
		firstAidKit.useUp(numberOfUnits2);
		firstAidKit2.useUp(numberOfUnits2);
		
		assertThat(firstAidKit.numberOfUnits(), is(greaterThanOrEqualTo(ZERO)));
		assertThat(firstAidKit2.numberOfUnits(), is(greaterThanOrEqualTo(ZERO)));
	}
	
	
}
