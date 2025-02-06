import java.util.List;

public abstract class ChessComponent {

    private ChessboardPoint source = new ChessboardPoint(0,0);
    private ChessColor chessColor;
    protected char name;

    public ChessComponent() {}

    public abstract List<ChessboardPoint> canMoveTo();

    public void setSource(int x, int y) {
        source.setX(x);
        source.setY(y);
    }

    public void setChessColor(char x) {
        if (x>=97 && x<=122) {
            chessColor = ChessColor.WHITE;
        }
        else if (x>=65 && x<=90) {
            chessColor = ChessColor.BLACK;
        }
        else {
            chessColor = ChessColor.NONE;
        }
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    @Override
    public String toString() {
        return String.valueOf(name);
    }
}