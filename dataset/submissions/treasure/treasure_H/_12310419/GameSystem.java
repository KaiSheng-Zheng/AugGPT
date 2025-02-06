import java.util.ArrayList;
public class GameSystem {
    private ArrayList<Player> players;
    private ArrayList<Map> maps = new ArrayList<>();
    public GameSystem(){
        players=new ArrayList<>();
    }

    public ArrayList<Map> getMaps() {
        return maps;
    }

    public void setMaps(ArrayList<Map> maps) {
        this.maps = maps;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public void addPlayer(Player player){
        players.add(player);
        setPlayers(players);
    }
    public Map newGame(int rows,int columns,Treasure[] treasures){
        return new Map(rows,columns,treasures);
    }
    public Player getWinner(){
        Player[] player=(Player[]) players.toArray(new Player[0]);
        int[][] playerScore = new int[2][player.length];
        for (int i = 0; i <player.length ; i++) {
            playerScore[0][i]=player[i].getScore();
            playerScore[1][i]=i;
        }
        int i=0;
        for (int j = player.length; j >i ; j--) {
            for (; i < player.length-1 ; i++) {
                if (playerScore[0][i]>playerScore[0][i+1]){
                    int c1=playerScore[0][i];
                    int c2=playerScore[1][i];
                    playerScore[0][i]=playerScore[0][i+1];
                    playerScore[1][i]=playerScore[1][i+1];
                    playerScore[0][i+1]=c1;
                    playerScore[1][i+1]=c2;
                }
                if (playerScore[0][i]==playerScore[0][i+1]){
                    if (player[playerScore[1][i]].getSteps()<player[playerScore[1][i+1]].getSteps()){
                        int c1=playerScore[0][i];
                        int c2=playerScore[1][i];
                        playerScore[0][i]=playerScore[0][i+1];
                        playerScore[1][i]=playerScore[1][i+1];
                        playerScore[0][i+1]=c1;
                        playerScore[1][i+1]=c2;
                    }
                }
            }
        }
        return player[playerScore[1][player.length-1]];
    }
}
