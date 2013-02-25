package character;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

import org.junit.Before;
import org.junit.Test;

public class CanteenTest {
	private static final int ZERO = 0;
	private Canteen canteen = null;
	private Canteen canteen2 = null;
	
	@Before
	public void setup(){
		canteen = new Canteen(4);
		canteen2 = new Canteen(1);
	}
	
	@Test
	public void shouldSetInternalAttributes(){
		assertThat(canteen.numberOfWaterRations(), is(equalTo(4)));
		assertThat(canteen2.numberOfWaterRations(), is(equalTo(1)));
	}
	
	@Test
	public void shouldHaveName(){
		assertThat(canteen.getName().length(), is(greaterThan(ZERO)));
	}

	@Test
	public void shouldBeRefilledBySpecifiedNumberOfWaterRations(){
		int numberOfWaterRations = 5;
		int numberOfWaterRations2 = 3;
		
		int originalNumberOfWaterRations = canteen.numberOfWaterRations();
		int originalNumberOfWaterRations2 = canteen2.numberOfWaterRations();
		
		canteen.refillBy(numberOfWaterRations);
		canteen2.refillBy(numberOfWaterRations);
		
		assertThat(canteen.numberOfWaterRations(), anyOf(equalTo(originalNumberOfWaterRations + numberOfWaterRations), equalTo(canteen.maximumNumberOfWaterRations())));
		assertThat(canteen2.numberOfWaterRations(), anyOf(equalTo(originalNumberOfWaterRations2 + numberOfWaterRations), equalTo(canteen2.maximumNumberOfWaterRations())));
		
		canteen.refillBy(numberOfWaterRations2);
		canteen2.refillBy(numberOfWaterRations2);
		
		assertThat(canteen.numberOfWaterRations(), anyOf(equalTo(originalNumberOfWaterRations + numberOfWaterRations + numberOfWaterRations2),equalTo(canteen.maximumNumberOfWaterRations())));
		assertThat(canteen2.numberOfWaterRations(), anyOf(equalTo(originalNumberOfWaterRations2 + numberOfWaterRations + numberOfWaterRations2), equalTo(canteen2.maximumNumberOfWaterRations())));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldThrowExceptionWhenRefilledByNumberOfWaterRationsLowerThanZero(){
		int numberOfWaterRations = -1;
		canteen.refillBy(numberOfWaterRations);		
	}
	
	@Test
	public void shouldUseUpSpecifiedNumberOfWaterRations(){
		int numberOfWaterRations = 1;
		int numberOfWaterRations2 = 3;
		
		int originalNumberOfUnits = canteen.numberOfWaterRations();
		int originalNumberOfUnits2 = canteen2.numberOfWaterRations();
		
		canteen.useUp(numberOfWaterRations);
		canteen2.useUp(numberOfWaterRations);
		
		assertThat(canteen.numberOfWaterRations(), anyOf(equalTo(originalNumberOfUnits - numberOfWaterRations), equalTo(ZERO)));
		assertThat(canteen2.numberOfWaterRations(), anyOf(equalTo(originalNumberOfUnits2 - numberOfWaterRations), equalTo(ZERO)));
		
		canteen.useUp(numberOfWaterRations2);
		canteen2.useUp(numberOfWaterRations2);
		
		assertThat(canteen.numberOfWaterRations(), anyOf(equalTo(originalNumberOfUnits - numberOfWaterRations - numberOfWaterRations2), equalTo(ZERO)));
		assertThat(canteen2.numberOfWaterRations(), anyOf(equalTo(originalNumberOfUnits2 - numberOfWaterRations - numberOfWaterRations2), equalTo(ZERO)));
	}
	
	@Test
	public void shouldNotChangeNumberOfWaterRationsAboveCanteenSize(){
		int numberOfWaterRations = 1;
		int numberOfWaterRations2 = 2;
		
		canteen.refillBy(numberOfWaterRations);
		canteen2.refillBy(numberOfWaterRations);
		canteen.refillBy(numberOfWaterRations2);
		canteen2.refillBy(numberOfWaterRations2);
		
		assertThat(canteen.numberOfWaterRations(), is(lessThanOrEqualTo(canteen.maximumNumberOfWaterRations())));
		assertThat(canteen2.numberOfWaterRations(), is(lessThanOrEqualTo(canteen2.maximumNumberOfWaterRations())));
	}
	
	@Test
	public void shouldNotChangeNumberOfWaterRationsBelowZero(){
		int numberOfWaterRations = 1;
		int numberOfWaterRations2 = 4;
		
		canteen.useUp(numberOfWaterRations);
		canteen2.useUp(numberOfWaterRations);
		canteen.useUp(numberOfWaterRations2);
		canteen2.useUp(numberOfWaterRations2);
		
		assertThat(canteen.numberOfWaterRations(), is(greaterThanOrEqualTo(ZERO)));
		assertThat(canteen2.numberOfWaterRations(), is(greaterThanOrEqualTo(ZERO)));
	}
}
