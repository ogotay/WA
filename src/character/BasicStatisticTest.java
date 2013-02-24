package character;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;

public class BasicStatisticTest {

	private final int ZERO = 0;
	
	private BasicStatistic statistic = null;
	private BasicStatistic statistic2 = null;
	
	@Before
	public void setup(){
		statistic = new BasicStatistic(0, 12, 3, "Statistic");
		statistic2 = new BasicStatistic(2, 7, 4, "Statistic2");
	}

	@Test
	public void shouldSetInternalAttributes(){
		assertThat(statistic.getMinimumValue(), is(equalTo(0)));
		assertThat(statistic.getMaximumValue(), is(equalTo(12)));
		assertThat(statistic.getCurrentValue(), is(equalTo(3)));
		assertThat(statistic.getName(), is(equalTo("Statistic")));
		
		assertThat(statistic2.getMinimumValue(), is(equalTo(2)));
		assertThat(statistic2.getMaximumValue(), is(equalTo(7)));
		assertThat(statistic2.getCurrentValue(), is(equalTo(4)));
		assertThat(statistic2.getName(), is(equalTo("Statistic2")));
	}
		
	@Test
	public void shouldHaveMinimumValueEqualOrGreaterThanZero(){
		assertThat(statistic.getMinimumValue(), is(greaterThanOrEqualTo(ZERO)));
		assertThat(statistic2.getMinimumValue(), is(greaterThanOrEqualTo(ZERO)));
	}
	
	@Test
	public void shouldHaveMaximumValueEqualOrGreaterThanMinimumValue(){
		assertThat(statistic.getMaximumValue(), is(greaterThanOrEqualTo(statistic.getMinimumValue())));
		assertThat(statistic2.getMaximumValue(), is(greaterThanOrEqualTo(statistic.getMinimumValue())));		
	}
	
	@Test
	public void shouldHaveCurrentValueEqualOrGreaterThanMinimumValue(){
		assertThat(statistic.getCurrentValue(), is(greaterThanOrEqualTo(statistic.getMinimumValue())));
		assertThat(statistic2.getCurrentValue(), is(greaterThanOrEqualTo(statistic.getMinimumValue())));
	}
	
	@Test
	public void shouldHaveCurrentValueEqualOrLowerThanMaximumValue(){
		assertThat(statistic.getCurrentValue(), is(lessThanOrEqualTo(statistic.getMaximumValue())));
		assertThat(statistic2.getCurrentValue(), is(lessThanOrEqualTo(statistic.getMaximumValue())));		
	}	
	
	@Test
	public void shouldCurrentValueNotGoUnderMinimumValue(){
		int modificator = -2;
		int modificator2 = -29;
		
		statistic.changeCurrentValueBy(modificator);
		statistic2.changeCurrentValueBy(modificator);
		
		assertThat(statistic.getCurrentValue(), is(greaterThanOrEqualTo(statistic.getMinimumValue())));
		assertThat(statistic2.getCurrentValue(), is(greaterThanOrEqualTo(statistic2.getMinimumValue())));
		
		statistic.changeCurrentValueBy(modificator2);
		statistic2.changeCurrentValueBy(modificator2);
		
		assertThat(statistic.getCurrentValue(), is(greaterThanOrEqualTo(statistic.getMinimumValue())));
		assertThat(statistic2.getCurrentValue(), is(greaterThanOrEqualTo(statistic2.getMinimumValue())));
	}
	
	@Test
	public void shouldCurrentValueNotGoOverMaximumValue(){
		int modificator = 2;
		int modificator2 = 29;
		
		statistic.changeCurrentValueBy(modificator);
		statistic2.changeCurrentValueBy(modificator);
		
		assertThat(statistic.getCurrentValue(), is(lessThanOrEqualTo(statistic.getMaximumValue())));
		assertThat(statistic2.getCurrentValue(), is(lessThanOrEqualTo(statistic2.getMaximumValue())));
		
		statistic.changeCurrentValueBy(modificator2);
		statistic2.changeCurrentValueBy(modificator2);
		
		assertThat(statistic.getCurrentValue(), is(lessThanOrEqualTo(statistic.getMaximumValue())));
		assertThat(statistic2.getCurrentValue(), is(lessThanOrEqualTo(statistic2.getMaximumValue())));
	}
	
	@Test
	public void shouldIncreaseMaximumValueByModificator(){
		int modificator = 3;
		int modificator2 = 22;
		
		int statisticOriginalMaximumValue = statistic.getMaximumValue();		
		int statistic2OriginalMaximumValue = statistic2.getMaximumValue();
						
		statistic.increaseMaximumValueBy(modificator);
		statistic2.increaseMaximumValueBy(modificator);
		
		assertThat(statistic.getMaximumValue(), is(equalTo(statisticOriginalMaximumValue + modificator)));		
		assertThat(statistic2.getMaximumValue(), is(equalTo(statistic2OriginalMaximumValue + modificator)));		
		
		statistic.increaseMaximumValueBy(modificator2);
		statistic2.increaseMaximumValueBy(modificator2);
				
		assertThat(statistic.getMaximumValue(), is(equalTo(statisticOriginalMaximumValue + modificator + modificator2)));		
		assertThat(statistic2.getMaximumValue(), is(equalTo(statistic2OriginalMaximumValue + modificator + modificator2)));				
	}
	
	@Test
	public void shouldNotIncreaseCurrentValueByModificatorAfterIncreasingMaximumValue(){
		int modificator = 3;
		int modificator2 = 22;
		
		int statisticOriginalCurrentValue = statistic.getCurrentValue();
		int statistic2OriginalCurrentValue = statistic2.getCurrentValue();
		
		statistic.increaseMaximumValueBy(modificator);
		statistic2.increaseMaximumValueBy(modificator);
		
		assertThat(statistic.getCurrentValue(), is(equalTo(statisticOriginalCurrentValue)));
		assertThat(statistic2.getCurrentValue(), is(equalTo(statistic2OriginalCurrentValue)));
		
		statistic.increaseMaximumValueBy(modificator2);
		statistic2.increaseMaximumValueBy(modificator2);
		
		assertThat(statistic.getCurrentValue(), is(equalTo(statisticOriginalCurrentValue)));
		assertThat(statistic2.getCurrentValue(), is(equalTo(statistic2OriginalCurrentValue)));
	}
	
	@Test
	public void shouldNotChangeMaximumValueWhenModificatorIsLowerThanZero(){
		int modificator = -4;
		int modificator2 = -17;
		
		int statisticOriginalMaximumValue = statistic.getMaximumValue();		
		int statistic2OriginalMaximumValue = statistic2.getMaximumValue();
		
		statistic.increaseMaximumValueBy(modificator);
		statistic2.increaseMaximumValueBy(modificator);
		
		assertThat(statistic.getMaximumValue(), is(equalTo(statisticOriginalMaximumValue)));		
		assertThat(statistic2.getMaximumValue(), is(equalTo(statistic2OriginalMaximumValue)));
		
		statistic.increaseMaximumValueBy(modificator2);
		statistic2.increaseMaximumValueBy(modificator2);
		
		assertThat(statistic.getMaximumValue(), is(equalTo(statisticOriginalMaximumValue)));		
		assertThat(statistic2.getMaximumValue(), is(equalTo(statistic2OriginalMaximumValue)));
	}
}
