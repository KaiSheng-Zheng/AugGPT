import java.util.*;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents=new ChessComponent[8][8];
    private ChessColor currentPlayer=ChessColor.WHITE;

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }
    public ConcreteChessGame(ChessComponent[][] chessComponents,ChessColor currentPlayer){
        this.chessComponents=chessComponents;
        this.currentPlayer=currentPlayer;
    }
    public ConcreteChessGame(){

    }
    @Override
    public void loadChessGame(List<String> chessboard){
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                if (chessboard.get(i).charAt(j)=='N'){
                    chessComponents[i][j]=new KnightChessComponent(i,j,ChessColor.BLACK);
                }
                if (chessboard.get(i).charAt(j)=='B'){
                    chessComponents[i][j]=new BishopChessComponent(i,j,ChessColor.BLACK);

                }
                if (chessboard.get(i).charAt(j)=='Q'){
                    chessComponents[i][j]=new QueenChessComponent(i,j,ChessColor.BLACK);
                }
                if (chessboard.get(i).charAt(j)=='K'){
                    chessComponents[i][j]=new KingChessComponent(i,j,ChessColor.BLACK);
                }
                if (chessboard.get(i).charAt(j)=='P'){
                    chessComponents[i][j]=new PawnChessComponent(i,j,ChessColor.BLACK);
                }
                if (chessboard.get(i).charAt(j)=='R'){
                    chessComponents[i][j]=new RookChessComponent(i,j,ChessColor.BLACK);
                }
                if (chessboard.get(i).charAt(j)=='r'){
                    chessComponents[i][j]=new RookChessComponent(i,j,ChessColor.WHITE);
                }
                if (chessboard.get(i).charAt(j)=='n'){
                    chessComponents[i][j]=new KnightChessComponent(i,j,ChessColor.WHITE);
                }
                if (chessboard.get(i).charAt(j)=='b'){
                    chessComponents[i][j]=new BishopChessComponent(i,j,ChessColor.WHITE);
                }
                if (chessboard.get(i).charAt(j)=='q'){
                    chessComponents[i][j]=new QueenChessComponent(i,j,ChessColor.WHITE);
                }

                if (chessboard.get(i).charAt(j)=='k'){
                    chessComponents[i][j]=new KingChessComponent(i,j,ChessColor.WHITE);

                }
                if (chessboard.get(i).charAt(j)=='p'){
                    chessComponents[i][j]=new PawnChessComponent(i,j,ChessColor.WHITE);
                }
                if (chessboard.get(i).charAt(j)=='_'){
                    chessComponents[i][j]=new EmptySlotComponent(i,j);
                }
            }
        }
        if (chessboard.get(8).charAt(0)=='w'){
            currentPlayer= ChessColor.WHITE;
        }
        if (chessboard.get(8).charAt(0)=='b'){
            currentPlayer= ChessColor.BLACK;
        }
    }
    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }


    @Override
    public String getChessboardGraph() {
        StringBuilder str=new StringBuilder();
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                str.append(chessComponents[i][j].getName());
            }
            str.append('\n');
        }
        return str.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        StringBuilder str=new StringBuilder();
        int R=2;
        int N=2;
        int B=2;
        int Q=1;
        int K=1;
        int P=8;
        int r=2;
        int n=2;
        int b=2;
        int q=1;
        int k=1;
        int p=8;
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                if (chessComponents[i][j].getName()=='R'){
                    R--;
                }
                if (chessComponents[i][j].getName()=='N'){
                    N--;
                }
                if (chessComponents[i][j].getName()=='B') {
                    B--;
                }
                if (chessComponents[i][j].getName()=='K') {
                    K--;
                }
                if (chessComponents[i][j].getName()=='Q') {
                        Q--;
                }
                if (chessComponents[i][j].getName()=='P') {
                        P--;
                }
                if (chessComponents[i][j].getName()=='r') {
                        r--;
                }
                if (chessComponents[i][j].getName()=='n') {
                        n--;
                }
                if (chessComponents[i][j].getName()=='b') {
                        b--;
                }
                if (chessComponents[i][j].getName()=='q') {
                        q--;
                }
                if (chessComponents[i][j].getName()=='k') {
                        k--;
                }
                if (chessComponents[i][j].getName()=='p') {
                        p--;
                }
            }
        }
        if (player== ChessColor.WHITE){
            if (k!=0){
                str.append("k ").append(k).append("\n");
            }
            if (q!=0){
                str.append("q ").append(q).append("\n");
            }
            if (r!=0){
                str.append("r ").append(r).append("\n");
            }
            if (b!=0){
                str.append("b ").append(b).append("\n");
            }
            if (n!=0){
                str.append("n ").append(n).append("\n");
            }
            if (p!=0){
                str.append("p ").append(p).append("\n");
            }
        }
        if (player== ChessColor.BLACK){
            if (K!=0){
                str.append("K ").append(K).append("\n");
            }
            if (Q!=0){
                str.append("Q ").append(Q).append("\n");
            }
            if (R!=0){
                str.append("R ").append(R).append("\n");
            }
            if (B!=0){
                str.append("B ").append(B).append("\n");
            }
            if (N!=0){
                str.append("N ").append(N).append("\n");
            }
            if (P!=0){
                str.append("P ").append(P).append("\n");
            }
        }
        return str.toString();
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) throws CloneNotSupportedException {
        if (getCurrentPlayer()!= chessComponents[sourceX][sourceY].getChessColor()) {
            return false;
        }
        chessComponents[sourceX][sourceY].setChessComponents(chessComponents);
        List<ChessboardPoint> chessboardPoints=chessComponents[sourceX][sourceY].canMoveTo();
        for (ChessboardPoint a:chessboardPoints){
            if (a.getX()==targetX&&a.getY()==targetY){
                chessComponents[targetX][targetY]= (ChessComponent) chessComponents[sourceX][sourceY].clone();
                chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
                chessComponents[sourceX][sourceY]=new EmptySlotComponent(sourceX,sourceY);
                currentPlayer= currentPlayer==ChessColor.WHITE?ChessColor.BLACK:ChessColor.WHITE;
                return true;
            }
        }
        return false;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess=getChess(source.getX(),source.getY());
        chess.setChessComponents(chessComponents);
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        return canMovePoints;
    }

    @Override
    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }
}