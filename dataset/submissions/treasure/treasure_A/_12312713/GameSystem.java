public class GameSystem
{
	Player[] players=new Player[100000];
	int n;
	public GameSystem()
	{
		n=0;
		Player.cnt=0;
	}
	public void addPlayer(Player player)
	{
		players[++n]=player;
	}
	public Map newGame(int rows,int columns,Treasure... treasures)
	{
		Map t=new Map(rows,columns,treasures);
		return t;
	}
	public Player getWinner()
	{
		int id=1;
		for(int i=1;i<=n;i++)
			if(players[i].getScore()>players[id].getScore()||(players[i].getScore()==players[id].getScore()&&players[i].getSteps()<players[id].getSteps()))
				id=i;
		return players[id];
	}
}