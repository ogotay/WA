package world.items;

import java.util.Iterator;

public interface Item extends Iterable<Item> {
	public String itemName();
	public ItemType itemType();	
	public ItemSize itemSize();
	
	public int skillModificator(SkillType skill); 
	//public Iterator<Item> iterator();
}
