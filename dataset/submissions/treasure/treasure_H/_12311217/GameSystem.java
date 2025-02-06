import java.util.ArrayList;


public class GameSystem {
    private ArrayList<Player> playerList=new ArrayList<>();

    public ArrayList<Player> getPlayerList(){
        return this.playerList;
    }
    public boolean checkPlayer(int pid){
        boolean flag=false;
        for (int i = 0; i < playerList.size(); i++) {
            if(playerList.get(i).getId()==pid){
                flag=true;
            }
        }

        return flag;
    }
    public boolean addPlayer(Player player){

        int id=player.getId();
        boolean flag=true;
        for (int i = 0; i < playerList.size(); i++) {
            if(playerList.get(i).getId()==id){
                flag=false;
            }
        }
        if(flag){
            playerList.add(player);
        }
        return flag;
    }
    public Map newGame(int row,int col,Treasure... treasure){
            Map map=new Map(row,col,treasure);
            return map;
    }
    public Player getWinner(){
        int max=playerList.get(0).getScore();
        int winnerNode=0;
        for (int i = 0; i < playerList.size(); i++) {
            if(playerList.get(i).getScore()>max){
                max=playerList.get(i).getScore();
                winnerNode=i;
            }
            if(playerList.get(i).getScore()==max&&playerList.get(i).getSteps()<playerList.get(winnerNode).getSteps()){
                winnerNode=i;
            }
        }
        return playerList.get(winnerNode);
    }

    public void setPlayerList(ArrayList<Player> playerList) {
        this.playerList = playerList;
    }
}
