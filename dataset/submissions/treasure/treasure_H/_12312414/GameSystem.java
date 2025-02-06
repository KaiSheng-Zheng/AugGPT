import java.util.ArrayList;

public class GameSystem {
    public ArrayList<Player> players= new ArrayList<>();
    public void addPlayer(Player player){
        players.add(player);
    }

    public Map newGame(int rows, int columns, Treasure... treasures){
        return new Map(rows, columns,treasures);
    }

    public Player getWinner(){
        Player winner = players.get(0);
        for (int i = 1; i < players.size(); i++) {
            if (players.get(i).getScore() > winner.getScore()){
                winner = players.get(i);
            }
        }
        ArrayList<Player> temp = new ArrayList<>();
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getScore() == winner.getScore()){
                temp.add(players.get(i));
            }
        }
        for (int i = 0; i < temp.size(); i++) {
            if (temp.get(i).getSteps() < winner.getSteps()){
                winner = temp.get(i);
            }
        }
        return winner;
    }
}
