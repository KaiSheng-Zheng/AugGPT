
import java.util.List;

public abstract class ChessComponent {
protected ChessComponent[][] chessComponents;
    protected ChessboardPoint source; // Where the chess is
    protected ChessColor chessColor;  // What's the color
    protected char name;			// What's the name
    public ChessComponent(){
    }

    public abstract List<ChessboardPoint> canMoveTo();

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    public void setChessboard(ChessComponent[][] chessComponents){
        this.chessComponents=chessComponents;
    }
}
