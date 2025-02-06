import java.util.*;
public abstract class ChessComponent{
	public ChessboardPoint source; // Where the chess is
	public ChessColor chessColor;  // What's the color
	public char name;			// What's the name
	public ChessComponent(){
	}
	public abstract List<ChessboardPoint> canMoveTo();
	//@Override
	public String toString() {
		return String.valueOf(this.name);
	}
}