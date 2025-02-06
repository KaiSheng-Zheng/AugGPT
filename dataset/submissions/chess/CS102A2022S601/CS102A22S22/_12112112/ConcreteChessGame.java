import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame {

    private ChessComponent[][] chessComponents=new ChessComponent[8][8];

    private ChessColor currentPlayer;

    public ConcreteChessGame() {

    }

    public ConcreteChessGame(ChessColor currentPlayer){
        this.currentPlayer=currentPlayer;
    }
    public void loadChessGame(List<String> chessboard){

        if (chessboard.get(8).charAt(0)=='w'){
            this.currentPlayer=ChessColor.WHITE;
        }else if (chessboard.get(8).charAt(0)=='b'){
            this.currentPlayer=ChessColor.BLACK;
        }else {
            this.currentPlayer=ChessColor.NONE;
        }
        for (int i=0;i<8;i++) {
            for (int j = 0; j < 8; j++) {
                if (chessboard.get(i).charAt(j)=='R'){
                    chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'R',chessboard);
                }
                if (chessboard.get(i).charAt(j)=='r'){
                    chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'r',chessboard);
                }
                if (chessboard.get(i).charAt(j)=='N'){
                    chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'N',chessboard);
                }
                if (chessboard.get(i).charAt(j)=='n'){
                    chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'n',chessboard);
                }
                if (chessboard.get(i).charAt(j)=='Q'){
                    chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'Q',chessboard);
                }
                if (chessboard.get(i).charAt(j)=='q'){
                    chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'q',chessboard);
                }
                if (chessboard.get(i).charAt(j)=='K'){
                    chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'K',chessboard);
                }
                if (chessboard.get(i).charAt(j)=='k'){
                    chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'k',chessboard);
                }
                if (chessboard.get(i).charAt(j)=='P'){
                    chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'P',chessboard);
                }
                if (chessboard.get(i).charAt(j)=='p'){
                    chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'p',chessboard);
                }
                if (chessboard.get(i).charAt(j)=='B'){
                    chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'B',chessboard);
                }
                if (chessboard.get(i).charAt(j)=='b'){
                    chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'b',chessboard);
                }
                if (chessboard.get(i).charAt(j)=='_'){
                    chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i,j),ChessColor.NONE,'_',chessboard);
                }
            }
        }
    }

    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }
    public String getChessboardGraph(){
        StringBuilder s1=new StringBuilder();
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                s1.append(chessComponents[i][j].name);
            }
            s1.append("\n");
        }
        return s1.toString();
    }
    public String getCapturedChess(ChessColor player){
        int K=1;
        int k=1;
        int Q=1;
        int q=1;
        int R=2;
        int r=2;
        int B=2;
        int b=2;
        int N=2;
        int n=2;
        int P=8;
        int p=8;
        for (int i=0;i<getChessboardGraph().length();i++){
            if (getChessboardGraph().charAt(i)=='K'){
                K--;
            }
            if (getChessboardGraph().charAt(i)=='k'){
                k--;
            }
            if (getChessboardGraph().charAt(i)=='Q'){
                Q--;
            }
            if (getChessboardGraph().charAt(i)=='q'){
                q--;
            }
            if (getChessboardGraph().charAt(i)=='R'){
                R--;
            }
            if (getChessboardGraph().charAt(i)=='r'){
                r--;
            }
            if (getChessboardGraph().charAt(i)=='B'){
                B--;
            }
            if (getChessboardGraph().charAt(i)=='b'){
                b--;
            }
            if (getChessboardGraph().charAt(i)=='N'){
                N--;
            }
            if (getChessboardGraph().charAt(i)=='n'){
                n--;
            }
            if (getChessboardGraph().charAt(i)=='P'){
                P--;
            }
            if (getChessboardGraph().charAt(i)=='p'){
                p--;
            }
        }

        StringBuilder b1=new StringBuilder();

            if (player==ChessColor.BLACK){
                if (K!=0){
                    b1.append("K ");
                    b1.append(K);
                    b1.append("\n");
                }
                if (Q!=0){
                    b1.append("Q ");
                    b1.append(Q);
                    b1.append("\n");
                }
                if (R!=0){
                    b1.append("R ");
                    b1.append(R);
                    b1.append("\n");
                }
                if (B!=0){
                    b1.append("B ");
                    b1.append(B);
                    b1.append("\n");
                }
                if (N!=0){
                    b1.append("N ");
                    b1.append(N);
                    b1.append("\n");
                }
                if (P!=0){
                    b1.append("P ");
                    b1.append(P);
                    b1.append("\n");
                }
            }
            if (player==ChessColor.WHITE){
                if (k!=0){
                    b1.append("k ");
                    b1.append(k);
                    b1.append("\n");
                }
                if (q!=0){
                    b1.append("q ");
                    b1.append(q);
                    b1.append("\n");
                }
                if (r!=0){
                    b1.append("r ");
                    b1.append(r);
                    b1.append("\n");
                }
                if (b!=0){
                    b1.append("b ");
                    b1.append(b);
                    b1.append("\n");
                }
                if (n!=0){
                    b1.append("n ");
                    b1.append(n);
                    b1.append("\n");
                }
                if (p!=0){
                    b1.append("p ");
                    b1.append(p);
                    b1.append("\n");

            }
        }
        return b1.toString();
    }




    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        int x=source.getX();
        int y=source.getY();
        return chessComponents[x][y].canMoveTo();
    }
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
        ArrayList<StringBuilder> s=new ArrayList<>();
        for (int i=0;i<8;i++){
            StringBuilder s1=new StringBuilder();
            for (int j=0;j<8;j++){
                s1.append(chessComponents[i][j].name);
            }
            s.add(s1);
        }
        if (currentPlayer==ChessColor.WHITE){
            s.add(new StringBuilder("b"));
        }else if (currentPlayer==ChessColor.BLACK){
            s.add(new StringBuilder("w"));
        }
        if (chessComponents[sourceX][sourceY].getChessColor()==currentPlayer) {
            for (int i = 0; i < chessComponents[sourceX][sourceY].canMoveTo().size(); i++) {
                if (chessComponents[sourceX][sourceY].canMoveTo().get(i).getX() == targetX && chessComponents[sourceX][sourceY].canMoveTo().get(i).getY() == targetY) {
                    s.get(targetX).setCharAt(targetY,chessComponents[sourceX][sourceY].name);
                    s.get(sourceX).setCharAt(sourceY,'_');
                    ArrayList<String> a=new ArrayList<>();
                    for (int j=0;j<s.size();j++){
                        a.add(s.get(j).toString());
                    }
                    chessComponents[targetX][targetY] = new EmptySlotComponent(new ChessboardPoint(targetX, targetY), ChessColor.NONE, '_',a );
                    chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX, sourceY), chessComponents[sourceX][sourceY].getChessColor(), chessComponents[sourceX][sourceY].name, a);
                    loadChessGame(a);
                    return true;
                }
            }
        }
        return false;
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

}
