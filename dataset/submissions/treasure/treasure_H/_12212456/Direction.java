public enum Direction {
    UP(0,-1),
    DOWN(0,1),
    LEFT(-1,0),
    RIGHT(1,0);
    private final int addCol;
    private final int addRow;
    private Direction(int a,int b){
        addCol=a;
        addRow=b;
    }

    public int getAddRow() {
        return addRow;
    }

    public int getAddCol() {
        return addCol;
    }
}
