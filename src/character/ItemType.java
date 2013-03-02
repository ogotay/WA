package character;

public enum ItemType {
	FOOD ("food"),
	WATER ("water"),
	MEDICINE ("medicine"),
	HAND_WEAPON ("hand weapon"),
	FIREARM ("firearm"),
	GENERAL ("general");
	
	private String name;
	
	private ItemType(String name){
		this.name = name;
	}
	
	public String itemTypeName(){
		return this.name;
	}
	
	//food, water, medicine, hand weapon, firearm
	//pistol, machine gun, shotgun, rifle, hand grenade
	//hunting knife	
}
