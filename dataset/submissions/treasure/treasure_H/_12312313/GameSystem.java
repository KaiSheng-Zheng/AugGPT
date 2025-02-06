import java.util.ArrayList;

public class GameSystem {
    private ArrayList<Player> Player = new ArrayList<Player>();

    private Map map;

    public void addPlayer(Player player) {
        boolean is = true;
        for (Player i : Player) {
            if (player.getId() == i.getId()) {
                is = false;
            }
        }
        if (is) {
            player.setMap(map);
            Player.add(player);
        }
    }

    public Map newGame(int rows, int columns, Treasure... treasures) {
        this.map = new Map(rows, columns, treasures);
        return map;
    }

    public Player getWinner() {
        int max = 0;
        int counter = 0;
        ArrayList<Player> p=new ArrayList<Player>();

        for (int i = 0; i < Player.size(); i++) {
            if (Player.get(i).getScore() >= max) {
               max=Player.get(i).getScore();
        }
        }
        for (int i = 0; i < Player.size(); i++){
            if (Player.get(i).getScore() >= max){
                p.add(Player.get(i));
            }

        }

        int step=p.get(0).getSteps();
        for(int m = 0; m < p.size(); m++){
            if(step>p.get(m).getSteps()){
                counter=m;
            }
        }
return p.get(counter);

    }
}