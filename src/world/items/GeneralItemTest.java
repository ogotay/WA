package world.items;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Before;
import org.junit.Test;

public class GeneralItemTest {

	private static final int ZERO = 0;
	private Item item;
	private String itemName = "Compass";
	
	@Before
	public void setUp() throws Exception {
		item = new GeneralItem(itemName);
	}
	
	@Test
	public void shouldCreateInstanceWithValidName(){
		assertThat(item.itemName(), is(equalTo(itemName)));
	}
	
	@Test
	public void shouldHaveCaseSensitiveName(){
		assertThat(item.itemName(), is(not(equalTo(itemName.toLowerCase()))));
		assertThat(item.itemName(), is(not(equalTo(itemName.toUpperCase()))));
	}
	
	@Test
	public void shouldCreateInstanceWithGeneralItemType(){
		assertThat(item.itemType(), is(equalTo(ItemType.GENERAL)));
	}
	
	@Test
	public void shouldCreateInstanceWithNormalSize(){
		assertThat(item.itemSize(), is(equalTo(ItemSize.NORMAL)));
	}
	
	@Test
	public void shouldNotModifyAnyTypeOfSkill(){
		assertThat(item.skillModificator(null), is(equalTo(ZERO)));
	}
}
