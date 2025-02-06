import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    // A 2-dimension array to store all the chess components
    // should be initialized in your construct method.
    // i.e. = new ChessComponent[8][8]
    private ChessComponent[][] chessComponents=new ChessComponent[8][8];
    // What's the current player's color, black or white?
    // should be initialized in your construct method.
    // by default, set0 the color to white.
    private ChessColor currentPlayer=ChessColor.WHITE;

//    public ConcreteChessGame(){
//        chessComponents=new ChessComponent[8][8];
//        currentPlayer=ChessColor.WHITE;
//    }
    public static ChessComponent[][] chessComponent2 = new ChessComponent[8][8];

    @Override
    public void loadChessGame(List<String> chessboard){
        for (int i=0;i<chessboard.size()-1;i++){
            for (int m=0;m<chessboard.get(i).length();m++){
                 String temp=chessboard.get(i).substring(m,m+1);
                 if (temp.equals("R")){
                     chessComponents[i][m]=new RookChessComponent(new ChessboardPoint(i,m),ChessColor.BLACK,'R');
                 }
                 else if (temp.equals("N"))
                     chessComponents[i][m]=new KnightChessComponent(new ChessboardPoint(i,m),ChessColor.BLACK,'N');
                 else if (temp.equals("B"))
                     chessComponents[i][m]=new BishopChessComponent(new ChessboardPoint(i,m),ChessColor.BLACK,'B');
                 else if (temp.equals("Q"))
                     chessComponents[i][m]=new QueenChessComponent(new ChessboardPoint(i,m),ChessColor.BLACK,'Q');
                 else if (temp.equals("K"))
                     chessComponents[i][m]=new KingChessComponent(new ChessboardPoint(i,m),ChessColor.BLACK,'K');
                 else if (temp.equals("P"))
                     chessComponents[i][m]=new PawnChessComponent(new ChessboardPoint(i,m),ChessColor.BLACK,'P');
                 else if (temp.equals("r"))
                     chessComponents[i][m]=new RookChessComponent(new ChessboardPoint(i,m),ChessColor.WHITE,'r');
                 else if (temp.equals("n"))
                     chessComponents[i][m]=new KnightChessComponent(new ChessboardPoint(i,m),ChessColor.WHITE,'n');
                 else if (temp.equals("b"))
                     chessComponents[i][m]=new BishopChessComponent(new ChessboardPoint(i,m),ChessColor.WHITE,'b');
                 else if (temp.equals("q"))
                     chessComponents[i][m]=new QueenChessComponent(new ChessboardPoint(i,m),ChessColor.WHITE,'q');
                 else if (temp.equals("k"))
                     chessComponents[i][m]=new KingChessComponent(new ChessboardPoint(i,m),ChessColor.WHITE,'k');
                 else if (temp.equals("p"))
                     chessComponents[i][m]=new PawnChessComponent(new ChessboardPoint(i,m),ChessColor.WHITE,'p');
                 else
                     chessComponents[i][m]=new EmptySlotComponent(new ChessboardPoint(i,m),ChessColor.NONE,'_');
            }
        }
        chessComponent2=chessComponents;
        char temp1=chessboard.get(8).charAt(0);
        if (temp1=='w')
            currentPlayer=ChessColor.WHITE;
        else if (temp1=='b')
            currentPlayer=ChessColor.BLACK;
    }



    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer; }

    @Override
    public String getChessboardGraph(){
        StringBuilder str=new StringBuilder();
        for (int i=0;i<8;i++){
            for (int m=0;m<8;m++){
                str.append(chessComponents[i][m].toString());
                }
            str.append("\n");
        }
        return str.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player){
        StringBuilder str=new StringBuilder();
        int R=0,r=0,N=0,n=0,B=0,b=0,K=0,k=0,P=0,p=0,Q=0,q=0,E=0;
        for (int i=0;i<8;i++){
            for (int m=0;m<8;m++){
                if (chessComponents[i][m] instanceof EmptySlotComponent && chessComponents[i][m].getChessColor()==ChessColor.NONE)
                    E++;
                else if (chessComponents[i][m] instanceof KnightChessComponent && chessComponents[i][m].getChessColor()==ChessColor.BLACK)
                    N++;
                else if (chessComponents[i][m] instanceof BishopChessComponent && chessComponents[i][m].getChessColor()==ChessColor.BLACK)
                    B++;
                else if (chessComponents[i][m] instanceof KingChessComponent && chessComponents[i][m].getChessColor()==ChessColor.BLACK)
                    K++;
                else if (chessComponents[i][m] instanceof PawnChessComponent && chessComponents[i][m].getChessColor()==ChessColor.BLACK)
                    P++;
                else if (chessComponents[i][m] instanceof QueenChessComponent && chessComponents[i][m].getChessColor()==ChessColor.BLACK)
                    Q++;
                else if (chessComponents[i][m] instanceof RookChessComponent && chessComponents[i][m].getChessColor()==ChessColor.BLACK)
                    R++;
                else if (chessComponents[i][m] instanceof KnightChessComponent && chessComponents[i][m].getChessColor()==ChessColor.WHITE)
                    n++;
                else if (chessComponents[i][m] instanceof BishopChessComponent && chessComponents[i][m].getChessColor()==ChessColor.WHITE)
                    b++;
                else if (chessComponents[i][m] instanceof KingChessComponent && chessComponents[i][m].getChessColor()==ChessColor.WHITE)
                    k++;
                else if (chessComponents[i][m] instanceof PawnChessComponent && chessComponents[i][m].getChessColor()==ChessColor.WHITE)
                    p++;
                else if (chessComponents[i][m] instanceof QueenChessComponent && chessComponents[i][m].getChessColor()==ChessColor.WHITE)
                    q++;
                else if (chessComponents[i][m] instanceof RookChessComponent && chessComponents[i][m].getChessColor()==ChessColor.WHITE)
                    r++;

            }
        }

        if (player==ChessColor.BLACK) {
            if (K == 0)
                str.append("K 1\n");

            if (Q == 0)
                str.append("Q 1\n");

            if (R == 1)
                str.append("R 1\n");
            else if (R == 0)
                str.append("R 2\n");

            if (B == 1)
                str.append("B 1\n");
            else if (B == 0)
                str.append("B 2\n");

            if (N == 1)
                str.append("N 1\n");
            else if (N == 0)
                str.append("N 2\n");

            if (P < 8){
                int m=8-P;
                str.append("P ");
                str.append(m);
                str.append("\n");
            }

        }

        if (player==ChessColor.WHITE) {
            if (k == 0)
                str.append("k 1\n");

            if (q == 0)
                str.append("q 1\n");

            if (r == 1)
                str.append("r 1\n");
            else if (r == 0)
                str.append("r 2\n");

            if (b == 1)
                str.append("b 1\n");
            else if (b == 0)
                str.append("b 2\n");

            if (n == 1)
                str.append("n 1\n");
            else if (n == 0)
                str.append("n 2\n");

            if (p < 8){
                int m=8-p;
                str.append("p ");
                str.append(m);
                str.append("\n");
            }

        }

        return str.toString();
    }

    @Override
    public ChessComponent getChess(int x, int y){
        ChessComponent chessComponent=chessComponents[x][y];
        return chessComponent;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){
        ChessComponent chessComponent1=getChess(source.getX(),source.getY());
        return chessComponent1.canMoveTo();
    }

    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
        ChessboardPoint chessboardPoint=new ChessboardPoint(sourceX,sourceY);
        if (chessComponents[sourceX][sourceY].getChessColor()!=getCurrentPlayer())
            return false;
        ChessboardPoint chessboardPointTarget=new ChessboardPoint(targetX,targetY);
        if (chessComponents[targetX][targetY].getChessColor()==getCurrentPlayer())
            return false;

        List<ChessboardPoint> chessboardPointList=getCanMovePoints(chessboardPoint);

        for (int i=0;i<chessboardPointList.size();i++){
            if (chessboardPointList.get(i).getX()==targetX && chessboardPointList.get(i).getY()==targetY){
                if (currentPlayer==ChessColor.BLACK)
                    currentPlayer=ChessColor.WHITE;
                else
                    currentPlayer=ChessColor.BLACK;

                if (chessComponents[sourceX][sourceY].getChessColor()==ChessColor.BLACK){
                    if (chessComponents[sourceX][sourceY] instanceof BishopChessComponent)
                         chessComponents[targetX][targetY]=new BishopChessComponent(chessboardPointTarget,ChessColor.BLACK,'B');
                    if (chessComponents[sourceX][sourceY] instanceof KingChessComponent)
                        chessComponents[targetX][targetY]=new KingChessComponent(chessboardPointTarget,ChessColor.BLACK,'K');
                    if (chessComponents[sourceX][sourceY] instanceof KnightChessComponent)
                        chessComponents[targetX][targetY]=new KnightChessComponent(chessboardPointTarget,ChessColor.BLACK,'N');
                    if (chessComponents[sourceX][sourceY] instanceof QueenChessComponent)
                        chessComponents[targetX][targetY]=new QueenChessComponent(chessboardPointTarget,ChessColor.BLACK,'Q');
                    if (chessComponents[sourceX][sourceY] instanceof RookChessComponent)
                        chessComponents[targetX][targetY]=new RookChessComponent(chessboardPointTarget,ChessColor.BLACK,'R');
                    if (chessComponents[sourceX][sourceY] instanceof PawnChessComponent)
                        chessComponents[targetX][targetY]=new PawnChessComponent(chessboardPointTarget,ChessColor.BLACK,'P');
                }
                else if (chessComponents[sourceX][sourceY].getChessColor()==ChessColor.WHITE){
                    if (chessComponents[sourceX][sourceY] instanceof BishopChessComponent)
                        chessComponents[targetX][targetY]=new BishopChessComponent(chessboardPointTarget,ChessColor.WHITE,'b');
                    if (chessComponents[sourceX][sourceY] instanceof KingChessComponent)
                        chessComponents[targetX][targetY]=new KingChessComponent(chessboardPointTarget,ChessColor.WHITE,'k');
                    if (chessComponents[sourceX][sourceY] instanceof KnightChessComponent)
                        chessComponents[targetX][targetY]=new KnightChessComponent(chessboardPointTarget,ChessColor.WHITE,'n');
                    if (chessComponents[sourceX][sourceY] instanceof QueenChessComponent)
                        chessComponents[targetX][targetY]=new QueenChessComponent(chessboardPointTarget,ChessColor.WHITE,'q');
                    if (chessComponents[sourceX][sourceY] instanceof RookChessComponent)
                        chessComponents[targetX][targetY]=new RookChessComponent(chessboardPointTarget,ChessColor.WHITE,'r');
                    if (chessComponents[sourceX][sourceY] instanceof PawnChessComponent)
                        chessComponents[targetX][targetY]=new PawnChessComponent(chessboardPointTarget,ChessColor.WHITE,'p');
                }

                chessComponents[sourceX][sourceY]=new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.NONE,'_');

                return true;}
        }

        return false;
    }
}