public enum Direction {
    UP(1),
    DOWN(2),
    LEFT(3),
    RIGHT(4);
    private int num;

    Direction(int i) {
        num=i;
    }
    public int getNum(){
        return num;
    }
}
