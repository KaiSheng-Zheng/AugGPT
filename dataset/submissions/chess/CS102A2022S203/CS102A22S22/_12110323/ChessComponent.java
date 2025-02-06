import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    protected static ChessComponent[][] newChessboard; 

    public ChessComponent(){

    }

    public ChessComponent[][] getNewChessboard() {
        return newChessboard;
    }

    public void setNewChessboard(ChessComponent[][] newChessboard) {
        ChessComponent.newChessboard = newChessboard;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public abstract List<ChessboardPoint> canMoveTo();

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

}
