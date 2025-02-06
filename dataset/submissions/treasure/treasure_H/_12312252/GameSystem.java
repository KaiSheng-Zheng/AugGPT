import java.util.ArrayList;
public class GameSystem {
        private ArrayList<Player> players;
        private Position position;
        private Treasure[] treasures;

        public GameSystem() {
            players = new ArrayList<>();
        }

        public void addPlayer(Player player) {
            players.add(player);
        }

        public Map newGame(int rows, int columns, Treasure... treasures) {
            position = new Position(rows, columns);
            return new Map(rows, columns, treasures);
        }

        public Player getWinner() {
            int score = -1, step = Integer.MAX_VALUE;
            Player winner = new Player(new Map(1,1,treasures), new Position(0, 0));
            for (Player p : players
            ) {
                if(p.getScore() > score)
                {
                    winner = p;
                    score = p.getScore();
                }
            }
            for (Player p : players
            ) {
                if(p.getScore() == score && (p.getSteps() < step)) {
                    step = p.getSteps();
                    winner = p;
                }
            }
            return winner;
        }
    }