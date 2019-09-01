package inventory;

import java.util.ArrayList;
import java.util.Iterator;

import entities.projectiles.PistolBullet;
import entities.projectiles.SmgBullet;
import items.Item;
import worlds.World;

// Referenced classes of package inventory:
//            Inventory

public class Hotbar
{

    private static boolean active = true;
    private static boolean hasItem1;
    private static ArrayList<Item> hotbarItems;
    
    private static int selectedItem = 0;
    
    private static World world;
	
    public Hotbar(World worl)
    {
        world = worl;
        hotbarItems = new ArrayList<Item>();
    }
    
    public void tick()
    {
    	if(world.id == 1) {
    		if(world.storage.getCurrentKey1().contains("1"))
                selectedItem = 0;
            else
            if(world.storage.getCurrentKey1().contains("2"))
                selectedItem = 1;
            else
            if(world.storage.getCurrentKey1().contains("3"))
                selectedItem = 2;
            else
            if(world.storage.getCurrentKey1().contains("4"))
                selectedItem = 3;
            else
            if(world.storage.getCurrentKey1().contains("5"))
                selectedItem = 4;
    	}else if(world.id == 2) {
    		if(world.storage.getCurrentKey2().contains("1"))
                selectedItem = 0;
            else
            if(world.storage.getCurrentKey2().contains("2"))
                selectedItem = 1;
            else
            if(world.storage.getCurrentKey2().contains("3"))
                selectedItem = 2;
            else
            if(world.storage.getCurrentKey2().contains("4"))
                selectedItem = 3;
            else
            if(world.storage.getCurrentKey2().contains("5"))
                selectedItem = 4;
    	}
        
        if(selectedItem < 0)
            selectedItem = 0;
        else
        if(selectedItem >= 5)
            selectedItem = 4;
        if(hotbarItems.size() == 0 || hotbarItems.size() == 1)
            selectedItem = 0;
        else
        if(hotbarItems.size() == 2 && selectedItem > 1)
            selectedItem = 1;
        else
        if(hotbarItems.size() == 3 && selectedItem > 2)
            selectedItem = 2;
        else
        if(hotbarItems.size() == 4 && selectedItem > 3)
            selectedItem = 3;
        else
        if(hotbarItems.size() == 5 && selectedItem > 4)
            selectedItem = 4;
        if(world.id == 1) {
        	if(world.storage.getCurrentKey1().contains("shift") && hotbarItems.size() > 0 && !((Item)hotbarItems.get(selectedItem)).isTool() 
            		&& !world.getEntityManager().getPlayer().getInventory().isActive()) {
                useItem((Item)hotbarItems.get(selectedItem));
                return;
            }else if(world.storage.getCurrentKey1().contains("shift") && hotbarItems.size() > 0 && (hotbarItems.get(selectedItem).getName().contains("Upgrade"))) { 
                useUpgrade((Item)hotbarItems.get(selectedItem));
                return;
            }
        }else if(world.id == 2) {
        	if(world.storage.getCurrentKey2().contains("shift") && hotbarItems.size() > 0 && !((Item)hotbarItems.get(selectedItem)).isTool() 
            		&& !world.getEntityManager().getPlayer().getInventory().isActive()) {
                useItem((Item)hotbarItems.get(selectedItem));
                return;
            }else if(world.storage.getCurrentKey2().contains("shift") && hotbarItems.size() > 0 && (hotbarItems.get(selectedItem).getName().contains("Upgrade"))) { 
                useUpgrade((Item)hotbarItems.get(selectedItem));
                return;
            }
        }
        if(hotbarItems.size() > 0 && hotbarItems.get(selectedItem).getId() == 16)
        	if(world.getTile(world.getEntityManager().getPlayer().getTileX(),
        			world.getEntityManager().getPlayer().getTileY()).getId() == 4) {
        		world.getEntityManager().getPlayer().getInventory().removeItem(hotbarItems.get(selectedItem), 1);
        		world.getEntityManager().getPlayer().getInventory().addItem(Item.waterBottle, 1);
        		return;
        	}
        if(hotbarItems.size() <= 0)
            return;
        if(hotbarItems.size() == 1)
        {
            if(!world.getEntityManager().getPlayer().getInventory().checkIfContains(hotbarItems.get(0).getId()))
            {
                hotbarItems.remove(hotbarItems.get(0));
                return;
            }
        } else
        if(hotbarItems.size() == 2)
        {
            if(!world.getEntityManager().getPlayer().getInventory().checkIfContains(hotbarItems.get(0).getId()))
            {
                hotbarItems.remove(hotbarItems.get(0));
                return;
            }
            if(!world.getEntityManager().getPlayer().getInventory().checkIfContains(hotbarItems.get(1).getId()))
            {
                hotbarItems.remove(hotbarItems.get(1));
                return;
            }
        } else
        if(hotbarItems.size() == 3)
        {
            if(!world.getEntityManager().getPlayer().getInventory().checkIfContains(hotbarItems.get(0).getId()))
            {
                hotbarItems.remove(hotbarItems.get(0));
                return;
            }
            if(!world.getEntityManager().getPlayer().getInventory().checkIfContains(hotbarItems.get(1).getId()))
            {
                hotbarItems.remove(hotbarItems.get(1));
                return;
            }
            if(!world.getEntityManager().getPlayer().getInventory().checkIfContains(hotbarItems.get(2).getId()))
            {
                hotbarItems.remove(hotbarItems.get(2));
                return;
            }
        } else
        if(hotbarItems.size() == 4)
        {
            if(!world.getEntityManager().getPlayer().getInventory().checkIfContains(hotbarItems.get(0).getId()))
            {
                hotbarItems.remove(hotbarItems.get(0));
                return;
            }
            if(!world.getEntityManager().getPlayer().getInventory().checkIfContains(hotbarItems.get(1).getId()))
            {
                hotbarItems.remove(hotbarItems.get(1));
                return;
            }
            if(!world.getEntityManager().getPlayer().getInventory().checkIfContains(hotbarItems.get(2).getId()))
            {
                hotbarItems.remove(hotbarItems.get(2));
                return;
            }
            if(!world.getEntityManager().getPlayer().getInventory().checkIfContains(hotbarItems.get(3).getId()))
            {
                hotbarItems.remove(hotbarItems.get(3));
                return;
            }
        } else
        if(hotbarItems.size() == 5)
        {
            if(!world.getEntityManager().getPlayer().getInventory().checkIfContains(hotbarItems.get(0).getId()))
            {
                hotbarItems.remove(hotbarItems.get(0));
                return;
            }
            if(!world.getEntityManager().getPlayer().getInventory().checkIfContains(hotbarItems.get(1).getId()))
            {
                hotbarItems.remove(hotbarItems.get(1));
                return;
            }
            if(!world.getEntityManager().getPlayer().getInventory().checkIfContains(hotbarItems.get(2).getId()))
            {
                hotbarItems.remove(hotbarItems.get(2));
                return;
            }
            if(!world.getEntityManager().getPlayer().getInventory().checkIfContains(hotbarItems.get(3).getId()))
            {
                hotbarItems.remove(hotbarItems.get(3));
                return;
            }
            if(!world.getEntityManager().getPlayer().getInventory().checkIfContains(hotbarItems.get(4).getId()))
            {
                hotbarItems.remove(hotbarItems.get(4));
                return;
            }
        }
    }

