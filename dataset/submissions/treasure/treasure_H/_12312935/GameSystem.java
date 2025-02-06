import java.util.ArrayList;

public class GameSystem {
    ArrayList<Player> players;
    public void addplayer(Player player){
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).equals(player)){
                break;
            }
            if (i == players.size()-1){
                players.add(player);
            }
        }
    }
}
