import java.util.ArrayList;
public class Treasure {
//    private static int count;
    private final int score;
    private final Position position;
    private boolean valid=true;
    public Treasure(int score,Position position){
        this.score=score;
        this.position=position;
//        count++;
    }
//    public Treasure(){count++;}

//    public static int getCount() {
//        return count;
//    }

    public int getScore() {
        return score;
    }

    public Position getPosition() {
        return position;

    }

    public void setValid() {
        valid = false;
    }

    public boolean getValid(){
        return valid;
    }

}
