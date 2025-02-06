import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;


    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;

    }


    // transform letter to corresponding chess
    private ChessComponent transform(char name, int x, int y) {
        ChessComponent chess;
        // judge kind
        if (name == 'P' || name == 'p') {
            chess = new PawnChessComponent(name, x, y);
        } else if (name == 'R' || name == 'r') {
            chess = new RookChessComponent(name, x, y);
        } else if (name == 'N' || name == 'n') {
            chess = new KnightChessComponent(name, x, y);
        } else if (name == 'B' || name == 'b') {
            chess = new BishopChessComponent(name, x, y);
        } else if (name == 'Q' || name == 'q') {
            chess = new QueenChessComponent(name, x, y);
        } else if (name == 'K' || name == 'k') {
            chess = new KingChessComponent(name, x, y);
        } else {
            chess = new EmptySlotComponent(name, x, y);
        }

        return chess;
    }

    public void loadChessGame(List<String> chessboard) {
        // adding concrete chess
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char name = chessboard.get(i).charAt(j);
                chessComponents[i][j] = transform(name, i, j);
            }
        }

        // Judging current player
        if (chessboard.get(8).charAt(0) == 'w') {
            this.currentPlayer = ChessColor.WHITE;
        } else {
            this.currentPlayer = ChessColor.BLACK;
        }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    // save file, as String
    public String getChessboardGraph() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                sb.append(chessComponents[i][j].toString());
            }
            sb.append("\n");
        }

        String save = sb.toString();
        return save;
        // But why not judge current player ?????????
    }

    public String getCapturedChess(ChessColor player) {
        if (player.equals(ChessColor.WHITE)) {
            return calWhite(chessComponents);
        } else {
            return calBlack(chessComponents);
        }
    }

    // calculate for white side
    private String calWhite(ChessComponent[][] chessBoardNow) {
        int[] lost = {1, 1, 2, 2, 2, 8}; // "King > Queen > Rooks > Bishops > Knights > Pawns"
        // calculate how many lost, subtract remaining from original number
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessBoardNow[i][j].getName() == 'k') {
                    lost[0]--;
                } else if (chessBoardNow[i][j].getName() == 'q') {
                    lost[1]--;
                } else if (chessBoardNow[i][j].getName() == 'r') {
                    lost[2]--;
                } else if (chessBoardNow[i][j].getName() == 'b') {
                    lost[3]--;
                } else if (chessBoardNow[i][j].getName() == 'n') {
                    lost[4]--;
                } else if (chessBoardNow[i][j].getName() == 'p') {
                    lost[5]--;
                }
            }
        }
        // generate corresponding string
        StringBuilder sb = new StringBuilder();
        if (lost[0] != 0) {
            sb.append("k " + lost[0] + "\n");
        }
        if (lost[1] != 0) {
            sb.append("q " + lost[1] + "\n");
        }
        if (lost[2] != 0) {
            sb.append("r " + lost[2] + "\n");
        }
        if (lost[3] != 0) {
            sb.append("b " + lost[3] + "\n");
        }
        if (lost[4] != 0) {
            sb.append("n " + lost[4] + "\n");
        }
        if (lost[5] != 0) {
            sb.append("p " + lost[5] + "\n");
        }
        String str = sb.toString();
        return str;
    }

    // calculate for black side
    private String calBlack(ChessComponent[][] chessBoardNow) {
        int[] lost = {1, 1, 2, 2, 2, 8}; // "King > Queen > Rooks > Bishops > Knights > Pawns"
        // calculate how many lost, subtract remaining from original number
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessBoardNow[i][j].getName() == 'K') {
                    lost[0]--;
                } else if (chessBoardNow[i][j].getName() == 'Q') {
                    lost[1]--;
                } else if (chessBoardNow[i][j].getName() == 'R') {
                    lost[2]--;
                } else if (chessBoardNow[i][j].getName() == 'B') {
                    lost[3]--;
                } else if (chessBoardNow[i][j].getName() == 'N') {
                    lost[4]--;
                } else if (chessBoardNow[i][j].getName() == 'P') {
                    lost[5]--;
                }
            }
        }
        // generate corresponding string
        StringBuilder sb = new StringBuilder();
        if (lost[0] != 0) {
            sb.append("K " + lost[0] + "\n");
        }
        if (lost[1] != 0) {
            sb.append("Q " + lost[1] + "\n");
        }
        if (lost[2] != 0) {
            sb.append("R " + lost[2] + "\n");
        }
        if (lost[3] != 0) {
            sb.append("B " + lost[3] + "\n");
        }
        if (lost[4] != 0) {
            sb.append("N " + lost[4] + "\n");
        }
        if (lost[5] != 0) {
            sb.append("P " + lost[5] + "\n");
        }
        String str = sb.toString();
        return str;
    }

    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
        // you have to be careful with this coordinate, this may confuse you with the coordinate of the array
    }

    // ============================================================================================ //
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        // be careful with the coordinate
        //first check out whether the current chess match the current player
        boolean match = chessComponents[sourceX][sourceY].getChessColor().equals(getCurrentPlayer());

        if (!match) {
            return false;// check whether match
        }
        if (targetX < 0 || targetX > 7 || targetY < 0 || targetY > 7) {
            return false;// check whether offset
        }
        if (chessComponents[sourceX][sourceY].canMoveTo().contains(new ChessboardPoint(targetX, targetY))) {
            // move the chess
            chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
            chessComponents[sourceX][sourceY] = new EmptySlotComponent('_', sourceX, sourceY);
            chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX, targetY));
            // switch the player
            if (currentPlayer.equals(ChessColor.WHITE)) {
                currentPlayer = ChessColor.BLACK;
            } else {
                currentPlayer = ChessColor.WHITE;
            }
            return true;
        }
        return false;
    }

    // must apply polymorphism (How)
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        // 1. find chess according to source
        ChessComponent chess = this.getChess(source.getX(), source.getY());
        // 2. as below statement:
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        // 3.sort canMovePoints by x - y ascending order(Comparable defined in class, or Comparator def in here)
        List<ChessboardPoint> canMovePointsSorted = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) { // check all the points on the chessBoard
                if (canMovePoints.contains(new ChessboardPoint(i, j))) {
                    canMovePointsSorted.add(new ChessboardPoint(i, j));
                }
            }
        }
        return canMovePointsSorted;
    }

}