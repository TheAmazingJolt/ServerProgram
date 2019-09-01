package entities.creatures;

import java.awt.Rectangle;
import java.util.ArrayList;

import entities.Entity;
import inventory.Grave;
import inventory.Hotbar;
import inventory.Inventory;
import inventory.LargeInventory;
import items.Item;
import items.Upgrade;
import tiles.Tile;
import tiles.structures.Structure;
import tiles.structures.WoodStructure;
import utils.Timer;
import worlds.World;

// Referenced classes of package entities.creatures:
//            Creature

public class Player extends Creature
{
    
    private long attackCooldown;
    private long attackCooldown2;
    
    private static int killedEnemies;
    private static int killedBosses = 0;
    private static int maxHealth;
    private int playerId;
    private int currentDialougueFran = 1;
    private int currentDialougueSierra = 1;
    private int currentDialougueChris = 1;
    
    private static ArrayList<Upgrade> upgrades;
    
    private float startX;
    private float startY;
    
    private Inventory inventory;
    private Grave grave;
    private Hotbar hotbar;
    private LargeInventory weapons;
    
    private Rectangle ar;
    
    private String directionMoving = "";
    
    private Timer timer;
    private Timer timer2;
	
    public Player(float x, float y, int playerId, int id, World world)
    {
        super(x, y, 64, 64, 10, id, world);
        this.playerId = playerId;
        attackCooldown = 200L;
        attackCooldown2 = 250;
        startX = 800F;
        startY = 800F;
        health = 10;
        bounds.x = 22;
        bounds.y = 30;
        bounds.width = 20;
        bounds.height = 34;
        inventory = new Inventory(world);
        hotbar = new Hotbar(world);
        weapons = new LargeInventory(world);
        upgrades = new ArrayList<Upgrade>();
        maxHealth = 10;
        ar = new Rectangle();
    }

    public void tick()
    {
    	System.out.println("Player Tick");
        if(health <= 0)
            die();
        if(playerId == 1) {
        	if(grave != null) {
        		if(!grave.isCollected())
        			grave.tick();
        		else if(grave.isCollected())
        			grave = null;
        	}
        	getInput();
            move();
            checkAttacks();
            if(world.id == 1) {
            	if(world.storage.getCurrentMousePress1().contains("left") && !inventory.isActive()) {
                    checkRangedAttacks();
                    buildStructure();
                }
            }else if(world.id == 2) {
            	if(world.storage.getCurrentMousePress2().contains("left") && !inventory.isActive()) {
                    checkRangedAttacks();
                    buildStructure();
                }
            }
            inventory.tick();
            hotbar.tick();
            weapons.tick();
            for(Upgrade u : upgrades) {
            	if(u.getEffectType().isInventoryExpansion()) {
            		if(!inventory.isLargeUnlocked()){
            			inventory.setLargeUnlocked(true);
            		}
           	 	}else if(u.getEffectType().isSpeed()) {
           	 		this.newSpeed = this.DEFAULT_SPEED * u.getEffectType().getMultiplier();
           	 	}
            }
            checkCurrentTile();
            for(int i = 0; i < Tile.getTiles().size(); i++) {
            	Tile t = Tile.getTiles().get(i);
           	 	if(i == (tileY * 104) + tileX) {
           	 		if(t.getId() == 4)
           	 			this.speed = (float) (DEFAULT_SPEED * 0.75);
           	 		else
           	 			this.speed = newSpeed;
           	 	}
            }
        }
    }
    
