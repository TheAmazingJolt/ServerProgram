package items;

import java.awt.Rectangle;

// Referenced classes of package items:
//            Item

public class CraftItem
{

	 public static CraftItem items[] = new CraftItem[256];
	 public static CraftItem axeItem = new CraftItem("Axe", 0, Item.woodItem, Item.rockItem, true);
	 public static CraftItem cutWoodItem = new CraftItem("Cut Wood", 1, Item.axeItem, Item.woodItem, false);
     public static CraftItem fireItem = new CraftItem("Fire (Wood)", 2, Item.cutWoodItem, Item.flintItem, false);
	 public static CraftItem fireItem2 = new CraftItem("Fire (Charcoal)", 3, Item.charcoalItem, Item.flintItem, false);
	 public static CraftItem ironBarItem = new CraftItem("Iron Bar", 4, Item.fireItem, Item.ironOreItem, false);
	 public static CraftItem woodenHandleItem = new CraftItem("Wooden Handle", 5, Item.woodItem, Item.cutWoodItem, false);
	 public static CraftItem ironAxeItem = new CraftItem("Iron Axe", 6, Item.woodenHandleItem, Item.ironBarItem, true);
	 public static CraftItem charcoalItem = new CraftItem("Charcoal", 7, Item.cutWoodItem, Item.fireItem, true);
	 public static CraftItem crushedIronItem = new CraftItem("Crushed Iron", 8, Item.rockItem, Item.ironBarItem, false);
	 public static CraftItem healingPowderItem = new CraftItem("Healing Powder", 9, Item.crushedIronItem, Item.rottenFleshItem, false);
	 public static CraftItem healingPotionItem = new CraftItem("Healing Potion", 10, Item.healingPowderItem, Item.waterBottle, false);
	 public static CraftItem bottleItem = new CraftItem("Bottle", 11, Item.crushedIronItem, Item.fireItem, false);
	 public static CraftItem healthBoostItem = new CraftItem("Health Boost Potion", 12, Item.healingPotionItem, Item.ironBarItem, false);
	 public static CraftItem coalDustItem = new CraftItem("Coal Dust", 13, Item.coalItem, Item.rockItem, false);
	 public static CraftItem steelBarItem = new CraftItem("Steel Bar", 14, Item.ironBarItem, Item.coalDustItem, false);
	 public static CraftItem cutWoodItem2 = new CraftItem("Cut Wood", 15, Item.ironAxeItem, Item.woodItem, false);
	 public static CraftItem cutWoodItem3 = new CraftItem("Cut Wood", 16, Item.steelAxeItem, Item.woodItem, false);
	 public static CraftItem cutAshyWoodItem = new CraftItem("Cut Wood", 17, Item.steelAxeItem, Item.ashyWoodItem, false);
	 public static CraftItem cutAshyWoodItem2 = new CraftItem("Cut Wood", 18, Item.ironAxeItem, Item.ashyWoodItem, false);
	 public static CraftItem cutAshyWoodItem3 = new CraftItem("Cut Wood", 19, Item.axeItem, Item.ashyWoodItem, false);
	 public static CraftItem steelAxeItem = new CraftItem("Steel Axe", 20, Item.woodenHandleItem, Item.steelBarItem, true);
	 public static CraftItem steelHealthBoostItem = new CraftItem("Steel Health Boost Potion", 21, Item.healthBoostItem, Item.steelBarItem, false);
	 //public static CraftItem woodenStructure = new CraftItem(Assets.woodenStructure, "Wooden Structure", 44, Item.cutWoodItem, Item.cutAshyWood, false);
	 public static CraftItem ashyWoodHandle = new CraftItem("Ashy Wood Handle", 45, Item.cutAshyWood, Item.ashyWoodItem, false);
	 public static CraftItem steelHammer = new CraftItem("Steel Hammer", 46, Item.ashyWoodHandle, Item.steelBarItem, true);
	 public static CraftItem steelPlate = new CraftItem("Steel Plate", 47, Item.steelBarItem, Item.steelHammer, false);
	 public static CraftItem steelRod = new CraftItem("Steel Rod", 48, Item.steelBarItem, Item.steelAxeItem, false);
	 public static CraftItem gunPowder = new CraftItem("Gun Powder", 54, Item.crushedIronItem, Item.snow, false);
	 
