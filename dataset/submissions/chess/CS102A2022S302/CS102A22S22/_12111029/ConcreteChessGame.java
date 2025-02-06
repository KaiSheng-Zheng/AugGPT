import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer = ChessColor.WHITE;

    public ConcreteChessGame(ChessColor currentPlayer) {
        super();
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = currentPlayer;
    }

    public ConcreteChessGame() {
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        if (chessboard.get(8).equals("w")) {
            currentPlayer = ChessColor.WHITE;
        } else if (chessboard.get(8).equals("b")) {
            currentPlayer = ChessColor.BLACK;
        }
        for (int i = 0; i < chessComponents.length; i++) {
            for (int j = 0; j < chessComponents[i].length; j++) {
                if (chessboard.get(i).charAt(j) == '_') {
                    chessComponents[i][j] = new EmptySlotComponent();
                    chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                    chessComponents[i][j].setChessColor(ChessColor.NONE);
                    chessComponents[i][j].setName('_');
                    chessComponents[i][j].setChessboard(this.getChessComponents());
                }
                if (Character.isUpperCase(chessboard.get(i).charAt(j))) {
                    if (chessboard.get(i).charAt(j) == 'K') {
                        chessComponents[i][j] = new KingChessComponent();
                        chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        chessComponents[i][j].setName('K');
                        chessComponents[i][j].setChessboard(this.getChessComponents());
                    } else if (chessboard.get(i).charAt(j) == 'Q') {
                        chessComponents[i][j] = new QueenChessComponent();
                        chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        chessComponents[i][j].setName('Q');
                        chessComponents[i][j].setChessboard(this.getChessComponents());
                    } else if (chessboard.get(i).charAt(j) == 'R') {
                        chessComponents[i][j] = new RookChessComponent();
                        chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        chessComponents[i][j].setName('R');
                        chessComponents[i][j].setChessboard(this.getChessComponents());
                    } else if (chessboard.get(i).charAt(j) == 'B') {
                        chessComponents[i][j] = new BishopChessComponent();
                        chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        chessComponents[i][j].setName('B');
                        chessComponents[i][j].setChessboard(this.getChessComponents());
                    } else if (chessboard.get(i).charAt(j) == 'N') {
                        chessComponents[i][j] = new KnightChessComponent();
                        chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        chessComponents[i][j].setName('N');
                        chessComponents[i][j].setChessboard(this.getChessComponents());
                    } else if (chessboard.get(i).charAt(j) == 'P') {
                        chessComponents[i][j] = new PawnChessComponent();
                        chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        chessComponents[i][j].setName('P');
                        chessComponents[i][j].setChessboard(this.getChessComponents());
                    }
                } else if (Character.isLowerCase(chessboard.get(i).charAt(j))) {
                    if (chessboard.get(i).charAt(j) == 'k') {
                        chessComponents[i][j] = new KingChessComponent();
                        chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        chessComponents[i][j].setName('k');
                        chessComponents[i][j].setChessboard(this.getChessComponents());
                    } else if (chessboard.get(i).charAt(j) == 'q') {
                        chessComponents[i][j] = new QueenChessComponent();
                        chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        chessComponents[i][j].setName('q');
                        chessComponents[i][j].setChessboard(this.getChessComponents());
                    } else if (chessboard.get(i).charAt(j) == 'r') {
                        chessComponents[i][j] = new RookChessComponent();
                        chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        chessComponents[i][j].setName('r');
                        chessComponents[i][j].setChessboard(this.getChessComponents());
                    } else if (chessboard.get(i).charAt(j) == 'b') {
                        chessComponents[i][j] = new BishopChessComponent();
                        chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        chessComponents[i][j].setName('b');
                        chessComponents[i][j].setChessboard(this.getChessComponents());
                    } else if (chessboard.get(i).charAt(j) == 'n') {
                        chessComponents[i][j] = new KnightChessComponent();
                        chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        chessComponents[i][j].setName('n');
                        chessComponents[i][j].setChessboard(this.getChessComponents());
                    } else if (chessboard.get(i).charAt(j) == 'p') {
                        chessComponents[i][j] = new PawnChessComponent();
                        chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        chessComponents[i][j].setName('p');
                        chessComponents[i][j].setChessboard(this.getChessComponents());
                    }
                }
            }
        }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public String getChessboardGraph() {
        String sTemp = "";
        ArrayList<String> temp = new ArrayList<>();
        for (int i = 0; i < chessComponents.length; i++) {
            for (int j = 0; j < chessComponents[i].length; j++) {
                sTemp = sTemp.concat(String.valueOf(chessComponents[i][j].name));
            }
            temp.add(sTemp);
            sTemp = "";
        }
        return temp.get(0) + "\n" + temp.get(1) + "\n" + temp.get(2) + "\n" + temp.get(3) + "\n" + temp.get(4) + "\n" + temp.get(5) + "\n" + temp.get(6) + "\n" + temp.get(7);
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int K = 1, Q = 1, R = 2, B = 2, N = 2, P = 8, k = 1, q = 1, r = 2, b = 2, n = 2, p = 8;
        for (int i = 0; i < chessComponents.length; i++) {
            for (int j = 0; j < chessComponents[i].length; j++) {
                if (chessComponents[i][j].name == 'K') {
                    K--;
                } else if (chessComponents[i][j].name == 'Q') {
                    Q--;
                } else if (chessComponents[i][j].name == 'R') {
                    R--;
                } else if (chessComponents[i][j].name == 'B') {
                    B--;
                } else if (chessComponents[i][j].name == 'N') {
                    N--;
                } else if (chessComponents[i][j].name == 'P') {
                    P--;
                } else if (chessComponents[i][j].name == 'k') {
                    k--;
                } else if (chessComponents[i][j].name == 'q') {
                    q--;
                } else if (chessComponents[i][j].name == 'r') {
                    r--;
                } else if (chessComponents[i][j].name == 'b') {
                    b--;
                } else if (chessComponents[i][j].name == 'n') {
                    n--;
                } else if (chessComponents[i][j].name == 'p') {
                    p--;
                }
            }
        }
        String kb = K == 0 ? "" : "K " + K + "\n";
        String qb = Q == 0 ? "" : "Q " + Q + "\n";
        String rb = R == 0 ? "" : "R " + R + "\n";
        String bb = B == 0 ? "" : "B " + B + "\n";
        String nb = N == 0 ? "" : "N " + N + "\n";
        String pb = P == 0 ? "" : "P " + P + "\n";
        String kw = k == 0 ? "" : "k " + k + "\n";
        String qw = q == 0 ? "" : "q " + q + "\n";
        String rw = r == 0 ? "" : "r " + r + "\n";
        String bw = b == 0 ? "" : "b " + b + "\n";
        String nw = n == 0 ? "" : "n " + n + "\n";
        String pw = p == 0 ? "" : "p " + p + "\n";
        if (player.equals(ChessColor.BLACK)) {
            return kb + qb + rb + bb + nb + pb;
        } else if (player.equals(ChessColor.WHITE)) {
            return kw + qw + rw + bw + nw + pw;
        }
        return null;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (chessComponents[sourceX][sourceY].getChessColor().equals(currentPlayer)) {
        } else {
            return false;
        }
        for (int i = 0; i < chessComponents[sourceX][sourceY].canMoveTo().size(); i++) {
            if (chessComponents[sourceX][sourceY].canMoveTo().get(i).toString().equals("(" + targetX + "," + targetY + ")")) {
                chessComponents[sourceX][sourceY].setSource(new ChessboardPoint(targetX, targetY));
                chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                if (currentPlayer.equals(ChessColor.BLACK)) {
                    currentPlayer = ChessColor.WHITE;
                } else if (currentPlayer.equals(ChessColor.WHITE)) {
                    currentPlayer = ChessColor.BLACK;
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ArrayList<ChessboardPoint> gCMP;
        ChessComponent chessTemp = chessComponents[source.getX()][source.getY()];
        gCMP = (ArrayList<ChessboardPoint>) chessTemp.canMoveTo();
        gCMP.sort(new Comparator<ChessboardPoint>() {
            int flag = 0;

            @Override
            public int compare(ChessboardPoint point1, ChessboardPoint point2) {
                if (point1.getX() < point2.getX()) {
                    return -1;
                } else if (point1.getX() == point2.getX() && point1.getY() < point2.getY()) {
                    return -1;
                } else if (point1.getX() > point2.getX()) {
                    return 1;
                } else if (point1.getX() == point2.getX() && point1.getY() > point2.getY()) {
                    return 1;
                }
                return 1;
            }
        });
        return gCMP;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }
}