    private void buildStructure() {
    	if(world.id == 1) {
    		float mouseX = world.storage.getMouseX1() + world.storage.getCameraXOffset1();
        	float mouseY = world.storage.getMouseY1() + world.storage.getCameraYOffset1();
        	int tileX = (int) Math.floor(mouseX/64);
        	int tileY = (int) Math.floor(mouseY/64);
        	for(Item i : hotbar.getInventoryItems()) {
        		if(i.isTile()) {
        			if(i.getTileType().getId() == 9) {
        				Structure s = new WoodStructure(9);
        				Tile.getStructures().add(s);
        				s.setLocation(tileX, tileY);
        				inventory.removeItem(i, 1);
               		 	try {
    						Thread.sleep(150);
    					} catch (InterruptedException e) {
    						e.printStackTrace();
    					}
        				return;
        			}
        		}
        	}
    	}else if(world.id == 2) {
    		float mouseX = world.storage.getMouseX2() + world.storage.getCameraXOffset2();
        	float mouseY = world.storage.getMouseY2() + world.storage.getCameraYOffset2();
        	int tileX = (int) Math.floor(mouseX/64);
        	int tileY = (int) Math.floor(mouseY/64);
        	for(Item i : hotbar.getInventoryItems()) {
        		if(i.isTile()) {
        			if(i.getTileType().getId() == 9) {
        				Structure s = new WoodStructure(9);
        				Tile.getStructures().add(s);
        				s.setLocation(tileX, tileY);
        				inventory.removeItem(i, 1);
               		 	try {
    						Thread.sleep(150);
    					} catch (InterruptedException e) {
    						e.printStackTrace();
    					}
        				return;
        			}
        		}
        	}
    	}
    }
    
    private void checkRangedAttacks() {
    	if(inventory.isActive())
    		return;
    	if(playerId == 1) {
        	if(timer2 == null)
        		timer2 = new Timer(attackCooldown2, 1);
        	timer2.tick();
        	if(!timer2.isCompleted()) {
        		return;
        	}else if(timer2.isCompleted()) {
        		timer2 = null;
        	}
            if(inventory.isActive())
                return;
            if(world.id == 1) {
            	float mouseX = world.storage.getMouseX1() + world.storage.getCameraXOffset1();
               	float mouseY = world.storage.getMouseY1() + world.storage.getCameraYOffset1();
               	if(mouseX >= this.x + this.width && mouseY >= this.y && mouseY <= this.y + this.height) {
               		directionMoving = "right";
               	}else if(mouseX <= this.x && mouseY >= this.y && mouseY <= this.y + this.height) {
               		directionMoving = "left";
               	}else if(mouseY >= this.y + this.height && mouseX >= this.x && mouseX <= this.x + this.width) {
               		directionMoving = "down";
               	}else if(mouseY <= this.y && mouseX >= this.x && mouseX <= this.x + this.width) {
               		directionMoving = "up";
               	}else {
               		directionMoving = "";
               	}
                if(hotbar.getInventoryItems().size() > 0) {
                	hotbar.useRanged(hotbar.getInventoryItems().get(hotbar.getSelectedItem()));
                }
            }else if(world.id == 2) {
            	float mouseX = world.storage.getMouseX2() + world.storage.getCameraXOffset2();
               	float mouseY = world.storage.getMouseY2() + world.storage.getCameraYOffset2();
               	if(mouseX >= this.x + this.width && mouseY >= this.y && mouseY <= this.y + this.height) {
               		directionMoving = "right";
               	}else if(mouseX <= this.x && mouseY >= this.y && mouseY <= this.y + this.height) {
               		directionMoving = "left";
               	}else if(mouseY >= this.y + this.height && mouseX >= this.x && mouseX <= this.x + this.width) {
               		directionMoving = "down";
               	}else if(mouseY <= this.y && mouseX >= this.x && mouseX <= this.x + this.width) {
               		directionMoving = "up";
               	}else {
               		directionMoving = "";
               	}
                if(hotbar.getInventoryItems().size() > 0) {
                	hotbar.useRanged(hotbar.getInventoryItems().get(hotbar.getSelectedItem()));
                }
            }
    	}
    }
    
    private void getInput()
    {
    	if(playerId == 1) {
    		xMove = 0.0F;
            yMove = 0.0F;
            if(inventory.isActive())
                return;
            if(world.id == 1) {
            	if(world.storage.getCurrentKey1().contains("W"))
                    yMove = -speed;
                if(world.storage.getCurrentKey1().contains("S") && !world.storage.getCurrentKey1().contains("shift") && !world.storage.getCurrentKey1().contains("escape")) {
                	yMove = speed;
                	}
                if(world.storage.getCurrentKey1().contains("A") && !world.storage.getCurrentKey1().contains("escape"))
                    xMove = -speed;
                if(world.storage.getCurrentKey1().contains("D"))
                    xMove = speed;
            }else if(world.id == 2) {
            	if(world.storage.getCurrentKey2().contains("W"))
                    yMove = -speed;
                if(world.storage.getCurrentKey2().contains("S") && !world.storage.getCurrentKey1().contains("shift") && !world.storage.getCurrentKey1().contains("escape")) {
                	yMove = speed;
                	}
                if(world.storage.getCurrentKey2().contains("A") && !world.storage.getCurrentKey1().contains("escape"))
                    xMove = -speed;
                if(world.storage.getCurrentKey2().contains("D"))
                    xMove = speed;
            }
    	}
    }
    
