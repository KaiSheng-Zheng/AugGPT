import java.util.List;

public abstract class ChessComponent {
    public ChessboardPoint source;

    public ChessColor chessColor;

    public char name;

    public ChessComponent[][] chessComponents = new ChessComponent[8][8];
    
    public boolean[][] chessBoard = new boolean[8][8];

    public ChessComponent() {}
    
    public abstract List<ChessboardPoint> canMoveTo();

    @Override
    public String toString() {
        return String.valueOf(this.name);
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

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }
}