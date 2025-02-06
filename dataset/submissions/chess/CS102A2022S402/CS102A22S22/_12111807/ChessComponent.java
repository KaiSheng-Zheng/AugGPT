
import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source; // Where the chess is
    private ChessColor chessColor;  // What's the color
    protected char name;			// What's the name

    protected ChessComponent[][] board;

    public void setBoard(ChessComponent[][] board) {
        this.board = board;
    }

    public ChessComponent(){
    }

    public ChessComponent(ChessboardPoint source, ChessColor chessColor, char name){
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
    }
    public ChessComponent(ChessboardPoint source, char name){
        this.source = source;
        this.name = name;
    }
    public abstract List<ChessboardPoint> canMoveTo();
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public void setName(char name) {
        this.name = name;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public boolean inBoard(int x, int y) {
        if(x<8 && y<8 && x>=0 && y>=0){
            return true;
        }
        else {
            return false;
        }
    }

}
