public enum Direction {
    UP(-1,true),
    DOWN(1,true),
    LEFT(-1,false),
    RIGHT(1,false);
    private final int len;
    private final boolean direct;
    private Direction(int len,boolean direct){
        this.len=len;
        this.direct=direct;
    }

    public int getLen() {
        return this.len;
    }

    public boolean isDirect() {
        return this.direct;
    }
}
