package tiles;

import gfx.Assets;

public class HellRockTile extends Tile{

	public HellRockTile(int id) {
		super(Assets.hellStoneWall, id);
	}
	public boolean isSolid() {
		return true;
	}

}
