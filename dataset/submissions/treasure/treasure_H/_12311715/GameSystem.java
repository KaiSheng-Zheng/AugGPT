import java.util.ArrayList;
import java.util.List;
public class GameSystem {
	private List<Player> players;

	public GameSystem() {
		players = new ArrayList<>();
	}

	public void addPlayer(Player player) {
		players.add(player);
	}

	public Map newGame(int rows, int columns, Treasure... treasures) {
		Map map = new Map(rows, columns, treasures);
		return map;
	}

	public Player getWinner() {
		if (players.isEmpty()) {

			
			return null;
		}

		Player winner = players.get(0);

		for (Player player : players) {
			if (player.getScore() > winner.getScore() ||
					(player.getScore() == winner.getScore() && player.getSteps() < winner.getSteps())) {
				winner = player;
			}
		}
		return winner;
	}

}
