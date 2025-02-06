import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    protected ChessComponent[][] chessboard;

    //should design
    public ChessComponent(){source=new ChessboardPoint(0,0);}

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

    public void setChessColor(ChessColor color){
        chessColor=color;
    }

    public ChessColor getChessColor(){
        return chessColor;
    }

    public ChessboardPoint getSource(){return source;}

    public ChessComponent[][] getChessComponent(){return chessboard;}

    public void setSource(int x, int y){source.setLocation(x, y);}
}
