import java.util.Comparator;
import java.util.List;

public class ConcreteChessGame implements ChessGame {

    private ChessComponent[][] chessComponents;

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    private ChessColor currentPlayer;

    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }

    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < chessboard.size() - 1; i++) {
            for (int j = 0; j < 8; j++) {
                ChessboardPoint s = new ChessboardPoint(i, j);
                switch (chessboard.get(i).charAt(j)) {
                    case 'R':
                        RookChessComponent R = new RookChessComponent(s, ChessColor.BLACK, 'R');
                        chessComponents[i][j] = R;
                        break;
                    case 'N':
                        KnightChessComponent N = new KnightChessComponent(s, ChessColor.BLACK, 'N');
                        chessComponents[i][j] = N;
                        break;
                    case 'B':
                        BishopChessComponent B = new BishopChessComponent(s, ChessColor.BLACK, 'B');
                        chessComponents[i][j] = B;
                        break;
                    case 'Q':
                        QueenChessComponent Q = new QueenChessComponent(s, ChessColor.BLACK, 'Q');
                        chessComponents[i][j] = Q;
                        break;
                    case 'K':
                        KingChessComponent K = new KingChessComponent(s, ChessColor.BLACK, 'K');
                        chessComponents[i][j] = K;
                        break;
                    case 'P':
                        PawnChessComponent P = new PawnChessComponent(s, ChessColor.BLACK, 'P');
                        chessComponents[i][j] = P;
                        break;
                    case '_':
                        EmptySlotComponent E = new EmptySlotComponent(s, ChessColor.NONE, '_');
                        chessComponents[i][j] = E;
                        break;
                    case 'r':
                        RookChessComponent r = new RookChessComponent(s, ChessColor.WHITE, 'r');
                        chessComponents[i][j] = r;
                        break;
                    case 'n':
                        KnightChessComponent n = new KnightChessComponent(s, ChessColor.WHITE, 'n');
                        chessComponents[i][j] = n;
                        break;
                    case 'b':
                        BishopChessComponent b = new BishopChessComponent(s, ChessColor.WHITE, 'b');
                        chessComponents[i][j] = b;
                        break;
                    case 'q':
                        QueenChessComponent q = new QueenChessComponent(s, ChessColor.WHITE, 'q');
                        chessComponents[i][j] = q;
                        break;
                    case 'k':
                        KingChessComponent k = new KingChessComponent(s, ChessColor.WHITE, 'k');
                        chessComponents[i][j] = k;
                        break;
                    case 'p':
                        PawnChessComponent p = new PawnChessComponent(s, ChessColor.WHITE, 'p');
                        chessComponents[i][j] = p;
                        break;
                }

            }
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessComponents[i][j].setChessboard(chessComponents);
            }
        }
        switch (chessboard.get(8)) {
            case "w" -> currentPlayer = ChessColor.WHITE;
            case "b" -> currentPlayer = ChessColor.BLACK;
        }
        for (String s : chessboard) {
            System.out.println(s);
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
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                sb.append(chessComponents[i][j].toString());
                if (j == 7 && i != 7) {
                    sb.append("\n");
                }
            }
        }

        return sb.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        StringBuilder sb = new StringBuilder();
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
                switch (chessComponents[i][j].toString()) {
                    case "R":
                        cR--;
                        break;
                    case "N":
                        cN--;
                        break;
                    case "B":
                        cB--;
                        break;
                    case "Q":
                        cQ--;
                        break;
                    case "K":
                        cK--;
                        break;
                    case "P":
                        cP--;
                        break;
                    case "_":
                        break;
                    case "r":
                        cr--;
                        break;
                    case "n":
                        cn--;
                        break;
                    case "b":
                        cb--;
                        break;
                    case "q":
                        cq--;
                        break;
                    case "k":
                        ck--;
                        break;
                    case "p":
                        cp--;
                        break;
                }
            }

        }
        if (player.equals(ChessColor.BLACK)) {
            if (cK != 0) {
                sb.append("K ").append(String.valueOf(cK)).append("\n");
            }
            if (cQ != 0) {
                sb.append("Q ").append(String.valueOf(cQ)).append("\n");
            }
            if (cR != 0) {
                sb.append("R ").append(String.valueOf(cR)).append("\n");
            }
            if (cB != 0) {
                sb.append("B ").append(String.valueOf(cB)).append("\n");
            }
            if (cN != 0) {
                sb.append("N ").append(String.valueOf(cN)).append("\n");
            }
            if (cP != 0) {
                sb.append("P ").append(String.valueOf(cP)).append("\n");
            }
            if (!sb.isEmpty()) {
                int r = sb.length() - 1;
                sb.deleteCharAt(r);
            }
            return sb.toString();
        }
        if (player.equals(ChessColor.WHITE)) {
            if (ck != 0) {
                sb.append("k ").append(String.valueOf(ck)).append("\n");
            }
            if (cq != 0) {
                sb.append("q ").append(String.valueOf(cq)).append("\n");
            }
            if (cr != 0) {
                sb.append("r ").append(String.valueOf(cr)).append("\n");
            }
            if (cb != 0) {
                sb.append("b ").append(String.valueOf(cb)).append("\n");
            }
            if (cn != 0) {
                sb.append("n ").append(String.valueOf(cn)).append("\n");
            }
            if (cp != 0) {
                sb.append("p ").append(String.valueOf(cp)).append("\n");
            }
            if (!sb.isEmpty()) {
                int r = sb.length() - 1;
                sb.deleteCharAt(r);
            }
            return sb.toString();
        }
        return null;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess = this.chessComponents[source.getX()][source.getY()];
        List<ChessboardPoint> weiyi = chess.canMoveTo();
        weiyi.sort(new Comparator<ChessboardPoint>() {
            @Override
            public int compare(ChessboardPoint o1, ChessboardPoint o2) {
                int num = o1.getX() - o2.getX();
                int num2 = num == 0 ? o1.getY() - o2.getY() : num;
                return num2;
            }
        });
        return weiyi;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessboardPoint chu = new ChessboardPoint(sourceX, sourceY);
        ChessboardPoint mo = new ChessboardPoint(targetX, targetY);
        ChessComponent a = chessComponents[sourceX][sourceY];
        List<ChessboardPoint> weiyi = a.canMoveTo();
        if (currentPlayer.equals(a.getChessColor())) {
            if (weiyi.contains(mo)) {
                a.setSource(mo);
                chessComponents[targetX][targetY] = a;
                chessComponents[sourceX][sourceY] = new EmptySlotComponent(chu, ChessColor.NONE, '_');
                chessComponents[targetX][targetY].setChessboard(chessComponents);
                chessComponents[sourceX][sourceY].setChessboard(chessComponents);
                if (currentPlayer.equals(ChessColor.WHITE)) {
                    currentPlayer = ChessColor.BLACK;
                } else {
                    currentPlayer = ChessColor.WHITE;
                }

                return true;
            }

        }
        return false;
    }
}
