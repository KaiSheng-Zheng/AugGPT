import java.util.List;
import java.util.Scanner;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer = ChessColor.WHITE;
    private List<String> chessboard;

    public ConcreteChessGame() {
    }

    public ConcreteChessGame(ChessComponent[][] chessComponents, ChessColor currentPlayer, List<String> chessboard) {
        this.chessComponents = chessComponents;
        this.currentPlayer = currentPlayer;
        this.chessboard = chessboard;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        this.chessboard=chessboard;
        for (int i = 0; i < 8; i++) {
            String a = chessboard.get(i);
            char[] b = a.toCharArray();
            for (int j = 0; j < 8; j++) {
                if (b[j] == 'p') {
                    PawnChessComponent chess = new PawnChessComponent();
                    chessComponents[i][j] = chess;
                }
                if (b[j] == 'r') {
                    RookChessComponent chess = new RookChessComponent();
                    chessComponents[i][j] = chess;
                }
                if (b[j] == 'b') {
                    BishopChessComponent chess = new BishopChessComponent();
                    chessComponents[i][j] = chess;
                }
                if (b[j] == 'q') {
                    QueenChessComponent chess = new QueenChessComponent();
                    chessComponents[i][j] = chess;
                }
                if (b[j] == 'k') {
                    KingChessComponent chess = new KingChessComponent();
                    chessComponents[i][j] = chess;
                }
                if (b[j] == 'n') {
                    KnightChessComponent chess = new KnightChessComponent();
                    chessComponents[i][j] = chess;
                }
                if (b[j] == 'P') {
                    PawnChessComponent chess = new PawnChessComponent();
                    chessComponents[i][j] = chess;
                }
                if (b[j] == 'R') {
                    RookChessComponent chess = new RookChessComponent();
                    chessComponents[i][j] = chess;
                }
                if (b[j] == 'B') {
                    BishopChessComponent chess = new BishopChessComponent();
                    chessComponents[i][j] = chess;
                }
                if (b[j] == 'Q') {
                    QueenChessComponent chess = new QueenChessComponent();
                    chessComponents[i][j] = chess;
                }
                if (b[j] == 'K') {
                    KingChessComponent chess = new KingChessComponent();
                    chessComponents[i][j] = chess;
                }
                if (b[j] == 'N') {
                    KnightChessComponent chess = new KnightChessComponent();
                    chessComponents[i][j] = chess;
                }
                if (b[j] == '_') {
                    EmptySlotComponent chess = new EmptySlotComponent();
                    chessComponents[i][j] = chess;
                }
            }
        }
        String color = chessboard.get(8);
        if (color.equals("w")) {
            currentPlayer = ChessColor.WHITE;
        } else {
            currentPlayer = ChessColor.BLACK;
        }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph() {
        String sum = "";
        for (String i :
                chessboard) {
            if (i.length() != 1) {
                sum += i;
                sum += "\n";
            }
        }
        return sum;
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        StringBuilder result=new StringBuilder();
        int k = 0;
        int q = 0;
        int r = 0;
        int b = 0;
        int n = 0;
        int p = 0;
        int K = 0;
        int Q = 0;
        int R = 0;
        int B = 0;
        int N = 0;
        int P = 0;
        for (String i :
                chessboard) {
            if (i.length() != 1) {
                for (int j = 0; j < 8; j++) {
                    char[]b1=i.toCharArray();
                    if (b1[j] == 'p') {
                        p++;
                    }
                    if (b1[j] == 'r') {
                        r++;
                    }
                    if (b1[j] == 'b') {
                        b++;
                    }
                    if (b1[j] == 'q') {
                        q++;
                    }
                    if (b1[j] == 'k') {
                       k++;
                    }
                    if (b1[j] == 'n') {
                      n++;
                    }
                    if (b1[j] == 'P') {
                        P++;
                    }
                    if (b1[j] == 'R') {
                        R++;
                    }
                    if (b1[j] == 'B') {
                        B++;
                    }
                    if (b1[j] == 'Q') {
                        Q++;
                    }
                    if (b1[j] == 'K') {
                        K++;
                    }
                    if (b1[j] == 'N') {
                        N++;
                    }
                }
            }
        }
        if (player == ChessColor.BLACK) {
            K=1-K;
            Q=1-Q;
            R=2-R;
            B=2-B;
            N=2-N;
            P=8-P;
            if(K!=0){
                result.append("K "+K+"\n");
            }if(Q!=0){
                result.append("Q "+Q+"\n");
            }if(R!=0){
                result.append("R "+R+"\n");
            }if(B!=0){
                result.append("B "+B+"\n");
            }if(N!=0){
                result.append("N "+N+"\n");
            }if(P!=0){
                result.append("P "+P+"\n");
            }
        }else {
            k=1-k;
            q=1-q;
            r=2-r;
            b=2-b;
            n=2-n;
            p=8-p;
            if(k!=0){
                result.append("k "+k+"\n");
            }if(q!=0){
                result.append("q "+q+"\n");
            }if(r!=0){
                result.append("r "+r+"\n");
            }if(b!=0){
                result.append("b "+b+"\n");
            }if(n!=0){
                result.append("n "+n+"\n");
            }if(p!=0){
                result.append("p "+p+"\n");
            }
        }
        return result.toString();
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        return null;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        return false;
    }
}
