

public enum Direction {
    RIGHT(new Position(0,1)),
    UP(new Position(-1,0)),
    LEFT(new Position(0,-1)),
    DOWN(new Position(1,0));
    Position vector;
    private Direction(Position vector){
        this.vector=vector;
    }
}