    public static void useItem(Item item)
    {
        if(checkIfContains(item.getId()) && item.isHeal())
        {
            if(item.getName() == "Health Boost Potion")
            	world.getEntityManager().getPlayer().setMaxHealth(world.getEntityManager().getPlayer().getMaxHealth() + 5);
            if(item.getName() == "Steel Health Boost Potion")
            	world.getEntityManager().getPlayer().setMaxHealth(world.getEntityManager().getPlayer().getMaxHealth() + 10);
            world.getEntityManager().getPlayer().setHealth(world.getEntityManager().getPlayer().getMaxHealth());
            world.getEntityManager().getPlayer().getInventory().removeItem(item, 1);
            world.getEntityManager().getPlayer().getInventory().addItem(Item.bottleItem, 1);
            if(item.getCount() <= 0)
                selectedItem--;
        }
    }

    public void useRanged(Item item)
    {
    	if(checkIfContains(item.getId()) && item.isRanged())
        {
        	if(item.getAmmoType().getName() == "Pistol Bullet") {
        		if(world.getEntityManager().getPlayer().getInventory().checkIfContains(item.getAmmoType().getId())) {
                	PistolBullet bullet = new PistolBullet(-10, -10, world.getEntityManager().getPlayer(), world);
                	world.getEntityManager().add(bullet);
                	world.getEntityManager().getPlayer().setAttackCooldown2(bullet.getAttackCooldown());
                   	bullet.fire(world.getEntityManager().getPlayer().getDirectionMoving());
        		}else {
        			return;
        		}
        	}else if(item.getAmmoType().getName() == "Smg Bullet") {
        		if(world.getEntityManager().getPlayer().getInventory().checkIfContains(item.getAmmoType().getId())) {
                	SmgBullet bullet = new SmgBullet(-10, -10, world.getEntityManager().getPlayer(), world);
                	world.getEntityManager().add(bullet);
                	world.getEntityManager().getPlayer().setAttackCooldown2(bullet.getAttackCooldown());
                   	bullet.fire(world.getEntityManager().getPlayer().getDirectionMoving());
        		}else {
        			return;
        		}
        	}else {
        		return;
        	}
        	world.getEntityManager().getPlayer().getInventory().removeItem(item.getAmmoType(), 1);
            if(item.getCount() <= 0)
                selectedItem--;
        }
    }
    
