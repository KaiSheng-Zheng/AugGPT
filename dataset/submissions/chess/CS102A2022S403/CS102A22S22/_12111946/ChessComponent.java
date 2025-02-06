import java.util.List;

public abstract class ChessComponent {
    public ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    protected ChessComponent[][] chessboard;

    public ChessComponent() {
    }

    public ChessComponent(ChessComponent[][] chessboard) {
        this.chessboard = chessboard;
    }

    public void setChessboard(ChessComponent[][] chessboard) {
        this.chessboard = chessboard;
    }

    public abstract List<ChessboardPoint> canMoveTo();

    public ChessboardPoint getSource() {
        return source;
    }

    public void setSource(int x,int y) {
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

}
