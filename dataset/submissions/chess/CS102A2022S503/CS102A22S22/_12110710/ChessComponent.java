import java.util.ArrayList;
import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    protected ChessComponent[][]wholeChessGame;
    //should design
    public ChessComponent(){}

    public ChessComponent(ChessboardPoint source,ChessColor chessColor,char name){
        this.source=source;
        this.name=name;
        this.chessColor=chessColor;
    }

    public ChessColor getChessColor(){
        return chessColor;
    }

    public void setWholeChessGame(ChessComponent[][]chessComponents){this.wholeChessGame=chessComponents;}

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



}
