

import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < chessboard.size() - 1; i++) {
            for (int j = 0; j < chessboard.get(i).length(); j++) {
                if (chessboard.get(i).charAt(j) == 'R') {
                    chessComponents[i][j] = new RookChessComponent('R', ChessColor.BLACK, new ChessboardPoint(i, j));
                }
                if (chessboard.get(i).charAt(j) == 'N') {
                    chessComponents[i][j] = new KnightChessComponent('N', ChessColor.BLACK, new ChessboardPoint(i, j));
                }
                if (chessboard.get(i).charAt(j) == 'B') {
                    chessComponents[i][j] = new BishopChessComponent('B', ChessColor.BLACK, new ChessboardPoint(i, j));
                }
                if (chessboard.get(i).charAt(j) == 'Q') {
                    chessComponents[i][j] = new QueenChessComponent('Q', ChessColor.BLACK, new ChessboardPoint(i, j));
                }
                if (chessboard.get(i).charAt(j) == 'K') {
                    chessComponents[i][j] = new KingChessComponent('K', ChessColor.BLACK, new ChessboardPoint(i, j));
                }
                if (chessboard.get(i).charAt(j) == 'P') {
                    chessComponents[i][j] = new PawnChessComponent('P', ChessColor.BLACK, new ChessboardPoint(i, j));
                }
                if (chessboard.get(i).charAt(j) == 'r') {
                    chessComponents[i][j] = new RookChessComponent('r', ChessColor.WHITE, new ChessboardPoint(i, j));
                }
                if (chessboard.get(i).charAt(j) == 'n') {
                    chessComponents[i][j] = new KnightChessComponent('n', ChessColor.WHITE, new ChessboardPoint(i, j));
                }
                if (chessboard.get(i).charAt(j) == 'b') {
                    chessComponents[i][j] = new BishopChessComponent('b', ChessColor.WHITE, new ChessboardPoint(i, j));
                }
                if (chessboard.get(i).charAt(j) == 'q') {
                    chessComponents[i][j] = new QueenChessComponent('q', ChessColor.WHITE, new ChessboardPoint(i, j));
                }
                if (chessboard.get(i).charAt(j) == 'k') {
                    chessComponents[i][j] = new KingChessComponent('k', ChessColor.WHITE, new ChessboardPoint(i, j));
                }
                if (chessboard.get(i).charAt(j) == 'p') {
                    chessComponents[i][j] = new PawnChessComponent('p', ChessColor.WHITE, new ChessboardPoint(i, j));
                }
                if (chessboard.get(i).charAt(j) == '_') {
                    chessComponents[i][j] = new EmptySlotComponent('_', ChessColor.NONE, new ChessboardPoint(i, j));
                }
            }
        }

        if (chessboard.get(chessboard.size() - 1).charAt(0) == 'w') {
            currentPlayer = ChessColor.WHITE;
        } else if (chessboard.get(chessboard.size() - 1).charAt(0) == 'b') {
            currentPlayer = ChessColor.BLACK;
        }
