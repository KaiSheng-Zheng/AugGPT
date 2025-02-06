import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    protected ChessComponent[][] chessboard;

    public ChessComponent(ChessComponent[][] chessboard){
        this.chessboard = chessboard;
    }

    public ChessComponent(){}

    public ChessComponent(char name, int x, int y){
        this.name = name;
        ChessboardPoint source = new ChessboardPoint(x, y);
        if (name >= 97 && name <= 122){
            chessColor = ChessColor.WHITE;
        }
        if (name >= 65 && name <= 90){
            chessColor = ChessColor.BLACK;
        }
    }

    public abstract List<ChessboardPoint> canMoveTo();

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}
