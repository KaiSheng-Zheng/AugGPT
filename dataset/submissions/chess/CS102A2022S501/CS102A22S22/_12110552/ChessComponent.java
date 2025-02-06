import java.util.List;

public abstract class ChessComponent {
    ChessboardPoint source;
    ChessColor chessColor;
    protected char name;
    protected ChessComponent[][] chessboard;

    public ChessComponent(){}
    public ChessComponent(ChessboardPoint source,ChessColor chessColor,char name){
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
    }
    public void setChessboard(ChessComponent[][] chessboard) {
        this.chessboard = chessboard;
    }
    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }
    public ChessComponent[][] getChessboard() {
        return chessboard;
    }
    public ChessColor getChessColor() {
        return chessColor;
    }

    public abstract List<ChessboardPoint> canMoveTo();

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}
