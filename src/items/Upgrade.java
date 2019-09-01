package items;

import java.awt.Rectangle;
import java.util.ArrayList;

import effects.Effect;

public class Upgrade {
	
	//upgrade takes in an Effect which will determine certain boosts to the player. Upgrade will have an Item equivalent and a CraftItem equivalent. First upgrade for
	//extended crafting will be used in the hotbar to upgrade the player before they can access the upgrade panel in LargeInventory
	
	public static ArrayList<Upgrade> upgrades = new ArrayList<Upgrade>();
	public static Upgrade inventoryUpgrade = new Upgrade("Inventory Upgrade", 0, Effect.largeCrafting);
	public static Upgrade speedUpgrade = new Upgrade("Speed Upgrade", 1, Effect.speedBoost);
	
	public static final int ITEMWIDTH = 32, ITEMHEIGHT = 32;
	
    protected String name;
    
    protected final int id;
    protected int damage;
    
    protected Rectangle bounds;
    protected int x;
    protected int y;
    protected int x2;
    protected int y2;
	protected int count;
	protected int invId;
	protected int slot = 0;
	protected int startSlot;
    protected boolean pickedUp = false;
    protected Effect effectType;
    
    public Upgrade(String name, int id, Effect effectType)
    {
        pickedUp = false;
        this.name = name;
        this.id = id;
        this.effectType = effectType;
        count = 1;
        bounds = new Rectangle(x, y, 32, 32);
        addItemsToList();
    }
    
    public static void addItemsToList()
    {
    	upgrades.add(inventoryUpgrade);
    	upgrades.add(speedUpgrade);
    }

    public void tick()
    {
        
    }
    
    public int getDamage()
    {
        return damage;
    }

    public void setDamage(int damage)
    {
        this.damage = damage;
    }

    public void setPosition(int x, int y)
    {
        this.x = x;
        this.y = y;
        bounds.x = x;
        bounds.y = y;
    }

    public int getInvId() {
		return invId;
	}

	public int getSlot() {
		return slot;
	}

	public int getStartSlot() {
		return startSlot;
	}

	public void setStartSlot(int startSlot) {
		this.startSlot = startSlot;
	}

	public Effect getEffectType() {
		return effectType;
	}

	public void setSlot(int slot) {
		this.slot = slot;
	}

	public void setInvId(int invId) {
		this.invId = invId;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
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
