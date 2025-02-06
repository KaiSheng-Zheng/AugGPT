public class Treasure {
    private final int score;
    private  final  Position position ;

    public Treasure(int score, Position position) {
        this.score = score;
        this.position = position;
    }
    public int getScore(){
        return score;
    }
    public Position getPosition(){
        return position;
    }
    public String toString() {
        return "Treasure{score = " + score + ", position = " + position + "}";
    }
}
