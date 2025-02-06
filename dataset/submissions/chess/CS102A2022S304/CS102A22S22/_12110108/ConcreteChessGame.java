import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private HashMap<Integer, Integer> leavedChessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame(ChessComponent[][] chessComponents) {
        this.chessComponents = new ChessComponent[8][8];
        this.chessComponents = chessComponents;
        this.currentPlayer = ChessColor.WHITE;
        leavedChessComponents = new HashMap<>();

    }

    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
        leavedChessComponents = new HashMap<>();

    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                switch (chessboard.get(i).charAt(j)) {
                    case 'K':
                        chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'K', 1);
                        break;
                    case 'Q':
                        chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'Q', 2);
                        break;
                    case 'R':
                        chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'R', 3);
                        break;
                    case 'B':
                        chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'B', 4);
                        break;
                    case 'N':
                        chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'N', 5);
                        break;
                    case 'P':
                        chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'P', 6);
                        break;
                    case 'k':
                        chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'k', 7);
                        break;
                    case 'q':
                        chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'q', 8);
                        break;
                    case 'r':
                        chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'r', 9);
                        break;
                    case 'b':
                        chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'b', 10);
                        break;
                    case 'n':
                        chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'n', 11);
                        break;
                    case 'p':
                        chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'p', 12);
                        break;
                    case '_':
                        chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i, j), ChessColor.NONE, '_', 0);
                        break;

                }
            }
        }
        chessComponents[0][0].setChessboard(chessComponents);
        if (chessboard.get(8).charAt(0) == 'w') {
            currentPlayer = ChessColor.WHITE;
        } else
            currentPlayer = ChessColor.BLACK;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                result.append(chessComponents[i][j].getName());
                if (j == 7)
                    result.append("\n");
            }
        }
        return result.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        StringBuilder result = new StringBuilder();
        leavedChessComponents.put(0, 0);
        leavedChessComponents.put(1, 0);
        leavedChessComponents.put(2, 0);
        leavedChessComponents.put(3, 0);
        leavedChessComponents.put(4, 0);
        leavedChessComponents.put(5, 0);
        leavedChessComponents.put(6, 0);
        leavedChessComponents.put(7, 0);
        leavedChessComponents.put(8, 0);
        leavedChessComponents.put(9, 0);
        leavedChessComponents.put(10, 0);
        leavedChessComponents.put(11, 0);
        leavedChessComponents.put(12, 0);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                int id = chessComponents[i][j].getId();
                if (id != 0) {
                    int a = Integer.parseInt(String.valueOf(leavedChessComponents.get(id)));
                    if (chessComponents[i][j].getChessColor() == player) {
                        ++a;
                        leavedChessComponents.put(id, a);
                    }
                }
            }
        }
        for (int i = 1; i < 13; i++) {
            int a = leavedChessComponents.get(i);
            if (player == ChessColor.BLACK) {
                switch (i) {
                    case 1:
                        if (a != 1) {
                            int b = 1 - a;
                            result.append("K " + b + "\n");
                            break;
                        }
                        break;
                    case 2:
                        if (a != 1) {
                            int b = 1 - a;
                            result.append("Q " + b + "\n");
                            break;
                        }
                        break;
                    case 3:
                        if (a != 2) {
                            int b = 2 - a;
                            result.append("R " + b + "\n");
                            break;
                        }
                        break;
                    case 4:
                        if (a != 2) {
                            int b = 2 - a;
                            result.append("B " + b + "\n");
                            break;
                        }
                        break;
                    case 5:
                        if (a != 2) {
                            int b = 2 - a;
                            result.append("N " + b + "\n");
                            break;
                        }
                        break;
                    case 6:
                        if (a != 8) {
                            int b = 8 - a;
                            result.append("P " + b + "\n");
                            break;
                        }
                        break;
                }
            } else
                switch (i) {
                    case 7:
                        if (a != 1) {
                            int b = 1 - a;
                            result.append("k " + b + "\n");
                            break;
                        }
                        break;
                    case 8:
                        if (a != 1) {
                            int b = 1 - a;
                            result.append("q " + b + "\n");
                            break;
                        }
                        break;
                    case 9:
                        if (a != 2) {
                            int b = 2 - a;
                            result.append("r " + b + "\n");
                            break;
                        }
                        break;
                    case 10:
                        if (a != 2) {
                            int b = 2 - a;
                            result.append("b " + b + "\n");
                            break;
                        }
                        break;
                    case 11:
                        if (a != 2) {
                            int b = 2 - a;
                            result.append("n " + b + "\n");
                            break;
                        }
                        break;
                    case 12:
                        if (a != 8) {
                            int b = 8 - a;
                            result.append("p " + b + "\n");
                            break;
                        }
                        break;
                }
        }
        return result.toString();
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessColor chessColor = this.chessComponents[sourceX][sourceY].getChessColor();
        boolean flag = false;
        if (chessColor == currentPlayer) {
            List<ChessboardPoint> result = this.chessComponents[sourceX][sourceY].canMoveTo();
            for (int i = 0; i < result.size(); i++) {
                if (result.get(i).getX() == targetX && result.get(i).getY() == targetY) {
                    ChessComponent chessComponent = this.chessComponents[sourceX][sourceY];
                    this.chessComponents[targetX][targetY] = chessComponent;
                    chessComponent.setSource(new ChessboardPoint(targetX,targetY));
                    this.chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX, sourceY), ChessColor.NONE, '_', 0);
                    currentPlayer = currentPlayer == ChessColor.WHITE ? ChessColor.BLACK : ChessColor.WHITE;
                    this.chessComponents[sourceX][sourceY].setChessboard(chessComponents);
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> result = chessComponents[source.getX()][source.getY()].canMoveTo();
        Collections.sort(result);
        return result;
    }

    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }


    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }
}