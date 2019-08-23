package items;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import main.Handler;
import tiles.Tile;
import gfx.Assets;

public class Item {
	
	public static ArrayList<Item> items = new ArrayList<Item>();
	public static Item woodItem = new Item(Assets.wood, "Wood", 0, false, false, false, false, 1);
    public static Item rockItem = new Item(Assets.rock, "Rock", 1, false, false, false, false, 1);
    public static Item axeItem = new Item(Assets.axe, "Axe", 2, true, false, false, false, 2);
    public static Item flintItem = new Item(Assets.flintRock, "Flint", 3, false, false, false, false, 1);
    public static Item fireItem = new Item(Assets.fire, "Fire", 4, false, false, false, false, 1);
    public static Item ironOreItem = new Item(Assets.ironOre, "Iron Ore", 5, false, false, false, false, 1);
    public static Item ironBarItem = new Item(Assets.ironBar, "Iron Bar", 6, false, false, false, false, 1);
    public static Item cutWoodItem = new Item(Assets.cutWood, "Cut Wood", 7, false, false, false, false, 1);
    public static Item ironAxeItem = new Item(Assets.ironAxe, "Iron Axe", 8, true, false, false, false, 3);
    public static Item woodenHandleItem = new Item(Assets.woodenHandle, "Wooden Handle", 9, false, false, false, false, 1);
    public static Item charcoalItem = new Item(Assets.charcoal, "Charcoal", 11, true, false, false, false, 1);
    public static Item rottenFleshItem = new Item(Assets.rottenFlesh, "Rotten Flesh", 12, false, false, false, false, 1);
    public static Item crushedIronItem = new Item(Assets.crushedIron, "Crushed Iron", 13, false, false, false, false, 1);
    public static Item healingPowderItem = new Item(Assets.healingPowder, "Healing Powder", 14, false, false, false, false, 1);
    public static Item healingPotionItem = new Item(Assets.healingPotion, "Healing Potion", 15, false, true, false, false, 1);
    public static Item bottleItem = new Item(Assets.bottle, "Bottle", 16, false, false, false, false, 1);
    public static Item healthBoostItem = new Item(Assets.healthBoostPotion, "Health Boost Potion", 18, false, true, false, false, 1);
    public static Item ashyWoodItem = new Item(Assets.ashyWood, "Ashy Wood", 19, false, false, false, false, 1);
    public static Item coalItem = new Item(Assets.coal, "Coal", 20, false, false, false, false, 1);
    public static Item coalDustItem = new Item(Assets.coalDust, "Coal Dust", 21, false, false, false, false, 1);
    public static Item steelBarItem = new Item(Assets.steelBar, "Steel Bar", 22, false, false, false, false, 1);
    public static Item steelAxeItem = new Item(Assets.steelAxe, "Steel Axe", 23, true, false, false, false, 4);
    public static Item steelHealthBoostItem = new Item(Assets.steelHealthBoostPotion, "Steel Health Boost Potion", 24, false, true, false, false, 1);
    public static Item pistolBulletItem = new Item(Assets.steelBullet, "Pistol Bullet", 25, false, false, false, true, 1);
    public static Item pistolItem = new Item(Assets.steelGun, "Steel Gun", 26, pistolBulletItem, 1);
    public static Item inventoryUpgrade = new Item(Assets.inventoryUpgrade, "Inventory Upgrade", 27, Upgrade.inventoryUpgrade);
    public static Item speedUpgrade = new Item(Assets.speedUpgrade, "Speed Upgrade", 28, Upgrade.speedUpgrade);
    public static Item woodenStructure = new Item(Assets.woodenStructure, "Wooden Structure", 29, Tile.woodStructure);
    public static Item cutAshyWood = new Item(Assets.cutAshyWood, "Cut Ashy Wood", 30, false, false, false, false, 1);
    public static Item steelHammer = new Item(Assets.steelHammer, "Steel Hammer", 31, true, false, false, false, 2);
    public static Item ashyWoodHandle = new Item(Assets.ashyWoodHandle, "Ashy Wood Handle", 32, false, false, false, false, 1);
    public static Item steelPlate = new Item(Assets.steelPlate, "Steel Plate", 33, false, false, false, false, 1);
    public static Item steelRod = new Item(Assets.steelRod, "Steel Rod", 34, false, false, false, false, 1);
    public static Item gunPowder = new Item(Assets.gunPowder, "Gun Powder", 35, false, false, false, false, 1);
    public static Item snow = new Item(Assets.snow, "Snow", 36, false, false, false, false, 1);
    public static Item waterBottle = new Item(Assets.waterBottle, "Water Bottle", 37, false, false, false, false, 1);
    public static Item smgBullet = new Item(Assets.smgBullet, "Smg Bullet", 38, false, false, false, true, 1);
    public static Item smg = new Item(Assets.smg, "SMG", 39, smgBullet, 1);

	public static final int ITEMWIDTH = 32, ITEMHEIGHT = 32;
	
	protected Handler handler;
    protected BufferedImage texture;
    protected String name;
    
