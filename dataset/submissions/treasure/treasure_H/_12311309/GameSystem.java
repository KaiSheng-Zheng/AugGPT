import java.util.ArrayList;
public class GameSystem {
    private ArrayList<Player> players;
    public GameSystem(){
        players=new ArrayList<>();
    }
    public void addPlayer(Player player){
        players.add(player);
    }
    public Map newGame(int rows,int columns,Treasure...treasures){
        return new Map(rows,columns,treasures);
    }
    public Player getWinner() {
        for (int j = 0; j < players.size(); j++) {
            for (int i = 0; i < players.size() - 1; i++) {
                if (players.get(i).getScore() < players.get(i + 1).getScore()) {
                   Player p1=players.get(i);
                   Player p2=players.get(i+1);
                   players.remove(i);
                   players.remove(i);
                   players.add(i,p2);
                   players.add(i+1,p1);
                }
            }
        }
        if(players.get(0).getScore()>players.get(1).getScore())
            return players.get(0);
        else {
            int k=0;
            for (int i=0;i< players.size()-1;i++){
                if(players.get(i).getScore()==players.get(i+1).getScore())
                    k+=1;
                else break;
            }
            for(int j=0;j<k;j++){
            for (int i=0;i<k;i++){
                if(players.get(i).getSteps()>players.get(i+1).getSteps()){
                    Player p1=players.get(i);
                    Player p2=players.get(i+1);
                    players.remove(i);
                    players.remove(i);
                    players.add(i,p2);
                    players.add(i+1,p1);
                }
            }}
            return players.get(0);
        }
    }
}
