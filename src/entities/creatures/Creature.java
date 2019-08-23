package entities.creatures;

import java.awt.Rectangle;
import java.util.Random;

import entities.Entity;
import tiles.structures.Structure;
import utils.Timer;
import worlds.World;

public abstract class Creature extends Entity
{

	public final float DEFAULT_SPEED = 5F;
    public static final int DEFAULT_CREATURE_WIDTH = 64;
    public static final int DEFAULT_CREATURE_HEIGHT = 64;
    public static final int DEFAULT_BOSS_WIDTH = 128;
    public static final int DEFAULT_BOSS_HEIGHT = 128;
    public static final int DEFAULT_ENTITY_ATTACK = 1;
    public static final int DEFAULT_BOSS_ATTACK = 2;

    protected float speed;
    protected float newSpeed = DEFAULT_SPEED;
    protected float xspeed;
    protected float yspeed;
    protected float xMove;
    protected float yMove;
    
    protected int attackStrength;
    protected int tileX;
    protected int tileY;
    
    protected Structure tile = null;
    protected Structure mainTile = null;
    
    protected Creature following;
    
    protected boolean isPassive = false;
	protected boolean isWandering = false;
	protected boolean isFollowing = false;
	protected boolean tileCollision = false;
	
	protected Rectangle cb;
	protected Rectangle ar;
	
	protected Timer movementTimer1;
	protected Timer movementTimer2;
	
	protected long movementCooldown = 1500L;
	protected long movementCooldown2 = 2000L;
    
	protected Random random = new Random();
	
	protected String side;
    
    public Creature(float x, float y, int width, int height, int health, int id, World world)
    {
        super(x, y, width, height, health, id, world);
        speed = DEFAULT_SPEED;
        xMove = 0.0F;
        yMove = 0.0F;
    }
    
    public void follow(int arSize, float distance) {
    	side = checkEntityLocation(following, distance);
        if(side == "bottom")
        {
            yMove = speed;
            if(!isPassive) {
            	ar.x = (cb.x + cb.width / 2) - arSize / 2;
            	ar.y = cb.y + cb.height;
            }
        } else
        if(side == "top")
        {
            yMove = -speed;
            if(!isPassive) {
                ar.x = (cb.x + cb.width / 2) - arSize / 2;
                ar.y = cb.y - arSize;
            }
        } else
        if(side == "left")
        {
            xMove = -speed;
            if(!isPassive) {
                ar.x = cb.x - arSize;
                ar.y = (cb.y + cb.height / 2) - arSize / 2;
            }
        } else
        if(side == "right")
        {
            xMove = speed;
            if(!isPassive) {
                ar.x = cb.x + cb.width;
                ar.y = (cb.y + cb.height / 2) - arSize / 2;
            }
        } else
        if(side == "top left")
        {
            xMove = -speed;
            yMove = -speed;
        } else
        if(side == "bottom left")
        {
            xMove = -speed;
            yMove = speed;
        } else
        if(side == "top right")
        {
            xMove = speed;
            yMove = -speed;
        } else
        if(side == "bottom right")
        {
            xMove = speed;
            yMove = speed;
        } else
        {
            xMove = 0.0F;
            yMove = 0.0F;
        }
    }
    
    public void wander() {
    	if(movementTimer1 == null)
    		movementTimer1 = new Timer(movementCooldown, 1);
    	movementTimer1.tick();
    	if(!movementTimer1.isCompleted()) {
    		return;
    	}else if(movementTimer1.isCompleted()) {
    		movementTimer1 = null;
    	}
        
        xMove = 0;
        yMove = 0;
        int randomNum = random.nextInt(5);
        if(randomNum == 0) {
            randomNum = random.nextInt(4);
        	if(randomNum == 0) {
        		xMove = -speed;
        		yMove = -speed;
        	}else if(randomNum == 1) {
        		xMove = speed;
        		yMove = -speed;
        	}else if(randomNum == 2 || randomNum == 3) {
        		xMove = 0;
        		yMove = -speed;
        	}
        }else if(randomNum == 1) {
            randomNum = random.nextInt(4);
            if(randomNum == 0) {
        		xMove = -speed;
        		yMove = speed;
        	}else if(randomNum == 1) {
        		xMove = speed;
        		yMove = speed;
        	}else if(randomNum == 2 || randomNum == 3) {
        		xMove = 0;
        		yMove = speed;
        	}
        }else if(randomNum == 2) {
            randomNum = random.nextInt(4);
            if(randomNum == 0) {
        		xMove = -speed;
        		yMove = -speed;
        	}else if(randomNum == 1) {
        		xMove = -speed;
        		yMove = speed;
        	}else if(randomNum == 2 || randomNum == 3) {
        		xMove = -speed;
        		yMove = 0;
        	}
        }else if(randomNum == 3) {
            randomNum = random.nextInt(4);
            if(randomNum == 0) {
        		xMove = speed;
        		yMove = -speed;
        	}else if(randomNum == 1) {
        		xMove = speed;
        		yMove = speed;
        	}else if(randomNum == 2 || randomNum == 3) {
        		xMove = speed;
        		yMove = 0;
        	}
        }else if(randomNum == 4) {
        	xMove = 0;
        	yMove = 0;
        }
        
        if(xMove == 0 && yMove == 0) {
    		return;
    	}
    	if(movementTimer2 == null)
    		movementTimer2 = new Timer(movementCooldown2, 1);
    	movementTimer2.tick();
    	if(!movementTimer2.isCompleted()) {
    		return;
    	}else if(movementTimer2.isCompleted()) {
    		movementTimer2 = null;
    	}
    	
    	xMove = 0;
    	yMove = 0;
    	
    }
    
