import java.util.List;

public class ConcreteChessGame implements ChessGame{
    static int x;
    static int y;
    private ChessComponent[][] chessComponents=new ChessComponent[8][8];
    private ChessColor currentPlayer;
    private BishopChessComponent bishopChessComponentB=new BishopChessComponent(chessComponents);
    private RookChessComponent rookChessComponentR=new RookChessComponent(chessComponents);
    private KingChessComponent kingChessComponentK=new KingChessComponent(chessComponents);
    private KnightChessComponent knightChessComponentN=new KnightChessComponent();
    private QueenChessComponent queenChessComponentQ=new QueenChessComponent(chessComponents);
    private PawnChessComponent pawnChessComponentP=new PawnChessComponent();
    private EmptySlotComponent emptySlotComponent=new EmptySlotComponent();

    private BishopChessComponent bishopChessComponentb=new BishopChessComponent(chessComponents);
    private RookChessComponent rookChessComponentr=new RookChessComponent(chessComponents);
    private KingChessComponent kingChessComponentk=new KingChessComponent(chessComponents);
    private KnightChessComponent knightChessComponentn=new KnightChessComponent();
    private QueenChessComponent queenChessComponentq=new QueenChessComponent(chessComponents);
    private PawnChessComponent pawnChessComponentp=new PawnChessComponent();

