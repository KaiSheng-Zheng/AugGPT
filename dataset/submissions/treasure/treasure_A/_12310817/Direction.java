public enum Direction {
    UP(-1,0),DOWN(1,0),LEFT(0,-1),RIGHT(0,1);
    private int rowStep;
    private int colStep;
    Direction(int rowStep,int colStep){
        this.rowStep=rowStep;this.colStep=colStep;
    }
    public int getRowStep() {
        return rowStep;
    }
    public int getColStep() {
        return colStep;
    }
}
