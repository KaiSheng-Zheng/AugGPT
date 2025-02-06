/**
 * Position
 */
public class Position{
    private int row;
    private int col;

    /* Constructor */
    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    /* Check if positions equal */
    public boolean equals(Object position) {
        if (position instanceof Position) {
            Position p = (Position) position;
            return this.row == p.getRow() && this.col == p.getCol();
        }
        return false;
    }

    /*
     * Getters and setters
     */
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
}