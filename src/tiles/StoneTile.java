package tiles;

import gfx.Assets;

// Referenced classes of package tiles:
//            Tile

public class StoneTile extends Tile
{

    public StoneTile(int id)
    {
        super(Assets.stone, id);
    }

    public boolean isSolid()
    {
        return false;
    }
    
    public boolean isDeadly() {
		return false;
	}
}
