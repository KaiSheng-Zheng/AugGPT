import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessComponent[][] chessComponents;

    public RookChessComponent(char r, ChessComponent[][] chessComponents, ChessboardPoint chessboardPoint) {
        super(r, chessComponents, chessboardPoint);
        this.name=r;
        this.chessComponents=chessComponents;
        this.source=chessboardPoint;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> move = new ArrayList<>();
        if (name == 'R') {
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
        }

        if (name=='r'){
            int x1 = source.getX();
            int y1 = source.getY();
            int k1 = 0;
            while (k1 < 8) {
                x1 += 1;
                if (x1 > 7) break;
                else {
                    if (chessComponents[x1][y1].name == '_') {
                        move.add(new ChessboardPoint(x1, y1));
                    } else if (chessComponents[x1][y1].name < '_') {
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
                    } else if (chessComponents[x2][y2].name < '_') {
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
                    } else if (chessComponents[x3][y3].name < '_') {
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
                    } else if (chessComponents[x4][y4].name < '_') {
                        move.add(new ChessboardPoint(x4, y4));
                        break;
                    } else break;
                }
                k4++;
            }
        }
        return move;
    }
}