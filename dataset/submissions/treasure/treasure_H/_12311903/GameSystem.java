import java.util.*;

public class GameSystem {

        private List<Player> players=new ArrayList<>();

    public void addPlayer (Player player){
        players.add(player);
    }
        public  Map newGame(int rows, int columns,Treasure[] treasures){
            return new Map(rows,columns,treasures);
        }
        public Player getWinner(){
                Player player0=players.get(0);
                for(int n=0;n<players.size()-1;n++){
                       if(player0.getScore()<players.get((n+1)).getScore()){
                               player0=players.get(n+1);
                       }
                       else if (player0.getScore()==players.get((n+1)).getScore()){
                               if(player0.getSteps()>players.get((n+1)).getSteps()){
                                       player0=players.get(n+1);
                               }
                       }
                }
                return player0;
        }



    }

