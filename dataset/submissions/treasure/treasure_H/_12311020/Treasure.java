public class Treasure {
private final int score;
private final Position position;
    public static int treasureNum = 0;



    public Treasure(int score, Position position) {
        this.score = score;
        this.position = position;
        treasureNum += 1;
    }
    public static int getTreasureNum() {
        return treasureNum;
    }

    public Position getPosition() {
        return position;
    }

    public int getScore() {
        return score;
    }

}
