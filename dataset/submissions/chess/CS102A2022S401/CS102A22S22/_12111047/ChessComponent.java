import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    public ChessComponent(){};
    public ChessComponent(int x, int y, ChessColor color, char name){
        this.source = new ChessboardPoint(x,y);
        this.chessColor = color;
        this.name = name;
    }
    public abstract List<ChessboardPoint> canMoveTo();
    public String toString(){
        return String.valueOf(this.name);
    }
    public ChessboardPoint getSource(){
        return this.source;
    }
    public ChessColor getChessColor(){
        return this.chessColor;
    }
    public void changeindex(ChessboardPoint a){
        source = a;
    }
}