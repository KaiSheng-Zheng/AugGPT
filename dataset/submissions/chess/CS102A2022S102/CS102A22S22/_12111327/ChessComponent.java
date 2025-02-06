import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    //should design
    public ChessComponent() {

    }

    public ChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
    }

    protected boolean addToList(int x, int y, List<ChessboardPoint> list) {
        if (x >= 0
                && x < 8
                && y >= 0
                && y < 8) {
            list.add(new ChessboardPoint(x, y));
            return true;
        } else
            return false;
    }

    public abstract List<ChessboardPoint> canMoveTo();

    public ChessboardPoint getSource() {
        return source;
    }

    @Override
    public String toString() {
        return String.valueOf(name);
    }

    public ChessColor getChessColor() {
        return chessColor;
    }
}
