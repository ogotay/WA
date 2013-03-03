package world.items;

public class GeneralItem implements Item {
	private final ItemType itemType = ItemType.GENERAL;
	private String name = null;	
	
	public GeneralItem(String itemName) {
		this.name = itemName;
	}

	@Override
	public String name() {
		return name;
	}

	@Override
	public int levelOfUnwieldiness() {
		return 0;
	}

	@Override
	public boolean isType(ItemType type) {		
		return this.itemType.equals(type);
	}

	@Override
	public boolean isNamed(String name) {
		return this.name.equals(name)
		;
	}

}
