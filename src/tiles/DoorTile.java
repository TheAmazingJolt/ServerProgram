package tiles;

public class DoorTile extends Tile
{

    public DoorTile(int id)
    {
        super(id);
    }

    public boolean isSolid()
    {
        return solid;
    }

    public static void open()
    {
        solid = false;
    }
    
    public static void close()
    {
        solid = true;
    }

    static boolean solid = true;

}
