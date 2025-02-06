import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame {


    // Attributes
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;


    // Constructors
    public ConcreteChessGame(ChessComponent[][] chessComponents, ChessColor currentPlayer) {

        // this. input
        this.chessComponents = chessComponents;
        this.currentPlayer = currentPlayer;

    }

    public ConcreteChessGame() {
        super();
    }


    // Concrete Methods

    /**
     * In this method, you need to load chess game from given chessboard.
     *
     * @param chessboard Input game from file
     */
    @Override
    public void loadChessGame(List<String> chessboard) {

        // Input ChessComponents
        ChessComponent[][] putChessOnBoard = new ChessComponent[8][8];
        for (int x = 0; x < 8; x++) {

            String recorder = chessboard.get(x);
            String[] singleComponent = recorder.split("");

            for (int y = 0; y < 8; y++) {

                switch (singleComponent[y]) {
                    // Null
                    case "_" -> putChessOnBoard[x][y] = new EmptySlotComponent
                            (new ChessboardPoint(x, y), ChessColor.NONE, '_');
                    // Black
                    case "K" -> putChessOnBoard[x][y] = new KingChessComponent
                            (new ChessboardPoint(x, y), ChessColor.BLACK, 'K');
                    case "Q" -> putChessOnBoard[x][y] = new QueenChessComponent
                            (new ChessboardPoint(x, y), ChessColor.BLACK, 'Q');
                    case "R" -> putChessOnBoard[x][y] = new RookChessComponent
                            (new ChessboardPoint(x, y), ChessColor.BLACK, 'R');
                    case "B" -> putChessOnBoard[x][y] = new BishopChessComponent
                            (new ChessboardPoint(x, y), ChessColor.BLACK, 'B');
                    case "N" -> putChessOnBoard[x][y] = new KnightChessComponent
                            (new ChessboardPoint(x, y), ChessColor.BLACK, 'N');
                    case "P" -> putChessOnBoard[x][y] = new PawnChessComponent
                            (new ChessboardPoint(x, y), ChessColor.BLACK, 'P');
                    // White
                    case "k" -> putChessOnBoard[x][y] = new KingChessComponent
                            (new ChessboardPoint(x, y), ChessColor.WHITE, 'k');
                    case "q" -> putChessOnBoard[x][y] = new QueenChessComponent
                            (new ChessboardPoint(x, y), ChessColor.WHITE, 'q');
                    case "r" -> putChessOnBoard[x][y] = new RookChessComponent
                            (new ChessboardPoint(x, y), ChessColor.WHITE, 'r');
                    case "b" -> putChessOnBoard[x][y] = new BishopChessComponent
                            (new ChessboardPoint(x, y), ChessColor.WHITE, 'b');
                    case "n" -> putChessOnBoard[x][y] = new KnightChessComponent
                            (new ChessboardPoint(x, y), ChessColor.WHITE, 'n');
                    case "p" -> putChessOnBoard[x][y] = new PawnChessComponent
                            (new ChessboardPoint(x, y), ChessColor.WHITE, 'p');
                }

            }

        }
        chessComponents = putChessOnBoard;

        // Alter Player
        if (chessboard.get(8).equals("w")) {
            currentPlayer = ChessColor.WHITE;
        } else if (chessboard.get(8).equals("b")) {
            currentPlayer = ChessColor.BLACK;
        } else {
            currentPlayer = ChessColor.NONE;
        }

        // Added part, to pass the reference of the chessboard,
        // Could be used to refresh the attributes in each chess.
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                chessComponents[x][y].setChessComponents(chessComponents);
            }
        }

    }


    /**
     * Method to Implement: getCurrentPlayer
     *
     * @return currentPlayer
     */
    @Override
    public ChessColor getCurrentPlayer() {

        return this.currentPlayer;

    }


    /**
     * This method returns the concrete chess component from
     * private ChessComponent[][] chessComponents;
     * in (x, y) location.
     *
     * @param x the horizontal position
     * @param y the vertical position
     * @return chessComponents staying at the certain position
     */
    @Override
    public ChessComponent getChess(int x, int y) {

        return chessComponents[x][y];

    }


    /**
     * This method returns the chessboard status.
     * You should return an 8-rows String in the same format with input chessboard.
     * Use \n to separate 2 rows.
     *
     * @return Print the chessboard into a list of String.
     */
    @Override
    public String getChessboardGraph() {

        String[] lines = new String[8];

        for (int x = 0; x < 8; x++) {

            StringBuilder thisLine = new StringBuilder();

            for (int y = 0; y < 8; y++) {
                thisLine.append(chessComponents[x][y].name);
            }

            lines[x] = thisLine.toString();

        }

        String result = String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s",
                lines[0], lines[1], lines[2], lines[3], lines[4], lines[5], lines[6], lines[7]);

        return result;

    }


    /**
     * This method returns all the captured chess pieces.
     * Pieces should be sort by the order of
     * "King > Queen > Rooks > Bishops > Knights > Pawns"
     * <br>
     * At the beginning of a game,
     * the original count of those chess pieces of
     * King, Queen, Rooks, Bishops, Knights, Pawns are
     * 1, 1, 2, 2, 2, 8 respectively,
     * so that the captured cheeses are those whose have been lost from chessboard.
     *
     * @param player the player we are going to check
     * @return a list of the dead
     */
    @Override
    public String getCapturedChess(ChessColor player) {

        // Attributes
        String result;
        StringBuilder resultBlack = new StringBuilder();
        StringBuilder resultWhite = new StringBuilder();
        // Null
        int _Count = 0;
        // Black
        int KCount = 0;
        int QCount = 0;
        int RCount = 0;
        int BCount = 0;
        int NCount = 0;
        int PCount = 0;
        // White
        int kCount = 0;
        int qCount = 0;
        int rCount = 0;
        int bCount = 0;
        int nCount = 0;
        int pCount = 0;
        // Captured
        // Black
        int K;
        int Q;
        int R;
        int B;
        int N;
        int P;
        // White
        int k;
        int q;
        int r;
        int b;
        int n;
        int p;

        // Operation
        // Counting
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {

                // Null
                if (getChess(x, y).name == '_') {
                    _Count += 1;
                }
                // Black
                else if (getChess(x, y).name == 'K') {
                    KCount += 1;
                } else if (getChess(x, y).name == 'Q') {
                    QCount += 1;
                } else if (getChess(x, y).name == 'R') {
                    RCount += 1;
                } else if (getChess(x, y).name == 'B') {
                    BCount += 1;
                } else if (getChess(x, y).name == 'N') {
                    NCount += 1;
                } else if (getChess(x, y).name == 'P') {
                    PCount += 1;
                }
                // White
                else if (getChess(x, y).name == 'k') {
                    kCount += 1;
                } else if (getChess(x, y).name == 'q') {
                    qCount += 1;
                } else if (getChess(x, y).name == 'r') {
                    rCount += 1;
                } else if (getChess(x, y).name == 'b') {
                    bCount += 1;
                } else if (getChess(x, y).name == 'n') {
                    nCount += 1;
                } else if (getChess(x, y).name == 'p') {
                    pCount += 1;
                }

            }
        }

        // Calculate captured chess pieces
        // Black
        K = 1 - KCount;
        Q = 1 - QCount;
        R = 2 - RCount;
        B = 2 - BCount;
        N = 2 - NCount;
        P = 8 - PCount;
        // White
        k = 1 - kCount;
        q = 1 - qCount;
        r = 2 - rCount;
        b = 2 - bCount;
        n = 2 - nCount;
        p = 8 - pCount;

        // Build your String
        // Black
        if (K != 0) {
            resultBlack.append("K ").append(K).append("\n");
        }
        if (Q != 0) {
            resultBlack.append("Q ").append(Q).append("\n");
        }
        if (R != 0) {
            resultBlack.append("R ").append(R).append("\n");
        }
        if (B != 0) {
            resultBlack.append("B ").append(B).append("\n");
        }
        if (N != 0) {
            resultBlack.append("N ").append(N).append("\n");
        }
        if (P != 0) {
            resultBlack.append("P ").append(P).append("\n");
        }

        // White
        if (k != 0) {
            resultWhite.append("k ").append(k).append("\n");
        }
        if (q != 0) {
            resultWhite.append("q ").append(q).append("\n");
        }
        if (r != 0) {
            resultWhite.append("r ").append(r).append("\n");
        }
        if (b != 0) {
            resultWhite.append("b ").append(b).append("\n");
        }
        if (n != 0) {
            resultWhite.append("n ").append(n).append("\n");
        }
        if (p != 0) {
            resultWhite.append("p ").append(p).append("\n");
        }

        // Alter result
        if (player.equals(ChessColor.BLACK)) {
            result = resultBlack.toString();
        } else if (player.equals(ChessColor.WHITE)) {
            result = resultWhite.toString();
        } else {
            result = "What to you mean?";
        }

        // Return
        return result;

    }


    /**
     * A Q4 method, using the theory of polymorphism
     *
     * @param sourceCoordinate Where are you from
     * @return Where can you go
     */
    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint sourceCoordinate) {

        // Attributes
        ChessComponent sourceChess = getChess(sourceCoordinate.getX(), sourceCoordinate.getY());
        List<ChessboardPoint> result = new ArrayList<>();

        // Operations
        // Get the list
        List<ChessboardPoint> canMovePoints = sourceChess.canMoveTo();
        // Sort the list
        if (canMovePoints == null) {
            result = new ArrayList<>();
        } else {

            for (int x = 0; x <= 7; x++) {
                for (int y = 0; y <= 7; y++) {
                    for (int index = 0; index < canMovePoints.size(); index++) {
                        if (canMovePoints.get(index).getX() == x &&
                                canMovePoints.get(index).getY() == y) {
                            result.add(canMovePoints.get(index));
                        }
                    }
                }
            }


        }

        // Return
        return result;

    }


    /**
     * A Q4 method, judge the movements and alter the chess
     *
     * @param sourceX from where
     * @param sourceY from where
     * @param targetX to where
     * @param targetY to where
     * @return whether you can go there
     */
    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {

        // Attributes
        ChessboardPoint sourceCoordinate = new ChessboardPoint(sourceX, sourceY);
        ChessboardPoint targetCoordinate = new ChessboardPoint(targetX, targetY);
        List<ChessboardPoint> availablePoints = getCanMovePoints(sourceCoordinate);
        boolean correctPlayer = false;
        boolean availability = false;
        boolean result;

        // Operations
        // Check out whether the movement is legal
        // Judge player
        if (currentPlayer.equals(getChess(sourceX, sourceY).getChessColor())) {
            correctPlayer = true;
        }
        // Judge availability
        for (int i = 0; i < availablePoints.size(); i++) {
            if (targetCoordinate.getX() == availablePoints.get(i).getX() &&
                    targetCoordinate.getY() == availablePoints.get(i).getY()) {
                availability = true;
                break;
            }
        }
        // Alter result
        result = correctPlayer && availability;

        // Alter Chessboard
        if (result) {
            // Change the location of two chesses
            getChess(sourceX, sourceY).setSource(targetCoordinate);
            getChess(targetX, targetY).setSource(sourceCoordinate);
            // Swap the reference of two cheeses in array "chessComponents"
            ChessComponent tempSource = chessComponents[sourceX][sourceY];
            ChessComponent tempTarget = chessComponents[targetX][targetY];
            chessComponents[sourceX][sourceY] = tempTarget;
            chessComponents[targetX][targetY] = tempSource;
            // Replace the original place to an empty slot
            chessComponents[sourceX][sourceY] = new EmptySlotComponent
                    (sourceCoordinate, ChessColor.NONE, '_');
            // Alter Player
            currentPlayer = currentPlayer == ChessColor.BLACK ? ChessColor.WHITE : ChessColor.BLACK;
        }

        // Added part, to pass the reference of the chessboard,
        // Could be used to refresh the attributes in each chess.
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                chessComponents[x][y].setChessComponents(chessComponents);
            }
        }

        // Return
        return result;

    }


}