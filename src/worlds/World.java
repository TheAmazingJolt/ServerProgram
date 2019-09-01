package worlds;

import entities.EntityManager;
import entities.creatures.Boss1;
import entities.creatures.Boss2;
import entities.creatures.Boss3;
import entities.creatures.HellZombie;
import entities.creatures.IcyZombie;
import entities.creatures.Penguin;
import entities.creatures.Zombie;
import entities.statics.Coal;
import entities.statics.Flint;
import entities.statics.HellTree;
import entities.statics.IcyTree;
import entities.statics.Iron;
import entities.statics.Stone;
import entities.statics.Tree;
import items.ItemManager;
import main.Storage;
import tiles.DoorTile;
import tiles.DoorTile2;
import tiles.Tile;
import tiles.structures.Structure;
import utils.Utils;

public class World
{

	public static final int DEFAULT_TREE_HEALTH = 15;
    public static final int DEFAULT_ROCK_HEALTH = 20;
    private int width;
    private int height;
    private int height2;
    private int spawnX;
    private int spawnY;
    private int tiles[][];
    private static int count = 0;
    private static int worldNum;
    private static int loadedSave = 1;
    private static boolean loaded;
    private static EntityManager entityManager;
    private ItemManager itemManager;
    private static int currentWorld;
    private static int totalEntities1;
    private static int totalEntities2;
    private static boolean playerSet = false;
    
    public int id;
    
    public Storage storage;
	
    public World(String path, Storage storage, int id)
    {
    	System.out.println("a");
        entityManager = new EntityManager();
        itemManager = new ItemManager();
        this.storage = storage;
        loadWorld(path);
        this.id = id;
    }

    public void tick()
    {
        if(!playerSet) {
        	entityManager.setWorld(this);
        	entityManager.setPlayer(this);
            spawnX = 3264;
            spawnY = 3264;
            entityManager.getPlayer().setPos(spawnX, spawnY);
        	playerSet = true;
        }
    	System.out.println("World Tick");
        entityManager.tick();
        itemManager.tick();
        if(entityManager.getPlayer().getKilledEnemies() >= 5)
            DoorTile.open();
        else
        	DoorTile.close();
        if(entityManager.getPlayer().getKilledBosses() >= 1 * getCurrentWorld())
            DoorTile2.open();
        else
        	DoorTile2.close();
    }

    public Tile getTile(int x, int y)
    {
        if(x < 0 || y < 0 || x >= width || y >= height)
            return Tile.grassTile;
        if(y == 0) {
        	Tile t = Tile.getTiles().get(x);
        	if(t == null)
                return Tile.dirtTile;
            else
                return t;
        }else {
        	Tile t = Tile.getTiles().get((width * y) + x);
        	if(t == null)
                return Tile.dirtTile;
            else
                return t;
        }
        
    }
    
    public Structure getStructure(int x, int y)
    {
    	if(Structure.getStructures().size() == 0) {
    		return null;
    	}
    	Structure t = null;
        if(x < 0 || y < 0 || x >= width || y >= height)
            return t;
        if(y == 0) {
        	for(Structure s : Structure.getStructures()) {
        		if(s.getLocationX() == x) {
        			if(s.getLocationY() == y) {
        				t = s;
        			}
        		}
        	}
        	if(t == null)
                return t;
            else
                return t;
        }else {
        	for(Structure s : Structure.getStructures()) {
        		if(s.getLocationX() == x) {
        			if(s.getLocationY() == y) {
        				t = s;
        			}
        		}
        	}
        	if(t == null)
                return t;
            else
                return t;
        }
        
    }

    public int getLoadedSave() {
		return loadedSave;
	}

	public void setLoadedWorld(int loadedWorld) {
		loadedSave = loadedWorld;
	}

