import java.util.ArrayList;

public class GameSystem {
        private ArrayList<Player> players = new ArrayList<>();
        private Map map;

        public void addPlayer(Player player){
            players.add(player);

        }

        public Map newGame(int rows, int columns, Treasure... treasures) {
            this.map = new Map(rows, columns, treasures);
            return map;
        }

        public Player getWinner() {
            int maxscore = Integer.MIN_VALUE; int sum = 0;int minsteps = Integer.MAX_VALUE;
            for (int i = 0; i < players.size(); i++) {
                if (players.get(i).getScore() > maxscore) {
                    maxscore = players.get(i).getScore();
                }
            }
            for (int i = 0; i < players.size(); i++) {
                if((players.get(i).getScore() == maxscore)){
                    sum++;
                }
            }
            if(sum == 1){
                for (int i = 0; i < players.size(); i++) {
                    if(players.get(i).getScore() == maxscore){
                        return players.get(i);
                    }
                }
            }
            for (int i = 0; i < players.size(); i++) {
                if((players.get(i).getSteps() < minsteps) && (players.get(i).getScore() == maxscore)){
                    minsteps = players.get(i).getSteps();
                }
            }
            for (int i = 0; i < players.size(); i++) {
                if((players.get(i).getScore() == maxscore) && (players.get(i).getSteps() == minsteps)){
                    return players.get(i);
                }
            }
            return players.get(0);
        }
    }





