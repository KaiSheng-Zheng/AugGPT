import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    protected ChessComponent[][] chessBoard;

    //should design
    public ChessComponent(){}

    public ChessComponent(ChessboardPoint source,ChessColor chessColor,char name){
        this.chessColor = chessColor;
        this.source = source;
        this.name = name;
    }
    public ChessboardPoint getSource() {
        return source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    // should design
    public abstract List<ChessboardPoint> canMoveTo();


    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    public void setChessBoard(ChessComponent[][] chessComponents) {
        chessBoard = chessComponents;
    }
}

