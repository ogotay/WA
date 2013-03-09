package world.items;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Before;
import org.junit.Test;

public class GeneralItemTest {

	private static final int ZERO = 0;
	private Item defaultItem;
	private Item specifiedItem;
	private Item fullySpecifiedItem;
	
	private String defaultItemName = "Compass";
	private String specifiedItemName = "Stone club";
	private String fullySpecifiedItemName = "Pill";
	
	private ItemSize specifiedItemSize = ItemSize.BIG;
	private ItemSize fullySpecifiedItemSize = ItemSize.SMALL;
	
	private ItemType fullySpecifiedItemType = ItemType.MEDICINE;
	
	@Before
	public void setUp() throws Exception {
		defaultItem = new GeneralItem(defaultItemName);
		specifiedItem = new GeneralItem(specifiedItemName, specifiedItemSize);
		fullySpecifiedItem = new GeneralItem(fullySpecifiedItemName, fullySpecifiedItemSize, fullySpecifiedItemType);
	}
	
	@Test
	public void shouldCreateInstanceWithValidName(){
		assertThat(defaultItem.itemName(), is(equalTo(defaultItemName)));
		assertThat(specifiedItem.itemName(), is(equalTo(specifiedItemName)));
		assertThat(fullySpecifiedItem.itemName(), is(equalTo(fullySpecifiedItemName)));
	}
	
	@Test
	public void shouldHaveCaseSensitiveName(){
		assertThat(defaultItem.itemName(), is(not(equalTo(defaultItemName.toLowerCase()))));
		assertThat(defaultItem.itemName(), is(not(equalTo(defaultItemName.toUpperCase()))));
	}
	
	@Test
	public void shouldCreateInstanceWithGeneralItemType(){
		assertThat(defaultItem.itemType(), is(equalTo(ItemType.GENERAL)));
	}
	
	@Test
	public void shouldCreateInstanceWithNormalSizeAsDefaultSize(){
		assertThat(defaultItem.itemSize(), is(equalTo(ItemSize.NORMAL)));
	}
	
	@Test
	public void shouldCreateInstanceWithSpecifiedItemSize(){
		assertThat(specifiedItem.itemSize(), is(equalTo(specifiedItemSize)));
		assertThat(fullySpecifiedItem.itemSize(), is(equalTo(fullySpecifiedItemSize)));
	}
	
	@Test
	public void shouldCreateInstanceWithSpecifiedItemType(){
		assertThat(fullySpecifiedItem.itemType(), is(equalTo(fullySpecifiedItemType)));
	}
	
	@Test
	public void shouldNotModifyAnyTypeOfSkill(){
		assertThat(defaultItem.skillModificator(null), is(equalTo(ZERO)));
	}
	
	@Test
	public void shouldReturnEmptyIterator(){
		assertThat(defaultItem.iterator().hasNext(), is(equalTo(false)));
	}
}
