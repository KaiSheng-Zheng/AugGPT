import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    protected ChessComponent[][] chessboard;

    public void setChessboard(ChessComponent[][] chessboard) {
        this.chessboard = chessboard;
    }
    public boolean add(List<ChessboardPoint> steps, ChessComponent chess, int x, int y) {
        boolean stop = false;
        if (x < 0 || y < 0 || x >= 8 || y >= 8)
            return true;

        ChessComponent c = chessboard[x][y];
        if (c.name == '_') {
            steps.add(c.getSource());
        } else if (c.getChessColor() != chess.getChessColor()) {
            steps.add(c.getSource());
            stop = true;
        } else if (c.getChessColor() == chess.getChessColor()) {
            stop = true;
        }
        return stop;
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

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    //should design
    public ChessComponent(){}

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
