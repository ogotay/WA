package character;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.junit.Before;
import org.junit.Test;

public class ItemTypeTest {

	ItemType itemType = null;
	ItemType itemType2 = null;
	
	@Before
	public void setup(){
		itemType = ItemType.FIREARM;
		itemType2 = ItemType.GENERAL;
	}
	
	@Test
	public void shouldTestIfItemTypeNameIsEqual(){
		ItemType itemType3 = ItemType.FIREARM;
		ItemType itemType4 = ItemType.GENERAL;
		
		assertThat(itemType.itemTypeName(), is(equalTo(itemType3.itemTypeName())));
		assertThat(itemType.itemTypeName(), is(equalTo(itemType4.itemTypeName())));
	}	
}
