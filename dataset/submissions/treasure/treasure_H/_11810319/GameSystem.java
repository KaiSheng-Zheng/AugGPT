import java.util.ArrayList;

public class GameSystem {
    private ArrayList<Player> player = new ArrayList<>(0);
    public void addPlayer(Player player){
        this.player.add(player);
    }
    public Map newGame(int rows, int columns, Treasure... treasures){
        Map map =new Map(rows,columns,treasures);
        return map;
    }
    public Player getWinner(){
        int counter=0;
        int maxscore = 0;
        for(int i = 0; i < player.size();i++){
            if(player.get(i).getScore()> maxscore){
                maxscore = player.get(i).getScore();
                counter = i;
            }
        }
        return player.get(counter);
    }

    public ArrayList<Player> getPlayer() {
        return player;
    }

    public void setPlayer(ArrayList<Player> player) {
        this.player = player;
    }
}
