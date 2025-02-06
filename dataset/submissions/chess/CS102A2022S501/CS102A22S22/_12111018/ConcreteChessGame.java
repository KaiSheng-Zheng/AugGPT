import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;
    static ChessComponent[][] chessComponents2=new ChessComponent[8][8];
    public ConcreteChessGame(){
        this.chessComponents=new ChessComponent[8][8];
        this.currentPlayer=ChessColor.WHITE;
    }
    public void loadChessGame(List<String> chessboard){
        switch (chessboard.get(8).charAt(0)){
            case 'w':
                this.currentPlayer=ChessColor.WHITE;break;
            case 'b' :
                this.currentPlayer=ChessColor.BLACK;break;
        }
        for (int i=0;i<chessboard.size()-1;i++){
            for (int j=0;j<chessboard.get(i).length();j++){
                switch (chessboard.get(i).charAt(j)){
                    case'R':
                        chessComponents[i][j]=new RookChessComponent(i,j,ChessColor.BLACK,'R');
                        break;
                    case'r':
                        chessComponents[i][j]=new RookChessComponent(i,j,ChessColor.WHITE,'r');
                        break;
                    case 'N':
                        chessComponents[i][j]=new KnightChessComponent(i,j,ChessColor.BLACK,'N');
                        break;
                    case 'n':
                        chessComponents[i][j]=new KnightChessComponent(i,j,ChessColor.WHITE,'n');
                        break;
                    case 'B':
                        chessComponents[i][j]=new BishopChessComponent(i,j,ChessColor.BLACK,'B');
                        break;
                    case 'b':
                        chessComponents[i][j]=new BishopChessComponent(i,j,ChessColor.WHITE,'b');
                        break;
                    case 'Q':
                        chessComponents[i][j]=new QueenChessComponent(i,j,ChessColor.BLACK,'Q');
                        break;
                    case 'q':
                        chessComponents[i][j]=new QueenChessComponent(i,j,ChessColor.WHITE,'q');
                        break;
                    case 'K':
                        chessComponents[i][j]=new KingChessComponent(i,j,ChessColor.BLACK,'K');
                        break;
                    case 'k':
                        chessComponents[i][j]=new KingChessComponent(i,j,ChessColor.WHITE,'k');
                        break;
                    case 'P':
                        chessComponents[i][j]=new PawnChessComponent(i,j,ChessColor.BLACK,'P');
                        break;
                    case 'p':
                        chessComponents[i][j]=new PawnChessComponent(i,j,ChessColor.WHITE,'p');
                        break;
                    default:
                        chessComponents[i][j]=new EmptySlotComponent(i,j,ChessColor.NONE,'_');
                        break;
                }
            }
            chessComponents2=chessComponents;
        }
    }

    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }


    public String getChessboardGraph(){
        StringBuilder s1=new StringBuilder();
        StringBuilder s2=new StringBuilder();
        StringBuilder s3=new StringBuilder();
        StringBuilder s4=new StringBuilder();
        StringBuilder s5=new StringBuilder();
        StringBuilder s6=new StringBuilder();
        StringBuilder s7=new StringBuilder();
        StringBuilder s8=new StringBuilder();
        for (int i=0;i<8;i++){
            s1.append(chessComponents[0][i].getName());
        }
        for (int i=0;i<8;i++){
            s2.append(chessComponents[1][i].getName());
        }
        for (int i=0;i<8;i++){
            s3.append(chessComponents[2][i].getName());
        }
        for (int i=0;i<8;i++){
            s4.append(chessComponents[3][i].getName());
        }
        for (int i=0;i<8;i++){
            s5.append(chessComponents[4][i].getName());
        }
        for (int i=0;i<8;i++){
            s6.append(chessComponents[5][i].getName());
        }
        for (int i=0;i<8;i++){
            s7.append(chessComponents[6][i].getName());
        }
        for (int i=0;i<8;i++){
            s8.append(chessComponents[7][i].getName());
        }

        return String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s",s1.toString(),s2.toString(),s3.toString(),s4.toString(),s5.toString(),s6.toString(),s7.toString(),s8.toString());
    }


    public String getCapturedChess(ChessColor player){
        int R=0; int r=0; int N=0 ;int n=0;int B=0; int b=0;
        int Q=0; int q=0; int K=0; int k=0; int P=0;int p=0;
        for (int i=0;i<8;i++){
            for (int j=0;j<chessComponents[i].length;j++){
                switch (chessComponents[i][j].getName()){
                    case 'R':
                        R++;break;
                    case 'r':
                        r++;break;
                    case 'N':
                        N++;break;
                    case 'n':
                        n++;break;
                    case 'B':
                        B++;break;
                    case 'b':
                        b++;break;
                    case 'Q':
                        Q++;break;
                    case 'q':
                        q++;break;
                    case 'K':
                        K++;break;
                    case 'k':
                        k++;break;
                    case 'P':
                        P++;break;
                    case 'p':
                        p++;break;
                }
            }
        }
        StringBuilder result=new StringBuilder();
        if (player==ChessColor.BLACK){
            if (K!=1){
                String s="K 1\n";
                result.append(s);
            }
            if (Q!=1){
                String s="Q 1\n";
                result.append(s);
            }
            if (R!=2){
                String s=String.format("R %d\n",2-R);
                result.append(s);
            }
            if (B!=2){
                String s=String.format("B %d\n",2-B);
                result.append(s);
            }
            if (N!=2){
                String s=String.format("N %d\n",2-N);
                result.append(s);
            }
            if (P!=8){
                String s=String.format("P %d\n",8-P);
                result.append(s);
            }
            return result.toString();
        }
        else {
            if (k!=1){
                String s=String.format("k 1\n");
                result.append(s);
            }
            if (q!=1){
                String s=String.format("q 1\n");
                result.append(s);
            }
            if (r!=2){
                String s=String.format("r %d\n",2-r);
                result.append(s);
            }
            if (b!=2){
                String s=String.format("b %d\n",2-b);
                result.append(s);
            }
            if (n!=2){
                String s=String.format("n %d\n",2-n);
                result.append(s);
            }
            if (p!=8){
                String s=String.format("p %d\n",8-p);
                result.append(s);
            }
            return result.toString();
        }
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess=this.getChess(source.getX(),source.getY());
        List<ChessboardPoint>canMovePoints=chess.canMoveTo();
        Collections.sort(canMovePoints, new Comparator<ChessboardPoint>() {
            @Override
            public int compare(ChessboardPoint o1, ChessboardPoint o2) {
                if (o1.getX()!=o2.getX()){
                    return o1.getX()-o2.getX();
                }
                else {
                    return o1.getY()-o2.getY();
                }
            }
        });
        return canMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessComponent chess=this.getChess(sourceX,sourceY);
        int p=0;
        for (int i=0;i<chess.canMoveTo().size();i++){
            int a=chess.canMoveTo().get(i).getX();
            int b=chess.canMoveTo().get(i).getY();
            if (a==targetX&&b==targetY){
                p++;break;
            }
        }
        boolean a=p!=0&&chess.getChessColor()==this.currentPlayer;
        if (a){
            chessComponents[targetX][targetY]=chess;
            chessComponents2[targetX][targetY]=chess;
            chessComponents[targetX][targetY].setSource(targetX,targetY);
            chessComponents2[targetX][targetY].setSource(targetX,targetY);
            chessComponents[sourceX][sourceY]=new EmptySlotComponent(sourceX,sourceY,ChessColor.NONE,'_');
            chessComponents2[sourceX][sourceY]=new EmptySlotComponent(sourceX,sourceY,ChessColor.NONE,'_');
            if (this.currentPlayer==ChessColor.BLACK){
                this.currentPlayer=ChessColor.WHITE;
            }
            else {
                this.currentPlayer=ChessColor.BLACK;
            }
        }
        return a;
    }

    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }

    }


