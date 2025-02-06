import java.util.ArrayList;
import java.util.List;

public abstract class ChessComponent {
    ChessboardPoint source;
    ChessColor chessColor;
    protected ChessComponent[][] chessboard;
    protected char name;

    public void setChessBoard(ChessComponent[][] chessBoard) {
        this.chessboard = chessBoard;
    }

    ChessColor getComponentColor(char component) {
        if (component >= 'A' && component <= 'Z'){
            return ChessColor.BLACK;
        }
        else if (component >= 'a' && component <= 'z'){
            return ChessColor.WHITE;
        }
        return ChessColor.NONE;
    }

    void loadCurrentChessboard(ChessComponent[][] chessBoard) {
        this.chessboard = chessBoard;
    }

    public ChessComponent() {}

    public ChessComponent(ChessboardPoint source, ChessColor chessColor) {
        this.source = source;
        this.chessColor = chessColor;
    }
    public ChessComponent(int x,int y, ChessColor chessColor) {
        x= source.getX();
        y= source.getY();
        this.chessColor = chessColor;
    }

    public abstract List<ChessboardPoint> canMoveTo();

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}












