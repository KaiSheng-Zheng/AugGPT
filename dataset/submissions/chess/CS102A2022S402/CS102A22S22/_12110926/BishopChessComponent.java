import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessComponent[][] chessComponents;

    public BishopChessComponent(char b, ChessComponent[][] chessComponents, ChessboardPoint chessboardPoint) {
        super(b, chessComponents, chessboardPoint);
        this.name=b;
        this.chessComponents=chessComponents;
        this.source=chessboardPoint;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> move = new ArrayList<>();
        if (name == 'B') {
            int x1 = source.getX();
            int y1 = source.getY();
            for (int k = 0; k < 8; k++) {
                x1 += 1;
                y1 += 1;
                if (x1 >= 0 && x1 < 8 && y1 >= 0 && y1 < 8) {
                    if (chessComponents[x1][y1].name == '_') {
                        move.add(new ChessboardPoint(x1, y1));
                    } else if (chessComponents[x1][y1].name >= 'a') {
                        move.add(new ChessboardPoint(x1, y1));
                        break;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
            int x2 = source.getX();
            int y2 = source.getY();
            for (int k = 0; k < 8; k++) {
                x2 -= 1;
                y2 += 1;
                if (x2 >= 0 && x2 < 8 && y2 >= 0 && y2 < 8) {
                    if (chessComponents[x2][y2].name == '_') {
                        move.add(new ChessboardPoint(x2, y2));
                    } else if (chessComponents[x2][y2].name >= 'a') {
                        move.add(new ChessboardPoint(x2, y2));
                        break;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
            int x3 = source.getX();
            int y3 = source.getY();
            for (int k = 0; k < 8; k++) {
                x3 -= 1;
                y3 -= 1;
                if (x3 >= 0 && x3 < 8 && y3 >= 0 && y3 < 8) {
                    if (chessComponents[x3][y3].name == '_') {
                        move.add(new ChessboardPoint(x3, y3));
                    } else if (chessComponents[x3][y3].name >= 'a') {
                        move.add(new ChessboardPoint(x3, y3));
                        break;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
            int x4 = source.getX();
            int y4 = source.getY();
            for (int k = 0; k < 8; k++) {
                x4 += 1;
                y4 -= 1;
                if (x4 >= 0 && x4 < 8 && y4 >= 0 && y4 < 8) {
                    if (chessComponents[x4][y4].name == '_') {
                        move.add(new ChessboardPoint(x4, y4));
                    } else if (chessComponents[x4][y4].name >= 'a') {
                        move.add(new ChessboardPoint(x4, y4));
                        break;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
        }

        if (name == 'b') {
            int x1 = source.getX();
            int y1 = source.getY();
            for (int k = 0; k < 8; k++) {
                x1 += 1;
                y1 += 1;
                if (x1 >= 0 && x1 < 8 && y1 >= 0 && y1 < 8) {
                    if (chessComponents[x1][y1].name == '_') {
                        move.add(new ChessboardPoint(x1, y1));
                    } else if (chessComponents[x1][y1].name < '_') {
                        move.add(new ChessboardPoint(x1, y1));
                        break;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
            int x2 = source.getX();
            int y2 = source.getY();
            for (int k = 0; k < 8; k++) {
                x2 -= 1;
                y2 += 1;
                if (x2 >= 0 && x2 < 8 && y2 >= 0 && y2 < 8) {
                    if (chessComponents[x2][y2].name == '_') {
                        move.add(new ChessboardPoint(x2, y2));
                    } else if (chessComponents[x2][y2].name < '_') {
                        move.add(new ChessboardPoint(x2, y2));
                        break;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
            int x3 = source.getX();
            int y3 = source.getY();
            for (int k = 0; k < 8; k++) {
                x3 -= 1;
                y3 -= 1;
                if (x3 >= 0 && x3 < 8 && y3 >= 0 && y3 < 8) {
                    if (chessComponents[x3][y3].name == '_') {
                        move.add(new ChessboardPoint(x3, y3));
                    } else if (chessComponents[x3][y3].name < '_') {
                        move.add(new ChessboardPoint(x3, y3));
                        break;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
            int x4 = source.getX();
            int y4 = source.getY();
            for (int k = 0; k < 8; k++) {
                x4 += 1;
                y4 -= 1;
                if (x4 >= 0 && x4 < 8 && y4 >= 0 && y4 < 8) {
                    if (chessComponents[x4][y4].name == '_') {
                        move.add(new ChessboardPoint(x4, y4));
                    } else if (chessComponents[x4][y4].name < '_') {
                        move.add(new ChessboardPoint(x4, y4));
                        break;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return move;
    }
}
