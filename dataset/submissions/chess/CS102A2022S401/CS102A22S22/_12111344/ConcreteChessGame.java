import java.util.List;
import java.util.Comparator;
public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents=new ChessComponent[8][8];
    public static ChessComponent[][] chessComponent=new ChessComponent[8][8];
    private ChessColor currentPlayer=ChessColor.WHITE;
    int a=0;

    public void loadChessGame(List<String> chessboard){
        for(int i=0; i<8;i++){
            for(int j=0; j<8;j++){
                if(chessboard.get(i).charAt(j)=='K'){
                    chessComponents[i][j]=new KingChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j),'K');
                    chessComponent[i][j]=new KingChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j),'K');
                }
                if(chessboard.get(i).charAt(j)=='k'){
                    chessComponents[i][j]=new KingChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j),'k');
                    chessComponent[i][j]=new KingChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j),'k');
                }
                if(chessboard.get(i).charAt(j)=='R'){
                    chessComponents[i][j]=new RookChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j),'R');
                    chessComponent[i][j]=new RookChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j),'R');
                }
                if(chessboard.get(i).charAt(j)=='r'){
                    chessComponents[i][j]=new RookChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j),'r');
                    chessComponent[i][j]=new RookChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j),'r');
                }
                if(chessboard.get(i).charAt(j)=='N'){
                    chessComponents[i][j]=new KnightChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j),'N');
                    chessComponent[i][j]=new KnightChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j),'N');
                }
                if(chessboard.get(i).charAt(j)=='n'){
                    chessComponents[i][j]=new KnightChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j),'n');
                    chessComponent[i][j]=new KnightChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j),'n');}
                if(chessboard.get(i).charAt(j)=='B'){
                    chessComponents[i][j]=new BishopChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j),'B');
                    chessComponent[i][j]=new BishopChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j),'B');}
                if(chessboard.get(i).charAt(j)=='b'){
                    chessComponents[i][j]=new BishopChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j),'b');
                    chessComponent[i][j]=new BishopChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j),'b');}
                if(chessboard.get(i).charAt(j)=='Q'){
                    chessComponents[i][j]=new QueenChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j),'Q');
                    chessComponent[i][j]=new QueenChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j),'Q');}
                if(chessboard.get(i).charAt(j)=='q'){
                    chessComponents[i][j]=new QueenChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j),'q');
                    chessComponent[i][j]=new QueenChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j),'q');}
                if(chessboard.get(i).charAt(j)=='P'){
                    chessComponents[i][j]=new PawnChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j),'P');
                    chessComponent[i][j]=new PawnChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j),'P');}
                if(chessboard.get(i).charAt(j)=='p'){
                    chessComponent[i][j]=new PawnChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j),'p');
                    chessComponents[i][j]=new PawnChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j),'p');}
                if(chessboard.get(i).charAt(j)=='_'){
                    chessComponents[i][j]=new EmptySlotComponent(ChessColor.NONE,new ChessboardPoint(i,j),'_');
                    chessComponent[i][j]=new EmptySlotComponent(ChessColor.NONE,new ChessboardPoint(i,j),'_');}
            }
        }
        if(chessboard.get(8).charAt(0)=='b'){
            currentPlayer=ChessColor.BLACK;
        }
        if(chessboard.get(8).charAt(0)=='w'){
            currentPlayer=ChessColor.WHITE;
        }
    }


    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }
    public String getChessboardGraph(){
        StringBuilder a=new StringBuilder();
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                a.append(chessComponents[i][j].name);
            }a.append("\n");
    }return a.toString();}

    public String getCapturedChess(ChessColor player){
        int a=1;int a2=1;
        int b=1;int b2=1;
        int c=2;int c2=2;
        int d=2;int d2=2;
        int e=2;int e2=2;
        int f=8;int f2=8;
        StringBuilder B=new StringBuilder();
        StringBuilder W=new StringBuilder();
            for(int i=0; i<8; i++){
                for(int j=0; j<8; j++){
                    if(chessComponents[i][j].name=='K'){a--;}
                    if(chessComponents[i][j].name=='k'){a2--;}
                    if(chessComponents[i][j].name=='Q'){b--;}
                    if(chessComponents[i][j].name=='q'){b2--;}
                    if(chessComponents[i][j].name=='R'){c--;}
                    if(chessComponents[i][j].name=='r'){c2--;}
                    if(chessComponents[i][j].name=='B'){d--;}
                    if(chessComponents[i][j].name=='b'){d2--;}
                    if(chessComponents[i][j].name=='N'){e--;}
                    if(chessComponents[i][j].name=='n'){e2--;}
                    if(chessComponents[i][j].name=='P'){f--;}
                    if(chessComponents[i][j].name=='p'){f2--;}
                }
            }
                if(a!=0){B.append(String.format("K %d\n",a));}
                if(b!=0){B.append(String.format("Q %d\n",b));}
                if(c!=0){B.append(String.format("R %d\n",c));}
                if(d!=0){B.append(String.format("B %d\n",d));}
                if(e!=0){B.append(String.format("N %d\n",e));}
                if(f!=0){B.append(String.format("P %d\n",f));}
                if(a2!=0){W.append(String.format("k %d\n",a2));}
                if(b2!=0){W.append(String.format("q %d\n",b2));}
                if(c2!=0){W.append(String.format("r %d\n",c2));}
                if(d2!=0){W.append(String.format("b %d\n",d2));}
                if(e2!=0){W.append(String.format("n %d\n",e2));}
                if(f2!=0){W.append(String.format("p %d\n",f2));}
            if(player==ChessColor.BLACK){
               return B.toString();}
            else{
              return W.toString();}
   }
    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }


    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
        if(a%2==0){currentPlayer=ChessColor.WHITE;}else{currentPlayer=ChessColor.BLACK;}
        if(getChess(sourceX,sourceY).chessColor.equals(currentPlayer)){
            for(int i=0; i<chessComponents[sourceX][sourceY].canMoveTo().size();i++){
                if(chessComponents[sourceX][sourceY].canMoveTo().get(i).getX()==targetX&chessComponents[sourceX][sourceY].canMoveTo().get(i).getY()==targetY){
                    chessComponents[sourceX][sourceY].setSource(new ChessboardPoint(targetX,targetY));
                    chessComponents[targetX][targetY]=chessComponent[sourceX][sourceY];
                    chessComponents[sourceX][sourceY]=new EmptySlotComponent(ChessColor.NONE,new ChessboardPoint(sourceX,sourceY),'_');
                   a++;return true;}
            }
        } return false;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        chessComponents[source.getX()][source.getY()].loadCurrentChessboard(chessComponents);
        List<ChessboardPoint> moveTo=(List<ChessboardPoint>)chessComponents[source.getX()][source.getY()].canMoveTo();
        moveTo.sort(new Sort());
        return moveTo;
    }
    private static class Sort implements Comparator<ChessboardPoint>{
        @Override
        public int compare(ChessboardPoint p1,ChessboardPoint p2){
            return p1.getX()==p2.getX()?p1.getY()-p2.getY():p1.getX()-p2.getX();
        }
    }



}
