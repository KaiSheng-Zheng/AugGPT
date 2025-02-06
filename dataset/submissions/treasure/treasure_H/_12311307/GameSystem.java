import java.util.ArrayList;

public class GameSystem {
    private ArrayList<Player>players=new ArrayList<>();
    public void addPlayer(Player player) {
        players.add(player);

    }
    public Map newGame(int rows, int columns, Treasure... treasures){

        return new Map(rows,columns,treasures);
    }
    public Player getWinner(){
        Player current=players.get(0);
       for (Player p:players){
           if (p.getScore()>current.getScore()){
               current=p;
           }
           if (p.getScore()==current.getScore()){
               if (p.getSteps()<current.getSteps()){
                   current=p;
               }
           }
       }
       return current;
    }
    }
