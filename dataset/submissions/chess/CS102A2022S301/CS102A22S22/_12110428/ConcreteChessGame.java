import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer;

    private int BISHOP = 0;
    private int KING = 0;
    private int KNIGHT = 0;
    private int PAWN = 0;
    private int QUEEN = 0;
    private int ROOK = 0;
    private int bishop = 0;
    private int king = 0 ;
    private int knight = 0;
    private int pawn = 0;
    private int queen = 0;
    private int rook = 0;

    int B;
    int K;
    int N;
    int P;
    int Q;
    int R;
    int b;
    int k;
    int n;
    int p;
    int q;
    int r;

    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                switch (chessboard.get(i).charAt(j)) {
                    case 'B':
                        chessComponents[i][j] = new BishopChessComponent(ChessColor.BLACK);
                        BISHOP++;
                        break;
                    case 'K':
                        chessComponents[i][j] = new KingChessComponent(ChessColor.BLACK);
                        KING++;
                        break;
                    case 'N':
                        chessComponents[i][j] = new KnightChessComponent(ChessColor.BLACK);
                        KNIGHT++;
                        break;
                    case 'P':
                        chessComponents[i][j] = new PawnChessComponent(ChessColor.BLACK);
                        PAWN++;
                        break;
                    case 'Q':
                        chessComponents[i][j] = new QueenChessComponent(ChessColor.BLACK);
                        QUEEN++;
                        break;
                    case 'R':
                        chessComponents[i][j] = new RookChessComponent(ChessColor.BLACK);
                        ROOK++;
                        break;
                    case 'b':
                        chessComponents[i][j] = new BishopChessComponent(ChessColor.WHITE);
                        bishop++;
                        break;
                    case 'k':
                        chessComponents[i][j] = new KingChessComponent(ChessColor.WHITE);
                        king++;
                        break;
                    case 'n':
                        chessComponents[i][j] = new KnightChessComponent(ChessColor.WHITE);
                        knight++;
                        break;
                    case 'p':
                        chessComponents[i][j] = new PawnChessComponent(ChessColor.WHITE);
                        pawn++;
                        break;
                    case 'q':
                        chessComponents[i][j] = new QueenChessComponent(ChessColor.WHITE);
                        queen++;
                        break;
                    case 'r':
                        chessComponents[i][j] = new RookChessComponent(ChessColor.WHITE);
                        rook++;
                        break;
                    case '_':
                        chessComponents[i][j] = new EmptySlotComponent(ChessColor.NONE);
                }
            }
        }
        if(chessboard.get(8).charAt(0)=='w'){
            this.currentPlayer = ChessColor.WHITE;
        } else if(chessboard.get(8).charAt(0)=='b'){
            this.currentPlayer = ChessColor.BLACK;
        }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public String getChessboardGraph() {
        int a;
        int b;
        StringBuilder stringBuilder = new StringBuilder();
        for (a = 0; a <= 7; a++) {
            for (b = 0; b <= 7; b++) {
                stringBuilder.append(chessComponents[a][b]);
            }
            stringBuilder.append("\n");
        }
        return String.valueOf(stringBuilder);
    }

    public String getCapturedChess(ChessColor player) {
        StringBuilder stringBuilder = new StringBuilder();
            b = 2 - bishop;
            k = 1 - king;
            n = 2 - knight;
            p = 8 - pawn;
            q = 1 - queen;
            r = 2 - rook;
            stringBuilder.append("");
            if(player == ChessColor.WHITE){
                if (k != 0) {
                    stringBuilder.append(String.format("k %d\n", k));
                }

                if (q != 0) {
                    stringBuilder.append(String.format("q %d\n", q));
                }
                
                if (r != 0) {
                    stringBuilder.append(String.format("r %d\n", r));
                }
                
                if (b != 0) {
                    stringBuilder.append(String.format("b %d\n", b));
                }
                
                if (n != 0) {
                    stringBuilder.append(String.format("n %d\n", n));
                }

                if (p != 0) {
                    stringBuilder.append(String.format("p %d\n", p));
                }
              
            } else if (player == ChessColor.BLACK){
                B = 2 - BISHOP;
                K = 1 - KING;
                N = 2 - KNIGHT;
                P = 8 - PAWN;
                Q = 1 - QUEEN;
                R = 2 - ROOK;

                if (K != 0) {
                    stringBuilder.append(String.format("K %d\n", K));
                }

                if (Q != 0) {
                    stringBuilder.append(String.format("Q %d\n", Q));
                }

                if (R != 0) {
                    stringBuilder.append(String.format("R %d\n", R));
                }

                if (B != 0) {
                    stringBuilder.append(String.format("B %d\n", B));
                }

                if (N != 0) {
                    stringBuilder.append(String.format("N %d\n", N));
                }

                if (P != 0) {
                    stringBuilder.append(String.format("P %d\n", P));
                }

            }
        return String.valueOf(stringBuilder);
    }

        public ChessComponent getChess ( int x, int y){
            return chessComponents[x][y];
    }

        @Override
        public List<ChessboardPoint> getCanMovePoints (ChessboardPoint source){
            return null;
    }

        @Override
        public boolean moveChess ( int sourceX, int sourceY, int targetX, int targetY){
            return false;
    }
}
