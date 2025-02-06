import java.util.ArrayList;
import java.util.Comparator;
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
                if (chessboard.get(i).charAt(j) == 'r') {
                    chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, chessboard.get(i).charAt(j));
                } else if (chessboard.get(i).charAt(j) == 'R') {
                    chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, chessboard.get(i).charAt(j));
                } else if (chessboard.get(i).charAt(j) == 'k') {
                    chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, chessboard.get(i).charAt(j));
                } else if (chessboard.get(i).charAt(j) == 'K') {
                    chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, chessboard.get(i).charAt(j));
                } else if (chessboard.get(i).charAt(j) == 'n') {
                    chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, chessboard.get(i).charAt(j));
                } else if (chessboard.get(i).charAt(j) == 'N') {
                    chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, chessboard.get(i).charAt(j));
                } else if (chessboard.get(i).charAt(j) == 'b') {
                    chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, chessboard.get(i).charAt(j));
                } else if (chessboard.get(i).charAt(j) == 'B') {
                    chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, chessboard.get(i).charAt(j));
                } else if (chessboard.get(i).charAt(j) == 'q') {
                    chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, chessboard.get(i).charAt(j));
                } else if (chessboard.get(i).charAt(j) == 'Q') {
                    chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, chessboard.get(i).charAt(j));
                } else if (chessboard.get(i).charAt(j) == 'p') {
                    chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, chessboard.get(i).charAt(j));
                } else if (chessboard.get(i).charAt(j) == 'P') {
                    chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, chessboard.get(i).charAt(j));
                } else if (chessboard.get(i).charAt(j) == '_') {
                    chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i, j), ChessColor.NONE, chessboard.get(i).charAt(j));
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

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph() {
        String a = "";
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                a = a + String.valueOf(chessComponents[i][j].name);
            }
            a += String.valueOf('\n');
        }
        return a;

    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int[] Black1 = new int[]{1, 1, 2, 2, 2, 8};
        int[] White1 = new int[]{1, 1, 2, 2, 2, 8};
        int[] Black = new int[6];
        int[] White = new int[6];
        String s1 = "";
        String s2 = "";
        String[] ss1 = new String[]{"K ", "Q ", "R ", "B ", "N ", "P "};
        String[] ss2 = new String[]{"k ", "q ", "r ", "b ", "n ", "p "};
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessComponents[i][j].name == 'K') {
                    Black1[0]--;
                    if (Black1[0] == 0) {
                        Black[0] = 1;
                    }
                } else if (chessComponents[i][j].name == 'k') {
                    White1[0]--;
                    if (White1[0] == 0) {
                        White[0] = 1;
                    }
                } else if (chessComponents[i][j].name == 'Q') {
                    Black1[1]--;
                    if (Black1[1] == 0) {
                        Black[1] = 1;
                    }
                } else if (chessComponents[i][j].name == 'q') {
                    White1[1]--;
                    if (White1[1] == 0) {
                        White[1] = 1;
                    }
                } else if (chessComponents[i][j].name == 'R') {
                    Black1[2]--;
                    if (Black1[2] == 0) {
                        Black[2] = 1;
                    }
                } else if (chessComponents[i][j].name == 'r') {
                    White1[2]--;
                    if (White1[2] == 0) {
                        White[2] = 1;
                    }
                } else if (chessComponents[i][j].name == 'B') {
                    Black1[3]--;
                    if (Black1[3] == 0) {
                        Black[3] = 1;
                    }
                } else if (chessComponents[i][j].name == 'b') {
                    White1[3]--;
                    if (White1[3] == 0) {
                        White[3] = 1;
                    }
                } else if (chessComponents[i][j].name == 'N') {
                    Black1[4]--;
                    if (Black1[4] == 0) {
                        Black[4] = 1;
                    }
                } else if (chessComponents[i][j].name == 'n') {
                    White1[4]--;
                    if (White1[4] == 0) {
                        White[4] = 1;
                    }
                } else if (chessComponents[i][j].name == 'P') {
                    Black1[5]--;
                    if (Black1[5] == 0) {
                        Black[5] = 1;
                    }
                } else if (chessComponents[i][j].name == 'p') {
                    White1[5]--;
                    if (White1[5] == 0) {
                        White[5] = 1;
                    }
                }
            }
        }
        if (player == ChessColor.BLACK) {
            for (int i = 0; i < Black.length; i++) {
                if (Black[i] == 0) {
                    s1 += ss1[i] + Black1[i] + ('\n');
                }
            }

            return s1;
        } else {
            for (int i = 0; i < White.length; i++) {
                if (White[i] == 0) {
                    s2 += ss2[i] + White1[i] + ('\n');
                }
            }

            return s2;
        }

    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ArrayList<ChessboardPoint> getCanMovePoints = new ArrayList<>();
        ChessboardPoint chessboardPoint = new ChessboardPoint(source.getX(), source.getY());
        int count = 0;

        if (chessComponents[source.getX()][source.getY()].name == 'k') {
            ChessComponent whiteKing = new KingChessComponent(source, ChessColor.WHITE, 'k');
            getCanMovePoints.addAll(whiteKing.canMoveTo());
            for (int i = 0; i < whiteKing.canMoveTo().size(); i++) {
                if (chessComponents[whiteKing.canMoveTo().get(i).getX()][whiteKing.canMoveTo().get(i).getY()].getChessColor() == ChessColor.WHITE) {
                    getCanMovePoints.remove(getCanMovePoints.get(i - count));
                    count++;
                }
            }
            getCanMovePoints.sort(Comparator.comparing(ChessboardPoint::getX).thenComparing(ChessboardPoint::getY));
            return getCanMovePoints;
        } else if (chessComponents[source.getX()][source.getY()].name == 'K') {
            ChessComponent blackKing = new KingChessComponent(source, ChessColor.BLACK, 'K');
            getCanMovePoints.addAll(blackKing.canMoveTo());
            for (int i = 0; i < blackKing.canMoveTo().size(); i++) {
                if (chessComponents[blackKing.canMoveTo().get(i).getX()][blackKing.canMoveTo().get(i).getY()].getChessColor() == ChessColor.BLACK) {
                    getCanMovePoints.remove(getCanMovePoints.get(i - count));
                    count++;
                }
            }
            getCanMovePoints.sort(Comparator.comparing(ChessboardPoint::getX).thenComparing(ChessboardPoint::getY));
            return getCanMovePoints;
        } else if (chessComponents[source.getX()][source.getY()].name == 'q' || chessComponents[source.getX()][source.getY()].name == 'Q') {
            for (int i = 1; i < 8; i++) {
                if (chessboardPoint.offset(i, 0) != null && isLegal(source.getX(), source.getY(), source.getX() + i, source.getY(), getCanMovePoints)) {
                    continue;
                } else {
                    break;
                }
            }
            for (int i = -1; i > -8; i--) {
                if (chessboardPoint.offset(i, 0) != null && isLegal(source.getX(), source.getY(), source.getX() + i, source.getY(), getCanMovePoints)) {
                    continue;
                } else {
                    break;
                }
            }
            for (int i = 1; i < 8; i++) {
                if (chessboardPoint.offset(0, i) != null && isLegal(source.getX(), source.getY(), source.getX(), source.getY() + i, getCanMovePoints)) {
                    continue;
                } else {
                    break;
                }
            }
            for (int i = -1; i > -8; i--) {
                if (chessboardPoint.offset(0, i) != null && isLegal(source.getX(), source.getY(), source.getX(), source.getY() + i, getCanMovePoints)) {
                    continue;
                } else {
                    break;
                }
            }
            for (int i = 1; i < 8; i++) {
                if (chessboardPoint.offset(i, i) != null && isLegal(source.getX(), source.getY(), source.getX() + i, source.getY() + i, getCanMovePoints)) {
                    continue;
                } else {
                    break;
                }
            }
            for (int i = 1; i < 8; i++) {
                if (chessboardPoint.offset(i, -i) != null && isLegal(source.getX(), source.getY(), source.getX() + i, source.getY() - i, getCanMovePoints)) {
                    continue;
                } else {
                    break;
                }
            }
            for (int i = -1; i > -8; i--) {
                if (chessboardPoint.offset(i, i) != null && isLegal(source.getX(), source.getY(), source.getX() + i, source.getY() + i, getCanMovePoints)) {
                    continue;
                } else {
                    break;
                }
            }
            for (int i = -1; i > -8; i--) {
                if (chessboardPoint.offset(i, -i) != null && isLegal(source.getX(), source.getY(), source.getX() + i, source.getY() - i, getCanMovePoints)) {
                    continue;
                } else {
                    break;
                }
            }
            getCanMovePoints.sort(Comparator.comparing(ChessboardPoint::getX).thenComparing(ChessboardPoint::getY));
            return getCanMovePoints;
        } else if (chessComponents[source.getX()][source.getY()].name == 'r' || chessComponents[source.getX()][source.getY()].name == 'R') {
            for (int i = 1; i < 8; i++) {
                if (chessboardPoint.offset(i, 0) != null && isLegal(source.getX(), source.getY(), source.getX() + i, source.getY(), getCanMovePoints)) {
                    continue;
                } else {
                    break;
                }
            }
            for (int i = -1; i > -8; i--) {
                if (chessboardPoint.offset(i, 0) != null && isLegal(source.getX(), source.getY(), source.getX() + i, source.getY(), getCanMovePoints)) {
                    continue;
                } else {
                    break;
                }
            }
            for (int i = 1; i < 8; i++) {
                if (chessboardPoint.offset(0, i) != null && isLegal(source.getX(), source.getY(), source.getX(), source.getY() + i, getCanMovePoints)) {
                    continue;
                } else {
                    break;
                }
            }
            for (int i = -1; i > -8; i--) {
                if (chessboardPoint.offset(0, i) != null && isLegal(source.getX(), source.getY(), source.getX(), source.getY() + i, getCanMovePoints)) {
                    continue;
                } else {
                    break;
                }
            }
            getCanMovePoints.sort(Comparator.comparing(ChessboardPoint::getX).thenComparing(ChessboardPoint::getY));
            return getCanMovePoints;
        } else if (chessComponents[source.getX()][source.getY()].name == 'b' || chessComponents[source.getX()][source.getY()].name == 'B') {
            for (int i = 1; i < 8; i++) {
                if (chessboardPoint.offset(i, i) != null && isLegal(source.getX(), source.getY(), source.getX() + i, source.getY() + i, getCanMovePoints)) {

                } else {
                    break;
                }
            }
            for (int i = 1; i < 8; i++) {
                if (chessboardPoint.offset(i, -i) != null && isLegal(source.getX(), source.getY(), source.getX() + i, source.getY() - i, getCanMovePoints)) {

                } else {
                    break;
                }
            }
            for (int i = -1; i > -8; i--) {
                if (chessboardPoint.offset(i, i) != null && isLegal(source.getX(), source.getY(), source.getX() + i, source.getY() + i, getCanMovePoints)) {

                } else {
                    break;
                }
            }
            for (int i = -1; i > -8; i--) {
                if (chessboardPoint.offset(i, -i) != null && isLegal(source.getX(), source.getY(), source.getX() + i, source.getY() - i, getCanMovePoints)) {


                } else {
                    break;
                }
            }
            getCanMovePoints.sort(Comparator.comparing(ChessboardPoint::getX).thenComparing(ChessboardPoint::getY));
            return getCanMovePoints;
        } else if (chessComponents[source.getX()][source.getY()].name == 'n') {
            ChessComponent whiteKnight = new KnightChessComponent(source, ChessColor.WHITE, 'n');
            getCanMovePoints.addAll(whiteKnight.canMoveTo());
            for (int i = 0; i < whiteKnight.canMoveTo().size(); i++) {
                if (chessComponents[whiteKnight.canMoveTo().get(i).getX()][whiteKnight.canMoveTo().get(i).getY()].getChessColor() == ChessColor.WHITE) {
                    getCanMovePoints.remove(getCanMovePoints.get(i - count));
                    count++;
                }
            }
            getCanMovePoints.sort(Comparator.comparing(ChessboardPoint::getX).thenComparing(ChessboardPoint::getY));
            return getCanMovePoints;
        } else if (chessComponents[source.getX()][source.getY()].name == 'N') {
            ChessComponent blackKnight = new KnightChessComponent(source, ChessColor.BLACK, 'N');
            getCanMovePoints.addAll(blackKnight.canMoveTo());
            for (int i = 0; i < blackKnight.canMoveTo().size(); i++) {
                if (chessComponents[blackKnight.canMoveTo().get(i).getX()][blackKnight.canMoveTo().get(i).getY()].getChessColor() == ChessColor.BLACK) {
                    getCanMovePoints.remove(getCanMovePoints.get(i - count));
                    count++;

                }
            }
            getCanMovePoints.sort(Comparator.comparing(ChessboardPoint::getX).thenComparing(ChessboardPoint::getY));
            return getCanMovePoints;
        } else if (chessComponents[source.getX()][source.getY()].name == 'p') {
            if (source.getX() == 6) {
                if (chessboardPoint.offset(-1, 0) != null) {
                    if (chessComponents[source.getX() - 1][source.getY()].getChessColor() == ChessColor.NONE) {
                        getCanMovePoints.add(chessboardPoint.offset(-1, 0));
                        if (chessboardPoint.offset(-2, 0) != null) {
                            if (chessComponents[source.getX() - 2][source.getY()].getChessColor() == ChessColor.NONE) {
                                getCanMovePoints.add(chessboardPoint.offset(-2, 0));
                            }
                        }
                    }
                }
                if (chessboardPoint.offset(-1, -1) != null) {
                    if (chessComponents[source.getX() - 1][source.getY() - 1].getChessColor() == ChessColor.BLACK) {
                        getCanMovePoints.add(chessboardPoint.offset(-1, -1));
                    }
                }
                if (chessboardPoint.offset(-1, 1) != null) {
                    if (chessComponents[source.getX() - 1][source.getY() + 1].getChessColor() == ChessColor.BLACK) {
                        getCanMovePoints.add(chessboardPoint.offset(-1, 1));
                    }
                }
            } else {
                if (chessboardPoint.offset(-1, 0) != null) {
                    if (chessComponents[source.getX() - 1][source.getY()].getChessColor() == ChessColor.NONE) {
                        getCanMovePoints.add(chessboardPoint.offset(-1, 0));
                    }
                }
                if (chessboardPoint.offset(-1, -1) != null) {
                    if (chessComponents[source.getX() - 1][source.getY() - 1].getChessColor() == ChessColor.BLACK) {
                        getCanMovePoints.add(chessboardPoint.offset(-1, -1));
                    }
                }
                if (chessboardPoint.offset(-1, 1) != null) {
                    if (chessComponents[source.getX() - 1][source.getY() + 1].getChessColor() == ChessColor.BLACK) {
                        getCanMovePoints.add(chessboardPoint.offset(-1, 1));
                    }

                }
            }
            getCanMovePoints.sort(Comparator.comparing(ChessboardPoint::getX).thenComparing(ChessboardPoint::getY));
            return getCanMovePoints;
        } else if (chessComponents[source.getX()][source.getY()].name == 'P') {
            if (source.getX() == 1) {
                if (chessboardPoint.offset(1, 0) != null) {
                    if (chessComponents[source.getX() + 1][source.getY()].getChessColor() == ChessColor.NONE) {
                        getCanMovePoints.add(chessboardPoint.offset(1, 0));
                        if (chessboardPoint.offset(+2, 0) != null) {
                            if (chessComponents[source.getX() + 2][source.getY()].getChessColor() == ChessColor.NONE) {
                                getCanMovePoints.add(chessboardPoint.offset(2, 0));
                            }
                        }
                    }
                }
                if (chessboardPoint.offset(1, -1) != null) {
                    if (chessComponents[source.getX() + 1][source.getY() - 1].getChessColor() == ChessColor.WHITE) {
                        getCanMovePoints.add(chessboardPoint.offset(+1, -1));
                    }
                }
                if (chessboardPoint.offset(1, 1) != null) {
                    if (chessComponents[source.getX() + 1][source.getY() + 1].getChessColor() == ChessColor.WHITE) {
                        getCanMovePoints.add(chessboardPoint.offset(1, 1));
                    }
                }
            } else {
                if (chessboardPoint.offset(1, 0) != null) {
                    if (chessComponents[source.getX() + 1][source.getY()].getChessColor() == ChessColor.NONE) {
                        getCanMovePoints.add(chessboardPoint.offset(1, 0));
                    }
                }
                if (chessboardPoint.offset(1, -1) != null) {
                    if (chessComponents[source.getX() + 1][source.getY() - 1].getChessColor() == ChessColor.WHITE) {
                        getCanMovePoints.add(chessboardPoint.offset(1, -1));
                    }
                }
                if (chessboardPoint.offset(1, 1) != null) {
                    if (chessComponents[source.getX() + 1][source.getY() + 1].getChessColor() == ChessColor.WHITE) {
                        getCanMovePoints.add(chessboardPoint.offset(1, 1));
                    }

                }
            }
            getCanMovePoints.sort(Comparator.comparing(ChessboardPoint::getX).thenComparing(ChessboardPoint::getY));
            return getCanMovePoints;
        } else {
            return getCanMovePoints;
        }
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessboardPoint source = new ChessboardPoint(sourceX, sourceY);
        ChessboardPoint target = new ChessboardPoint(targetX, targetY);

        int count = 0;
        if (chessComponents[sourceX][sourceY].getChessColor() != currentPlayer) {
            return false;
        }
        for (int i = 0; i < getCanMovePoints(source).size(); i++) {
            if (getCanMovePoints(source).get(i).getX()==targetX&&getCanMovePoints(source).get(i).getY()==targetY) {
                count = 1;
                break;
            }
        }
        if (count == 1) {
            chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
            chessComponents[sourceX][sourceY] = new EmptySlotComponent(source, ChessColor.NONE, '_');
            if (currentPlayer == ChessColor.WHITE) {
                currentPlayer = ChessColor.BLACK;
            } else {
                currentPlayer = ChessColor.WHITE;
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean isLegal(int sourceX, int sourceY, int targetX, int targetY, List<ChessboardPoint> steps) {
        boolean isLegal = true;
        ChessboardPoint a = new ChessboardPoint(targetX, targetY);
        if (chessComponents[targetX][targetY].name == '_') {
            steps.add(a);
        } else if (chessComponents[targetX][targetY].getChessColor() == chessComponents[sourceX][sourceY].getChessColor()) {
            isLegal = false;
        } else {
            isLegal = false;
            steps.add(a);
        }
        return isLegal;
    }
}

