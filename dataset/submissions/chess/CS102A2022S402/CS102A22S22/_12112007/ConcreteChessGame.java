import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private static final ChessComponent[][]chessComponents=new ChessComponent[8][8];
    private ChessColor currentPlayer=ChessColor.WHITE;


    public static ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public void loadChessGame(List<String> chessboard){
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                if (chessboard.get(i).charAt(j)=='R'){
                    chessComponents[i][j]= new RookChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'R');
                }
                if (chessboard.get(i).charAt(j)=='N'){
                    chessComponents[i][j]=new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'N');
                }
                if (chessboard.get(i).charAt(j)=='B'){
                    chessComponents[i][j]=new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'B');
                }
                if (chessboard.get(i).charAt(j)=='Q'){
                    chessComponents[i][j]=new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'Q');
                }
                if (chessboard.get(i).charAt(j)=='K'){
                    chessComponents[i][j]=new KingChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'K');
                }
                if (chessboard.get(i).charAt(j)=='P'){
                    chessComponents[i][j]=new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'P');
                }
                 if (chessboard.get(i).charAt(j)=='_'){
                    chessComponents[i][j]=new EmptySlotComponent(new ChessboardPoint(i,j),ChessColor.NONE,'_');
                }
                if (chessboard.get(i).charAt(j)=='r'){
                    chessComponents[i][j]=new RookChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'r');
                }
                if (chessboard.get(i).charAt(j)=='n'){
                    chessComponents[i][j]=new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'n');
                }
                if (chessboard.get(i).charAt(j)=='b'){
                    chessComponents[i][j]=new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'b');
                }
                if (chessboard.get(i).charAt(j)=='q'){
                    chessComponents[i][j]=new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'q');
                }
                if (chessboard.get(i).charAt(j)=='k'){
                    chessComponents[i][j]=new KingChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'k');
                }
                if (chessboard.get(i).charAt(j)=='p'){
                    chessComponents[i][j]=new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'p');
                }
            }
        }
        if (chessboard.get(8).charAt(0)=='w'){
            currentPlayer=ChessColor.WHITE;
        }
        else if (chessboard.get(8).charAt(0)=='b'){
            currentPlayer=ChessColor.BLACK;
        }
    }
    @Override
    public ChessColor getCurrentPlayer(){
        return this.currentPlayer;
    }
    public String getChessboardGraph(){
        StringBuilder paimian=new StringBuilder();
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                if (chessComponents[i][j]instanceof EmptySlotComponent){
                    paimian.append("_");
                }
                else if (chessComponents[i][j]instanceof BishopChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.BLACK){
                    paimian.append("B");
                }
                else if (chessComponents[i][j]instanceof BishopChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.WHITE){
                    paimian.append("b");
                }
                else if (chessComponents[i][j]instanceof KingChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.BLACK){
                    paimian.append("K");
                }
                else if (chessComponents[i][j]instanceof KingChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.WHITE){
                    paimian.append("k");
                }
                else if (chessComponents[i][j]instanceof KnightChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.BLACK){
                    paimian.append("N");
                }
                else if (chessComponents[i][j]instanceof KnightChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.WHITE){
                    paimian.append("n");
                }
                else if (chessComponents[i][j]instanceof PawnChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.BLACK){
                    paimian.append("P");
                }
                else if (chessComponents[i][j]instanceof PawnChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.WHITE){
                    paimian.append("p");
                }
                else if (chessComponents[i][j]instanceof QueenChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.BLACK){
                    paimian.append("Q");
                }
                else if (chessComponents[i][j]instanceof QueenChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.WHITE){
                    paimian.append("q");
                }
                else if (chessComponents[i][j]instanceof RookChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.BLACK){
                    paimian.append("R");
                }
                else if (chessComponents[i][j]instanceof RookChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.WHITE){
                    paimian.append("r");
                }
            }
            paimian.append("\n");
        }
        return paimian.toString();
    }
    public String getCapturedChess(ChessColor player){
        int heirook=0;
        int heibishop=0;
        int heiking=0;
        int heiknight=0;
        int heipawn=0;
        int heiqueen=0;
        int bairook=0;
        int baibishop=0;
        int baiking=0;
        int baiknight=0;
        int baipawn=0;
        int baiqueen=0;
        StringBuilder str=new StringBuilder();
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                if (chessComponents[i][j]instanceof BishopChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.BLACK){
                    heibishop++;
                }
                else if (chessComponents[i][j]instanceof BishopChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.WHITE){
                    baibishop++;
                }
                else if (chessComponents[i][j]instanceof KingChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.BLACK){
                    heiking++;
                }
                else if (chessComponents[i][j]instanceof KingChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.WHITE){
                    baiking++;
                }
                else if (chessComponents[i][j]instanceof KnightChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.BLACK){
                    heiknight++;
                }
                else if (chessComponents[i][j]instanceof KnightChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.WHITE){
                    baiknight++;
                }
                else if (chessComponents[i][j]instanceof PawnChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.BLACK){
                    heipawn++;
                }
                else if (chessComponents[i][j]instanceof PawnChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.WHITE){
                    baipawn++;
                }
                else if (chessComponents[i][j]instanceof QueenChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.BLACK){
                    heiqueen++;
                }
                else if (chessComponents[i][j]instanceof QueenChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.WHITE){
                    baiqueen++;
                }
                else if (chessComponents[i][j]instanceof RookChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.BLACK){
                    heirook++;
                }
                else if (chessComponents[i][j]instanceof RookChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.WHITE){
                    bairook++;
                }
            }
        }
        if (player==ChessColor.WHITE){
            if (baiking!=1){
                str.append("k ").append(1 - baiking).append("\n");
            }
            if (baiqueen!=1){
                str.append("q ").append(1 - baiqueen).append("\n");
            }
            if (bairook!=2){
                str.append("r ").append(2 - bairook).append("\n");
            }
            if (baibishop!=2){
                str.append("b ").append(2 - baibishop).append("\n");
            }
            if (baiknight!=2){
                str.append("n ").append(2 - baiknight).append("\n");
            }
            if (baipawn!=8){
                str.append("p ").append(8 - baipawn).append("\n");
            }
        }
        else if (player==ChessColor.BLACK){
            if (heiking!=1){
                str.append("K ").append(1 - heiking).append("\n");
            }
            if (heiqueen!=1){
                str.append("Q ").append(1 - heiqueen).append("\n");
            }
            if (heirook!=2){
                str.append("R ").append(2 - heirook).append("\n");
            }
            if (heibishop!=2){
                str.append("B ").append(2 - heibishop).append("\n");
            }
            if (heiknight!=2){
                str.append("N ").append(2 - heiknight).append("\n");
            }
            if (heipawn!=8){
                str.append("P ").append(8 - heipawn).append("\n");
            }
        }
        return str.toString();
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        return chessComponents[source.getX()][source.getY()].canMoveTo();
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (chessComponents[sourceX][sourceY].getChessColor()==currentPlayer){
            boolean a=false;
            for (int i=0;i<chessComponents[sourceX][sourceY].canMoveTo().size();i++){
                if (chessComponents[sourceX][sourceY].canMoveTo().get(i).getX()==chessComponents[targetX][targetY].getChessboardPoint().getX()&&chessComponents[sourceX][sourceY].canMoveTo().get(i).getY()==chessComponents[targetX][targetY].getChessboardPoint().getY()){
                    a=true;
                }
            }
            if (a){
                if (chessComponents[sourceX][sourceY].name=='R'){
                    chessComponents[targetX][targetY]=new RookChessComponent(new ChessboardPoint(targetX,targetY),ChessColor.BLACK,'R');
                }
                if (chessComponents[sourceX][sourceY].name=='N'){
                    chessComponents[targetX][targetY]=new KnightChessComponent(new ChessboardPoint(targetX,targetY),ChessColor.BLACK,'N');
                }
                if (chessComponents[sourceX][sourceY].name=='B'){
                    chessComponents[targetX][targetY]=new BishopChessComponent(new ChessboardPoint(targetX,targetY),ChessColor.BLACK,'B');
                }
                if (chessComponents[sourceX][sourceY].name=='Q'){
                    chessComponents[targetX][targetY]=new QueenChessComponent(new ChessboardPoint(targetX,targetY),ChessColor.BLACK,'Q');
                }
                if (chessComponents[sourceX][sourceY].name=='K'){
                    chessComponents[targetX][targetY]=new KingChessComponent(new ChessboardPoint(targetX,targetY),ChessColor.BLACK,'K');
                }
                if (chessComponents[sourceX][sourceY].name=='P'){
                    chessComponents[targetX][targetY]=new PawnChessComponent(new ChessboardPoint(targetX,targetY),ChessColor.BLACK,'P');
                }
                if (chessComponents[sourceX][sourceY].name=='r'){
                    chessComponents[targetX][targetY]=new RookChessComponent(new ChessboardPoint(targetX,targetY),ChessColor.WHITE,'r');
                }
                if (chessComponents[sourceX][sourceY].name=='n'){
                    chessComponents[targetX][targetY]=new KnightChessComponent(new ChessboardPoint(targetX,targetY),ChessColor.WHITE,'n');
                }
                if (chessComponents[sourceX][sourceY].name=='b'){
                    chessComponents[targetX][targetY]=new BishopChessComponent(new ChessboardPoint(targetX,targetY),ChessColor.WHITE,'b');
                }
                if (chessComponents[sourceX][sourceY].name=='q'){
                    chessComponents[targetX][targetY]=new QueenChessComponent(new ChessboardPoint(targetX,targetY),ChessColor.WHITE,'q');
                }
                if (chessComponents[sourceX][sourceY].name=='k'){
                    chessComponents[targetX][targetY]=new KingChessComponent(new ChessboardPoint(targetX,targetY),ChessColor.WHITE,'k');
                }
                if (chessComponents[sourceX][sourceY].name=='p'){
                    chessComponents[targetX][targetY]=new PawnChessComponent(new ChessboardPoint(targetX,targetY),ChessColor.WHITE,'p');
                }

                chessComponents[sourceX][sourceY]=new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.NONE,'_');
                if (currentPlayer==ChessColor.WHITE){
                    currentPlayer=ChessColor.BLACK;
                }
                else if (currentPlayer==ChessColor.BLACK){
                    currentPlayer=ChessColor.WHITE;
                }
                

                return true;
            }
            else return false;
        }
        else return false;

    }


    public ChessComponent getChess(int x,int y){
        return chessComponents[x][y];
    }

}
