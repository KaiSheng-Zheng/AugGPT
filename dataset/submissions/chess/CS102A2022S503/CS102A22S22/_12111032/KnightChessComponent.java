import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {

    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        setSource(source);
        setChessColor(chessColor);
        this.name = name;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> n = new ArrayList<>();
        ChessboardPoint N = getSource();
        int x = N.getX();
        int y = N.getY();
        if (ConcreteChessGame.geta()[x][y].name == 'N') {
            if (N.offset( 2,  1) != null && ConcreteChessGame.geta()[x + 2][y + 1].getChessColor() != ChessColor.BLACK) {
                n.add(new ChessboardPoint(x + 2, y + 1));
            }
            if (N.offset( 2,  -1) != null && ConcreteChessGame.geta()[x + 2][y - 1].getChessColor() != ChessColor.BLACK) {
                n.add(new ChessboardPoint(x + 2, y - 1));
            }
            if (N.offset( -2,  1) != null && ConcreteChessGame.geta()[x - 2][y + 1].getChessColor() != ChessColor.BLACK) {
                n.add(new ChessboardPoint(x - 2, y + 1));
            }
            if (N.offset(- 2,  - 1) != null && ConcreteChessGame.geta()[x - 2][y - 1].getChessColor() != ChessColor.BLACK) {
                n.add(new ChessboardPoint(x - 2, y - 1));
            }
            if (N.offset( 1,  2) != null && ConcreteChessGame.geta()[x + 1][y + 2].getChessColor() != ChessColor.BLACK) {
                n.add(new ChessboardPoint(x + 1, y + 2));
            }
            if (N.offset( 1,  -2) != null && ConcreteChessGame.geta()[x + 1][y - 2].getChessColor() != ChessColor.BLACK) {
                n.add(new ChessboardPoint(x + 1, y - 2));
            }
            if (N.offset( -1,  2) != null && ConcreteChessGame.geta()[x - 1][y + 2].getChessColor() != ChessColor.BLACK) {
                n.add(new ChessboardPoint(x - 1, y + 2));
            }
            if (N.offset( - 1,  - 2) != null && ConcreteChessGame.geta()[x - 1][y - 2].getChessColor() != ChessColor.BLACK) {
                n.add(new ChessboardPoint(x - 1, y - 2));
            }
            } else if (ConcreteChessGame.geta()[x][y].name == 'n') {
            if (N.offset(2, 1) != null && ConcreteChessGame.geta()[x + 2][y + 1].getChessColor() != ChessColor.WHITE) {
                n.add(new ChessboardPoint(x + 2, y + 1));
            }
            if (N.offset(2, -1) != null && ConcreteChessGame.geta()[x + 2][y - 1].getChessColor() != ChessColor.WHITE) {
                n.add(new ChessboardPoint(x + 2, y - 1));
            }
            if (N.offset(-2, 1) != null && ConcreteChessGame.geta()[x - 2][y + 1].getChessColor() != ChessColor.WHITE) {
                n.add(new ChessboardPoint(x - 2, y + 1));
            }
            if (N.offset(-2, -1) != null && ConcreteChessGame.geta()[x - 2][y - 1].getChessColor() != ChessColor.WHITE) {
                n.add(new ChessboardPoint(x - 2, y - 1));
            }
            if (N.offset(1, 2) != null && ConcreteChessGame.geta()[x + 1][y + 2].getChessColor() != ChessColor.WHITE) {
                n.add(new ChessboardPoint(x + 1, y + 2));
            }
            if (N.offset(1, -2) != null && ConcreteChessGame.geta()[x + 1][y - 2].getChessColor() != ChessColor.WHITE) {
                n.add(new ChessboardPoint(x + 1, y - 2));
            }
            if (N.offset(-1, 2) != null && ConcreteChessGame.geta()[x - 1][y + 2].getChessColor() != ChessColor.WHITE) {
                n.add(new ChessboardPoint(x - 1, y + 2));
            }
            if (N.offset(-1,  - 2) != null && ConcreteChessGame.geta()[x - 1][y - 2].getChessColor() != ChessColor.WHITE) {
                n.add(new ChessboardPoint(x - 1, y - 2));
            }

        }
//
        return n;
    }
}