    private void checkAttacks()
    {
    	if(playerId == 1) {
    		if(health <= 0)
                die();
            if(hotbar.getInventoryItems().size() > 0) {
            	if(hotbar.getSelectedItem() >= hotbar.getInventoryItems().size()) {
            		return;
            	}
                this.attackStrength = ((Item)hotbar.getInventoryItems().get(hotbar.getSelectedItem())).getDamage();
            }
            else
                this.attackStrength = 1;
        	if(timer == null)
        		timer = new Timer(attackCooldown, 1);
        	timer.tick();
        	if(!timer.isCompleted()) {
        		return;
        	}else if(timer.isCompleted()) {
        		timer = null;
        	}
            if(inventory.isActive())
                return;
            Rectangle cb = getCollisionBounds(0.0F, 0.0F);
            int arSize = 20;
            ar.width = arSize;
            ar.height = arSize;
            if(yMove < 0.0F && xMove == 0)
            {
                ar.x = (cb.x + cb.width / 2) - arSize / 2;
                ar.y = cb.y - arSize;
            } else
            if(yMove > 0.0F && xMove == 0|| yMove == 0 && xMove == 0)
            {
                ar.x = (cb.x + cb.width / 2) - arSize / 2;
                ar.y = cb.y + cb.height;
                
            }
            
            if(xMove < 0.0F && yMove == 0)
            {
                ar.x = cb.x - arSize;
                ar.y = (cb.y + cb.height / 2) - arSize / 2;
            } else
            if(xMove > 0.0F && yMove == 0)
            {
                ar.x = cb.x + cb.width;
                ar.y = (cb.y + cb.height / 2) - arSize / 2;
            }
            
            if(xMove > 0.0f && yMove < 0.0f) {
            	ar.x = cb.x + cb.width;
            	ar.y = cb.y - arSize;
            }else if(xMove > 0.0f && yMove > 0.0f) {
            	ar.x = cb.x + cb.width;
            	ar.y = cb.y + cb.height;
            }
            
            if(xMove < 0.0f && yMove < 0.0f) {
            	ar.x = cb.x - cb.width;
            	ar.y = cb.y - arSize;
            }else if(xMove < 0.0f && yMove > 0.0f) {
            	ar.x = cb.x - cb.width;
            	ar.y = cb.y + cb.height;
            }
            
            if(world.id == 1) {
            	if(world.storage.getCurrentMousePress1().contains("left")) {
                    checkTiles();
                	if(world.getCurrentWorld() == 1) {
                    	for(Entity e : world.getEntityManager().getEntities())
                    	{
                    		if(e != this && e.getCollisionBounds(0.0F, 0.0F).intersects(ar))
                    		{
                    			int healthBefore = health;
                    			e.hurt(this.attackStrength);
                    			if(health != healthBefore)
                    				health = healthBefore;
                    			else
                    				return;
                    		}
                    	}
                    	for(Entity e : world.getEntityManager().getE1overflow1())
                    	{
                    		if(e != this && e.getCollisionBounds(0.0F, 0.0F).intersects(ar))
                    		{
                    			int healthBefore = health;
                    			e.hurt(this.attackStrength);
                    			if(health != healthBefore)
                    				health = healthBefore;
                    			else
                    				return;
                    		}
                    	}
                    	for(Entity e : world.getEntityManager().getE1overflow2())
                    	{
                    		if(e != this && e.getCollisionBounds(0.0F, 0.0F).intersects(ar))
                    		{
                    			int healthBefore = health;
                    			e.hurt(this.attackStrength);
                    			if(health != healthBefore)
                    				health = healthBefore;
                    			else
                    				return;
                    		}
                    	}
                    }else if(world.getCurrentWorld() == 2) {
                    	for(Entity e : world.getEntityManager().getEntities2())
                    	{
                    		if(e != this && e.getCollisionBounds(0.0F, 0.0F).intersects(ar))
                    		{
                    			int healthBefore = health;
                    			e.hurt(this.attackStrength);
                    			if(health != healthBefore)
                    				health = healthBefore;
                    			else
                    				return;
                    		}
                    	}
                    	for(Entity e : world.getEntityManager().getE2overflow1())
                    	{
                    		if(e != this && e.getCollisionBounds(0.0F, 0.0F).intersects(ar))
                    		{
                    			int healthBefore = health;
                    			e.hurt(this.attackStrength);
                    			if(health != healthBefore)
                    				health = healthBefore;
                    			else
                    				return;
                    		}
                    	}
                    	for(Entity e : world.getEntityManager().getE2overflow2())
                    	{
                    		if(e != this && e.getCollisionBounds(0.0F, 0.0F).intersects(ar))
                    		{
                    			int healthBefore = health;
                    			e.hurt(this.attackStrength);
                    			if(health != healthBefore)
                    				health = healthBefore;
                    			else
                    				return;
                    		}
                    	}
                    }else if(world.getCurrentWorld() == 3) {
                    	for(Entity e : world.getEntityManager().getEntities3())
                    	{
                    		if(e != this && e.getCollisionBounds(0.0F, 0.0F).intersects(ar))
                    		{
                    			int healthBefore = health;
                    			e.hurt(this.attackStrength);
                    			if(health != healthBefore)
                    				health = healthBefore;
                    			else
                    				return;
                    		}
                    	}
                    	for(Entity e : world.getEntityManager().getE3overflow1())
                    	{
                    		if(e != this && e.getCollisionBounds(0.0F, 0.0F).intersects(ar))
                    		{
                    			int healthBefore = health;
                    			e.hurt(this.attackStrength);
                    			if(health != healthBefore)
                    				health = healthBefore;
                    			else
                    				return;
                    		}
                    	}
                    	for(Entity e : world.getEntityManager().getE3overflow2())
                    	{
                    		if(e != this && e.getCollisionBounds(0.0F, 0.0F).intersects(ar))
                    		{
                    			int healthBefore = health;
                    			e.hurt(this.attackStrength);
                    			if(health != healthBefore)
                    				health = healthBefore;
                    			else
                    				return;
                    		}
                    	}
                    }
                }
            }else if(world.id == 2) {
            	if(world.storage.getCurrentMousePress2().contains("left")) {
                    checkTiles();
                	if(world.getCurrentWorld() == 1) {
                    	for(Entity e : world.getEntityManager().getEntities())
                    	{
                    		if(e != this && e.getCollisionBounds(0.0F, 0.0F).intersects(ar))
                    		{
                    			int healthBefore = health;
                    			e.hurt(this.attackStrength);
                    			if(health != healthBefore)
                    				health = healthBefore;
                    			else
                    				return;
                    		}
                    	}
                    	for(Entity e : world.getEntityManager().getE1overflow1())
                    	{
                    		if(e != this && e.getCollisionBounds(0.0F, 0.0F).intersects(ar))
                    		{
                    			int healthBefore = health;
                    			e.hurt(this.attackStrength);
                    			if(health != healthBefore)
                    				health = healthBefore;
                    			else
                    				return;
                    		}
                    	}
                    	for(Entity e : world.getEntityManager().getE1overflow2())
                    	{
                    		if(e != this && e.getCollisionBounds(0.0F, 0.0F).intersects(ar))
                    		{
                    			int healthBefore = health;
                    			e.hurt(this.attackStrength);
                    			if(health != healthBefore)
                    				health = healthBefore;
                    			else
                    				return;
                    		}
                    	}
                    }else if(world.getCurrentWorld() == 2) {
                    	for(Entity e : world.getEntityManager().getEntities2())
                    	{
                    		if(e != this && e.getCollisionBounds(0.0F, 0.0F).intersects(ar))
                    		{
                    			int healthBefore = health;
                    			e.hurt(this.attackStrength);
                    			if(health != healthBefore)
                    				health = healthBefore;
                    			else
                    				return;
                    		}
                    	}
                    	for(Entity e : world.getEntityManager().getE2overflow1())
                    	{
                    		if(e != this && e.getCollisionBounds(0.0F, 0.0F).intersects(ar))
                    		{
                    			int healthBefore = health;
                    			e.hurt(this.attackStrength);
                    			if(health != healthBefore)
                    				health = healthBefore;
                    			else
                    				return;
                    		}
                    	}
                    	for(Entity e : world.getEntityManager().getE2overflow2())
                    	{
                    		if(e != this && e.getCollisionBounds(0.0F, 0.0F).intersects(ar))
                    		{
                    			int healthBefore = health;
                    			e.hurt(this.attackStrength);
                    			if(health != healthBefore)
                    				health = healthBefore;
                    			else
                    				return;
                    		}
                    	}
                    }else if(world.getCurrentWorld() == 3) {
                    	for(Entity e : world.getEntityManager().getEntities3())
                    	{
                    		if(e != this && e.getCollisionBounds(0.0F, 0.0F).intersects(ar))
                    		{
                    			int healthBefore = health;
                    			e.hurt(this.attackStrength);
                    			if(health != healthBefore)
                    				health = healthBefore;
                    			else
                    				return;
                    		}
                    	}
                    	for(Entity e : world.getEntityManager().getE3overflow1())
                    	{
                    		if(e != this && e.getCollisionBounds(0.0F, 0.0F).intersects(ar))
                    		{
                    			int healthBefore = health;
                    			e.hurt(this.attackStrength);
                    			if(health != healthBefore)
                    				health = healthBefore;
                    			else
                    				return;
                    		}
                    	}
                    	for(Entity e : world.getEntityManager().getE3overflow2())
                    	{
                    		if(e != this && e.getCollisionBounds(0.0F, 0.0F).intersects(ar))
                    		{
                    			int healthBefore = health;
                    			e.hurt(this.attackStrength);
                    			if(health != healthBefore)
                    				health = healthBefore;
                    			else
                    				return;
                    		}
                    	}
                    }
                }
            }
            
    	}
    	if(playerId == 2) {
    		if(health <= 0)
                die();
    	}
    }

