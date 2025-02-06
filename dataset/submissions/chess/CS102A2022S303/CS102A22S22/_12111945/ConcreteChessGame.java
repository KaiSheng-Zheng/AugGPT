import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessColor currentPlayer;
    private ChessComponent[][] chessComponents;

    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }

    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessboard.get(i).charAt(j) == 'R') {
                    chessComponents[i][j] = new RookChessComponent(i, j, ChessColor.BLACK, 'R', chessComponents);
                }
                if (chessboard.get(i).charAt(j) == 'B') {
                    chessComponents[i][j] = new BishopChessComponent(i,j, ChessColor.BLACK, 'B', chessComponents);
                }
                if (chessboard.get(i).charAt(j) == 'N') {
                    chessComponents[i][j] = new KnightChessComponent(i,j, ChessColor.BLACK, 'N', chessComponents);
                }
                if (chessboard.get(i).charAt(j) == 'Q') {
                    chessComponents[i][j] = new QueenChessComponent(i,j, ChessColor.BLACK, 'Q', chessComponents);
                }
                if (chessboard.get(i).charAt(j) == 'K') {
                    chessComponents[i][j] = new KingChessComponent(i,j, ChessColor.BLACK, 'K', chessComponents);
                }
                if (chessboard.get(i).charAt(j) == 'P') {
                    chessComponents[i][j] = new PawnChessComponent(i,j, ChessColor.BLACK, 'P', chessComponents);
                }
                if (chessboard.get(i).charAt(j) == '_') {
                    chessComponents[i][j] = new EmptySlotComponent(i,j, ChessColor.NONE, '_', chessComponents);
                }
                if (chessboard.get(i).charAt(j) == 'r') {
                    chessComponents[i][j] = new RookChessComponent(i, j, ChessColor.WHITE, 'r', chessComponents);
                }
                if (chessboard.get(i).charAt(j) == 'b') {
                    chessComponents[i][j] = new BishopChessComponent(i,j, ChessColor.WHITE, 'b', chessComponents);
                }
                if (chessboard.get(i).charAt(j) == 'n') {
                    chessComponents[i][j] = new KnightChessComponent(i,j, ChessColor.WHITE, 'n', chessComponents);
                }
                if (chessboard.get(i).charAt(j) == 'q') {
                    chessComponents[i][j] = new QueenChessComponent(i,j, ChessColor.WHITE, 'q', chessComponents);
                }
                if (chessboard.get(i).charAt(j) == 'k') {
                    chessComponents[i][j] = new KingChessComponent(i,j, ChessColor.WHITE, 'k', chessComponents);
                }
                if (chessboard.get(i).charAt(j) == 'p') {
                    chessComponents[i][j] = new PawnChessComponent(i,j, ChessColor.WHITE, 'p', chessComponents);
                }
            }
        }
        if (chessboard.get(8).equals("w")) {
            setCurrentPlayer(ChessColor.WHITE);
        }
        if (chessboard.get(8).equals("b")) {
            setCurrentPlayer(ChessColor.BLACK);
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessComponents[i][j].setChessComponents(chessComponents);
            }
        }
    }

    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    public String getChessboardGraph() {
        StringBuilder chessboardgraph = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            chessboardgraph.append(chessComponents[0][i].getName());
        }
        chessboardgraph.append("\n");
        for (int i = 0; i < 8; i++) {
            chessboardgraph.append(chessComponents[1][i].getName());
        }
        chessboardgraph.append("\n");
        for (int i = 0; i < 8; i++) {
            chessboardgraph.append(chessComponents[2][i].getName());
        }
        chessboardgraph.append("\n");
        for (int i = 0; i < 8; i++) {
            chessboardgraph.append(chessComponents[3][i].getName());
        }
        chessboardgraph.append("\n");
        for (int i = 0; i < 8; i++) {
            chessboardgraph.append(chessComponents[4][i].getName());
        }
        chessboardgraph.append("\n");
        for (int i = 0; i < 8; i++) {
            chessboardgraph.append(chessComponents[5][i].getName());
        }
        chessboardgraph.append("\n");
        for (int i = 0; i < 8; i++) {
            chessboardgraph.append(chessComponents[6][i].getName());
        }
        chessboardgraph.append("\n");
        for (int i = 0; i < 8; i++) {
            chessboardgraph.append(chessComponents[7][i].getName());
        }
        return String.valueOf(chessboardgraph);
    }

    public String getCapturedChess(ChessColor player) {
        int R_num = 0;
        int B_num = 0;
        int N_num = 0;
        int Q_num = 0;
        int K_num = 0;
        int P_num = 0;
        int r_num = 0;
        int b_num = 0;
        int n_num = 0;
        int q_num = 0;
        int k_num = 0;
        int p_num = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessComponents[i][j].getName() == 'R') {
                    R_num++;
                }
                if (chessComponents[i][j].getName() == 'r') {
                    r_num++;
                }
                if (chessComponents[i][j].getName() == 'B') {
                    B_num++;
                }
                if (chessComponents[i][j].getName() == 'b') {
                    b_num++;
                }
                if (chessComponents[i][j].getName() == 'N') {
                    N_num++;
                }
                if (chessComponents[i][j].getName() == 'n') {
                    n_num++;
                }
                if (chessComponents[i][j].getName() == 'Q') {
                    Q_num++;
                }
                if (chessComponents[i][j].getName() == 'q') {
                    q_num++;
                }
                if (chessComponents[i][j].getName() == 'K') {
                    K_num++;
                }
                if (chessComponents[i][j].getName() == 'k') {
                    k_num++;
                }
                if (chessComponents[i][j].getName() == 'P') {
                    P_num++;
                }
                if (chessComponents[i][j].getName() == 'p') {
                    p_num++;
                }
            }
        }
        R_num = 2 - R_num;
        B_num = 2 - B_num;
        N_num = 2 - N_num;
        Q_num = 1 - Q_num;
        K_num = 1 - K_num;
        P_num = 8 - P_num;
        r_num = 2 - r_num;
        b_num = 2 - b_num;
        n_num = 2 - n_num;
        q_num = 1 - q_num;
        k_num = 1 - k_num;
        p_num = 8 - p_num;
        StringBuilder CapturedChess = new StringBuilder();
        if (player == ChessColor.WHITE) {
            if (k_num != 0) {
                CapturedChess.append("k ").append(k_num).append("\n");
            }
            if (q_num != 0) {
                CapturedChess.append("q ").append(q_num).append("\n");
            }
            if (r_num != 0) {
                CapturedChess.append("r ").append(r_num).append("\n");
            }
            if (b_num != 0) {
                CapturedChess.append("b ").append(b_num).append("\n");
            }
            if (n_num != 0) {
                CapturedChess.append("n ").append(n_num).append("\n");
            }
            if (p_num != 0) {
                CapturedChess.append("p ").append(p_num).append("\n");
            }
        }
        if (player == ChessColor.BLACK) {
            if (K_num != 0) {
                CapturedChess.append("K ").append(K_num).append("\n");
            }
            if (Q_num != 0) {
                CapturedChess.append("Q ").append(Q_num).append("\n");
            }
            if (R_num != 0) {
                CapturedChess.append("R ").append(R_num).append("\n");
            }
            if (B_num != 0) {
                CapturedChess.append("B ").append(B_num).append("\n");
            }
            if (N_num != 0) {
                CapturedChess.append("N ").append(N_num).append("\n");
            }
            if (P_num != 0) {
                CapturedChess.append("P ").append(P_num).append("\n");
            }
        }
        return CapturedChess.toString();
    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        if (chessComponents[source.getX()][source.getY()].canMoveTo() == null) return new ArrayList<>();
        List<ChessboardPoint> canMovePoints = chessComponents[source.getX()][source.getY()].canMoveTo();
        canMovePoints.sort(Comparator.comparingInt(ChessboardPoint::getX).thenComparingInt(ChessboardPoint::getY));
        return canMovePoints;
    }

    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        boolean can = false;
        List<ChessboardPoint> canmove =  chessComponents[sourceX][sourceY].canMoveTo();
        for (ChessboardPoint chessboardPoint : canmove) {
            if(chessboardPoint.getY() == targetY && chessboardPoint.getX()==targetX){
                can = true;
                break;}
        }
        if(can && chessComponents[sourceX][sourceY].getChessColor().equals(currentPlayer)){
            chessComponents[targetX][targetY]  = chessComponents[sourceX][sourceY];
            chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
            chessComponents[sourceX][sourceY] = new EmptySlotComponent(sourceX,sourceY,ChessColor.NONE,'_',chessComponents);

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    chessComponents[i][j].setChessComponents(this.chessComponents);
                }   }
            if(currentPlayer == ChessColor.BLACK) {
                currentPlayer = ChessColor.WHITE;
            }
            else{
                currentPlayer = ChessColor.BLACK;}
            return true;}
        else {return false;}
    }
}