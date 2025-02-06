import java.util.Collections;
import java.util.List;

public class ConcreteChessGame implements ChessGame {

    private ChessComponent[][] chessComponents = new ChessComponent[8][8];

    private ChessColor currentPlayer = ChessColor.WHITE;

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessboard.get(i).charAt(j) == 'R') {
                    chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK);
                } else if (chessboard.get(i).charAt(j) == 'N') {
                    chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK);
                } else if (chessboard.get(i).charAt(j) == 'B') {
                    chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK);
                } else if (chessboard.get(i).charAt(j) == 'Q') {
                    chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK);
                } else if (chessboard.get(i).charAt(j) == 'K') {
                    chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK);
                } else if (chessboard.get(i).charAt(j) == 'P') {
                    chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK);
                } else if (chessboard.get(i).charAt(j) == 'p') {
                    chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE);
                } else if (chessboard.get(i).charAt(j) == 'r') {
                    chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE);
                } else if (chessboard.get(i).charAt(j) == 'n') {
                    chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE);
                } else if (chessboard.get(i).charAt(j) == 'b') {
                    chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE);
                } else if (chessboard.get(i).charAt(j) == 'q') {
                    chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE);
                } else if (chessboard.get(i).charAt(j) == 'k') {
                    chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE);
                } else {
                    chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i, j), ChessColor.NONE);
                }
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessComponents[i][j].setChessComponents(chessComponents);
            }
        }
        if (chessboard.get(8).equals("b")) {
            currentPlayer = ChessColor.BLACK;
        }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return currentPlayer;
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
                if (chessComponents[i][j] instanceof RookChessComponent && chessComponents[i][j].getChessColor() == ChessColor.BLACK) {
                    sb.append('R');
                } else if (chessComponents[i][j] instanceof KnightChessComponent && chessComponents[i][j].getChessColor() == ChessColor.BLACK) {
                    sb.append('N');
                } else if (chessComponents[i][j] instanceof BishopChessComponent && chessComponents[i][j].getChessColor() == ChessColor.BLACK) {
                    sb.append('B');
                } else if (chessComponents[i][j] instanceof QueenChessComponent && chessComponents[i][j].getChessColor() == ChessColor.BLACK) {
                    sb.append('Q');
                } else if (chessComponents[i][j] instanceof KingChessComponent && chessComponents[i][j].getChessColor() == ChessColor.BLACK) {
                    sb.append('K');
                } else if (chessComponents[i][j] instanceof PawnChessComponent && chessComponents[i][j].getChessColor() == ChessColor.BLACK) {
                    sb.append('P');
                } else if (chessComponents[i][j] instanceof PawnChessComponent && chessComponents[i][j].getChessColor() == ChessColor.WHITE) {
                    sb.append('p');
                } else if (chessComponents[i][j] instanceof RookChessComponent && chessComponents[i][j].getChessColor() == ChessColor.WHITE) {
                    sb.append('r');
                } else if (chessComponents[i][j] instanceof KnightChessComponent && chessComponents[i][j].getChessColor() == ChessColor.WHITE) {
                    sb.append('n');
                } else if (chessComponents[i][j] instanceof BishopChessComponent && chessComponents[i][j].getChessColor() == ChessColor.WHITE) {
                    sb.append('b');
                } else if (chessComponents[i][j] instanceof QueenChessComponent && chessComponents[i][j].getChessColor() == ChessColor.WHITE) {
                    sb.append('q');
                } else if (chessComponents[i][j] instanceof KingChessComponent && chessComponents[i][j].getChessColor() == ChessColor.WHITE) {
                    sb.append('k');
                } else {
                    sb.append('_');
                }
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        if (player == ChessColor.BLACK) {
            int num1 = 0;
            int num2 = 0;
            int num3 = 0;
            int num4 = 0;
            int num5 = 0;
            int num6 = 0;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j] instanceof KingChessComponent && chessComponents[i][j].getChessColor() == ChessColor.BLACK) {
                        num1++;
                    } else if (chessComponents[i][j] instanceof QueenChessComponent && chessComponents[i][j].getChessColor() == ChessColor.BLACK) {
                        num2++;
                    } else if (chessComponents[i][j] instanceof RookChessComponent && chessComponents[i][j].getChessColor() == ChessColor.BLACK) {
                        num3++;
                    } else if (chessComponents[i][j] instanceof BishopChessComponent && chessComponents[i][j].getChessColor() == ChessColor.BLACK) {
                        num4++;
                    } else if (chessComponents[i][j] instanceof KnightChessComponent && chessComponents[i][j].getChessColor() == ChessColor.BLACK) {
                        num5++;
                    } else if (chessComponents[i][j] instanceof PawnChessComponent && chessComponents[i][j].getChessColor() == ChessColor.BLACK) {
                        num6++;
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            int capturedNum1 = 1 - num1;
            if (capturedNum1 != 0) {
                sb.append("K");
                sb.append(" ");
                sb.append(capturedNum1);
                sb.append("\n");
            }
            int capturedNum2 = 1 - num2;
            if (capturedNum2 != 0) {
                sb.append("Q");
                sb.append(" ");
                sb.append(capturedNum2);
                sb.append("\n");
            }
            int capturedNum3 = 2 - num3;
            if (capturedNum3 != 0) {
                sb.append("R");
                sb.append(" ");
                sb.append(capturedNum3);
                sb.append("\n");
            }
            int capturedNum4 = 2 - num4;
            if (capturedNum4 != 0) {
                sb.append("B");
                sb.append(" ");
                sb.append(capturedNum4);
                sb.append("\n");
            }
            int capturedNum5 = 2 - num5;
            if (capturedNum5 != 0) {
                sb.append("N");
                sb.append(" ");
                sb.append(capturedNum5);
                sb.append("\n");
            }
            int capturedNum6 = 8 - num6;
            if (capturedNum6 != 0) {
                sb.append("P");
                sb.append(" ");
                sb.append(capturedNum6);
                sb.append("\n");
            }
            return sb.toString();
        } else {
            int num1 = 0;
            int num2 = 0;
            int num3 = 0;
            int num4 = 0;
            int num5 = 0;
            int num6 = 0;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j] instanceof KingChessComponent && chessComponents[i][j].getChessColor() == ChessColor.WHITE) {
                        num1++;
                    } else if (chessComponents[i][j] instanceof QueenChessComponent && chessComponents[i][j].getChessColor() == ChessColor.WHITE) {
                        num2++;
                    } else if (chessComponents[i][j] instanceof RookChessComponent && chessComponents[i][j].getChessColor() == ChessColor.WHITE) {
                        num3++;
                    } else if (chessComponents[i][j] instanceof BishopChessComponent && chessComponents[i][j].getChessColor() == ChessColor.WHITE) {
                        num4++;
                    } else if (chessComponents[i][j] instanceof KnightChessComponent && chessComponents[i][j].getChessColor() == ChessColor.WHITE) {
                        num5++;
                    } else if (chessComponents[i][j] instanceof PawnChessComponent && chessComponents[i][j].getChessColor() == ChessColor.WHITE) {
                        num6++;
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            int capturedNum1 = 1 - num1;
            if (capturedNum1 != 0) {
                sb.append("k");
                sb.append(" ");
                sb.append(capturedNum1);
                sb.append("\n");
            }
            int capturedNum2 = 1 - num2;
            if (capturedNum2 != 0) {
                sb.append("q");
                sb.append(" ");
                sb.append(capturedNum2);
                sb.append("\n");
            }
            int capturedNum3 = 2 - num3;
            if (capturedNum3 != 0) {
                sb.append("r");
                sb.append(" ");
                sb.append(capturedNum3);
                sb.append("\n");
            }
            int capturedNum4 = 2 - num4;
            if (capturedNum4 != 0) {
                sb.append("b");
                sb.append(" ");
                sb.append(capturedNum4);
                sb.append("\n");
            }
            int capturedNum5 = 2 - num5;
            if (capturedNum5 != 0) {
                sb.append("n");
                sb.append(" ");
                sb.append(capturedNum5);
                sb.append("\n");
            }
            int capturedNum6 = 8 - num6;
            if (capturedNum6 != 0) {
                sb.append("p");
                sb.append(" ");
                sb.append(capturedNum6);
                sb.append("\n");
            }
            return sb.toString();
        }
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> canMovePoints = getChess(source.getX(), source.getY()).canMoveTo();
        for (int i = 0; i < canMovePoints.size(); i++) {
            for (int j = i + 1; j < canMovePoints.size(); j++) {
                if (canMovePoints.get(i).getX() > canMovePoints.get(j).getX()) {
                    Collections.swap(canMovePoints, i, j);
                }
            }
        }
        for (int i = 0; i < canMovePoints.size(); i++) {
            for (int j = i + 1; j < canMovePoints.size(); j++) {
                if (canMovePoints.get(i).getX() == canMovePoints.get(j).getX() && canMovePoints.get(i).getY() > canMovePoints.get(j).getY()) {
                    Collections.swap(canMovePoints, i, j);
                }
            }
        }
        return canMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (getChess(sourceX, sourceY).getChessColor() != getCurrentPlayer()) {
            return false;
        } else {
            boolean test = false;
            for (int i = 0; i < getCanMovePoints(new ChessboardPoint(sourceX, sourceY)).size(); i++) {
                if (getCanMovePoints(getChess(sourceX, sourceY).getSource()).get(i).getX() == targetX && getCanMovePoints(getChess(sourceX, sourceY).getSource()).get(i).getY() == targetY) {
                    test = true;
                    chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                    chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX, targetY));
                    chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX, sourceY), ChessColor.NONE);
                    if (getCurrentPlayer() == ChessColor.WHITE) {
                        currentPlayer = ChessColor.BLACK;
                    } else {
                        currentPlayer = ChessColor.WHITE;
                    }
                    break;
                }
            }
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    chessComponents[i][j].setChessComponents(chessComponents);
                }
            }
            if (test) {
                return true;
            } else {
                return false;
            }
        }
    }
}