    private void checkTiles() {
    	if(xMove > 0.0F)
        {
            int tx = (int)(x + xMove + (float)bounds.x + (float)bounds.width) / 64;
            int ty = (int)(y + (float)bounds.y) / 64;
            int ty2 = (int)(y + (float)bounds.y + (float)bounds.height) / 64;
            if(collisionWithStructure(tx, ty) && collisionWithStructure(tx, ty2)) {
            	if(tile.getLocationX() == tx) {
        			if(tile.getLocationY() == ty || tile.getLocationY() == ty2) {
        				tile.hurt(attackStrength);

        			}
        		}
            }
        } else
        if(xMove < 0.0F)
        {
            int tx = (int)(x + xMove + (float)bounds.x) / 64;
            int ty = (int)(y + (float)bounds.y) / 64;
            int ty2 = (int)(y + (float)bounds.y + (float)bounds.height) / 64;
            if(collisionWithStructure(tx, ty) && collisionWithStructure(tx, ty2)) {
            	if(tile.getLocationX() == tx) {
        			if(tile.getLocationY() == ty || tile.getLocationY() == ty2) {
        				tile.hurt(attackStrength);
        			}
        		}
            }
        }
    	if(yMove < 0.0F)
        {
            int ty = (int)(y + yMove + (float)bounds.y) / 64;
            int tx = (int)(x + (float)bounds.x) / 64;
            int tx2 = (int)(x + (float)bounds.x + (float)bounds.width) / 64;
            if(collisionWithStructure(tx, ty) && collisionWithStructure(tx2, ty)) {
            	if(tile.getLocationX() == tx || tile.getLocationX() == tx2) {
        			if(tile.getLocationY() == ty) {
        				tile.hurt(attackStrength);
        			}
        		}
            }
        } else
        if(yMove > 0.0F)
        {
            int ty = (int)(y + yMove + (float)bounds.y + (float)bounds.height) / 64;
            int tx = (int)(x + (float)bounds.x) / 64;
            int tx2 = (int)(x + (float)bounds.x + (float)bounds.width) / 64;
            if(collisionWithStructure(tx, ty) && collisionWithStructure(tx2, ty)) {
            	if(tile.getLocationX() == tx || tile.getLocationX() == tx2) {
        			if(tile.getLocationY() == ty) {
        				tile.hurt(attackStrength);
        			}
        		}
            }
        }
    }
    
