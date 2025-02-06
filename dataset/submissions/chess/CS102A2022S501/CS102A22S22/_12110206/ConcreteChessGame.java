

import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame(ChessColor currentPlayer) {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = currentPlayer;
    }

    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessComponent temp = null;
                if ((chessboard.get(i).charAt(j) == 'r') || (chessboard.get(i).charAt(j) == 'R')) {
                    temp = new RookChessComponent(i, j, chessboard.get(i).charAt(j));
                }
                if ((chessboard.get(i).charAt(j) == 'k') || (chessboard.get(i).charAt(j) == 'K')) {
                    temp = new KingChessComponent(i, j, chessboard.get(i).charAt(j));
                }
                if ((chessboard.get(i).charAt(j) == 'b') || (chessboard.get(i).charAt(j) == 'B')) {
                    temp = new BishopChessComponent(i, j, chessboard.get(i).charAt(j));
                }
                if ((chessboard.get(i).charAt(j) == 'Q') || (chessboard.get(i).charAt(j) == 'q')) {
                    temp = new QueenChessComponent(i, j, chessboard.get(i).charAt(j));
                }
                if ((chessboard.get(i).charAt(j) == 'n') || (chessboard.get(i).charAt(j) == 'N')) {
                    temp = new KnightChessComponent(i, j, chessboard.get(i).charAt(j));
                }
                if ((chessboard.get(i).charAt(j) == 'p') || (chessboard.get(i).charAt(j) == 'P')) {
                    temp = new PawnChessComponent(i, j, chessboard.get(i).charAt(j));
                }
                if ((chessboard.get(i).charAt(j) == '_')) {
                    temp = new EmptySlotComponent(i, j, chessboard.get(i).charAt(j));
                }
                temp.setChessboard(chessComponents);
                chessComponents[i][j] = temp;
            }
        }
        if (chessboard.get(8).equals("w")) {
            currentPlayer = ChessColor.WHITE;
        } else {
            currentPlayer = ChessColor.BLACK;
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
        StringBuilder getChessboardGraph = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                getChessboardGraph.append((chessComponents[i][j].name));
            }
            getChessboardGraph.append("\n");
        }
        return getChessboardGraph.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        StringBuilder getCapturedChess = new StringBuilder();
        int[] counter = new int[6];
        int[] original = {1, 1, 2, 2, 2, 8};
        char[] white = {'k', 'q', 'r', 'b', 'n', 'p'};
        char[] black = {'K', 'Q', 'R', 'B', 'N', 'P'};
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessComponents[i][j].chessColor() == player && chessComponents[i][j] instanceof KingChessComponent) {
                    counter[0]++;
                }
                if (chessComponents[i][j].chessColor() == player && chessComponents[i][j] instanceof QueenChessComponent) {
                    counter[1]++;
                }
                if (chessComponents[i][j].chessColor() == player && chessComponents[i][j] instanceof RookChessComponent) {
                    counter[2]++;
                }
                if (chessComponents[i][j].chessColor() == player && chessComponents[i][j] instanceof BishopChessComponent) {
                    counter[3]++;
                }
                if (chessComponents[i][j].chessColor() == player && chessComponents[i][j] instanceof KnightChessComponent) {
                    counter[4]++;
                }
                if (chessComponents[i][j].chessColor() == player && chessComponents[i][j] instanceof PawnChessComponent) {
                    counter[5]++;
                }
            }
        }
        if (player == ChessColor.WHITE) {
            for (int i = 0; i < 6; i++) {
                if (original[i] - counter[i] != 0) {
                    getCapturedChess.append(String.format("%s %d\n", white[i], original[i] - counter[i]));
                }
            }
        }
        if (player == ChessColor.BLACK) {
            for (int i = 0; i < 6; i++) {
                if (original[i] - counter[i] != 0) {
                    getCapturedChess.append(String.format("%s %d\n", black[i], original[i] - counter[i]));
                }
            }
        }
        return getCapturedChess.toString();
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess = getChess(source.getX(), source.getY());
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        for (int j = 0; j < canMovePoints.size(); j++) {
            for (int i = 0; i < canMovePoints.size() - 1; i++) {
                if (canMovePoints.get(i).getY() > canMovePoints.get(i + 1).getY()) {
                    ChessboardPoint temp = canMovePoints.get(i);
                    canMovePoints.remove(canMovePoints.get(i));
                    canMovePoints.add(i + 1, temp);
                }
            }
        }
        for (int j = 0; j < canMovePoints.size(); j++) {
            for (int i = 0; i < canMovePoints.size() - 1; i++) {
                if (canMovePoints.get(i).getX() > canMovePoints.get(i + 1).getX()) {
                    ChessboardPoint temp = canMovePoints.get(i);
                    canMovePoints.remove(canMovePoints.get(i));
                    canMovePoints.add(i + 1, temp);
                }
            }
        }
        return canMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (getChess(sourceX, sourceY).chessColor() == currentPlayer) {
            for (int i = 0; i < getChess(sourceX, sourceY).canMoveTo().size(); i++) {
                if (getChess(sourceX, sourceY).canMoveTo().get(i).getX() == targetX && getChess(sourceX, sourceY).canMoveTo().get(i).getY() == targetY) {
                    getChess(sourceX, sourceY).getSource().setX(targetX);
                    getChess(sourceX, sourceY).getSource().setY(targetY);
                    currentPlayer = currentPlayer == ChessColor.WHITE ? ChessColor.BLACK : ChessColor.WHITE;
                    chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                    chessComponents[sourceX][sourceY] = new EmptySlotComponent(sourceX, sourceY, '_');
                    return true;
                }
            }
            return false;
        } else {
            return false;
        }
    }


}