	public void loadWorld(String path)
    {
        String file = Utils.loadFileAsString(path);
        String file2 = Utils.loadFileAsString(path.replace(".txt", "entities.txt")); 
        String tokens[] = file.split("\\s+");
        String tokens2[] = file2.split("\\s+");
        width = Utils.parseInt(tokens[0]);
        height = Utils.parseInt(tokens[1]);
        height2 = Utils.parseInt(tokens2[0]);
        //spawnX = Utils.parseInt(tokens[2]);
        //spawnY = Utils.parseInt(tokens[3]);
        tiles = new int[width][height];
        String token[];
        String token2[];
        String token3[];
        String entityName;
        int entityNum = 0;
        int entityNum2 = 0;
        int entityNum3 = 0;
        for(int y = 1; y <= height2; y++)
        {
        	try {
                token2 = tokens2[y].split("\\:");
                entityName = token2[0];
                token3 = token2[1].split("\\,");
               	if(currentWorld == 1) {
               		System.out.println("aaa");
               		entityNum++;
               		if(entityName.contains("t")) {
                       	entityManager.addEntity1(new Tree((float) Integer.parseInt(token3[0]) * 64, (float) Integer.parseInt(token3[1]) * 64, entityNum, this));
                  	}else if(entityName.contains("s")) {
                   		entityManager.addEntity1(new Stone((float) Integer.parseInt(token3[0]) * 64, (float) Integer.parseInt(token3[1]) * 64, entityNum, this));
                   	}else if(entityName.contains("i")) {
                   		entityManager.addEntity1(new Iron((float) Integer.parseInt(token3[0]) * 64, (float) Integer.parseInt(token3[1]) * 64, entityNum, this));
                    }else if(entityName.contains("f")) {
                   		entityManager.addEntity1(new Flint((float) Integer.parseInt(token3[0]) * 64, (float) Integer.parseInt(token3[1]) * 64, entityNum, this));
                   	}else if(entityName.contains("z")) {
                   		entityManager.addEntity1(new Zombie((float) Integer.parseInt(token3[0]) * 64, (float) Integer.parseInt(token3[1]) * 64, entityNum, getEntityManager().getPlayer(), this));
                   	}else if(entityName.contains("b")) {
                  		entityManager.addEntity1(new Boss1((float) Integer.parseInt(token3[0]) * 64, (float) Integer.parseInt(token3[1]) * 64, 20, entityNum, this));
                   	}
               	}else if(currentWorld == 2) {
               		entityNum2++;
               		if(entityName.contains("t")) {
                       	entityManager.addEntity2(new HellTree((float) Integer.parseInt(token3[0]) * 64, (float) Integer.parseInt(token3[1]) * 64, entityNum2, this));
                   	}else if(entityName.contains("s")) {
                  		entityManager.addEntity2(new Stone((float) Integer.parseInt(token3[0]) * 64, (float) Integer.parseInt(token3[1]) * 64, entityNum2, this));
                   	}else if(entityName.contains("i")) {
                  		entityManager.addEntity2(new Iron((float) Integer.parseInt(token3[0]) * 64, (float) Integer.parseInt(token3[1]) * 64, entityNum2, this));
                   	}else if(entityName.contains("f")) {
                  		entityManager.addEntity2(new Flint((float) Integer.parseInt(token3[0]) * 64, (float) Integer.parseInt(token3[1]) * 64, entityNum2, this));
                  	}else if(entityName.contains("z")) {
                  		entityManager.addEntity2(new HellZombie((float) Integer.parseInt(token3[0]) * 64, (float) Integer.parseInt(token3[1]) * 64, entityNum2, getEntityManager().getPlayer(), this));
                  	}else if(entityName.contains("c")) {
                 		entityManager.addEntity2(new Coal((float) Integer.parseInt(token3[0]) * 64, (float) Integer.parseInt(token3[1]) * 64, entityNum2, this));
                   	}else if(entityName.contains("b")) {
                   		entityManager.addEntity2(new Boss2((float) Integer.parseInt(token3[0]) * 64, (float) Integer.parseInt(token3[1]) * 64, 50, entityNum2, this));
                   	}
              	}else if(currentWorld == 3) {
               		entityNum3++;
                    if(entityName.contains("t")) {
                       	entityManager.addEntity3(new IcyTree((float) Integer.parseInt(token3[0]) * 64, (float) Integer.parseInt(token3[1]) * 64, entityNum3, this));
                   	}else if(entityName.contains("s")) {
                  		entityManager.addEntity3(new Stone((float) Integer.parseInt(token3[0]) * 64, (float) Integer.parseInt(token3[1]) * 64, entityNum3, this));
                   	}else if(entityName.contains("i")) {
                  		entityManager.addEntity3(new Iron((float) Integer.parseInt(token3[0]) * 64, (float) Integer.parseInt(token3[1]) * 64, entityNum3, this));
                   	}else if(entityName.contains("f")) {
                  		entityManager.addEntity3(new Flint((float) Integer.parseInt(token3[0]) * 64, (float) Integer.parseInt(token3[1]) * 64, entityNum3, this));
                  	}else if(entityName.contains("z")) {
                  		entityManager.addEntity3(new IcyZombie((float) Integer.parseInt(token3[0]) * 64, (float) Integer.parseInt(token3[1]) * 64, entityNum3, getEntityManager().getPlayer(), this));
                  	}else if(entityName.contains("c")) {
                 		entityManager.addEntity3(new Coal((float) Integer.parseInt(token3[0]) * 64, (float) Integer.parseInt(token3[1]) * 64, entityNum3, this));
                   	}else if(entityName.contains("p")) {
                 		entityManager.addEntity3(new Penguin((float) Integer.parseInt(token3[0]) * 64, (float) Integer.parseInt(token3[1]) * 64, entityNum3, this));
                   	}else if(entityName.contains("b")) {
                   		entityManager.addEntity3(new Boss3((float) Integer.parseInt(token3[0]) * 64, (float) Integer.parseInt(token3[1]) * 64, 50, entityNum3, this));
                   	}
              	}
                	
        	}catch(ArrayIndexOutOfBoundsException e) {
               	
            }
        }
      
        
        for(int y = 0; y < height; y++) {
        	for(int x = 0; x < width; x++) {
            	token = tokens[x + y * width + 4].split("\\ ");
                tiles[x][y] = Utils.parseInt(token[0]);
        		if(tiles[x][y] == 0) {
        			Tile.getTiles().add(Tile.grassTile);
        		}else if(tiles[x][y] == 1) {
        			Tile.getTiles().add(Tile.dirtTile);
        		}else if(tiles[x][y] == 2) {
        			Tile.getTiles().add(Tile.rockTile);
        		}else if(tiles[x][y] == 3) {
        			Tile.getTiles().add(Tile.stoneTile);
        		}else if(tiles[x][y] == 4) {
        			Tile.getTiles().add(Tile.waterTile);
        		}else if(tiles[x][y] == 5) {
        			Tile.getTiles().add(Tile.doorTile);
        		}else if(tiles[x][y] == 6) {
        			Tile.getTiles().add(Tile.warpTile);
        		}else if(tiles[x][y] == 7) {
        			Tile.getTiles().add(Tile.hellRockTile);
        		}else if(tiles[x][y] == 8) {
        			Tile.getTiles().add(Tile.hellStoneTile);
        		}else if(tiles[x][y] == 9) {
        			Tile.getTiles().add(Tile.hellGrassTile);
        		}else if(tiles[x][y] == 11) {
        			Tile.getTiles().add(Tile.icyRockTile);
        		}else if(tiles[x][y] == 12) {
        			Tile.getTiles().add(Tile.icyStoneTile);
        		}else if(tiles[x][y] == 13) {
        			Tile.getTiles().add(Tile.icyGrassTile);
        		}else if(tiles[x][y] == 14) {
        			Tile.getTiles().add(Tile.doorTile2);
        		}
        	}
        }

    }
    
