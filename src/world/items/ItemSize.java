package world.items;

public enum ItemSize {
	SMALL (0),
	NORMAL (1),
	BIG (2);
	
	private int size;
	
	private ItemSize(int size){
		this.size = size;
	}
	
	public int itemSize(){
		return this.size;
	}
}
