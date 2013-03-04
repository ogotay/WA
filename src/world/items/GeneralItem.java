package world.items;

public class GeneralItem implements Item {
	private String name;
	private ItemType itemType;
	private ItemSize itemSize;
	
	public GeneralItem(String itemName) {
		this.name = itemName;
		this.itemType = ItemType.GENERAL;
		this.itemSize = ItemSize.NORMAL;
	}

	@Override
	public String itemName() {
		return name;
	}

	@Override
	public ItemType itemType() {
		return itemType;
	}

	@Override
	public ItemSize itemSize() {
		return itemSize;
	}

	@Override
	public int skillModificator(SkillType skill) {
		return 0;
	}

}