	 //allows crafting to go either direction
	 public static CraftItem axeItem2 = new CraftItem(22, Item.woodItem, Item.rockItem, true);
	 public static CraftItem cutWoodItem7 = new CraftItem(23, Item.axeItem, Item.woodItem, false);
	 public static CraftItem fireItem3 = new CraftItem(24, Item.cutWoodItem, Item.flintItem, false);
	 public static CraftItem fireItem4 = new CraftItem(25, Item.charcoalItem, Item.flintItem, false);
	 public static CraftItem ironBarItem2 = new CraftItem(26, Item.fireItem, Item.ironOreItem, false);
	 public static CraftItem woodenHandleItem2 = new CraftItem(27, Item.woodItem, Item.cutWoodItem, false);
	 public static CraftItem ironAxeItem2 = new CraftItem(28, Item.woodenHandleItem, Item.ironBarItem, true);
	 public static CraftItem charcoalItem2 = new CraftItem(29, Item.cutWoodItem, Item.fireItem, true);
	 public static CraftItem crushedIronItem2 = new CraftItem(30, Item.rockItem, Item.ironBarItem, false);
	 public static CraftItem healingPowderItem2 = new CraftItem(31, Item.crushedIronItem, Item.rottenFleshItem, false);
	 public static CraftItem healingPotionItem2 = new CraftItem(32, Item.healingPowderItem, Item.waterBottle, false);
	 public static CraftItem bottleItem2 = new CraftItem(33, Item.crushedIronItem, Item.fireItem, false);
	 public static CraftItem healthBoostItem2 = new CraftItem(34, Item.healingPotionItem, Item.ironBarItem, false);
	 public static CraftItem coalDustItem2 = new CraftItem(35, Item.coalItem, Item.rockItem, false);
	 public static CraftItem steelBarItem2 = new CraftItem(36, Item.ironBarItem, Item.coalDustItem, false);
	 public static CraftItem cutWoodItem8 = new CraftItem(37, Item.ironAxeItem, Item.woodItem, false);
	 public static CraftItem cutWoodItem9 = new CraftItem(38, Item.steelAxeItem, Item.woodItem, false);
	 public static CraftItem cutAshyWoodItem4 = new CraftItem(39, Item.steelAxeItem, Item.ashyWoodItem, false);
	 public static CraftItem cutAshyWoodItem5 = new CraftItem(40, Item.ironAxeItem, Item.ashyWoodItem, false);
	 public static CraftItem cutAshyWoodItem6 = new CraftItem(41, Item.axeItem, Item.ashyWoodItem, false);
	 public static CraftItem steelAxeItem2 = new CraftItem(42, Item.woodenHandleItem, Item.steelBarItem, true);
	 public static CraftItem steelHealthBoostItem2 = new CraftItem(43, Item.healthBoostItem, Item.steelBarItem, false);
	 //public static CraftItem woodenStructure2 = new CraftItem(Assets.woodenStructure, "Wooden Structure", 49, Item.cutAshyWood, Item.cutWoodItem, false);
	 public static CraftItem ashyWoodHandle2 = new CraftItem("Ashy Wood Handle", 50, Item.ashyWoodItem, Item.cutAshyWood, false);
	 public static CraftItem steelHammer2 = new CraftItem("Steel Hammer", 51, Item.steelBarItem, Item.ashyWoodHandle, true);
	 public static CraftItem steelPlate2 = new CraftItem("Steel Plate", 52, Item.steelHammer, Item.steelBarItem, false);
	 public static CraftItem steelRod2 = new CraftItem("Steel Rod", 53, Item.steelAxeItem, Item.steelBarItem, false);
	 public static CraftItem gunPowder2 = new CraftItem("Gun Powder", 55, Item.snow, Item.crushedIronItem, false);
	 	
	public static final int ITEMWIDTH = 32;
    public static final int ITEMHEIGHT = 32;
    
    protected String name;
	    
    protected final int id;
    protected Item i1;
    protected Item i2;
    protected boolean isTool;
	    
    protected Rectangle bounds;
    protected int x;
    protected int y;
    protected int count;
    protected boolean pickedUp;
    protected boolean contained;
	
    public CraftItem(String name, int id, Item i1, Item i2, boolean isTool)
    {
        pickedUp = false;
        this.name = name;
        this.id = id;
        this.i1 = i1;
        this.i2 = i2;
        this.isTool = isTool;
        count = 1;
        items[id] = this;
    }
    
    public CraftItem(int id, Item i2, Item i1, boolean isTool)
    {
        pickedUp = false;
        this.id = id;
        this.i1 = i1;
        this.i2 = i2;
        this.isTool = isTool;
        count = 1;
        items[id] = this;
    }

    public void tick()
    {
    }

    public boolean isContained() {
		return contained;
	}

	public void setContained(boolean contained) {
		this.contained = contained;
	}

	public CraftItem createNew(int count)
    {
        CraftItem i = new CraftItem(name, id, i1, i2, isTool);
        i.setPickedUp(true);
        i.setCount(count);
        return i;
    }

    public CraftItem createNew(int x, int y)
    {
        CraftItem i = new CraftItem(name, id, i1, i2, isTool);
        i.setPosition(x, y);
        return i;
    }

    public boolean isTool()
    {
        return isTool;
    }

    public int getI1id()
    {
        return i1.getId();
    }

    public int getI2id()
    {
        return i2.getId();
    }

    public Item getI1()
    {
        return i1;
    }

    public Item getI2()
    {
        return i2;
    }

    public void setPosition(int x, int y)
    {
        this.x = x;
        this.y = y;
        bounds.x = x;
        bounds.y = y;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public int getY()
    {
        return y;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public int getCount()
    {
        return count;
    }

    public void setCount(int count)
    {
        this.count = count;
    }

    public int getId()
    {
        return id;
    }

    public boolean isPickedUp()
    {
        return pickedUp;
    }

    public void setPickedUp(boolean pickedUp)
    {
        this.pickedUp = pickedUp;
    }


}
