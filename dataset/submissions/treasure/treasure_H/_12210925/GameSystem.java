import java.util.ArrayList;

public class GameSystem {
    private int count=1;
    private ArrayList<Player> players=new ArrayList<>();


    public void addPlayer(Player player){
        players.add(player);
        player.setId(count);
        count++;
    }

    public Map newGame(int rows, int columns, Treasure[] treasures){
        return new Map(rows,columns,treasures);
    }
    public Player getWinner(){
        Player player = new Player();
        int Max=-1;
        int maxStep=10000;
        for (int i = 0; i < players.size(); i++) {
            if(players.get(i).getScore()>Max){
                player=players.get(i);
                Max=players.get(i).getScore();
                maxStep=players.get(i).getStep();
            }
            else if(players.get(i).getScore()==Max){
                if(players.get(i).getStep()<maxStep){
                    player=players.get(i);
                    maxStep=players.get(i).getStep();
                }
            }
        }return player;
    }
}
