import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    public static ChessComponent[][] chessComponentsCopy;
    private ChessColor currentPlayer;
    private List<String> chessboard;

    public ConcreteChessGame() {
        chessComponents = new ChessComponent[8][8];
        currentPlayer = ChessColor.WHITE;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        this.chessboard = chessboard;
        if (chessboard != null && chessboard.size() > 0) {
            System.out.println("List<String> chessboard;");
            for (int i = 0; i < chessboard.size() - 1; i++) {
                System.out.println("chessboard.get(" + i + ") equals to \"" + chessboard.get(i) + "\";");
                for (int j = 0; j < chessboard.get(i).split("").length; j++) {
                    switch (chessboard.get(i).split("")[j]) {
                        case "R":
                            chessComponents[i][j] = new RookChessComponent('R', new ChessboardPoint(i, j), ChessColor.BLACK);
                            break;
                        case "r":
                            chessComponents[i][j] = new RookChessComponent('r', new ChessboardPoint(i, j), ChessColor.WHITE);
                            break;
                        case "N":
                            chessComponents[i][j] = new KnightChessComponent('N', new ChessboardPoint(i, j), ChessColor.BLACK);
                            break;
                        case "n":
                            chessComponents[i][j] = new KnightChessComponent('n', new ChessboardPoint(i, j), ChessColor.WHITE);
                            break;
                        case "B"://
                            chessComponents[i][j] = new BishopChessComponent('B', new ChessboardPoint(i, j), ChessColor.BLACK);
                            break;
                        case "b":
                            chessComponents[i][j] = new BishopChessComponent('b', new ChessboardPoint(i, j), ChessColor.WHITE);
                            break;
                        case "Q"://
                            chessComponents[i][j] = new QueenChessComponent('Q', new ChessboardPoint(i, j), ChessColor.BLACK);
                            break;
                        case "q":
                            chessComponents[i][j] = new QueenChessComponent('q', new ChessboardPoint(i, j), ChessColor.WHITE);
                            break;
                        case "K"://
                            chessComponents[i][j] = new KingChessComponent('K', new ChessboardPoint(i, j), ChessColor.BLACK);
                            break;
                        case "k":
                            chessComponents[i][j] = new KingChessComponent('k', new ChessboardPoint(i, j), ChessColor.WHITE);
                            break;
                        case "P"://
                            chessComponents[i][j] = new PawnChessComponent('P', new ChessboardPoint(i, j), ChessColor.BLACK);
                            break;
                        case "p":
                            chessComponents[i][j] = new PawnChessComponent('p', new ChessboardPoint(i, j), ChessColor.WHITE);
                            break;
                        default:
                            chessComponents[i][j] = new EmptySlotComponent('_', new ChessboardPoint(i, j), ChessColor.NONE);
                            break;
                    }
                }
            }
            if (chessboard.get(chessboard.size() - 1).equals("w")) {
                currentPlayer = ChessColor.WHITE;
            } else {
                currentPlayer = ChessColor.BLACK;
            }
        }
        chessComponentsCopy = chessComponents;
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
        String temp = "";
        for (int i = 0; i < chessboard.size() - 1; i++) {
            if (i == chessboard.size() - 2) {
                temp += chessboard.get(i);
            } else {
                temp += chessboard.get(i) + "\n";
            }
        }
        return temp;
    }

    @Override
    public String getCapturedChess(ChessColor player) {

        String temp = "";
        if ("BLACK".equals(player.name())) {
            int K = 1;
            int Q = 1;
            int R = 2;
            int B = 2;
            int N = 2;
            int P = 8;
            for (int i = 0; i < chessComponents.length; i++) {
                for (int j = 0; j < chessComponents[i].length; j++) {
                    switch (chessComponents[i][j].getName()) {
                        case 'R':
                            R--;
                            break;
                        case 'N':
                            N--;
                            break;
                        case 'B':
                            B--;
                            break;
                        case 'Q':
                            Q--;
                            break;
                        case 'K':
                            K--;
                            break;
                        case 'P':
                            P--;
                            break;
                    }
                }
            }
            if (K > 0) {
                temp += "K " + K + "\n";
            }
            if (Q > 0) {
                temp += "Q " + Q + "\n";
            }
            if (R > 0) {
                temp += "R " + R + "\n";
            }
            if (B > 0) {
                temp += "B " + B + "\n";
            }
            if (N > 0) {
                temp += "N " + N + "\n";
            }
            if (P > 0) {
                temp += "P " + P + "\n";
            }
            return temp;
        } else if ("WHITE".equals(player.name())) {
            int k = 1;
            int q = 1;
            int r = 2;
            int b = 2;
            int n = 2;
            int p = 8;
            for (int i = 0; i < chessComponents.length; i++) {
                for (int j = 0; j < chessComponents[i].length; j++) {
                    switch (chessComponents[i][j].getName()) {
                        case 'r':
                            r--;
                            break;
                        case 'n':
                            n--;
                            break;
                        case 'b':
                            b--;
                            break;
                        case 'q':
                            q--;
                            break;
                        case 'k':
                            k--;
                            break;
                        case 'p':
                            p--;
                            break;


                    }

                }
            }
            if (k > 0) {
                temp += "k " + k + "\n";
            }
            if (q > 0) {
                temp += "q " + q + "\n";
            }
            if (r > 0) {
                temp += "r " + r + "\n";
            }
            if (b > 0) {
                temp += "b " + b + "\n";
            }
            if (n > 0) {
                temp += "n " + n + "\n";
            }
            if (p > 0) {
                temp += "p " + p + "\n";
            }
            return temp;
        }

        return "";
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {

        return chessComponents[source.getX()][source.getY()].canMoveTo();
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessComponent component = chessComponents[sourceX][sourceY];
        if (currentPlayer.name() == component.getChessColor().name()) {
            if (component.canMoveTo().size() > 0) {
                for (ChessboardPoint chessboardPoint : component.canMoveTo()) {
                    if (targetX == chessboardPoint.getX() && targetY == chessboardPoint.getY()) {
                        if (currentPlayer.name() == component.getChessColor().name()) {
                            chessComponents[sourceX][sourceY] = new EmptySlotComponent('_', new ChessboardPoint(sourceX, sourceY), ChessColor.NONE);
                            component.setSource(new ChessboardPoint(targetX, targetY));
                            chessComponents[targetX][targetY] = component;
                            if ("WHITE".equals(currentPlayer.name())) {
                                currentPlayer = ChessColor.BLACK;
                            } else {
                                currentPlayer = ChessColor.WHITE;
                            }
                            return true;
                        }
                    }
                }
            }
        }


        return false;
    }
}