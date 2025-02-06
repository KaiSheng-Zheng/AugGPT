import java.util.List;
import java.util.Objects;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private static ChessComponent[][] chessComponents0;
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
        chessComponents = new ChessComponent[8][8];
        chessComponents0 = new ChessComponent[8][8];
        currentPlayer = ChessColor.WHITE;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        char[][] chars = new char[8][8];
        for (int i=0; i<8; i++) {
            chars[i] = chessboard.get(i).toCharArray();
        }
        String player = chessboard.get(8);
        if (Objects.equals(player, "w")) {
            currentPlayer = ChessColor.WHITE;
        }
        else if (Objects.equals(player, "b")) {
            currentPlayer = ChessColor.BLACK;
        }
        for (int i=0; i<8; i++) {
            for (int j=0; j<8; j++) {
                if (chars[i][j] == 'K' || chars[i][j] == 'k') {
                    chessComponents[i][j] = new KingChessComponent();
                    chessComponents0[i][j] = new KingChessComponent();
                }
                else if (chars[i][j] == 'Q' || chars[i][j] == 'q') {
                    chessComponents[i][j] = new QueenChessComponent();
                    chessComponents0[i][j] = new QueenChessComponent();
                }
                else if (chars[i][j] == 'R' || chars[i][j] == 'r') {
                    chessComponents[i][j] = new RookChessComponent();
                    chessComponents0[i][j] = new RookChessComponent();
                }
                else if (chars[i][j] == 'B' || chars[i][j] == 'b') {
                    chessComponents[i][j] = new BishopChessComponent();
                    chessComponents0[i][j] = new BishopChessComponent();
                }
                else if (chars[i][j] == 'N' || chars[i][j] == 'n') {
                    chessComponents[i][j] = new KnightChessComponent();
                    chessComponents0[i][j] = new KnightChessComponent();
                }
                else if (chars[i][j] == 'P' || chars[i][j] == 'p') {
                    chessComponents[i][j] = new PawnChessComponent();
                    chessComponents0[i][j] = new PawnChessComponent();
                }
                else {
                    chessComponents[i][j] = new EmptySlotComponent();
                    chessComponents0[i][j] = new EmptySlotComponent();
                }
                chessComponents0[i][j].name = chars[i][j];
                chessComponents0[i][j].setSource(i, j);
                chessComponents0[i][j].setChessColor(chars[i][j]);
                chessComponents[i][j] = chessComponents0[i][j];
            }
        }
    }

    public static ChessComponent[][] getChessComponents0() {
        return chessComponents0;
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph() {
        char[][] chars0 = new char[8][8];
        for (int i=0; i<8; i++) {
            for (int j=0; j<8; j++) {
                chars0[i][j] = getChess(i, j).name;
            }
        }
        String string = "";
        for (int i=0; i<8; i++) {
            string = string.concat(String.valueOf(chars0[i])) + "\n";
        }
        return string;
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int K = 1, Q = 1, k = 1, q = 1;
        int R = 2, B = 2, N = 2, r = 2, b = 2, n = 2;
        int P = 8, p = 8;
        for (int i=0; i<8; i++) {
            for (int j = 0; j < 8; j++) {
                if (getChess(i, j).name == 'K') {
                    K = K-1;
                }
                else if (getChess(i, j).name == 'Q') {
                    Q = Q-1;
                }
                else if (getChess(i, j).name == 'k') {
                    k = k-1;
                }
                else if (getChess(i, j).name == 'q') {
                    q = q-1;
                }
                else if (getChess(i, j).name == 'R') {
                    R = R-1;
                }
                else if (getChess(i, j).name == 'B') {
                    B = B-1;
                }
                else if (getChess(i, j).name == 'N') {
                    N = N-1;
                }
                else if (getChess(i, j).name == 'r') {
                    r = r-1;
                }
                else if (getChess(i, j).name == 'b') {
                    b = b-1;
                }
                else if (getChess(i, j).name == 'n') {
                    n = n-1;
                }
                else if (getChess(i, j).name == 'P') {
                    P = P-1;
                }
                else if (getChess(i, j).name == 'p') {
                    p = p-1;
                }
            }
        }
        String string1 = "";
        if (K!=0) {
            string1 = string1.concat("K " + K + "\n");
        }
        if (Q!=0) {
            string1 = string1.concat("Q " + Q + "\n");
        }
        if (R!=0) {
            string1 = string1.concat("R " + R + "\n");
        }
        if (B!=0) {
            string1 = string1.concat("B " + B + "\n");
        }
        if (N!=0) {
            string1 = string1.concat("N " + N + "\n");
        }
        if (P!=0) {
            string1 = string1.concat("P " + P + "\n");
        }

        String string2 = "";
        if (k!=0) {
            string2 = string2.concat("k " + k + "\n");
        }
        if (q!=0) {
            string2 = string2.concat("q " + q + "\n");
        }
        if (r!=0) {
            string2 = string2.concat("r " + r + "\n");
        }
        if (b!=0) {
            string2 = string2.concat("b " + b + "\n");
        }
        if (n!=0) {
            string2 = string2.concat("n " + n + "\n");
        }
        if (p!=0) {
            string2 = string2.concat("p " + p + "\n");
        }
        if (player == ChessColor.BLACK) {
            return string1;
        }
        else {
            return string2;
        }
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> canMovePoints = getChess(source.getX(), source.getY()).canMoveTo();
        ChessboardPoint k;
        for (int i=0; i<canMovePoints.size()-1; i++) {
            for (int j=0; j<canMovePoints.size()-1-i; j++) {
                if (canMovePoints.get(j).getX() > canMovePoints.get(j+1).getX()) {
                    k = canMovePoints.get(j);
                    canMovePoints.set(j, canMovePoints.get(j+1));
                    canMovePoints.set(j+1, k);
                }
            }
        }
        for (int i=0; i<canMovePoints.size()-1; i++) {
            for (int j=0; j<canMovePoints.size()-1-i; j++) {
                if (canMovePoints.get(j).getX() == canMovePoints.get(j+1).getX() && canMovePoints.get(j).getY() > canMovePoints.get(j+1).getY()) {
                    k = canMovePoints.get(j);
                    canMovePoints.set(j, canMovePoints.get(j+1));
                    canMovePoints.set(j+1, k);
                }
            }
        }
        return canMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (getChess(sourceX,sourceY).getChessColor() == currentPlayer) {
            ChessComponent n = getChess(sourceX,sourceY);
            chessComponents0[sourceX][sourceY] = new EmptySlotComponent();
            chessComponents[sourceX][sourceY] = new EmptySlotComponent();
            chessComponents0[sourceX][sourceY].setSource(sourceX,sourceY);
            chessComponents[sourceX][sourceY].setSource(sourceX,sourceY);
            chessComponents0[sourceX][sourceY].name =  '_';
            chessComponents[sourceX][sourceY].name =  '_';
            chessComponents0[targetX][targetY] = n;
            chessComponents[targetX][targetY] = n;
            chessComponents0[targetX][targetY].setSource(targetX,targetY);
            chessComponents[targetX][targetY].setSource(targetX,targetY);
            if (getCurrentPlayer() == ChessColor.WHITE) {
                currentPlayer = ChessColor.BLACK;
            }
            else if (getCurrentPlayer() == ChessColor.BLACK) {
                currentPlayer = ChessColor.WHITE;
            }
            return true;
        }
        else {
            return false;
        }
    }

    public boolean resist(ChessComponent chess, int targetX, int targetY) {
        if (chess.name == 'K' || chess.name == 'k') {
            return getChess(targetX, targetY).getChessColor() == chess.getChessColor();
        }
        if (chess.name == 'Q' || chess.name == 'q') {
            if (chess.getSource().getX() == targetX) {
                if (targetY > chess.getSource().getY()) {
                    for (int i=1; i<=targetY-chess.getSource().getY()+1 ; i++) {
                        return false;
                    }
                }
            }
        }
        return false;
    }
}