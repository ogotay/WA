package world.items;


import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class BackpackTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void shouldHaveName(){
		fail("Not yet implemented");
	}
	
	@Test
	public void shouldReportValidNumberOfItemsInside(){
		fail("Not yet implemented");
	}
	
	@Test
	public void shouldReportCorrectlySpaceUsedByItems(){
		fail("Not yet implemented");
	}
	
	@Test
	public void shouldAllowToInsertNewItems(){
		fail("Not yet implemented");
	}
	
	@Test
	public void shouldAllowToHoldOtherContainers(){
		fail("Not yet implemented");
		//TODO: Assure that won't allow to insert too big container (in terms of size, number of items?)
	}

	@Test
	public void shouldAllowToInsertItemsWhichTakeMoreThanOneAvailableItemSlot(){
		fail("Not yet implemented");
	}
	
	@Test
	public void shouldNotAllowToInsertTooBigItems(){
		fail("Not yet implemented");
	}
	
	@Test
	public void shouldNotAllowToInsertItemsIfThereIsNotEnoughSpaceLeft(){
		fail("Not yet implemented");
		//TODO: Check which test are covered already by test from GeneralContainer class.
		//TODO: Check which test should be moved to GeneralContainerTest class.
	}
	
	@Test
	public void shouldNotAllowToHoldWeaponsOfAnyKind(){
		fail("Not yet implemented");
		//TODO: Consider all implications of holding weapons inside backpack. Maybe It should be allowed?
	}
	
	@Test
	public void shouldAllowToRemoveItems(){
		fail("Not yet implemented");
	}
	
	@Test 
	public void shouldAllowToFindSpecificItemInside(){
		fail("Not yet implemented");
	}
	
	@Test 
	public void shouldAllowToRemoveAllItems(){
		fail("Not yet implemented");
	}
	
	@Test
	public void shouldReturnCorrectAgilityModificator(){
		fail("Not yet implemented");
	}
	
	/*
	 * - backpack name
	 * - current number of items inside
	 * - inserting items (including other containers)
	 * - removing items (including other containers)
	 * - agility modifications regarding current number of items
	 * - items taking space of two or more items (up to maximum backpack capacity)
	 */
}
