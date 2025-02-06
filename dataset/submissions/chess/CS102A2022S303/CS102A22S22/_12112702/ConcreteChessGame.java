import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer;
    private List<String> chessboard;

    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessboard.get(i).charAt(j) == 'B') {
                    chessComponents[i][j] = new BishopChessComponent(i, j, true);
                }
                if (chessboard.get(i).charAt(j) == 'b') {
                    chessComponents[i][j] = new BishopChessComponent(i, j, false);
                }
                if (chessboard.get(i).charAt(j) == '_') {
                    chessComponents[i][j] = new EmptySlotComponent(i, j);
                }
                if (chessboard.get(i).charAt(j) == 'K') {
                    chessComponents[i][j] = new KingChessComponent(i, j, true);
                }
                if (chessboard.get(i).charAt(j) == 'k') {
                    chessComponents[i][j] = new KingChessComponent(i, j, false);
                }
                if (chessboard.get(i).charAt(j) == 'N') {
                    chessComponents[i][j] = new KnightChessComponent(i, j, true);
                }
                if (chessboard.get(i).charAt(j) == 'n') {
                    chessComponents[i][j] = new KnightChessComponent(i, j, false);
                }
                if (chessboard.get(i).charAt(j) == 'P') {
                    chessComponents[i][j] = new PawnChessComponent(i, j, true);
                }
                if (chessboard.get(i).charAt(j) == 'p') {
                    chessComponents[i][j] = new PawnChessComponent(i, j, false);
                }
                if (chessboard.get(i).charAt(j) == 'Q') {
                    chessComponents[i][j] = new QueenChessComponent(i, j, true);
                }
                if (chessboard.get(i).charAt(j) == 'q') {
                    chessComponents[i][j] = new QueenChessComponent(i, j, false);
                }
                if (chessboard.get(i).charAt(j) == 'R') {
                    chessComponents[i][j] = new RookChessComponent(i, j, true);
                }
                if (chessboard.get(i).charAt(j) == 'r') {
                    chessComponents[i][j] = new RookChessComponent(i, j, false);
                }
            }
        }
        if (Objects.equals(chessboard.get(8), "w")) {
            currentPlayer = ChessColor.WHITE;
        } else {
            currentPlayer = ChessColor.BLACK;
        }
        this.chessboard = chessboard;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessComponents[i][j].setChessComponents(this.chessComponents);
            }
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
        return String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n", chessboard.get(0), chessboard.get(1), chessboard.get(2), chessboard.get(3), chessboard.get(4), chessboard.get(5), chessboard.get(6), chessboard.get(7));
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int b = 2;
        int k = 1;
        int n = 2;
        int p = 8;
        int q = 1;
        int r = 2;
        if (player == ChessColor.WHITE) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessboard.get(i).charAt(j) == 'b') {
                        b--;
                    }
                    if (chessboard.get(i).charAt(j) == 'k') {
                        k--;
                    }
                    if (chessboard.get(i).charAt(j) == 'n') {
                        n--;
                    }
                    if (chessboard.get(i).charAt(j) == 'p') {
                        p--;
                    }
                    if (chessboard.get(i).charAt(j) == 'q') {
                        q--;
                    }
                    if (chessboard.get(i).charAt(j) == 'r') {
                        r--;
                    }
                }
            }
            StringBuilder a = new StringBuilder();
            if (k!=0){
                a.append(String.format("k %d\n",k));
            }
            if (q!=0){
                a.append(String.format("q %d\n",q));
            }
            if (r!=0){
                a.append(String.format("r %d\n",r));
            }
            if (b!=0){
                a.append(String.format("b %d\n",b));
            }
            if (n!=0){
                a.append(String.format("n %d\n",n));
            }
            if (p!=0){
                a.append(String.format("p %d\n",p));
            }
            return a.toString();
        }
        else {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessboard.get(i).charAt(j) == 'B') {
                        b--;
                    }
                    if (chessboard.get(i).charAt(j) == 'K') {
                        k--;
                    }
                    if (chessboard.get(i).charAt(j) == 'N') {
                        n--;
                    }
                    if (chessboard.get(i).charAt(j) == 'P') {
                        p--;
                    }
                    if (chessboard.get(i).charAt(j) == 'Q') {
                        q--;
                    }
                    if (chessboard.get(i).charAt(j) == 'R') {
                        r--;
                    }
                }
            }
            StringBuilder a = new StringBuilder();
            if (k!=0){
                a.append(String.format("K %d\n",k));
            }
            if (q!=0){
                a.append(String.format("Q %d\n",q));
            }
            if (r!=0){
                a.append(String.format("R %d\n",r));
            }
            if (b!=0){
                a.append(String.format("B %d\n",b));
            }
            if (n!=0){
                a.append(String.format("N %d\n",n));
            }
            if (p!=0){
                a.append(String.format("P %d\n",p));
            }
            return a.toString();
        }
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        // 1. find chess according to source
        // 2. as below statement:
        List<ChessboardPoint> canMovePoints = chessComponents[source.getX()][source.getY()].canMoveTo();
        // 3.sort canMovePoints by x - y ascending order
        return canMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        List<ChessboardPoint> can = getCanMovePoints(chessComponents[sourceX][sourceY].getSource());
        if (sourceX > 7 || sourceY > 7 || targetY > 7 || targetX > 7) {
            return false;
        }
        if (chessComponents[sourceX][sourceY].getChessColor() != currentPlayer) {
            return false;
        }
        if (can.contains(new ChessboardPoint(targetX,targetY))){
            currentPlayer = currentPlayer == ChessColor.BLACK ? ChessColor.WHITE : ChessColor.BLACK;
            ChessComponent a = chessComponents[sourceX][sourceY];
            chessComponents[targetX][targetY] = a;
            chessComponents[sourceX][sourceY] = new EmptySlotComponent(sourceX,sourceY);
            a.setSource(new ChessboardPoint(targetX,targetY));
            return true;
        } else {
            return false;
        }
    }
}
