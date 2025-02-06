
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ConcreteChessGame implements ChessGame {
    // A 2-dimension array to store all the chess components
// should be initialized in your construct method.
// i.e. = new ChessComponent[8][8]
    private ChessComponent[][] chessComponents;
    // What's the current player's color, black or white?
// should be initialized in your construct method.
// by default, set the color to white.
    private ChessColor currentPlayer;


    @Override
    public void loadChessGame(List<String> chessboard) {

        chessComponents = new ChessComponent[8][8];
        //fill the chessComponents
        //the first 8 rows are chessboard
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                chessComponents[i][j] = figureChess(String.valueOf(chessboard.get(i).charAt(j)));
                //figure out the color
                // by default, set the color to white.
                if (Character.isUpperCase(chessboard.get(i).charAt(j))) {
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                } else {
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                }
                chessComponents[i][j].setName();
                chessComponents[i][j].setSource(i, j);
            }
        }

        //figure out the player
        if (chessboard.get(8).charAt(0) == 'b') {
            this.currentPlayer = ChessColor.BLACK;
        } else {
            this.currentPlayer = ChessColor.WHITE;
        }

    }


    @Override
    public String getChessboardGraph() {
        String s = "";
        s = s.concat(chessGraph(chessComponents));
        return s;
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        //conserve the initial chessboard

        String capturedChess = "";

        capturedChess = capturedChess.concat(capturedChess(getChessboardGraph(), player));


        return capturedChess;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {

        //Check out whether the current ChessComponent (sourceX, sourceY) match the current player.
        boolean judgeColor = false;
        if (getChess(sourceX, sourceY).getChessColor().equals(currentPlayer) && !getChess(sourceX, sourceY).getClass().equals(EmptySlotComponent.class)) {
            judgeColor = true;

        }

        if (judgeColor) {
            //judge if the target coordinate appears in the canMove List
            int appearance = 0;
            chessComponents[sourceX][sourceY].setCurrentChessboard(chessComponents);
            List<ChessboardPoint> canMoveList = getChess(sourceX, sourceY).canMoveTo();
            for (int i = 0; i < canMoveList.size(); i++) {
                if (targetX== canMoveList.get(i).getX()&&targetY==canMoveList.get(i).getY() && !chessComponents[sourceX][sourceY].getClass().equals(EmptySlotComponent.class)) {
                    appearance++;
                    break;
                }
            }
            if (appearance != 0) {
                //change the location of the chess
                ChessComponent temp = getChess(sourceX, sourceY);
                chessComponents[sourceX][sourceY] = chessComponents[targetX][targetY];
                chessComponents[targetX][targetY] = temp;
                chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                chessComponents[targetX][targetY].setCurrentChessboard(chessComponents);
                chessComponents[sourceX][sourceY].setSource(sourceX, sourceY);
                chessComponents[targetX][targetY].setSource(targetX, targetY);


                //switch the player
                if (currentPlayer == ChessColor.WHITE) {
                    currentPlayer = ChessColor.BLACK;
                } else {
                    currentPlayer = ChessColor.WHITE;
                }
                return true;
            } else {
                return false;
            }


        } else {
            return false;
        }
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        // 1. find chess according to source
        chessComponents[source.getX()][source.getY()].setCurrentChessboard(chessComponents);
        ChessComponent chess = chessComponents[source.getX()][source.getY()];
        // 2. as below statement:
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        // 3.sort canMovePoints by x - y ascending order
        for (int i = 0; i < canMovePoints.size(); i++) {
            for (int j = 0; j < canMovePoints.size() - i - 1; j++) {
                if (canMovePoints.get(j).getX() > canMovePoints.get(j + 1).getX()) {
                    canMovePoints.add(j, canMovePoints.get(j + 1));
                    canMovePoints.remove(j + 2);
                } else if (canMovePoints.get(j).getX() == canMovePoints.get(j + 1).getX()) {
                    if (canMovePoints.get(j).getY() > canMovePoints.get(j + 1).getY()) {
                        canMovePoints.add(j, canMovePoints.get(j + 1));
                        canMovePoints.remove(j + 2);
                    }
                }
            }
        }
        return canMovePoints;
    }


    //methods that added by myself
    public ChessComponent figureChess(String s) {

        if (s.equalsIgnoreCase("r")) {

            return new RookChessComponent();
        }
        if (s.equalsIgnoreCase("n")) {
            return new KnightChessComponent();
        }
        if (s.equalsIgnoreCase("b")) {
            return new BishopChessComponent();
        }
        if (s.equalsIgnoreCase("q")) {
            return new QueenChessComponent();
        }
        if (s.equalsIgnoreCase("k")) {
            return new KingChessComponent();
        }
        if (s.equalsIgnoreCase("p")) {
            return new PawnChessComponent();
        }
        if (s.equalsIgnoreCase("_")) {
            return new EmptySlotComponent();
        }
        return null;
    }

    public String chessGraph(ChessComponent[][] chessComponents) {
        String s = "";
        List<String> ss = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            ss.clear();
            for (int j = 0; j < 8; j++) {
                if (chessComponents[i][j].getClass().equals(KingChessComponent.class)) {
                    ss.add("k");
                }
                if (chessComponents[i][j].getClass().equals(QueenChessComponent.class)) {
                    ss.add("q");
                }
                if (chessComponents[i][j].getClass().equals(RookChessComponent.class)) {
                    ss.add("r");
                }
                if (chessComponents[i][j].getClass().equals(BishopChessComponent.class)) {
                    ss.add("b");
                }
                if (chessComponents[i][j].getClass().equals(KnightChessComponent.class)) {
                    ss.add("n");
                }
                if (chessComponents[i][j].getClass().equals(PawnChessComponent.class)) {
                    ss.add("p");
                }
                if (chessComponents[i][j].getClass().equals(EmptySlotComponent.class)) {
                    ss.add("_");
                }


                //chess's color define upper or lower case
                if (chessComponents[i][j].getChessColor() == ChessColor.BLACK) {
                    ss.add(j, ss.get(j).toUpperCase(Locale.ROOT));
                    ss.remove(j + 1);
                }
                s = s.concat(ss.get(j));
                if (j == 7) {
                    s = s.concat("\n");
                }
            }

        }
        return s;
    }

    public String capturedChess(String graph, ChessColor player) {

        String captured = "";
        //count the amount
        int k1 = 0;
        int k2 = 0;
        int q1 = 0;
        int q2 = 0;
        int r1 = 0;
        int r2 = 0;
        int b1 = 0;
        int b2 = 0;
        int n1 = 0;
        int n2 = 0;
        int p1 = 0;
        int p2 = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (getChessboardGraph().charAt(9 * i + j) == 'K') {
                    k1++;
                }
                if (getChessboardGraph().charAt(9 * i + j) == 'k') {
                    k2++;
                }
                if (getChessboardGraph().charAt(9 * i + j) == 'Q') {
                    q1++;
                }
                if (getChessboardGraph().charAt(9 * i + j) == 'q') {
                    q2++;
                }
                if (getChessboardGraph().charAt(9 * i + j) == 'R') {
                    r1++;
                }
                if (getChessboardGraph().charAt(9 * i + j) == 'r') {
                    r2++;
                }
                if (getChessboardGraph().charAt(9 * i + j) == 'B') {
                    b1++;
                }
                if (getChessboardGraph().charAt(9 * i + j) == 'b') {
                    b2++;
                }
                if (getChessboardGraph().charAt(9 * i + j) == 'N') {
                    n1++;
                }
                if (getChessboardGraph().charAt(9 * i + j) == 'n') {
                    n2++;
                }
                if (getChessboardGraph().charAt(9 * i + j) == 'P') {
                    p1++;
                }
                if (getChessboardGraph().charAt(9 * i + j) == 'p') {
                    p2++;
                }
            }

        }

        //count the amount of the captured chess
        if (player == ChessColor.BLACK) {
            if (1 - k1 > 0) {
                captured += "K " + (1 - k1) + "\n";
            }
            if (1 - q1 > 0) {
                captured += "Q " + (1 - q1) + "\n";
            }
            if (2 - r1 > 0) {
                captured += "R " + (2 - r1) + "\n";
            }
            if (2 - b1 > 0) {
                captured += "B " + (2 - b1) + "\n";
            }
            if (2 - n1 > 0) {
                captured += "N " + (2 - n1) + "\n";
            }
            if (8 - p1 > 0) {
                captured += "P " + (8 - p1) + "\n";
            }
        } else {
            if (1 - k2 > 0) {
                captured += "k " + (1 - k2) + "\n";
            }
            if (1 - q2 > 0) {
                captured += "q " + (1 - q2) + "\n";
            }
            if (2 - r2 > 0) {
                captured += "r " + (2 - r2) + "\n";
            }
            if (2 - b2 > 0) {
                captured += "b " + (2 - b2) + "\n";
            }
            if (2 - n2 > 0) {
                captured += "n " + (2 - n2) + "\n";
            }
            if (8 - p2 > 0) {
                captured += "p " + (8 - p2) + "\n";
            }
        }


        return captured;
    }


}
