public class GameSystem{
    static Player[] players =new Player[100];
    private Map map;
    private static int NumOfPlayers = 0;
    public void addPlayer(Player player)
    {
        players[NumOfPlayers] = player;
        NumOfPlayers++;
    }
    public Map newGame(int rows, int columns, Treasure... treasures) {
        map = new Map(rows, columns, treasures);
        return new Map(rows, columns, treasures);
    }

    public Player getWinner() {
        Player player =new Player(map,new Position(0,0));
        for(int i =0;i< NumOfPlayers-1;i++){
            if(players[i].getScore()> players[i+1].getScore()||players[i].getScore()==players[i+1].getScore()
                    &&players[i].getSteps()<players[i+1].getSteps())
            {
                player = players[i];
            }
        }
        return player;
    }
}