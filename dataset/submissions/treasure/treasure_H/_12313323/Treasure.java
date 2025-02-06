import java.util.*;
public class Treasure {

    public int getScore() {
        return score;
    }

    private final int score;

    public Position getPosition() {
        return position;
    }
    public static int [][]xunBaoTu;
    private final Position position;
    public Treasure(int score, Position position){
        this.position=position;
        this.score=score;
    }

}


