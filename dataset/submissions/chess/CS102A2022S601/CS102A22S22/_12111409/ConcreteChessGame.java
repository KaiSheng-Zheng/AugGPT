import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }

    public ConcreteChessGame(ChessComponent[][] chessComponents, ChessColor currentPlayer) {
        this.chessComponents = chessComponents;
        this.currentPlayer = currentPlayer;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                this.chessComponents[i][j].game=this;
            }
        }
    }

    public void loadChessGame(List<String> chessboard){
        this.chessComponents = new ChessComponent[8][8];
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(chessboard.get(i).charAt(j)=='R'){
                    chessComponents[i][j]=new RookChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'R');
                    }
                if(chessboard.get(i).charAt(j)=='N'){
                    chessComponents[i][j]=new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'N');
                }
                if(chessboard.get(i).charAt(j)=='B'){
                    chessComponents[i][j]=new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'B');
                }
                if(chessboard.get(i).charAt(j)=='Q'){
                    chessComponents[i][j]=new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'Q');
                }
                if(chessboard.get(i).charAt(j)=='K'){
                    chessComponents[i][j]=new KingChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'K');
                }
                if(chessboard.get(i).charAt(j)=='P'){
                    chessComponents[i][j]=new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'P');
                }
                if(chessboard.get(i).charAt(j)=='r'){
                    chessComponents[i][j]=new RookChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'r');
                }
                if(chessboard.get(i).charAt(j)=='n'){
                    chessComponents[i][j]=new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'n');
                }
                if(chessboard.get(i).charAt(j)=='b'){
                    chessComponents[i][j]=new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'b');
                }
                if(chessboard.get(i).charAt(j)=='q'){
                    chessComponents[i][j]=new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'q');
                }
                if(chessboard.get(i).charAt(j)=='k'){
                    chessComponents[i][j]=new KingChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'k');
                }
                if(chessboard.get(i).charAt(j)=='p'){
                    chessComponents[i][j]=new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'p');
                }
                if(chessboard.get(i).charAt(j)=='_'){
                    chessComponents[i][j]=new EmptySlotComponent(new ChessboardPoint(i,j));
                }
            }
        }

        if(chessboard.get(8).charAt(0)=='w'){
            this.currentPlayer = ChessColor.WHITE;
        }
        else if(chessboard.get(8).charAt(0)=='b'){
            this.currentPlayer = ChessColor.BLACK;
        }
        else{
            this.currentPlayer = ChessColor.NONE;
        }

        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                this.chessComponents[i][j].game=this;
            }
        }
    }

    public ChessColor getCurrentPlayer() {
            return this.currentPlayer;
    }

    public String getChessboardGraph(){
        String ans="";
        for(int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ans = ans + chessComponents[i][j].name;
            }
            ans = ans + "\n";
        }
        return ans;
    }

    public String getCapturedChess(ChessColor player){
        String ans="";
        int K=1,k=1;
        int Q=1,q=1;
        int R=2,r=2;
        int B=2,b=2;
        int N=2,n=2;
        int P=8,p=8;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(chessComponents[i][j].name=='K'){
                    K--;
                }
                if(chessComponents[i][j].name=='k'){
                    k--;
                }
                if(chessComponents[i][j].name=='Q'){
                    Q--;
                }
                if(chessComponents[i][j].name=='q'){
                    q--;
                }
                if(chessComponents[i][j].name=='R'){
                    R--;
                }
                if(chessComponents[i][j].name=='r'){
                    r--;
                }
                if(chessComponents[i][j].name=='B'){
                    B--;
                }
                if(chessComponents[i][j].name=='b'){
                    b--;
                }
                if(chessComponents[i][j].name=='N'){
                    N--;
                }
                if(chessComponents[i][j].name=='n'){
                    n--;
                }
                if(chessComponents[i][j].name=='P'){
                    P--;
                }
                if(chessComponents[i][j].name=='p'){
                    p--;
                }
            }
        }
        if(player==ChessColor.BLACK){
            if(K!=0){
                ans = ans + "K " + K + "\n";
            }
            if(Q!=0){
                ans = ans + "Q " + Q + "\n";
            }
            if(R!=0){
                ans = ans + "R " + R + "\n";
            }
            if(B!=0){
                ans = ans + "B " + B + "\n";
            }
            if(N!=0){
                ans = ans + "N " + N + "\n";
            }
            if(P!=0){
                ans = ans + "P " + P + "\n";
            }
            return ans;
        }
        else if(player==ChessColor.WHITE){
            if(k!=0){
                ans = ans + "k " + k + "\n";
            }
            if(q!=0){
                ans = ans + "q " + q + "\n";
            }
            if(r!=0){
                ans = ans + "r " + r + "\n";
            }
            if(b!=0){
                ans = ans + "b " + b + "\n";
            }
            if(n!=0){
                ans = ans + "n " + n + "\n";
            }
            if(p!=0){
                ans = ans + "p " + p + "\n";
            }
            return ans;
        }
        return null;
    }

    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){
        return chessComponents[source.getX()][source.getY()].canMoveTo();
    }

    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
        ChessboardPoint source = new ChessboardPoint(sourceX,sourceY);
        ChessboardPoint target = new ChessboardPoint(targetX,targetY);
        boolean contain = false;
        if(chessComponents[sourceX][sourceY].getChessColor()!=currentPlayer){
            return false;
        }
        List<ChessboardPoint> canMove = getCanMovePoints(source);
        for(int i=0;i<canMove.size();i++){
            if(canMove.get(i).getX()==targetX&&canMove.get(i).getY()==targetY){
                contain = true;
                break;
            }
        }
        if(contain){
            chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
            chessComponents[sourceX][sourceY] = new EmptySlotComponent(source);

            if(currentPlayer.equals(ChessColor.BLACK)){
                currentPlayer = ChessColor.WHITE;
            }else {
                currentPlayer = ChessColor.BLACK;
            }
            chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
            for(int a=0; a<8; a++){
                for(int b=0; b<8; b++){
                    chessComponents[a][b].game = this;
                }
            }
            return true;
        }else {
            return false;
        }
    }
}
