import java.util.Comparator;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents= new ChessComponent[8][8];
    private ChessColor currentPlayer=ChessColor.WHITE;
    public ConcreteChessGame(){}


    public ChessColor getCurrentPlayer() {return this.currentPlayer; }

    public void loadChessGame(List<String> chessboard) {
        if (chessboard.get(8).charAt(0) == 'w') {
            this.currentPlayer = ChessColor.WHITE;
        } else if (chessboard.get(8).charAt(0) == 'b') {
            this.currentPlayer = ChessColor.BLACK;
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessboardPoint source=new ChessboardPoint(i,j);
                if (chessboard.get(i).charAt(j) == 'p') {
                    PawnChessComponent pawns=new PawnChessComponent(ChessColor.WHITE,source);
                    chessComponents[i][j]=pawns;
                }
                if (chessboard.get(i).charAt(j) == 'b') {
                    BishopChessComponent bishops=new BishopChessComponent(ChessColor.WHITE,source);
                    bishops.setChessComponents(chessComponents);
                    chessComponents[i][j]=bishops;
                }
                if (chessboard.get(i).charAt(j) == 'k') {
                    KingChessComponent king=new KingChessComponent(ChessColor.WHITE,source);
                    king.setChessComponents(chessComponents);
                    chessComponents[i][j]=king;
                }
                if (chessboard.get(i).charAt(j) == 'q') {
                    QueenChessComponent queen=new QueenChessComponent(ChessColor.WHITE,source);
                    queen.setChessComponents(chessComponents);
                    chessComponents[i][j]=queen;
                }
                if (chessboard.get(i).charAt(j) == 'n') {
                    KnightChessComponent knights=new KnightChessComponent(ChessColor.WHITE,source);
                    knights.setChessComponents(chessComponents);
                    chessComponents[i][j]=knights;
                }
                if (chessboard.get(i).charAt(j) == 'r') {
                    RookChessComponent rooks=new RookChessComponent(ChessColor.WHITE,source);
                    rooks.setChessComponents(chessComponents);
                    chessComponents[i][j]=rooks;
                }
                if (chessboard.get(i).charAt(j) == 'P') {
                    PawnChessComponent pawns=new PawnChessComponent(ChessColor.BLACK,source);
                    pawns.setChessComponents(chessComponents);
                    chessComponents[i][j]=pawns;
                }
                if (chessboard.get(i).charAt(j) == 'B') {
                    BishopChessComponent bishops=new BishopChessComponent(ChessColor.BLACK,source);
                    bishops.setChessComponents(chessComponents);
                    chessComponents[i][j]=bishops;
                }
                if (chessboard.get(i).charAt(j) == 'K') {
                    KingChessComponent king=new KingChessComponent(ChessColor.BLACK,source);
                    king.setChessComponents(chessComponents);
                    chessComponents[i][j]=king;
                }
                if (chessboard.get(i).charAt(j) == 'Q') {
                    QueenChessComponent queen=new QueenChessComponent(ChessColor.BLACK,source);
                    queen.setChessComponents(chessComponents);
                    chessComponents[i][j]=queen;
                }
                if (chessboard.get(i).charAt(j) == 'N') {
                    KnightChessComponent knights=new KnightChessComponent(ChessColor.BLACK,source);
                    knights.setChessComponents(chessComponents);
                    chessComponents[i][j]=knights;
                }
                if (chessboard.get(i).charAt(j) == 'R') {
                    RookChessComponent rooks=new RookChessComponent(ChessColor.BLACK,source);
                    rooks.setChessComponents(chessComponents);
                    chessComponents[i][j]=rooks;
                }
                if (chessboard.get(i).charAt(j) == '_') {
                    EmptySlotComponent nothing=new EmptySlotComponent(source);
                    nothing.setChessComponents(chessComponents);
                    chessComponents[i][j]=nothing;
                }
            }
        }
    }

    public String getChessboardGraph() {
        String a;
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessComponents[i][j] instanceof PawnChessComponent
                        &&chessComponents[i][j].getChessColor().equals(ChessColor.WHITE)) {
                    b.append("p");
                }
                if (chessComponents[i][j] instanceof BishopChessComponent
                        &&chessComponents[i][j].getChessColor().equals(ChessColor.WHITE)) {
                    b.append("b");
                }
                if (chessComponents[i][j] instanceof KingChessComponent
                        &&chessComponents[i][j].getChessColor().equals(ChessColor.WHITE)) {
                    b.append("k");
                }
                if (chessComponents[i][j] instanceof QueenChessComponent
                        &&chessComponents[i][j].getChessColor().equals(ChessColor.WHITE)) {
                    b.append("q");
                }
                if (chessComponents[i][j] instanceof KnightChessComponent
                        &&chessComponents[i][j].getChessColor().equals(ChessColor.WHITE)) {
                    b.append("n");
                }
                if (chessComponents[i][j] instanceof RookChessComponent
                        &&chessComponents[i][j].getChessColor().equals(ChessColor.WHITE)) {
                    b.append("r");
                }
                if (chessComponents[i][j] instanceof PawnChessComponent
                        &&chessComponents[i][j].getChessColor().equals(ChessColor.BLACK)) {
                    b.append("P");
                }
                if (chessComponents[i][j] instanceof BishopChessComponent
                        &&chessComponents[i][j].getChessColor().equals(ChessColor.BLACK)) {
                    b.append("B");
                }
                if (chessComponents[i][j] instanceof KingChessComponent
                        &&chessComponents[i][j].getChessColor().equals(ChessColor.BLACK)) {
                    b.append("K");
                }
                if (chessComponents[i][j] instanceof QueenChessComponent
                        &&chessComponents[i][j].getChessColor().equals(ChessColor.BLACK)) {
                    b.append("Q");
                }
                if (chessComponents[i][j] instanceof KnightChessComponent
                        &&chessComponents[i][j].getChessColor().equals(ChessColor.BLACK)) {
                    b.append("N");
                }
                if (chessComponents[i][j] instanceof RookChessComponent
                        &&chessComponents[i][j].getChessColor().equals(ChessColor.BLACK)) {
                    b.append("R");
                }
                if (chessComponents[i][j] instanceof EmptySlotComponent) {
                    b.append("_");
                }

            }
            b.append("\n");
        }
        a = String.valueOf(b);
        return a;
    }

    public String getCapturedChess(ChessColor player){
        int p = 8;int b=2;int k=1;int q=1;int n=2;int r=2;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessComponents[i][j] instanceof PawnChessComponent
                        &&chessComponents[i][j].getChessColor().equals(player)) {
                    p--;
                }
                if (chessComponents[i][j] instanceof BishopChessComponent
                        &&chessComponents[i][j].getChessColor().equals(player)) {
                    b--;
                }
                if (chessComponents[i][j] instanceof KingChessComponent
                        &&chessComponents[i][j].getChessColor().equals(player)) {
                    k--;
                }
                if (chessComponents[i][j] instanceof QueenChessComponent
                        &&chessComponents[i][j].getChessColor().equals(player)) {
                    q--;
                }
                if (chessComponents[i][j] instanceof KnightChessComponent
                        &&chessComponents[i][j].getChessColor().equals(player)) {
                    n--;
                }
                if (chessComponents[i][j] instanceof RookChessComponent
                        &&chessComponents[i][j].getChessColor().equals(player)) {
                    r--;
                }
            }
        }
        StringBuilder c = new StringBuilder();
        if (k!=0&&player.equals(ChessColor.WHITE)){
            c.append("k ").append(k).append("\n");
        }
        if (q!=0&&player.equals(ChessColor.WHITE)){
            c.append("q ").append(q).append("\n");
        }
        if (r!=0&&player.equals(ChessColor.WHITE)){
            c.append("r ").append(r).append("\n");
        }
        if (b!=0&&player.equals(ChessColor.WHITE)){
            c.append("b ").append(b).append("\n");
        }
        if (n!=0&&player.equals(ChessColor.WHITE)){
            c.append("n ").append(n).append("\n");
        }
        if (p!=0&&player.equals(ChessColor.WHITE)){
            c.append("p ").append(p).append("\n");
        }
        if (k!=0&&player.equals(ChessColor.BLACK)){
            c.append("K ").append(k).append("\n");
        }
        if (q!=0&&player.equals(ChessColor.BLACK)){
            c.append("Q ").append(q).append("\n");
        }
        if (r!=0&&player.equals(ChessColor.BLACK)){
            c.append("R ").append(r).append("\n");
        }
        if (b!=0&&player.equals(ChessColor.BLACK)){
            c.append("B ").append(b).append("\n");
        }
        if (n!=0&&player.equals(ChessColor.BLACK)){
            c.append("N ").append(n).append("\n");
        }
        if (p!=0&&player.equals(ChessColor.BLACK)){
            c.append("P ").append(p).append("\n");
        }
        String a;
        a=String.valueOf(c);
        return a;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){
        List<ChessboardPoint> canMoveTo=this.chessComponents[source.getX()][source.getY()].canMoveTo();
        canMoveTo.sort(Comparator.comparing(ChessboardPoint::getX).thenComparing(ChessboardPoint::getY));
        return canMoveTo;
    }

 @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if(this.currentPlayer!=this.chessComponents[sourceX][sourceY].getChessColor())
            return false;
        List<ChessboardPoint> l=this.chessComponents[sourceX][sourceY].canMoveTo();
        for(int a=0;a<l.size();a++)
            if(targetX==l.get(a).getX()&&targetY==l.get(a).getY()) {
                this.currentPlayer=this.currentPlayer==ChessColor.WHITE?ChessColor.BLACK:ChessColor.WHITE;
                char chess=this.chessComponents[sourceX][sourceY].name;
                this.chessComponents[sourceX][sourceY]=new EmptySlotComponent();
                this.chessComponents[sourceX][sourceY].refresh(sourceX,sourceY,'_');
                if(chess=='K'||chess=='k')
                    this.chessComponents[targetX][targetY]=new KingChessComponent();
                if(chess=='R'||chess=='r')
                    this.chessComponents[targetX][targetY]=new RookChessComponent();
                if(chess=='B'||chess=='b')
                    this.chessComponents[targetX][targetY]=new BishopChessComponent();
                if(chess=='N'||chess=='n')
                    this.chessComponents[targetX][targetY]=new KnightChessComponent();
                if(chess=='Q'||chess=='q')
                    this.chessComponents[targetX][targetY]=new QueenChessComponent();
                if(chess=='P'||chess=='p')
                    this.chessComponents[targetX][targetY]=new PawnChessComponent();
                this.chessComponents[targetX][targetY].refresh(targetX,targetY,chess);
                for(int b=0;b<8;b++)
                    for(int c=0;c<8;c++){
                        this.chessComponents[b][c].chessComponents=new ChessComponent[8][8];
                        for(int i=0;i<8;i++)
                            for(int j=0;j<8;j++){
                                if (this.chessComponents[i][j].name == 'K' || this.chessComponents[i][j].name == 'k')
                                    chessComponents[b][c].chessComponents[i][j] = new KingChessComponent();
                                if (this.chessComponents[i][j].name == 'R' || this.chessComponents[i][j].name == 'r')
                                    chessComponents[b][c].chessComponents[i][j] = new RookChessComponent();
                                if (this.chessComponents[i][j].name == 'N' || this.chessComponents[i][j].name == 'n')
                                    chessComponents[b][c].chessComponents[i][j] = new KnightChessComponent();
                                if (this.chessComponents[i][j].name == 'B' || this.chessComponents[i][j].name == 'b')
                                    chessComponents[b][c].chessComponents[i][j] = new BishopChessComponent();
                                if (this.chessComponents[i][j].name == 'Q' || this.chessComponents[i][j].name == 'q')
                                    chessComponents[b][c].chessComponents[i][j] = new QueenChessComponent();
                                if (this.chessComponents[i][j].name == 'P' || this.chessComponents[i][j].name == 'p')
                                    chessComponents[b][c].chessComponents[i][j] = new PawnChessComponent();
                                if (this.chessComponents[i][j].name == '_')
                                    chessComponents[b][c].chessComponents[i][j] = new EmptySlotComponent();
                                chessComponents[b][c].chessComponents[i][j].refresh(i, j, this.chessComponents[i][j].name);
                            }
                    }
                return true;
            }
        return false;
    }

    public ChessComponent getChess(int x,int y){
        return this.chessComponents[x][y];
    }

}