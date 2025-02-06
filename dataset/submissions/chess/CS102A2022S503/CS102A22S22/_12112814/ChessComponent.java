import java.util.List;

public abstract class ChessComponent {
    
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    protected ConcreteChessGame chessGame;

   
    public ChessComponent() {
    }

    public ChessComponent(ConcreteChessGame chessGame, ChessboardPoint source, ChessColor chessColor) {
        this.chessGame = chessGame;
        this.source = source;
        this.chessColor = chessColor;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public char getName() {
        return name;
    }

    
    public abstract List<ChessboardPoint> canMoveTo();

    
    protected boolean checkPoint(int x, int y) {
        if (x < 0 || x > 7 || y < 0 || y > 7) {
            return false;
        }
        return chessGame.getChessComponents()[x][y].chessColor != getChessColor();
    }

    public void updatePoint(ChessboardPoint point) {
        this.source = point;
    }

    
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}