    @Override
    public void loadChessGame(List<String> chessboard) {
        Character player= chessboard.get(8).charAt(0);
        if (player=='w')
            currentPlayer=ChessColor.WHITE;
        else
            currentPlayer=ChessColor.BLACK;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Character use=chessboard.get(i).charAt(j);
                if (use=='R') {
                    rookChessComponentR.name='R';
                    chessComponents[i][j] = rookChessComponentR;
                }
                if (use=='r') {

                    rookChessComponentr.name='r';
                    chessComponents[i][j] = rookChessComponentr;
                }
                if (use=='B') {
                    bishopChessComponentB.name='B';
                    chessComponents[i][j] = bishopChessComponentB;
                }
                if (use=='b') {
                    bishopChessComponentb.name='b';
                    chessComponents[i][j] = bishopChessComponentb;
                }
                if (use=='K') {
                    kingChessComponentK.name='K';
                    chessComponents[i][j] = kingChessComponentK;
                }
                if (use=='k') {
                    kingChessComponentk.name='k';
                    chessComponents[i][j] = kingChessComponentk;
                }
                if (use=='N') {
                    knightChessComponentN.name='N';
                    chessComponents[i][j] = knightChessComponentN;
                }
                if (use=='n') {
                    knightChessComponentn.name='n';
                    chessComponents[i][j] = knightChessComponentn;
                }
                if (use=='Q') {
                    queenChessComponentQ.name='Q';
                    chessComponents[i][j] = queenChessComponentQ;
                }
                if (use=='q') {
                    queenChessComponentq.name='q';
                    chessComponents[i][j] = queenChessComponentq;
                }
                if (use=='P') {
                    pawnChessComponentP.name='P';
                    chessComponents[i][j] = pawnChessComponentP;
                }
                if (use=='p') {
                    pawnChessComponentp.name='p';
                    chessComponents[i][j] = pawnChessComponentp;
                }
                if (use=='_') {
                    chessComponents[i][j] = emptySlotComponent;
                }
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
       StringBuilder use=new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessComponents[i][j] == rookChessComponentr)
                        use.append("r");
                if (chessComponents[i][j] == rookChessComponentR)
                        use.append("R");
                if (chessComponents[i][j] == pawnChessComponentp)
                        use.append("p");
                if (chessComponents[i][j] == pawnChessComponentP)
                        use.append("P");
                if (chessComponents[i][j] == kingChessComponentk)
                        use.append("k");
                if (chessComponents[i][j] == kingChessComponentK)
                        use.append("K");
                if (chessComponents[i][j] == knightChessComponentn)
                        use.append("n");
                if (chessComponents[i][j] == knightChessComponentN)
                        use.append("N");
                if (chessComponents[i][j] == bishopChessComponentb)
                        use.append("b");
                if (chessComponents[i][j] == bishopChessComponentB)
                        use.append("B");
                if (chessComponents[i][j] == queenChessComponentq)
                        use.append("q");
                if (chessComponents[i][j] == queenChessComponentQ)
                        use.append("Q");
                if (chessComponents[i][j]==emptySlotComponent){
                    use.append("_");
                }
                if (j==7)
                    use.append("\n");

            }
        }
        String out= String.valueOf(use);
        return out;

    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int r=2;
        int R=2;
        int p=8;
        int P=8;
        int k=1;
        int K=1;
        int N=2;
        int n=2;
        int b=2;
        int B=2;
        int q=1;
        int Q=1;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessComponents[i][j] == rookChessComponentr)
                    r-=1;
                if (chessComponents[i][j] == rookChessComponentR)
                    R-=1;
                if (chessComponents[i][j] == pawnChessComponentp)
                    p-=1;
                if (chessComponents[i][j] == pawnChessComponentP)
                    P-=1;
                if (chessComponents[i][j] == kingChessComponentk)
                    k-=1;
                if (chessComponents[i][j] == kingChessComponentK)
                    K-=1;
                if (chessComponents[i][j] == knightChessComponentn)
                    n-=1;
                if (chessComponents[i][j] == knightChessComponentN)
                    N-=1;
                if (chessComponents[i][j] == bishopChessComponentb)
                    b-=1;
                if (chessComponents[i][j] == bishopChessComponentB)
                    B-=1;
                if (chessComponents[i][j] == queenChessComponentq)
                    q-=1;
                if (chessComponents[i][j] == queenChessComponentQ)
                    Q-=1;
            }
        }
        StringBuilder use=new StringBuilder();
        if (player==ChessColor.BLACK){
            if (K!=0)
                use.append("K 1\n");
            if (Q!=0)
                use.append("Q 1\n");
            if (R!=0)
                use.append("R "+R+"\n");
            if (B!=0)
                use.append("B "+B+"\n");
            if (N!=0)
                use.append("N "+N+"\n");
            if (P!=0)
                use.append("P "+P+"\n");
        }
       else {
            if (k!=0)
                use.append("k 1\n");
            if (q!=0)
                use.append("q 1\n");
            if (r!=0)
                use.append("r "+r+"\n");
            if (b!=0)
                use.append("b "+b+"\n");
            if (n!=0)
                use.append("n "+n+"\n");
            if (p!=0)
                use.append("p "+p+"\n");
        }
       String out= String.valueOf(use);
       return out;

    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        x=source.getX();
        y=source.getY();
        ChessComponent chess=chessComponents[source.getX()][source.getY()];
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        return canMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessboardPoint source=new ChessboardPoint(sourceX,sourceY);
        List<ChessboardPoint> canMovePoints = getCanMovePoints(source);
        ChessboardPoint target=new ChessboardPoint(targetX,targetY);
        boolean x=canMovePoints.contains(target);
        if (x==true){
            if (getCurrentPlayer()==ChessColor.WHITE){
                if (chessComponents[sourceX][sourceY].name>95){
                    chessComponents[targetX][targetY]=chessComponents[sourceX][sourceY];
                    chessComponents[sourceX][sourceY]=new EmptySlotComponent();
                    currentPlayer=ChessColor.BLACK;
                    return true;
                }
                else
                    return false;
            }
            else {
                if (chessComponents[sourceX][sourceY].name<95){
                    chessComponents[targetX][targetY]=chessComponents[sourceX][sourceY];
                    chessComponents[sourceX][sourceY]=new EmptySlotComponent();
                    currentPlayer=ChessColor.WHITE;
                    return true;
                }
                else
                    return false;
            }
        }
        else
            return false;
    }
}
