import java.util.ArrayList;
import java.util.List;

public  class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents =new ChessComponent[8][8];
    private ChessColor currentPlayer;
    private List<String> list;
    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public ConcreteChessGame() {}

    public void loadChessGame(List<String> chessboard){
         this.list=chessboard;
        char [][]a=new char[8][8];
         for (int j=0;j<8;j++){
         for (int i=0;i<8;i++){
             a[j][i]=chessboard.get(j).charAt(i);}
         }
         if (chessboard.get(8).charAt(0)=='w'){setCurrentPlayer(ChessColor.WHITE);}
         else if (chessboard.get(8).charAt(0)=='b'){setCurrentPlayer(ChessColor.BLACK);}
         else {setCurrentPlayer(ChessColor.NONE);}

        for (int i=0;i<8;i++){
             for (int j=0;j<8;j++){
                 if (a[i][j]=='R'){ChessboardPoint chessboardPoint=new ChessboardPoint(i,j);
                     chessComponents[i][j]=new RookChessComponent(chessboardPoint,ChessColor.BLACK,'R',chessboard);}
                 else if (a[i][j]=='N'){ChessboardPoint chessboardPoint=new ChessboardPoint(i,j);
                     chessComponents[i][j]=new KnightChessComponent(chessboardPoint,ChessColor.BLACK,'N',chessboard);}
                 else if (a[i][j]=='K'){ChessboardPoint chessboardPoint=new ChessboardPoint(i,j);
                     chessComponents[i][j]=new KingChessComponent(chessboardPoint,ChessColor.BLACK,'K',chessboard);}
                 else if (a[i][j]=='Q'){ChessboardPoint chessboardPoint=new ChessboardPoint(i,j);
                     chessComponents[i][j]=new QueenChessComponent(chessboardPoint,ChessColor.BLACK,'Q',chessboard);}
                 else if (a[i][j]=='B'){ChessboardPoint chessboardPoint=new ChessboardPoint(i,j);
                     chessComponents[i][j]=new BishopChessComponent(chessboardPoint,ChessColor.BLACK,'B',chessboard);}
                 else if (a[i][j]=='P'){ChessboardPoint chessboardPoint=new ChessboardPoint(i,j);
                     chessComponents[i][j]=new PawnChessComponent(chessboardPoint,ChessColor.BLACK,'P',chessboard);}
                 else if (a[i][j]=='r'){ChessboardPoint chessboardPoint=new ChessboardPoint(i,j);
                     chessComponents[i][j]=new RookChessComponent(chessboardPoint,ChessColor.WHITE,'r',chessboard);}
                 else if (a[i][j]=='n'){ChessboardPoint chessboardPoint=new ChessboardPoint(i,j);
                     chessComponents[i][j]=new KnightChessComponent(chessboardPoint,ChessColor.WHITE,'n',chessboard);}
                 else if (a[i][j]=='k'){ChessboardPoint chessboardPoint=new ChessboardPoint(i,j);
                     chessComponents[i][j]=new KingChessComponent(chessboardPoint,ChessColor.WHITE,'k',chessboard);}
                 else if (a[i][j]=='q'){ChessboardPoint chessboardPoint=new ChessboardPoint(i,j);
                     chessComponents[i][j]=new QueenChessComponent(chessboardPoint,ChessColor.WHITE,'q',chessboard);}
                 else if (a[i][j]=='b'){ChessboardPoint chessboardPoint=new ChessboardPoint(i,j);
                     chessComponents[i][j]=new BishopChessComponent(chessboardPoint,ChessColor.WHITE,'b',chessboard);}
                 else if (a[i][j]=='p'){ChessboardPoint chessboardPoint=new ChessboardPoint(i,j);
                     chessComponents[i][j]=new PawnChessComponent(chessboardPoint,ChessColor.WHITE,'p',chessboard);}
                 else {ChessboardPoint chessboardPoint=new ChessboardPoint(i,j);
                     chessComponents[i][j]=new EmptySlotComponent(chessboardPoint,ChessColor.NONE,'_',chessboard);}
             }
        }
    }


    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public String getChessboardGraph(){
         StringBuilder stringBuilder=new StringBuilder();
         for (int i=0;i<list.size()-1;i++){
             stringBuilder.append(list.get(i));
             stringBuilder.append('\n');
         }
         return stringBuilder.toString();
    }

    public String getCapturedChess(ChessColor player){
        StringBuilder stringBuilder=new StringBuilder();
        int K=0;int Q=0;int R=0;int B=0;int N=0;int P=0;
        int k=0;int q=0;int r=0;int b=0;int n=0;int p=0;
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                if (chessComponents[i][j].getName()=='R'){R++;}
                    else if (chessComponents[i][j].getName()=='N'){N++;}
                    else if (chessComponents[i][j].getName()=='K'){K++;}
                    else if (chessComponents[i][j].getName()=='Q'){Q++;}
                    else if (chessComponents[i][j].getName()=='B'){B++;}
                    else if (chessComponents[i][j].getName()=='P'){P++;}
                    else if (chessComponents[i][j].getName()=='r'){r++;}
                    else if (chessComponents[i][j].getName()=='n'){n++;}
                    else if (chessComponents[i][j].getName()=='k'){k++;}
                    else if (chessComponents[i][j].getName()=='q'){q++;}
                    else if (chessComponents[i][j].getName()=='b'){b++;}
                    else if (chessComponents[i][j].getName()=='p'){p++;}
            }
        }
        if (player==ChessColor.BLACK){
            if (K!=1){stringBuilder.append("K 1");stringBuilder.append('\n');}
            if (Q!=1){stringBuilder.append("Q 1");stringBuilder.append('\n');}
            if (R!=2){stringBuilder.append(String.format("R %d",2-R));stringBuilder.append('\n');}
            if (B!=2){stringBuilder.append(String.format("B %d",2-B));stringBuilder.append('\n');}
            if (N!=2){stringBuilder.append(String.format("N %d",2-N));stringBuilder.append('\n');}
            if (P!=8){stringBuilder.append(String.format("P %d",8-P));stringBuilder.append('\n');}
        }
        else if (player==ChessColor.WHITE){
            if (k!=1){stringBuilder.append("k 1");stringBuilder.append('\n');}
            if (q!=1){stringBuilder.append("q 1");stringBuilder.append('\n');}
            if (r!=2){stringBuilder.append(String.format("r %d",2-r));stringBuilder.append('\n');}
            if (b!=2){stringBuilder.append(String.format("b %d",2-b));stringBuilder.append('\n');}
            if (n!=2){stringBuilder.append(String.format("n %d",2-n));stringBuilder.append('\n');}
            if (p!=8){stringBuilder.append(String.format("p %d",8-p));stringBuilder.append('\n');}
        }
        return stringBuilder.toString();
    }


    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        return chessComponents[source.getX()][source.getY()].canMoveTo();
    }


         public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
        
        int sx=sourceX;int sy=sourceY;int tx=targetX;int ty=targetY;

        List<StringBuilder> location =new ArrayList<>();

        for (int a=0;a<8;a++){
            StringBuilder stringBuilder=new StringBuilder();
            for (int b=0;b<8;b++){stringBuilder.append(chessComponents[a][b].getName());}
            location.add(stringBuilder);}
        
        StringBuilder b=new StringBuilder("b");StringBuilder w=new StringBuilder("w");
        
        if (currentPlayer==ChessColor.WHITE){location.add(new StringBuilder(b));}
        if (currentPlayer==ChessColor.BLACK){location.add(new StringBuilder(w));}

        if (chessComponents[sx][sy].getChessColor()==getCurrentPlayer()) {
            int size=chessComponents[sx][sy].canMoveTo().size();
            
            for (int a= 0; a < size; a++) {
                ChessboardPoint chessboardPoint=new ChessboardPoint(tx,ty);
                if (chessComponents[sx][sy].canMoveTo().get(a).getX() == targetX &&
                    chessComponents[sx][sy].canMoveTo().get(a).getY() == targetY) {

                    location.get(tx).setCharAt(ty,chessComponents[sx][sy].getName());
                    
                    location.get(sx).setCharAt(sy,'_');

                    List<String> game=new ArrayList<>();
                    
                    for (StringBuilder stringBuilder : location) {
                        game.add(stringBuilder.toString());}
                    loadChessGame(game);return true;}
                    }
        }
        return false;
    }
}
