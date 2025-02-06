import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessComponent[][] chessComponents;

    public QueenChessComponent(char q, ChessComponent[][] chessComponents, ChessboardPoint chessboardPoint) {
        super(q, chessComponents, chessboardPoint);
        this.chessComponents=chessComponents;
        this.name=q;
        this.source=chessboardPoint;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> move = new ArrayList<>();
        if (name == 'Q') {
            int x1 = source.getX();
            int y1 = source.getY();
            int k1 = 0;
            while (k1 < 8) {
                x1 += 1;
                if (x1 > 7) break;
                else {
                    if (chessComponents[x1][y1].name == '_') {
                        move.add(new ChessboardPoint(x1, y1));
                    } else if (chessComponents[x1][y1].name >= 'a') {
                        move.add(new ChessboardPoint(x1, y1));
                        break;
                    } else break;
                }
                k1++;
            }
            int x2 = source.getX();
            int y2 = source.getY();
            int k2 = 0;
            while (k2 < 8) {
                x2 -= 1;
                if (x2 < 0) break;
                else {
                    if (chessComponents[x2][y2].name == '_') {
                        move.add(new ChessboardPoint(x2, y2));
                    } else if (chessComponents[x2][y2].name >= 'a') {
                        move.add(new ChessboardPoint(x2, y2));
                        break;
                    } else break;
                }
                k2++;
            }
            int x3 = source.getX();
            int y3 = source.getY();
            int k3 = 0;
            while (k3 < 8) {
                y3 += 1;
                if (y3 > 7) break;
                else {
                    if (chessComponents[x3][y3].name == '_') {
                        move.add(new ChessboardPoint(x3, y3));
                    } else if (chessComponents[x3][y3].name >= 'a') {
                        move.add(new ChessboardPoint(x3, y3));
                        break;
                    } else break;
                }
                k3++;
            }
            int x4 = source.getX();
            int y4 = source.getY();
            int k4 = 0;
            while (k4 < 8) {
                y4 -= 1;
                if (y4 < 0) break;
                else {
                    if (chessComponents[x4][y4].name == '_') {
                        move.add(new ChessboardPoint(x4, y4));
                    } else if (chessComponents[x4][y4].name >= 'a') {
                        move.add(new ChessboardPoint(x4, y4));
                        break;
                    } else break;
                }
                k4++;
            }
            //bishop
            int x5 = source.getX();
            int y5 = source.getY();
            for (int k = 0; k < 8; k++) {
                x5 += 1;
                y5 += 1;
                if (x5 >= 0 && x5 < 8 && y5 >= 0 && y5 < 8) {
                    if (chessComponents[x5][y5].name == '_') {
                        move.add(new ChessboardPoint(x5, y5));
                    } else if (chessComponents[x5][y5].name >= 'a') {
                        move.add(new ChessboardPoint(x5, y5));
                        break;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
            int x6 = source.getX();
            int y6 = source.getY();
            for (int k = 0; k < 8; k++) {
                x6 -= 1;
                y6 += 1;
                if (x6 >= 0 && x6 < 8 && y6 >= 0 && y6 < 8) {
                    if (chessComponents[x6][y6].name == '_') {
                        move.add(new ChessboardPoint(x6, y6));
                    } else if (chessComponents[x6][y6].name >= 'a') {
                        move.add(new ChessboardPoint(x6, y6));
                        break;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
            int x7 = source.getX();
            int y7 = source.getY();
            for (int k = 0; k < 8; k++) {
                x7 -= 1;
                y7 -= 1;
                if (x7 >= 0 && x7 < 8 && y7 >= 0 && y7 < 8) {
                    if (chessComponents[x7][y7].name == '_') {
                        move.add(new ChessboardPoint(x7, y7));
                    } else if (chessComponents[x7][y7].name >= 'a') {
                        move.add(new ChessboardPoint(x7, y7));
                        break;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
            int x8 = source.getX();
            int y8 = source.getY();
            for (int k = 0; k < 8; k++) {
                x8 += 1;
                y8 -= 1;
                if (x8 >= 0 && x8 < 8 && y8 >= 0 && y8 < 8) {
                    if (chessComponents[x8][y8].name == '_') {
                        move.add(new ChessboardPoint(x8, y8));
                    } else if (chessComponents[x8][y8].name >= 'a') {
                        move.add(new ChessboardPoint(x8, y8));
                        break;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
        }

        if (name=='q'){
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
            int x5 = source.getX();
            int y5 = source.getY();
            int k1 = 0;
            while (k1 < 8) {
                x5 += 1;
                if (x5 > 7) break;
                else {
                    if (chessComponents[x5][y5].name == '_') {
                        move.add(new ChessboardPoint(x5, y5));
                    } else if (chessComponents[x5][y5].name < '_') {
                        move.add(new ChessboardPoint(x5, y5));
                        break;
                    } else break;
                }
                k1++;
            }
            int x6 = source.getX();
            int y6 = source.getY();
            int k2 = 0;
            while (k2 < 8) {
                x6 -= 1;
                if (x6 < 0) break;
                else {
                    if (chessComponents[x6][y6].name == '_') {
                        move.add(new ChessboardPoint(x6, y6));
                    } else if (chessComponents[x6][y6].name < '_') {
                        move.add(new ChessboardPoint(x6, y6));
                        break;
                    } else break;
                }
                k2++;
            }
            int x7 = source.getX();
            int y7 = source.getY();
            int k3 = 0;
            while (k3 < 8) {
                y7 += 1;
                if (y7 > 7) break;
                else {
                    if (chessComponents[x7][y7].name == '_') {
                        move.add(new ChessboardPoint(x7, y7));
                    } else if (chessComponents[x7][y7].name < '_') {
                        move.add(new ChessboardPoint(x7, y7));
                        break;
                    } else break;
                }
                k3++;
            }
            int x8 = source.getX();
            int y8 = source.getY();
            int k4 = 0;
            while (k4 < 8) {
                y8 -= 1;
                if (y8 < 0) break;
                else {
                    if (chessComponents[x8][y8].name == '_') {
                        move.add(new ChessboardPoint(x8, y8));
                    } else if (chessComponents[x8][y8].name < '_') {
                        move.add(new ChessboardPoint(x8, y8));
                        break;
                    } else break;
                }
                k4++;
            }
        }
        return move;
    }
}