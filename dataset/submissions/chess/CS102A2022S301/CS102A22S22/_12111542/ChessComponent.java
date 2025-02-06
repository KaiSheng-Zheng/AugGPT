import java.util.List;

public abstract class ChessComponent {

    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    protected ChessComponent[][] board;




    public ChessboardPoint getSource() {
        return source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public ChessComponent(ChessboardPoint chessboardPoint, ChessColor chessColor, char name){
        source=chessboardPoint;
        this.chessColor=chessColor;
        this.name=name;
    }
    public ChessComponent(){
    }

    public abstract List<ChessboardPoint> canMoveTo();

//    public abstract ChessComponent copy(int x,int y);

    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

}
