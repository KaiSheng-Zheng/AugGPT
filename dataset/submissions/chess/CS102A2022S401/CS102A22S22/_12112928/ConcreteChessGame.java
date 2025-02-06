

import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents=new ChessComponent[8][8];
    private ChessColor currentPlayer = ChessColor.WHITE;
    int R = 0;
    int r = 0;
    int N = 0;
    int n = 0;
    int Q = 0;
    int q = 0;
    int B = 0;
    int b = 0;
    int K = 0;
    int k = 0;
    int P = 0;
    int p = 0;
    private static ChessComponent[][] a;
    private String[][] apple = new String[8][8];

    public ConcreteChessGame(){
    }

    public ChessComponent[][] getChessComponent() {
        return chessComponents;
    }

    public static ChessComponent[][] getA() {
        return a;
    }

    public static ChessComponent[][] getChessComponents() {
        return a;
    }

    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessboardPoint o = new ChessboardPoint(i, j);
                if (chessboard.get(i).charAt(j) == 'R') {
                    ChessComponent v = new RookChessComponent(o, ChessColor.BLACK, 'R');
                    chessComponents[i][j] = v;
                    apple[i][j] = "R";
                    R++;
                }
                if (chessboard.get(i).charAt(j) == 'r') {
                    ChessComponent v = new RookChessComponent(o, ChessColor.WHITE, 'r');
                    chessComponents[i][j] = v;
                    apple[i][j] = "r";
                    r++;
                }
                if (chessboard.get(i).charAt(j) == 'N') {
                    ChessComponent v = new KnightChessComponent(o, ChessColor.BLACK, 'N');
                    chessComponents[i][j] = v;
                    apple[i][j] = "N";
                    N++;
                }
                if (chessboard.get(i).charAt(j) == 'n') {
                    ChessComponent v = new RookChessComponent(o, ChessColor.WHITE, 'n');
                    chessComponents[i][j] = v;
                    apple[i][j] = "n";
                    n++;
                }
                if (chessboard.get(i).charAt(j) == 'B') {
                    ChessComponent v = new BishopChessComponent(o, ChessColor.BLACK, 'B');
                    chessComponents[i][j] = v;
                    apple[i][j] = "B";
                    B++;
                }
                if (chessboard.get(i).charAt(j) == 'b') {
                    ChessComponent v = new BishopChessComponent(o, ChessColor.WHITE, 'b');
                    chessComponents[i][j] = v;
                    apple[i][j] = "b";
                    b++;
                }
                if (chessboard.get(i).charAt(j) == 'P') {
                    ChessComponent v = new PawnChessComponent(o, ChessColor.BLACK, 'P');
                    chessComponents[i][j] = v;
                    apple[i][j] = "P";
                    P++;
                }
                if (chessboard.get(i).charAt(j) == 'p') {
                    ChessComponent v = new PawnChessComponent(o, ChessColor.WHITE, 'p');
                    chessComponents[i][j] = v;
                    apple[i][j] = "p";
                    p++;
                }
                if (chessboard.get(i).charAt(j) == 'K') {
                    ChessComponent v = new KingChessComponent(o, ChessColor.BLACK, 'K');
                    chessComponents[i][j] = v;
                    apple[i][j] = "K";
                    K++;
                }
                if (chessboard.get(i).charAt(j) == 'k') {
                    ChessComponent v = new KingChessComponent(o, ChessColor.WHITE, 'k');
                    chessComponents[i][j] = v;
                    apple[i][j] = "k";
                    k++;
                }
                if (chessboard.get(i).charAt(j) == 'Q') {
                    ChessComponent v = new QueenChessComponent(o, ChessColor.BLACK, 'Q');
                    chessComponents[i][j] = v;
                    apple[i][j] = "Q";
                    Q++;
                }
                if (chessboard.get(i).charAt(j) == 'q') {
                    ChessComponent v = new QueenChessComponent(o, ChessColor.WHITE, 'q');
                    chessComponents[i][j] = v;
                    apple[i][j] = "q";
                    q++;
                }
                if (chessboard.get(i).charAt(j) == '_') {
                    ChessComponent v = new EmptySlotComponent(o, ChessColor.NONE, '_');
                    chessComponents[i][j] = v;
                    apple[i][j] = "_";
                }
            }
        }
        if (chessboard.get(8).charAt(0) == 'w') {
            currentPlayer = ChessColor.WHITE;
        }
        if (chessboard.get(8).charAt(0) == 'b') {
            currentPlayer = ChessColor.BLACK;
        }
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                chessComponents[i][j].setChessComponents(chessComponents);
            }
        }
    }

    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }


    public String ss(String s[][], int l) {
        StringBuilder k = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            k.append(s[l][i]);
        }
        return k.toString();
    }

    public String getChessboardGraph() {
        String a = (ss(apple, 0) + '\n' + ss(apple, 1) + '\n' + ss(apple, 2) + '\n'
                + ss(apple, 3) + '\n' + ss(apple, 4) + '\n' +
                ss(apple, 5) + '\n' + ss(apple, 6) + '\n' +
                ss(apple, 7));
        return a;
    }

    public String getCapturedChess(ChessColor player) {
        StringBuilder cap = new StringBuilder();
        R = 2 - R;
        int rr = 2 - r;
        B = 2 - B;
        int bb = 2 - b;
        K = 1 - K;
        int kk = 1 - k;
        N = 2 - N;
        int nn = 2 - n;
        Q = 1 - Q;
        int qq = 1 - q;
        P = 8 - P;
        int pp = 8 - p;
        if (player == ChessColor.WHITE) {
            if (kk != 0) {
                cap.append("k " + kk + '\n');
            }
            if (qq != 0) {
                cap.append("q " + qq + '\n');
            }
            if (rr != 0) {
                cap.append("r " + rr + '\n');
            }
            if (bb != 0) {
                cap.append("b " + bb + '\n');
            }
            if (nn != 0) {
                cap.append("n " + nn + '\n');
            }
            if (pp != 0) {
                cap.append("p " + pp + '\n');
            }
        }
        if (player == ChessColor.BLACK) {
            if (K > 0) {
                cap.append("K " + K + '\n');
            }
            if (Q > 0) {
                cap.append("Q " + Q + '\n');
            }
            if (R > 0) {
                cap.append("R " + R + '\n');
            }
            if (B > 0) {
                cap.append("B " + B + '\n');
            }
            if (N > 0) {
                cap.append("N " + N + '\n');
            }
            if (P > 0) {
                cap.append("P " + P + '\n');
            }
        }
        return cap.toString();
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> canMovePoints = getChess(source.getX(), source.getY()).canMoveTo();
        for (int i = 0;i <= canMovePoints.size()-2;i++) {
            for (int j = i + 1; j <= canMovePoints.size() - 1; j++) {
                ChessboardPoint t;
                if (canMovePoints.get(i).getX() > canMovePoints.get(j).getX()) {
                    t = canMovePoints.get(i);
                    canMovePoints.set(i, canMovePoints.get(j));
                    canMovePoints.set(j, t);
                }
                if (canMovePoints.get(i).getX() == canMovePoints.get(j).getX() && canMovePoints.get(i).getY() > canMovePoints.get(j).getY()) {
                    t = canMovePoints.get(i);
                    canMovePoints.set(i, canMovePoints.get(j));
                    canMovePoints.set(j, t);
                }
            }
        }
        return canMovePoints;
    }
private void setCurrentPlayer(ChessColor a){
        this.currentPlayer=a;
}
    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessboardPoint source = new ChessboardPoint(sourceX, sourceY);
        ChessboardPoint destination = new ChessboardPoint(targetX, targetY);
        ChessComponent tchesscomponent = getChess(sourceX, sourceY);
        if (getCurrentPlayer() == chessComponents[sourceX][sourceY].getChessColor()) {
             if (tchesscomponent.canMoveTo().contains(destination)) {
                 chessComponents[targetX][targetY]=tchesscomponent;
                 chessComponents[sourceX][sourceY]=new EmptySlotComponent(source,ChessColor.NONE,'_');
                 for (int i=0;i<8;i++){
                     for (int j=0;j<8;j++){
                         chessComponents[i][j].setChessComponents(chessComponents);
                     }
                 }
                 currentPlayer = currentPlayer == ChessColor.BLACK ? ChessColor.WHITE : ChessColor.BLACK;
                return true;
            } else return false;
        } else return false;
    }
}
