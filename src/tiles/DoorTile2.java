package tiles;

import gfx.Assets;

public class DoorTile2 extends Tile
{

    public DoorTile2(int id)
    {
        super(Assets.closedDoor2, id);
    }

    public boolean isSolid()
    {
        return solid;
    }

    public static void open()
    {
        solid = false;
        for(Tile t : Tile.getTiles()) {
        	if(t.getId() == Tile.doorTile2.id) {
        		t.setTexture(Assets.openDoor2);
        	}
        }
    }
    
    public static void close()
    {
        solid = true;
        for(Tile t : Tile.getTiles()) {
        	if(t.getId() == Tile.doorTile2.id) {
        		t.setTexture(Assets.closedDoor2);
        	}
        }
    }

    static boolean solid = true;

}
