package entities.projectiles;

import entities.Entity;
import tiles.structures.Structure;
import worlds.World;

public abstract class Projectile extends Entity
{

	public static final float DEFAULT_SPEED = 6F;
    public static final int DEFAUL_WIDTH = 32;
    public static final int DEFAULT_HEIGHT = 32;
    public final int DEFAULT_ATTACK = 5;
    protected float speed;
    protected float xMove;
    protected float yMove;
    
    protected int attack;
    protected int ammoId;
	
    public Projectile(float x, float y, int width, int height, int id, World world)
    {
        super(x, y, width, height, 1, id, world);
        this.ammoId = id;
        speed = 6F;
        xMove = 0.0F;
        yMove = 0.0F;
    }

    public void move()
    {
        if(!checkEntityCollisions(xMove, 0.0F))
            moveX();
        if(!checkEntityCollisions(0.0F, yMove))
            moveY();
        
    }

    public void moveX()
    {
        if(xMove > 0.0F)
        {
            int tx = (int)(x + xMove + (float)bounds.x + (float)bounds.width) / 64;
            if(!collisionWithTile(tx, (int)(y + (float)bounds.y) / 64) && !collisionWithTile(tx, (int)(y + (float)bounds.y + (float)bounds.height) / 64) && 
            		!collisionWithStructure(tx, (int)(y + (float)bounds.y) / 64) && !collisionWithStructure(tx, (int)(y + (float)bounds.y + (float)bounds.height) / 64))
                x += xMove;
            else
                x = tx * 64 - bounds.x - bounds.width - 1;
        } else
        if(xMove < 0.0F)
        {
            int tx = (int)(x + xMove + (float)bounds.x) / 64;
            if(!collisionWithTile(tx, (int)(y + (float)bounds.y) / 64) && !collisionWithTile(tx, (int)(y + (float)bounds.y + (float)bounds.height) / 64) && 
            		!collisionWithStructure(tx, (int)(y + (float)bounds.y) / 64) && !collisionWithStructure(tx, (int)(y + (float)bounds.y + (float)bounds.height) / 64))
                x += xMove;
            else
                x = (tx * 64 + 64) - bounds.x;
        }
    }

    public void moveY()
    {
        if(yMove < 0.0F)
        {
            int ty = (int)(y + yMove + (float)bounds.y) / 64;
            if(!collisionWithTile((int)(x + (float)bounds.x) / 64, ty) && !collisionWithTile((int)(x + (float)bounds.x + (float)bounds.width) / 64, ty) && 
            		!collisionWithStructure((int)(x + (float)bounds.x) / 64, ty) && !collisionWithStructure((int)(x + (float)bounds.x + (float)bounds.width) / 64, ty))
                y += yMove;
            else
                y = (ty * 64 + 64) - bounds.y;
        } else
        if(yMove > 0.0F)
        {
            int ty = (int)(y + yMove + (float)bounds.y + (float)bounds.height) / 64;
            if(!collisionWithTile((int)(x + (float)bounds.x) / 64, ty) && !collisionWithTile((int)(x + (float)bounds.x + (float)bounds.width) / 64, ty) && 
            		!collisionWithStructure((int)(x + (float)bounds.x) / 64, ty) && !collisionWithStructure((int)(x + (float)bounds.x + (float)bounds.width) / 64, ty))
                y += yMove;
            else
                y = ty * 64 - bounds.y - bounds.height - 1;
        }
    }

    protected boolean collisionWithTile(int x, int y)
    {
    	if(world.getTile(x, y).isSolid()) {
    		this.die();
    	}
        return world.getTile(x, y).isSolid();
    }
    
    protected boolean collisionWithStructure(int x, int y)
    {
    	Structure t = null;
    	for(Structure s : Structure.getStructures()) {
    		if(s.getLocationX() == x) {
    			if(s.getLocationY() == y) {
    				t = s;
    			}
    		}
    	}
    	if(t != null) {
    		this.die();
    		t.hurt(DEFAULT_ATTACK);
            return t.isSolid();
    	}
    	return false;
    }

    public float getxMove()
    {
        return xMove;
    }

    public void setxMove(float xMove)
    {
        this.xMove = xMove;
    }

    public float getyMove()
    {
        return yMove;
    }

    public void setyMove(float yMove)
    {
        this.yMove = yMove;
    }

    public int getHealth()
    {
        return health;
    }

    public void setHealth(int health)
    {
        this.health = health;
    }

    public float getSpeed()
    {
        return speed;
    }

    public int getAmmoId() {
		return ammoId;
	}

	public void setSpeed(float speed)
    {
        this.speed = speed;
    }

    
}
