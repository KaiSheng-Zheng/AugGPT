import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }

    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                switch (chessboard.get(i).charAt(j)) {
                    case 'R':
                        chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'R');
                        break;
                    case 'r':
                        chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'r');
                        break;
                    case 'Q':
                        chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'Q');
                        break;
                    case 'q':
                        chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'q');
                        break;
                    case 'B':
                        chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'B');
                        break;
                    case 'b':
                        chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'b');
                        break;
                    case 'N':
                        chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'N');
                        break;
                    case 'n':
                        chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'n');
                        break;
                    case 'K':
                        chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'K');
                        break;
                    case 'k':
                        chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'k');
                        break;
                    case 'P':
                        chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'P');
                        break;
                    case 'p':
                        chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'p');
                        break;
                    case '_':
                        chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i, j), ChessColor.NONE, '_');
                        break;
                }
            }
        }
        if (chessboard.get(8).charAt(0) == 'w') {
            this.currentPlayer = ChessColor.WHITE;
        } else {
            this.currentPlayer = ChessColor.BLACK;
        }
    }

    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public String getChessboardGraph() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                result.append(chessComponents[i][j].name);
            }
            if (i < 7) {
                result.append("\n");
            }
        }
        return result.toString();
    }

    public String getCapturedChess(ChessColor player) {
        int K = 0, k = 0, Q = 0, q = 0, R = 0, r = 0, B = 0, b = 0, N = 0, n = 0, P = 0, p = 0;
        if (player == ChessColor.WHITE) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    switch (chessComponents[i][j].name) {
                        case 'k':
                            k++;
                            break;
                        case 'q':
                            q++;
                            break;
                        case 'r':
                            r++;
                            break;
                        case 'b':
                            b++;
                            break;
                        case 'n':
                            n++;
                            break;
                        case 'p':
                            p++;
                            break;
                    }
                }
            }
            StringBuilder str = new StringBuilder();
            if (k != 1) {
                str.append("k 1\n");
            }
            if (q != 1) {
                str.append("q 1\n");
            }
            if (r != 2) {
                str.append(String.format("r %d\n", 2 - r));
            }
            if (b != 2) {
                str.append(String.format("b %d\n", 2 - b));
            }
            if (n != 2) {
                str.append(String.format("n %d\n", 2 - n));
            }
            if (p != 8) {
                str.append(String.format("p %d\n", 8 - p));
            }
            return str.toString();
        } else {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    switch (chessComponents[i][j].name) {
                        case 'K':
                            K++;
                            break;
                        case 'Q':
                            Q++;
                            break;
                        case 'R':
                            R++;
                            break;
                        case 'B':
                            B++;
                            break;
                        case 'N':
                            N++;
                            break;
                        case 'P':
                            P++;
                            break;
                    }
                }
            }
            StringBuilder str = new StringBuilder();
            if (K != 1) {
                str.append("K 1\n");
            }
            if (Q != 1) {
                str.append("Q 1\n");
            }
            if (R != 2) {
                str.append(String.format("R %d\n", 2 - R));
            }
            if (B != 2) {
                str.append(String.format("B %d\n", 2 - B));
            }
            if (N != 2) {
                str.append(String.format("N %d\n", 2 - N));
            }
            if (P != 8) {
                str.append(String.format("P %d\n", 8 - P));
            }
            return str.toString();
        }
    }

    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess = chessComponents[source.getX()][source.getY()];
        chess.setChessboard(this.chessComponents);
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        Collections.sort(canMovePoints, new Comparator<ChessboardPoint>() {
            @Override
            public int compare(ChessboardPoint o1, ChessboardPoint o2) {
                if (o1.getX() != o2.getX()) {
                    return o1.getX() - o2.getX();
                } else {
                    return o1.getY() - o2.getY();
                }
            }
        });
        return canMovePoints;
    }

    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        chessComponents[sourceX][sourceY].setChessboard(this.chessComponents);
        if (getChess(sourceX, sourceY).getChessColor() == this.currentPlayer) {
            int a = 0;
            for (int i = 0; i < getChess(sourceX, sourceY).canMoveTo().size(); i++) {
                if (getChess(sourceX, sourceY).canMoveTo().get(i).getX() == targetX && getChess(sourceX, sourceY).canMoveTo().get(i).getY() == targetY) {
                    a++;
                    chessComponents[targetX][targetY] = getChess(sourceX,sourceY);
                    chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX, targetY));
                    chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX, sourceY), ChessColor.NONE, '_');
                    break;
                }
            }
            if (a != 0) {
                if (this.currentPlayer == ChessColor.WHITE) {
                    this.currentPlayer = ChessColor.BLACK;
                } else {
                    this.currentPlayer = ChessColor.WHITE;
                }
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
