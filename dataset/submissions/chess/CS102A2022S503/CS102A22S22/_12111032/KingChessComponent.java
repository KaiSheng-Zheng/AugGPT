import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        setSource(source);
        setChessColor(chessColor);
        this.name = name;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> k = new ArrayList<>();
        ChessboardPoint K = getSource();
        int x = K.getX();
        int y = K.getY();
                if (ConcreteChessGame.geta()[x][y].name == 'K') {
                    if (K.offset(1, 1) != null && ConcreteChessGame.geta()[x + 1][y + 1].getChessColor() != ChessColor.BLACK) {
                        k.add(new ChessboardPoint(x + 1, y + 1));
                    }
                    if (K.offset(1, -1) != null && ConcreteChessGame.geta()[x + 1][y - 1].getChessColor() != ChessColor.BLACK) {
                        k.add(new ChessboardPoint(x + 1, y - 1));
                    }
                    if (K.offset(-1, 1) != null && ConcreteChessGame.geta()[x - 1][y + 1].getChessColor() != ChessColor.BLACK) {
                        k.add(new ChessboardPoint(x - 1, y + 1));
                    }
                    if (K.offset(-1, -1) != null && ConcreteChessGame.geta()[x - 1][y - 1].getChessColor() != ChessColor.BLACK) {
                        k.add(new ChessboardPoint(x - 1, y - 1));
                    }
                    if (K.offset(1, 0) != null && ConcreteChessGame.geta()[x + 1][y].getChessColor() != ChessColor.BLACK) {
                        k.add(new ChessboardPoint(x + 1, y));
                    }
                    if (K.offset(-1, 0) != null && ConcreteChessGame.geta()[x - 1][y].getChessColor() != ChessColor.BLACK) {
                        k.add(new ChessboardPoint(x - 1, y));
                    }
                    if (K.offset(0, 1) != null && ConcreteChessGame.geta()[x][y + 1].getChessColor() != ChessColor.BLACK) {
                        k.add(new ChessboardPoint(x, y + 1));
                    }
                    if (K.offset(0, -1) != null && ConcreteChessGame.geta()[x][y - 1].getChessColor() != ChessColor.BLACK) {
                        k.add(new ChessboardPoint(x, y - 1));
                    }

                } else if (ConcreteChessGame.geta()[x][y].name == 'k') {
                    if (K.offset(1, 1) != null && ConcreteChessGame.geta()[x + 1][y + 1].getChessColor() != ChessColor.WHITE) {
                        k.add(new ChessboardPoint(x + 1, y + 1));
                    }
                    if (K.offset(1, -1) != null && ConcreteChessGame.geta()[x + 1][y - 1].getChessColor() != ChessColor.WHITE) {
                        k.add(new ChessboardPoint(x + 1, y - 1));
                    }
                    if (K.offset(-1, 1) != null && ConcreteChessGame.geta()[x - 1][y + 1].getChessColor() != ChessColor.WHITE) {
                        k.add(new ChessboardPoint(x - 1, y + 1));
                    }
                    if (K.offset(-1, -1) != null && ConcreteChessGame.geta()[x - 1][y - 1].getChessColor() != ChessColor.WHITE) {
                        k.add(new ChessboardPoint(x - 1, y - 1));
                    }
                    if (K.offset(1, 0) != null && ConcreteChessGame.geta()[x + 1][y].getChessColor() != ChessColor.WHITE) {
                        k.add(new ChessboardPoint(x + 1, y));
                    }
                    if (K.offset(-1, 0) != null && ConcreteChessGame.geta()[x - 1][y].getChessColor() != ChessColor.WHITE) {
                        k.add(new ChessboardPoint(x - 1, y));
                    }
                    if (K.offset(0, 1) != null && ConcreteChessGame.geta()[x][y + 1].getChessColor() != ChessColor.WHITE) {
                        k.add(new ChessboardPoint(x, y + 1));
                    }
                    if (K.offset(0, -1) != null && ConcreteChessGame.geta()[x][y - 1].getChessColor() != ChessColor.WHITE) {
                        k.add(new ChessboardPoint(x, y - 1));
            }
        }
        return k;
    }
}