    protected boolean tool;
    protected boolean heal;
    protected boolean key;
    protected boolean ranged;
    protected boolean ammo;
    protected boolean upgrade = false;
    protected boolean tile = false;
    
    protected Item ammoType;
    protected Upgrade upgradeType;
    protected Tile tileType;
    
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
    public Item(BufferedImage texture, String name, int id, boolean tool, boolean heal, boolean ranged, boolean ammo, int damage)
    {
        pickedUp = false;
        this.texture = texture;
        this.name = name;
        this.id = id;
        this.heal = heal;
        this.damage = damage;
        this.tool = tool;
        this.ranged = ranged;
        this.ammo = ammo;
        count = 1;
        bounds = new Rectangle(x, y, 32, 32);
    }
    
    public Item(BufferedImage texture, String name, int id, Item ammoType, int damage)
    {
        pickedUp = false;
        this.texture = texture;
        this.name = name;
        this.id = id;
        this.heal = false;
        this.damage = damage;
        this.tool = true;
        this.ranged = true;
        this.ammoType = ammoType;
        count = 1;
        bounds = new Rectangle(x, y, 32, 32);
    }
    
    public Item(BufferedImage texture, String name, int id, Upgrade upgradeType)
    {
        pickedUp = false;
        this.texture = texture;
        this.name = name;
        this.id = id;
        this.heal = false;
        this.tool = true;
        this.ranged = false;
        this.upgrade = true;
        this.upgradeType = upgradeType;
        count = 1;
        bounds = new Rectangle(x, y, 32, 32);
    }
    
    public Item(BufferedImage texture, String name, int id, Tile tileType)
    {
        pickedUp = false;
        this.texture = texture;
        this.name = name;
        this.id = id;
        this.heal = false;
        this.tool = false;
        this.ranged = false;
        this.upgrade = false;
        this.tileType = tileType;
        this.tile = true;
        count = 1;
        bounds = new Rectangle(x, y, 32, 32);
    }

    public static void addItemsToList()
    {
        items = new ArrayList<Item>();
        items.add(axeItem);
        items.add(bottleItem);
        items.add(charcoalItem);
        items.add(crushedIronItem);
        items.add(cutWoodItem);
        items.add(fireItem);
        items.add(flintItem);
        items.add(healingPotionItem);
        items.add(healingPowderItem);
        items.add(ironAxeItem);
        items.add(ironBarItem);
        items.add(ironOreItem);
        items.add(rockItem);
        items.add(rottenFleshItem);
        items.add(woodItem);
        items.add(woodenHandleItem);
        items.add(healthBoostItem);
        items.add(ashyWoodItem);
        items.add(coalItem);
        items.add(coalDustItem);
        items.add(steelBarItem);
        items.add(steelAxeItem);
        items.add(steelHealthBoostItem);
        items.add(pistolItem);
        items.add(pistolBulletItem);
        items.add(inventoryUpgrade);
        items.add(speedUpgrade);
        items.add(woodenStructure);
        items.add(cutAshyWood);
        items.add(steelHammer);
        items.add(ashyWoodHandle);
        items.add(steelPlate);
        items.add(steelRod);
        items.add(gunPowder);
        items.add(waterBottle);
        items.add(smgBullet);
        items.add(smg);
    }

    public void setTool(boolean tool) {
		this.tool = tool;
	}

	public void setHeal(boolean heal) {
		this.heal = heal;
	}

	public void setUpgrade(boolean upgrade) {
		this.upgrade = upgrade;
	}

	public void tick()
    {
    	if(this.upgradeType != null) {
    		this.upgrade = true;
    	}
        if(handler.getWorld().getEntityManager().getPlayer().getCollisionBounds(0.0F, 0.0F).intersects(bounds))
        {
            pickedUp = true;
            handler.getWorld().getEntityManager().getPlayer().getInventory().addItem(this, 1);
        }
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

    public Item createNew(int count)
    {
        Item i = new Item(texture, name, id, tool, heal, key, ranged, damage);
        i.setPickedUp(true);
        i.setCount(count);
        return i;
    }

    public Item createNew(int x, int y, boolean tool, boolean heal, boolean ranged)
    {
        Item i = new Item(texture, name, id, tool, heal, key, ranged, damage);
        i.setPosition(x, y);
        return i;
    }

    public int getDamage()
    {
        return damage;
    }

    public Upgrade getUpgradeType() {
		return upgradeType;
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

    public Tile getTileType() {
		return tileType;
	}

	public Handler getHandler()
    {
        return handler;
    }

    public boolean isUpgrade() {
		return upgrade;
	}

	public boolean isTile() {
		return tile;
	}

	public int getInvId() {
		return invId;
	}

	public boolean isRanged() {
		return ranged;
	}

	public Item getAmmoType() {
		return ammoType;
	}

	public void setRanged(boolean ranged) {
		this.ranged = ranged;
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

    public boolean isTool()
    {
        return tool;
    }

    public boolean isHeal()
    {
        return heal;
    }

    public boolean isKey()
    {
        return key;
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

    public static ArrayList<Item> getItems()
    {
        return items;
    }
	
}
