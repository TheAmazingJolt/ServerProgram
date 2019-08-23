package tiles;

import gfx.Assets;

public class DoorTile extends Tile
{

    public DoorTile(int id)
    {
        super(Assets.closedDoor, id);
    }

    public boolean isSolid()
    {
        return solid;
    }

    public static void open()
    {
        solid = false;
        for(Tile t : Tile.getTiles()) {
        	if(t.getId() == Tile.doorTile.id) {
        		t.setTexture(Assets.openDoor);
        	}
        }
    }
    
    public static void close()
    {
        solid = true;
        for(Tile t : Tile.getTiles()) {
        	if(t.getId() == Tile.doorTile.id) {
        		t.setTexture(Assets.closedDoor);
        	}
        }
    }

    static boolean solid = true;

}
