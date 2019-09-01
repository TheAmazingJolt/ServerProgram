package items;

import java.awt.Rectangle;

// Referenced classes of package items:
//            Item

public class LargeCraftItem
{

	public static LargeCraftItem items[] = new LargeCraftItem[256];
	public static LargeCraftItem pistol = new LargeCraftItem("Steel Gun", 0, Item.steelHammer, Item.steelPlate, Item.steelRod, Item.pistolBulletItem, true);
	public static LargeCraftItem pistolBullet = new LargeCraftItem("Steel Bullet", 1, Item.steelAxeItem, Item.steelRod, Item.gunPowder, Item.fireItem, false);
	public static LargeCraftItem SMG = new LargeCraftItem("SMG", 2, Item.pistolItem, Item.steelPlate, Item.steelRod, Item.smgBullet, true);
	public static LargeCraftItem smgBullet = new LargeCraftItem("SMG Bullet", 3, Item.steelAxeItem, Item.pistolBulletItem, Item.gunPowder, Item.fireItem, false);
	
	public static final int ITEMWIDTH = 32;
    public static final int ITEMHEIGHT = 32;
	    
    protected String name;
	    
    protected final int id;
    protected Item i1;
    protected Item i2;
    protected Item i3;
    protected Item i4;
    protected boolean isTool;
	    
    protected Rectangle bounds;
    protected int x;
    protected int y;
    protected int count;
    protected boolean pickedUp;
    protected boolean contained;
	
    public LargeCraftItem(String name, int id, Item i1, Item i2, Item i3, Item i4, boolean tool)
    {
        pickedUp = false;
        this.name = name;
        this.id = id;
        this.i1 = i1;
        this.i2 = i2;
        this.i3 = i3;
        this.i4 = i4;
        this.isTool = tool;
        count = 1;
        items[id] = this;
    }
    
    public LargeCraftItem(int id, Item i2, Item i1, Item i3, Item i4)
    {
        pickedUp = false;
        this.id = id;
        this.i1 = i1;
        this.i2 = i2;
        this.i3 = i3;
        this.i4 = i4;
        this.isTool = true;
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
    
    public int getI3id()
    {
        return i3.getId();
    }

    public int getI4id()
    {
        return i4.getId();
    }

    public Item getI3()
    {
        return i3;
    }

    public Item getI4()
    {
        return i4;
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
