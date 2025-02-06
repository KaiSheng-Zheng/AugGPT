import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer;

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                if (chessboard.get(i).charAt(j) == '_')
                    chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i, j), ChessColor.NONE, chessComponents);
                if (chessboard.get(i).charAt(j) == 'K')
                    chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, chessComponents);
                if (chessboard.get(i).charAt(j) == 'k')
                    chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, chessComponents);
                if (chessboard.get(i).charAt(j) == 'R')
                    chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, chessComponents);
                if (chessboard.get(i).charAt(j) == 'r')
                    chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, chessComponents);
                if (chessboard.get(i).charAt(j) == 'B')
                    chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, chessComponents);
                if (chessboard.get(i).charAt(j) == 'b')
                    chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, chessComponents);
                if (chessboard.get(i).charAt(j) == 'Q')
                    chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, chessComponents);
                if (chessboard.get(i).charAt(j) == 'q')
                    chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, chessComponents);
                if (chessboard.get(i).charAt(j) == 'N')
                    chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, chessComponents);
                if (chessboard.get(i).charAt(j) == 'n')
                    chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, chessComponents);
                if (chessboard.get(i).charAt(j) == 'P')
                    chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, chessComponents);
                if (chessboard.get(i).charAt(j) == 'p')
                    chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, chessComponents);
            }
        }
        if (chessboard.get(8).charAt(0) == 'w') currentPlayer = ChessColor.WHITE;
        if (chessboard.get(8).charAt(0) == 'b') currentPlayer = ChessColor.BLACK;
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public String getChessboardGraph() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                sb.append(chessComponents[i][j].name);
            }
            if (i < 7) sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        String board = getChessboardGraph();
        int k = 1;
        int q = 1;
        int r = 2;
        int b = 2;
        int n = 2;
        int p = 8;
        StringBuilder sb = new StringBuilder();
        if (player == ChessColor.WHITE) {
            for (int i = 0; i < board.length(); i++) {
                if (board.charAt(i) == 'k') k--;
                if (board.charAt(i) == 'q') q--;
                if (board.charAt(i) == 'r') r--;
                if (board.charAt(i) == 'b') b--;
                if (board.charAt(i) == 'n') n--;
                if (board.charAt(i) == 'p') p--;
            }
            if (k > 0) sb.append(String.format("k %d\n", k));
            if (q > 0) sb.append(String.format("q %d\n", q));
            if (r > 0) sb.append(String.format("r %d\n", r));
            if (b > 0) sb.append(String.format("b %d\n", b));
            if (n > 0) sb.append(String.format("n %d\n", n));
            if (p > 0) sb.append(String.format("p %d\n", p));
        } else {
            for (int i = 0; i < board.length(); i++) {
                if (board.charAt(i) == 'K') k--;
                if (board.charAt(i) == 'Q') q--;
                if (board.charAt(i) == 'R') r--;
                if (board.charAt(i) == 'B') b--;
                if (board.charAt(i) == 'N') n--;
                if (board.charAt(i) == 'P') p--;
            }
            if (k > 0) sb.append(String.format("K %d\n", k));
            if (q > 0) sb.append(String.format("Q %d\n", q));
            if (r > 0) sb.append(String.format("R %d\n", r));
            if (b > 0) sb.append(String.format("B %d\n", b));
            if (n > 0) sb.append(String.format("N %d\n", n));
            if (p > 0) sb.append(String.format("P %d\n", p));
        }
        return sb.toString();
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> ori = chessComponents[source.getX()][source.getY()].canMoveTo();
        List<ChessboardPoint> move = new ArrayList<>();
        if (ori.size() == 0) return move;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                for (int k = 0; k < ori.size(); k++) {
                    if (ori.get(k).getX() == i && ori.get(k).getY() == j) move.add(new ChessboardPoint(i, j));
                }
            }
        }
        return move;
    }

    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (getChess(sourceX, sourceY).canMoveTo().size() == 0||chessComponents[sourceX][sourceY].getChessColor()!=currentPlayer) return false;
        for (int i = 0; i < getChess(sourceX, sourceY).canMoveTo().size(); i++) {
            if (getChess(sourceX, sourceY).canMoveTo().get(i).getX() == targetX && getChess(sourceX, sourceY).canMoveTo().get(i).getY() == targetY) {
                chessComponents[sourceX][sourceY].setSource(new ChessboardPoint(targetX, targetY));
                chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                chessComponents[sourceX][sourceY] = new EmptySlotComponent(getChess(sourceX, sourceY).getSource(), ChessColor.NONE, chessComponents);
                if (currentPlayer==ChessColor.WHITE) currentPlayer=ChessColor.BLACK;
                else currentPlayer=ChessColor.WHITE;
                return true;
            }
        }
        return false;
    }
}
