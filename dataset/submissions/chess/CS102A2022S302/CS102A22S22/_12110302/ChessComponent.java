import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
    protected ChessColor chessColor;
    protected char name;
    protected  ChessComponent[][] chessBoard;
    PriSort priSort = new PriSort();
    public ChessComponent(){
    }

    public void setChessBoard(ChessComponent[][] chessComponents){
        chessBoard=chessComponents;
    }

    public abstract List<ChessboardPoint> canMoveTo();
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    public ChessColor getChessColor(){
        return chessColor;
    }

    public ChessboardPoint getSource(){
        return source;
    }

    public void setSource(ChessboardPoint target){
        this.source=target;
    }
}