package entities.projectiles;

import java.awt.Rectangle;

import entities.Entity;
import entities.creatures.Player;
import worlds.World;

public class SmgBullet extends Projectile
{
    
    private long attackCooldown;
    
    private Player player;
	
    public SmgBullet(float x, float y, Player player, World world)
    {
        super(x, y, 32, 32, 1, world);
        this.player = player;
        startX = x;
        startY = y;
        attackCooldown = 200;
        attack = 3;
        this.health = maxHealth;
        startHealth = maxHealth;
        bounds.x = 11;
        bounds.y = 15;
        bounds.width = 10;
        bounds.height = 17;
        this.active = false;
        this.ammo = true;
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
        move();
        checkAttacks();
    }

    public void fire(String direction) {
    	active = true;
    	if(direction.contains("right")) {
    		this.x = player.getX() + 75;
    		this.y = player.getY() + player.getHeight()/4;
    		xMove = speed;
    	}else if(direction.contains("left")) {
    		this.x = player.getX() - 75;
    		this.y = player.getY() + player.getHeight()/4;
    		xMove = -speed;
    	}else if(direction.contains("up")) {
    		this.y = player.getY() - 75;
    		this.x = player.getX() + player.getWidth()/4;
    		yMove = -speed;
    	}else if(direction.contains("down")) {
    		this.y = player.getY() + 75;
    		this.x = player.getX() + player.getWidth()/4;
    		yMove = speed;
    	}
    }
    
    private void checkAttacks()
    {
        Rectangle cb = getCollisionBounds(0.0F, 0.0F);
        Rectangle ar = new Rectangle();
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
        if(world.getCurrentWorld() == 1) {
        	for(Entity e : world.getEntityManager().getEntities())
        	{
        		if(e != this && e.getCollisionBounds(0.0F, 0.0F).intersects(ar) && e != player && !e.isAmmo())
        		{
        			int healthBefore = health;
        			e.hurt(this.attack);
        			if(health != healthBefore)
        				health = healthBefore;
        			else {
        				die();
        			}
        		}
        	}
        	for(Entity e : world.getEntityManager().getE1overflow1())
        	{
        		if(e != this && e.getCollisionBounds(0.0F, 0.0F).intersects(ar) && e != player && !e.isAmmo())
        		{
        			int healthBefore = health;
        			e.hurt(this.attack);
        			if(health != healthBefore)
        				health = healthBefore;
        			else {
        				die();
        			}
        		}
        	}for(Entity e : world.getEntityManager().getE1overflow2())
        	{
        		if(e != this && e.getCollisionBounds(0.0F, 0.0F).intersects(ar) && e != player && !e.isAmmo())
        		{
        			int healthBefore = health;
        			e.hurt(this.attack);
        			if(health != healthBefore)
        				health = healthBefore;
        			else {
        				die();
        			}
        		}
        	}
        }else if(world.getCurrentWorld() == 2) {
        	for(Entity e : world.getEntityManager().getEntities2())
        	{
        		if(e != this && e.getCollisionBounds(0.0F, 0.0F).intersects(ar) && e != player && !e.isAmmo())
        		{
        			int healthBefore = health;
        			e.hurt(this.attack);
        			if(health != healthBefore)
        				health = healthBefore;
        			else {
        				die();
        			}
        		}
        	}
        	for(Entity e : world.getEntityManager().getE2overflow1())
        	{
        		if(e != this && e.getCollisionBounds(0.0F, 0.0F).intersects(ar) && e != player && !e.isAmmo())
        		{
        			int healthBefore = health;
        			e.hurt(this.attack);
        			if(health != healthBefore)
        				health = healthBefore;
        			else {
        				die();
        			}
        		}
        	}for(Entity e : world.getEntityManager().getE2overflow2())
        	{
        		if(e != this && e.getCollisionBounds(0.0F, 0.0F).intersects(ar) && e != player && !e.isAmmo())
        		{
        			int healthBefore = health;
        			e.hurt(this.attack);
        			if(health != healthBefore)
        				health = healthBefore;
        			else {
        				die();
        			}
        		}
        	}
        }else if(world.getCurrentWorld() == 3) {
        	for(Entity e : world.getEntityManager().getEntities3())
        	{
        		if(e != this && e.getCollisionBounds(0.0F, 0.0F).intersects(ar) && e != player && !e.isAmmo())
        		{
        			int healthBefore = health;
        			e.hurt(this.attack);
        			if(health != healthBefore)
        				health = healthBefore;
        			else {
        				die();
        			}
        		}
        	}
        	for(Entity e : world.getEntityManager().getE3overflow1())
        	{
        		if(e != this && e.getCollisionBounds(0.0F, 0.0F).intersects(ar) && e != player && !e.isAmmo())
        		{
        			int healthBefore = health;
        			e.hurt(this.attack);
        			if(health != healthBefore)
        				health = healthBefore;
        			else {
        				die();
        			}
        		}
        	}for(Entity e : world.getEntityManager().getE3overflow2())
        	{
        		if(e != this && e.getCollisionBounds(0.0F, 0.0F).intersects(ar) && e != player && !e.isAmmo())
        		{
        			int healthBefore = health;
        			e.hurt(this.attack);
        			if(health != healthBefore)
        				health = healthBefore;
        			else {
        				die();
        			}
        		}
        	}
        }
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
    	xMove = 0;
    	yMove = 0;
    	active = false;
    	world.getEntityManager().remove(this);
    }

	public long getAttackCooldown() {
		return attackCooldown;
	}
    
    
}