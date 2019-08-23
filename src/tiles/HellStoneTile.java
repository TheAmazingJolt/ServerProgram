package tiles;

import gfx.Assets;

// Referenced classes of package tiles:
//            Tile

public class HellStoneTile extends Tile
{

    public HellStoneTile(int id)
    {
        super(Assets.hellStone, id);
    }

    public boolean isSolid()
    {
        return false;
    }
}
