import java.util.List;
public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    public ConcreteChessGame belonging;

    public ChessComponent(){}
    public abstract List<ChessboardPoint> canMoveTo();

    public void setChessColor(ChessColor chessColor){
        this.chessColor = chessColor;
    }

    public ChessboardPoint getSource(){
        return source;
    }
    public ChessColor getChessColor(){
        return chessColor;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}
