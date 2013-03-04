package world.items;

public interface Item {
	public String itemName();
	public ItemType itemType();	
	public ItemSize itemSize();
	
	public int skillModificator(SkillType skill); 
}
