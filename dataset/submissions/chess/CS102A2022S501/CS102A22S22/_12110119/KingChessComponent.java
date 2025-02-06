import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    private ChessboardPoint source; // Where the chess is
    private ChessColor chessColor;  // What's the color
    protected char name;// What's the name

    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super();
        super.name = name;
        this.chessColor = chessColor;
        this.source = source;
        super.chessColor1 = chessColor;

    }

    public boolean canMoveTo1(ChessboardPoint destination) {
        if (ConcreteChessGame.chessComponents11[destination.getX()][destination.getY()].getChessColor().equals(chessColor)) {
            return false;
        }
        if ((Math.abs(source.getY() - destination.getY()) <= 1 && Math.abs(source.getX() - destination.getX()) <= 1) && !(Math.abs(source.getY() - destination.getY()) == 0 && Math.abs(source.getX() - destination.getX()) == 0)) {

            return true;
        } else return false;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> i = new ArrayList<>();
        for (int x = 0; x <= 7; x++) {
            for (int y = 0; y <= 7; y++) {

                if (canMoveTo1(chessboardPoints[x][y])) {
                    i.add(chessboardPoints[x][y]);
                }
            }

        }
        return i;


    }

    public void changeSource(int x, int y) {
        source = new ChessboardPoint(x, y);
    }
}
