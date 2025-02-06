import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
private ChessColor chessColor;
protected char name;
public ChessComponent(){}

    public abstract List<ChessboardPoint> canMoveTo();

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }
    @Override
public String toString() {
    return String.valueOf(this.name);
}

    public ChessboardPoint getSource() {
        return source;
    }
    public ChessColor getChessColor() {
        return chessColor;
    }
    public void setSource(int x,int y) {
        ChessboardPoint a=new ChessboardPoint(x, y);
        this.source=a;
    }
}
