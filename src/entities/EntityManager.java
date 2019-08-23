package entities;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;

import entities.creatures.Player;
import worlds.World;

public class EntityManager {

	private Player player;
	private Player player2;
	
	private ArrayList<Entity> entities1;
	private ArrayList<Entity> e1overflow1;
	private ArrayList<Entity> e1overflow2;

	private ArrayList<Entity> entities2;
	private ArrayList<Entity> e2overflow1;
	private ArrayList<Entity> e2overflow2;

	private ArrayList<Entity> entities3;
	private ArrayList<Entity> e3overflow1;
	private ArrayList<Entity> e3overflow2;
	
	private ArrayList<Entity> toAdd;
	private ArrayList<Entity> toRemove;
	
	private World world;
	
	private boolean positionDetermined = false;
	private int currentSorting = 0;
	private Comparator<Entity> renderSorter = new Comparator<Entity>() {
		public int compare(Entity a, Entity b) {
			if(a.getY() + a.getHeight() < b.getY() + b.getHeight()) {
				return -1;//a is rendered after b
			}
			return 1;//a is rendered before b
		}
	};
	
	public EntityManager(Player player) {
		this.player = player;
		player2 = new Player(3164, 3164, 2, -2, world);
		entities1 = new ArrayList<Entity>();
		e1overflow1 = new ArrayList<Entity>();
		e1overflow2 = new ArrayList<Entity>();
		entities2 = new ArrayList<Entity>();
		e2overflow1 = new ArrayList<Entity>();
		e2overflow2 = new ArrayList<Entity>();
		entities3 = new ArrayList<Entity>();
		e3overflow1 = new ArrayList<Entity>();
		e3overflow2 = new ArrayList<Entity>();
		toAdd = new ArrayList<Entity>();
		toRemove = new ArrayList<Entity>();
		addEntity1(player);
		addEntity2(player);
		addEntity3(player);
		addEntity1(player2);
	}
	
	public void tick()
    {
		player.setHealth(player.getMaxHealth());
		player2.setHealth(player2.getMaxHealth());
		if(world.getCurrentWorld() == 1) {
	        for(Entity e : entities1) {
	            e.tick();
	        }
	        for(Entity e : e1overflow1) {
	            if(e == player) {
	            	continue;
	            }
	            e.tick();
	        }
	        for(Entity e : e1overflow2) {
	            if(e == player) {
	            	continue;
	            }
	            e.tick();
	        }
	        entities1.sort(renderSorter);
	        e1overflow1.sort(renderSorter);
	        e1overflow2.sort(renderSorter);
	        entities1.addAll(toAdd);
	        toAdd.clear();
	        entities1.removeAll(toRemove);
	        toRemove.clear();
		}
		if(world.getCurrentWorld() == 2) {
			for(Entity e : entities2) {
	            e.tick();
	        }
	        for(Entity e : e2overflow1) {
	            if(e == player) {
	            	continue;
	            }
	            e.tick();
	        }
	        for(Entity e : e2overflow2) {
	            if(e == player) {
	            	continue;
	            }
	            e.tick();
	        }
	        entities2.sort(renderSorter);
	        e2overflow1.sort(renderSorter);
	        e2overflow2.sort(renderSorter);
	        entities2.addAll(toAdd);
	        toAdd.clear();
	        entities2.removeAll(toRemove);
	        toRemove.clear();
		}
		if(world.getCurrentWorld() == 3) {
			for(Entity e : entities3) {
	            e.tick();
	        }
	        for(Entity e : e3overflow1) {
	            if(e == player) {
	            	continue;
	            }
	            e.tick();
	        }
	        for(Entity e : e3overflow2) {
	            if(e == player) {
	            	continue;
	            }
	            e.tick();
	        }
	        entities3.sort(renderSorter);
	        e3overflow1.sort(renderSorter);
	        e3overflow2.sort(renderSorter);
	        entities3.addAll(toAdd);
	        toAdd.clear();
	        entities3.removeAll(toRemove);
	        toRemove.clear();
		}
    }
    
    public void addToOverflow() {
    	e1overflow1.add(player);
    	e1overflow2.add(player);
    	e2overflow1.add(player);
    	e2overflow2.add(player);
    	e3overflow1.add(player);
    	e3overflow2.add(player);
    }
    
    public ArrayList<Entity> getE1overflow1() {
		return e1overflow1;
	}

	public ArrayList<Entity> getE1overflow2() {
		return e1overflow2;
	}
	
	public ArrayList<Entity> getE2overflow1() {
		return e2overflow1;
	}

	public ArrayList<Entity> getE2overflow2() {
		return e2overflow2;
	}
	
	public ArrayList<Entity> getE3overflow1() {
		return e3overflow1;
	}

	public ArrayList<Entity> getE3overflow2() {
		return e3overflow2;
	}

	public void addEntity1(Entity e)
    {
    	if(entities1.size() >= 67) {
    		if(e1overflow1.size() >= 67) {
    			e1overflow2.add(e);
    			return;
    		}
    		e1overflow1.add(e);
    		return;
    	}
        entities1.add(e);
    }
	
    public void addEntity2(Entity e)
    {
    	if(entities2.size() >= 67) {
    		if(e2overflow1.size() >= 67) {
    			e2overflow2.add(e);
    			return;
    		}
    		e2overflow1.add(e);
    		return;
    	}
        entities2.add(e);
    }
    
    public void addEntity3(Entity e)
    {
	    if(entities3.size() >= 67) {
	   		if(e3overflow1.size() >= 67) {
	   			e3overflow2.add(e);
	   			return;
	   		}
	   		e3overflow1.add(e);
	    	return;
	    }
	    entities3.add(e);
    }
    
    public void add(Entity e)
    {
        toAdd.add(e);
    }
    
    public void remove(Entity e)
    {
        toRemove.add(e);
    }

    public Player getPlayer()
    {
        return player;
    }

    public void setPlayer(Player player)
    {
        this.player = player;
    }
    
    public Player getPlayer2()
    {
        return player2;
    }

    public void setPlayer2(Player player2)
    {
        this.player2 = player2;
    }

    public ArrayList<Entity> getEntities()
    {
        return entities1;
    }

    public void setEntities(ArrayList<Entity> entities)
    {
        this.entities1 = entities;
    }
    
    public ArrayList<Entity> getEntities2()
    {
        return entities2;
    }
    
    public ArrayList<Entity> getEntities3()
    {
        return entities3;
    }

    public void setEntities2(ArrayList<Entity> entities)
    {
        this.entities2 = entities;
    }
    
    public void createPlayer2() {
    	addEntity1(player2);
		addEntity2(player2);
    }
    
	public void setWorld(World world) {
		this.world = world;
	}
	
}
