import java.util.ArrayList;

public class GameSystem {
    private ArrayList<Player> players=new ArrayList<>();

    public GameSystem(ArrayList<Player> players) {
        this.players = players;
    }
    public GameSystem() {}


    public void addPlayer(Player player){
        players.add(player);
    }
    public Map newGame(int rows, int columns, Treasure... treasures){
        return new Map(rows,columns,treasures);
    }
    public Player getWinner(){
        int maxscore=players.get(0).getScore();
        for (Player p: players) {
            if (p.getScore()>maxscore){
                maxscore=p.getScore();
            }
        }
        ArrayList<Player> winners = new ArrayList<>();
        for (Player p: players) {
            if(p.getScore()==maxscore){
                winners.add(p);}
        }
        if (winners.size()!=1){
            int minsteps=winners.get(0).getSteps();
            for (Player p: winners) {
                if (p.getSteps()<minsteps){
                    minsteps=p.getSteps();
                }
            }
            for (Player p:winners) {
                if (p.getSteps()==minsteps){
                    return p;
                }
            }
        }
        return winners.get(0);}
}