    public void move()
    {
    	if(world.getEntityManager().getPlayer().getInventory().isActive())
    		return;
        if(!checkEntityCollisions(xMove, 0.0F)) {
            moveX();
        }else if(isPassive){
        	xMove = -xMove;
        	yMove = -yMove;
        }
        if(!checkEntityCollisions(0.0F, yMove)) {
            moveY();
        }else if(isPassive){
        	xMove = -xMove;
        	yMove = -yMove;
        }
    }

    public void moveX()
    {
        if(xMove > 0.0F)
        {
            int tx = (int)(x + xMove + (float)bounds.x + (float)bounds.width) / 64;
            if(!collisionWithTile(tx, (int)(y + (float)bounds.y) / 64) && !collisionWithTile(tx, (int)(y + (float)bounds.y + (float)bounds.height) / 64) && 
            		!collisionWithStructure(tx, (int)(y + (float)bounds.y) / 64) && !collisionWithStructure(tx, (int)(y + (float)bounds.y + (float)bounds.height) / 64))
                x += xMove;
            else {
            	if(isPassive) {
            		xMove = -xMove;
            		yMove = -yMove;
            	}
                x = tx * 64 - bounds.x - bounds.width - 1;
            }
        } else
        if(xMove < 0.0F)
        {
            int tx = (int)(x + xMove + (float)bounds.x) / 64;
            if(!collisionWithTile(tx, (int)(y + (float)bounds.y) / 64) && !collisionWithTile(tx, (int)(y + (float)bounds.y + (float)bounds.height) / 64) && 
            		!collisionWithStructure(tx, (int)(y + (float)bounds.y) / 64) && !collisionWithStructure(tx, (int)(y + (float)bounds.y + (float)bounds.height) / 64))
                x += xMove;
            else {
            	if(isPassive) {
            		xMove = -xMove;
            		yMove = -yMove;
            	}
                x = (tx * 64 + 64) - bounds.x;
            }
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
            else {
            	if(isPassive) {
            		xMove = -xMove;
            		yMove = -yMove;
            	}
                y = (ty * 64 + 64) - bounds.y;
            }
        } else
        if(yMove > 0.0F)
        {
            int ty = (int)(y + yMove + (float)bounds.y + (float)bounds.height) / 64;
            if(!collisionWithTile((int)(x + (float)bounds.x) / 64, ty) && !collisionWithTile((int)(x + (float)bounds.x + (float)bounds.width) / 64, ty) && 
            		!collisionWithStructure((int)(x + (float)bounds.x) / 64, ty) && !collisionWithStructure((int)(x + (float)bounds.x + (float)bounds.width) / 64, ty))
                y += yMove;
            else {
            	if(isPassive) {
            		xMove = -xMove;
            		yMove = -yMove;
            	}
                y = ty * 64 - bounds.y - bounds.height - 1;
            }
        }
    }

    protected boolean collisionWithTile(int x, int y)
    {
    	this.tileCollision = world.getTile(x, y).isSolid();
        return world.getTile(x, y).isSolid();
    }
    
    protected boolean collisionWithStructure(int x, int y)
    {
    	boolean toReturn = false;
    	for(Structure s : Structure.getStructures()) {
    		if(s.getLocationX() == x) {
    			if(s.getLocationY() == y) {
    				mainTile = s;
    			}
    		}
    	}
    	if(mainTile != null) {
            toReturn = mainTile.isSolid();
        	tile = mainTile;
    	}
    	mainTile = null;
    	return toReturn;
    }

    protected void checkCurrentTile() {
    	int tX = (int) Math.floor(this.x/64);
    	int tY = (int) Math.floor(this.y/64);
    	tileX = tX;
    	tileY = tY;
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

    public void setSpeed(float speed)
    {
        this.speed = speed;
    }

    public String checkEntityLocation(Creature c, float distance)
    {
        if(c.getX() >= x && c.getX() <= x + (float)bounds.width)
        {
            if(c.getY() >= y && c.getY() <= y + (float)bounds.height + distance)
                return "bottom";
            if(c.getY() <= y && c.getY() >= y - distance)
                return "top";
        } else
        {
            yMove = 0.0F;
        }
        if(c.getY() >= y && c.getY() <= y + (float)bounds.height)
        {
            if(c.getX() <= x && c.getX() >= x - distance)
                return "left";
            if(c.getX() >= x + (float)bounds.width && c.getX() <= x + (float)bounds.width + distance)
                return "right";
        } else
        {
            xMove = 0.0F;
        }
        if(c.getX() >= x - distance && c.getX() <= x)
        {
            if(c.getY() >= y - distance && c.getY() <= y)
                return "top left";
            if(c.getY() <= y + (float)bounds.height + distance && c.getY() >= y + (float)bounds.height)
                return "bottom left";
        } else
        if(c.getX() <= x + (float)bounds.width + distance && c.getX() >= x + (float)bounds.width)
        {
            if(c.getY() >= y - distance && c.getY() <= y)
                return "top right";
            if(c.getY() <= y + (float)bounds.height + distance && c.getY() >= y + (float)bounds.height)
                return "bottom right";
        } else
        {
            yMove = 0.0F;
            xMove = 0.0F;
        }
        return null;
    }
    
}
