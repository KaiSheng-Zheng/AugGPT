import java.util.List;

public class GameSystem {
    Map map;
    Player a;
    Player player[];
    private List<Player> players;
    public void addPlayer(Player player){
        this.player= new Player[]{player};
        a=player;
    }
    public Map newGame(int rows, int columns, Treasure... treasures){
        map.rows=rows;
        map.columns=columns;
        map.treasures=treasures;
        return map;
    }
    public Player getWinner(){
        return a;
    }
}
