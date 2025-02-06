
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    // A 2-dimension array to store all the chess components
// should be initialized in your construct method.
// i.e. = new ChessComponent[8][8]
    private ChessComponent[][] chessComponents;


    //    private static ChessComponent[][] chessComponents ;
    // What's the current player's color, black or white?
// should be initialized in your construct method.
// by default, set the color to white.
    private ChessColor currentPlayer;


    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }


    public ConcreteChessGame(ChessComponent[][] chessComponents, ChessColor currentPlayer) {
        this.chessComponents = chessComponents;
        this.currentPlayer = currentPlayer;
    }

    public ConcreteChessGame() {
        chessComponents = new ChessComponent[8][8];
        currentPlayer = ChessColor.WHITE;
    }

    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                switch (chessboard.get(i).charAt(j)) {
                    case 'R':
                        chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'R', chessComponents);
                        break;
                    case 'N':
                        chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'N', chessComponents);
                        break;
                    case 'B':
                        chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'B', chessComponents);
                        break;
                    case 'Q':
                        chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'Q', chessComponents);
                        break;
                    case 'K':
                        chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'K', chessComponents);
                        break;
                    case 'P':
                        chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'P', chessComponents);
                        break;
                    case 'r':
                        chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'r', chessComponents);
                        break;
                    case 'n':
                        chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'n', chessComponents);
                        break;
                    case 'b':
                        chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'b', chessComponents);
                        break;
                    case 'q':
                        chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'q', chessComponents);
                        break;
                    case 'k':
                        chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'k', chessComponents);
                        break;
                    case 'p':
                        chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'p', chessComponents);
                        break;
                    default:
                        chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i, j), ChessColor.NONE, '_', chessComponents);
                        break;
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

    public String getChessboardGraph() {
        String[] chessBoard = new String[8];
        Arrays.fill(chessBoard, "");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessBoard[i] = chessBoard[i] + chessComponents[i][j].name;
            }
        }
        return String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s", chessBoard[0], chessBoard[1], chessBoard[2], chessBoard[3], chessBoard[4], chessBoard[5], chessBoard[6], chessBoard[7]);
    }

    public String getCapturedChess(ChessColor player) {
       
        int[] count = new int[6];
        StringBuilder buffer = new StringBuilder();
        if (player == ChessColor.WHITE) {
            //White
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (Character.isLowerCase(chessComponents[i][j].name)) {
                        switch (chessComponents[i][j].name) {
                            case 'k':
                                count[0]++;
                                break;
                            case 'q':
                                count[1]++;
                                break;
                            case 'r':
                                count[2]++;
                                break;
                            case 'b':
                                count[3]++;
                                break;
                            case 'n':
                                count[4]++;
                                break;
                            case 'p':
                                count[5]++;
                                break;
                        }
                    }
                }
            }
            if (count[0] == 0) {
                buffer.append("k 1\n");
            }
            if (count[1] == 0) {
                buffer.append("q 1\n");
            }
            if (count[2] < 2) {
                buffer.append("r " + (2 - count[2]) + "\n");
            }
            if (count[3] < 2) {
                buffer.append("b " + (2 - count[3]) + "\n");
            }
            if (count[4] < 2) {
                buffer.append("n " + (2 - count[4]) + "\n");
            }
            if (count[5] < 8) {
                buffer.append("p " + (8 - count[5]) + "\n");
            }

//Black
        } else {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (Character.isUpperCase(chessComponents[i][j].name)) {
                        switch (chessComponents[i][j].name) {
                            case 'K':
                                count[0]++;
                                break;
                            case 'Q':
                                count[1]++;
                                break;
                            case 'R':
                                count[2]++;
                                break;
                            case 'B':
                                count[3]++;
                                break;
                            case 'N':
                                count[4]++;
                                break;
                            case 'P':
                                count[5]++;
                                break;
                        }
                    }
                }
            }
            if (count[0] == 0) {
                buffer.append("K 1\n");
            }
            if (count[1] == 0) {
                buffer.append("Q 1\n");
            }
            if (count[2] < 2) {
                buffer.append("R " + (2 - count[2]) + "\n");
            }
            if (count[3] < 2) {
                buffer.append("B " + (2 - count[3]) + "\n");
            }
            if (count[4] < 2) {
                buffer.append("N " + (2 - count[4]) + "\n");
            }
            if (count[5] < 8) {
                buffer.append("P " + (8 - count[5]) + "\n");
            }
        }
        return buffer.toString();
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        return chessComponents[source.getX()][source.getY()].canMoveTo();
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (chessComponents[sourceX][sourceY].getChessColor() == currentPlayer) {
//            if (chessComponents[sourceX][sourceY].canMoveChess(sourceX, sourceY, targetX, targetY)) {
            for (ChessboardPoint Cbp : chessComponents[sourceX][sourceY].canMoveTo()) {
                if (Cbp.getX() == targetX && Cbp.getY() == targetY) {
                    char k;
                    char q;
                    char b;
                    char n;
                    char r;
                    char p;
                    if (chessComponents[sourceX][sourceY].chessColor == ChessColor.BLACK) {
                        k = 'K';
                        q = 'Q';
                        b = 'B';
                        n = 'N';
                        r = 'R';
                        p = 'P';
                    } else {
                        k = 'k';
                        q = 'q';
                        b = 'b';
                        n = 'n';
                        r = 'r';
                        p = 'p';
                    }
                    if (chessComponents[sourceX][sourceY] instanceof KingChessComponent)
                        chessComponents[targetX][targetY] = new KingChessComponent(new ChessboardPoint(targetX, targetY), chessComponents[sourceX][sourceY].getChessColor(), k, chessComponents);
                    else if (chessComponents[sourceX][sourceY] instanceof QueenChessComponent)
                        chessComponents[targetX][targetY] = new QueenChessComponent(new ChessboardPoint(targetX, targetY), chessComponents[sourceX][sourceY].getChessColor(), q, chessComponents);
                    else if (chessComponents[sourceX][sourceY] instanceof BishopChessComponent)
                        chessComponents[targetX][targetY] = new BishopChessComponent(new ChessboardPoint(targetX, targetY), chessComponents[sourceX][sourceY].getChessColor(), b, chessComponents);
                    else if (chessComponents[sourceX][sourceY] instanceof KnightChessComponent)
                        chessComponents[targetX][targetY] = new KnightChessComponent(new ChessboardPoint(targetX, targetY), chessComponents[sourceX][sourceY].getChessColor(), n, chessComponents);
                    else if (chessComponents[sourceX][sourceY] instanceof RookChessComponent)
                        chessComponents[targetX][targetY] = new  RookChessComponent(new ChessboardPoint(targetX, targetY), chessComponents[sourceX][sourceY].getChessColor(), r, chessComponents);
                    else if (chessComponents[sourceX][sourceY] instanceof PawnChessComponent)
                        chessComponents[targetX][targetY] = new PawnChessComponent(new ChessboardPoint(targetX, targetY), chessComponents[sourceX][sourceY].getChessColor(), p, chessComponents);
//                chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];

                    chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX, sourceY), ChessColor.NONE, '_', chessComponents);
                    if (this.currentPlayer == ChessColor.WHITE) {
                        this.currentPlayer = ChessColor.BLACK;
                    } else {
                        this.currentPlayer = ChessColor.WHITE;
                    }
                    return true;
                }
            }
        } else {
            return false;
        }
        return false;
    }
}