//        for (ChessComponent[] chessComponent : chessComponents) {
//            for (ChessComponent component : chessComponent) {
//                System.out.print(component.getName());
//                System.out.print(component.getChessColor());
//                System.out.print(component.getSource());
//                System.out.println();
//            }
//        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessComponent component = chessComponents[i][j];
                component.setChessComponents(getChessComponents());
            }
        }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph() {
        String[] strings = new String[8];
        for (int i = 0; i < 8; i++) {
            strings[i] = " ";
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                strings[i] = strings[i].concat(String.valueOf(chessComponents[i][j].getName()));
            }
        }
        return strings[0].substring(1) + "\n" + strings[1].substring(1) + "\n" + strings[2].substring(1) + "\n" + strings[3].substring(1)
                + "\n" + strings[4].substring(1) + "\n" + strings[5].substring(1) + "\n"
                + strings[6].substring(1) + "\n" + strings[7].substring(1);
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int R = 2;
        int N = 2;
        int B = 2;
        int Q = 1;
        int K = 1;
        int P = 8;
        int r = 2;
        int n = 2;
        int b = 2;
        int q = 1;
        int k = 1;
        int p = 8;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessComponents[i][j].getName() == 'R') {
                    R = R - 1;
                }
                if (chessComponents[i][j].getName() == 'N') {
                    N = N - 1;
                }
                if (chessComponents[i][j].getName() == 'B') {
                    B = B - 1;
                }
                if (chessComponents[i][j].getName() == 'Q') {
                    Q = Q - 1;
                }
                if (chessComponents[i][j].getName() == 'K') {
                    K = K - 1;
                }
                if (chessComponents[i][j].getName() == 'P') {
                    P = P - 1;
                }
                if (chessComponents[i][j].getName() == 'r') {
                    r = r - 1;
                }
                if (chessComponents[i][j].getName() == 'n') {
                    n = n - 1;
                }
                if (chessComponents[i][j].getName() == 'b') {
                    b = b - 1;
                }
                if (chessComponents[i][j].getName() == 'q') {
                    q = q - 1;
                }
                if (chessComponents[i][j].getName() == 'k') {
                    k = k - 1;
                }
                if (chessComponents[i][j].getName() == 'p') {
                    p = p - 1;
                }
            }
        }
        String BS = " ";
        String WS = " ";
        if (K != 0) {
            BS = BS.concat(String.format("K %d", K));
        }
        if (Q != 0) {
            BS = BS.concat(String.format("\nQ %d", Q));
        }
        if (R != 0) {
            BS = BS.concat(String.format("\nR %d", R));
        }
        if (B != 0) {
            BS = BS.concat(String.format("\nB %d", B));
        }
        if (N != 0) {
            BS = BS.concat(String.format("\nN %d", N));
        }
        if (P != 0) {
            BS = BS.concat(String.format("\nP %d", P));
        }
        if (k != 0) {
            WS = WS.concat(String.format("k %d", k));
        }
        if (q != 0) {
            WS = WS.concat(String.format("\nq %d", q));
        }
        if (r != 0) {
            WS = WS.concat(String.format("\nr %d", r));
        }
        if (b != 0) {
            WS = WS.concat(String.format("\nb %d", b));
        }
        if (n != 0) {
            WS = WS.concat(String.format("\nn %d", n));
        }
        if (p != 0) {
            WS = WS.concat(String.format("\np %d", p));
        }
        if (player == ChessColor.BLACK) {
            return BS.substring(1) + "\n";
        } else if (player == ChessColor.WHITE) {
            return WS.substring(1) + "\n";
        } else return null;
    }
    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> canMovePoints = chessComponents[source.getX()][source.getY()].canMoveTo();
        if (canMovePoints.size() == 0) {
            return canMovePoints;
        } else if (canMovePoints.size() == 1) {
            return canMovePoints;
        } else {
            int k;
            for (int i = 0; i < canMovePoints.size() - 1; i++) {
                k = i;
                for (int j = i + 1; j < canMovePoints.size(); j++) {
                    if (canMovePoints.get(j).getX() < canMovePoints.get(k).getX()) {
                        k = j;
                        ChessboardPoint C = canMovePoints.get(k);
                        if (k != i) {
                            canMovePoints.set(k, canMovePoints.get(i));
                            canMovePoints.set(i, C);
                        }
                    }
                }
            }
            for (int i = 0; i < canMovePoints.size() - 1; i++) {
                k = i;
                for (int j = i + 1; j < canMovePoints.size(); j++) {
                    if (canMovePoints.get(j).getX() == canMovePoints.get(k).getX() && canMovePoints.get(j).getY() < canMovePoints.get(k).getY()) {
                        k = j;
                        ChessboardPoint C = canMovePoints.get(k);
                        if (k != i) {
                            canMovePoints.set(k, canMovePoints.get(i));
                            canMovePoints.set(i, C);
                        }
                    }
                }
            }
            return canMovePoints;
        }
    }



    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        int a = 0;
        if (targetX > 7 || targetX < 0 || targetY > 7 || targetY < 0 || sourceX > 7 || sourceX < 0 || sourceY > 7 || sourceY < 0) {
            return false;
        } else if (chessComponents[sourceX][sourceY].getChessColor() == chessComponents[targetX][targetY].getChessColor() && chessComponents[sourceX][sourceY].getChessColor() != getCurrentPlayer()) {
            return false;
        } else {
            for (int i = 0; i < chessComponents[sourceX][sourceY].canMoveTo().size(); i++) {
                if (chessComponents[sourceX][sourceY].canMoveTo().get(i) == chessComponents[targetX][targetY].getSource()) {
                    a = 1;
                    break;
                }
            }
        }
        if (a == 0) {
            return false;
        }else {
            {if (currentPlayer == ChessColor.BLACK) {
                currentPlayer = ChessColor.WHITE;
            } else if (currentPlayer==ChessColor.WHITE){
                currentPlayer = ChessColor.BLACK;
            }}
            chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
            chessComponents[sourceX][sourceY] = new EmptySlotComponent('_', ChessColor.NONE, new ChessboardPoint(sourceX, sourceY));
            return true;
        }
    }
}
