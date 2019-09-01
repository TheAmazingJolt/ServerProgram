package tiles;


public class DirtTile extends Tile{
	public DirtTile(int id) {
		super(id);
	}
	
	public boolean isDeadly() {
		return false;
	}
}
