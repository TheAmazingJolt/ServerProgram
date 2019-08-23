package entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import worlds.World;

public abstract class Entity
{
	
	public static final int DEFAULT_HEALTH = 10;
    protected float x;
    protected float y;
    protected int width;
    protected int height;
    protected int health;
    protected int maxHealth;
    protected int startHealth;
    protected float startX;
    protected float startY;
    protected boolean active;
    protected boolean attacked;
    protected boolean ammo;
    protected Rectangle bounds;
    protected int id;
    protected boolean isNpc = false;
    protected World world;

    public Entity(float x, float y, int width, int height, int health, int id, World world)
    {
        active = true;
        attacked = false;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.health = health;
        maxHealth = health;
        this.startHealth = health;
        this.startX = x;
        this.startY = y;
        this.id = id;
        this.world = world;
        bounds = new Rectangle(0, 0, width, height);
    }

    public abstract void tick();

    public abstract void die();

    public void revive()
    {
        attacked = false;
        active = true;
        health = startHealth;
        x = startX;
        y = startY;
    }

    public void suicide() {
    	this.active = false;
    }
    
    public void setStartData() {
    	this.health = startHealth;
    	this.x = startX;
    	this.y = startY;
    }
    
    public void hurt(int amt)
    {
        this.attacked = true;
        health -= amt;
        if(health <= 0)
        {
            active = false;
            die();
        }
    }

    public boolean checkEntityCollisions(float xOffset, float yOffset)
    {
    	if(world.getCurrentWorld() == 1) {
    		for(Entity e : world.getEntityManager().getEntities())
            {
    			if(world.getEntityManager().getPlayer2() != null && e.equals(world.getEntityManager().getPlayer2()))
    				return false;
                if(!e.equals(this) && e.getCollisionBounds(0.0F, 0.0F).intersects(getCollisionBounds(xOffset, yOffset)))
                    return true;
            }
    		for(Entity e : world.getEntityManager().getE1overflow1())
            {
    			if(world.getEntityManager().getPlayer2() != null && e.equals(world.getEntityManager().getPlayer2()))
    				return false;
                if(!e.equals(this) && e.getCollisionBounds(0.0F, 0.0F).intersects(getCollisionBounds(xOffset, yOffset)))
                    return true;
            }
    		for(Entity e : world.getEntityManager().getE1overflow2())
            {
    			if(world.getEntityManager().getPlayer2() != null && e.equals(world.getEntityManager().getPlayer2()))
    				return false;
                if(!e.equals(this) && e.getCollisionBounds(0.0F, 0.0F).intersects(getCollisionBounds(xOffset, yOffset)))
                    return true;
            }
    	}else if(world.getCurrentWorld() == 2) {
    		for(Entity e : world.getEntityManager().getEntities2())
            {
    			if(world.getEntityManager().getPlayer2() != null && e.equals(world.getEntityManager().getPlayer2()))
    				return false;
                if(!e.equals(this) && e.getCollisionBounds(0.0F, 0.0F).intersects(getCollisionBounds(xOffset, yOffset)))
                    return true;
            }
    		for(Entity e : world.getEntityManager().getE2overflow1())
            {
    			if(world.getEntityManager().getPlayer2() != null && e.equals(world.getEntityManager().getPlayer2()))
    				return false;
                if(!e.equals(this) && e.getCollisionBounds(0.0F, 0.0F).intersects(getCollisionBounds(xOffset, yOffset)))
                    return true;
            }
    		for(Entity e : world.getEntityManager().getE2overflow2())
            {
    			if(world.getEntityManager().getPlayer2() != null && e.equals(world.getEntityManager().getPlayer2()))
    				return false;
                if(!e.equals(this) && e.getCollisionBounds(0.0F, 0.0F).intersects(getCollisionBounds(xOffset, yOffset)))
                    return true;
            }
    	}else if(world.getCurrentWorld() == 3) {
    		for(Entity e : world.getEntityManager().getEntities3())
            {
    			if(world.getEntityManager().getPlayer2() != null && e.equals(world.getEntityManager().getPlayer2()))
    				return false;
                if(!e.equals(this) && e.getCollisionBounds(0.0F, 0.0F).intersects(getCollisionBounds(xOffset, yOffset)))
                    return true;
            }
    		for(Entity e : world.getEntityManager().getE3overflow1())
            {
    			if(world.getEntityManager().getPlayer2() != null && e.equals(world.getEntityManager().getPlayer2()))
    				return false;
                if(!e.equals(this) && e.getCollisionBounds(0.0F, 0.0F).intersects(getCollisionBounds(xOffset, yOffset)))
                    return true;
            }
    		for(Entity e : world.getEntityManager().getE3overflow2())
            {
    			if(world.getEntityManager().getPlayer2() != null && e.equals(world.getEntityManager().getPlayer2()))
    				return false;
                if(!e.equals(this) && e.getCollisionBounds(0.0F, 0.0F).intersects(getCollisionBounds(xOffset, yOffset)))
                    return true;
            }
    	}
        return false;
    }

    public Rectangle getCollisionBounds(float xOffset, float yOffset)
    {
        return new Rectangle((int)(x + (float)bounds.x + xOffset), (int)(y + (float)bounds.y + yOffset), bounds.width, bounds.height);
    }

    public float getX()
    {
        return x;
    }

    public int getMaxHealth()
    {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth)
    {
        this.maxHealth = maxHealth;
    }

    public void setX(float x)
    {
        this.x = x;
    }

    public float getY()
    {
        return y;
    }

    public void setY(float y)
    {
        this.y = y;
    }

    public int getId() {
		return id;
	}

	public boolean isAmmo() {
		return ammo;
	}

	public void setAmmo(boolean ammo) {
		this.ammo = ammo;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getWidth()
    {
        return width;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public int getHealth()
    {
        return health;
    }

    public void setHealth(int health)
    {
        this.health = health;
    }

    public boolean isActive()
    {
        return active;
    }

    public void setActive(boolean active)
    {
        this.active = active;
    }

    public boolean isAttacked()
    {
        return attacked;
    }

    
}
