import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents=new ChessComponent[8][8];

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }
    public void swapColor() {
        currentPlayer = currentPlayer == ChessColor.BLACK ? ChessColor.WHITE : ChessColor.BLACK;
    }
    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        chessComponents[sourceX][sourceY].pass(chessComponents);
        if(targetX>=8||targetX<0||targetY>=8||targetY<0){
            return false;
        }
        for(int i=0;i<chessComponents[sourceX][sourceY].canMoveTo().size();i++){
            if(chessComponents[sourceX][sourceY].canMoveTo().get(i).getX()==targetX&&chessComponents[sourceX][sourceY].canMoveTo().get(i).getY()==targetY&&chessComponents[sourceX][sourceY].getChessColor()==currentPlayer)
            {swapChessComponents(chessComponents[sourceX][sourceY],chessComponents[targetX][targetY]);
            return true;}
        }
        return false;
    }
    public void swapChessComponents(ChessComponent chess1, ChessComponent chess2) {
        chessComponents[chess1.getChessboardPoint().getX()][chess1.getChessboardPoint().getY()]=new EmptySlotComponent(chess1.getChessboardPoint(),ChessColor.NONE,'_',chessComponents);
        chess1.setSource(chess2.getChessboardPoint());
        chessComponents[chess2.getChessboardPoint().getX()][chess2.getChessboardPoint().getY()]=chess1;
        swapColor();
    }
    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        chessComponents[source.getX()][source.getY()].pass(chessComponents);
        List<ChessboardPoint> canMovePoints = chessComponents[source.getX()][source.getY()].canMoveTo();

        return canMovePoints;
    }

    private ChessColor currentPlayer=ChessColor.WHITE;

    public void loadChessGame(List<String> chessboard) {
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(chessboard.get(i).charAt(j)=='p')
                    chessComponents[i][j]=new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'p',chessComponents);
                else if(chessboard.get(i).charAt(j)=='r')
                    chessComponents[i][j]=new RookChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'r',chessComponents);
                else if(chessboard.get(i).charAt(j)=='n')
                    chessComponents[i][j]=new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'n',chessComponents);
                else if(chessboard.get(i).charAt(j)=='b')
                    chessComponents[i][j]=new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'b',chessComponents);
                else if(chessboard.get(i).charAt(j)=='q')
                    chessComponents[i][j]=new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'q',chessComponents);
                else if(chessboard.get(i).charAt(j)=='k')
                    chessComponents[i][j]=new KingChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'k',chessComponents);
                else if(chessboard.get(i).charAt(j)=='P')
                    chessComponents[i][j]=new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'P',chessComponents);
                else if(chessboard.get(i).charAt(j)=='R')
                    chessComponents[i][j]=new RookChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'R',chessComponents);
                else if(chessboard.get(i).charAt(j)=='N')
                    chessComponents[i][j]=new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'N',chessComponents);
                else if(chessboard.get(i).charAt(j)=='B')
                    chessComponents[i][j]=new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'B',chessComponents);
                else if(chessboard.get(i).charAt(j)=='Q')
                    chessComponents[i][j]=new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'Q',chessComponents);
                else if(chessboard.get(i).charAt(j)=='K')
                    chessComponents[i][j]=new KingChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'K',chessComponents);
                else
                    chessComponents[i][j]=new EmptySlotComponent(new ChessboardPoint(i,j),ChessColor.NONE,'_',chessComponents);
                chessComponents[i][j].pass(chessComponents);
            }
        }
        if(chessboard.get(8).charAt(0)=='w'){
           currentPlayer=ChessColor.WHITE;
        }
        else
            currentPlayer=ChessColor.BLACK;
    }
    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }
    public String getCapturedChess(ChessColor player){
        int p=0,r=0,n=0,b=0,q=0,k=0;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if (chessComponents[i][j].getChessColor()==player){
                    if(chessComponents[i][j] instanceof PawnChessComponent)
                        p++;
                    else if (chessComponents[i][j] instanceof RookChessComponent)
                        r++;
                    else if (chessComponents[i][j] instanceof KnightChessComponent)
                        n++;
                    else if (chessComponents[i][j] instanceof BishopChessComponent)
                        b++;
                    else if (chessComponents[i][j] instanceof QueenChessComponent)
                        q++;
                    else if (chessComponents[i][j] instanceof KingChessComponent)
                        k++;
                }
            }
        }
        String str="";
        if(player==ChessColor.BLACK){

        if(k!=1)
            str=str+"K "+(1-k)+"\n";
        if(q!=1)
            str=str+"Q "+(1-q)+"\n";
        if(r!=2)
            str=str+"R "+(2-r)+"\n";
        if(b!=2)
                str=str+"B "+(2-b)+"\n";
            if(n!=2)
                str=str+"N "+(2-n)+"\n";
            if(p!=8)
                str=str+"P "+(8-p)+"\n";
    }
        else{if(k!=1)
            str=str+"k "+(1-k)+"\n";
            if(q!=1)
                str=str+"q "+(1-q)+"\n";
            if(r!=2)
                str=str+"r "+(2-r)+"\n";
            if(b!=2)
                str=str+"b "+(2-b)+"\n";
            if(n!=2)
                str=str+"n "+(2-n)+"\n";
            if(p!=8)
                str=str+"p "+(8-p)+"\n";}
        return str;
    }
    public String getChessboardGraph(){
        char[][] chr=new char[8][8];
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(chessComponents[i][j].getChessColor()== ChessColor.WHITE){
                    if(chessComponents[i][j] instanceof PawnChessComponent)
                        chr[i][j]='p';
                    else if (chessComponents[i][j] instanceof RookChessComponent)
                        chr[i][j]='r';
                    else if (chessComponents[i][j] instanceof KnightChessComponent)
                        chr[i][j]='n';
                    else if (chessComponents[i][j] instanceof BishopChessComponent)
                        chr[i][j]='b';
                    else if (chessComponents[i][j] instanceof QueenChessComponent)
                        chr[i][j]='q';
                    else if (chessComponents[i][j] instanceof KingChessComponent)
                        chr[i][j]='k';
                }
                else if(chessComponents[i][j].getChessColor()==ChessColor.BLACK){
                    if(chessComponents[i][j] instanceof PawnChessComponent)
                        chr[i][j]='P';
                    else if (chessComponents[i][j] instanceof RookChessComponent)
                        chr[i][j]='R';
                    else if (chessComponents[i][j] instanceof KnightChessComponent)
                        chr[i][j]='N';
                    else if (chessComponents[i][j] instanceof BishopChessComponent)
                        chr[i][j]='B';
                    else if (chessComponents[i][j] instanceof QueenChessComponent)
                        chr[i][j]='Q';
                    else if (chessComponents[i][j] instanceof KingChessComponent)
                        chr[i][j]='K';
                }
                if(chessComponents[i][j] instanceof EmptySlotComponent)
                    chr[i][j]='_';
            }
        }
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=0;i<8;i++){
            stringBuilder.append(chr[i]);
            if(i!=7)
           stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
    public ChessComponent getChess(int x,int y){
        return chessComponents[x][y];
    }
}
