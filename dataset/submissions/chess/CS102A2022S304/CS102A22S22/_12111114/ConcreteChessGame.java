import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer;

    //private List<String> cb;
    public ConcreteChessGame() {
        StoreChessGame.setConcreteChessGame(this);
    }

    public void loadChessGame(List<String> chessboard) {
//        cb=chessboard;
        StoreChessGame.setConcreteChessGame(this);
        for (int j = 0; j < 8; j++) {//x
            for (int i = 0; i < 8; i++) {//y
                if (chessboard.get(i).charAt(j) == 'R') {
                    chessComponents[i][j] = new RookChessComponent(ChessColor.BLACK,i,j);
                } else if (chessboard.get(i).charAt(j) == 'N') {
                    chessComponents[i][j] = new KnightChessComponent(ChessColor.BLACK,i,j);
                } else if (chessboard.get(i).charAt(j) == 'B') {
                    chessComponents[i][j] = new BishopChessComponent(ChessColor.BLACK,i,j);
                } else if (chessboard.get(i).charAt(j) == 'Q') {
                    chessComponents[i][j] = new QueenChessComponent(ChessColor.BLACK,i,j);
                } else if (chessboard.get(i).charAt(j) == 'K') {
                    chessComponents[i][j] = new KingChessComponent(ChessColor.BLACK,i,j);
                } else if (chessboard.get(i).charAt(j) == 'P') {
                    chessComponents[i][j] = new PawnChessComponent(ChessColor.BLACK,i,j);
                } else if (chessboard.get(i).charAt(j) == 'r') {
                    chessComponents[i][j] = new RookChessComponent(ChessColor.WHITE,i,j);
                } else if (chessboard.get(i).charAt(j) == 'n') {
                    chessComponents[i][j] = new KnightChessComponent(ChessColor.WHITE,i,j);
                } else if (chessboard.get(i).charAt(j) == 'b') {
                    chessComponents[i][j] = new BishopChessComponent(ChessColor.WHITE,i,j);
                } else if (chessboard.get(i).charAt(j) == 'q') {
                    chessComponents[i][j] = new QueenChessComponent(ChessColor.WHITE,i,j);
                } else if (chessboard.get(i).charAt(j) == 'k') {
                    chessComponents[i][j] = new KingChessComponent(ChessColor.WHITE,i,j);
                } else if (chessboard.get(i).charAt(j) == 'p') {
                    chessComponents[i][j] = new PawnChessComponent(ChessColor.WHITE,i,j);
                } else {
                    chessComponents[i][j] = new EmptySlotComponent(ChessColor.NONE,i,j);
                }
            }
        }
        if (chessboard.get(8).equals("w")) {
            currentPlayer = ChessColor.WHITE;
        } else
            currentPlayer = ChessColor.BLACK;
    }

    public ChessColor getCurrentPlayer() {

        StoreChessGame.setConcreteChessGame(this);
        return this.currentPlayer;
    }

    public String getChessboardGraph() {
        StoreChessGame.setConcreteChessGame(this);
        StringBuilder a = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                a.append(chessComponents[i][j].tochar());
            }
            a.append("\n");
        }
        return a.toString();
//        return null;
    }

    //kqrbnp
    //430215
    public String getCapturedChess(ChessColor player) {
        StoreChessGame.setConcreteChessGame(this);
        int[] number = new int[]{2, 2, 2, 1, 1, 8, 0};
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (player == chessComponents[i][j].getChessColor())
                    number[chessComponents[i][j].getType()]--;
            }
        }
        StringBuilder a = new StringBuilder();
        int b = 0;
        if (player == ChessColor.WHITE) {
            if (number[4] != 0) {
                a.append("k " + String.valueOf(number[4]));
                b++;
            }
            if (number[3] != 0) {
                if (b != 0)
                    a.append("\n");
                a.append("q " + String.valueOf(number[3]));
                b++;
            }
            if (number[0] != 0) {
                if (b != 0)
                    a.append("\n");
                a.append("r " + String.valueOf(number[0]));
                b++;
            }
            if (number[2] != 0) {
                if (b != 0)
                    a.append("\n");
                a.append("b " + String.valueOf(number[2]));
                b++;
            }
            if (number[1] != 0) {
                if (b != 0)
                    a.append("\n");
                a.append("n " + String.valueOf(number[1]));
                b++;
            }
            if (number[5] != 0) {
                if (b != 0)
                    a.append("\n");
                a.append("p " + String.valueOf(number[5]));
                b++;
            }
        }
        else if (player == ChessColor.BLACK) {
            if (number[4] != 0) {
                a.append("K " + String.valueOf(number[4]));
                b++;
            }
            if (number[3] != 0) {
                if (b != 0)
                    a.append("\n");
                a.append("Q " + String.valueOf(number[3]));
                b++;
            }
            if (number[0] != 0) {
                if (b != 0)
                    a.append("\n");
                a.append("R ");
                a.append(number[0]);
                b++;
            }
            if (number[2] != 0) {
                if (b != 0)
                    a.append("\n");
                a.append("B " + String.valueOf(number[2]));
                b++;
            }
            if (number[1] != 0) {
                if (b != 0)
                    a.append("\n");
                a.append("N " + String.valueOf(number[1]));
                b++;
            }
            if (number[5] != 0) {
                if (b != 0)
                    a.append("\n");
                a.append("P " + String.valueOf(number[5]));
                b++;
            }
        }
        return a.toString();
    }

    public ChessComponent getChess(int x, int y) {
        StoreChessGame.setConcreteChessGame(this);
        return chessComponents[x][y];
    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        StoreChessGame.setConcreteChessGame(this);
        return chessComponents[source.getX()][source.getY()].canMoveTo();
    }

    public boolean moveChess(int sourceX, int sourceY, int targetY, int targetX) { // change the param list from X Y X Y to X Y Y X for no valid reason
        StoreChessGame.setConcreteChessGame(this);
        List<ChessboardPoint> chessboardPoints = getCanMovePoints(
                new ChessboardPoint(sourceX, sourceY));
        int length = chessboardPoints.size();
        for (ChessboardPoint chessboardPoint : chessboardPoints) {
            if (chessboardPoint.getX() == targetX && chessboardPoint.getY() == targetY) {
                return true;
            }
        }
        return false;
    }
}
