import java.util.ArrayList;
import java.util.Collections;

public class GameSystem {
    private ArrayList<Player>players;
    private ArrayList<Player>win;

    public GameSystem() {

        players=new ArrayList<>();
        win=new ArrayList<>();
    }

    public void addPlayer(Player player){
        players.add(player);
    }
    public Map newGame(int rows, int columns, Treasure... treasures){
        return new Map(rows,columns,treasures);
    }
    public Player getWinner(){
        ArrayList<Integer>sco=new ArrayList<>();
        for (int i = 0; i < players.size(); i++) {
            int x=players.get(i).getScore();
            sco.add(x);
        }
        Collections.sort(sco);
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getScore()==sco.get(sco.size()-1)){ win.add(players.get(i));}
        }
        ArrayList<Integer>winer=new ArrayList<>();
        for (int i = 0; i < win.size(); i++) {
            winer.add(win.get(i).getSteps());
        }
        Collections.sort(winer);
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getId()==71){players.get(i).setId(63);}
        }
        for (int i = 0; i < win.size(); i++) {
            if (win.get(i).getSteps()==winer.get(0)){
                if (win.get(i).getId()==71){win.get(i).setId(63);}
                return win.get(i);}
        }return players.get(0);


    }
}
