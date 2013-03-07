package world.items;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class GeneralContainerTest {
	private static final int ZERO = 0;
	private static final int MAXIMUM_CAPACITY = 3;
	
	private Item item = null;
	private String itemName = "Crate";
	private int itemMaximumCapacity = MAXIMUM_CAPACITY;
	
	@Before
	public void setUp(){
		item = new GeneralContainer(itemName, itemMaximumCapacity);

	}
	
	@Test
	public void shouldHaveContainerItemType(){
		assertThat(item.itemType(), is(equalTo(ItemType.CONTAINTER)));
	}
	
	@Test
	public void shouldHaveAbilityToConstraintContaintedItemTypes(){
		fail("Not implemented");
	}
	
	@Test
	public void shouldNotAllowToContainMoreItemsThanAllowedByMaxiumCapacity(){
		fail("Not implemented");
	}
	
	@Test
	public void shouldAllowToPutNewItemsIntoContainer(){
		fail("Not implemented");
	}
	
	@Test
	public void shouldAllowToRemoveItemFromContainer(){
		fail("Not implemented");	
	}
	
	@Test
	public void shouldAllowToUseItemFromContainer(){
		fail("Not implemented");
	}
	
	@Test
	public void shouldAllowToEmptyWholeContainer(){
		fail("Not implemented");
	}
	
	@Test
	public void shouldNotAllowToTakeAnythingFromContainerIfContainerIsEmpty(){
		fail("Not implemented");
	}
	
	@Test
	public void shouldFindSpecificItemInContainer(){
		fail("Not implemented");
	}
		
	@Test
	public void shouldNotModifyAnyTypeOfSkill(){
		assertThat(item.skillModificator(null), is(equalTo(ZERO)));
	}
	
	
	
	/*
	 * 
	 * 	- maximum capacity
		- some items are containers for other items
		- containter can contain different types of items or only specific item type
		- size (in container)
		- variable in time or depending on other factors modification of character abilities
	 */
	
}