    public void hurtMe(int dmg, Creature c)
    {
        health -= dmg;
        if(health <= 0)
        {
            active = false;
            die();
        }
    }

    public void die()
    {
        hotbar.getInventoryItems().clear();
        if(grave == null)
        	grave = new Grave(inventory.getInventoryItems(), this, this.x, this.y);
    	inventory.clear();
//        for(Iterator<Item> iterator = inventory.getInventoryItems().iterator(); iterator.hasNext();)
//        {
//            Item i = (Item)iterator.next();
//            droppedItems.add(i);
//            if(inventory.getInventoryItems().size() == droppedItems.size())
//            {
//                inventory.dropItem(droppedItems);
//                State.setState(handler.getGame().deathState);
//                active = true;
//                health = maxHealth;
//                x = startX;
//                y = startY;
//                Item ii;
//                for(Iterator<Item> iterator1 = droppedItems.iterator(); iterator1.hasNext(); ii.setCount(0))
//                    ii = (Item)iterator1.next();
//
//                droppedItems.removeAll(droppedItems);
//                inventory.getInventoryItems().removeAll(inventory.getInventoryItems());
//                return;
//            }
//        }
        
//        for(Item item : inventory.getInventoryItems()) {
//        	inventory.dropItem(item, item.getCount());
//        }
        
        active = true;
        health = maxHealth;
        x = startX;
        y = startY;
    }

