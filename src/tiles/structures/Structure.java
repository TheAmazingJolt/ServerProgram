package tiles.structures;

import java.awt.image.BufferedImage;

import tiles.Tile;

public class Structure extends Tile{

	public int locationX;
	public int locationY;
	public int health = 50;
	private boolean locationSet = false;
	
	public Structure(BufferedImage texture, int id, int locationX, int locationY) {
		super(texture, id);
	}
	
	public void hurt(int dmg) {
		health -= dmg;
		if(health <= 0) {
			die();
		}
	}
	
	public void die() {
		structures.remove(this);
	}
	
	public void setLocation(int x, int y) {
		this.locationX = x;
		this.locationY = y;
		locationSet = true;
	}

	public int getLocationX() {
		return locationX;
	}

	public int getLocationY() {
		return locationY;
	}

	public boolean isLocationSet() {
		return locationSet;
	}

}
