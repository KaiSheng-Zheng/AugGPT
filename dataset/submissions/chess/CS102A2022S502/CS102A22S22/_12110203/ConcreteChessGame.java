import java.util.Comparator;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
        this.currentPlayer = ChessColor.WHITE;
        this.chessComponents = new ChessComponent[8][8];
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessboardPoint point = new ChessboardPoint(i, j);
                char c = chessboard.get(i).charAt(j);
                if (c == 'R') {
                    chessComponents[i][j] = new RookChessComponent(point, ChessColor.BLACK, 'R');
                }
                if (c == 'N') {
                    chessComponents[i][j] = new KnightChessComponent(point, ChessColor.BLACK, 'N');
                }
                if (c == 'B') {
                    chessComponents[i][j] = new BishopChessComponent(point, ChessColor.BLACK, 'B');
                }
                if (c == 'Q') {
                    chessComponents[i][j] = new QueenChessComponent(point, ChessColor.BLACK, 'Q');
                }
                if (c == 'K') {
                    chessComponents[i][j] = new KingChessComponent(point, ChessColor.BLACK, 'K');
                }
                if (c == 'P') {
                    chessComponents[i][j] = new PawnChessComponent(point, ChessColor.BLACK, 'P');
                }
                if (c == 'r') {
                    chessComponents[i][j] = new RookChessComponent(point, ChessColor.WHITE, 'r');
                }
                if (c == 'n') {
                    chessComponents[i][j] = new KnightChessComponent(point, ChessColor.WHITE, 'n');
                }
                if (c == 'b') {
                    chessComponents[i][j] = new BishopChessComponent(point, ChessColor.WHITE, 'b');
                }
                if (c == 'q') {
                    chessComponents[i][j] = new QueenChessComponent(point, ChessColor.WHITE, 'q');
                }
                if (c == 'k') {
                    chessComponents[i][j] = new KingChessComponent(point, ChessColor.WHITE, 'k');
                }
                if (c == 'p') {
                    chessComponents[i][j] = new PawnChessComponent(point, ChessColor.WHITE, 'p');
                }
                if (c == '_') {
                    chessComponents[i][j] = new EmptySlotComponent(point, ChessColor.NONE, '_');
                }
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessComponents[i][j].setChessboard(chessComponents);
            }
        }
        String which = chessboard.get(8);
        if (which.equals("w")) {
            this.currentPlayer = ChessColor.WHITE;
        }
        if (which.equals("b")) {
            this.currentPlayer = ChessColor.BLACK;
        }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public String getChessboardGraph() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                str.append(chessComponents[i][j].toString());
                if (j == 7) {
                    str.append("\n");
                }
            }
        }
        return str.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int noR = 2, noN = 2, noB = 2, noQ = 1, noK = 1, noP = 8, nor = 2, non = 2, nob = 2, noq = 1, nok = 1, nop = 8;
        StringBuilder shit = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessComponents[i][j].toString().equals("R")) {
                    noR--;
                }
                if (chessComponents[i][j].toString().equals("N")) {
                    noN--;
                }
                if (chessComponents[i][j].toString().equals("B")) {
                    noB--;
                }
                if (chessComponents[i][j].toString().equals("Q")) {
                    noQ--;
                }
                if (chessComponents[i][j].toString().equals("K")) {
                    noK--;
                }
                if (chessComponents[i][j].toString().equals("P")) {
                    noP--;
                }
                if (chessComponents[i][j].toString().equals("r")) {
                    nor--;
                }
                if (chessComponents[i][j].toString().equals("n")) {
                    non--;
                }
                if (chessComponents[i][j].toString().equals("b")) {
                    nob--;
                }
                if (chessComponents[i][j].toString().equals("q")) {
                    noq--;
                }
                if (chessComponents[i][j].toString().equals("k")) {
                    nok--;
                }
                if (chessComponents[i][j].toString().equals("p")) {
                    nop--;
                }
            }
        }
        if (player.equals(ChessColor.BLACK)) {
            if (noK != 0) {
                shit.append("K " + noK + "\n");
            }
            if (noQ != 0) {
                shit.append("Q " + noQ + "\n");
            }
            if (noR != 0) {
                shit.append("R " + noR + "\n");
            }
            if (noB != 0) {
                shit.append("B " + noB + "\n");
            }
            if (noN != 0) {
                shit.append("N " + noN + "\n");
            }
            if (noP != 0) {
                shit.append("P " + noP);
            }
            return shit.toString();
        }
        if (player.equals(ChessColor.WHITE)) {
            if (nok != 0) {
                shit.append("k " + nok + "\n");
            }
            if (noq != 0) {
                shit.append("q " + noq + "\n");
            }
            if (nor != 0) {
                shit.append("r " + nor + "\n");
            }
            if (nob != 0) {
                shit.append("b " + nob + "\n");
            }
            if (non != 0) {
                shit.append("n " + non + "\n");
            }
            if (nop != 0) {
                shit.append("p " + nop);
            }
            return shit.toString();
        }
        return null;
    }


    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess = this.chessComponents[source.getX()][source.getY()];
        List<ChessboardPoint> where = chess.canMoveTo();

        return where;
    }


    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        return true;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return this.chessComponents[x][y];
    }
}
