import java.util.*;

public class Position {
    private int row;
    private int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public boolean equals(Object position) {
        if (position instanceof Position) {
            Position p = (Position) position;
            return this.row == p.row && this.col == p.col;
        }
        return false;
    }

    // getters and setters
    public int getRow() { return row; }
    public int getCol() { return col; }
    public void setRow(int row) { this.row = row; }
    public void setCol(int col) { this.col = col; }
}
