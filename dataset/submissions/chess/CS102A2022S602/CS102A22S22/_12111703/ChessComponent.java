import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source; // Where the chess is
    private ChessColor chessColor; // What's the color
    protected char name; // What's the name
    public ChessComponent(){
    }
    public abstract List<ChessboardPoint> canMoveTo();
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public void setSource(int x, int y) {
        ChessboardPoint chessboardPoint=new ChessboardPoint(x, y);
        this.source = chessboardPoint;
    }
    public void setSource(ChessboardPoint chessboardPoint) {

        this.source = chessboardPoint;
    }
    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }
}
