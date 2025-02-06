import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source; // Where the chess is
    private ChessColor chessColor; // What's the color
    protected char name; // What's the name

    public ChessComponent(){}

    public abstract List<ChessboardPoint> canMoveTo();

    public void setChessColor(ChessColor color){this.chessColor = color;}

    public ChessColor getChessColor(){return this.chessColor;}

    public void setSource(int x, int y){this.source = new ChessboardPoint(x,y);}

    @Override
    public String toString(){
        return String.valueOf(this.name);
    }
}
