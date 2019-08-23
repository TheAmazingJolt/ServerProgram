package inventory;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import com.sun.glass.events.KeyEvent;

import entities.projectiles.PistolBullet;
import entities.projectiles.SmgBullet;
import gfx.Assets;
import items.Item;
import main.Handler;

// Referenced classes of package inventory:
//            Inventory

public class Hotbar
{

	private static Handler handler;
    private static boolean active = true;
    private static boolean hasItem1;
    private static ArrayList<Item> hotbarItems;
    
    private int invX;
    private int invY;
    private int invWidth;
    private int invHeight;
    
    private int slot1x;
    private int slotY;
    private int slotWidth;
    private int slotHeight;
    
    private int dividerWidth;
    
    private int slot2x;
    private int slot3x;
    private int slot4x;
    private int slot5x;
    
    private static int selectedItem = 0;
	
    public Hotbar(Handler handle)
    {
        invX = 332;
        invY = 645;
        invWidth = 299;
        invHeight = 56;
        slot1x = 339;
        slotY = 650;
        slotWidth = 45;
        slotHeight = 45;
        dividerWidth = 15;
        slot2x = slot1x + (slotWidth + dividerWidth);
        slot3x = slot2x + (slotWidth + dividerWidth);
        slot4x = slot3x + (slotWidth + dividerWidth);
        slot5x = slot4x + (slotWidth + dividerWidth);
        handler = handle;
        hotbarItems = new ArrayList<Item>();
    }
    
