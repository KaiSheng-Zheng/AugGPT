import java.util.Iterator;
import java.util.List;

public abstract class ChessComponent {
    protected char name;
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;

    //should design
    public ChessComponent() {
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public abstract List<ChessboardPoint> canMoveTo();

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    public void moveTo(ChessboardPoint target) {

    }

    public boolean canMove(ChessComponent[][] chess, int x, int y) {
        return true;
    }

    public ChessColor getSide() {
        return chessColor;
    }


}
