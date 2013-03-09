package world.items;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class GeneralItem implements Item {
	private String name;
	private ItemType itemType;
	private ItemSize itemSize;
	
	public GeneralItem(String itemName) {
		this.name = itemName;
		this.itemType = ItemType.GENERAL;
		this.itemSize = ItemSize.NORMAL;
	}

	public GeneralItem(String itemName, ItemSize itemSize) {
		this.name = itemName;
		this.itemType = ItemType.GENERAL;
		this.itemSize = itemSize;
	}

	public GeneralItem(String itemName, ItemSize itemSize, ItemType itemType) {
		this.name = itemName;
		this.itemSize = itemSize;
		this.itemType = itemType;
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

	@Override
	public Iterator<Item> iterator() {
		List<Item> emptyList = Collections.<Item>emptyList();
		return emptyList.iterator();
	}

}
