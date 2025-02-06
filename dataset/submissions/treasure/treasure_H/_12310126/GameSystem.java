public class GameSystem {
    private Player[] players =new Player[0];
    private Treasure[] treasures;


    private int count=1;
    public void addPlayer(Player player){
        Player[] passingPlayers =new Player[players.length];
        System.arraycopy(players, 0, passingPlayers, 0, players.length);
        players =new Player[players.length+1];
        System.arraycopy(passingPlayers, 0, players, 0, players.length - 1);
        players[players.length-1]=player;
        players[players.length-1].setId(count);
        count++;
    }
    public Map newGame(int rows,int columns,Treasure...treasures){
        return new Map(rows,columns,treasures);
    }
    public Player getWinner(){
        int[] scores=new int[players.length];
        int[] ids =new int [players.length];
        for(int i=0;i< players.length;i++){
            ids[i] =i;
        }
        int max =0;

        for(int i =0;i<players.length;i++){
            scores[i]=players[i].getScore();
        if(players[i].getScore()>max){
            max =players[i].getScore();

        }

    }
        for(int i =0;i< players.length;i++){
            for(int j=i;j<players.length;j++){
                if(scores[i]<scores[j]
                        ||(scores[i]==scores[j]&&players[ids[i]].getSteps()>players[ids[j]].getSteps())){
                    int mid =scores[j];
                    int mid0 =ids[j];
                    scores[j] =scores[i];
                    ids[j]=ids[i];
                    scores[i]=mid;
                    ids[i]=mid0;
                }

            }
        }
        return players[ids[0]];

    }
}