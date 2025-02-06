import java.util.List;
import java.util.Objects;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer;

    public ConcreteChessGame(ChessComponent[][] chessComponents, ChessColor currentPlayer) {
        this.chessComponents = chessComponents;
        this.currentPlayer = currentPlayer;

    }

    public ConcreteChessGame() {
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        String[] strings = new String[8];
        for (int i = 0; i < 8; i++) {
            strings[i] = chessboard.get(i);
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                KingChessComponent kb = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'K');
                QueenChessComponent qb = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'Q');
                RookChessComponent rb = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'R');
                BishopChessComponent bb = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'B');
                KnightChessComponent nb = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'N');
                PawnChessComponent pb = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'P');
                KingChessComponent kw = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'k');
                QueenChessComponent qw = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'q');
                RookChessComponent rw = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'r');
                BishopChessComponent bw = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'b');
                KnightChessComponent nw = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'n');
                PawnChessComponent pw = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'p');
                EmptySlotComponent en = new EmptySlotComponent(new ChessboardPoint(i, j), ChessColor.NONE, '_');
                switch (strings[i].charAt(j)) {
                    case 'K':
                        chessComponents[i][j] = kb;
                        break;
                    case 'k':
                        chessComponents[i][j] = kw;
                        break;
                    case 'Q':
                        chessComponents[i][j] = qb;
                        break;
                    case 'q':
                        chessComponents[i][j] = qw;
                        break;
                    case 'N':
                        chessComponents[i][j] = nb;
                        break;
                    case 'n':
                        chessComponents[i][j] = nw;
                        break;
                    case 'B':
                        chessComponents[i][j] = bb;
                        break;
                    case 'b':
                        chessComponents[i][j] = bw;
                        break;
                    case 'R':
                        chessComponents[i][j] = rb;
                        break;
                    case 'r':
                        chessComponents[i][j] = rw;
                        break;
                    case 'P':
                        chessComponents[i][j] = pb;
                        break;
                    case 'p':
                        chessComponents[i][j] = pw;
                        break;
                    case '_':
                        chessComponents[i][j] = en;
                        break;
                }
            }
        }

        if (chessboard.get(8) == "b") {
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
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                s.append(chessComponents[i][j].name);
            }
            s.append("\n");
        }
        return s.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        String s = "";
        if (player == ChessColor.BLACK) {
            int countK = 1;
            int countQ = 1;
            int countR = 2;
            int countB = 2;
            int countN = 2;
            int countP = 8;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].name == 'K') {
                        countK--;
                    }
                    if (chessComponents[i][j].name == 'Q') {
                        countQ--;
                    }
                    if (chessComponents[i][j].name == 'R') {
                        countR--;
                    }
                    if (chessComponents[i][j].name == 'B') {
                        countB--;
                    }
                    if (chessComponents[i][j].name == 'N') {
                        countN--;
                    }
                    if (chessComponents[i][j].name == 'P') {
                        countP--;
                    }
                }
            }
            if (countK != 0) {
                s += String.format("K %d\n", countK);
            }
            if (countQ != 0) {
                s += String.format("Q %d\n", countQ);
            }
            if (countR != 0) {
                s += String.format("R %d\n", countR);
            }
            if (countB != 0) {
                s += String.format("B %d\n", countB);
            }
            if (countN != 0) {
                s += String.format("N %d\n", countN);
            }
            if (countP != 0) {
                s += String.format("P %d\n", countP);
            }
        }
        if (player == ChessColor.WHITE) {
            int countK = 1;
            int countQ = 1;
            int countR = 2;
            int countB = 2;
            int countN = 2;
            int countP = 8;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].name == 'k') {
                        countK--;
                    }
                    if (chessComponents[i][j].name == 'q') {
                        countQ--;
                    }
                    if (chessComponents[i][j].name == 'r') {
                        countR--;
                    }
                    if (chessComponents[i][j].name == 'b') {
                        countB--;
                    }
                    if (chessComponents[i][j].name == 'n') {
                        countN--;
                    }
                    if (chessComponents[i][j].name == 'p') {
                        countP--;
                    }
                }
            }
            if (countK != 0) {
                s += String.format("k %d\n", countK);
            }
            if (countQ != 0) {
                s += String.format("q %d\n", countQ);
            }
            if (countR != 0) {
                s += String.format("r %d\n", countR);
            }
            if (countB != 0) {
                s += String.format("b %d\n", countQ);
            }
            if (countN != 0) {
                s += String.format("n %d\n", countN);
            }
            if (countP != 0) {
                s += String.format("p %d\n", countP);
            }
        }
        return s;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        chessComponents[source.getX()][source.getY()].setChessC(chessComponents);
        return chessComponents[source.getX()][source.getY()].canMoveTo();
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        chessComponents[sourceX][sourceY].setChessC(chessComponents);
        List<ChessboardPoint> chessboardPoints = getCanMovePoints(new ChessboardPoint(sourceX, sourceY));
        ChessboardPoint targetSource = new ChessboardPoint(targetX, targetY);
        for (int i = 0; i < chessboardPoints.size(); i++) {
            if (chessboardPoints.get(i).equals(targetSource)) {
                if (currentPlayer == ChessColor.BLACK) {
                    currentPlayer = ChessColor.WHITE;
                } else {
                    currentPlayer = ChessColor.BLACK;
                }
                chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX, sourceY), ChessColor.NONE, '_');
                chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX, targetY));
                return true;
            }
        }
        return false;
    }
}
