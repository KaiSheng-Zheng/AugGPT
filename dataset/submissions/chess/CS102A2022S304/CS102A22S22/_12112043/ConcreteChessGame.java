import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;
    private ChessColor getChessColor;
    private int b = 0;
    private int k = 0;
    private int n = 0;
    private int p = 0;
    private int q = 0;
    private int r = 0;
    private int B = 0;
    private int K = 0;
    private int N = 0;
    private int P = 0;
    private int Q = 0;
    private int R = 0;

    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessboard.get(i).charAt(j) == '_') {
                    this.chessComponents[i][j] = new EmptySlotComponent();
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                    this.chessComponents[i][j].setChessColor(ChessColor.NONE);
                    this.chessComponents[i][j].setName('_');
                    this.chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                } else if (chessboard.get(i).charAt(j) == 'k') {
                    this.chessComponents[i][j] = new KingChessComponent();
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                    this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    this.chessComponents[i][j].setName('k');
                    this.chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                    k++;
                } else if (chessboard.get(i).charAt(j) == 'K') {
                    this.chessComponents[i][j] = new KingChessComponent();
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                    this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    this.chessComponents[i][j].setName('K');
                    this.chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                    K++;
                } else if (chessboard.get(i).charAt(j) == 'q') {
                    this.chessComponents[i][j] = new QueenChessComponent();
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                    this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    this.chessComponents[i][j].setName('q');
                    this.chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                    q++;
                } else if (chessboard.get(i).charAt(j) == 'Q') {
                    this.chessComponents[i][j] = new QueenChessComponent();
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                    this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    this.chessComponents[i][j].setName('Q');
                    this.chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                    Q++;
                } else if (chessboard.get(i).charAt(j) == 'n') {
                    this.chessComponents[i][j] = new KnightChessComponent();
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                    this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    this.chessComponents[i][j].setName('n');
                    this.chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                    n++;
                } else if (chessboard.get(i).charAt(j) == 'N') {
                    this.chessComponents[i][j] = new KnightChessComponent();
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                    this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    this.chessComponents[i][j].setName('N');
                    this.chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                    N++;
                } else if (chessboard.get(i).charAt(j) == 'p') {
                    this.chessComponents[i][j] = new PawnChessComponent();
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                    this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    this.chessComponents[i][j].setName('p');
                    this.chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                    p++;
                } else if (chessboard.get(i).charAt(j) == 'P') {
                    this.chessComponents[i][j] = new PawnChessComponent();
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                    this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    this.chessComponents[i][j].setName('P');
                    this.chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                    P++;
                } else if (chessboard.get(i).charAt(j) == 'r') {
                    this.chessComponents[i][j] = new RookChessComponent();
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                    this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    this.chessComponents[i][j].setName('r');
                    this.chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                    r++;
                } else if (chessboard.get(i).charAt(j) == 'R') {
                    this.chessComponents[i][j] = new RookChessComponent();
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                    this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    this.chessComponents[i][j].setName('R');
                    this.chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                    R++;
                } else if (chessboard.get(i).charAt(j) == 'b') {
                    this.chessComponents[i][j] = new BishopChessComponent();
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                    this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    this.chessComponents[i][j].setName('b');
                    this.chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                    b++;
                } else if (chessboard.get(i).charAt(j) == 'B') {
                    this.chessComponents[i][j] = new BishopChessComponent();
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                    this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    this.chessComponents[i][j].setName('B');
                    this.chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                    B++;
                }
            }
        }
        if (chessboard.get(8).charAt(0) == 'w') {
            this.currentPlayer = ChessColor.WHITE;
        } else if (chessboard.get(8).charAt(0) == 'b') {
            this.currentPlayer = ChessColor.BLACK;
        } else {
            this.currentPlayer = ChessColor.NONE;
        }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public String getChessboardGraph() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                s.append(this.chessComponents[i][j].toString());
            }
            s.append("\n");
        }
        return s.substring(0);
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        b = 0;
        k = 0;
        n = 0;
        p = 0;
        q = 0;
        r = 0;
        B = 0;
        K = 0;
        N = 0;
        P = 0;
        Q = 0;
        R = 0;
        StringBuilder s2 = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessComponents[i][j].getName() == 'b') {
                    b++;
                }
                if (chessComponents[i][j].getName() == 'B') {
                    B++;
                }
                if (chessComponents[i][j].getName() == 'k') {
                    k++;
                }
                if (chessComponents[i][j].getName() == 'K') {
                    K++;
                }
                if (chessComponents[i][j].getName() == 'N') {
                    N++;
                }
                if (chessComponents[i][j].getName() == 'n') {
                    n++;
                }
                if (chessComponents[i][j].getName() == 'p') {
                    p++;
                }
                if (chessComponents[i][j].getName() == 'P') {
                    P++;
                }
                if (chessComponents[i][j].getName() == 'q') {
                    q++;
                }
                if (chessComponents[i][j].getName() == 'Q') {
                    Q++;
                }
                if (chessComponents[i][j].getName() == 'r') {
                    r++;
                }
                if (chessComponents[i][j].getName() == 'R') {
                    R++;
                }
            }
        }
            if (player == ChessColor.WHITE) {
                if (k != 1) {
                    s2.append("k 1");
                }
                if (q != 1) {
                    s2.append("\nq 1");
                }
                if (r != 2) {
                    s2.append("\nr ");
                    s2.append(2 - r);
                }
                if (b != 2) {
                    s2.append("\nb ");
                    s2.append(2 - b);
                }
                if (n != 2) {
                    s2.append("\nn ");
                    s2.append(2 - n);
                }
                if (p != 8) {
                    s2.append("\np ");
                    s2.append(8 - p);
                }
            }
            if (player == ChessColor.BLACK) {
                if (K != 1) {
                    s2.append("K 1\n");
                }
                if (Q != 1) {
                    s2.append("Q 1");
                }
                if (R != 2) {
                    s2.append("\nR ");
                    s2.append(2 - R);
                }
                if (B != 2) {
                    s2.append("\nB ");
                    s2.append(2 - B);
                }
                if (N != 2) {
                    s2.append("\nN ");
                    s2.append(2 - N);
                }
                if (P != 8) {
                    s2.append("\nP ");
                    s2.append(8 - P);
                }
            }
            return s2.substring(0);
        }

    @Override
    public ChessComponent getChess(int x, int y) {
        return this.chessComponents[x][y];
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        boolean move = true;
        if (chessComponents[sourceX][sourceY].getChessColor() == currentPlayer) {
            for (int i = 0; i < chessComponents[sourceX][sourceY].canMoveTo().size(); i++){
                move = true;
                if (chessComponents[sourceX][sourceY].canMoveTo().get(i).getX() == targetX && chessComponents[sourceX][sourceY].canMoveTo().get(i).getY() == targetY) {
                    chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                    chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX, targetY));
                    chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                    chessComponents[sourceX][sourceY].setSource(new ChessboardPoint(sourceX, sourceY));
                    chessComponents[sourceX][sourceY].setName('_');
                    chessComponents[sourceX][sourceY].setChessColor(ChessColor.NONE);
                    this.chessComponents[sourceX][sourceY].setChessboard(this.chessComponents);
                    this.chessComponents[targetX][targetY].setChessboard(this.chessComponents);
                    if(currentPlayer == ChessColor.BLACK){
                        currentPlayer = ChessColor.WHITE;
                    }else if (currentPlayer==ChessColor.WHITE){
                        currentPlayer = ChessColor.BLACK;
                    }

                } else {
                    move = false;
                }
            }
            if (sourceX==targetX&&sourceY==targetY){
                move=true;
            }
        }else {move = false;}
        return move;
    }


    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess = this.getChess(source.getX(), source.getY());
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        for (int i = 0; i < canMovePoints.size(); i++) {
            for (int j = 0; j < canMovePoints.size()-i-1; j++) {
                if (canMovePoints.get(j).getX()>canMovePoints.get(j+1).getX()){
                    ChessboardPoint p1 = canMovePoints.get(j);
                    ChessboardPoint p2 = canMovePoints.get(j+1);
                    canMovePoints.set(j,p2);
                    canMovePoints.set(j+1,p1);
                }else if (canMovePoints.get(j).getX() ==canMovePoints.get(j+1).getX()){
                   if (canMovePoints.get(j).getY() >canMovePoints.get(j+1).getY()){
                       ChessboardPoint p1 = canMovePoints.get(j);
                       ChessboardPoint p2 = canMovePoints.get(j+1);
                       canMovePoints.set(j,p2);
                       canMovePoints.set(j+1,p1);
                   }else {
                       ChessboardPoint p1 = canMovePoints.get(j);
                       ChessboardPoint p2 = canMovePoints.get(j+1);
                       canMovePoints.set(j,p1);
                       canMovePoints.set(j+1,p2);
                   }
                }else if (canMovePoints.get(j).getX() < canMovePoints.get(j+1).getX()){
                    ChessboardPoint p1 = canMovePoints.get(j);
                    ChessboardPoint p2 = canMovePoints.get(j+1);
                    canMovePoints.set(j,p1);
                    canMovePoints.set(j+1,p2);
            }
        }
        }
        return canMovePoints;
    }
}