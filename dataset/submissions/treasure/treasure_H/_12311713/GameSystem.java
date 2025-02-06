import java.util.ArrayList;

public class GameSystem {
	public static int counts=0;
	ArrayList<Player> playerList= new ArrayList<>();
	Map map;
	public void addPlayer(Player player){
		playerList.add(player);
	}
	public Map newGame(int rows, int colums, Treasure... treasures){
		this.map=new Map(rows,colums,treasures);
		return map;
	}
	public Player getWinner(){
		int max=0,steps=999999;
		int ans=0;
		for (Player value : playerList) {
			max = Math.max(max, value.getScore());
		}
		for (Player player : playerList) {
			if (player.getScore() == max) {
				steps = Math.min(steps, player.getSteps());
			}
		}
		for(int i=0;i<playerList.size();i++){
			if(playerList.get(i).getScore()==max &&
			playerList.get(i).getSteps()==steps)
				return playerList.get(i);
		}
		return playerList.get(0);
	}
}
