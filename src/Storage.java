import java.util.ArrayList;

public class Storage {

	private float player1X = 0;
	private float player1Y = 0;
	private float player2X = 0;
	private float player2Y = 0;
	private int player1Health = 0;
	private int player2Health = 0;
	private float player1XMove = 0;
	private float player1YMove = 0;
	private float player2XMove = 0;
	private float player2YMove = 0;
	
	private ArrayList<Integer> entityState = new ArrayList<Integer>();
	
	public Storage() {
		
	}

	public float getPlayer1X() {
		return player1X;
	}

	public float getPlayer2XMove() {
		return player2XMove;
	}

	public float getPlayer1XMove() {
		return player1XMove;
	}

	public void setPlayer1XMove(float player1xMove) {
		player1XMove = player1xMove;
	}

	public float getPlayer1YMove() {
		return player1YMove;
	}

	public void setPlayer1YMove(float player1yMove) {
		player1YMove = player1yMove;
	}

	public ArrayList<Integer> getEntityState() {
		return entityState;
	}

	public void setEntityState(ArrayList<Integer> entityState) {
		this.entityState = entityState;
	}

	public void setPlayer2XMove(float player2xMove) {
		player2XMove = player2xMove;
	}

	public float getPlayer2YMove() {
		return player2YMove;
	}

	public void setPlayer2YMove(float player2yMove) {
		player2YMove = player2yMove;
	}

	public void setPlayer1X(float player1x) {
		player1X = player1x;
	}

	public float getPlayer1Y() {
		return player1Y;
	}

	public void setPlayer1Y(float player1y) {
		player1Y = player1y;
	}

	public float getPlayer2X() {
		return player2X;
	}

	public void setPlayer2X(float player2x) {
		player2X = player2x;
	}

	public float getPlayer2Y() {
		return player2Y;
	}

	public void setPlayer2Y(float player2y) {
		player2Y = player2y;
	}

	public int getPlayer1Health() {
		return player1Health;
	}

	public void setPlayer1Health(int player1Health) {
		this.player1Health = player1Health;
	}

	public int getPlayer2Health() {
		return player2Health;
	}

	public void setPlayer2Health(int player2Health) {
		this.player2Health = player2Health;
	}
	
}
