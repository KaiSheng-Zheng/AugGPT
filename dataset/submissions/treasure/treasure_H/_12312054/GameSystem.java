

import java.util.ArrayList;

public class GameSystem {
    private ArrayList<Player>players;
    public GameSystem(){
        players=new ArrayList<>();
    }
    public void addPlayer(Player player){
            players.add(player);
    }
    public Map newGame(int rows, int columns, Treasure... treasures){
         return new Map(rows,columns,treasures);
    }
    public Player getWinner(){
        Player[]winner=new Player[players.size()];
        for (int i = 0; i < players.size(); i++) {
            winner[i]=players.get(i);
        }
        for (int i = 0; i <players.size()-1; i++) {
            for (int j = 0; j <players.size()-1-i; j++) {
                if(winner[j].getScore()<winner[j+1].getScore()){
                    Player temp=winner[j+1];
                    winner[j+1]=winner[j];
                    winner[j]=temp;
                }
            }
        }
        for (int i = 1; i < players.size(); i++) {
            if(winner[0].getScore()==winner[i].getScore()){
                if(winner[0].getSteps()>winner[i].getSteps()) {
                    Player temp = winner[i];
                    winner[i] = winner[0];
                    winner[0]=temp;
                }

            }
        }
        return winner[0];
    }
}
