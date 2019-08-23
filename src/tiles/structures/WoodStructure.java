package tiles.structures;

import gfx.Assets;

public class WoodStructure extends Structure{

	public WoodStructure(int id) {
		super(Assets.woodenStructure, id, -1, -1);
	}

	public boolean isSolid() {
		return true;
	}
	
	public void setLocation(int x, int y) {
		this.locationX = x;
		this.locationY = y;
	}
	
}
