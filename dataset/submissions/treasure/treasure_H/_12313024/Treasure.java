public class Treasure {
    private final int score;
    private final Position position;
    public Treasure (int sc, Position pos) {
        score = sc;
        position = pos;
    }
    public int getScore () {
        return score;
    }
    public Position getPosition () {
        return position;
    }
}