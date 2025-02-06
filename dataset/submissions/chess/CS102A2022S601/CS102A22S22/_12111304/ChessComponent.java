import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    ChessComponent[][] board;

    //should design
    public ChessComponent(){}

    public ChessComponent(ChessboardPoint source, ChessColor chessColor){
        this.source = source;
        this.chessColor = chessColor;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    public boolean canMoveTo(ChessboardPoint target) {
        List<ChessboardPoint> list = canMoveTo();
        for (ChessboardPoint point : list) {
            if (target.getX() == point.getX() && target.getY() == point.getY()) {
                return true;
            }
        }
        return false;
    }

    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

}
