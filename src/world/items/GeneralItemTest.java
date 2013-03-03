package world.items;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Before;
import org.junit.Test;

public class GeneralItemTest {
	private final int ZERO = 0;
	private final String COMPASS_NAME = "Super compass";
	
	private GeneralItem compass = null;
	
	
	@Before
	public void setUp() throws Exception {
		compass = new GeneralItem(COMPASS_NAME);
	}
	
	@Test
	public void shouldCreateInstanceWithValidName(){
		assertThat(compass.isNamed(COMPASS_NAME), is(true));
		assertThat(compass.name(), is(equalTo(COMPASS_NAME)));
	}
	
	@Test
	public void shouldCreateInstanceWithValidItemType(){
		assertThat(compass.isType(ItemType.GENERAL), is(true));
	}
	
	@Test
	public void shouldCreateInstanceWithDefaultUnwieldinessEqualToZero(){
		assertThat(compass.levelOfUnwieldiness(), is(equalTo(ZERO)));
	}
	
}
