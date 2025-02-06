


import java.util.ArrayList;

public class GameSystem {
    public ArrayList<Player> getGradeboard() {
        return gradeboard;
    }

    private ArrayList<Player> gradeboard = new ArrayList<>();

    public ArrayList<Player> getStepsboard() {
        return stepsboard;
    }

    private ArrayList<Player> stepsboard = new ArrayList<>();

    public void addPlayer(Player player) {
        gradeboard.add(player);
        player.status = true;
    }

    public Map newGame(int rows, int columns, Treasure... treasures) {
        for (int i=0;i<stepsboard.size();i++){
            stepsboard.get(i).setScore(0);
            stepsboard.get(i).setSteps(0);
        }
        return new Map(rows, columns, treasures);
    }

    public Player getWinner(){
//        for (int i = 0; i <  stepsboard.get(0).getMap().map.length; i++) {
//            for (int j = 0; j <  stepsboard.get(0).getMap().map[i].length; j++) {
//                stepsboard.get(0).getMap().map[i][j] = 0;
//            }
//        }

        for (int i = 0; i < gradeboard.size() - 1; i++) {
            for (int j = i + 1; j < gradeboard.size(); j++) {
                if (gradeboard.get(i).getScore() < gradeboard.get(j).getScore()) {
                    Player temp = gradeboard.get(i);
                    gradeboard.set(i, gradeboard.get(j));
                    gradeboard.set(j, temp);
                }
            }
        }
        stepsboard.add(gradeboard.get(0));
        for (int i = 0; i < gradeboard.size(); i++) {
            if (gradeboard.get(0).getScore() == gradeboard.get(i).getScore()) {
                stepsboard.add(gradeboard.get(i));
            }
        }
//        if (gradeboard.get(0)!=gradeboard.get(1)){
//            return gradeboard.get(0);
//        }else {

        if (stepsboard.size() == 0) {
            return gradeboard.get(0);
        } else {
            for (int i = 0; i < stepsboard.size() - 1; i++) {
                for (int j = i + 1; j < stepsboard.size(); j++) {
                    if (stepsboard.get(i).getSteps() > stepsboard.get(j).getSteps()) {
                        Player temp = stepsboard.get(i);
                        stepsboard.set(i, stepsboard.get(j));
                        stepsboard.set(j, temp);
                    }
                }
            }
            return stepsboard.get(0);
        }

    }
}

