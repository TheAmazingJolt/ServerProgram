package tiles;

import gfx.Assets;

public class DirtTile extends Tile{
	public DirtTile(int id) {
		super(Assets.dirt, id);
	}
	
	public boolean isDeadly() {
		return false;
	}
}
