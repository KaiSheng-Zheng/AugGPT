import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {
    public RookChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        setSource(source);
        setChessColor(chessColor);
        this.name = name;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> r = new ArrayList<>();
        ChessboardPoint R = getSource();
        int x = R.getX();
        int y = R.getY();
        if (ConcreteChessGame.geta()[x][y].name == 'R') {
            for (int k = 1;R.offset(-k, 0) != null ; k++) {

                    if (ConcreteChessGame.geta()[x - k][y].getChessColor() == ChessColor.NONE) {
                        r.add(new ChessboardPoint(x - k, y));
                    }
                    if (ConcreteChessGame.geta()[x - k][y].getChessColor() == ChessColor.WHITE) {
                        r.add(new ChessboardPoint(x - k, y));
                        break;
                    }
                    if (ConcreteChessGame.geta()[x - k][y].getChessColor() == ChessColor.BLACK) {
                        break;
                    }

            }
            for (int k = 1;R.offset(k, 0) != null ; k++) {

                    if (ConcreteChessGame.geta()[x + k][y].getChessColor() == ChessColor.NONE) {
                        r.add(new ChessboardPoint(x + k, y));
                    }
                    if (ConcreteChessGame.geta()[x + k][y].getChessColor() == ChessColor.WHITE) {
                        r.add(new ChessboardPoint(x + k, y));
                        break;
                    }
                    if (ConcreteChessGame.geta()[x + k][y].getChessColor() == ChessColor.BLACK) {
                        break;
                    }

            }
            for (int k = 1;R.offset(0, k) != null ; k++) {

                    if (ConcreteChessGame.geta()[x][y + k].getChessColor() == ChessColor.NONE) {
                        r.add(new ChessboardPoint(x, y + k));
                    }
                    if (ConcreteChessGame.geta()[x][y + k].getChessColor() == ChessColor.WHITE) {
                        r.add(new ChessboardPoint(x, y + k));
                        break;
                    }
                    if (ConcreteChessGame.geta()[x][y + k].getChessColor() == ChessColor.BLACK) {
                        break;
                    }

            }
            for (int k = 1;(R.offset(0, -k) != null) ; k++) {

                    if (ConcreteChessGame.geta()[x][y - k].getChessColor() == ChessColor.NONE) {
                        r.add(new ChessboardPoint(x, y - k));
                    }
                    if (ConcreteChessGame.geta()[x][y - k].getChessColor() == ChessColor.WHITE) {
                        r.add(new ChessboardPoint(x, y - k));
                        break;
                    }
                    if (ConcreteChessGame.geta()[x][y - k].getChessColor() == ChessColor.BLACK) {
                        break;
                    }

            }
//            for (int k = 0; x + k < 8 && x + k >= 0; k++) {
//                if (R.offset(k, 0) != null && ConcreteChessGame.geta()[x + k][y].getChessColor() != ChessColor.BLACK) {
//                    r.add(new ChessboardPoint(x + k, y));
//                }
//            }
//            for (int k = 0; y + k < 8 && y + k >= 0; k++) {
//                if (R.offset(0, k) != null && ConcreteChessGame.geta()[x][y + k].getChessColor() != ChessColor.BLACK) {
//                    r.add(new ChessboardPoint(x, y + k));
//                }
//            }
//            for (int k = 0; y - k < 8 && y - k >= 0; k++) {
//                if (R.offset(0, -k) != null && ConcreteChessGame.geta()[x][y - k].getChessColor() != ChessColor.BLACK) {
//                    r.add(new ChessboardPoint(x, y - k));
//                }
//            }
        } else if (ConcreteChessGame.geta()[x][y].name == 'r') {
            for (int k = 1;(R.offset(-k, 0) != null) ; k++) {

                    if (ConcreteChessGame.geta()[x - k][y].getChessColor() == ChessColor.NONE) {
                        r.add(new ChessboardPoint(x - k, y));
                    }
                    if (ConcreteChessGame.geta()[x - k][y].getChessColor() == ChessColor.BLACK) {
                        r.add(new ChessboardPoint(x - k, y));
                        break;
                    }
                    if (ConcreteChessGame.geta()[x - k][y].getChessColor() == ChessColor.WHITE) {
                        break;
                    }
                }

            for (int k = 1;R.offset(k, 0) != null ; k++) {

                    if (ConcreteChessGame.geta()[x + k][y].getChessColor() == ChessColor.NONE) {
                        r.add(new ChessboardPoint(x + k, y));
                    }
                    if (ConcreteChessGame.geta()[x + k][y].getChessColor() == ChessColor.BLACK) {
                        r.add(new ChessboardPoint(x + k, y));
                        break;
                    }
                    if (ConcreteChessGame.geta()[x + k][y].getChessColor() == ChessColor.WHITE) {
                        break;
                    }
                }

            for (int k = 1;R.offset(0, k) != null ; k++) {

                    if (ConcreteChessGame.geta()[x][y + k].getChessColor() == ChessColor.NONE) {
                        r.add(new ChessboardPoint(x, y + k));
                    }
                    if (ConcreteChessGame.geta()[x][y + k].getChessColor() == ChessColor.BLACK) {
                        r.add(new ChessboardPoint(x, y + k));
                        break;
                    }
                    if (ConcreteChessGame.geta()[x][y + k].getChessColor() == ChessColor.WHITE) {
                        break;

                }
            }
            for (int k = 1;R.offset(0, -k) != null ; k++) {
                    if (ConcreteChessGame.geta()[x][y - k].getChessColor() == ChessColor.NONE) {
                        r.add(new ChessboardPoint(x, y - k));
                    }
                    if (ConcreteChessGame.geta()[x][y - k].getChessColor() == ChessColor.BLACK) {
                        r.add(new ChessboardPoint(x, y - k));
                        break;
                    }
                    if (ConcreteChessGame.geta()[x][y - k].getChessColor() == ChessColor.WHITE) {
                        break;
                    }
            }
//            for (int k = 0; x - k < 8 && x - k >= 0; k++) {
//                if (R.offset(-k, 0) != null && ConcreteChessGame.geta()[x - k][y].getChessColor() != ChessColor.WHITE) {
//                    r.add(new ChessboardPoint(x - k, y));
//                }
//            }
//            for (int k = 0; x + k < 8 && x + k >= 0; k++) {
//                if (R.offset(k, 0) != null && ConcreteChessGame.geta()[x + k][y].getChessColor() != ChessColor.WHITE) {
//                    r.add(new ChessboardPoint(x + k, y));
//                }
//            }
//            for (int k = 0; y + k < 8 && y + k >= 0; k++) {
//                if (R.offset(0, k) != null && ConcreteChessGame.geta()[x][y + k].getChessColor() != ChessColor.WHITE) {
//                    r.add(new ChessboardPoint(x, y + k));
//                }
//            }
//            for (int k = 0; y - k < 8 && y - k >= 0; k++) {
//                if (R.offset(0, -k) != null && ConcreteChessGame.geta()[x][y - k].getChessColor() != ChessColor.WHITE) {
//                    r.add(new ChessboardPoint(x, y - k));
//                }
//            }

        }
        return r;
    }
}
