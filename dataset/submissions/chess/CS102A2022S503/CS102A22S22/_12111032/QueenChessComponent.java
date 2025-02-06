import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent {
    public QueenChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        setSource(source);
        setChessColor(chessColor);
        this.name = name;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> q = new ArrayList<>();
        ChessboardPoint Q = getSource();
        int x = Q.getX();
        int y = Q.getY();
                if (ConcreteChessGame.geta()[x][y].name == 'Q') {
                    for (int k = 1;Q.offset(-k, 0) != null ; k++) {

                        if (ConcreteChessGame.geta()[x - k][y].getChessColor() == ChessColor.NONE) {
                            q.add(new ChessboardPoint(x - k, y));
                        }
                        if (ConcreteChessGame.geta()[x - k][y].getChessColor() == ChessColor.WHITE) {
                            q.add(new ChessboardPoint(x - k, y));
                            break;
                        }
                        if (ConcreteChessGame.geta()[x - k][y].getChessColor() == ChessColor.BLACK) {
                            break;
                        }

                    }
                    for (int k = 1;Q.offset(k, 0) != null ; k++) {

                        if (ConcreteChessGame.geta()[x + k][y].getChessColor() == ChessColor.NONE) {
                            q.add(new ChessboardPoint(x + k, y));
                        }
                        if (ConcreteChessGame.geta()[x + k][y].getChessColor() == ChessColor.WHITE) {
                            q.add(new ChessboardPoint(x + k, y));
                            break;
                        }
                        if (ConcreteChessGame.geta()[x + k][y].getChessColor() == ChessColor.BLACK) {
                            break;
                        }

                    }
                    for (int k = 1;Q.offset(0, k) != null ; k++) {

                        if (ConcreteChessGame.geta()[x][y + k].getChessColor() == ChessColor.NONE) {
                            q.add(new ChessboardPoint(x, y + k));
                        }
                        if (ConcreteChessGame.geta()[x][y + k].getChessColor() == ChessColor.WHITE) {
                            q.add(new ChessboardPoint(x, y + k));
                            break;
                        }
                        if (ConcreteChessGame.geta()[x][y + k].getChessColor() == ChessColor.BLACK) {
                            break;
                        }

                    }
                    for (int k = 1;(Q.offset(0, -k) != null) ; k++) {

                        if (ConcreteChessGame.geta()[x][y - k].getChessColor() == ChessColor.NONE) {
                            q.add(new ChessboardPoint(x, y - k));
                        }
                        if (ConcreteChessGame.geta()[x][y - k].getChessColor() == ChessColor.WHITE) {
                            q.add(new ChessboardPoint(x, y - k));
                            break;
                        }
                        if (ConcreteChessGame.geta()[x][y - k].getChessColor() == ChessColor.BLACK) {
                            break;
                        }
                    }
                    for (int k = 1; Q.offset(-k, -k) != null; k++) {
                        if (ConcreteChessGame.geta()[x - k][y - k].getChessColor() == ChessColor.NONE) {
                            q.add(new ChessboardPoint(x - k, y - k));
                        }
                        if (ConcreteChessGame.geta()[x - k][y - k].getChessColor() == ChessColor.WHITE) {
                            q.add(new ChessboardPoint(x - k, y - k));
                            break;
                        }
                        if (ConcreteChessGame.geta()[x - k][y - k].getChessColor() == ChessColor.BLACK) {
                            break;
                        }

                    }
                    for (int k = 1; Q.offset(k, -k) != null; k++) {

                        if (ConcreteChessGame.geta()[x + k][y - k].getChessColor() == ChessColor.NONE) {
                            q.add(new ChessboardPoint(x + k, y - k));
                        }
                        if (ConcreteChessGame.geta()[x + k][y - k].getChessColor() == ChessColor.WHITE) {
                            q.add(new ChessboardPoint(x - k, y - k));
                            break;
                        }
                        if (ConcreteChessGame.geta()[x + k][y - k].getChessColor() == ChessColor.BLACK) {
                            break;
                        }

                    }
                    for (int k = 1; Q.offset(k, k) != null; k++) {

                        if (ConcreteChessGame.geta()[x + k][y + k].getChessColor() == ChessColor.NONE) {
                            q.add(new ChessboardPoint(x + k, y + k));
                        }
                        if (ConcreteChessGame.geta()[x + k][y + k].getChessColor() == ChessColor.WHITE) {
                            q.add(new ChessboardPoint(x + k, y + k));
                            break;
                        }
                        if (ConcreteChessGame.geta()[x + k][y + k].getChessColor() == ChessColor.BLACK) {
                            break;
                        }

                    }
                    for (int k = 1; (Q.offset(-k, k) != null); k++) {

                        if (ConcreteChessGame.geta()[x - k][y + k].getChessColor() == ChessColor.NONE) {
                            q.add(new ChessboardPoint(x - k, y + k));
                        }
                        if (ConcreteChessGame.geta()[x - k][y + k].getChessColor() == ChessColor.WHITE) {
                            q.add(new ChessboardPoint(x - k, y + k));
                            break;
                        }
                        if (ConcreteChessGame.geta()[x - k][y + k].getChessColor() == ChessColor.BLACK) {
                            break;
                        }
                    }
                } else if (ConcreteChessGame.geta()[x][y].name == 'q') {
                    for (int k = 1;Q.offset(-k, 0) != null ; k++) {

                        if (ConcreteChessGame.geta()[x - k][y].getChessColor() == ChessColor.NONE) {
                            q.add(new ChessboardPoint(x - k, y));
                        }
                        if (ConcreteChessGame.geta()[x - k][y].getChessColor() == ChessColor.BLACK) {
                            q.add(new ChessboardPoint(x - k, y));
                            break;
                        }
                        if (ConcreteChessGame.geta()[x - k][y].getChessColor() == ChessColor.WHITE) {
                            break;
                        }

                    }
                    for (int k = 1;Q.offset(k, 0) != null ; k++) {

                        if (ConcreteChessGame.geta()[x + k][y].getChessColor() == ChessColor.NONE) {
                            q.add(new ChessboardPoint(x + k, y));
                        }
                        if (ConcreteChessGame.geta()[x + k][y].getChessColor() == ChessColor.BLACK) {
                            q.add(new ChessboardPoint(x + k, y));
                            break;
                        }
                        if (ConcreteChessGame.geta()[x + k][y].getChessColor() == ChessColor.WHITE) {
                            break;
                        }

                    }
                    for (int k = 1;Q.offset(0, k) != null ; k++) {

                        if (ConcreteChessGame.geta()[x][y + k].getChessColor() == ChessColor.NONE) {
                            q.add(new ChessboardPoint(x, y + k));
                        }
                        if (ConcreteChessGame.geta()[x][y + k].getChessColor() == ChessColor.BLACK) {
                            q.add(new ChessboardPoint(x, y + k));
                            break;
                        }
                        if (ConcreteChessGame.geta()[x][y + k].getChessColor() == ChessColor.WHITE) {
                            break;
                        }

                    }
                    for (int k = 1;(Q.offset(0, -k) != null) ; k++) {

                        if (ConcreteChessGame.geta()[x][y - k].getChessColor() == ChessColor.NONE) {
                            q.add(new ChessboardPoint(x, y - k));
                        }
                        if (ConcreteChessGame.geta()[x][y - k].getChessColor() == ChessColor.BLACK) {
                            q.add(new ChessboardPoint(x, y - k));
                            break;
                        }
                        if (ConcreteChessGame.geta()[x][y - k].getChessColor() == ChessColor.WHITE) {
                            break;
                        }
                    }
                    for (int k = 1; Q.offset(-k, -k) != null; k++) {
                        if (ConcreteChessGame.geta()[x - k][y - k].getChessColor() == ChessColor.NONE) {
                            q.add(new ChessboardPoint(x - k, y - k));
                        }
                        if (ConcreteChessGame.geta()[x - k][y - k].getChessColor() == ChessColor.BLACK) {
                            q.add(new ChessboardPoint(x - k, y - k));
                            break;
                        }
                        if (ConcreteChessGame.geta()[x - k][y - k].getChessColor() == ChessColor.WHITE) {
                            break;
                        }

                    }
                    for (int k = 1; Q.offset(k, -k) != null; k++) {

                        if (ConcreteChessGame.geta()[x + k][y - k].getChessColor() == ChessColor.NONE) {
                            q.add(new ChessboardPoint(x + k, y - k));
                        }
                        if (ConcreteChessGame.geta()[x + k][y - k].getChessColor() == ChessColor.BLACK) {
                            q.add(new ChessboardPoint(x - k, y - k));
                            break;
                        }
                        if (ConcreteChessGame.geta()[x + k][y - k].getChessColor() == ChessColor.WHITE) {
                            break;
                        }

                    }
                    for (int k = 1; Q.offset(k, k) != null; k++) {

                        if (ConcreteChessGame.geta()[x + k][y + k].getChessColor() == ChessColor.NONE) {
                            q.add(new ChessboardPoint(x + k, y + k));
                        }
                        if (ConcreteChessGame.geta()[x + k][y + k].getChessColor() == ChessColor.BLACK) {
                            q.add(new ChessboardPoint(x + k, y + k));
                            break;
                        }
                        if (ConcreteChessGame.geta()[x + k][y + k].getChessColor() == ChessColor.WHITE) {
                            break;
                        }

                    }
                    for (int k = 1; (Q.offset(-k, k) != null); k++) {

                        if (ConcreteChessGame.geta()[x - k][y + k].getChessColor() == ChessColor.NONE) {
                            q.add(new ChessboardPoint(x - k, y + k));
                        }
                        if (ConcreteChessGame.geta()[x - k][y + k].getChessColor() == ChessColor.BLACK) {
                            q.add(new ChessboardPoint(x - k, y + k));
                            break;
                        }
                        if (ConcreteChessGame.geta()[x - k][y + k].getChessColor() == ChessColor.WHITE) {
                            break;
                        }
                    }
                }
        return q;
    }
}
