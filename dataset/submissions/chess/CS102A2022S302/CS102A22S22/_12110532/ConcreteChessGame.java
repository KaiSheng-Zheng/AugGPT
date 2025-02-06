import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.List;

public class ConcreteChessGame implements ChessGame {

    // A 2-dimension array to store all the chess components
// should be initialized in your construct method.
// i.e. = new ChessComponent[8][8]
    private ChessComponent[][] chessComponents;
    // What's the current player's color, black or white?
// should be initialized in your construct method.
// by default, set the color to white.
    private ChessColor currentPlayer;
    public int cR, cN, cB, cQ, cK, cP, cr, cn, cb, cq, ck, cp;

    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                switch (chessboard.get(i).charAt(j)) {
                    case 'R':
                        ChessboardPoint zuobiaoR = new ChessboardPoint(i, j);
                        chessComponents[i][j] = new RookChessComponent(zuobiaoR, ChessColor.BLACK, 'R');
                        cR++;
                        break;
                    case 'N':
                        ChessboardPoint zuobiaoN = new ChessboardPoint(i, j);
                        chessComponents[i][j] = new KnightChessComponent(zuobiaoN, ChessColor.BLACK, 'N');
                        cN++;
                        break;
                    case 'B':
                        ChessboardPoint zuobiaoB = new ChessboardPoint(i, j);
                        chessComponents[i][j] = new BishopChessComponent(zuobiaoB, ChessColor.BLACK, 'B');
                        cB++;
                        break;
                    case 'Q':
                        ChessboardPoint zuobiaoQ = new ChessboardPoint(i, j);
                        chessComponents[i][j] = new QueenChessComponent(zuobiaoQ, ChessColor.BLACK, 'Q');
                        cQ++;
                        break;
                    case 'K':
                        ChessboardPoint zuobiaoK = new ChessboardPoint(i, j);
                        chessComponents[i][j] = new KingChessComponent(zuobiaoK, ChessColor.BLACK, 'K');
                        cK++;
                        break;
                    case 'P':
                        ChessboardPoint zuobiaoP = new ChessboardPoint(i, j);
                        chessComponents[i][j] = new PawnChessComponent(zuobiaoP, ChessColor.BLACK, 'P');
                        cP++;
                        break;
                    case 'r':
                        ChessboardPoint zuobiaor = new ChessboardPoint(i, j);
                        chessComponents[i][j] = new RookChessComponent(zuobiaor, ChessColor.WHITE, 'r');
                        cr++;
                        break;
                    case 'n':
                        ChessboardPoint zuobiaon = new ChessboardPoint(i, j);
                        chessComponents[i][j] = new KnightChessComponent(zuobiaon, ChessColor.WHITE, 'n');
                        cn++;
                        break;
                    case 'b':
                        ChessboardPoint zuobiaob = new ChessboardPoint(i, j);
                        chessComponents[i][j] = new BishopChessComponent(zuobiaob, ChessColor.WHITE, 'b');
                        cb++;
                        break;
                    case 'q':
                        ChessboardPoint zuobiaoq = new ChessboardPoint(i, j);
                        chessComponents[i][j] = new QueenChessComponent(zuobiaoq, ChessColor.WHITE, 'q');
                        cq++;
                        break;
                    case 'k':
                        ChessboardPoint zuobiaok = new ChessboardPoint(i, j);
                        chessComponents[i][j] = new KingChessComponent(zuobiaok, ChessColor.WHITE, 'k');
                        ck++;
                        break;
                    case 'p':
                        ChessboardPoint zuobiaop = new ChessboardPoint(i, j);
                        chessComponents[i][j] = new PawnChessComponent(zuobiaop, ChessColor.WHITE, 'p');
                        cp++;
                        break;
                    case '_':
                        ChessboardPoint zuobiao_ = new ChessboardPoint(i, j);
                        chessComponents[i][j] = new EmptySlotComponent(zuobiao_, ChessColor.NONE, '_');
                        break;
                }
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessComponents[i][j].setChessboard(chessComponents);
            }
        }
        if (chessboard.get(8).equals("w")) {
            this.currentPlayer = ChessColor.WHITE;
        }
        if (chessboard.get(8).equals("b")) {
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
        StringBuilder graph = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                graph.append(chessComponents[i][j].toString());
                if (j == 7) {
                    graph.append("\n");
                }
            }
        }

        return graph.toString();
    }

