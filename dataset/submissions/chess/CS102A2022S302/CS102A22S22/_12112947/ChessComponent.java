
import java.util.List;

public abstract class ChessComponent {
    //should design
     ChessboardPoint source;
     ChessColor chessColor;
     protected char name;
     ChessComponent[][] chessBoard;
     private ChessComponent[][] chessComponents; 

    //should design
    public ChessComponent(ChessboardPoint source, ChessColor chessColor){
        this.source=source;
        this.chessColor=chessColor;
    }

    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    ChessColor getComponentColor(char component){
        return (component=='_')?ChessColor.NONE:((component>='A'&&component<='Z')?ChessColor.BLACK:ChessColor.WHITE);
    }
    void loadCurrentChessboard(ChessComponent[][] chessBoard){
        this.chessBoard=chessBoard;
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        return null;
    }


}

