import java.util.ArrayList;
import java.util.List;

    public class EmptySlotComponent extends ChessComponent {
    private ChessboardPoint source; // Where the chess is
    private char name = '_';			// What's the name
    public ChessColor chessColor = ChessColor.NONE;

    public EmptySlotComponent( ChessboardPoint p) {
        source = p;
    }



    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }

    public char getName(){return name;}

    public ChessColor getChessColor(){return this.chessColor;}

    public String toString() {
            return String.valueOf(this.name);
        }
}
