public class GameSystem{
    private List<Player> players;

    public GameSystem() {
        this.players = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public Map newGame(int rows, int columns, Treasure... treasures) {
        Map map = new Map(rows, columns, treasures);
        return map;
    }

    public Player getWinner() {
        return players.stream()
                .max(Comparator.comparing(Player::getScore)
                        .thenComparing(Player::getSteps))
                .orElse(null);
    }
}