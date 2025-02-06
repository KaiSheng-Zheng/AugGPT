import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private boolean chilemei = true;

    public boolean isChilemei() {
        return chilemei;
    }

    public void setChilemei(boolean chilemei) {
        this.chilemei = chilemei;
    }

    public ChessboardPoint getSource() {
        return source;
    }
//    protected int x = getSource().getX();
//    protected int y = getSource().getY();
    private ChessColor chessColor;
    protected char name;

    public static ChessComponent[][] chessboard;

    public static void setChessboard(ChessComponent[][] chessboard1) {
        chessboard = chessboard1;
    }

    //should design
    public ChessComponent(){}

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    public void setName(char name) {
        this.name = name;
    }

    public char getName() {
        return name;
    }

    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }


}

