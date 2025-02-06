

import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    ChessComponent[][] ChessBoard;

    public ChessComponent(ChessComponent[][] chessBoard) {
        ChessBoard = chessBoard;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public ChessComponent() {
    }

    public ChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
    }


    public abstract List<ChessboardPoint> canMoveTo();
    public String toString() {
        return String.valueOf(this.name);
    }
}