    public Inventory getInventory()
    {
        return inventory;
    }

	public Hotbar getHotbar() {
		return hotbar;
	}

	public int getTileX() {
		return tileX;
	}

	public int getTileY() {
		return tileY;
	}

	public float getStartX() {
		return startX;
	}

	public void setStartX(float startX) {
		this.startX = startX;
	}

	public float getStartY() {
		return startY;
	}

	public void setStartY(float startY) {
		this.startY = startY;
	}

	public LargeInventory getWeapons() {
		return weapons;
	}

	public int getKilledEnemies()
    {
        return killedEnemies;
    }

    public long getAttackCooldown2() {
		return attackCooldown2;
	}

	public void setAttackCooldown2(long attackCooldown2) {
		this.attackCooldown2 = attackCooldown2;
	}

	public ArrayList<Upgrade> getUpgrades() {
		return upgrades;
	}

	public void setKilledEnemies(int killedEnemy)
    {
        killedEnemies = killedEnemy;
    }

    public int getKilledBosses()
    {
        return killedBosses;
    }

    public void setKilledBosses(int killedBoss)
    {
        killedBosses = killedBoss;
    }

    public void setInventory(Inventory inventory)
    {
        this.inventory = inventory;
    }
    public void setMaxHealth(int h)
    {
        maxHealth = h;
    }

    public int getMaxHealth()
    {
        return maxHealth;
    }

	public String getDirectionMoving() {
		return directionMoving;
	}
	
	public void setPos(float x, float y) {
		this.x = x;
		this.y = y;
		this.startX = x;
		this.startY = y;
	}

	public int getCurrentDialougueF() {
		return currentDialougueFran;
	}

	public void setCurrentDialougueF(int currentDialougueF) {
		this.currentDialougueFran = currentDialougueF;
	}
	
	public int getCurrentDialougueS() {
		return currentDialougueSierra;
	}

	public void setCurrentDialougueS(int currentDialougueS) {
		this.currentDialougueSierra = currentDialougueS;
	}
	
	public int getCurrentDialougueC() {
		return currentDialougueChris;
	}

	public void setCurrentDialougueC(int currentDialougueC) {
		this.currentDialougueChris = currentDialougueC;
	}

}