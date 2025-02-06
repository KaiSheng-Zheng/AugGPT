public class Treasure {
    private final int score;
    private final Position position;

    public Treasure (int score, Position position) {
        this.score = score;
    //    Position a = new Position(position.getRow(), position.getCol());
        this.position = position;
    }

    public int getScore () {
        return score;
    }

    public Position getPosition () {
        return position;
    }
}
