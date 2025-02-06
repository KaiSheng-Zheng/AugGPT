import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConcreteChessGame implements ChessGame {

    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;
    public ConcreteChessGame (){
        chessComponents=new ChessComponent[8][8];
        currentPlayer=ChessColor.WHITE;
    }


    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {

        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                char x=chessboard.get(i).charAt(j);
                if(x=='_') {
                    chessComponents[i][j]= new EmptyChessComponent() ;
                    chessComponents[i][j].setChessColor(ChessColor.NONE);
                    chessComponents[i][j].setName(x);
                    chessComponents[i][j].setSource(i,j);
                    chessComponents[i][j].setChessboard(chessComponents);
                }
                else if((int)x<=90&&(int)x>=65) {
                    if(x=='R')  chessComponents[i][j]=new RookChessComponent();
                    if(x=='K')  chessComponents[i][j]=new KingChessComponent();
                    if(x=='P')  chessComponents[i][j]=new PawnChessComponent();
                    if(x=='Q')  chessComponents[i][j]=new QueenChessComponent();
                    if(x=='B')  chessComponents[i][j]=new BishopChessComponent();
                    if(x=='N')  chessComponents[i][j]=new KnightChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    chessComponents[i][j].setName(x);
                    chessComponents[i][j].setSource(i,j);
                    chessComponents[i][j].setChessboard(chessComponents);
                }
                else{
                    if(x=='r')  chessComponents[i][j]=new RookChessComponent();
                    if(x=='k')  chessComponents[i][j]=new KingChessComponent();
                    if(x=='p')  chessComponents[i][j]=new PawnChessComponent();
                    if(x=='q')  chessComponents[i][j]=new QueenChessComponent();
                    if(x=='b')  chessComponents[i][j]=new BishopChessComponent();
                    if(x=='n')  chessComponents[i][j]=new KnightChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    chessComponents[i][j].setName(x);
                    chessComponents[i][j].setSource(i,j);
                    chessComponents[i][j].setChessboard(chessComponents);
                }
            }
        }
        char s=chessboard.get(8).charAt(0);
        if(s=='b')this.currentPlayer=ChessColor.BLACK;
        else this.currentPlayer=ChessColor.WHITE;
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        if(x>7||y>7) return null;
        if(x<0||y<0) return null;
        return chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph() {
        String s="";
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                s+=chessComponents[i][j].getName();
            }
            s+='\n';
        }
        return s;
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int K=1,Q=1,R=2,B=2,N=2,P=8;
        String out="";
        if(player==ChessColor.WHITE){
            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    if(chessComponents[i][j].getName()=='k') K--;
                    if(chessComponents[i][j].getName()=='q') Q--;
                    if(chessComponents[i][j].getName()=='r') R--;
                    if(chessComponents[i][j].getName()=='b') B--;
                    if(chessComponents[i][j].getName()=='n') N--;
                    if(chessComponents[i][j].getName()=='p') P--;
                }
            }

            if (K != 0) out += "k 1\n";
            if (Q != 0) out += "q 1\n";
            if (R != 0) out += "r " + R + '\n';
            if (B != 0) out += "b " + B + '\n';
            if (N != 0) out += "n " + N + '\n';
            if (P != 0) out += "p " + P + '\n';
            return out;
        }
        else {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].getName() == 'K') K--;
                    if (chessComponents[i][j].getName() == 'Q') Q--;
                    if (chessComponents[i][j].getName() == 'R') R--;
                    if (chessComponents[i][j].getName() == 'B') B--;
                    if (chessComponents[i][j].getName() == 'N') N--;
                    if (chessComponents[i][j].getName() == 'P') P--;
                }
            }

            if (K != 0) out += "K 1\n";
            if (Q != 0) out += "Q 1\n";
            if (R != 0) out += "R " + R + '\n';
            if (B != 0) out += "B " + B + '\n';
            if (N != 0) out += "N " + N + '\n';
            if (P != 0) out += "P " + P + '\n';
            return out;

        }
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> a=new ArrayList<>();
//        if(getChess(source.getX(),source.getY()) instanceof EmptyChessComponent)
//            System.out.println("Empty");
//        if(chessComponents[source.getX()][source.getY()].getName()=='_') return a;
//        if(getChess(source.getX(),source.getY()) instanceof EmptyChessComponent) return a;
        a=chessComponents[source.getX()][source.getY()].canMoveTo();
        Collections.sort(a);
        return a;
    }

    //
    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if(getChess(sourceX,sourceY).getChessColor()==ChessColor.NONE) return false;
        if(getChess(sourceX,sourceY).getChessColor()==getChess(targetX,targetY).getChessColor()) return false;
        if(getChess(sourceX,sourceY).getChessColor()!=getCurrentPlayer()) return false;

        List<ChessboardPoint> a=chessComponents[sourceX][sourceY].canMoveTo();
        for(int i=0;i<a.size();i++){
            if(a.get(i).getX()==targetX&&a.get(i).getY()==targetY) break;
            if(i==a.size()-1) return false;
        }


        chessComponents[targetX][targetY]=chessComponents[sourceX][sourceY];
        chessComponents[targetX][targetY].setSource(targetX,targetY);

        chessComponents[sourceX][sourceY]=new EmptyChessComponent();
        chessComponents[sourceX][sourceY].name='_';
        chessComponents[sourceX][sourceY].setChessColor(ChessColor.NONE);
        chessComponents[sourceX][sourceY].setSource(sourceX,sourceY);

        if(getCurrentPlayer()==ChessColor.WHITE) currentPlayer=ChessColor.BLACK;
        else currentPlayer=ChessColor.WHITE;
        return true;
    }


}
