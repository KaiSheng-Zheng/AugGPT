import java.util.Comparator;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;
    private List<String> chessboard;

    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
    }

    public void loadChessGame(List<String> chessboard) {
        this.chessboard = chessboard;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                String chess = String.valueOf(chessboard.get(i).charAt(j));
                if (chess.equals("P")) {
                    ChessboardPoint chessboardPoint = new ChessboardPoint(i, j);
                    PawnChessComponent P = new PawnChessComponent(chessboardPoint, ChessColor.BLACK, 'P', this.chessComponents);
                    chessComponents[i][j] = P;
                }
                if (chess.equals("p")) {
                    ChessboardPoint chessboardPoint = new ChessboardPoint(i, j);
                    PawnChessComponent p = new PawnChessComponent(chessboardPoint, ChessColor.WHITE, 'p', this.chessComponents);
                    chessComponents[i][j] = p;
                }
                if (chess.equals("b")) {
                    ChessboardPoint chessboardPoint = new ChessboardPoint(i, j);
                    BishopChessComponent b = new BishopChessComponent(chessboardPoint, ChessColor.WHITE, 'b', this.chessComponents);
                    chessComponents[i][j] = b;
                }
                if (chess.equals("B")) {
                    ChessboardPoint chessboardPoint = new ChessboardPoint(i, j);
                    BishopChessComponent B = new BishopChessComponent(chessboardPoint, ChessColor.BLACK, 'B', this.chessComponents);
                    chessComponents[i][j] = B;
                }
                if (chess.equals("k")) {
                    ChessboardPoint chessboardPoint = new ChessboardPoint(i, j);
                    KingChessComponent k = new KingChessComponent(chessboardPoint, ChessColor.WHITE, 'k', this.chessComponents);
                    chessComponents[i][j] = k;
                }
                if (chess.equals("K")) {
                    ChessboardPoint chessboardPoint = new ChessboardPoint(i, j);
                    KingChessComponent K = new KingChessComponent(chessboardPoint, ChessColor.BLACK, 'K', this.chessComponents);
                    chessComponents[i][j] = K;
                }
                if (chess.equals("q")) {
                    ChessboardPoint chessboardPoint = new ChessboardPoint(i, j);
                    QueenChessComponent q = new QueenChessComponent(chessboardPoint, ChessColor.WHITE, 'q', this.chessComponents);
                    chessComponents[i][j] = q;
                }
                if (chess.equals("Q")) {
                    ChessboardPoint chessboardPoint = new ChessboardPoint(i, j);
                    QueenChessComponent Q = new QueenChessComponent(chessboardPoint, ChessColor.BLACK, 'Q', this.chessComponents);
                    chessComponents[i][j] = Q;
                }
                if (chess.equals("n")) {
                    ChessboardPoint chessboardPoint = new ChessboardPoint(i, j);
                    KnightChessComponent n = new KnightChessComponent(chessboardPoint, ChessColor.WHITE, 'n', this.chessComponents);
                    chessComponents[i][j] = n;
                }
                if (chess.equals("N")) {
                    ChessboardPoint chessboardPoint = new ChessboardPoint(i, j);
                    KnightChessComponent N = new KnightChessComponent(chessboardPoint, ChessColor.BLACK, 'N', this.chessComponents);
                    chessComponents[i][j] = N;
                }
                if (chess.equals("r")) {
                    ChessboardPoint chessboardPoint = new ChessboardPoint(i, j);
                    RookChessComponent r = new RookChessComponent(chessboardPoint, ChessColor.WHITE, 'r', this.chessComponents);
                    chessComponents[i][j] = r;
                }
                if (chess.equals("R")) {
                    ChessboardPoint chessboardPoint = new ChessboardPoint(i, j);
                    RookChessComponent R = new RookChessComponent(chessboardPoint, ChessColor.BLACK, 'R', this.chessComponents);
                    chessComponents[i][j] = R;
                }
                if (chess.equals("_")) {
                    ChessboardPoint chessboardPoint = new ChessboardPoint(i, j);
                    EmptySlotComponent em = new EmptySlotComponent(chessboardPoint, ChessColor.NONE, '_', this.chessComponents);
                    chessComponents[i][j] = em;
                }
            }
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessComponents[i][j].setChessboard(chessComponents);
            }
        }

        if (chessboard.get(8).charAt(0) == 'w') {
            this.currentPlayer = ChessColor.WHITE;
        } else if (chessboard.get(8).charAt(0) == 'b') {
            this.currentPlayer = ChessColor.BLACK;
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
        return String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s", this.chessboard.get(0), this.chessboard.get(1), this.chessboard.get(2), this.chessboard.get(3), this.chessboard.get(4), this.chessboard.get(5), this.chessboard.get(6), this.chessboard.get(7));

    }

    @Override
    public String getCapturedChess(ChessColor player) {
        StringBuilder remain = new StringBuilder();
        int[] countChess = new int[6];
        countChess[0] = 1;
        countChess[1] = 1;
        countChess[2] = 2;
        countChess[3] = 2;
        countChess[4] = 2;
        countChess[5] = 8;
        if (player == ChessColor.BLACK) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].name == 'K') {
                        countChess[0]--;
                    }
                    if (chessComponents[i][j].name == 'Q') {
                        countChess[1]--;
                    }
                    if (chessComponents[i][j].name == 'R') {
                        countChess[2]--;
                    }
                    if (chessComponents[i][j].name == 'B') {
                        countChess[3]--;
                    }
                    if (chessComponents[i][j].name == 'N') {
                        countChess[4]--;
                    }
                    if (chessComponents[i][j].name == 'P') {
                        countChess[5]--;
                    }
                }
            }
            if (countChess[0] != 0) {
                remain.append("K");
                remain.append(" ");
                remain.append(countChess[0]);
                remain.append("\n");
            }
            if (countChess[1] != 0) {
                remain.append("Q");
                remain.append(" ");
                remain.append(countChess[1]);
                remain.append("\n");
            }
            if (countChess[2] != 0) {
                remain.append("R");
                remain.append(" ");
                remain.append(countChess[2]);
                remain.append("\n");
            }
            if (countChess[3] != 0) {
                remain.append("B");
                remain.append(" ");
                remain.append(countChess[3]);
                remain.append("\n");
            }
            if (countChess[4] != 0) {
                remain.append("N");
                remain.append(" ");
                remain.append(countChess[4]);
                remain.append("\n");
            }
            if (countChess[5] != 0) {
                remain.append("P");
                remain.append(" ");
                remain.append(countChess[5]);
                remain.append("\n");
            }
        } else if (player == ChessColor.WHITE) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].name == 'k') {
                        countChess[0]--;
                    }
                    if (chessComponents[i][j].name == 'q') {
                        countChess[1]--;
                    }
                    if (chessComponents[i][j].name == 'r') {
                        countChess[2]--;
                    }
                    if (chessComponents[i][j].name == 'b') {
                        countChess[3]--;
                    }
                    if (chessComponents[i][j].name == 'n') {
                        countChess[4]--;
                    }
                    if (chessComponents[i][j].name == 'p') {
                        countChess[5]--;
                    }
                }
            }
            if (countChess[0] != 0) {
                remain.append("k");
                remain.append(" ");
                remain.append(countChess[0]);
                remain.append("\n");
            }
            if (countChess[1] != 0) {
                remain.append("q");
                remain.append(" ");
                remain.append(countChess[1]);
                remain.append("\n");
            }
            if (countChess[2] != 0) {
                remain.append("r");
                remain.append(" ");
                remain.append(countChess[2]);
                remain.append("\n");
            }
            if (countChess[3] != 0) {
                remain.append("b");
                remain.append(" ");
                remain.append(countChess[3]);
                remain.append("\n");
            }
            if (countChess[4] != 0) {
                remain.append("n");
                remain.append(" ");
                remain.append(countChess[4]);
                remain.append("\n");
            }
            if (countChess[5] != 0) {
                remain.append("p");
                remain.append(" ");
                remain.append(countChess[5]);
                remain.append("\n");
            }
        }
        return remain.toString();
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> paixu = chessComponents[source.getX()][source.getY()].canMoveTo();
        paixu.sort(new Comparator<ChessboardPoint>() {
            @Override
            public int compare(ChessboardPoint o1, ChessboardPoint o2) {
                int num = o1.getX() - o2.getX();
                int num2 = num == 0 ? o1.getY() - o2.getY() : num;
                return num2;
            }
        });

        return paixu;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessboardPoint chushi = new ChessboardPoint(sourceX, sourceY);
        ChessboardPoint mo = new ChessboardPoint(targetX, targetY);
        if (!chessComponents[sourceX][sourceY].getChessColor().equals(currentPlayer)) {
            return false;
        }
        if (chessComponents[sourceX][sourceY].canMoveTo().contains(mo)) {
            chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
            chessComponents[targetX][targetY].setSource(mo);
            chessComponents[sourceX][sourceY] = new EmptySlotComponent(chushi, ChessColor.NONE, '_');

            if (currentPlayer.equals(ChessColor.WHITE)) {
                currentPlayer = ChessColor.BLACK;
            } else {
                currentPlayer = ChessColor.WHITE;
            }
            return true;
        }
        return false;

    }


}
