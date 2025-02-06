import java.util.ArrayList;

public class GameSystem {
    private ArrayList<Player> playerList;

    public GameSystem(){
        playerList = new ArrayList<>();

    }
    public void addPlayer(Player player){
        playerList.add(player);
    }
    public Map newGame(int rows, int columns, Treasure... treasures){
        return  new Map(rows,columns,treasures);
    }
    public Player getWinner(){
        int maxPoint = playerList.get(0).getScore();
        ArrayList<Player> playerCompete = new ArrayList<>();
        for(Player player:playerList){
            if(player.getId() != 1) {
                if(player.getScore() > maxPoint) {
                    playerCompete = new ArrayList<>();
                    playerCompete.add(player);
                    maxPoint = player.getScore();
                } else if (player.getScore() == maxPoint) {
                    playerCompete.add(player);
                }
            }
        }
        if(playerCompete.size() == 1) {
            return playerCompete.get(0);
        } else {
            Player winner = playerCompete.get(0);
            for(Player player: playerCompete) {
                if(player.getId()!=1) {
                    if(player.getSteps() < winner.getSteps()) {
                        winner = player;
                    }
                }
            }
            return winner;
        }


    }


}