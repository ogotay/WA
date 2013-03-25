package world.items;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class GeneralContainerTest {
	private static final int ZERO = 0;
	
	private Container container = null;
	private String containerName = "Crate";
	private int containerMaximumCapacity = 3;
	
	private Container container2 = null;
	private String containerName2 = "First aid kit";
	private int containerMaximumCapacity2 = 12;
	
	private Item item = new GeneralItem("Stone");
	private Item item2 = new GeneralItem("Flower");
	private Item item3 = new GeneralItem("Bottle");
	private Item item4 = new GeneralItem("Pill", ItemSize.SMALL, ItemType.MEDICINE);
	
	@Ignore
	public static List<Item> createGeneralItems(int numberOfItems, ItemType itemType, ItemSize itemSize, String itemsName){
		List<Item> items = new ArrayList<Item>(numberOfItems);
				
		for (int i=0; i<numberOfItems; i++){
			Item item = new GeneralItem(itemsName, itemSize, itemType);
			items.add(item);
		}
		
		return items;
	}
	
	@Before
	public void setUp(){
		container = new GeneralContainer(containerName, containerMaximumCapacity);
		container2 = new GeneralContainer(containerName2, containerMaximumCapacity2, ItemType.MEDICINE);
	}
	
	@Test
	public void shouldHaveContainerItemType(){
		assertThat(container.itemType(), is(equalTo(ItemType.CONTAINER)));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldHaveAbilityToConstraintInsertedItemTypes() throws Throwable{
		container2.insert(item);		
	}
	
	@Test(expected=Exception.class)
	public void shouldNotAllowToContainMoreItemsThanAllowedByMaxiumCapacity() throws Throwable {		
		container.insert(item);
		container.insert(item2);
		container.insert(item3);
		container.insert(item4);
	}
	
	@Test
	public void shouldAllowToPutNewItemsIntoContainer() throws Throwable {
		int numberOfItems = container.numberOfItems();
		container.insert(item);
		assertThat(container.numberOfItems(), is(equalTo(numberOfItems + 1)));
	}
	
	@Test
	public void shouldAllowToRemoveSpecificItemFromContainer() throws Throwable{
		container.insert(item);
		container.insert(item2);
		int numberOfItems = container.numberOfItems();
		
		@SuppressWarnings("unused")
		Item removedItem = container.remove("Flower");
		assertThat(container.numberOfItems(), is(equalTo(numberOfItems - 1)));	
	}
	
	@Test
	public void shouldAllowToRemoveFirstItemFromContainer() throws Throwable{
		container.insert(item);
		container.insert(item2);
		int numberOfItems = container.numberOfItems();
		
		@SuppressWarnings("unused")
		Item removedItem = container.remove();
		assertThat(container.numberOfItems(), is(equalTo(numberOfItems - 1)));	
	}
	
	@Test
	public void shouldReportValidNumberOfItemsHeld() throws Throwable {
		container.insert(item);
		container.insert(item4);
		
		assertThat(container.numberOfItems(), is(equalTo(2)));
	}
	
	@Test
	public void shouldAllowToEmptyWholeContainer() throws Throwable {
		container.insert(item);
		container.insert(item2);
		container.removeAllItems();
		
		assertThat(container.numberOfItems(), is(equalTo(ZERO)));
	}
	
	@Test(expected=Exception.class)
	public void shouldNotAllowToTakeAnythingFromContainerIfContainerIsEmpty() throws Throwable {
		@SuppressWarnings("unused")
		Item item = container.remove("Pill");
	}
	
	@Test
	public void shouldFindSpecificItemInContainer() throws Throwable {
		container.insert(item);
		container.insert(item2);
		container.insert(item3);
		
		String itemNameToFind = "Bottle";
		
		Item itemFound = container.find(itemNameToFind);
		assertThat(itemFound, is(equalTo(item3)));
	}
		
	@Test
	public void shouldNotModifyAnyTypeOfSkill(){
		assertThat(container.skillModificator(null), is(equalTo(ZERO)));
	}
}
