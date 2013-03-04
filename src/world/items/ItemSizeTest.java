package world.items;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;

public class ItemSizeTest {
	private ItemSize smallItem = null;
	private ItemSize normalItem = null;
	private ItemSize bigItem = null;
	
	private final int SMALL = 0;	
	private final int BIG = 2;
	
	@Before
	public void setUp() throws Exception {
		smallItem = ItemSize.SMALL;
		normalItem = ItemSize.NORMAL;
		bigItem = ItemSize.BIG;
	}

	@Test
	public void shouldReturnValidItemSize(){
		assertThat(smallItem.itemSize(), is(equalTo(SMALL)));
		assertThat(bigItem.itemSize(), is(equalTo(BIG)));
	}
	
	@Test
	public void shouldHaveComparableItemSizes(){
		assertThat(smallItem, is(lessThan(normalItem)));
		assertThat(bigItem, is(greaterThan(normalItem)));
		assertThat(bigItem, is(greaterThan(smallItem)));
		
		assertThat(smallItem.itemSize(), is(lessThan(normalItem.itemSize())));
		assertThat(bigItem.itemSize(), is(greaterThan(normalItem.itemSize())));
		assertThat(bigItem.itemSize(), is(greaterThan(smallItem.itemSize())));
		
		ItemSize normalItem2 = ItemSize.NORMAL;
		assertThat(normalItem, is(equalTo(normalItem2)));
		assertThat(normalItem.itemSize(), is(equalTo(normalItem2.itemSize())));
	}	
}
