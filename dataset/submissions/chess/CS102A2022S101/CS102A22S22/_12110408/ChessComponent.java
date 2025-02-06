import java.util.ArrayList;
import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    public ChessComponent() {

    }

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

    public List<ChessboardPoint> getAvailablePointsOfLine(int dx, int dy) {
        ArrayList<ChessboardPoint> availablePoints = new ArrayList<ChessboardPoint>();

        int x = getSource().getX() + dx, y = getSource().getY() + dy;

        ChessGame chessGame = ConcreteChessGame.getInstance();
        while (chessGame.isValidPoint(x, y)) {
            ChessComponent chessComponent = chessGame.getChess(x, y);

            if (chessComponent.getChessColor() != this.getChessColor()) {
                availablePoints.add(chessComponent.getSource());
            }
            if (chessComponent instanceof EmptySlotComponent) {
                x += dx;
                y += dy;
            } else {
                break;
            }
        }

        return availablePoints;
    }

    public boolean canMoveTo(int x, int y) {
        ArrayList<ChessboardPoint> chessComponents = (ArrayList<ChessboardPoint>) canMoveTo();

        for (ChessboardPoint chessComponent : chessComponents) {
            if (chessComponent.getX() == x && chessComponent.getY() == y)
                return true;
        }

        return false;
    }
}
