public class Position {
	private int row;
	private int col;

	public Position(int row, int col) {
		this.row = row;
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	public boolean equals(Object position) {
		if (position == this) {
			return true;
		}
		if (!(position instanceof Position)) {
			return false;
		}
		Position p = (Position) position;
		return this.row == p.row && this.col == p.col;
	}
}
