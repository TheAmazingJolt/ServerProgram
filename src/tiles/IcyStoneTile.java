package tiles;

import gfx.Assets;

// Referenced classes of package tiles:
//            Tile

public class IcyStoneTile extends Tile
{

    public IcyStoneTile(int id)
    {
        super(Assets.icyStone, id);
    }

    public boolean isSolid()
    {
        return false;
    }
}
