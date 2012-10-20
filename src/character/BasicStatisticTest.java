package character;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Before;
import org.junit.Test;

import main.CharacterSkillsBoundaries;


public class BasicStatisticTest {

	@Test
	public void shouldHaveInitialValueGreaterThanZero(){
		BasicStatistic stat = new BasicStatistic();
		assertThat(stat.initialValue, greaterThan(0));
	}
	
	@
	
	
	
}
