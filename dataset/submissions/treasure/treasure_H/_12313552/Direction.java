public enum Direction {
    UP("UP"),DOWN("DOWN"),LEFT("LEFT"),RIGHT("RIGHT");

    private final String Direction;
    private Direction(String direction){
        Direction = direction;
    }
    public String getDirection(){
        return Direction;
    };

}