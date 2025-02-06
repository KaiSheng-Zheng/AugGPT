import java.util.List;

public abstract class ChessComponent {
    //should design
    protected ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    protected ChessComponent[][] chessBoard;
    //should design
    public ChessComponent(){}

    public ChessComponent(ChessboardPoint chessboardPoint, ChessColor chessColor){
        this.source = chessboardPoint;
        this.chessColor = chessColor;
    }

    public void setChessBoard(ChessComponent[][] chessBoard) {
        this.chessBoard = chessBoard;
    }

    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }


    public ChessColor getChessColor() {
        return chessColor;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public Boolean yuejie(int x,int y){
        if (x < 8 && y < 8 && x >= 0 && y >= 0 ){
            return true;
        }else {
            return false;
        }
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }
}
