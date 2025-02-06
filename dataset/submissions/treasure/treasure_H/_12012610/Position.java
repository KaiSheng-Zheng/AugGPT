
public class Position {
    private int row;
    private int col;

    // Constructor
    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    // Getter and Setter for row
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    // Getter and Setter for col
    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    // Equals method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Position position = (Position) obj;
        return row == position.row && col == position.col;
    }
}
