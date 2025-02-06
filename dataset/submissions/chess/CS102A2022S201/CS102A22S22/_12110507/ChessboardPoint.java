public class ChessboardPoint {
	private int x, y;

	public ChessboardPoint(int X, int Y) {
		x = X;
		y = Y;
	}
	public ChessboardPoint() {
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public String toString() {
		return "(" + x + ',' + y + ')';
	}

	public ChessboardPoint offset(int dx, int dy) {
		if (x + dx < 0 || x + dx > 7 || y + dy < 0 || y + dy > 7)
			return null;
		return new ChessboardPoint(x + dx, y + dy);
	}

}