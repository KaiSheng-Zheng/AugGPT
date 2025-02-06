import java.util.ArrayList;

public class GameSystem {
    private Map map;
    private static ArrayList<Player> playlist=new ArrayList<>();

    public void addPlayer(Player player){
        playlist.add(player);
    }

    public Map newGame(int rows, int columns, Treasure[] treasures){
        this.map=new Map(rows,columns,treasures);
        return map;
    }
    public Player getWinner(){
        for(int i=0;i<playlist.size()-1;i++){
            for(int j=0;j<playlist.size()-1;j++) {
                if (playlist.get(j).getScore() < playlist.get(j + 1).getScore()) {
                    Player a = playlist.get(j);
                    playlist.set(j, playlist.get(j + 1));
                    playlist.set(j + 1, a);}
            }
        }
                for(int c=0;c< playlist.size()-1;c++){
                    for(int a=0;a< playlist.size()-1;a++){
                if (playlist.get(a).getScore() == playlist.get(a + 1).getScore()) {
                    if (playlist.get(a).getSteps() > playlist.get(a + 1).getSteps()) {
                        Player b = playlist.get(a);
                        playlist.set(a, playlist.get(a + 1));
                        playlist.set(a + 1, b);
                    }
                }
            }
                }
                return playlist.get(0);
    }
}