import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer =ChessColor.WHITE;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        int i=0;
        for (String row:chessboard) {
            if(i<8){
            for (int j = 0; j < 8; j++) {
                if (row.charAt(j) == 'P') {
                    chessComponents[i][j] = new PawnChessComponent(ChessColor.BLACK);
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                } else if (row.charAt(j) == 'p') {
                    chessComponents[i][j] = new PawnChessComponent(ChessColor.WHITE);
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                } else if (row.charAt(j) == 'B') {
                    chessComponents[i][j] = new BishopChessComponent(ChessColor.BLACK);
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                } else if(row.charAt(j)=='b'){
                    chessComponents[i][j]=new BishopChessComponent(ChessColor.WHITE);
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                } else if(row.charAt(j)=='R'){
                    chessComponents[i][j]=new RookChessComponent(ChessColor.BLACK);
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                } else if(row.charAt(j)=='r'){
                    chessComponents[i][j]=new RookChessComponent(ChessColor.WHITE);
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                } else if(row.charAt(j)=='N'){
                    chessComponents[i][j]=new KnightChessComponent(ChessColor.BLACK);
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                } else if (row.charAt(j) == 'n') {
                    chessComponents[i][j]=new KnightChessComponent(ChessColor.WHITE);
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                } else if(row.charAt(j)=='Q'){
                    chessComponents[i][j]=new QueenChessComponent(ChessColor.BLACK);
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                } else if(row.charAt(j)=='q'){
                    chessComponents[i][j]=new QueenChessComponent(ChessColor.WHITE);
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                } else if(row.charAt(j)=='K'){
                    chessComponents[i][j]=new KingChessComponent(ChessColor.BLACK);
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                } else if (row.charAt(j) == 'k') {
                    chessComponents[i][j]=new KingChessComponent(ChessColor.WHITE);
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                } else if(row.charAt(j)=='_'){
                    chessComponents[i][j]=new EmptySlotComponent(ChessColor.NONE);
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                }
                }}
            else{
                if(row.charAt(0)=='w'){
                    currentPlayer=ChessColor.WHITE;
                }
                else if(row.charAt(0)=='b'){
                    currentPlayer=ChessColor.BLACK;
                }
            }
            i++;
            }
        for(int m=0;m<8;m++){
            for(int n=0;n<8;n++){
                this.chessComponents[m][n].setChessboard(this.chessComponents);
                this.chessComponents[m][n].setSource(new ChessboardPoint(m,n));
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
        String[] s=new String[8];
        for(int i=0;i<8;i++){
            s[i]="";
            for(int j=0;j<8;j++){
                if(chessComponents[i][j] instanceof PawnChessComponent){
                    if(chessComponents[i][j].getChessColor()==ChessColor.BLACK){
                        s[i]+="P";
                    }
                    else if(chessComponents[i][j].getChessColor()==ChessColor.WHITE){
                        s[i]+="p";
                    }
                }

                else if(chessComponents[i][j] instanceof BishopChessComponent){
                    if(chessComponents[i][j].getChessColor()==ChessColor.BLACK){
                        s[i]+="B";
                    }
                    else if(chessComponents[i][j].getChessColor()==ChessColor.WHITE){
                        s[i]+="b";
                    }
                }

                else if(chessComponents[i][j] instanceof KnightChessComponent){
                    if(chessComponents[i][j].getChessColor()==ChessColor.BLACK){
                        s[i]+="N";
                    }
                    else if(chessComponents[i][j].getChessColor()==ChessColor.WHITE){
                        s[i]+="n";
                    }
                }

                else if(chessComponents[i][j] instanceof RookChessComponent){
                    if(chessComponents[i][j].getChessColor()==ChessColor.BLACK){
                        s[i]+="R";
                    }
                    else if(chessComponents[i][j].getChessColor()==ChessColor.WHITE){
                        s[i]+="r";
                    }
                }
                else if(chessComponents[i][j] instanceof KingChessComponent){
                    if(chessComponents[i][j].getChessColor()==ChessColor.BLACK){
                        s[i]+="K";
                    }
                    else if(chessComponents[i][j].getChessColor()==ChessColor.WHITE){
                        s[i]+="k";
                    }
                }

                else if(chessComponents[i][j] instanceof QueenChessComponent){
                    if(chessComponents[i][j].getChessColor()==ChessColor.BLACK){
                        s[i]+="Q";
                    }
                    else if(chessComponents[i][j].getChessColor()==ChessColor.WHITE){
                        s[i]+="q";
                    }
                }
                else if(chessComponents[i][j] instanceof EmptySlotComponent){
                    s[i]+="_";
                }
            }
        }
        String a="";
        for(int i=0;i<8;i++){
           a+=s[i]+"\n";
        }
        return a;
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int p=0,b=0,n=0,k=0,q=0,r=0;;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(chessComponents[i][j]instanceof PawnChessComponent&&chessComponents[i][j].getChessColor()==player){
                    p++;
                }
                else if(chessComponents[i][j]instanceof BishopChessComponent&&chessComponents[i][j].getChessColor()==player){
                    b++;
                }
                else if(chessComponents[i][j]instanceof KnightChessComponent&&chessComponents[i][j].getChessColor()==player){
                    n++;
                }
                else if(chessComponents[i][j]instanceof KingChessComponent&&chessComponents[i][j].getChessColor()==player){
                    k++;
                }
                else if(chessComponents[i][j]instanceof QueenChessComponent&&chessComponents[i][j].getChessColor()==player){
                    q++;
                }
                else if(chessComponents[i][j]instanceof RookChessComponent&&chessComponents[i][j].getChessColor()==player){
                    r++;
                }
            }
        }
        int P=8-p;
        int B=2-b;
        int N=2-n;
        int K=1-k;
        int Q=1-q;
        int R=2-r;
        StringBuilder sbB=new StringBuilder();
        StringBuilder sbW=new StringBuilder();
        if(K>0){
            sbB.append("K "+K+"\n");
            sbW.append("k "+K+'\n');
        }
        if(Q>0){
            sbB.append("Q "+Q+"\n");
            sbW.append("q "+Q+"\n");
        }
        if(R>0){
            sbB.append("R "+R+"\n");
            sbW.append("r "+R+"\n");
        }
        if(B>0){
            sbB.append("B "+B+"\n");
            sbW.append("b "+B+"\n");
        }
        if(N>0){
            sbB.append("N "+N+"\n");
            sbW.append("n "+N+"\n");
        }
        if(P>0){
            sbB.append("P "+P+"\n");
            sbW.append("p "+P+"\n");
        }
        if(player==ChessColor.BLACK)
            return sbB.toString();
        else if(player==ChessColor.WHITE)
            return sbW.toString();
        else return null;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
       ChessComponent chess= this.getChess(source.getX(), source.getY());
       List<ChessboardPoint> CanMovePoints=chess.canMoveTo();
           return  CanMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if(targetX>=0&&targetX<8&&targetY>=0&&targetY<8&&sourceX>=0&&sourceX<8&&sourceY>=0&&sourceY<8){
        ChessComponent chess= this.getChess(sourceX, sourceY);
        ChessComponent chess1=this.getChess(targetX,targetY);
        ChessComponent c1;
        int a=0;
        for(int i=0;i<chess.canMoveTo().size();i++){
            if(chess.canMoveTo().get(i).getX()==targetX&&chess.canMoveTo().get(i).getY()==targetY){
                a=1;
            }
        }
        if(chess instanceof PawnChessComponent){
            c1=new PawnChessComponent(chess.getChessColor());
            c1.setSource(chess1.getSource());
            if(a==1&&chess.getChessColor()==currentPlayer){
                chessComponents[targetX][targetY]=c1;
                chessComponents[sourceX][sourceY]=new EmptySlotComponent();
                chessComponents[sourceX][sourceY].setSource(new ChessboardPoint(sourceX,sourceY));
                if(currentPlayer==ChessColor.WHITE){
                    this.currentPlayer=ChessColor.BLACK;
                }
                else if(currentPlayer==ChessColor.BLACK){
                    this.currentPlayer=ChessColor.WHITE;
                }
                return true;
            }
        }
        else if(chess instanceof KingChessComponent){
            c1=new KingChessComponent((chess.getChessColor()));
            c1.setSource(chess.getSource());
            if(a==1&&chess.getChessColor()==currentPlayer){
                chessComponents[targetX][targetY]=c1;
                chessComponents[sourceX][sourceY]=new EmptySlotComponent();
                chessComponents[sourceX][sourceY].setSource(new ChessboardPoint(sourceX,sourceY));
                if(currentPlayer==ChessColor.WHITE){
                    this.currentPlayer=ChessColor.BLACK;
                }
                else if(currentPlayer==ChessColor.BLACK){
                    this.currentPlayer=ChessColor.WHITE;
                }
                return true;
            }
        }
        else if(chess instanceof KnightChessComponent){
            c1=new KnightChessComponent(chess.getChessColor());
            c1.setSource(chess.getSource());
            if(a==1&&chess.getChessColor()==currentPlayer){
                chessComponents[targetX][targetY]=c1;
                chessComponents[sourceX][sourceY]=new EmptySlotComponent();
                chessComponents[sourceX][sourceY].setSource(new ChessboardPoint(sourceX,sourceY));
                if(currentPlayer==ChessColor.WHITE){
                    this.currentPlayer=ChessColor.BLACK;
                }
                else if(currentPlayer==ChessColor.BLACK){
                    this.currentPlayer=ChessColor.WHITE;
                }
                return true;
            }
        }
        else if(chess instanceof QueenChessComponent){
            c1=new QueenChessComponent(chess.getChessColor());
            c1.setSource(chess.getSource());
            if(a==1&&chess.getChessColor()==currentPlayer){
                chessComponents[targetX][targetY]=c1;
                chessComponents[sourceX][sourceY]=new EmptySlotComponent();
                chessComponents[sourceX][sourceY].setSource(new ChessboardPoint(sourceX,sourceY));
                if(currentPlayer==ChessColor.WHITE){
                    this.currentPlayer=ChessColor.BLACK;
                }
                else if(currentPlayer==ChessColor.BLACK){
                    this.currentPlayer=ChessColor.WHITE;
                }
                return true;
            }
        }
        else if(chess instanceof RookChessComponent){
            c1=new RookChessComponent(chess.getChessColor());
            c1.setSource(chess.getSource());
            if(a==1&&chess.getChessColor()==currentPlayer){
                chessComponents[targetX][targetY]=c1;
                chessComponents[sourceX][sourceY]=new EmptySlotComponent();
                chessComponents[sourceX][sourceY].setSource(new ChessboardPoint(sourceX,sourceY));
                if(currentPlayer==ChessColor.WHITE){
                    this.currentPlayer=ChessColor.BLACK;
                }
                else if(currentPlayer==ChessColor.BLACK){
                    this.currentPlayer=ChessColor.WHITE;
                }
                return true;
            }
        }
        else if(chess instanceof BishopChessComponent){
            c1=new BishopChessComponent(chess.getChessColor());
            c1.setSource(chess.getSource());
            if(a==1&&chess.getChessColor()==currentPlayer){
                chessComponents[targetX][targetY]=c1;
                chessComponents[sourceX][sourceY]=new EmptySlotComponent();
                chessComponents[sourceX][sourceY].setSource(new ChessboardPoint(sourceX,sourceY));
                if(currentPlayer==ChessColor.WHITE){
                    this.currentPlayer=ChessColor.BLACK;
                }
                else if(currentPlayer==ChessColor.BLACK){
                    this.currentPlayer=ChessColor.WHITE;
                }
                return true;
            }
        }
        else if(chess instanceof EmptySlotComponent){
            return false;
        }
            return false;
    }
        else
            return false;
    }
}
