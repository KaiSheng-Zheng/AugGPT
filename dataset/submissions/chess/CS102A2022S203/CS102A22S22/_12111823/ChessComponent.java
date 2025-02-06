import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    protected ChessboardPoint getSource(){
        return this.source;
    }

    protected void setSource(int x, int y){
        this.source = new ChessboardPoint(x,y);
    }

    public ChessComponent(){
    }

    public abstract List<ChessboardPoint> canMoveTo();

    protected ChessColor getChessColor(){
        return this.chessColor;
    }

    protected void setChessColor(ChessColor chessColor){
        this.chessColor=chessColor;
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}
