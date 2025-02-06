public class Treasure {
    private final int score;
    private final Position position;
    private static int number;
    public Treasure(int score, Position position){
        this.score=score;
        this.position=position;
        number++;
    }

    public static int getNumber() {
        return number;
    }

    public static void setNumber(int number) {
        Treasure.number = number;
    }

    public int getScore() {
        return score;
    }

    public Position getPosition() {
        return position;
    }
}
