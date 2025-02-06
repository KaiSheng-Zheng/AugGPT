import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    public ChessboardPoint getSource() {
        return source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    ChessComponent[][] chessBoard;
    int[][] moveByOneStep = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};
    

    ChessColor checkColor(char componentName) {
        if (componentName == '_') {
            return ChessColor.NONE;
        }
        if (componentName >= 'A' && componentName <= 'Z') {
            return ChessColor.BLACK;
        } else {
            return ChessColor.WHITE;
        }
    }

    void loadChessboard(ChessComponent[][] chessBoard) {
        this.chessBoard = chessBoard;
    }

    //should design
    public ChessComponent() {
    }

    public ChessComponent(ChessboardPoint source, ChessColor chessColor) {
        this.source = source;
        this.chessColor = chessColor;
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
        return String.valueOf(this.name);
    }
}
