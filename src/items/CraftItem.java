package items;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import gfx.Assets;
import main.Handler;

// Referenced classes of package items:
//            Item

public class CraftItem
{

	 public static CraftItem items[] = new CraftItem[256];
	 public static CraftItem axeItem = new CraftItem(Assets.axe, "Axe", 0, Item.woodItem, Item.rockItem, true);
	 public static CraftItem cutWoodItem = new CraftItem(Assets.cutWood, "Cut Wood", 1, Item.axeItem, Item.woodItem, false);
     public static CraftItem fireItem = new CraftItem(Assets.fire, "Fire (Wood)", 2, Item.cutWoodItem, Item.flintItem, false);
	 public static CraftItem fireItem2 = new CraftItem(Assets.fire, "Fire (Charcoal)", 3, Item.charcoalItem, Item.flintItem, false);
	 public static CraftItem ironBarItem = new CraftItem(Assets.ironBar, "Iron Bar", 4, Item.fireItem, Item.ironOreItem, false);
	 public static CraftItem woodenHandleItem = new CraftItem(Assets.woodenHandle, "Wooden Handle", 5, Item.woodItem, Item.cutWoodItem, false);
	 public static CraftItem ironAxeItem = new CraftItem(Assets.ironAxe, "Iron Axe", 6, Item.woodenHandleItem, Item.ironBarItem, true);
	 public static CraftItem charcoalItem = new CraftItem(Assets.charcoal, "Charcoal", 7, Item.cutWoodItem, Item.fireItem, true);
	 public static CraftItem crushedIronItem = new CraftItem(Assets.crushedIron, "Crushed Iron", 8, Item.rockItem, Item.ironBarItem, false);
	 public static CraftItem healingPowderItem = new CraftItem(Assets.healingPowder, "Healing Powder", 9, Item.crushedIronItem, Item.rottenFleshItem, false);
	 public static CraftItem healingPotionItem = new CraftItem(Assets.healingPotion, "Healing Potion", 10, Item.healingPowderItem, Item.waterBottle, false);
	 public static CraftItem bottleItem = new CraftItem(Assets.bottle, "Bottle", 11, Item.crushedIronItem, Item.fireItem, false);
	 public static CraftItem healthBoostItem = new CraftItem(Assets.healthBoostPotion, "Health Boost Potion", 12, Item.healingPotionItem, Item.ironBarItem, false);
	 public static CraftItem coalDustItem = new CraftItem(Assets.coalDust, "Coal Dust", 13, Item.coalItem, Item.rockItem, false);
	 public static CraftItem steelBarItem = new CraftItem(Assets.steelBar, "Steel Bar", 14, Item.ironBarItem, Item.coalDustItem, false);
	 public static CraftItem cutWoodItem2 = new CraftItem(Assets.cutWood, "Cut Wood", 15, Item.ironAxeItem, Item.woodItem, false);
	 public static CraftItem cutWoodItem3 = new CraftItem(Assets.cutWood, "Cut Wood", 16, Item.steelAxeItem, Item.woodItem, false);
	 public static CraftItem cutAshyWoodItem = new CraftItem(Assets.cutAshyWood, "Cut Wood", 17, Item.steelAxeItem, Item.ashyWoodItem, false);
	 public static CraftItem cutAshyWoodItem2 = new CraftItem(Assets.cutAshyWood, "Cut Wood", 18, Item.ironAxeItem, Item.ashyWoodItem, false);
	 public static CraftItem cutAshyWoodItem3 = new CraftItem(Assets.cutAshyWood, "Cut Wood", 19, Item.axeItem, Item.ashyWoodItem, false);
	 public static CraftItem steelAxeItem = new CraftItem(Assets.steelAxe, "Steel Axe", 20, Item.woodenHandleItem, Item.steelBarItem, true);
	 public static CraftItem steelHealthBoostItem = new CraftItem(Assets.steelHealthBoostPotion, "Steel Health Boost Potion", 21, Item.healthBoostItem, Item.steelBarItem, false);
	 //public static CraftItem woodenStructure = new CraftItem(Assets.woodenStructure, "Wooden Structure", 44, Item.cutWoodItem, Item.cutAshyWood, false);
	 public static CraftItem ashyWoodHandle = new CraftItem(Assets.ashyWoodHandle, "Ashy Wood Handle", 45, Item.cutAshyWood, Item.ashyWoodItem, false);
	 public static CraftItem steelHammer = new CraftItem(Assets.steelHammer, "Steel Hammer", 46, Item.ashyWoodHandle, Item.steelBarItem, true);
	 public static CraftItem steelPlate = new CraftItem(Assets.steelPlate, "Steel Plate", 47, Item.steelBarItem, Item.steelHammer, false);
	 public static CraftItem steelRod = new CraftItem(Assets.steelRod, "Steel Rod", 48, Item.steelBarItem, Item.steelAxeItem, false);
	 public static CraftItem gunPowder = new CraftItem(Assets.gunPowder, "Gun Powder", 54, Item.crushedIronItem, Item.snow, false);
	 
