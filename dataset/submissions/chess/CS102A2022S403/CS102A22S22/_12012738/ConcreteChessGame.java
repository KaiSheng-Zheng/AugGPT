import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer = ChessColor.WHITE;

    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessboard.get(i).charAt(j) == 'R') {
                    chessComponents[i][j] = new RookChessComponent(i, j, ChessColor.BLACK, 'R');
                }
                if (chessboard.get(i).charAt(j) == 'r') {
                    chessComponents[i][j] = new RookChessComponent(i, j, ChessColor.WHITE, 'r');
                }
                if (chessboard.get(i).charAt(j) == 'Q') {
                    chessComponents[i][j] = new QueenChessComponent(i, j, ChessColor.BLACK, 'Q');
                }
                if (chessboard.get(i).charAt(j) == 'q') {
                    chessComponents[i][j] = new QueenChessComponent(i, j, ChessColor.WHITE, 'q');
                }
                if (chessboard.get(i).charAt(j) == 'P') {
                    chessComponents[i][j] = new PawnChessComponent(i, j, ChessColor.BLACK, 'P');
                }
                if (chessboard.get(i).charAt(j) == 'p') {
                    chessComponents[i][j] = new PawnChessComponent(i, j, ChessColor.WHITE, 'p');
                }
                if (chessboard.get(i).charAt(j) == 'N') {
                    chessComponents[i][j] = new KnightChessComponent(i, j, ChessColor.BLACK, 'N');
                }
                if (chessboard.get(i).charAt(j) == 'n') {
                    chessComponents[i][j] = new KnightChessComponent(i, j, ChessColor.WHITE, 'n');
                }
                if (chessboard.get(i).charAt(j) == 'K') {
                    chessComponents[i][j] = new KingChessComponent(i, j, ChessColor.BLACK, 'K');
                }
                if (chessboard.get(i).charAt(j) == 'k') {
                    chessComponents[i][j] = new KingChessComponent(i, j, ChessColor.WHITE, 'k');
                }
                if (chessboard.get(i).charAt(j) == 'B') {
                    chessComponents[i][j] = new BishopChessComponent(i, j, ChessColor.BLACK, 'B');
                }
                if (chessboard.get(i).charAt(j) == 'b') {
                    chessComponents[i][j] = new BishopChessComponent(i, j, ChessColor.WHITE, 'b');
                }
                if (chessboard.get(i).charAt(j) == '_') {
                    chessComponents[i][j] = new EmptySlotComponent(i, j, ChessColor.NONE, '_');
                }
                this.chessComponents[i][j].setChessboard(this.chessComponents);
            }
        }
        if (chessboard.get(8).equals("w")) {
            this.currentPlayer = ChessColor.WHITE;
        }
        if (chessboard.get(8).equals("b")) {
            this.currentPlayer = ChessColor.BLACK;
        }
    }

    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public String getChessboardGraph() {
        StringBuilder ChessboardGraph = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessboardGraph.append(chessComponents[i][j].getName());
            }
            ChessboardGraph.append("\n");
        }
        return ChessboardGraph.toString();
    }

    public String getCapturedChess(ChessColor player) {
        StringBuilder CapturedChess = new StringBuilder();
        int k = 1, q = 1, r = 2, b = 2, n = 2, p = 8;
        if (player == ChessColor.BLACK) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].getName() == 'K') {
                        k -= 1;
                    }
                    if (chessComponents[i][j].getName() == 'Q') {
                        q -= 1;
                    }
                    if (chessComponents[i][j].getName() == 'R') {
                        r -= 1;
                    }
                    if (chessComponents[i][j].getName() == 'B') {
                        b -= 1;
                    }
                    if (chessComponents[i][j].getName() == 'N') {
                        n -= 1;
                    }
                    if (chessComponents[i][j].getName() == 'P') {
                        p -= 1;
                    }
                }
            }
            if (k != 0) {
                CapturedChess.append("K ").append(k).append("\n");
            }
            if (q != 0) {
                CapturedChess.append("Q ").append(q).append("\n");
            }
            if (r != 0) {
                CapturedChess.append("R ").append(r).append("\n");
            }
            if (b != 0) {
                CapturedChess.append("B ").append(b).append("\n");
            }
            if (n != 0) {
                CapturedChess.append("N ").append(n).append("\n");
            }
            if (p != 0) {
                CapturedChess.append("P ").append(p).append("\n");
            }
        }
        if (player == ChessColor.WHITE) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].getName() == 'k') {
                        k -= 1;
                    }
                    if (chessComponents[i][j].getName() == 'q') {
                        q -= 1;
                    }
                    if (chessComponents[i][j].getName() == 'r') {
                        r -= 1;
                    }
                    if (chessComponents[i][j].getName() == 'b') {
                        b -= 1;
                    }
                    if (chessComponents[i][j].getName() == 'n') {
                        n -= 1;
                    }
                    if (chessComponents[i][j].getName() == 'p') {
                        p -= 1;
                    }
                }
            }
            if (k != 0) {
                CapturedChess.append("k ").append(k).append("\n");
            }
            if (q != 0) {
                CapturedChess.append("q ").append(q).append("\n");
            }
            if (r != 0) {
                CapturedChess.append("r ").append(r).append("\n");
            }
            if (b != 0) {
                CapturedChess.append("b ").append(b).append("\n");
            }
            if (n != 0) {
                CapturedChess.append("n ").append(n).append("\n");
            }
            if (p != 0) {
                CapturedChess.append("p ").append(p).append("\n");
            }
        }
        return CapturedChess.toString();
    }

    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        // 1. find chess according to source
        ChessComponent chess = getChess(source.getX(), source.getY());
        // 2. as below statement:
        // 3.sort canMovePoints by x - y ascending order
        return chess.canMoveTo();
    }

    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessboardPoint target = new ChessboardPoint(targetX, targetY);
        boolean contains = false;
        if (chessComponents[sourceX][sourceY].getChessColor() == this.currentPlayer) {
            if (chessComponents[sourceX][sourceY].getName() != '_') {
                for (ChessboardPoint A : getCanMovePoints(new ChessboardPoint(sourceX, sourceY))) {
                    if (A.equals(target)) {
                        contains = true;
                        break;
                    }
                }
                if (contains) {
                    if (chessComponents[sourceX][sourceY].getName() == 'R') {
                        chessComponents[sourceX][sourceY] = new EmptySlotComponent(sourceX, sourceY, currentPlayer, '_');
                        chessComponents[targetX][targetY] = new RookChessComponent(targetX, targetY, currentPlayer, 'R');
                    }
                    if (chessComponents[sourceX][sourceY].getName() == 'r') {
                        chessComponents[sourceX][sourceY] = new EmptySlotComponent(sourceX, sourceY, currentPlayer, '_');
                        chessComponents[targetX][targetY] = new RookChessComponent(targetX, targetY, currentPlayer, 'r');
                    }
                    if (chessComponents[sourceX][sourceY].getName() == 'Q') {
                        chessComponents[sourceX][sourceY] = new EmptySlotComponent(sourceX, sourceY, currentPlayer, '_');
                        chessComponents[targetX][targetY] = new QueenChessComponent(targetX, targetY, currentPlayer, 'Q');
                    }
                    if (chessComponents[sourceX][sourceY].getName() == 'q') {
                        chessComponents[sourceX][sourceY] = new EmptySlotComponent(sourceX, sourceY, currentPlayer, '_');
                        chessComponents[targetX][targetY] = new QueenChessComponent(targetX, targetY, currentPlayer, 'q');
                    }
                    if (chessComponents[sourceX][sourceY].getName() == 'P') {
                        chessComponents[sourceX][sourceY] = new EmptySlotComponent(sourceX, sourceY, currentPlayer, '_');
                        chessComponents[targetX][targetY] = new PawnChessComponent(targetX, targetY, currentPlayer, 'P');
                    }
                    if (chessComponents[sourceX][sourceY].getName() == 'p') {
                        chessComponents[sourceX][sourceY] = new EmptySlotComponent(sourceX, sourceY, currentPlayer, '_');
                        chessComponents[targetX][targetY] = new PawnChessComponent(targetX, targetY, currentPlayer, 'p');
                    }
                    if (chessComponents[sourceX][sourceY].getName() == 'N') {
                        chessComponents[sourceX][sourceY] = new EmptySlotComponent(sourceX, sourceY, currentPlayer, '_');
                        chessComponents[targetX][targetY] = new KnightChessComponent(targetX, targetY, currentPlayer, 'N');
                    }
                    if (chessComponents[sourceX][sourceY].getName() == 'n') {
                        chessComponents[sourceX][sourceY] = new EmptySlotComponent(sourceX, sourceY, currentPlayer, '_');
                        chessComponents[targetX][targetY] = new KnightChessComponent(targetX, targetY, currentPlayer, 'n');
                    }
                    if (chessComponents[sourceX][sourceY].getName() == 'K') {
                        chessComponents[sourceX][sourceY] = new EmptySlotComponent(sourceX, sourceY, currentPlayer, '_');
                        chessComponents[targetX][targetY] = new KingChessComponent(targetX, targetY, currentPlayer, 'K');
                    }
                    if (chessComponents[sourceX][sourceY].getName() == 'k') {
                        chessComponents[sourceX][sourceY] = new EmptySlotComponent(sourceX, sourceY, currentPlayer, '_');
                        chessComponents[targetX][targetY] = new KingChessComponent(targetX, targetY, currentPlayer, 'k');
                    }
                    if (chessComponents[sourceX][sourceY].getName() == 'B') {
                        chessComponents[sourceX][sourceY] = new EmptySlotComponent(sourceX, sourceY, currentPlayer, '_');
                        chessComponents[targetX][targetY] = new BishopChessComponent(targetX, targetY, currentPlayer, 'B');
                    }
                    if (chessComponents[sourceX][sourceY].getName() == 'b') {
                        chessComponents[sourceX][sourceY] = new EmptySlotComponent(sourceX, sourceY, currentPlayer, '_');
                        chessComponents[targetX][targetY] = new BishopChessComponent(targetX, targetY, currentPlayer, 'b');
                    }
                    this.chessComponents[sourceX][sourceY].setChessboard(this.chessComponents);
                    this.chessComponents[targetX][targetY].setChessboard(this.chessComponents);
                    if (currentPlayer == ChessColor.WHITE) {
                        this.currentPlayer = ChessColor.BLACK;
                    } else {
                        this.currentPlayer = ChessColor.WHITE;
                    }
                    return true;
                }
            }
        }
        return false;
    }
}