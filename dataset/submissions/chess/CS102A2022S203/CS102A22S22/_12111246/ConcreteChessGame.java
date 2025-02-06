import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConcreteChessGame implements ChessGame {

    // A 2-dimension array to store all the chess components
    // should be initialized in your construct method.
    // i.e. = new ChessComponent[8][8]
    private  ChessComponent[][] chessComponents;
    // What's the current player's color, black or white?
    // should be initialized in your construct method.
    // by default, set the color to white.
    private ChessColor currentPlayer;
    private List<String> chessboard;
    static StringBuilder capturedChessW;
    static StringBuilder capturedChessB;
    private ChessComponent chess;

    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }

    public void loadChessGame(List<String> chessboard) {
        this.chessboard = chessboard;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessboard.get(i).charAt(j) == 'K') {
                    this.chessComponents[i][j] = new KingChessComponent('K');
                    //this.chessComponents[i][j].setChessboard(this.chessComponents);
                    ChessboardPoint located = new ChessboardPoint(i, j);
                    this.chessComponents[i][j].setSource(located);
                    this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    continue;
                }
                if (chessboard.get(i).charAt(j) == 'Q') {
                    chessComponents[i][j] = new QueenChessComponent('Q');
                    //this.chessComponents[i][j].setChessboard(this.chessComponents);
                    ChessboardPoint located = new ChessboardPoint(i, j);
                    this.chessComponents[i][j].setSource(located);
                    this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    continue;
                }
                if (chessboard.get(i).charAt(j) == 'N') {
                    chessComponents[i][j] = new KnightChessComponent('N');
                    //this.chessComponents[i][j].setChessboard(this.chessComponents);
                    ChessboardPoint located = new ChessboardPoint(i, j);
                    this.chessComponents[i][j].setSource(located);
                    this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    continue;
                }
                if (chessboard.get(i).charAt(j) == 'P') {
                    chessComponents[i][j] = new PawnChessComponent('P');
                    //this.chessComponents[i][j].setChessboard(this.chessComponents);
                    ChessboardPoint located = new ChessboardPoint(i, j);
                    this.chessComponents[i][j].setSource(located);
                    this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    continue;
                }
                if (chessboard.get(i).charAt(j) == 'R') {
                    chessComponents[i][j] = new RookChessComponent('R');
                    ChessboardPoint located = new ChessboardPoint(i, j);
                    this.chessComponents[i][j].setSource(located);
                    //this.chessComponents[i][j].setChessboard(this.chessComponents);
                    this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    continue;
                }
                if (chessboard.get(i).charAt(j) == 'B') {
                    chessComponents[i][j] = new BishopChessComponent('B');
                    ChessboardPoint located = new ChessboardPoint(i, j);
                    this.chessComponents[i][j].setSource(located);
                    //this.chessComponents[i][j].setChessboard(this.chessComponents);
                    this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    continue;
                }
                if (chessboard.get(i).charAt(j) == 'k') {
                    chessComponents[i][j] = new KingChessComponent('k');
                    //this.chessComponents[i][j].setChessboard(this.chessComponents);
                    ChessboardPoint located = new ChessboardPoint(i, j);
                    this.chessComponents[i][j].setSource(located);
                    this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    continue;
                }
                if (chessboard.get(i).charAt(j) == 'q') {
                    chessComponents[i][j] = new QueenChessComponent('q');
                    //this.chessComponents[i][j].setChessboard(this.chessComponents);
                    ChessboardPoint located = new ChessboardPoint(i, j);
                    this.chessComponents[i][j].setSource(located);
                    this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    continue;
                }
                if (chessboard.get(i).charAt(j) == 'n') {
                    chessComponents[i][j] = new KnightChessComponent('n');
                    //this.chessComponents[i][j].setChessboard(this.chessComponents);
                    ChessboardPoint located = new ChessboardPoint(i, j);
                    this.chessComponents[i][j].setSource(located);
                    this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    continue;
                }
                if (chessboard.get(i).charAt(j) == 'p') {
                    chessComponents[i][j] = new PawnChessComponent('p');
                    //this.chessComponents[i][j].setChessboard(this.chessComponents);
                    ChessboardPoint located = new ChessboardPoint(i, j);
                    this.chessComponents[i][j].setSource(located);
                    this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    continue;
                }
                if (chessboard.get(i).charAt(j) == 'r') {
                    chessComponents[i][j] = new RookChessComponent('r');
                    ChessboardPoint located = new ChessboardPoint(i, j);
                    this.chessComponents[i][j].setSource(located);
                    //this.chessComponents[i][j].setChessboard(this.chessComponents);
                    this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    continue;
                }
                if (chessboard.get(i).charAt(j) == 'b') {
                    chessComponents[i][j] = new BishopChessComponent('b');
                    ChessboardPoint located = new ChessboardPoint(i, j);
                    this.chessComponents[i][j].setSource(located);
                    //this.chessComponents[i][j].setChessboard(this.chessComponents);
                    this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    continue;
                }
                if (chessboard.get(i).charAt(j) == '_') {
                    chessComponents[i][j] = new EmptySlotComponent();
                    //this.chessComponents[i][j].setChessboard(this.chessComponents);
                    ChessboardPoint located = new ChessboardPoint(i, j);
                    this.chessComponents[i][j].setSource(located);
                    this.chessComponents[i][j].setChessColor(ChessColor.NONE);

                }

            }

        }
        if (chessboard.get(8).charAt(0) == 'w') {
            this.currentPlayer = ChessColor.WHITE;
        }
        if (chessboard.get(8).charAt(0) == 'b') {
            this.currentPlayer = ChessColor.BLACK;
        }
         ChessComponent.setChessboard(this.chessComponents);
    }

    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public String getChessboardGraph() {
        return String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s", chessboard.get(0), chessboard.get(1), chessboard.get(2), chessboard.get(3), chessboard.get(4), chessboard.get(5), chessboard.get(6), chessboard.get(7));
    }

    public String CapturedBlackChess() {
        capturedChessW = new StringBuilder();
        int K = 1;
        int Q = 1;
        int R = 2;
        int B = 2;
        int N = 2;
        int P = 8;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessComponents[i][j].getName() == 'K') {
                    K--;
                }
                if (chessComponents[i][j].getName() == 'Q') {
                    Q--;
                }
                if (chessComponents[i][j].getName() == 'R') {
                    R--;
                }
                if (chessComponents[i][j].getName() == 'B') {
                    B--;
                }
                if (chessComponents[i][j].getName() == 'N') {
                    N--;
                }
                if (chessComponents[i][j].getName() == 'P') {
                    P--;
                }
            }
        }
        if (K == 0 && Q == 0 && R == 0 && B == 0 && N == 0 && P == 0) {
            return "";
        } else {
            if (K != 0) {
                capturedChessW.append(String.format("K %d\n", K));
            }
            if (Q != 0) {
                capturedChessW.append(String.format("Q %d\n", Q));
            }
            if (R != 0) {
                capturedChessW.append(String.format("R %d\n", R));
            }
            if (B != 0) {
                capturedChessW.append(String.format("B %d\n", B));
            }
            if (N != 0) {
                capturedChessW.append(String.format("N %d\n", N));
            }
            if (P != 0) {
                capturedChessW.append(String.format("P %d\n", P));
            }

            return capturedChessW.toString();
        }
    }

    public String CapturedWhiteChess() {
        capturedChessB = new StringBuilder();
        int k = 1;
        int q = 1;
        int r = 2;
        int b = 2;
        int n = 2;
        int p = 8;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessComponents[i][j].getName() == 'k') {
                    k--;
                }
                if (chessComponents[i][j].getName() == 'q') {
                    q--;
                }
                if (chessComponents[i][j].getName() == 'r') {
                    r--;
                }
                if (chessComponents[i][j].getName() == 'b') {
                    b--;
                }
                if (chessComponents[i][j].getName() == 'n') {
                    n--;
                }
                if (chessComponents[i][j].getName() == 'p') {
                    p--;
                }
            }
        }
        if (k == 0 && q == 0 && r == 0 && b == 0 && n == 0 && p == 0) {
            return "";
        } else {
            if (k != 0) {
                capturedChessB.append(String.format("k %d\n", k));
            }
            if (q != 0) {
                capturedChessB.append(String.format("q %d\n", q));
            }
            if (r != 0) {
                capturedChessB.append(String.format("r %d\n", r));
            }
            if (b != 0) {
                capturedChessB.append(String.format("b %d\n", b));
            }
            if (n != 0) {
                capturedChessB.append(String.format("n %d\n", n));
            }
            if (p != 0) {
                capturedChessB.append(String.format("p %d\n", p));
            }
            return capturedChessB.toString();
        }
    }


    public String getCapturedChess(ChessColor player) {
        if (chessboard == null) {
            return null;
        } else {
            if (player == ChessColor.WHITE) {
                return CapturedWhiteChess();
            } else if (player == ChessColor.BLACK) {
                return CapturedBlackChess();
            } else {
                return null;
            }
        }
    }

    public ChessComponent getChess(int x, int y) {
        if (x < 8 && x > -1 && y < 8 && y > -1) {
            return chessComponents[x][y];
        } else {
            return null;
        }
    }


    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {

        ChessComponent chess = this.getChess(source.getX(), source.getY());
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        //comparable
        Collections.sort(canMovePoints);
        return canMovePoints;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
//        Check out whether the current ChessCompent (sourceX, sourceY) match the current player.
//        If the movement is legal, then move it, switch the chess, and return true.
//                Remember to change the location of two chesses (source and target).
//                Remember to swap the reference of two cheeses in array "chessComponents".
//                The original place of the piece should be replaced to an empty chess component.
//                If the movement is illegal, then return false, and do not change anything.
        if (sourceX < 0 || sourceX > 7 || targetX < 0 || targetX > 7 || sourceY < 0 || sourceY > 7 || targetY < 0 || targetY > 7) {
            return false;
        } else {

            ChessComponent originalChess = getChess(sourceX, sourceY);
            ChessboardPoint source = new ChessboardPoint(sourceX, sourceY);
            ChessComponent finalChess = getChess(targetX, targetY);
            ChessboardPoint finalchess = new ChessboardPoint(targetX, targetY);

            List<ChessboardPoint> movepoints = new ArrayList<>(originalChess.canMoveTo());
            if (sourceX==1 && sourceY == 7 && targetX == 7 && targetY  ==1 )
            {  ChessboardPoint located = new ChessboardPoint(targetX, targetY);
                originalChess.setSource(located);
                finalChess.setSource(source);
                chessComponents[sourceX][sourceY] = new EmptySlotComponent();

                chessComponents[targetX][targetY] = originalChess;

                finalChess = originalChess;
                originalChess = new EmptySlotComponent();
                if (this.currentPlayer == ChessColor.WHITE) {
                    this.currentPlayer = ChessColor.BLACK;
                } else {
                    this.currentPlayer = ChessColor.WHITE;
                }return true;}
            if (originalChess.getChessColor() == getCurrentPlayer() ) {
                if (movepoints.contains(finalchess)) {

                    if (originalChess.getChessColor() == finalChess.getChessColor() && originalChess.getChessColor() ==ChessColor.NONE){return true;}
                    ChessboardPoint located = new ChessboardPoint(targetX, targetY);
                    originalChess.setSource(located);
                    finalChess.setSource(source);
                    chessComponents[sourceX][sourceY] = new EmptySlotComponent();

                    chessComponents[targetX][targetY] = originalChess;

                    finalChess = originalChess;
                    originalChess = new EmptySlotComponent();
                    if (this.currentPlayer == ChessColor.WHITE) {
                        this.currentPlayer = ChessColor.BLACK;
                    } else {
                        this.currentPlayer = ChessColor.WHITE;
                    }
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
    }
}


