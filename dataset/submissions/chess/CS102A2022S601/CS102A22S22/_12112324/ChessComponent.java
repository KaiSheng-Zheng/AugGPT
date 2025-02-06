import java.util.List;
public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    public ChessComponent(){
    }
    public void setChessboardPoint(ChessboardPoint chessboardPoint){
        source=chessboardPoint;
    }
    public ChessColor getChessColor(){
        return chessColor;
    }
    public abstract List<ChessboardPoint> canMoveTo();
    public void setChessComponent(ChessComponent[][] chessComponent){}
    public ChessComponent[][] getChessComponent(){
        return null;
    }
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}