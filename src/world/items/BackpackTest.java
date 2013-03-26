package world.items;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class BackpackTest {

	private static final int ZERO = 0;

	private Backpack backpack = null;
	private Item boulder = null;
	private Item cbRadio = null;
	private Item canteen = null;
	private Item firstAidKit = null;
	
	
	@Before
	public void setUp() throws Exception {				
		backpack = new Backpack();
		boulder = new GeneralItem("Boulder", ItemSize.BIG);
		cbRadio = new GeneralItem("CB Radio");
		canteen = new Canteen();
		firstAidKit = new FirstAidKit();
	}

	@Test
	public void shouldHaveName(){
		assertThat(backpack.itemName().length(), is(greaterThan(ZERO)));
	}
	
	@Test
	public void shouldReportValidNumberOfItemsInside() throws Throwable {
		backpack.insert(boulder);
		backpack.insert(canteen);
		assertThat(backpack.numberOfItems(), is(equalTo(2)));
		
		((FirstAidKit)firstAidKit).refillBy(GeneralContainerTest.createGeneralItems(7, ItemType.MEDICINE, ItemSize.SMALL, "Pill"));
		backpack.insert(firstAidKit);
		backpack.insert(cbRadio);
		assertThat(backpack.numberOfItems(), is(equalTo(4)));				
	}
	
	@Test
	public void shouldReportCorrectlySpaceUsedByItems() throws Throwable {
		backpack.insert(canteen);
		assertThat(backpack.availableSpace(), is(equalTo(9)));
		
		((FirstAidKit)firstAidKit).refillBy(GeneralContainerTest.createGeneralItems(7, ItemType.MEDICINE, ItemSize.SMALL, "Pill"));
		backpack.insert(firstAidKit);
		backpack.insert(cbRadio);
		assertThat(backpack.availableSpace(), is(equalTo(7)));
		
		backpack.insert(boulder);
		assertThat(backpack.availableSpace(), is(equalTo(5)));
		
		backpack.insert(new GeneralItem("Coin", ItemSize.SMALL));
		assertThat(backpack.availableSpace(), is(equalTo(4)));
	}
	
	@Test
	public void shouldAllowToInsertNewItems() throws Throwable{
		backpack.insert(cbRadio);				
		assertThat(backpack.numberOfItems(), is(equalTo(1)));
	}
	
	@Test
	public void shouldAllowToHoldOtherContainers() throws Throwable{
		backpack.insert(canteen);
		((FirstAidKit)firstAidKit).refillBy(GeneralContainerTest.createGeneralItems(12, ItemType.MEDICINE, ItemSize.SMALL, "Pill"));
		backpack.insert(firstAidKit);
		assertThat(backpack.numberOfItems(), is(equalTo(2)));
		
		//TODO: Assure that won't allow to insert too big container (in terms of size, number of items?)
	}

	@Test
	public void shouldAllowToInsertItemsWhichTakeMoreThanOneAvailableItemSlot() throws Throwable{
		backpack.insert(boulder);
		assertThat(backpack.numberOfItems(), is(equalTo(1)));
		assertThat(backpack.availableSpace(), is(equalTo(8)));
	}
	
	@Test
	public void shouldNotAllowToInsertItemsIfThereIsNotEnoughSpaceLeft() throws Throwable{
		backpack.insert(cbRadio);
		backpack.insert(canteen);
		backpack.insert(firstAidKit);
		backpack.insert(new GeneralItem("Pen"));
		backpack.insert(new GeneralItem("Book"));
		backpack.insert(new GeneralItem("Binocular"));
		backpack.insert(new GeneralItem("Coin", ItemSize.SMALL));
		backpack.insert(new GeneralItem("Environmental suit", ItemSize.BIG));
		
		try {
			backpack.insert(boulder);
		} catch (Throwable e) {
			assertThat(backpack.numberOfItems(), is(equalTo(8)));
			assertThat(backpack.availableSpace(), is(equalTo(1)));
		}
		
		//TODO: Check which test are covered already by test from GeneralContainer class.
		//TODO: Check which test should be moved to GeneralContainerTest class.
	}
	
	@Ignore
	@Test
	public void shouldNotAllowToHoldWeaponsOfAnyKind(){
		try {
			backpack.insert(new GeneralItem("Desert Eeagle", ItemSize.NORMAL, ItemType.FIREARM));
			fail("Allowed insertion of a firearm into container.");
		} catch (Throwable e){
			assertThat(backpack.numberOfItems(), is(equalTo(ZERO)));
		}
		try {
			backpack.insert(new GeneralItem("Hunting knife", ItemSize.NORMAL, ItemType.HAND_WEAPON));
			fail("Allowed insertion of a hand weapon into container.");
		} catch (Throwable e){
			assertThat(backpack.numberOfItems(), is(equalTo(ZERO)));
		}
				
		//TODO: Consider all implications of holding weapons inside backpack. Maybe It should be allowed?
	}
	
	@Test
	public void shouldAllowToRemoveItems() throws Throwable{
		backpack.insert(canteen);
		backpack.insert(boulder);
		backpack.insert(cbRadio);		
		assertThat(backpack.numberOfItems(), is(equalTo(3)));
		assertThat(backpack.availableSpace(), is(equalTo(6)));
		
		backpack.remove();
		assertThat(backpack.numberOfItems(), is(equalTo(2)));
		assertThat(backpack.availableSpace(), is(equalTo(7)));
		
		backpack.remove("CB Radio");
		assertThat(backpack.numberOfItems(), is(equalTo(1)));
		assertThat(backpack.availableSpace(), is(equalTo(8)));
		
		backpack.remove("Boulder");
		assertThat(backpack.numberOfItems(), is(equalTo(ZERO)));
		assertThat(backpack.availableSpace(), is(equalTo(10)));
	}
	
	@Test 
	public void shouldAllowToFindSpecificItemInside() throws Throwable{
		backpack.insert(canteen);
		backpack.insert(boulder);
		backpack.insert(cbRadio);
		
		Item item = backpack.find("CB Radio");
		assertThat(item, is(equalTo(cbRadio)));		
	}
	
	@Test 
	public void shouldAllowToRemoveAllItems() throws Throwable{
		backpack.insert(canteen);
		backpack.insert(boulder);
		backpack.insert(cbRadio);
		assertThat(backpack.numberOfItems(), is(equalTo(3)));
		assertThat(backpack.availableSpace(), is(equalTo(6)));
		
		backpack.removeAllItems();
		assertThat(backpack.numberOfItems(), is(equalTo(ZERO)));
		assertThat(backpack.availableSpace(), is(equalTo(10)));		
	}
	
	@Test
	public void shouldReturnCorrectAgilityModificator() throws Throwable{
		SkillType skill = SkillType.AGILITY;
		
		backpack.skillModificator(SkillType.AGILITY);
		assertThat(backpack.skillModificator(skill), is(equalTo(ZERO)));
		
		backpack.insert(boulder);
		backpack.insert(cbRadio);
		assertThat(backpack.skillModificator(skill), is(equalTo(ZERO)));
		
		backpack.insert(canteen);
		assertThat(backpack.skillModificator(skill), is(equalTo(-1)));
		backpack.insert(firstAidKit);
		backpack.insert(new GeneralItem("Pen"));
		assertThat(backpack.skillModificator(skill), is(equalTo(-1)));
		
		backpack.insert(new GeneralItem("Book"));
		assertThat(backpack.skillModificator(skill), is(equalTo(-2)));
		backpack.insert(new GeneralItem("Mug"));
		backpack.insert(new GeneralItem("Binocular"));
		assertThat(backpack.skillModificator(skill), is(equalTo(-2)));
		
		backpack.insert(new GeneralItem("Map"));
		assertThat(backpack.skillModificator(skill), is(equalTo(-3)));		
	}
	

	@Test
	public void shouldNotChangeStatisticsOtherThanAgility() throws Throwable{
		backpack.insert(boulder);
		backpack.insert(firstAidKit);
		backpack.insert(cbRadio);
		backpack.insert(canteen);
        assertThat(backpack.skillModificator(SkillType.DRIVING), is(equalTo(ZERO)));
        assertThat(backpack.skillModificator(SkillType.PERCEPTION), is(equalTo(ZERO)));
        assertThat(backpack.skillModificator(SkillType.SHOOTING), is(equalTo(ZERO)));
        assertThat(backpack.skillModificator(SkillType.TERRAIN_ORIENTATION), is(equalTo(ZERO)));
        assertThat(backpack.skillModificator(SkillType.FIGHTING), is(equalTo(ZERO)));
        assertThat(backpack.skillModificator(SkillType.TOUGHNESS), is(equalTo(ZERO)));
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