    public void useUpgrade(Item item)
    {
    	if(checkIfContains(item.getId()) && item.isUpgrade())
        {
    		world.getEntityManager().getPlayer().getUpgrades().add(item.getUpgradeType());
    		world.getEntityManager().getPlayer().getInventory().removeItem(item, 1);
            if(item.getCount() <= 0)
                selectedItem--;
        }
    }

    public int getSelectedItem()
    {
        return selectedItem;
    }

    public void addItem(Item item, int amt)
    {
        for(Iterator<Item> iterator = hotbarItems.iterator(); iterator.hasNext();)
        {
            Item i = (Item)iterator.next();
            if(i.getId() == item.getId())
                return;
        }

        hotbarItems.add(item);
    }

    public static void removeItem(int id, int amt)
    {
        for(Iterator<Item> iterator = hotbarItems.iterator(); iterator.hasNext();)
        {
            Item i = (Item)iterator.next();
            if(i.getId() == id)
            {
                i.setCount(i.getCount() - amt);
                if(i.getCount() <= 0)
                {
                    selectedItem = hotbarItems.size() - 2;
                    hotbarItems.remove(i);
                }
            }
        }

    }

    public static boolean checkIfContains(int id)
    {
        hasItem1 = false;
        for(Iterator<Item> iterator = hotbarItems.iterator(); iterator.hasNext(); hasItem1 = false)
        {
            Item i = (Item)iterator.next();
            if(i.getId() != id)
                continue;
            hasItem1 = true;
            break;
        }

        return hasItem1;
    }

    public static boolean isActive()
    {
        return active;
    }

    public void setActive(boolean activ)
    {
        active = activ;
    }

    public ArrayList<Item> getInventoryItems()
    {
        return hotbarItems;
    }

    public static void setSelectedItem(int i)
    {
        selectedItem = i;
    }

    

}