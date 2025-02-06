import java.util.List;
public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;
    private List<String> chessboard;

    public ConcreteChessGame() {
        chessComponents = new ChessComponent[8][8];
        currentPlayer = ChessColor.WHITE;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i, j));
            }
        }
    }

    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void setChessComponents(ChessComponent chessComponent, int x, int y) {
        this.chessComponents[x][y] = chessComponent;
        this.chessComponents[x][y].setSource(new ChessboardPoint(x,y));
    }


    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                if (chessboard.get(i).charAt(j) == 'K') {
                    chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, this);
                } else if (chessboard.get(i).charAt(j) == 'k') {
                    chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, this);
                } else if (chessboard.get(i).charAt(j) == 'Q') {
                    chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, this);
                } else if (chessboard.get(i).charAt(j) == 'q') {
                    chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, this);
                } else if (chessboard.get(i).charAt(j) == 'R') {
                    chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, this);
                } else if (chessboard.get(i).charAt(j) == 'r') {
                    chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, this);
                } else if (chessboard.get(i).charAt(j) == 'B') {
                    chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, this);
                } else if (chessboard.get(i).charAt(j) == 'b') {
                    chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, this);
                } else if (chessboard.get(i).charAt(j) == 'N') {
                    chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, this);
                } else if (chessboard.get(i).charAt(j) == 'n') {
                    chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, this);
                } else if (chessboard.get(i).charAt(j) == 'P') {
                    chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, this);
                } else if (chessboard.get(i).charAt(j) == 'p') {
                    chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, this);
                } else if (chessboard.get(i).charAt(j) == '_') {
                    chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i, j));
                }
            }
        }
        if (chessboard.get(8).equals("w")) {
            setCurrentPlayer(ChessColor.WHITE);
        } else if (chessboard.get(8).equals("b")) {
            setCurrentPlayer(ChessColor.BLACK);
        }
        this.chessboard = chessboard;
    }

    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public String getChessboardGraph() {
        return String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n", chessboard.get(0), chessboard.get(1), chessboard.get(2), chessboard.get(3),
                chessboard.get(4), chessboard.get(5), chessboard.get(6), chessboard.get(7));
    }

    public String getCapturedChess(ChessColor player) {
        String[] c;
        int[] t = {1, 1, 2, 2, 2, 8};
        if (player == ChessColor.BLACK) {
            c = new String[]{"K", "Q", "R", "B", "N", "P"};
            for (int i = 0; i <= 7; i++) {
                for (int j = 0; j <= 7; j++) {
                    if (chessComponents[i][j].name == 'K') {
                        t[0] = t[0] - 1;
                    }
                    if (chessComponents[i][j].name == 'Q') {
                        t[1] = t[1] - 1;
                    }
                    if (chessComponents[i][j].name == 'R') {
                        t[2] = t[2] - 1;
                    }
                    if (chessComponents[i][j].name == 'B') {
                        t[3] = t[3] - 1;
                    }
                    if (chessComponents[i][j].name == 'N') {
                        t[4] = t[4] - 1;
                    }
                    if (chessComponents[i][j].name == 'P') {
                        t[5] = t[5] - 1;
                    }
                }
            }
        } else {
            c = new String[]{"k", "q", "r", "b", "n", "p"};
            for (int i = 0; i <= 7; i++) {
                for (int j = 0; j <= 7; j++) {
                    if (chessComponents[i][j].name == 'k') {
                        t[0] = t[0] - 1;
                    }
                    if (chessComponents[i][j].name == 'q') {
                        t[1] = t[1] - 1;
                    }
                    if (chessComponents[i][j].name == 'r') {
                        t[2] = t[2] - 1;
                    }
                    if (chessComponents[i][j].name == 'b') {
                        t[3] = t[3] - 1;
                    }
                    if (chessComponents[i][j].name == 'n') {
                        t[4] = t[4] - 1;
                    }
                    if (chessComponents[i][j].name == 'p') {
                        t[5] = t[5] - 1;
                    }
                }
            }
        }
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            if (t[i] != 0) {
                str.append(c[i]).append(" ").append(t[i]).append("\n");
            }
        }
        return str.toString();
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> canMovePoints = getChess(source.getX(), source.getY()).canMoveTo();
        for (int i = 0; i < canMovePoints.size(); i++) {
            for (int j = i + 1; j < canMovePoints.size(); j++) {
                if (canMovePoints.get(i).getX() > canMovePoints.get(j).getX()) {
                    ChessboardPoint temp = canMovePoints.get(j);
                    canMovePoints.set(j, canMovePoints.get(i));
                    canMovePoints.set(i, temp);
                }
            }
        }
        for (int i = 0; i < canMovePoints.size(); i++){
            for (int j = i + 1; j < canMovePoints.size(); j++){
                if (canMovePoints.get(i).getX() == canMovePoints.get(j).getX()){
                    if (canMovePoints.get(i).getY() > canMovePoints.get(j).getY()) {
                        ChessboardPoint temp = canMovePoints.get(j);
                        canMovePoints.set(j, canMovePoints.get(i));
                        canMovePoints.set(i, temp);
                    }
                }
            }
        }
        return canMovePoints;
    }

    public boolean moveChess1(int sourceX, int sourceY, int targetX, int targetY) {
        boolean a = sourceX == targetX && sourceY == targetY;
        if (a) {
            return false;
        }
        boolean d = sourceX >= 0 && sourceX <= 7 && sourceY >= 0 && sourceY <= 7 && targetX >= 0 && targetX <= 7 && targetY >= 0 && targetY <= 7;
        if (!d) {
            return false;
        }
        return getChess(targetX, targetY).getChessColor() != getChess(sourceX, sourceY).getChessColor();
    }

    public boolean moveChess2(int sourceX, int sourceY, int targetX, int targetY){
        boolean a = sourceX == targetX && sourceY == targetY;
        if (a) {
            return false;
        }
        return sourceX >= 0 && sourceX <= 7 && sourceY >= 0 && sourceY <= 7 && targetX >= 0 && targetX <= 7 && targetY >= 0 && targetY <= 7;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (targetX < 0 || targetX > 7 || targetY < 0 || targetY > 7) {
            return false;
        }
        boolean a = this.getCurrentPlayer() == getChess(sourceX, sourceY).getChessColor();
        boolean c = getChess(targetX, targetY).getChessColor() != ChessColor.NONE;
        boolean q = getChess(sourceX, sourceY).canMoveTo().contains(new ChessboardPoint(targetX, targetY));
        if (a && q) {
            if (c) {
                setChessComponents(getChess(sourceX, sourceY), targetX, targetY);
                ChessboardPoint k = new ChessboardPoint(sourceX, sourceY);
                setChessComponents(new EmptySlotComponent(k), sourceX, sourceY);
            } else {
                ChessComponent temp = getChess(sourceX, sourceY);
                setChessComponents(getChess(targetX, targetY), sourceX, sourceY);
                setChessComponents(temp, targetX, targetY);
            }
            if (this.currentPlayer == ChessColor.WHITE) {
                setCurrentPlayer(ChessColor.BLACK);
            } else {
                setCurrentPlayer(ChessColor.WHITE);
            }
            return true;
        } else {
            return false;
        }
    }

    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }
}
