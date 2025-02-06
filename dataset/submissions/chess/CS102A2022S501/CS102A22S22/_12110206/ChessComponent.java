import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    protected ChessComponent[][] chessboard = new ChessComponent[8][8];

    public ChessComponent() {
    }

    //should design
    public ChessComponent(int i, int j, char identity) {
        this.source = new ChessboardPoint(i, j);
        if (identity < 'z' && identity > 'a') {
            chessColor = ChessColor.WHITE;
        } else if (identity < 'Z' && identity > 'A') {
            chessColor = ChessColor.BLACK;
        } else {
            chessColor = ChessColor.NONE;
        }
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public ChessColor chessColor() {
        return chessColor;
    }

    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    /**
     * should design
     *
     * @return
     */
    @Override
    public String toString() {
        if (this.chessColor != ChessColor.WHITE) {
            return String.valueOf(this.name);
        }
        else{
            return String.valueOf((char)(this.name-'A'+'a'));
        }

    }

    public void setChessboard(ChessComponent[][] chessboard) {
        this.chessboard = chessboard;
    }

}
