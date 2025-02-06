import java.util.List;

public class KnightChessComponent extends ChessComponent {
    //Variables
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    //Constructor
    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source, chessColor);
        if (chessColor == ChessColor.BLACK)
            name = 'N';
        else
            name = 'n';
    }

    public KnightChessComponent(ChessboardPoint source, char name) {
        super(source, name);
        if (name == 'N')
            chessColor = ChessColor.BLACK;
        else
            chessColor = ChessColor.WHITE;
    }

    //Methods
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    //Methods
    public ChessboardPoint getSource() {
        return source;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }
}
