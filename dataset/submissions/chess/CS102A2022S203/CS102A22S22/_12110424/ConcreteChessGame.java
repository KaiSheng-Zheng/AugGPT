import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    // A 2-dimension array to store all the chess components
// should be initialized in your construct method.
// i.e. = new ChessComponent[8][8]
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    // What's the current player's color, black or white?
// should be initialized in your construct method.
// by default, set the color to white.
    private ChessColor currentPlayer;


    public void loadChessGame(List<String> chessboard){
        for (int n =0;n<8;n++){
            for (int n1 =0;n1<8;n1++){
                switch (chessboard.get(n).charAt(n1)){
                    case 'K' :
                        chessComponents[n][n1]=new KingChessComponent(n,n1,ChessColor.BLACK,'K');
                        break;
                    case 'Q' :
                        chessComponents[n][n1]=new QueenChessComponent(n,n1,ChessColor.BLACK,'Q');
                        break;
                    case 'R' :
                        chessComponents[n][n1]=new RookChessComponent(n,n1,ChessColor.BLACK,'R');
                        break;
                    case 'B' :
                        chessComponents[n][n1]=new BishopChessComponent(n,n1,ChessColor.BLACK,'B');
                        break;
                    case 'N' :
                        chessComponents[n][n1]=new KnightChessComponent(n,n1,ChessColor.BLACK,'N');
                        break;
                    case 'P' :
                        chessComponents[n][n1]=new PawnChessComponent(n,n1,ChessColor.BLACK,'P');
                        break;
                    case 'k' :
                        chessComponents[n][n1]=new KingChessComponent(n,n1,ChessColor.WHITE,'k');
                        break;
                    case 'q' :
                        chessComponents[n][n1]=new QueenChessComponent(n,n1,ChessColor.WHITE,'q');
                        break;
                    case 'r' :
                        chessComponents[n][n1]=new RookChessComponent(n,n1,ChessColor.WHITE,'r');
                        break;
                    case 'b' :
                        chessComponents[n][n1]=new BishopChessComponent(n,n1,ChessColor.WHITE,'b');
                        break;
                    case 'n' :
                        chessComponents[n][n1]=new KnightChessComponent(n,n1,ChessColor.WHITE,'n');
                        break;
                    case 'p' :
                        chessComponents[n][n1]=new PawnChessComponent(n,n1,ChessColor.WHITE,'p');
                        break;
                    case '_':
                        chessComponents[n][n1]=new EmptySlotComponent(n,n1,ChessColor.NONE,'_');
                        break;
                }
                chessComponents[n][n1].setComponents(chessComponents);
            }
        }
        if (chessboard.get(8).equals("w")){
            this.currentPlayer=ChessColor.WHITE;
        } else this.currentPlayer=ChessColor.BLACK;
        componentToChess();
    }
    public ChessColor getCurrentPlayer(){
        return this.currentPlayer;
    }
    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }
    public String getChessboardGraph(){
        StringBuilder a = new StringBuilder("");
        for (int n=0;n<8;n++){
            for (int n1=0;n1<8;n1++){
                a.append(chessComponents[n][n1]);
                if (n1==7&&n!=7){
                    a.append("\n");
                }
            }
        }
        return a.toString();
    }
    public String getCapturedChess(ChessColor player){
        int K=1,Q=1,R=2,B=2,N=2,P=8;
        for (int n=0;n<8;n++){
            for (int n1=0;n1<8;n1++){
                if (chessComponents[n][n1].getChessColor().equals(player)){
                    if (chessComponents[n][n1].getName()=='k'||chessComponents[n][n1].getName()=='K'){
                        K--;
                    } else if (chessComponents[n][n1].getName()=='q'||chessComponents[n][n1].getName()=='Q'){
                        Q--;
                    } else if (chessComponents[n][n1].getName()=='r'||chessComponents[n][n1].getName()=='R'){
                        R--;
                    } else if (chessComponents[n][n1].getName()=='b'||chessComponents[n][n1].getName()=='B'){
                        B--;
                    } else if (chessComponents[n][n1].getName()=='n'||chessComponents[n][n1].getName()=='N'){
                        N--;
                    } else if (chessComponents[n][n1].getName()=='p'||chessComponents[n][n1].getName()=='P'){
                        P--;
                    }
                }
            }
        }
        StringBuilder a = new StringBuilder();
        if (player==ChessColor.BLACK) {
            if (K != 0) {
                a.append("K ");
                a.append(K);
                a.append("\n");
            }
            if (Q != 0) {
                a.append("Q ");
                a.append(Q);
                a.append("\n");
            }
            if (R != 0) {
                a.append("R ");
                a.append(R);
                a.append("\n");
            }
            if (B != 0) {
                a.append("B ");
                a.append(B);
                a.append("\n");
            }
            if (N != 0) {
                a.append("N ");
                a.append(N);
                a.append("\n");
            }
            if (P != 0) {
                a.append("P ");
                a.append(P);
                a.append("\n");
            }
        } else {
            if (K != 0) {
                a.append("k ");
                a.append(K);
                a.append("\n");
            }
            if (Q != 0) {
                a.append("q ");
                a.append(Q);
                a.append("\n");
            }
            if (R != 0) {
                a.append("r ");
                a.append(R);
                a.append("\n");
            }
            if (B != 0) {
                a.append("b ");
                a.append(B);
                a.append("\n");
            }
            if (N != 0) {
                a.append("n ");
                a.append(N);
                a.append("\n");
            }
            if (P != 0) {
                a.append("p ");
                a.append(P);
                a.append("\n");
            }
        }
        return a.toString();
    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        // 1. find chess according to source
        // 2. as below statement:
        // 3. sort canMovePoints by x - y ascending order
        
        List<ChessboardPoint> getCanMovePoint = new ArrayList<>();
        for (int n =0;n<8;n++){
            for (int n1 =0;n1<8;n1++){
                for (ChessboardPoint a :chessComponents[source.getX()][source.getY()].canMoveTo()){
                    if (a.getX()==n&&a.getY()==n1){
                        getCanMovePoint.add(a);
                    }
                }

            }
        }
        return getCanMovePoint;
    }
    public boolean xy(int sourceX, int sourceY,int targetX, int targetY) {
        for (ChessboardPoint a : chessComponents[sourceX][sourceY].canMoveTo()){
            if (a.getX()==targetX&&a.getY()==targetY){
                return true;
            }
        }
        return false;
    }
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
        if (chessComponents[sourceX][sourceY].getChessColor()==currentPlayer&&xy(sourceX,sourceY,targetX,targetY)){
            chessComponents[targetX][targetY]=chessComponents[sourceX][sourceY];
            chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
            chessComponents[sourceX][sourceY]=new EmptySlotComponent(sourceX,sourceY,ChessColor.NONE,'_');
            componentToChess();
            if (currentPlayer==ChessColor.BLACK){
                currentPlayer=ChessColor.WHITE;
            } else currentPlayer=ChessColor.BLACK;
            return true;
        }
        return false;
    }
    public void componentToChess(){
        for (ChessComponent []a :chessComponents){
            for (ChessComponent b :a){
                b.setComponents(chessComponents);
            }
        }
    }

}