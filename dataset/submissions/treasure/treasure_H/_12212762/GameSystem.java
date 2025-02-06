import java.util.ArrayList;

public class GameSystem {
    private ArrayList<Player> playerArrayList=new ArrayList<>();

    public void addPlayer(Player player){
        playerArrayList.add(player);
    }

    public ArrayList<Player> getPlayerArrayList() {
        return playerArrayList;
    }

    public Map newGame(int rows,int columns,Treasure[] treasures){
        Map map=new Map(rows,columns,treasures);
        return map;
    }

    public Player getWinner(){
        ArrayList<Player> Winner =new ArrayList<>();
        int pos=0;
        for(int i=0;i< playerArrayList.size()-1;i++){
                for(int k=i+1;k< playerArrayList.size();k++) {
                     if (playerArrayList.get(i).getScore() < playerArrayList.get(k).getScore()) {
                     break;
                     }
                     if (k == playerArrayList.size() - 1) {
                     pos = i;
                     Winner.add(playerArrayList.get(i));
                     }
                 }
        }
        if(Winner.size()==1){
            return Winner.get(0);
        }else if(Winner.size()==2){
            if(Winner.get(0).getSteps()>Winner.get(1).getSteps()){
                return Winner.get(1);
            }else return Winner.get(0);
        }
        for(int i=0;i< Winner.size()-1;i++){
            for(int k=i+1;k< Winner.size();k++){
                if(Winner.get(i).getSteps()>Winner.get(k).getSteps()){
                    break;
                }
                if(k== Winner.size()-1){
                    return Winner.get(i);
                }
            }
        }
        return playerArrayList.get(0);
    }
}