    public void unloadWorld() {
    	width = 0;
    	height = 0;
    	spawnX = 0;
    	spawnY = 0;
    	tiles = null;
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }

    public static void setCount(int Count)
    {
        count = Count;
    }

    public static int getCount()
    {
        return count;
    }

    public int getTotalEntities1() {
		return totalEntities1;
	}

	public static void setTotalEntities1(int totalEntities1) {
		World.totalEntities1 = totalEntities1;
	}

	public static int getTotalEntities2() {
		return totalEntities2;
	}

	public static void setTotalEntities2(int totalEntities2) {
		World.totalEntities2 = totalEntities2;
	}

	public int getCurrentWorld() {
		return currentWorld;
	}

	public void setCurrentWorld(int currentWorl) {
		currentWorld = currentWorl;
	}

	public boolean isLoaded()
    {
        return loaded;
    }

    public static void setLoaded(boolean loade)
    {
        loaded = loade;
    }

    public EntityManager getEntityManager()
    {
        return entityManager;
    }

    public static int getWorldNum()
    {
        return worldNum;
    }

    public static void setWorldNum(int num)
    {
        worldNum = num;
    }

    public ItemManager getItemManager()
    {
        return itemManager;
    }

    public void setItemManager(ItemManager itemManager)
    {
        this.itemManager = itemManager;
    }

    

}