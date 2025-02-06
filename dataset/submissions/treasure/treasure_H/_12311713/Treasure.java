import java.util.*;
public class Treasure {
	private final int score;
	private final Position position;
	public static ArrayList<String> poses=new ArrayList<String>();
	public Treasure(int score, Position position){
		this.score=score;
		this.position=position;
		GameSystem.counts++;
		poses.add(String.format("%d %d %d",score,position.getRow(),position.getCol()));
	}
	public int getScore(){
		return this.score;
	}
	public Position getPosition(){
		return this.position;
	}
}
