public class GameSystem {
 Player[] playerstore=new Player[100000];
   int playercount;
    public void addPlayer(Player player){
        playerstore[playercount]= player;
        playercount++;
    }
    public Map newGame(int rows, int columns, Treasure[] treasures){
        return new Map(rows,columns,treasures);
    }
    public Player getWinner(){
        int index=0;
        for (int i = 1; i < playercount-1; i++) {
            if (playerstore[i].getScore()>playerstore[index].getScore()){
              index=i;
            } else if (playerstore[i].getScore()==playerstore[index].getScore()){
                index=(playerstore[i].getSteps() >= playerstore[index].getSteps())? index:i;
            }
        }
        return playerstore[index];
    }
}