	 //allows crafting to go either direction
	 public static CraftItem axeItem2 = new CraftItem(Assets.axe, 22, Item.woodItem, Item.rockItem, true);
	 public static CraftItem cutWoodItem7 = new CraftItem(Assets.cutWood, 23, Item.axeItem, Item.woodItem, false);
	 public static CraftItem fireItem3 = new CraftItem(Assets.fire, 24, Item.cutWoodItem, Item.flintItem, false);
	 public static CraftItem fireItem4 = new CraftItem(Assets.fire, 25, Item.charcoalItem, Item.flintItem, false);
	 public static CraftItem ironBarItem2 = new CraftItem(Assets.ironBar, 26, Item.fireItem, Item.ironOreItem, false);
	 public static CraftItem woodenHandleItem2 = new CraftItem(Assets.woodenHandle, 27, Item.woodItem, Item.cutWoodItem, false);
	 public static CraftItem ironAxeItem2 = new CraftItem(Assets.ironAxe, 28, Item.woodenHandleItem, Item.ironBarItem, true);
	 public static CraftItem charcoalItem2 = new CraftItem(Assets.charcoal, 29, Item.cutWoodItem, Item.fireItem, true);
	 public static CraftItem crushedIronItem2 = new CraftItem(Assets.crushedIron, 30, Item.rockItem, Item.ironBarItem, false);
	 public static CraftItem healingPowderItem2 = new CraftItem(Assets.healingPowder, 31, Item.crushedIronItem, Item.rottenFleshItem, false);
	 public static CraftItem healingPotionItem2 = new CraftItem(Assets.healingPotion, 32, Item.healingPowderItem, Item.waterBottle, false);
	 public static CraftItem bottleItem2 = new CraftItem(Assets.bottle, 33, Item.crushedIronItem, Item.fireItem, false);
	 public static CraftItem healthBoostItem2 = new CraftItem(Assets.healthBoostPotion, 34, Item.healingPotionItem, Item.ironBarItem, false);
	 public static CraftItem coalDustItem2 = new CraftItem(Assets.coalDust, 35, Item.coalItem, Item.rockItem, false);
	 public static CraftItem steelBarItem2 = new CraftItem(Assets.steelBar, 36, Item.ironBarItem, Item.coalDustItem, false);
	 public static CraftItem cutWoodItem8 = new CraftItem(Assets.cutWood, 37, Item.ironAxeItem, Item.woodItem, false);
	 public static CraftItem cutWoodItem9 = new CraftItem(Assets.cutWood, 38, Item.steelAxeItem, Item.woodItem, false);
	 public static CraftItem cutAshyWoodItem4 = new CraftItem(Assets.cutAshyWood, 39, Item.steelAxeItem, Item.ashyWoodItem, false);
	 public static CraftItem cutAshyWoodItem5 = new CraftItem(Assets.cutAshyWood, 40, Item.ironAxeItem, Item.ashyWoodItem, false);
	 public static CraftItem cutAshyWoodItem6 = new CraftItem(Assets.cutAshyWood, 41, Item.axeItem, Item.ashyWoodItem, false);
	 public static CraftItem steelAxeItem2 = new CraftItem(Assets.steelAxe, 42, Item.woodenHandleItem, Item.steelBarItem, true);
	 public static CraftItem steelHealthBoostItem2 = new CraftItem(Assets.steelHealthBoostPotion, 43, Item.healthBoostItem, Item.steelBarItem, false);
	 //public static CraftItem woodenStructure2 = new CraftItem(Assets.woodenStructure, "Wooden Structure", 49, Item.cutAshyWood, Item.cutWoodItem, false);
	 public static CraftItem ashyWoodHandle2 = new CraftItem(Assets.ashyWoodHandle, "Ashy Wood Handle", 50, Item.ashyWoodItem, Item.cutAshyWood, false);
	 public static CraftItem steelHammer2 = new CraftItem(Assets.steelHammer, "Steel Hammer", 51, Item.steelBarItem, Item.ashyWoodHandle, true);
	 public static CraftItem steelPlate2 = new CraftItem(Assets.steelPlate, "Steel Plate", 52, Item.steelHammer, Item.steelBarItem, false);
	 public static CraftItem steelRod2 = new CraftItem(Assets.steelRod, "Steel Rod", 53, Item.steelAxeItem, Item.steelBarItem, false);
	 public static CraftItem gunPowder2 = new CraftItem(Assets.gunPowder, "Gun Powder", 55, Item.snow, Item.crushedIronItem, false);
	 	
	public static final int ITEMWIDTH = 32;
    public static final int ITEMHEIGHT = 32;
	    
    protected Handler handler;
    protected BufferedImage texture;
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
	
    public CraftItem(BufferedImage texture, String name, int id, Item i1, Item i2, boolean isTool)
    {
        pickedUp = false;
        this.texture = texture;
        this.name = name;
        this.id = id;
        this.i1 = i1;
        this.i2 = i2;
        this.isTool = isTool;
        count = 1;
        items[id] = this;
    }
    
    public CraftItem(BufferedImage texture, int id, Item i2, Item i1, boolean isTool)
    {
        pickedUp = false;
        this.texture = texture;
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

    public void render(Graphics g)
    {
        if(handler == null)
        {
            return;
        } else
        {
            render(g, (int)((float)x - handler.getGameCamera().getxOffset()), (int)((float)y - handler.getGameCamera().getyOffset()));
            return;
        }
    }

    public void render(Graphics g, int x, int y)
    {
        g.drawImage(texture, x, y, 32, 32, null);
    }

    public boolean isContained() {
		return contained;
	}

	public void setContained(boolean contained) {
		this.contained = contained;
	}

	public CraftItem createNew(int count)
    {
        CraftItem i = new CraftItem(texture, name, id, i1, i2, isTool);
        i.setPickedUp(true);
        i.setCount(count);
        return i;
    }

    public CraftItem createNew(int x, int y)
    {
        CraftItem i = new CraftItem(texture, name, id, i1, i2, isTool);
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

    public Handler getHandler()
    {
        return handler;
    }

    public void setHandler(Handler handler)
    {
        this.handler = handler;
    }

    public BufferedImage getTexture()
    {
        return texture;
    }

    public void setTexture(BufferedImage texture)
    {
        this.texture = texture;
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
