import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

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
                if (chessboard.get(i).charAt(j) == '_') {
                    chessComponents[i][j] = new EmptySlotComponent();
                    chessComponents[i][j].setChessColor(ChessColor.NONE);
                } else if (chessboard.get(i).charAt(j) == 'K' || chessboard.get(i).charAt(j) == 'k') {
                    chessComponents[i][j] = new KingChessComponent();
                } else if (chessboard.get(i).charAt(j) == 'Q' || chessboard.get(i).charAt(j) == 'q') {
                    chessComponents[i][j] = new QueenChessComponent();
                } else if (chessboard.get(i).charAt(j) == 'R' || chessboard.get(i).charAt(j) == 'r') {
                    chessComponents[i][j] = new RookChessComponent();
                } else if (chessboard.get(i).charAt(j) == 'B' || chessboard.get(i).charAt(j) == 'b') {
                    chessComponents[i][j] = new BishopChessComponent();
                } else if (chessboard.get(i).charAt(j) == 'N' || chessboard.get(i).charAt(j) == 'n') {
                    chessComponents[i][j] = new KnightChessComponent();
                } else if (chessboard.get(i).charAt(j) == 'P' || chessboard.get(i).charAt(j) == 'p') {
                    chessComponents[i][j] = new PawnChessComponent();
                }
                chessComponents[i][j].setName(chessboard.get(i).charAt(j));
                if ('a' < chessComponents[i][j].name && chessComponents[i][j].name < 'z') {
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                }
                if ('A' < chessComponents[i][j].name && chessComponents[i][j].name < 'Z') {
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                }
                chessComponents[i][j].setSource(i, j);
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
        StringBuilder chessboard = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessboard.append(chessComponents[i][j].name);
                if (j == 7) {
                    chessboard.append('\n');
                }
            }
        }
        return chessboard.toString();
    }

    public String getCapturedChess(ChessColor player) {
        HashMap<Character, Integer> capturedChess = new HashMap<>();
        HashMap<Integer, Character> capturedChess1 = new HashMap<>();
        int[] capturedChessNumber = new int[]{1, 1, 2, 2, 2, 8};
        if (player.equals(ChessColor.WHITE)) {
            capturedChess.put('k', 0);
            capturedChess.put('q', 1);
            capturedChess.put('r', 2);
            capturedChess.put('b', 3);
            capturedChess.put('n', 4);
            capturedChess.put('p', 5);
            capturedChess1.put(0, 'k');
            capturedChess1.put(1, 'q');
            capturedChess1.put(2, 'r');
            capturedChess1.put(3, 'b');
            capturedChess1.put(4, 'n');
            capturedChess1.put(5, 'p');
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if ('a' < chessComponents[i][j].name && chessComponents[i][j].name < 'z') {
                        capturedChessNumber[capturedChess.get(chessComponents[i][j].name)]--;
                    }
                }
            }
        } else {
            capturedChess.put('K', 0);
            capturedChess.put('Q', 1);
            capturedChess.put('R', 2);
            capturedChess.put('B', 3);
            capturedChess.put('N', 4);
            capturedChess.put('P', 5);
            capturedChess1.put(0, 'K');
            capturedChess1.put(1, 'Q');
            capturedChess1.put(2, 'R');
            capturedChess1.put(3, 'B');
            capturedChess1.put(4, 'N');
            capturedChess1.put(5, 'P');
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if ('A' < chessComponents[i][j].name && chessComponents[i][j].name < 'Z') {
                        capturedChessNumber[(int) capturedChess.get(chessComponents[i][j].name)]--;
                    }
                }
            }
        }
        StringBuilder getCapturedChess = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            if (capturedChessNumber[i] != 0) {
                getCapturedChess.append(capturedChess1.get(i).toString()).append(" ").append(capturedChessNumber[i]);
                if (i != 5) {
                    getCapturedChess.append('\n');
                }
            }
        }
        return getCapturedChess.toString();
    }

    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        chessComponents[source.getX()][source.getY()].setChessComponents(chessComponents);
        return sortBy((ArrayList<ChessboardPoint>) chessComponents[source.getX()][source.getY()].canMoveTo());
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        chessComponents[sourceX][sourceY].setChessComponents(chessComponents);
        if (currentPlayer != chessComponents[sourceX][sourceY].chessColor) {
            return false;
        }
        if (chessComponents[sourceX][sourceY].canMoveTo().contains(new ChessboardPoint(targetX, targetY))) {
            chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
            chessComponents[targetX][targetY].setSource(targetX, targetY);

            chessComponents[sourceX][sourceY] = new EmptySlotComponent();
            chessComponents[sourceX][sourceY].setSource(sourceX, sourceY);
            chessComponents[sourceX][sourceY].setChessColor(ChessColor.NONE);
            chessComponents[sourceX][sourceY].setName('_');

            if (currentPlayer.equals(ChessColor.WHITE)) {
                currentPlayer = ChessColor.BLACK;
            } else {
                currentPlayer = ChessColor.WHITE;
            }
            return true;
        } else {
            return false;
        }
    }

    public List<ChessboardPoint> sortBy(ArrayList<ChessboardPoint> canMoveTo) {
        canMoveTo.sort(new Sort());
        return canMoveTo;
    }

    public static class Sort implements Comparator<ChessboardPoint> {
        @Override
        public int compare(ChessboardPoint point1, ChessboardPoint point2) {
            if (point1.getX() == point2.getX()) {
                if (point1.getY() > point2.getY()) {
                    return 1;
                }
                if (point1.getY() < point2.getY()) {
                    return -1;
                }
                return 0;
            } else {
                if (point1.getX() > point2.getX()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        }
    }
}
