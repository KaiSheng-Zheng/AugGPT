import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    public ChessComponent()
    {
        this.name='_';
    }
    public ChessComponent(ChessboardPoint source,ChessColor chessColor,char name)
    {
        this.source=source;
        this.chessColor=chessColor;
        this.name=name;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public abstract List<ChessboardPoint> canMoveTo(ChessComponent[][] chessComponents);
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}
