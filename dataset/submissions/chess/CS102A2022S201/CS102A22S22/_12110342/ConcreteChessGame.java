import java.util.Comparator;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    // A 2-dimension array to store all the chess components
// should be initialized in your construct method.
// i.e. = new ChessComponent[8][8]
    private ChessComponent[][] chessComponents;
    // What's the current player's color, black or white?
// should be initialized in your construct method.
// by default, set the color to white.

    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.BLACK;
    }

    /***
     * RNBQKBNR
     * PPPPPPPP
     * ________
     * ________
     * ________
     * ________
     * pppppppp
     * rnbqkbnr
     * w
     */
    private ChessColor currentPlayer;

    public void loadChessGame(List<String> chessboard) {


        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {

                chessComponents[x][y] = exchange(chessboard.get(x).substring(y, y + 1), x, y);

            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessComponents[i][j].setChessComponents(chessComponents);
            }
        }

        if (chessboard.get(8).equals("w")) {
            currentPlayer = ChessColor.WHITE;
        } else {
            currentPlayer = ChessColor.BLACK;
        }

    }

    private ChessComponent exchange(String a, int x, int y) {
        ChessComponent result = null;

        ChessboardPoint point = new ChessboardPoint(x, y);

        //char name , ChessColor a, ChessboardPoint b
        if (a.equals("_")) result = new EmptySlotComponent(point, ChessColor.NONE, '_', chessComponents);
        if (a.equals("R")) result = new RookChessComponent(point, ChessColor.BLACK, 'R', chessComponents);
        if (a.equals("N")) result = new KnightChessComponent(point, ChessColor.BLACK, 'N', chessComponents);
        if (a.equals("B")) result = new BishopChessComponent(point, ChessColor.BLACK, 'B', chessComponents);
        if (a.equals("Q")) result = new QueenChessComponent(point, ChessColor.BLACK, 'Q', chessComponents);
        if (a.equals("K")) result = new KingChessComponent(point, ChessColor.BLACK, 'K', chessComponents);
        if (a.equals("P")) result = new PawnChessComponent(point, ChessColor.BLACK, 'P', chessComponents);

        if (a.equals("r")) result = new RookChessComponent(point, ChessColor.WHITE, 'r', chessComponents);
        if (a.equals("n")) result = new KnightChessComponent(point, ChessColor.WHITE, 'n', chessComponents);
        if (a.equals("b")) result = new BishopChessComponent(point, ChessColor.WHITE, 'b', chessComponents);
        if (a.equals("q")) result = new QueenChessComponent(point, ChessColor.WHITE, 'q', chessComponents);
        if (a.equals("k")) result = new KingChessComponent(point, ChessColor.WHITE, 'k', chessComponents);
        if (a.equals("p")) result = new PawnChessComponent(point, ChessColor.WHITE, 'p', chessComponents);

        return result;
    }

    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    public String getChessboardGraph() {
        StringBuilder a = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                a.append(chessComponents[i][j].getName());

            }
            a.append("\n");
        }

        return a.toString();
    }


    public String getCapturedChess(ChessColor player) {
        int numK = 1;
        int numQ = 1;
        int numB = 2;
        int numN = 2;
        int numR = 2;
        int numP = 8;
        int numk = 1;
        int numq = 1;
        int numb = 2;
        int numn = 2;
        int numr = 2;
        int nump = 8;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                switch (chessComponents[i][j].name) {
                    case 'K':
                        numK--;
                        break;
                    case 'Q':
                        numQ--;
                        break;
                    case 'B':
                        numB--;
                        break;
                    case 'N':
                        numN--;
                        break;
                    case 'R':
                        numR--;
                        break;
                    case 'P':
                        numP--;
                        break;
                    case 'k':
                        numk--;
                        break;
                    case 'q':
                        numq--;
                        break;
                    case 'b':
                        numb--;
                        break;
                    case 'n':
                        numn--;
                        break;
                    case 'r':
                        numr--;
                        break;
                    case 'p':
                        nump--;
                        break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        if (player.equals(ChessColor.BLACK)) {
            if (numK != 0) {
                sb.append("K ").append(numK).append("\n");
            }
            if (numQ != 0) {
                sb.append("Q ").append(numQ).append("\n");
            }
            if (numR != 0) {
                sb.append("R ").append(numR).append("\n");
            }
            if (numB != 0) {
                sb.append("B ").append(numB).append("\n");
            }
            if (numN != 0) {
                sb.append("N ").append(numN).append("\n");
            }
            if (numP != 0) {
                sb.append("P ").append(numP).append("\n");
            }
            if (sb.length() != 0) {
                sb.delete(sb.length() - 1, sb.length() - 1);
            }

            return sb.toString();
        }
        if (player.equals(ChessColor.WHITE)) {
            if (numK != 0) {
                sb.append("k ").append(numk).append("\n");
            }
            if (numq != 0) {
                sb.append("q ").append(numq).append("\n");
            }
            if (numr != 0) {
                sb.append("r ").append(numr).append("\n");
            }
            if (numb != 0) {
                sb.append("b ").append(numb).append("\n");
            }
            if (numn != 0) {
                sb.append("n ").append(numn).append("\n");
            }
            if (nump != 0) {
                sb.append("p ").append(nump).append("\n");
            }
            if (sb.length() != 0) {
                sb.delete(sb.length() - 1, sb.length() - 1);
            }
            return sb.toString();
        }
        return sb.toString();
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> a = chessComponents[source.getX()][source.getY()].canMoveTo();
        a.sort(new Comparator<ChessboardPoint>() {
            @Override
            public int compare(ChessboardPoint o1, ChessboardPoint o2) {
                int num = o1.getX() - o2.getX();
                int num2 = num == 0 ? o1.getY() - o2.getY() : num;
                return num2;
            }
        });

        return a;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (!currentPlayer.equals(chessComponents[sourceX][sourceY].getChessColor())) {
            return false;
        }
        if (chessComponents[sourceX][sourceY].canMoveTo().contains(new ChessboardPoint(targetX, targetY))) {
            chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
            chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX, targetY));
            chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX, sourceY), ChessColor.NONE, '_', chessComponents);
            if (currentPlayer.equals(ChessColor.BLACK)) {
                currentPlayer = ChessColor.WHITE;
            } else {
                currentPlayer = ChessColor.BLACK;
            }
            return true;
        }
        return false;
    }

}