import java.util.ArrayList;
import java.util.List;


public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents =new ChessComponent[8][8];
    private ChessColor currentPlayer=ChessColor.WHITE;

   public void loadChessGame(List<String> chessboard){
       for (int i=0;i<8;i++){
           for (int j=0;j<8;j++){
               if (chessboard.get(i).charAt(j)=='R'){
                   chessComponents[i][j]=new RookChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'R');//.chessboard.get(i).charAt(j);
               }
               else if (chessboard.get(i).charAt(j)=='r'){
                   chessComponents[i][j]=new RookChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'r');
               }
               else if (chessboard.get(i).charAt(j)=='N'){
                   chessComponents[i][j]= new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'N');
               }
               else if (chessboard.get(i).charAt(j)=='n'){
                   chessComponents[i][j]= new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'n');
               }
               else if (chessboard.get(i).charAt(j)=='B'){
                   chessComponents[i][j]= new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'B');
               }
               else if (chessboard.get(i).charAt(j)=='b'){
                   chessComponents[i][j]= new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'b');
               }
               else if (chessboard.get(i).charAt(j)=='Q'){
                   chessComponents[i][j]= new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'Q');
               }
               else if (chessboard.get(i).charAt(j)=='q'){
                   chessComponents[i][j]= new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'q');
               }
               else if (chessboard.get(i).charAt(j)=='K'){
                   chessComponents[i][j]= new KingChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'K');
               }
               else if (chessboard.get(i).charAt(j)=='k'){
                   chessComponents[i][j]= new KingChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'k');
               }
               else if (chessboard.get(i).charAt(j)=='P'){
                   chessComponents[i][j]= new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'P');
               }
               else if (chessboard.get(i).charAt(j)=='p'){
                   chessComponents[i][j]= new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'p');
               }
               else if (chessboard.get(i).charAt(j)=='_'){
                   chessComponents[i][j]= new EmptySlotComponent(new ChessboardPoint(i,j),ChessColor.NONE,'_');
               }
           }
       }
       if (chessboard.get(8).charAt(0)=='w'){
           currentPlayer = ChessColor.WHITE;
       }
       else if (chessboard.get(8).charAt(0)=='b'){
           currentPlayer =ChessColor.BLACK;
       }
    }

    public ChessColor getCurrentPlayer() {
        return this.currentPlayer; }


    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }


    public String getChessboardGraph(){
       StringBuilder ChessboardGraph = new StringBuilder();
       for (int i=0;i<8;i++){
           for (int j=0;j<8;j++){
               ChessboardGraph.append(chessComponents[i][j].name);

           }
           ChessboardGraph.append("\n");
       }
       String str="";
       for (int i=0;i<ChessboardGraph.length();i++){
           str= str + ChessboardGraph.charAt(i);
       }
       return str;

    }


    public String getCapturedChess(ChessColor player) {
       int B =2;
       int b =2;
       int Q =1;
       int q =1;
       int P =8;
       int p =8;
       int K =1;
       int k =1;
       int R =2;
       int r =2;
       int N =2;
       int n =2;
        StringBuilder ChessboardGraph =new StringBuilder();
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                if (chessComponents[i][j].name!='_'){
                    ChessboardGraph.append(chessComponents[i][j].name);}

            }
        }

        for (int i=0;i<ChessboardGraph.length();i++){
            if (ChessboardGraph.charAt(i)=='B'){
                B=B-1;
            }
            else if (ChessboardGraph.charAt(i)=='b'){
                b=b-1;
            }
            else if (ChessboardGraph.charAt(i)=='Q'){
                Q=Q-1;
            }
            else if (ChessboardGraph.charAt(i)=='q'){
                q=q-1;
            }
            else if (ChessboardGraph.charAt(i)=='P'){
                P=P-1;
            }
            else if (ChessboardGraph.charAt(i)=='p'){
                p=p-1;
            }
            else if (ChessboardGraph.charAt(i)=='K'){
                K=K-1;
            }
            else if (ChessboardGraph.charAt(i)=='k'){
                k=k-1;
            }
            else if (ChessboardGraph.charAt(i)=='R'){
                R=R-1;
            }
            else if (ChessboardGraph.charAt(i)=='r'){
                r=r-1;
            }
            else if (ChessboardGraph.charAt(i)=='N'){
                N=N-1;
            }
            else if (ChessboardGraph.charAt(i)=='n'){
                n=n-1;
            }
        }
        //kqrbnp
        ArrayList<String> capture =new ArrayList<>();
        if (player==ChessColor.WHITE){
            if (k!=0){
                capture.add("k "+k+"\n");
            }
            if (q!=0){
                capture.add("q "+q+"\n");
            }
            if (r!=0){
                capture.add("r "+r+"\n");
            }
            if (b!=0){
                capture.add("b "+b+"\n");
            }
            if (n!=0){
                capture.add("n "+n+"\n");
            }
            if (p!=0){
                capture.add("p "+p+"\n");
            }

        }else if (player==ChessColor.BLACK){
            if (K!=0){
                capture.add("K "+K+"\n");
            }
            if (Q!=0){
                capture.add("Q "+Q+"\n");
            }
            if (R!=0){
                capture.add("R "+R+"\n");
            }
            if (B!=0){
                capture.add("B "+B+"\n");
            }
            if (N!=0){
                capture.add("N "+N+"\n");
            }
            if (P!=0){
                capture.add("P "+P+"\n");
            }
        }
        String str="";
        for (int i=0;i<capture.size();i++){
            str= str +capture.get(i);
        }
        return str;
    }
    public boolean moveChess(int sourceX, int sourceY, int targetX, int
            targetY){
       ChessComponent b[][] =new ChessComponent[8][8];
       int a=0;
       for (int i=0;i<getCanMovePoints(chessComponents[sourceX][sourceY].getSource()).size();i++) {
           if (getCanMovePoints(chessComponents[sourceX][sourceY].getSource()).get(i).getX()==targetX &&
                   getCanMovePoints(chessComponents[sourceX][sourceY].getSource()).get(i).getY()==targetY
           && chessComponents[sourceX][sourceY].getChessColor()==currentPlayer){
               b[sourceX][sourceY]=chessComponents[sourceX][sourceY];
               chessComponents[sourceX][sourceY]=chessComponents[targetX][targetY];
               chessComponents[targetX][targetY]=b[sourceX][sourceY];
               a++;
           }
       }
        if (a==1){
            if (currentPlayer ==ChessColor.WHITE){
                currentPlayer=ChessColor.BLACK;
            }else if (currentPlayer==ChessColor.BLACK){
                currentPlayer=ChessColor.WHITE;}
            return true;
        }else return false;
    }
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){
        // 1. find chess according to source

        // 2. as below statement:
        List<ChessboardPoint> canMovePoints = chessComponents[source.getX()][source.getY()].canMoveTo();
        // 3.sort canMovePoints by x - y ascending order
        return canMovePoints;
    }

    /*public static void main(String[] args) {
       ConcreteChessGame jb =new ConcreteChessGame();
       String sb= jb.getCapturedChess(ChessColor.WHITE);
        System.out.printf("%f",sb);

    }
     */

}
