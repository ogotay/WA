package world.items;

public enum ItemType {
	FOOD ("food"),
	WATER ("water"),
	MEDICINE ("medicine"),
	HAND_WEAPON ("hand weapon"),
	FIREARM ("firearm"),
	CONTAINER ("container"),
	GENERAL ("general"),
	ANY ("any");
	
	private String name;
	
	private ItemType(String name){
		this.name = name;
	}
	
	public String itemTypeName(){
		return this.name;
	}
	
	//TODO: remove this comments
	//food, water, medicine, hand weapon, firearm
	//pistol, machine gun, shotgun, rifle, hand grenade
	//hunting knife	
}