    public void tick()
    {
        if(handler.getKeyManager().keyJustPressed(49))
            selectedItem = 0;
        else
        if(handler.getKeyManager().keyJustPressed(50))
            selectedItem = 1;
        else
        if(handler.getKeyManager().keyJustPressed(51))
            selectedItem = 2;
        else
        if(handler.getKeyManager().keyJustPressed(52))
            selectedItem = 3;
        else
        if(handler.getKeyManager().keyJustPressed(53))
            selectedItem = 4;
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
        if(handler.getKeyManager().keyJustPressed(16) && hotbarItems.size() > 0 && !((Item)hotbarItems.get(selectedItem)).isTool() 
        		&& !handler.getWorld().getEntityManager().getPlayer().getInventory().isActive()) {
            useItem((Item)hotbarItems.get(selectedItem));
            return;
        }if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_SHIFT) && hotbarItems.size() > 0 && (hotbarItems.get(selectedItem).getName().contains("Upgrade"))) { 
            useUpgrade((Item)hotbarItems.get(selectedItem));
            return;
        }if(hotbarItems.size() > 0 && hotbarItems.get(selectedItem).getId() == 16)
        	if(handler.getWorld().getTile(handler.getWorld().getEntityManager().getPlayer().getTileX(),
        			handler.getWorld().getEntityManager().getPlayer().getTileY()).getId() == 4) {
        		handler.getWorld().getEntityManager().getPlayer().getInventory().removeItem(hotbarItems.get(selectedItem), 1);
        		handler.getWorld().getEntityManager().getPlayer().getInventory().addItem(Item.waterBottle, 1);
        		return;
        	}
    }

    public void render(Graphics g)
    {
        if(!active)
            return;
        g.drawImage(Assets.hotbar, invX, invY, invWidth, invHeight, null);
        int len = hotbarItems.size();
        if(len == 0)
            return;
        if(hotbarItems.size() <= 0)
            return;
        if(hotbarItems.size() == 1)
        {
            if(handler.getWorld().getEntityManager().getPlayer().getInventory().checkIfContains(hotbarItems.get(0).getId()))
                g.drawImage(((Item)hotbarItems.get(0)).getTexture(), slot1x, slotY, slotWidth, slotHeight, null);
            else
            if(!handler.getWorld().getEntityManager().getPlayer().getInventory().checkIfContains(hotbarItems.get(0).getId()))
            {
                hotbarItems.remove(hotbarItems.get(0));
                return;
            }
        } else
        if(hotbarItems.size() == 2)
        {
            if(handler.getWorld().getEntityManager().getPlayer().getInventory().checkIfContains(hotbarItems.get(0).getId()))
                g.drawImage(((Item)hotbarItems.get(0)).getTexture(), slot1x, slotY, slotWidth, slotHeight, null);
            else
            if(!handler.getWorld().getEntityManager().getPlayer().getInventory().checkIfContains(hotbarItems.get(0).getId()))
            {
                hotbarItems.remove(hotbarItems.get(0));
                return;
            }
            if(handler.getWorld().getEntityManager().getPlayer().getInventory().checkIfContains(hotbarItems.get(1).getId()))
                g.drawImage(((Item)hotbarItems.get(1)).getTexture(), slot2x, slotY, slotWidth, slotHeight, null);
            else
            if(!handler.getWorld().getEntityManager().getPlayer().getInventory().checkIfContains(hotbarItems.get(1).getId()))
            {
                hotbarItems.remove(hotbarItems.get(1));
                return;
            }
        } else
        if(hotbarItems.size() == 3)
        {
            if(handler.getWorld().getEntityManager().getPlayer().getInventory().checkIfContains(hotbarItems.get(0).getId()))
                g.drawImage(((Item)hotbarItems.get(0)).getTexture(), slot1x, slotY, slotWidth, slotHeight, null);
            else
            if(!handler.getWorld().getEntityManager().getPlayer().getInventory().checkIfContains(hotbarItems.get(0).getId()))
            {
                hotbarItems.remove(hotbarItems.get(0));
                return;
            }
            if(handler.getWorld().getEntityManager().getPlayer().getInventory().checkIfContains(hotbarItems.get(1).getId()))
                g.drawImage(((Item)hotbarItems.get(1)).getTexture(), slot2x, slotY, slotWidth, slotHeight, null);
            else
            if(!handler.getWorld().getEntityManager().getPlayer().getInventory().checkIfContains(hotbarItems.get(1).getId()))
            {
                hotbarItems.remove(hotbarItems.get(1));
                return;
            }
            if(handler.getWorld().getEntityManager().getPlayer().getInventory().checkIfContains(hotbarItems.get(2).getId()))
                g.drawImage(((Item)hotbarItems.get(2)).getTexture(), slot3x, slotY, slotWidth, slotHeight, null);
            else
            if(!handler.getWorld().getEntityManager().getPlayer().getInventory().checkIfContains(hotbarItems.get(2).getId()))
            {
                hotbarItems.remove(hotbarItems.get(2));
                return;
            }
        } else
        if(hotbarItems.size() == 4)
        {
            if(handler.getWorld().getEntityManager().getPlayer().getInventory().checkIfContains(hotbarItems.get(0).getId()))
                g.drawImage(((Item)hotbarItems.get(0)).getTexture(), slot1x, slotY, slotWidth, slotHeight, null);
            else
            if(!handler.getWorld().getEntityManager().getPlayer().getInventory().checkIfContains(hotbarItems.get(0).getId()))
            {
                hotbarItems.remove(hotbarItems.get(0));
                return;
            }
            if(handler.getWorld().getEntityManager().getPlayer().getInventory().checkIfContains(hotbarItems.get(1).getId()))
                g.drawImage(((Item)hotbarItems.get(1)).getTexture(), slot2x, slotY, slotWidth, slotHeight, null);
            else
            if(!handler.getWorld().getEntityManager().getPlayer().getInventory().checkIfContains(hotbarItems.get(1).getId()))
            {
                hotbarItems.remove(hotbarItems.get(1));
                return;
            }
            if(handler.getWorld().getEntityManager().getPlayer().getInventory().checkIfContains(hotbarItems.get(2).getId()))
                g.drawImage(((Item)hotbarItems.get(2)).getTexture(), slot3x, slotY, slotWidth, slotHeight, null);
            else
            if(!handler.getWorld().getEntityManager().getPlayer().getInventory().checkIfContains(hotbarItems.get(2).getId()))
            {
                hotbarItems.remove(hotbarItems.get(2));
                return;
            }
            if(handler.getWorld().getEntityManager().getPlayer().getInventory().checkIfContains(hotbarItems.get(3).getId()))
                g.drawImage(((Item)hotbarItems.get(3)).getTexture(), slot4x, slotY, slotWidth, slotHeight, null);
            else
            if(!handler.getWorld().getEntityManager().getPlayer().getInventory().checkIfContains(hotbarItems.get(3).getId()))
            {
                hotbarItems.remove(hotbarItems.get(3));
                return;
            }
        } else
        if(hotbarItems.size() == 5)
        {
            if(handler.getWorld().getEntityManager().getPlayer().getInventory().checkIfContains(hotbarItems.get(0).getId()))
                g.drawImage(((Item)hotbarItems.get(0)).getTexture(), slot1x, slotY, slotWidth, slotHeight, null);
            else
            if(!handler.getWorld().getEntityManager().getPlayer().getInventory().checkIfContains(hotbarItems.get(0).getId()))
            {
                hotbarItems.remove(hotbarItems.get(0));
                return;
            }
            if(handler.getWorld().getEntityManager().getPlayer().getInventory().checkIfContains(hotbarItems.get(1).getId()))
                g.drawImage(((Item)hotbarItems.get(1)).getTexture(), slot2x, slotY, slotWidth, slotHeight, null);
            else
            if(!handler.getWorld().getEntityManager().getPlayer().getInventory().checkIfContains(hotbarItems.get(1).getId()))
            {
                hotbarItems.remove(hotbarItems.get(1));
                return;
            }
            if(handler.getWorld().getEntityManager().getPlayer().getInventory().checkIfContains(hotbarItems.get(2).getId()))
                g.drawImage(((Item)hotbarItems.get(2)).getTexture(), slot3x, slotY, slotWidth, slotHeight, null);
            else
            if(!handler.getWorld().getEntityManager().getPlayer().getInventory().checkIfContains(hotbarItems.get(2).getId()))
            {
                hotbarItems.remove(hotbarItems.get(2));
                return;
            }
            if(handler.getWorld().getEntityManager().getPlayer().getInventory().checkIfContains(hotbarItems.get(3).getId()))
                g.drawImage(((Item)hotbarItems.get(3)).getTexture(), slot4x, slotY, slotWidth, slotHeight, null);
            else
            if(!handler.getWorld().getEntityManager().getPlayer().getInventory().checkIfContains(hotbarItems.get(3).getId()))
            {
                hotbarItems.remove(hotbarItems.get(3));
                return;
            }
            if(handler.getWorld().getEntityManager().getPlayer().getInventory().checkIfContains(hotbarItems.get(4).getId()))
                g.drawImage(((Item)hotbarItems.get(4)).getTexture(), slot5x, slotY, slotWidth, slotHeight, null);
            else
            if(!handler.getWorld().getEntityManager().getPlayer().getInventory().checkIfContains(hotbarItems.get(4).getId()))
            {
                hotbarItems.remove(hotbarItems.get(4));
                return;
            }
        }

        if(selectedItem == 0)
            g.drawImage(Assets.outline, slot1x, slotY, slotWidth, slotHeight, null);
        else
        if(selectedItem == 1)
            g.drawImage(Assets.outline, slot2x, slotY, slotWidth, slotHeight, null);
        else
        if(selectedItem == 2)
            g.drawImage(Assets.outline, slot3x, slotY, slotWidth, slotHeight, null);
        else
        if(selectedItem == 3)
            g.drawImage(Assets.outline, slot4x, slotY, slotWidth, slotHeight, null);
        else
        if(selectedItem == 4)
            g.drawImage(Assets.outline, slot5x, slotY, slotWidth, slotHeight, null);
    }

    public static void useItem(Item item)
    {
        if(checkIfContains(item.getId()) && item.isHeal())
        {
            if(item.getName() == "Health Boost Potion")
                handler.getWorld().getEntityManager().getPlayer().setMaxHealth(handler.getWorld().getEntityManager().getPlayer().getMaxHealth() + 5);
            if(item.getName() == "Steel Health Boost Potion")
                handler.getWorld().getEntityManager().getPlayer().setMaxHealth(handler.getWorld().getEntityManager().getPlayer().getMaxHealth() + 10);
            handler.getWorld().getEntityManager().getPlayer().setHealth(handler.getWorld().getEntityManager().getPlayer().getMaxHealth());
            handler.getWorld().getEntityManager().getPlayer().getInventory().removeItem(item, 1);
            handler.getWorld().getEntityManager().getPlayer().getInventory().addItem(Item.bottleItem, 1);
            if(item.getCount() <= 0)
                selectedItem--;
        }
    }

    public void useRanged(Item item)
    {
    	if(checkIfContains(item.getId()) && item.isRanged())
        {
        	if(item.getAmmoType().getName() == "Pistol Bullet") {
        		if(handler.getWorld().getEntityManager().getPlayer().getInventory().checkIfContains(item.getAmmoType().getId())) {
                	PistolBullet bullet = new PistolBullet(handler, -10, -10, handler.getWorld().getEntityManager().getPlayer());
                   	handler.getWorld().getEntityManager().add(bullet);
                   	handler.getWorld().getEntityManager().getPlayer().setAttackCooldown2(bullet.getAttackCooldown());
                   	bullet.fire(handler.getWorld().getEntityManager().getPlayer().getDirectionMoving());
        		}else {
        			return;
        		}
        	}else if(item.getAmmoType().getName() == "Smg Bullet") {
        		if(handler.getWorld().getEntityManager().getPlayer().getInventory().checkIfContains(item.getAmmoType().getId())) {
                	SmgBullet bullet = new SmgBullet(handler, -10, -10, handler.getWorld().getEntityManager().getPlayer());
                   	handler.getWorld().getEntityManager().add(bullet);
                   	handler.getWorld().getEntityManager().getPlayer().setAttackCooldown2(bullet.getAttackCooldown());
                   	bullet.fire(handler.getWorld().getEntityManager().getPlayer().getDirectionMoving());
        		}else {
        			return;
        		}
        	}else {
        		return;
        	}
            handler.getWorld().getEntityManager().getPlayer().getInventory().removeItem(item.getAmmoType(), 1);
            if(item.getCount() <= 0)
                selectedItem--;
        }
    }
    
    public void useUpgrade(Item item)
    {
    	if(checkIfContains(item.getId()) && item.isUpgrade())
        {
        	handler.getWorld().getEntityManager().getPlayer().getUpgrades().add(item.getUpgradeType());
            handler.getWorld().getEntityManager().getPlayer().getInventory().removeItem(item, 1);
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

    public Handler getHandler()
    {
        return handler;
    }

    public void setHandler(Handler handle)
    {
        handler = handle;
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