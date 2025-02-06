public enum Direction
{
    UP(-1,0),DOWN(1,0),LEFT(0,-1),RIGHT(0,1);
    final int row;
    final int col;

    Direction(int row, int col) {
        this.col = col;
        this.row = row;
    }
}
