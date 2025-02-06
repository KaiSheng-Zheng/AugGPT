import java.util.*;

public abstract class ChessComponent {

    private ChessboardPoint source ;
    private ChessColor chessColor ;
    //user defined
    protected char name ;
    protected ChessComponent[][] chessboard ;
    public ChessComponent() {
    } ;

    public ChessComponent(ChessComponent[][] chessboard){
        this.chessboard = chessboard ;
    }
    public void setChessboard (ChessComponent[][] chessboard){
        this.chessboard = chessboard ;
    }

    public abstract List<ChessboardPoint> canMoveTo() ;

    public String toString(){
        return String.valueOf(this.name);
    }
}
