import java.util.ArrayList;


public class GameSystem {
    final ArrayList<Player> players = new ArrayList<>();

    public void addPlayer(Player player) {
        players.add(player);
    }

    public Map newGame(int rows, int columns, Treasure... treasures) {
        return new Map1(rows,columns,treasures);
    }
    public int findMax(){
        int maxNumber =0;
        int numbers = players.size();
        while (numbers>=0){
        for (Player p : players){
            if (p.getScore()>=maxNumber){
                maxNumber = p.getScore();

            }
       }
            numbers--; }return maxNumber;
    }

    public Player getWinner() {
        int id = 0;
        int i = 0;
        int max = findMax();
        int[] index = new int[players.size()];
            for (int j = 0; j <players.size() ; j++) {
                if (players.get(j).getScore()==max){
                    index[i] = j;
                    i++;

            }
        }
        for (int k = 0; k <i; k++) {
            if (players.get(index[k]).getSteps()<players.get(index[k+1]).getSteps()){
                id = index[k];
            }
        }
       return players.get(id);
    }



    }

