
import java.util.ArrayList;


public class GameSystem {
    private ArrayList<Player> players;


    public GameSystem() {
        players = new ArrayList<>();
    }

    public void addPlayer(Player player){
        players.add(player);
    }



    public Map newGame(int rows, int columns, Treasure... treasures){
        return new Map(rows,columns,treasures);
    }
    public Player getWinner(){
        Player winner = null;
        int maxscore=0;
        ArrayList<Player> possiblewinner = new ArrayList<>();
        for (Player p:players
        ) {if (p.getScore()>maxscore)
                maxscore= p.getScore();}

        for (Player pl:players)
         {if (maxscore== pl.getScore()){
            possiblewinner.add(pl);
        }
            int minsteps=Integer.MAX_VALUE;
            for (Player ps:possiblewinner)
            {if (minsteps>ps.getSteps()){
                minsteps=ps.getSteps();
            }
            }

            for (Player ps:possiblewinner) {
                 if (ps.getSteps() == minsteps) {
                     winner = ps;

                 }
             }

            }
        return winner;}
    }






