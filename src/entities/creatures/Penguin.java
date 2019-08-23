package entities.creatures;

import items.Item;
import worlds.World;

public class Penguin extends Creature
{
    
    private static int maxHealth = 20;
    private static int startHealth;
	
    public Penguin(float x, float y, int id, World world)
    {
        super(x, y, 64, 64, maxHealth, id, world);
        this.id = id;
        startX = x;
        startY = y;
        this.health = maxHealth;
        startHealth = this.health;
        bounds.x = 20;
        bounds.y = 30;
        bounds.width = 20;
        bounds.height = 20;
        this.isPassive = true;
        this.isWandering = true;
        this.speed = 2f;
    }

    public void tick()
    {
        if(!active)
        {
            bounds.width = 0;
            bounds.height = 0;
            return;
        }
        if(health != startHealth && health >= startHealth)
            health = maxHealth;
        if(this.isFollowing) {
        	follow(0, 100F);
        }else if(this.isWandering) {
        	wander();
        }
        move();
    }
    
    public void hurt(int amt)
    {
    	attacked = true;
        health -= amt;
        if(health <= 0)
        {
            active = false;
            die();
        }
    }

    public void die()
    {
    	world.getItemManager().addItem(Item.snow.createNew((int) x, (int) y, false, false, false));
    }

}