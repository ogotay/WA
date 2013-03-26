package world.items;

public class AmmunitionPouch extends GeneralContainer {
	private static final String POUCH_NAME = "£adownica";
	private static final int MAXIMUM_NUMBER_OF_BULLETS = 40;
	public AmmunitionPouch(){
		super(POUCH_NAME, MAXIMUM_NUMBER_OF_BULLETS, ItemType.AMMUNITION);
	}
}
