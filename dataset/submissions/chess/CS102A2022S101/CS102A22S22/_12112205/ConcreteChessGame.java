import java.util.HashMap;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
        chessComponents = new ChessComponent[8][8];
        currentPlayer = ChessColor.WHITE;
    }

    public void loadChessGame(List<String> chessboard) {
        // chessComponents = new ChessComponent[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                switch ((int) chessboard.get(i).charAt(j)) {
                    case 'R':
                        chessComponents[i][j] = new RookChessComponent(chessComponents, ChessColor.BLACK,
                                new ChessboardPoint(i, j));
                        break;
                    case 'N':
                        chessComponents[i][j] = new KnightChessComponent(chessComponents, ChessColor.BLACK,
                                new ChessboardPoint(i, j));
                        break;
                    case 'B':
                        chessComponents[i][j] = new BishopChessComponent(chessComponents, ChessColor.BLACK,
                                new ChessboardPoint(i, j));
                        break;
                    case 'Q':
                        chessComponents[i][j] = new QueenChessComponent(chessComponents, ChessColor.BLACK,
                                new ChessboardPoint(i, j));
                        break;
                    case 'K':
                        chessComponents[i][j] = new KingChessComponent(chessComponents, ChessColor.BLACK,
                                new ChessboardPoint(i, j));
                        break;
                    case 'P':
                        chessComponents[i][j] = new PawnChessComponent(chessComponents, ChessColor.BLACK,
                                new ChessboardPoint(i, j));
                        break;
                    case 'r':
                        chessComponents[i][j] = new RookChessComponent(chessComponents, ChessColor.WHITE,
                                new ChessboardPoint(i, j));
                        break;
                    case 'n':
                        chessComponents[i][j] = new KnightChessComponent(chessComponents, ChessColor.WHITE,
                                new ChessboardPoint(i, j));
                        break;
                    case 'b':
                        chessComponents[i][j] = new BishopChessComponent(chessComponents, ChessColor.WHITE,
                                new ChessboardPoint(i, j));
                        break;
                    case 'q':
                        chessComponents[i][j] = new QueenChessComponent(chessComponents, ChessColor.WHITE,
                                new ChessboardPoint(i, j));
                        break;
                    case 'k':
                        chessComponents[i][j] = new KingChessComponent(chessComponents, ChessColor.WHITE,
                                new ChessboardPoint(i, j));
                        break;
                    case 'p':
                        chessComponents[i][j] = new PawnChessComponent(chessComponents, ChessColor.WHITE,
                                new ChessboardPoint(i, j));
                        break;
                    default:
                        chessComponents[i][j] = new EmptySlotComponent(chessComponents, ChessColor.NONE,
                                new ChessboardPoint(i, j));
                }
            }
        }
        if (chessboard.get(8).charAt(0) == 'w') {
            currentPlayer = ChessColor.WHITE;
        } else {
            currentPlayer = ChessColor.BLACK;
        }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public String getChessboardGraph() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                sb.append(chessComponents[i][j].toString());
            }
            if (i < 7) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        Integer count;
        hm.put('k', 0);
        hm.put('q', 0);
        hm.put('r', 0);
        hm.put('b', 0);
        hm.put('n', 0);
        hm.put('p', 0);
        hm.put('K', 0);
        hm.put('Q', 0);
        hm.put('R', 0);
        hm.put('B', 0);
        hm.put('N', 0);
        hm.put('P', 0);
        hm.put('_', 0);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                count = hm.get(chessComponents[i][j].toString().charAt(0));
                hm.put(chessComponents[i][j].toString().charAt(0), count + 1);
            }
        }
        StringBuilder sb = new StringBuilder();

        if (player.equals(ChessColor.WHITE)) {
            if (hm.get('k') != 1) {
                sb.append("k " + (1 - hm.get('k')) + "\n");
            }
            if (hm.get('q') != 1) {
                sb.append("q " + (1 - hm.get('q')) + "\n");
            }
            if (hm.get('r') != 2) {
                sb.append("r " + (2 - hm.get('r')) + "\n");
            }
            if (hm.get('b') != 2) {
                sb.append("b " + (2 - hm.get('b')) + "\n");
            }
            if (hm.get('n') != 2) {
                sb.append("n " + (2 - hm.get('n')) + "\n");
            }
            if (hm.get('p') != 8) {
                sb.append("p " + (8 - hm.get('p')) + "\n");
            }
        } else {
            if (hm.get('K') != 1) {
                sb.append("K " + (1 - hm.get('K')) + "\n");
            }
            if (hm.get('Q') != 1) {
                sb.append("Q " + (1 - hm.get('Q')) + "\n");
            }
            if (hm.get('R') != 2) {
                sb.append("R " + (2 - hm.get('R')) + "\n");
            }
            if (hm.get('B') != 2) {
                sb.append("B " + (2 - hm.get('B')) + "\n");
            }
            if (hm.get('N') != 2) {
                sb.append("N " + (2 - hm.get('N')) + "\n");
            }
            if (hm.get('P') != 8) {
                sb.append("P " + (8 - hm.get('P')) + "\n");
            }
        }
        return sb.toString();
    }

    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint point) {
        return chessComponents[point.getX()][point.getY()].canMoveTo();
    }

    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (chessComponents[sourceX][sourceY].getChessColor() != currentPlayer) {
            return false;
        }
        if (getCanMovePoints(new ChessboardPoint(sourceX, sourceY)).size() == 0) {
            return false;
        }
        for (ChessboardPoint point : getCanMovePoints(new ChessboardPoint(sourceX, sourceY))) {
            if (point.getX() == targetX && point.getY() == targetY) {
                if (chessComponents[sourceX][sourceY].name == 'P' || chessComponents[sourceX][sourceY].name == 'p') {
                    chessComponents[sourceX][sourceY].setTwoBlock();
                }
                currentPlayer = currentPlayer == ChessColor.WHITE ? ChessColor.BLACK : ChessColor.WHITE;
                chessComponents[sourceX][sourceY].setChessPoint(
                        chessComponents[sourceX][sourceY].getChessPoint().offset(targetX - sourceX, targetY - sourceY));
                chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                chessComponents[sourceX][sourceY] = new EmptySlotComponent(chessComponents, ChessColor.NONE,
                        new ChessboardPoint(sourceX, sourceY));

                return true;
            }
        }
        return false;
    }
}
