import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GameSystem {

    private List<Player> players = new ArrayList<>();

    public void addPlayer(Player player){
        players.add(player);
    }

    public Map newGame(int rows, int columns, Treasure... treasures){
        return new Map(rows,columns,treasures);
    }

    public Player getWinner(){
        players.sort(new ScoreCompare());
        Player winner = players.get(players.size()-1);
        return winner;
    }
    public static void main(String[] args) {
        GameSystem game = new GameSystem();
        Treasure[] treasures = new Treasure[4];
        treasures[0] = new Treasure(5, new Position(0,1));
        treasures[1] = new Treasure(10, new Position(0,2));
        treasures[2] = new Treasure(2, new Position(0,4));
        treasures[3] = new Treasure(15, new Position(1,3));
        Map map = game.newGame(3,5, treasures);
        Player player1 = new Player(map, new Position(0,0));
        Player player2 = new Player(map, new Position(1,4), 4);
        Player player3 = new Player(map, new Position(0,3));
        game.addPlayer(player1);
        game.addPlayer(player2);
        game.addPlayer(player3);
        player1.move(Direction.DOWN, 2);
        player1.move(Direction.RIGHT, 2);
        player1.move(Direction.UP, 4);

        player2.move(Direction.LEFT, 2);
        player2.move(Direction.UP,1);
        player1.move(Direction.LEFT, 3);

        player2.move(Direction.RIGHT, 2);
        player3.move(Direction.RIGHT,1);
        player3.move(Direction.DOWN, 2);

        assert(player1.getSteps() == 8);
        assert(player1.getPosition().equals(new Position(0,0)));
        assert(player1.getScore() == 15);

        assert(player2.getSteps() == 4);
        assert(player2.getPosition().equals(new Position(0,3)));
        assert(player2.getScore() == 15);

        assert(player3.getSteps() == 1);
        assert(player3.getPosition().equals(new Position(0,4)));
        assert(player3.getScore() == 2);

        Player winner = game.getWinner();
        assert(winner.equals(player2));
    }

}
    

class ScoreCompare implements Comparator<Player> {
    @Override
    public int compare(Player o1, Player o2) {

        int i = o1.getScore() - o2.getScore();
        if(i==0){
            i = o2.getSteps() - o1.getSteps();
        }
        return i;
    }
}
