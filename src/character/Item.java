package character;

public interface Item {
	public String name();

	//unwieldiness 1,2,3,4,...
	public int levelOfUnwieldiness();
	
	public boolean isType(ItemType type);
	
	public boolean isNamed(String name);
}
