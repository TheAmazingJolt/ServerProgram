package tiles.structures;

public class WoodStructure extends Structure{

	public WoodStructure(int id) {
		super(id, -1, -1);
	}

	public boolean isSolid() {
		return true;
	}
	
	public void setLocation(int x, int y) {
		this.locationX = x;
		this.locationY = y;
	}
	
}
