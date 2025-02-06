import java.util.List;
import java.util.ArrayList;

abstract public class ChessComponent {
	private ChessboardPoint source;
	private ChessColor chessColor;
	protected char name;

	public ChessComponent() {
	}

	public abstract List<ChessboardPoint> canMoveTo();

	public ChessboardPoint getPoint() {
		return source;
	}

	public ChessColor getColor() {
		return chessColor;
	}

	public String toString() {
		return String.valueOf(this.name);
	}

	public void Setsource(ChessboardPoint s) {
		source = s;
	}

	public void Setcolor(ChessColor c) {
		chessColor = c;
	}

}
