import java.util.ArrayList;

class GameSystem {
    ArrayList<Player> players=new ArrayList<Player>();
    ArrayList<Map> maps;

    public void addPlayer(Player player){
        players.add(player);
    }

    public Map newGame(int rows, int columns, Treasure... treasures){
        ArrayList<Treasure> treasures2=new ArrayList<Treasure>();

        for(Treasure tre: treasures) {
            treasures2.add(tre);
        }
        Treasure[] treasures1=new Treasure[treasures2.size()];
        for (int n=0;n<=treasures2.size()-1;n++){
            treasures1[n]=treasures2.get(n);
        }
        Map map1=new Map(rows,columns,treasures1);
        Player.setTheID(0);
        return map1;
    }

    public Player getWinner(){
        Player theWinner=players.get(0);
        for (int n=0;n<=players.size()-1;n++){
            if(players.get(n).getScore()>theWinner.getScore()){
                theWinner=players.get(n);
            }
            else if (players.get(n).getScore()==theWinner.getScore()){
                if(players.get(n).getSteps()<theWinner.getSteps()){
                    theWinner=players.get(n);
                }
            }
        }
        return theWinner;
    }
}
