package world.items;

public class Backpack extends GeneralContainer {
	private static final String BACKPACK_NAME = "Plecak";
	private static final int MAXIMUM_NUMBER_OF_ITEMS = 10;

	public Backpack() {
		super(BACKPACK_NAME, MAXIMUM_NUMBER_OF_ITEMS, ItemType.ANY);
	}

	private int spaceUsed() {
		int totalSpace = 0;
		for (Item item : this) {
			int space = item.itemSize().ordinal();

			if (item.itemSize().equals(ItemSize.SMALL)) {
				space = ItemSize.NORMAL.ordinal();
			}

			totalSpace += space;
		}

		return totalSpace;
	}

	public int availableSpace() {
		return MAXIMUM_NUMBER_OF_ITEMS - spaceUsed();
	}

	@Override
	public int skillModificator(SkillType skill) {
		int modificator = 0;
		if (skill.equals(SkillType.AGILITY)) {
			int totalSpaceUsed = spaceUsed();

			if (totalSpaceUsed > 3 && totalSpaceUsed <= 6) {
				modificator = -1;
			} else if (totalSpaceUsed > 6 && totalSpaceUsed <= 9) {
				modificator = -2;
			} else if (totalSpaceUsed >= 10) {
				modificator = -3;
			}
		} else {
			modificator = super.skillModificator(skill);
		}
		return modificator;
	}

}
