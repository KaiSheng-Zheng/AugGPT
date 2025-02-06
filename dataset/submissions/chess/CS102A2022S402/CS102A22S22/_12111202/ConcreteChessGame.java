import java.util.List;
public class ConcreteChessGame implements ChessGame{
    private ChessColor currentPlayer;
    private ChessComponent[][] chessComponents;
    @Override
    public void loadChessGame(List<String> chessboard){
        int i;
        chessComponents=new ChessComponent[8][8];
        Board board =new Board();
        for (i=0;i<8;i++){
            chessboard.get(i);
            for (int h=0;h<8;h++){
                switch (chessboard.get(i).charAt(h)){
                    case 'R':
                        chessComponents[i][h]=new RookChessComponent();
                        chessComponents[i][h].name='R';
                        chessComponents[i][h].setSource(i,h);
                        chessComponents[i][h].setChessColor(ChessColor.BLACK);
                        break;
                    case 'r':
                        chessComponents[i][h]=new RookChessComponent();
                        this.chessComponents[i][h].name='r';
                        chessComponents[i][h].setSource(i,h);
                        chessComponents[i][h].setChessColor(ChessColor.WHITE);
                        break;
                    case 'N':
                        chessComponents[i][h]=new KnightChessComponent();
                        this.chessComponents[i][h].name='N';
                        chessComponents[i][h].setSource(i,h);
                        chessComponents[i][h].setChessColor(ChessColor.BLACK);
                        break;
                    case 'n':
                        chessComponents[i][h]=new KnightChessComponent();
                        this.chessComponents[i][h].name='n';
                        chessComponents[i][h].setSource(i,h);
                        chessComponents[i][h].setChessColor(ChessColor.WHITE);
                        break;
                    case 'B':
                        chessComponents[i][h]=new BishopChessComponent();
                        this.chessComponents[i][h].name='B';
                        chessComponents[i][h].setSource(i,h);
                        chessComponents[i][h].setChessColor(ChessColor.BLACK);
                        break;
                    case 'b':
                        chessComponents[i][h]=new BishopChessComponent();
                        this.chessComponents[i][h].name='b';
                        chessComponents[i][h].setSource(i,h);
                        chessComponents[i][h].setChessColor(ChessColor.WHITE);
                        break;
                    case 'Q':
                        chessComponents[i][h]=new QueenChessComponent();
                        this.chessComponents[i][h].name='Q';
                        chessComponents[i][h].setSource(i,h);
                        chessComponents[i][h].setChessColor(ChessColor.BLACK);
                        break;
                    case 'q':
                        chessComponents[i][h]=new QueenChessComponent();
                        this.chessComponents[i][h].name='q';
                        chessComponents[i][h].setSource(i,h);
                        chessComponents[i][h].setChessColor(ChessColor.WHITE);
                        break;
                    case 'K':
                        chessComponents[i][h]=new KingChessComponent();
                        this.chessComponents[i][h].name='K';
                        chessComponents[i][h].setSource(i,h);
                        chessComponents[i][h].setChessColor(ChessColor.BLACK);
                        break;
                    case 'k':
                        chessComponents[i][h]=new KingChessComponent();
                        this.chessComponents[i][h].name='k';
                        chessComponents[i][h].setSource(i,h);
                        chessComponents[i][h].setChessColor(ChessColor.WHITE);
                        break;
                    case 'P':
                        chessComponents[i][h]=new PawnChessComponent();
                        this.chessComponents[i][h].name='P';
                        chessComponents[i][h].setSource(i,h);
                        chessComponents[i][h].setChessColor(ChessColor.BLACK);
                        break;
                    case 'p':
                        chessComponents[i][h]=new PawnChessComponent();
                        this.chessComponents[i][h].name='p';
                        chessComponents[i][h].setSource(i,h);
                        chessComponents[i][h].setChessColor(ChessColor.WHITE);
                        break;
                    case '_':
                        chessComponents[i][h]=new EmptySlotComponent();
                        this.chessComponents[i][h].name='_';
                        chessComponents[i][h].setSource(i,h);
                        chessComponents[i][h].setChessColor(ChessColor.NONE);
                        break;
                }
            }
        }
        board.loadboard(chessComponents);
        if (chessboard.get(i).equals("w")){
            this.currentPlayer=ChessColor.WHITE;
        }
        else {
            this.currentPlayer=ChessColor.BLACK;
        }
    }
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){
        return chessComponents[source.getX()][source.getY()].canMoveTo();
    }
    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }
    public String getChessboardGraph(){
        StringBuilder i=new StringBuilder();
        for (int a=0;a<8;a++){
            for (int b=0;b<8;b++){
                i.append(chessComponents[a][b].name);
            }
            if (a<7){i.append("\n");}
        }
        return i.toString();
    }
    public String getCapturedChess(ChessColor player){
        StringBuilder m=new StringBuilder();
        int p=0;
        int q=0;
        int r=0;
        int b=0;
        int n=0;
        int k=0;
        if (player==ChessColor.BLACK){
            for (int a=0;a<8;a++){
                for (int B=0;B<8;B++){
                    switch (chessComponents[a][B].name){
                        case 'R':
                            r++;
                            break;
                        case 'N':
                            n++;
                            break;
                        case 'B':
                            b++;
                            break;
                        case 'Q':
                            q++;
                            break;
                        case 'K':
                            k++;
                            break;
                        case 'P':
                            p++;
                            break;}
                }}if (1-k!=0){
                m.append("K ");
                m.append(1-k);
            }
            if (1-q!=0){
                m.append("\nQ ");
                m.append(1-q);
            }
            if (2-r!=0){
                m.append("\nR ");
                m.append(2-r);
            }
            if (2-b!=0){
                m.append("\nB ");
                m.append(2-b);
            }
            if (2-n!=0){
                m.append("\nN ");
                m.append(2-n);
            }
            if (8-p!=0){
                m.append("\nP ");
                m.append(8-p);
            }
            return m.toString();
        }
        else {
            for (int a=0;a<8;a++){
                for (int B=0;B<8;B++){
                    switch (chessComponents[a][B].name){
                        case 'r':
                            r++;
                            break;
                        case 'n':
                            n++;
                            break;
                        case 'b':
                            b++;
                            break;
                        case 'q':
                            q++;
                            break;
                        case 'k':
                            k++;
                            break;
                        case 'p':
                            p++;
                            break;}
                }}
        }if (1-k!=0){
            m.append("k ");
            m.append(1-k);
        }
        if (1-q!=0){
            m.append("\nq ");
            m.append(1-q);
        }
        if (2-r!=0){
            m.append("\nr ");
            m.append(2-r);
        }
        if (2-b!=0){
            m.append("\nb ");
            m.append(2-b);
        }
        if (2-n!=0){
            m.append("\nn ");
            m.append(2-n);
        }
        if (8-p!=0){
            m.append("\np ");
            m.append(8-p);
        }
        return m.toString();
    }
    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }
    public void setChess1(int x, int y,int a,int b){
        chessComponents[a][b]=chessComponents[x][y];
        chessComponents[a][b].setSource(a,b);
        chessComponents[x][y]=new EmptySlotComponent();
        chessComponents[x][y].setChessColor(ChessColor.NONE);
        chessComponents[x][y].setSource(x,y);
        chessComponents[x][y].name='_';
        Board.loadboard(chessComponents);
    }
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
        ChessboardPoint a=new ChessboardPoint(targetX,targetY);
        if (getChess(sourceX,sourceY).getChessColor()==this.currentPlayer){
            for(int i = 0 ;i < getChess(sourceX,sourceY).canMoveTo().size();i++){
            if(getChess(sourceX,sourceY).canMoveTo().get(i)==a){
                    setChess1(sourceX, sourceY, targetX,targetY);
                    if (this.currentPlayer==ChessColor.WHITE){
                        this.currentPlayer=ChessColor.BLACK;
                    }else{this.currentPlayer=ChessColor.WHITE;}
                    return true;
            }
        }
        return false;
        }
        else {return false;}
    }
}
