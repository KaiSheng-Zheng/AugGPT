import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    protected ChessComponent[][] chessboard;

    protected boolean cnt;

    public void setCnt(boolean cnt) {
        this.cnt = cnt;
    }

    public boolean isCnt() {
        return cnt;
    }

    public void setChessboard(ChessComponent[][] chessboard) {
        this.chessboard = chessboard;
    }


    //should design
    public ChessComponent(){}

    public ChessColor getChessColor() {
        return this.chessColor;
    }

    public ChessboardPoint getSource() {
        return this.source;
    }

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