//    @Override
//    public String getCapturedChess(ChessColor player) {
//        StringBuilder captured = new StringBuilder();
//        if (player.equals(ChessColor.BLACK)) {
//            if (cK == 1) {
//
//            }
//            if (cK != 1) {
//                captured.append("K 1\n");
//            }
//            if (cQ == 1) {
//
//            }
//            if (cQ != 1) {
//                captured.append("Q 1\n");
//            }
//            if (cR == 2) {
//
//            }
//            if (cR != 2) {
//                int x = 2 - cR;
//                captured.append("R " + x + "\n");
//            }
//            if (cB == 2) {
//
//            }
//            if (cB != 2) {
//                int x = 2 - cB;
//                captured.append("B " + x + "\n");
//            }
//            if (cN == 2) {
//
//            }
//            if (cN != 2) {
//                int x = 2 - cN;
//                captured.append("N " + x + "\n");
//            }
//            if (cP == 8) {
//
//            }
//            if (cP != 8) {
//                int x = 8 - cP;
//                captured.append("P " + x);
//            }
//            return captured.toString();
//        }
//        if (player.equals(ChessColor.WHITE)) {
//            if (ck == 1) {
//
//            }
//            if (ck != 1) {
//                captured.append("k 1\n");
//            }
//            if (cq == 1) {
//
//            }
//            if (cq != 1) {
//                captured.append("q 1\n");
//            }
//            if (cr == 2) {
//
//            }
//            if (cr != 2) {
//                int x = 2 - cr;
//                captured.append("r " + x + "\n");
//            }
//            if (cb == 2) {
//
//            }
//            if (cb != 2) {
//                int x = 2 - cb;
//                captured.append("b " + x + "\n");
//            }
//            if (cn == 2) {
//
//            }
//            if (cn != 2) {
//                int x = 2 - cn;
//                captured.append("n " + x + "\n");
//            }
//            if (cp == 8) {
//
//            }
//            if (cp != 8) {
//                int x = 8 - cp;
//                captured.append("p " + x);
//            }
//            return captured.toString();
//        }
//        return null;
//    }

    @Override
    public String getCapturedChess(ChessColor player) {
        StringBuilder captured = new StringBuilder();
        int cR = 2;
        int cB = 2;
        int cK = 1;
        int cQ = 1;
        int cP = 8;
        int cN = 2;
        int cr = 2;
        int cb = 2;
        int ck = 1;
        int cq = 1;
        int cp = 8;
        int cn = 2;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                String s = chessComponents[i][j].toString();
                if (s.equals("R")) {
                    cR--;
                } else if (s.equals("N")) {
                    cN--;
                } else if (s.equals("B")) {
                    cB--;
                } else if (s.equals("Q")) {
                    cQ--;
                } else if (s.equals("K")) {
                    cK--;
                } else if (s.equals("P")) {
                    cP--;
                } else if (s.equals("r")) {
                    cr--;
                } else if (s.equals("n")) {
                    cn--;
                } else if (s.equals("b")) {
                    cb--;
                } else if (s.equals("q")) {
                    cq--;
                } else if (s.equals("k")) {
                    ck--;
                } else if (s.equals("p")) {
                    cp--;
                }
            }

        }
        if (player.equals(ChessColor.BLACK)) {
            if (cK != 0) {
                captured.append("K ").append(String.valueOf(cK)).append("\n");
            }
            if (cQ != 0) {
                captured.append("Q ").append(String.valueOf(cQ)).append("\n");
            }
            if (cR != 0) {
                captured.append("R ").append(String.valueOf(cR)).append("\n");
            }
            if (cB != 0) {
                captured.append("B ").append(String.valueOf(cB)).append("\n");
            }
            if (cN != 0) {
                captured.append("N ").append(String.valueOf(cN)).append("\n");
            }
            if (cP != 0) {
                captured.append("P ").append(String.valueOf(cP));
            }
            return captured.toString();
        }
        if (player.equals(ChessColor.WHITE)) {
            if (ck != 0) {
                captured.append("k ").append(String.valueOf(ck)).append("\n");
            }
            if (cq != 0) {
                captured.append("q ").append(String.valueOf(cq)).append("\n");
            }
            if (cr != 0) {
                captured.append("r ").append(String.valueOf(cr)).append("\n");
            }
            if (cb != 0) {
                captured.append("b ").append(String.valueOf(cb)).append("\n");
            }
            if (cn != 0) {
                captured.append("n ").append(String.valueOf(cn)).append("\n");
            }
            if (cp != 0) {
                captured.append("p ").append(String.valueOf(cp));
            }
            return captured.toString();
        }
        return null;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        int x = source.getX();
        int y = source.getY();
        ChessComponent chess = this.chessComponents[source.getX()][source.getY()];
        List<ChessboardPoint> get = chess.canMoveTo();
        get.sort(new Comparator<ChessboardPoint>() {
            @Override
            public int compare(ChessboardPoint C1, ChessboardPoint C2) {
                int n1 = C1.getX() - C2.getX();
                int n2 = n1 == 0 ? C1.getY() - C2.getY() : n1;
                return n2;
            }
        });

        return get;
    }


    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        boolean n = true;
        ChessboardPoint s = new ChessboardPoint(sourceX, sourceY);
        ChessboardPoint t = new ChessboardPoint(targetX, targetY);
        ChessComponent sour = chessComponents[sourceX][sourceY];
        List<ChessboardPoint> tar = sour.canMoveTo();


        if (!currentPlayer.equals(sour.getChessColor())) {
            n = false;
        } else {
            if (tar.contains(t)) {
                sour.setSource(t);
                chessComponents[sourceX][sourceY] = new EmptySlotComponent(s, ChessColor.NONE, '_');
                chessComponents[targetX][targetY] = sour;
                chessComponents[sourceX][sourceY].setChessboard(chessComponents);
                chessComponents[targetX][targetY].setChessboard(chessComponents);
                if (this.currentPlayer.equals(ChessColor.BLACK)) {
                    this.currentPlayer = ChessColor.WHITE;
                } else {
                    this.currentPlayer = ChessColor.BLACK;
                }
                n = true;
            } else {
                n = false;
            }
        }
        return n;
    }
}
