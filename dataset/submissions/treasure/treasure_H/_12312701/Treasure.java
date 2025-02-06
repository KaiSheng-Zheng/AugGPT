public class Treasure {
    private final int score;
    private final Position position;

    public Treasure(int score, Position position) {
        this.score = score;
        this.position = new Position(position);
        //this.position = position;
    }

    public Treasure(Treasure treasure) {
        score = treasure.score;
        //position = new Position(treasure.position);
        position = treasure.position;
    }

    public int getScore() {
        return score;
    }

    public Position getPosition() {
        return position;
    }

    public static boolean hasBiggerPosition(Treasure treasure1, Treasure treasure2) {
        return Position.isBigger(treasure1.position, treasure2.position);
    }
}
