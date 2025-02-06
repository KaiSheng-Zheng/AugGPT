import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    protected ChessColor chessColor;
    protected  ChessComponent[][] chessPieces;
    protected char name;
    Presort presort = new Presort();
    public void setChessPieces(ChessComponent[][] chessComponents){
        chessPieces=chessComponents;
    }
    public ChessComponent(){}

    public abstract List<ChessboardPoint> canMoveTo();

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    public ChessColor chessColor() {
        return chessColor;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public void setSource(ChessboardPoint target){
        this.source=target;
    }
}
