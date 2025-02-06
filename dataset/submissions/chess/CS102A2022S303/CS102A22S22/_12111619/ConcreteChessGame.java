import java.util.*;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }

    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                switch (chessboard.get(i).charAt(j)) {
                    case 'k':
                        this.chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(0, 0), ChessColor.WHITE, 'k');
                        break;
                    case 'q':
                        this.chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(0, 0), ChessColor.WHITE, 'q');
                        break;
                    case 'r':
                        this.chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(0, 0), ChessColor.WHITE, 'r');
                        break;
                    case 'b':
                        this.chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(0, 0), ChessColor.WHITE, 'b');
                        break;
                    case 'n':
                        this.chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(0, 0), ChessColor.WHITE, 'n');
                        break;
                    case 'p':
                        this.chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(0, 0), ChessColor.WHITE, 'p');
                        break;
                    case 'K':
                        this.chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(0, 0), ChessColor.BLACK, 'K');
                        break;
                    case 'Q':
                        this.chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(0, 0), ChessColor.BLACK, 'Q');
                        break;
                    case 'R':
                        this.chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(0, 0), ChessColor.BLACK, 'R');
                        break;
                    case 'B':
                        this.chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(0, 0), ChessColor.BLACK, 'B');
                        break;
                    case 'N':
                        this.chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(0, 0), ChessColor.BLACK, 'N');
                        break;
                    case 'P':
                        this.chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(0, 0), ChessColor.BLACK, 'P');
                        break;
                    case '_':
                        this.chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(0, 0), ChessColor.NONE, '_');
                        break;
                }
                this.chessComponents[i][j].setSource(new ChessboardPoint(i, j));
            }
        }
        if (chessboard.get(8).charAt(0) == 'w') {
            this.currentPlayer = ChessColor.WHITE;
        } else {
            this.currentPlayer = ChessColor.BLACK;
        }
    }

    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public String getChessboardGraph() {
        StringBuilder chessboardGraph = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessboardGraph.append(chessComponents[i][j]);
            }
            if (i < 7) {
                chessboardGraph.append("\n");
            }
        }
        return chessboardGraph.toString();
    }

    public String getCapturedChess(ChessColor player) {
        Map<Character, Integer> capturedChessSearch = new LinkedHashMap<>();
        StringBuilder returnString = new StringBuilder();
        if (player == ChessColor.WHITE) {
            capturedChessSearch.put('k', 1);
            capturedChessSearch.put('q', 1);
            capturedChessSearch.put('r', 2);
            capturedChessSearch.put('b', 2);
            capturedChessSearch.put('n', 2);
            capturedChessSearch.put('p', 8);
        }
        if (player == ChessColor.BLACK) {
            capturedChessSearch.put('K', 1);
            capturedChessSearch.put('Q', 1);
            capturedChessSearch.put('R', 2);
            capturedChessSearch.put('B', 2);
            capturedChessSearch.put('N', 2);
            capturedChessSearch.put('P', 8);
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (capturedChessSearch.containsKey(this.chessComponents[i][j].name)) {
                    capturedChessSearch.replace(this.chessComponents[i][j].name, capturedChessSearch.get(this.chessComponents[i][j].name) - 1);
                }
            }
        }
        for (Map.Entry<Character, Integer> p : capturedChessSearch.entrySet()) {
            if (p.getValue() == 0) {
                continue;
            }
            returnString.append(p.getKey());
            returnString.append(" ");
            returnString.append(p.getValue());
            returnString.append("\n");
        }
        return returnString.toString();
    }

    public ChessComponent getChess(int x, int y) {
        return this.chessComponents[x][y];
    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        chessComponents[source.getX()][source.getY()].passChessboard(this.chessComponents);
        ChessComponent movingChess = chessComponents[source.getX()][source.getY()];
        List<ChessboardPoint> returnValue = movingChess.canMoveTo();
        Collections.sort(returnValue, new SortByAxis());
        return returnValue;
    }

    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        chessComponents[sourceX][sourceY].passChessboard(chessComponents);
        ChessComponent testingChess = chessComponents[sourceX][sourceY];
        if (testingChess.getChessColor() != currentPlayer) {
            return false;
        }
        List<ChessboardPoint> testingChessPosition = testingChess.canMoveTo();
        for (ChessboardPoint P : testingChessPosition) {
            if (P.getX() == targetX && P.getY() == targetY) {
                chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX, targetY));
                chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX, sourceY), ChessColor.NONE, '_');
                if (this.currentPlayer == ChessColor.WHITE) {
                    this.currentPlayer = ChessColor.BLACK;
                } else {
                    this.currentPlayer = ChessColor.WHITE;
                }
                return true;
            }
        }
        return false;
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    private class SortByAxis implements Comparator<ChessboardPoint> {
        @Override
        public int compare(ChessboardPoint p1, ChessboardPoint p2) {
            if (p1.getX() > p2.getX()) {
                return 1;
            } else if (p1.getX() == p2.getX()) {
                return Integer.compare(p1.getY(), p2.getY());
            } else {
                return -1;
            }
        }
    }
}