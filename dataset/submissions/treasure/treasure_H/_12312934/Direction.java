public enum Direction {
    UP(0),DOWN(1),LEFT(2),RIGHT(3);
    private final int d;
    private Direction(int d){
        this.d = d;
    }

    public int getD() {
        return d;
    }
}
