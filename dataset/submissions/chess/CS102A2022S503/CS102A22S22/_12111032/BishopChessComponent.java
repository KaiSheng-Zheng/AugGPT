import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {
    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        setSource(source);
        setChessColor(chessColor);
        this.name = name;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> b = new ArrayList<>();
        ChessboardPoint B = getSource();
        int x = B.getX();
        int y = B.getY();
        if (ConcreteChessGame.geta()[x][y].name == 'B') {
            for (int k = 1; B.offset(-k, -k) != null; k++) {
                if (ConcreteChessGame.geta()[x - k][y - k].getChessColor() == ChessColor.NONE) {
                    b.add(new ChessboardPoint(x - k, y - k));
                }
                if (ConcreteChessGame.geta()[x - k][y - k].getChessColor() == ChessColor.WHITE) {
                    b.add(new ChessboardPoint(x - k, y - k));
                    break;
                }
                if (ConcreteChessGame.geta()[x - k][y - k].getChessColor() == ChessColor.BLACK) {
                    break;
                }

            }
            for (int k = 1; B.offset(k, -k) != null; k++) {

                if (ConcreteChessGame.geta()[x + k][y - k].getChessColor() == ChessColor.NONE) {
                    b.add(new ChessboardPoint(x + k, y - k));
                }
                if (ConcreteChessGame.geta()[x + k][y - k].getChessColor() == ChessColor.WHITE) {
                    b.add(new ChessboardPoint(x + k, y - k));
                    break;
                }
                if (ConcreteChessGame.geta()[x + k][y - k].getChessColor() == ChessColor.BLACK) {
                    break;
                }

            }
            for (int k = 1; B.offset(k, k) != null; k++) {

                if (ConcreteChessGame.geta()[x + k][y + k].getChessColor() == ChessColor.NONE) {
                    b.add(new ChessboardPoint(x + k, y + k));
                }
                if (ConcreteChessGame.geta()[x + k][y + k].getChessColor() == ChessColor.WHITE) {
                    b.add(new ChessboardPoint(x + k, y + k));
                    break;
                }
                if (ConcreteChessGame.geta()[x + k][y + k].getChessColor() == ChessColor.BLACK) {
                    break;
                }

            }
            for (int k = 1; (B.offset(-k, k) != null); k++) {

                if (ConcreteChessGame.geta()[x - k][y + k].getChessColor() == ChessColor.NONE) {
                    b.add(new ChessboardPoint(x - k, y + k));
                }
                if (ConcreteChessGame.geta()[x - k][y + k].getChessColor() == ChessColor.WHITE) {
                    b.add(new ChessboardPoint(x - k, y + k));
                    break;
                }
                if (ConcreteChessGame.geta()[x - k][y + k].getChessColor() == ChessColor.BLACK) {
                    break;
                }
            }
        } else if (ConcreteChessGame.geta()[x][y].name == 'b') {
            for (int k = 1; B.offset(-k, -k) != null; k++) {
                if (ConcreteChessGame.geta()[x - k][y - k].getChessColor() == ChessColor.NONE) {
                    b.add(new ChessboardPoint(x - k, y - k));
                }
                if (ConcreteChessGame.geta()[x - k][y - k].getChessColor() == ChessColor.BLACK) {
                    b.add(new ChessboardPoint(x - k, y - k));
                    break;
                }
                if (ConcreteChessGame.geta()[x - k][y - k].getChessColor() == ChessColor.WHITE) {
                    break;
                }

            }
            for (int k = 1; B.offset(k, -k) != null; k++) {

                if (ConcreteChessGame.geta()[x + k][y - k].getChessColor() == ChessColor.NONE) {
                    b.add(new ChessboardPoint(x + k, y - k));
                }
                if (ConcreteChessGame.geta()[x + k][y - k].getChessColor() == ChessColor.BLACK) {
                    b.add(new ChessboardPoint(x + k, y - k));
                    break;
                }
                if (ConcreteChessGame.geta()[x + k][y - k].getChessColor() == ChessColor.WHITE) {
                    break;
                }

            }
            for (int k = 1; B.offset(k, k) != null; k++) {

                if (ConcreteChessGame.geta()[x + k][y + k].getChessColor() == ChessColor.NONE) {
                    b.add(new ChessboardPoint(x + k, y + k));
                }
                if (ConcreteChessGame.geta()[x + k][y + k].getChessColor() == ChessColor.BLACK) {
                    b.add(new ChessboardPoint(x + k, y + k));
                    break;
                }
                if (ConcreteChessGame.geta()[x + k][y + k].getChessColor() == ChessColor.WHITE) {
                    break;
                }

            }
            for (int k = 1; (B.offset(-k, k) != null); k++) {

                if (ConcreteChessGame.geta()[x - k][y + k].getChessColor() == ChessColor.NONE) {
                    b.add(new ChessboardPoint(x - k, y + k));
                }
                if (ConcreteChessGame.geta()[x - k][y + k].getChessColor() == ChessColor.BLACK) {
                    b.add(new ChessboardPoint(x - k, y + k));
                    break;
                }
                if (ConcreteChessGame.geta()[x - k][y + k].getChessColor() == ChessColor.WHITE) {
                    break;
                }
            }
        }
        return b;

    }
}
