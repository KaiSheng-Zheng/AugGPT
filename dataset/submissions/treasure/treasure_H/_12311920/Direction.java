public enum Direction {
    UP(-1 , 0) , DOWN(1 , 0) , LEFT(0 , -1) , RIGHT(0 , 1);
    public int add_row;
    public int add_col;

    Direction(int add_row, int add_col){
        this.add_row = add_row;
        this.add_col = add_col;
    }
}
