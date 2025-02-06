import java.util.*;


public class GameSystem {

    ArrayList<Player> pb=new ArrayList<>();
    ArrayList<Integer> findMax=new ArrayList<>();

    public GameSystem(){}
    public void addPlayer(Player player){
        this.pb.add(player);
    }

    public Map newGame (int rows, int columns, Treasure... treasures){
        return new Map(rows,columns,treasures);
    }
    public Player getWinner(){
        for(int i=0;i< pb.size();i++){
            findMax.add(pb.get(i).getScore());
        }
        int maxNum=findMax.indexOf(Collections.max(findMax));
        int max=Collections.max(findMax);
        findMax.set(maxNum,-1);
        ArrayList <Integer> arr2= new ArrayList<>();

        int max2=Collections.max(findMax);
        int maxNum2=findMax.indexOf(Collections.max(findMax));
        if(max==max2){
            if(pb.get(maxNum).getSteps()>pb.get(maxNum2).getSteps()){
                return pb.get(maxNum2);
            }
            if(pb.get(maxNum).getSteps()<pb.get(maxNum2).getSteps()){
                return pb.get(maxNum);
            }
        }
        return pb.get(maxNum);
    }




}
