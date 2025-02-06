import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected boolean isFirstMove = false;
    protected char name;
    protected ChessComponent[][] board;
    //should design

    public ChessComponent(){}
    protected void  setName(final ChessColor chessColor){
        name = '_';
    }
    protected void setChessColor(final ChessColor chessColor){
        this.chessColor = chessColor;
    }
    protected void  setSource(final int x, final int y){
        source = new ChessboardPoint(x, y);
    }
    protected ChessboardPoint getSource(){
        return source;
    }

    public ChessColor getChessColor(){
        return chessColor;
    }
    // should design
    public abstract List<ChessboardPoint> canMoveTo();


    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

}
