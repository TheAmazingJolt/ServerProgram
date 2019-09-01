package tiles;

public class RockTile extends Tile{

	public RockTile( int id) {
		super(id);
	}
	public boolean isSolid() {
		return true;
	}

}
