import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame {

    // A 2-dimension array to store all the chess components
    // should be initialized in your construct method.
    // i.e. = new ChessComponent[8][8]
    private ChessComponent[][] chessComponents;

    // What's the current player's color, black or white?
    // should be initialized in your construct method.
    // by default, set the color to white.
    private ChessColor currentPlayer;

    // Constructor
    public ConcreteChessGame() {
        // initialize the chess components
        chessComponents = new ChessComponent[8][8];

        // set the current player to white
        currentPlayer = ChessColor.WHITE;
    }


        /* --------- ChessGame methods --------- */

    @Override
    public void loadChessGame(List<String> chessboard) {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessboardPoint point = new ChessboardPoint(i, j);

                if (chessboard.get(i).charAt(j) == 'K') {
                    chessComponents[i][j] = new KingChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    chessComponents[i][j].setSource(point);
                }
                if (chessboard.get(i).charAt(j) == 'k') {
                    chessComponents[i][j] = new KingChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    chessComponents[i][j].setSource(point);
                }
                if (chessboard.get(i).charAt(j) == 'Q') {
                    chessComponents[i][j] = new QueenChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    chessComponents[i][j].setSource(point);
                }
                if (chessboard.get(i).charAt(j) == 'q') {
                    chessComponents[i][j] = new QueenChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    chessComponents[i][j].setSource(point);
                }
                if (chessboard.get(i).charAt(j) == 'R') {
                    chessComponents[i][j] = new RookChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    chessComponents[i][j].setSource(point);
                }
                if (chessboard.get(i).charAt(j) == 'r') {
                    chessComponents[i][j] = new RookChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    chessComponents[i][j].setSource(point);
                }
                if (chessboard.get(i).charAt(j) == 'B') {
                    chessComponents[i][j] = new BishopChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    chessComponents[i][j].setSource(point);
                }
                if (chessboard.get(i).charAt(j) == 'b') {
                    chessComponents[i][j] = new BishopChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    chessComponents[i][j].setSource(point);
                }
                if (chessboard.get(i).charAt(j) == 'N') {
                    chessComponents[i][j] = new KnightChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    chessComponents[i][j].setSource(point);
                }
                if (chessboard.get(i).charAt(j) == 'n') {
                    chessComponents[i][j] = new KnightChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    chessComponents[i][j].setSource(point);
                }
                if (chessboard.get(i).charAt(j) == 'P') {
                    chessComponents[i][j] = new PawnChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    chessComponents[i][j].setSource(point);
                }
                if (chessboard.get(i).charAt(j) == 'p') {
                    chessComponents[i][j] = new PawnChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    chessComponents[i][j].setSource(point);
                }
                if (chessboard.get(i).charAt(j) == '_') {
                    chessComponents[i][j] = new EmptySlotComponent();
                    chessComponents[i][j].setChessColor(ChessColor.NONE);
                    chessComponents[i][j].setSource(point);
                }

                chessComponents[i][j].name = chessboard.get(i).charAt(j);
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
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                sb.append(chessComponents[i][j].name);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {

        int[] lostChess = new int[] {1, 1, 2, 2, 2, 8, 1, 1, 2, 2, 2, 8};
        char[] lostChessName = new char[] {'K', 'Q', 'R', 'B', 'N', 'P', 'k', 'q', 'r', 'b', 'n', 'p'};

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessComponents[i][j].name == 'K') {
                    lostChess[0]--;
                }
                if (chessComponents[i][j].name == 'Q') {
                    lostChess[1]--;
                }
                if (chessComponents[i][j].name == 'R') {
                    lostChess[2]--;
                }
                if (chessComponents[i][j].name == 'B') {
                    lostChess[3]--;
                }
                if (chessComponents[i][j].name == 'N') {
                    lostChess[4]--;
                }
                if (chessComponents[i][j].name == 'P') {
                    lostChess[5]--;
                }
                if (chessComponents[i][j].name == 'k') {
                    lostChess[6]--;
                }
                if (chessComponents[i][j].name == 'q') {
                    lostChess[7]--;
                }
                if (chessComponents[i][j].name == 'r') {
                    lostChess[8]--;
                }
                if (chessComponents[i][j].name == 'b') {
                    lostChess[9]--;
                }
                if (chessComponents[i][j].name == 'n') {
                    lostChess[10]--;
                }
                if (chessComponents[i][j].name == 'p') {
                    lostChess[11]--;
                }
            }
        }


        if (player == ChessColor.BLACK) {
            for (int i = 0; i < 6; i++) {
                if (lostChess[i] > 0) {
                    sb.append(lostChessName[i]);
                    sb.append(' ');
                    sb.append(lostChess[i]);
                    sb.append('\n');
                }
            }
        } else {
            for (int i = 6; i < 12; i++) {
                if (lostChess[i] > 0) {
                    sb.append(lostChessName[i]);
                    sb.append(' ');
                    sb.append(lostChess[i]);
                    sb.append("\n");
                }
            }
        }

        return sb.toString();
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        int x = source.getX();
        int y = source.getY();

        ChessComponent chessComponent = chessComponents[x][y];

        List<ChessboardPoint> canMovePoints;
        List<ChessboardPoint> finalCanMovePoints = new ArrayList<>();

        char specialName = chessComponent.name;

        if (chessComponent.name == 'K') {
            chessComponent = new KingChessComponent();
        }
        if (chessComponent.name == 'k') {
            chessComponent = new KingChessComponent();
        }
        if (chessComponent.name == 'Q') {
            chessComponent = new QueenChessComponent();
        }
        if (chessComponent.name == 'q') {
            chessComponent = new QueenChessComponent();
        }
        if (chessComponent.name == 'R') {
            chessComponent = new RookChessComponent();
        }
        if (chessComponent.name == 'r') {
            chessComponent = new RookChessComponent();
        }
        if (chessComponent.name == 'B') {
            chessComponent = new BishopChessComponent();
        }
        if (chessComponent.name == 'b') {
            chessComponent = new BishopChessComponent();
        }
        if (chessComponent.name == 'N') {
            chessComponent = new KnightChessComponent();
        }
        if (chessComponent.name == 'n') {
            chessComponent = new KnightChessComponent();
        }
        if (chessComponent.name == 'P') {
            chessComponent = new PawnChessComponent();
        }
        if (chessComponent.name == 'p') {
            chessComponent = new PawnChessComponent();
        }

        canMovePoints = chessComponent.canMoveTo();


        for (int i = 0; i < canMovePoints.size(); i++) {

            int x1 = canMovePoints.get(i).getX();
            int y1 = canMovePoints.get(i).getY();

            ChessboardPoint point = new ChessboardPoint(x1 + x, y1 + y);

            if (!isOutOfBound(point)) {
                if (chessComponents[point.getX()][point.getY()].name == '_' || chessComponents[point.getX()][point.getY()].getChessColor() != chessComponents[x][y].getChessColor()) {
                    finalCanMovePoints.add(point);
                }
            }

        }

            /* ----- if rook or queen or bishop ----- */

        // if rook
        if (specialName == 'R' || specialName == 'r') {
            List<ChessboardPoint> temp = new ArrayList<>(finalCanMovePoints);
            List<ChessboardPoint> temp2 = new ArrayList<>(finalCanMovePoints);

            finalCanMovePoints.clear();

            for (int i = 0; i < temp.size(); i++) {
                int x1 = temp.get(i).getX();
                int y1 = temp.get(i).getY();

                if (x == x1) {  // same x
                    int ti = Math.abs(y - y1);
                    boolean yMoreThanY1 = y > y1;

                    if (ti > 1) // more than 1
                    {
                        if (yMoreThanY1) {
                            for (int j = 1; j < ti; j++) {
                                boolean isContain = false;
                                for (int k = 0; k < temp.size(); k++) {
                                    if (temp.get(k).getX() == x1 && temp.get(k).getY() == y1 + j && chessComponents[temp.get(k).getX()][temp.get(k).getY()].name == '_') {
                                        isContain = true;
                                        break;
                                    }
                                }
                                if (!isContain) {
                                    temp2.set(i, new ChessboardPoint(9, 9));
                                    break;
                                }
                            }
                        } else {
                            for (int j = 1; j < ti; j++) {
                                boolean isContain = false;
                                for (int k = 0; k < temp.size(); k++) {
                                    if (temp.get(k).getX() == x1 && temp.get(k).getY() == y1 - j && chessComponents[temp.get(k).getX()][temp.get(k).getY()].name == '_') {
                                        isContain = true;
                                        break;
                                    }
                                }
                                if (!isContain) {
                                    temp2.set(i, new ChessboardPoint(9, 9));
                                    break;
                                }
                            }
                        }
                    }
                }
                else {        // same y
                    int ti = Math.abs(x - x1);
                    boolean xMoreThanX1 = x > x1;

                    if (ti > 1) // more than 1
                    {
                        if (xMoreThanX1) {
                            for (int j = 1; j < ti; j++) {
                                boolean isContain = false;
                                for (int k = 0; k < temp.size(); k++) {
                                    if (temp.get(k).getX() == x1 + j && temp.get(k).getY() == y1 && chessComponents[temp.get(k).getX()][temp.get(k).getY()].name == '_') {
                                        isContain = true;
                                        break;
                                    }
                                }
                                if (!isContain) {
                                    temp2.set(i, new ChessboardPoint(9, 9));
                                    break;
                                }
                            }
                        } else {
                            for (int j = 1; j < ti; j++) {
                                boolean isContain = false;
                                for (int k = 0; k < temp.size(); k++) {
                                    if (temp.get(k).getX() == x1 - j && temp.get(k).getY() == y1 && chessComponents[temp.get(k).getX()][temp.get(k).getY()].name == '_') {
                                        isContain = true;
                                        break;
                                    }
                                }
                                if (!isContain) {
                                    temp2.set(i, new ChessboardPoint(9, 9));
                                    break;
                                }
                            }
                        }
                    }
                }

            } // end for in temp all

            for (int i = 0; i < temp2.size(); i++) {
                if (temp2.get(i).getX() != 9 && temp2.get(i).getY() != 9) {
                    finalCanMovePoints.add(temp2.get(i));
                }
            }

        } // if rook

        // if bishop
        if (specialName == 'B' || specialName == 'b') {
            List<ChessboardPoint> temp = new ArrayList<>(finalCanMovePoints);
            List<ChessboardPoint> temp2 = new ArrayList<>(finalCanMovePoints);

            finalCanMovePoints.clear();

            for (int i = 0; i < temp.size(); i++) {
                int x1 = temp.get(i).getX();
                int y1 = temp.get(i).getY();

                if (x - x1 == y1 - y) {  // same x and y
                    int ti = Math.abs(y - y1);
                    boolean yMoreThanY1 = y > y1;

                    if (ti > 1) // more than 1
                    {
                        if (yMoreThanY1) {
                            for (int j = 1; j < ti; j++) {
                                boolean isContain = false;
                                for (int k = 0; k < temp.size(); k++) {
                                    if (temp.get(k).getX() == (x1 - j) && temp.get(k).getY() == (y1 + j) && chessComponents[temp.get(k).getX()][temp.get(k).getY()].name == '_') {
                                        isContain = true;
                                        break;
                                    }
                                }
                                if (!isContain) {
                                    temp2.set(i, new ChessboardPoint(9, 9));
                                    break;
                                }
                            }
                        } else {
                            for (int j = 1; j < ti; j++) {
                                boolean isContain = false;
                                for (int k = 0; k < temp.size(); k++) {
                                    if (temp.get(k).getX() == x1 + j && temp.get(k).getY() == y1 - j && chessComponents[temp.get(k).getX()][temp.get(k).getY()].name == '_') {
                                        isContain = true;
                                        break;
                                    }
                                }
                                if (!isContain) {
                                    temp2.set(i, new ChessboardPoint(9, 9));
                                    break;
                                }
                            }
                        }
                    }
                }
                else {        // same y
                    int ti = Math.abs(x - x1);
                    boolean xMoreThanX1 = x > x1;

                    if (ti > 1) // more than 1
                    {
                        if (xMoreThanX1) {
                            for (int j = 1; j < ti; j++) {
                                boolean isContain = false;
                                for (int k = 0; k < temp.size(); k++) {
                                    if (temp.get(k).getX() == x1 + j && temp.get(k).getY() == y1 + j && chessComponents[temp.get(k).getX()][temp.get(k).getY()].name == '_') {
                                        isContain = true;
                                        break;
                                    }
                                }
                                if (!isContain) {
                                    temp2.set(i, new ChessboardPoint(9, 9));
                                    break;
                                }
                            }
                        } else {
                            for (int j = 1; j < ti; j++) {
                                boolean isContain = false;
                                for (int k = 0; k < temp.size(); k++) {
                                    if (temp.get(k).getX() == x1 - j && temp.get(k).getY() == y1 - j && chessComponents[temp.get(k).getX()][temp.get(k).getY()].name == '_') {
                                        isContain = true;
                                        break;
                                    }
                                }
                                if (!isContain) {
                                    temp2.set(i, new ChessboardPoint(9, 9));
                                    break;
                                }
                            }
                        }
                    }
                }

            } // end for in temp all

            for (int i = 0; i < temp2.size(); i++) {
                if (temp2.get(i).getX() != 9) {
                    finalCanMovePoints.add(temp2.get(i));
                }
            }

        } // if bishop

        // if queen
        if (specialName == 'Q' || specialName == 'q') {
            List<ChessboardPoint> temp = new ArrayList<>(finalCanMovePoints);
            List<ChessboardPoint> temp2 = new ArrayList<>(finalCanMovePoints);

            finalCanMovePoints.clear();

            for (int i = 0; i < temp.size(); i++) {
                int x1 = temp.get(i).getX();
                int y1 = temp.get(i).getY();

                if (x == x1) {  // same x
                    int ti = Math.abs(y - y1);
                    boolean yMoreThanY1 = y > y1;

                    if (ti > 1) // more than 1
                    {
                        if (yMoreThanY1) {
                            for (int j = 1; j < ti; j++) {
                                boolean isContain = false;
                                for (int k = 0; k < temp.size(); k++) {
                                    if (temp.get(k).getX() == x1 && temp.get(k).getY() == y1 + j && chessComponents[temp.get(k).getX()][temp.get(k).getY()].name == '_') {
                                        isContain = true;
                                        break;
                                    }
                                }
                                if (!isContain) {
                                    temp2.set(i, new ChessboardPoint(9, 9));
                                    break;
                                }
                            }
                        } else {
                            for (int j = 1; j < ti; j++) {
                                boolean isContain = false;
                                for (int k = 0; k < temp.size(); k++) {
                                    if (temp.get(k).getX() == x1 && temp.get(k).getY() == y1 - j && chessComponents[temp.get(k).getX()][temp.get(k).getY()].name == '_') {
                                        isContain = true;
                                        break;
                                    }
                                }
                                if (!isContain) {
                                    temp2.set(i, new ChessboardPoint(9, 9));
                                    break;
                                }
                            }
                        }
                    }
                }
                else if (y == y1) {        // same y
                    int ti = Math.abs(x - x1);
                    boolean xMoreThanX1 = x > x1;

                    if (ti > 1) // more than 1
                    {
                        if (xMoreThanX1) {
                            for (int j = 1; j < ti; j++) {
                                boolean isContain = false;
                                for (int k = 0; k < temp.size(); k++) {
                                    if (temp.get(k).getX() == x1 + j && temp.get(k).getY() == y1 && chessComponents[temp.get(k).getX()][temp.get(k).getY()].name == '_') {
                                        isContain = true;
                                        break;
                                    }
                                }
                                if (!isContain) {
                                    temp2.set(i, new ChessboardPoint(9, 9));
                                    break;
                                }
                            }
                        } else {
                            for (int j = 1; j < ti; j++) {
                                boolean isContain = false;
                                for (int k = 0; k < temp.size(); k++) {
                                    if (temp.get(k).getX() == x1 - j && temp.get(k).getY() == y1 && chessComponents[temp.get(k).getX()][temp.get(k).getY()].name == '_') {
                                        isContain = true;
                                        break;
                                    }
                                }
                                if (!isContain) {
                                    temp2.set(i, new ChessboardPoint(9, 9));
                                    break;
                                }
                            }
                        }
                    }
                }
                else if (x - x1 == y1 - y) {  // same x and y
                    int ti = Math.abs(y - y1);
                    boolean yMoreThanY1 = y > y1;

                    if (ti > 1) // more than 1
                    {
                        if (yMoreThanY1) {
                            for (int j = 1; j < ti; j++) {
                                boolean isContain = false;
                                for (int k = 0; k < temp.size(); k++) {
                                    if (temp.get(k).getX() == (x1 - j) && temp.get(k).getY() == (y1 + j) && chessComponents[temp.get(k).getX()][temp.get(k).getY()].name == '_') {
                                        isContain = true;
                                        break;
                                    }
                                }
                                if (!isContain) {
                                    temp2.set(i, new ChessboardPoint(9, 9));
                                    break;
                                }
                            }
                        } else {
                            for (int j = 1; j < ti; j++) {
                                boolean isContain = false;
                                for (int k = 0; k < temp.size(); k++) {
                                    if (temp.get(k).getX() == x1 + j && temp.get(k).getY() == y1 - j && chessComponents[temp.get(k).getX()][temp.get(k).getY()].name == '_') {
                                        isContain = true;
                                        break;
                                    }
                                }
                                if (!isContain) {
                                    temp2.set(i, new ChessboardPoint(9, 9));
                                    break;
                                }
                            }
                        }
                    }
                }
                else {        // same y
                    int ti = Math.abs(x - x1);
                    boolean xMoreThanX1 = x > x1;

                    if (ti > 1) // more than 1
                    {
                        if (xMoreThanX1) {
                            for (int j = 1; j < ti; j++) {
                                boolean isContain = false;
                                for (int k = 0; k < temp.size(); k++) {
                                    if (temp.get(k).getX() == x1 + j && temp.get(k).getY() == y1 + j && chessComponents[temp.get(k).getX()][temp.get(k).getY()].name == '_') {
                                        isContain = true;
                                        break;
                                    }
                                }
                                if (!isContain) {
                                    temp2.set(i, new ChessboardPoint(9, 9));
                                    break;
                                }
                            }
                        } else {
                            for (int j = 1; j < ti; j++) {
                                boolean isContain = false;
                                for (int k = 0; k < temp.size(); k++) {
                                    if (temp.get(k).getX() == x1 - j && temp.get(k).getY() == y1 - j && chessComponents[temp.get(k).getX()][temp.get(k).getY()].name == '_') {
                                        isContain = true;
                                        break;
                                    }
                                }
                                if (!isContain) {
                                    temp2.set(i, new ChessboardPoint(9, 9));
                                    break;
                                }
                            }
                        }
                    }
                }
            } // end for in temp all

            for (int i = 0; i < temp2.size(); i++) {
                if (temp2.get(i).getX() != 9 && temp2.get(i).getY() != 9) {
                    finalCanMovePoints.add(temp2.get(i));
                }
            }

        } // if queen

            /* ----- if pawn ----- */

        // if pawn
        if (specialName == 'P' || specialName == 'p') {
            ArrayList<ChessboardPoint> temp = new ArrayList<>(finalCanMovePoints);
            ArrayList<ChessboardPoint> temp2 = new ArrayList<>(finalCanMovePoints);

            finalCanMovePoints.clear();

            if (specialName == 'P') { // Black
                // delete the opposite point
                for (int i = 0; i < temp.size(); i++) {
                    int x1 = temp.get(i).getX();
                    if (x1 < x) {
                        temp2.set(i, new ChessboardPoint(9, 9));
                    }
                }

                // whether pawn can move two steps or not
                if (x == 1) {
                    if (chessComponents[x + 1][y].name != '_' || chessComponents[x + 2][y].name != '_') {
                        for (int i = 0; i < temp.size(); i++) {
                            int x1 = temp.get(i).getX();
                            if (x1 == x + 2) {
                                temp2.set(i, new ChessboardPoint(9, 9));
                            }
                        }
                    }
                } else {
                    for (int i = 0; i < temp.size(); i++) {
                        int x1 = temp.get(i).getX();
                        if (x1 == x + 2) {
                            temp2.set(i, new ChessboardPoint(9, 9));
                        }
                    }
                }

                // whether pawn can move one step or not
                if (chessComponents[x + 1][y].name != '_') {
                    for (int i = 0; i < temp.size(); i++) {
                        int x1 = temp.get(i).getX();
                        if (x1 == x - 1) {
                            temp2.set(i, new ChessboardPoint(9, 9));
                        }
                    }
                }

                // whether pawn can eat or not
                if (chessComponents[x + 1][y - 1].name >= 'A' && chessComponents[x + 1][y - 1].name <= 'Z' || chessComponents[x + 1][y - 1].name == '_') {
                    for (int i = 0; i < temp.size(); i++) {
                        int x1 = temp.get(i).getX();
                        int y1 = temp.get(i).getY();

                        if (x1 == x + 1 && y1 == y - 1) {
                            temp2.set(i, new ChessboardPoint(9, 9));
                        }
                    }
                }
                if (chessComponents[x + 1][y + 1].name >= 'A' && chessComponents[x + 1][y + 1].name <= 'Z' || chessComponents[x + 1][y + 1].name == '_') {
                    for (int i = 0; i < temp.size(); i++) {
                        int x1 = temp.get(i).getX();
                        int y1 = temp.get(i).getY();

                        if (x1 == x + 1 && y1 == y + 1) {
                            temp2.set(i, new ChessboardPoint(9, 9));
                        }
                    }
                }
            } else { // White
                // delete the opposite point
                for (int i = 0; i < temp.size(); i++) {
                    int x1 = temp.get(i).getX();
                    if (x1 > x) {
                        temp2.set(i, new ChessboardPoint(9, 9));
                    }
                }

                // whether pawn can move two steps or not
                if (x == 6) {
                    if (chessComponents[x - 1][y].name != '_' || chessComponents[x - 2][y].name != '_') {
                        for (int i = 0; i < temp.size(); i++) {
                            int x1 = temp.get(i).getX();
                            if (x1 == x - 2) {
                                temp2.set(i, new ChessboardPoint(9, 9));
                            }
                        }
                    }
                } else {
                    for (int i = 0; i < temp.size(); i++) {
                        int x1 = temp.get(i).getX();
                        if (x1 == x - 2) {
                            temp2.set(i, new ChessboardPoint(9, 9));
                        }
                    }
                }

                // whether pawn can move one step or not
                if (chessComponents[x - 1][y].name != '_') {
                    for (int i = 0; i < temp.size(); i++) {
                        int x1 = temp.get(i).getX();
                        if (x1 == x - 1) {
                            temp2.set(i, new ChessboardPoint(9, 9));
                        }
                    }
                }

                // whether pawn can eat or not
                if (chessComponents[x - 1][y - 1].name >= 'a' && chessComponents[x - 1][y - 1].name <= 'z' || chessComponents[x - 1][y - 1].name == '_') {
                    for (int i = 0; i < temp.size(); i++) {
                        int x1 = temp.get(i).getX();
                        int y1 = temp.get(i).getY();

                        if (x1 == x - 1 && y1 == y - 1) {
                            temp2.set(i, new ChessboardPoint(9, 9));
                        }
                    }
                }
                if (chessComponents[x - 1][y + 1].name >= 'a' && chessComponents[x - 1][y + 1].name <= 'z' || chessComponents[x - 1][y + 1].name == '_') {
                    for (int i = 0; i < temp.size(); i++) {
                        int x1 = temp.get(i).getX();
                        int y1 = temp.get(i).getY();

                        if (x1 == x - 1 && y1 == y + 1) {
                            temp2.set(i, new ChessboardPoint(9, 9));
                        }
                    }
                }
            }

            for (int i = 0; i < temp2.size(); i++) {
                if (temp2.get(i).getX() != 9 && temp2.get(i).getY() != 9) {
                    finalCanMovePoints.add(temp2.get(i));
                }
            }
        } // if pawn

        return finalCanMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessboardPoint source = new ChessboardPoint(sourceX, sourceY);
        ChessboardPoint target = new ChessboardPoint(targetX, targetY);
        char sourceName = chessComponents[sourceX][sourceY].name;
        ChessColor sourceColor = chessComponents[sourceX][sourceY].getChessColor();

        List<ChessboardPoint> canMovePoints = getCanMovePoints(source);

        if (sourceName >= 'a' && sourceName <= 'z') {
            if (currentPlayer == ChessColor.BLACK) {
                return false;
            }
        } else {
            if (currentPlayer == ChessColor.WHITE) {
                return false;
            }
        }

        for (int i = 0; i < canMovePoints.size(); i++) {
            if (canMovePoints.get(i).getX() == target.getX() && canMovePoints.get(i).getY() == target.getY()) {
                chessComponents[sourceX][sourceY].name = '_';
                chessComponents[sourceX][sourceY].setChessColor(ChessColor.NONE);

                chessComponents[targetX][targetY].name = sourceName;
                chessComponents[targetX][targetY].setChessColor(sourceColor);

                currentPlayer = currentPlayer == ChessColor.BLACK ? ChessColor.WHITE : ChessColor.BLACK;
                return true;
            }
        }

        return false;
    }

    private boolean isOutOfBound(ChessboardPoint point) {
        int x = point.getX();
        int y = point.getY();
        return x < 0 || x > 7 || y < 0 || y > 7;
    }

}