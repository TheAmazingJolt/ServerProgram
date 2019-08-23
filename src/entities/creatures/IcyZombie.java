package entities.creatures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

import items.Item;
import tiles.Tile;
import utils.Timer;
import worlds.World;

public class IcyZombie extends Creature
{
    
    private static int maxHealth = 40;
    private static int startHealth;
    
    private long attackCooldown;
    
    private Player player;
    private Random random = new Random();
    
    private Timer timer;
	
    public IcyZombie(float x, float y, int id, Player player, World world)
    {
        super(x, y, 64, 64, maxHealth, id, world);
        this.id = id;
        this.player = player;
        startX = x;
        startY = y;
        attackCooldown = 200L;
        this.health = maxHealth;
        startHealth = this.health;
        bounds.x = 22;
        bounds.y = 30;
        bounds.width = 20;
        bounds.height = 34;
        this.isFollowing = true;
        this.following = world.getEntityManager().getPlayer();
        this.newSpeed = player.getSpeed() - (player.getSpeed() / 10);
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
        checkAttacks();
        move();
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
        	world.getEntityManager().getPlayer().hurt(5);
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
    	world.getItemManager().addItem(Item.rottenFleshItem.createNew((int)x, (int)y, false, false, false));
    	world.getItemManager().addItem(Item.rottenFleshItem.createNew((int)x, (int)y, false, false, false));
        if(random.nextInt(25) == 1) {
        	player.getInventory().addItem(Item.speedUpgrade, 1); 
        }
        player.setKilledEnemies(player.getKilledEnemies() + 1);
    }

}