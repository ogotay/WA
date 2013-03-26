package world.items;

public interface Item extends Iterable<Item> {
	public String itemName();
	public ItemType itemType();	
	public ItemSize itemSize();
	
	public int skillModificator(SkillType skill); 
}
