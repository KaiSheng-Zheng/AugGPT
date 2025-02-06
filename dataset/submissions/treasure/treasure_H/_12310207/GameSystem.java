import java.util.ArrayList;

public class GameSystem {
    private ArrayList<Player> gradeList = new ArrayList<>();
    private ArrayList<Player> stepList = new ArrayList<>();
    public void addPlayer(Player player){
        gradeList.add(player);
    }
    public Map newGame(int rows, int columns, Treasure...treasures){
        if (!stepList.isEmpty()){stepList.clear();}
        if (!gradeList.isEmpty()){gradeList.clear();}
        return new Map(rows,columns,treasures);
    }
    public Player getWinner(){
        for (int i = 0; i < gradeList.size()-1; i++) {
            for (int j = i+1; j < gradeList.size(); j++) {
                if (gradeList.get(i).getScore() > gradeList.get(j).getScore()){
                    Player win =gradeList.get(i);
                    gradeList.set(i,gradeList.get(j));
                    gradeList.set(j,win);
                }
            }
        }
        for (int i = 0; i < gradeList.size(); i++) {
            if (gradeList.get(i).getScore() == gradeList.get(gradeList.size()-1).getScore()){
                stepList.add(gradeList.get(i));
            }
        }
        if (stepList.isEmpty()){
            return gradeList.get(0);
        }
        else {
            for (int i = 0; i < stepList.size()-1; i++) {
                for (int j = i+1; j < stepList.size(); j++) {
                    if (stepList.get(i).getSteps() > stepList.get(j).getSteps()){
                        Player win = stepList.get(i);
                        stepList.set(i,stepList.get(j));
                        stepList.set(j,win);
                    }
                }
            }
            return stepList.get(0);
        }
    }
}
