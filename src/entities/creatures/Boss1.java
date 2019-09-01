package entities.creatures;

import java.awt.Rectangle;

import items.Item;
import utils.Timer;
import worlds.World;

public class Boss1 extends Creature
{

    private static int maxHealth = 20;
    private static int startHealth;
    private long attackCooldown;
    
    private Timer timer;
	
    public Boss1(float x, float y, int health, int id, World world)
    {
        super(x, y, 128, 128, maxHealth, id, world);
        this.id = id;
        attackCooldown = 350L;
        startHealth = health;
        this.health = health;
        bounds.x = 30;
        bounds.y = 30;
        bounds.width = 70;
        bounds.height = 74;
        this.speed = world.getEntityManager().getPlayer().getSpeed() - (world.getEntityManager().getPlayer().getSpeed() / 10);
        this.following = world.getEntityManager().getPlayer();
        this.isFollowing = true;
    }

    public void tick()
    {
        if(!active)
        {
            bounds.width = 0;
            bounds.height = 0;
            return;
        }
        if(world.getEntityManager().getPlayer().getKilledBosses() > 0)
            suicide();
        if(health != startHealth && health >= startHealth)
            health = maxHealth;
        move();
        checkAttacks();
    }

    private void checkAttacks()
    {
    	if(timer == null)
    		timer = new Timer(attackCooldown, 1);
    	timer.tick();
    	if(!timer.isCompleted()) {
    		return;
    	}else if(timer.isCompleted()) {
    		timer = null;
    	}
        cb = getCollisionBounds(0.0F, 0.0F);
        ar = new Rectangle();
        int arSize = 20;
        ar.width = arSize;
        ar.height = arSize;
        if(this.isFollowing) {
        	follow(arSize, 150F);
        }else if(this.isWandering) {
        	wander();
        }
        if(world.getEntityManager().getPlayer().getCollisionBounds(0.0F, 0.0F).intersects(ar))
        	world.getEntityManager().getPlayer().hurt(3);
    }

    public void hurt(int amt)
    {
        health -= amt;
        if(health <= 0)
        {
            active = false;
            die();
        }
    }

    public void die()
    {
        for(int i = 0; i < 10; i++)
        	world.getItemManager().addItem(Item.rottenFleshItem.createNew((int)x, (int)y, false, false, false));
        world.getItemManager().addItem(Item.ironBarItem.createNew((int)x, (int) y, false, false, false));
        world.getEntityManager().getPlayer().setKilledBosses(1);
    }

    public void suicide()
    {
        health = 0;
        active = false;
    }

}