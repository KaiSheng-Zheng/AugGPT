public enum Direction {
//    private int number;
    LEFT_UP(0),
    LEFT_DOWN(1),
    RIGHT_UP(2),
    RIGHT_DOWN(3);
    private int number;
//    public static final Direction LEFT_UP=new Direction(0);
//    public static final Direction LEFT_DOWN=new Direction(1);
//    public static final Direction RIGHT_UP=new Direction(2);
//    public static final Direction RIGHT_DOWN=new Direction(3);
    private Direction(int a){
        number=a;
    }

    public int getNumber() {
        return number;
    }
}
