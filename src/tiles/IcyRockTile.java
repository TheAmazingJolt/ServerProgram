package tiles;

import gfx.Assets;

public class IcyRockTile extends Tile{

	public IcyRockTile(int id) {
		super(Assets.icyWall, id);
	}
	public boolean isSolid() {
		return true;
	}

}
