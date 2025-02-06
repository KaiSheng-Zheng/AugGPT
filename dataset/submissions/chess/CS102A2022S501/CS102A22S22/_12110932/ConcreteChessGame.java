import java.util.List;


public class ConcreteChessGame implements ChessGame{
    // A 2-dimension array to store all the chess components
    // should be initialized in your construct method.
    // i.e. = new ChessComponent[8][8]
    private ChessComponent[][] chessComponents=new ChessComponent[8][8];
    // What's the current player's color, black or white?
    // should be initialized in your construct method.
    // by default, set the color to white.
    private ChessColor currentPlayer=ChessColor.WHITE;
    //ChessGame game1=new ConcreteChessGame();
    @Override
    public void loadChessGame(List<String> chessboard) {
        if(chessboard.get(8).charAt(0)=='b'){
            currentPlayer=ChessColor.BLACK;
        }
        for(int i=0;i<=7;i++){
            for (int j=0;j<=7;j++){
                if(chessboard.get(i).charAt(j)=='K'){
                    chessComponents[i][j] = new KingChessComponent();
                    chessComponents[i][j].name='K';
                    chessComponents[i][j].setSource(i,j);
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                }
                if(chessboard.get(i).charAt(j)=='k'){
                    chessComponents[i][j] = new KingChessComponent();
                    chessComponents[i][j].name='k';
                    chessComponents[i][j].setSource(i,j);
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                }
                if(chessboard.get(i).charAt(j)=='Q'){
                    chessComponents[i][j] = new QueenChessComponent();
                    chessComponents[i][j].name='Q';
                    chessComponents[i][j].setSource(i,j);
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                }
                if(chessboard.get(i).charAt(j)=='q'){
                    chessComponents[i][j] = new QueenChessComponent();
                    chessComponents[i][j].name='q';
                    chessComponents[i][j].setSource(i,j);
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                }
                if(chessboard.get(i).charAt(j)=='B'){
                    chessComponents[i][j] = new BishopChessComponent();
                    chessComponents[i][j].name='B';
                    chessComponents[i][j].setSource(i,j);
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                }
                if(chessboard.get(i).charAt(j)=='b'){
                    chessComponents[i][j] = new KingChessComponent();
                    chessComponents[i][j].name='b';
                    chessComponents[i][j].setSource(i,j);
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                }
                if(chessboard.get(i).charAt(j)=='N'){
                    chessComponents[i][j] = new KnightChessComponent();
                    chessComponents[i][j].name='N';
                    chessComponents[i][j].setSource(i,j);
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                }
                if(chessboard.get(i).charAt(j)=='n'){
                    chessComponents[i][j] = new KnightChessComponent();
                    chessComponents[i][j].name='n';
                    chessComponents[i][j].setSource(i,j);
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                }
                if(chessboard.get(i).charAt(j)=='R'){
                    chessComponents[i][j] = new RookChessComponent();
                    chessComponents[i][j].name='R';
                    chessComponents[i][j].setSource(i,j);
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                }
                if(chessboard.get(i).charAt(j)=='r'){
                    chessComponents[i][j] = new RookChessComponent();
                    chessComponents[i][j].name='r';
                    chessComponents[i][j].setSource(i,j);
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                }
                if(chessboard.get(i).charAt(j)=='P'){
                    chessComponents[i][j] = new PawnChessComponent();
                    chessComponents[i][j].name='P';
                    chessComponents[i][j].setSource(i,j);
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                }
                if(chessboard.get(i).charAt(j)=='p'){
                    chessComponents[i][j] = new PawnChessComponent();
                    chessComponents[i][j].name='p';
                    chessComponents[i][j].setSource(i,j);
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                }
                if(chessboard.get(i).charAt(j)=='_'){
                    chessComponents[i][j] = new EmptySlotComponent();
                    chessComponents[i][j].name='_';
                    chessComponents[i][j].setSource(i,j);
                    chessComponents[i][j].setChessColor(ChessColor.NONE);
                }
            }
        }
        /*for(int i=0;i<=7;i++){
            for (int j=0;j<=7;j++){
                System.out.printf("%c",chessComponents[i][j].name);
            }
            System.out.printf("\n");
        }*/

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
        String s="";
        for(int i=0;i<=7;i++){
            for(int j=0;j<=7;j++){
                s=s+chessComponents[i][j].name;
            }
            if(i!=7) {
                s = s + "\n";
            }
        }
        return s;
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int k=1;
        int q=1;
        int r=2;
        int b=2;
        int n=2;
        int p=8;
        String s="";
        if(player==ChessColor.BLACK){
            for(int i=0;i<=7;i++){
                for(int j=0;j<=7;j++){
                    if (chessComponents[i][j].name=='K'){
                        k--;
                    }
                    if (chessComponents[i][j].name=='Q'){
                        q--;
                    }
                    if (chessComponents[i][j].name=='R'){
                        r--;
                    }
                    if (chessComponents[i][j].name=='B'){
                        b--;
                    }
                    if (chessComponents[i][j].name=='N'){
                        n--;
                    }
                    if (chessComponents[i][j].name=='P'){
                        p--;
                    }
                }
            }
            if(k!=0){
                s=s+"K ";
                int a=k;
                s=s+a;
                s=s+"\n";
            }
            if(q!=0){
                s=s+"Q ";
                int a=q;
                s=s+a;
                s=s+"\n";
            }
            if(r!=0){
                s=s+"R ";
                int a=r;
                s=s+a;
                s=s+"\n";
            }
            if(b!=0){
                s=s+"B ";
                int a=b;
                s=s+a;
                s=s+"\n";
            }
            if(n!=0){
                s=s+"N ";
                int a=n;
                s=s+a;
                s=s+"\n";
            }
            if(p!=0){
                s=s+"P ";
                int a=p;
                s=s+a;
                s=s+"\n";
            }
            return s;
        }
        if(player==ChessColor.WHITE){
            for(int i=0;i<=7;i++){
                for(int j=0;j<=7;j++){
                    if (chessComponents[i][j].name=='k'){
                        k--;
                    }
                    if (chessComponents[i][j].name=='q'){
                        q--;
                    }
                    if (chessComponents[i][j].name=='r'){
                        r--;
                    }
                    if (chessComponents[i][j].name=='b'){
                        b--;
                    }
                    if (chessComponents[i][j].name=='n'){
                        n--;
                    }
                    if (chessComponents[i][j].name=='p'){
                        p--;
                    }
                }
            }
            if(k!=0){
                s=s+"k ";
                int a=k;
                s=s+a;
                s=s+"\n";
            }
            if(q!=0){
                s=s+"q ";
                int a=q;
                s=s+a;
                s=s+"\n";
            }
            if(r!=0){
                s=s+"r ";
                int a=r;
                s=s+a;
                s=s+"\n";
            }
            if(b!=0){
                s=s+"b ";
                int a=b;
                s=s+a;
                s=s+"\n";
            }
            if(n!=0){
                s=s+"n ";
                int a=n;
                s=s+a;
                s=s+"\n";
            }
            if(p!=0){
                s=s+"p ";
                int a=p;
                s=s+a;
                s=s+"\n";
            }
            return s;
        }
        return null;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessboardPoint a=new ChessboardPoint(sourceX,sourceY);
        ChessboardPoint b=new ChessboardPoint(targetX,targetY);
        List<ChessboardPoint> c = getCanMovePoints(a);
        for(int i=0;i<c.size();i++){
            if(c.get(i)==b){
                chessComponents[targetX][targetY]=chessComponents[sourceX][sourceY];
                chessComponents[targetX][targetX].setSource(targetX,targetY);
                chessComponents[sourceX][sourceY]=new EmptySlotComponent();
                return true;
            }
        }
        return false;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess=chessComponents[source.getX()][source.getY()];
        //chess.canMoveTo(chessComponents,source);
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        return canMovePoints;
    }
}
