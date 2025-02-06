import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source = new ChessboardPoint(0,0);
    private ChessColor chessColor;
    protected char name;
    public ChessComponent(){
    }
    public abstract List<ChessboardPoint> canMoveTo();

    public ChessboardPoint getSource() {
        return source;
    }

    public void setSource(int x,int y) {
        this.source.setX(x);
        this.source.setY(y);
    }

    public ChessColor getChessColor() {
        return chessColor;
    }


    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}

