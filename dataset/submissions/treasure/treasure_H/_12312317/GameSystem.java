import java.util.ArrayList;

public class GameSystem {
//    Field
    private ArrayList<Player> players= new ArrayList<>();

//    Methods
    public void addPlayer(Player player){
        players.add(player);
    }

    public Map newGame(int rows, int columns, Treasure[] treasures){
        return new Map(rows,columns,treasures);
    }

    public Player getWinner(){
        int max = players.get(0).getScore();
        int WinnerNumber = 0;
        for (int i = 0; i < players.size(); i++) {
            if(players.get(i).getScore()>max){
                max = players.get(i).getScore();
                WinnerNumber = i;
            }else if(players.get(i).getScore()==max){
                if(players.get(i).getSteps()<players.get(WinnerNumber).getSteps()){
                    WinnerNumber = i;
                }
            }
        }
        return players.get(WinnerNumber);
    }

}
