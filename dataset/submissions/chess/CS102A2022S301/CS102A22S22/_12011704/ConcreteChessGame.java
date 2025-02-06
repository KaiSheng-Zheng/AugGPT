import java.util.*;

public class ConcreteChessGame implements ChessGame{

    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer=ChessColor.WHITE;
    private int R=0,r=0,N=0,n=0,B=0,b=0,Q=0,q=0,K=0,k=0,P=0,p=0;

    public ConcreteChessGame(){
        chessComponents=new ChessComponent[8][8];
    }
    @Override
    public void loadChessGame(List<String> chessboard) {
        if(chessboard.get(8).equals("w")){
            currentPlayer=ChessColor.WHITE;
        }
        if(chessboard.get(8).equals("b")){
            currentPlayer=ChessColor.BLACK;
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                     switch (chessboard.get(i).charAt(j)){
                         case 'R': R++;chessComponents[i][j]=new RookChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'R');
                             chessComponents[i][j].setChessboard(this.chessComponents);
                         break;
                         case 'r': r++;chessComponents[i][j]=new RookChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'r');
                             chessComponents[i][j].setChessboard(this.chessComponents);
                         break;
                         case 'N': N++;chessComponents[i][j]=new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'N');
                             chessComponents[i][j].setChessboard(this.chessComponents);
                         break;
                         case 'n': n++;chessComponents[i][j]=new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'n');
                             chessComponents[i][j].setChessboard(this.chessComponents);
                         break;
                         case 'B': B++;chessComponents[i][j]=new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'B');
                             chessComponents[i][j].setChessboard(this.chessComponents);
                         break;
                         case 'b': b++;chessComponents[i][j]=new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'b');
                             chessComponents[i][j].setChessboard(this.chessComponents);
                         break;
                         case 'Q': Q++;chessComponents[i][j]=new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'Q');
                             chessComponents[i][j].setChessboard(this.chessComponents);
                         break;
                         case 'q': q++;chessComponents[i][j]=new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'q');
                             chessComponents[i][j].setChessboard(this.chessComponents);
                         break;
                         case 'K': K++;chessComponents[i][j]=new KingChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'K');
                             chessComponents[i][j].setChessboard(this.chessComponents);
                         break;
                         case 'k': k++;chessComponents[i][j]=new KingChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'k');
                             chessComponents[i][j].setChessboard(this.chessComponents);
                         break;
                         case 'P': P++;chessComponents[i][j]=new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'P');
                             chessComponents[i][j].setChessboard(this.chessComponents);
                         break;
                         case 'p': p++;chessComponents[i][j]=new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'p');
                             chessComponents[i][j].setChessboard(this.chessComponents);
                         break;
                         case '_': chessComponents[i][j]=new EmptySlotComponent(new ChessboardPoint(i,j),ChessColor.NONE,'_');
                         break;
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
        String[] ans=new String[8];
        for (int i = 0; i < 8; i++) {
            ans[i]="";
            for (int j = 0; j < 8; j++) {
                ans[i]=ans[i]+chessComponents[i][j].name;
            }
        }
        return String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s",ans[0],ans[1],ans[2],ans[3],ans[4],ans[5],ans[6],ans[7]);

    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int[]captured=new int[6];
        String ans="";
        if(player==ChessColor.BLACK){
            captured[0]=1-K;if(captured[0]==1){ans=ans+"K 1\n";}
            captured[1]=1-Q;if(captured[1]==1){ans=ans+"Q 1\n";}
            captured[2]=2-R;if(captured[2]!=0){ans=ans+String.format("R %d\n",captured[2]);}
            captured[3]=2-B;if(captured[3]!=0){ans=ans+String.format("B %d\n",captured[3]);}
            captured[4]=2-N;if(captured[4]!=0){ans=ans+String.format("N %d\n",captured[4]);}
            captured[5]=8-P;if(captured[5]!=0){ans=ans+String.format("P %d\n",captured[5]);}
            return ans;
            }
        if(player==ChessColor.WHITE){
            captured[0]=1-k;if(captured[0]==1){ans=ans+"k 1\n";}
            captured[1]=1-q;if(captured[1]==1){ans=ans+"q 1\n";}
            captured[2]=2-r;if(captured[2]!=0){ans=ans+String.format("r %d\n",captured[2]);}
            captured[3]=2-b;if(captured[3]!=0){ans=ans+String.format("b %d\n",captured[3]);}
            captured[4]=2-n;if(captured[4]!=0){ans=ans+String.format("n %d\n",captured[4]);}
            captured[5]=8-p;if(captured[5]!=0){ans=ans+String.format("p %d\n",captured[5]);}
            return ans;
        }
        return null;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
            ChessComponent chess=getChess(source.getX(),source.getY());
            List<ChessboardPoint> point = chess.canMoveTo();
            Collections.sort(point, new Comparator<ChessboardPoint>() {
            @Override
            public int compare(ChessboardPoint o1, ChessboardPoint o2) {
                return (o1.getX()-o2.getX()==0)?(o1.getY()-o2.getY()):(o1.getX()-o2.getX());
            }
        });
        /*for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(point.contains(new ChessboardPoint(i,j))){
                    System.out.println(point.contains(new ChessboardPoint(i,j)));
                    canMovePoints.add(new ChessboardPoint(i,j));
                }
            }
        }*/
        return point;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessComponent chess=getChess(sourceX,sourceY);
        ChessColor player=chess.getChessColor();
        List<ChessboardPoint> point=chess.canMoveTo();
        for (ChessboardPoint chessboardPoint : point) {
            if (chessboardPoint.getX() == targetX && chessboardPoint.getY() == targetY && player == getCurrentPlayer()) {
                if (currentPlayer == ChessColor.BLACK) {
                    currentPlayer = ChessColor.WHITE;
                }
                else { currentPlayer = ChessColor.BLACK; }
                chess.setSource(new ChessboardPoint(targetX,targetY));
                switch (chessComponents[targetX][targetY].getName()){
                    case 'R': R--;
                        break;
                    case 'r': r--;
                        break;
                    case 'N': N--;
                        break;
                    case 'n': n--;
                        break;
                    case 'B': B--;
                        break;
                    case 'b': b--;
                        break;
                    case 'Q': Q--;
                        break;
                    case 'q': q--;
                        break;
                    case 'K': K--;
                        break;
                    case 'k': k--;
                        break;
                    case 'P': P--;
                        break;
                    case 'p': p--;
                    break;
                    case '_': 
                        break;
                }
                chessComponents[targetX][targetY] = chess;
                chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX, sourceY), ChessColor.NONE, '_');
                return true;
            }
        }
        return false;
    }
}
