
import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    protected ChessComponent[][] chessboard;
    protected int chessNum;

    public void setChessNum(int chessNum) {
        this.chessNum = chessNum;
    }

    public int getChessNum() {
        return chessNum;
    }

    public ChessComponent(){
    }
    public ChessColor getChessColor() {
        return chessColor;
    }

    public void setName(char name) {
        this.name = name;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public char getName() {
        return name;
    }

    //should design


    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    public void setChessboard(ChessComponent[][] chessboard) {
        this.chessboard = chessboard;
    }

    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    public ChessboardPoint getSource() {
        return source;
    }
}
