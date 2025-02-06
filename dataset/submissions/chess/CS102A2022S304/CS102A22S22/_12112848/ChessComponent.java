import java.util.List;

public abstract class ChessComponent {

    // Variable
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    private ChessComponent[][] chessboard;
    protected ConcreteChessGame game;

    // Setter
    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public void setName(char name) {
        this.name = name;
    }

    // Getter
    public ChessboardPoint getSource() {
        return source;
    }

    public ChessColor getChessColor() {
        return this.chessColor;
    }

    public char getName() {
        return name;
    }

    // Constructor
    public ChessComponent() {
    }

    public ChessComponent(ChessboardPoint source, ChessColor color, char name, ConcreteChessGame concreteChessGame) {
        this.source = source;
        this.chessColor = color;
        this.name = name;
        this.game = concreteChessGame;
    }

    // Method
    public abstract List<ChessboardPoint> canMoveTo();

    public boolean moveTo(ChessboardPoint point) {
        for (ChessboardPoint p : canMoveTo()) {
            if (p.toString().equals(point.toString())) {
                return true;
            }
        }
        return false;
    }

    public void loadChessboard(ChessComponent[][] Chessboard) {
        this.chessboard = Chessboard;
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

}
