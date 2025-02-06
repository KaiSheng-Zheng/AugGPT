public class Treasure {
    private final int score;
    private final Position position;
    public Treasure(int score,Position position){
        this.score=score;
        this.position=position;
    }
    public int getScore(){return score;};
    public Position getPosition(){return position;}
    public boolean equals(Object treasure) {
        if(this==treasure)return true;
        return (treasure instanceof Treasure aTreasure)
                && (this.position.equals(aTreasure))
                && (this.score==aTreasure.score);
    }
}