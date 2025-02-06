import java.util.List;
public abstract class ChessComponent {
    ChessboardPoint source;
    ChessColor chessColor;
    protected char name;
    public ChessComponent(ChessColor chessColor,ChessboardPoint source,char name) {
        this.chessColor = chessColor;this.source = source;this.name = name;
     }

    public ChessComponent(){}



    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public abstract List<ChessboardPoint> canMoveTo();
    @Override
    public String toString() {
        return  String.valueOf(name);
    }
    ChessComponent[][] chessBoard;
    void loadCurrentChessboard(ChessComponent[][] chessBoard){
        this.chessBoard=chessBoard;
    }

}

