
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    // A 2-dimension array to store all the chess components
// should be initialized in your construct method.
// i.e. = new ChessComponent[8][8]
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];

    // What's the current player's color, black or white?
// should be initialized in your construct method.
// by default, set the color to white.
    private ChessColor currentPlayer = ChessColor.WHITE;

    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }


    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
//                ChessComponent chessComponent = null;
                if ((chessboard.get(i).charAt(j) == 'K') || (chessboard.get(i).charAt(j) == 'k')){
                    chessComponents[i][j] = new KingChessComponent(i,j,chessboard.get(i).charAt(j));
                }
                if ((chessboard.get(i).charAt(j) == 'Q') || (chessboard.get(i).charAt(j) == 'q')){
                    chessComponents[i][j] = new QueenChessComponent(i,j,chessboard.get(i).charAt(j));
                }
                if ((chessboard.get(i).charAt(j) == 'B') || (chessboard.get(i).charAt(j) == 'b')){
                    chessComponents[i][j] = new BishopChessComponent(i,j,chessboard.get(i).charAt(j));
                }
                if ((chessboard.get(i).charAt(j) == 'N') || (chessboard.get(i).charAt(j) == 'n')){
                    chessComponents[i][j] = new KnightChessComponent(i,j,chessboard.get(i).charAt(j));
                }
                if ((chessboard.get(i).charAt(j) == 'R') || (chessboard.get(i).charAt(j) == 'r')){
                    chessComponents[i][j] = new RookChessComponent(i,j,chessboard.get(i).charAt(j));
                }
                if ((chessboard.get(i).charAt(j) == 'P') || (chessboard.get(i).charAt(j) == 'p')){
                    chessComponents[i][j] = new PawnChessComponent(i,j,chessboard.get(i).charAt(j));
                }
                if (chessboard.get(i).charAt(j) == '_'){
                    chessComponents[i][j] = new EmptySlotComponent(i,j,chessboard.get(i).charAt(j));
                }
                chessComponents[i][j].setChessboard(chessComponents);
//                chessComponents[i][j] = chessComponent;
            }
        }
        if (chessboard.get(8).equals("b")) {
            currentPlayer = ChessColor.BLACK;
        } else {
            currentPlayer = ChessColor.WHITE;
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
        StringBuilder graph = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessComponents[i][j] instanceof EmptySlotComponent){
                    graph.append('_');
                }else if (chessComponents[i][j].getChessColor() == ChessColor.WHITE) {
                    graph.append((char) (chessComponents[i][j].name - 'A' + 'a'));
                } else {
                    graph.append(chessComponents[i][j].name);
                }
            }
            graph.append("\n");
        }
        return graph.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        StringBuilder capturedChessBlack = new StringBuilder();
        StringBuilder capturedChessWhite = new StringBuilder();
        int K = 1, k = 1, Q = 1, q = 1, R = 2, r = 2, B = 2, b = 2, N = 2, n = 2, P = 8, p = 8;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessComponents[i][j] instanceof KingChessComponent) {
                    if (chessComponents[i][j].getChessColor().equals(ChessColor.BLACK)) {
                        K--;
                    }
                    if (chessComponents[i][j].getChessColor().equals(ChessColor.WHITE)) {
                        k--;
                    }
                }
                if (chessComponents[i][j] instanceof QueenChessComponent) {
                    if (chessComponents[i][j].getChessColor().equals(ChessColor.BLACK)) {
                        Q--;
                    }
                    if (chessComponents[i][j].getChessColor().equals(ChessColor.WHITE)) {
                        q--;
                    }
                }
                if (chessComponents[i][j] instanceof RookChessComponent) {
                    if (chessComponents[i][j].getChessColor().equals(ChessColor.BLACK)) {
                        R--;
                    }
                    if (chessComponents[i][j].getChessColor().equals(ChessColor.WHITE)) {
                        r--;
                    }
                }
                if (chessComponents[i][j] instanceof PawnChessComponent) {
                    if (chessComponents[i][j].getChessColor().equals(ChessColor.BLACK)) {
                        P--;
                    }
                    if (chessComponents[i][j].getChessColor().equals(ChessColor.WHITE)) {
                        p--;
                    }
                }
                if (chessComponents[i][j] instanceof KnightChessComponent) {
                    if (chessComponents[i][j].getChessColor().equals(ChessColor.BLACK)) {
                        N--;
                    }
                    if (chessComponents[i][j].getChessColor().equals(ChessColor.WHITE)) {
                        n--;
                    }
                }
                if (chessComponents[i][j] instanceof BishopChessComponent) {
                    if (chessComponents[i][j].getChessColor().equals(ChessColor.BLACK)) {
                        B--;
                    }
                    if (chessComponents[i][j].getChessColor().equals(ChessColor.WHITE)) {
                        b--;
                    }
                }
            }
        }
        if (K > 0) {
            capturedChessBlack.append("K " + K + "\n");
        }
        if (k > 0) {
            capturedChessWhite.append("k " + k + "\n");
        }
        if (Q > 0) {
            capturedChessBlack.append("Q " + Q + "\n");
        }
        if (q > 0) {
            capturedChessWhite.append("q " + q + "\n");
        }
        if (R > 0) {
            capturedChessBlack.append("R " + R + "\n");
        }
        if (r > 0) {
            capturedChessWhite.append("r " + r + "\n");
        }
        if (B > 0) {
            capturedChessBlack.append("B " + B + "\n");
        }
        if (b > 0) {
            capturedChessWhite.append("b " + b + "\n");
        }
        if (N > 0) {
            capturedChessBlack.append("N " + N + "\n");
        }
        if (n > 0) {
            capturedChessWhite.append("n " + n + "\n");
        }
        if (P > 0) {
            capturedChessBlack.append("P " + P + "\n");
        }
        if (p > 0) {
            capturedChessWhite.append("p " + p + "\n");
        }

        if (player == ChessColor.WHITE){
            return capturedChessWhite.toString();
        }
        return capturedChessBlack.toString();
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess = getChess(source.getX(),source.getY());
        chess.canMoveTo().sort(Comparator.comparingInt(ChessboardPoint::getY));
        chess.canMoveTo().sort(Comparator.comparingInt(ChessboardPoint::getX));
        return chess.canMoveTo();
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        List<ChessboardPoint> canMovePoint =  getChess(sourceX,sourceY).canMoveTo();
        boolean flag = false;
        for (int i = 0; i < canMovePoint.size(); i++) {
            if (canMovePoint.get(i).getX() == targetX && canMovePoint.get(i).getY() == targetY){
               flag = true;
            }
        }
        if (getChess(sourceX,sourceY).getChessColor() == currentPlayer){
            ChessboardPoint source = new ChessboardPoint(sourceX,sourceY);
            if (flag){
                getChess(sourceX,sourceY).getSource().setX(targetX);
                getChess(sourceX,sourceY).getSource().setY(targetY);
                chessComponents[targetX][targetY] = getChess(sourceX, sourceY);
                chessComponents[sourceX][sourceY] = new EmptySlotComponent(sourceX, sourceY, '_');
                if (currentPlayer == ChessColor.WHITE){
                    currentPlayer = ChessColor.BLACK;
                }else {
                    currentPlayer = ChessColor.WHITE;
                }
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }

}

