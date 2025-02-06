import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
    protected ChessColor chessColor;
    protected char name;

    protected ChessComponent[][] chessComponents=new ChessComponent[8][8];
    public ChessComponent(){
    }

    public ChessComponent[][] getChessComponents(){
        return this.chessComponents;
    }

    protected ChessComponent(ChessboardPoint source,ChessColor chessColor){
        this.source=source;
        this.chessColor=chessColor;
    }

    public ChessComponent(ChessColor chessColor, ChessboardPoint chessboardPoint) {
        this.source=chessboardPoint;
        this.chessColor=chessColor;
    }

    public ChessboardPoint getChessboardPoint() {
        return this.source;
    }


    public ChessColor getChessColor() {
        return chessColor;
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    public abstract List<ChessboardPoint> canMoveTo();

}
