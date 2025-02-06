import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents=new ChessComponent[8][8];
    private ChessColor currentPlayer;
    private ChessboardPoint[][] chessboardPoints=new ChessboardPoint[8][8];

    public ConcreteChessGame(){
        currentPlayer=ChessColor.WHITE;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessboardPoints[i][j]=new ChessboardPoint(i,j);
            }
        }

    }

    public void loadChessGame(List<String> chessboard){
        if(chessboard.get(8).equals("w"))currentPlayer=ChessColor.WHITE;
        if(chessboard.get(8).equals("b"))currentPlayer=ChessColor.BLACK;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                switch (chessboard.get(i).charAt(j)){
                    case 'R':{
                        this.chessComponents[i][j]=new RookChessComponent(ChessColor.BLACK,chessboardPoints[i][j]);
                        //Black.add('R');
                        chessComponents[i][j].setChessboard(chessComponents);
                        continue;
                    }
                    case 'r':{
                        this.chessComponents[i][j]=new RookChessComponent(ChessColor.WHITE,chessboardPoints[i][j]);
                        //White.add('r');
                        chessComponents[i][j].setChessboard(chessComponents);
                        continue;
                    }
                    case 'N':{
                        this.chessComponents[i][j]=new KnightChessComponent(ChessColor.BLACK,chessboardPoints[i][j]);
                        //Black.add('N');
                        chessComponents[i][j].setChessboard(chessComponents);
                        continue;
                    }
                    case 'n':{
                        this.chessComponents[i][j]=new KnightChessComponent(ChessColor.WHITE,chessboardPoints[i][j]);
                        //White.add('n');
                        chessComponents[i][j].setChessboard(chessComponents);
                        continue;
                    }
                    case 'B':{
                        this.chessComponents[i][j]=new BishopChessComponent(ChessColor.BLACK,chessboardPoints[i][j]);
                        //Black.add('B');
                        chessComponents[i][j].setChessboard(chessComponents);
                        continue;
                    }
                    case 'b':{
                        this.chessComponents[i][j]=new BishopChessComponent(ChessColor.WHITE,chessboardPoints[i][j]);
                        //White.add('b');
                        chessComponents[i][j].setChessboard(chessComponents);
                        continue;
                    }
                    case 'Q':{
                        this.chessComponents[i][j]=new QueenChessComponent(ChessColor.BLACK,chessboardPoints[i][j]);
                        //Black.add('Q');
                        chessComponents[i][j].setChessboard(chessComponents);
                        continue;
                    }
                    case 'q':{
                        this.chessComponents[i][j]=new QueenChessComponent(ChessColor.WHITE,chessboardPoints[i][j]);
                        //White.add('q');
                        chessComponents[i][j].setChessboard(chessComponents);
                        continue;
                    }
                    case 'K':{
                        this.chessComponents[i][j]=new KingChessComponent(ChessColor.BLACK,chessboardPoints[i][j]);
                        chessComponents[i][j].setChessboard(chessComponents);
                        //Black.add('K');
                        continue;
                    }
                    case 'k':{
                        this.chessComponents[i][j]=new KingChessComponent(ChessColor.WHITE,chessboardPoints[i][j]);
                        //White.add('k');
                        chessComponents[i][j].setChessboard(chessComponents);
                        continue;
                    }
                    case 'P':{
                        this.chessComponents[i][j]=new PawnChessComponent(ChessColor.BLACK,chessboardPoints[i][j]);
                        //Black.add('P');
                        chessComponents[i][j].setChessboard(chessComponents);
                        continue;
                    }
                    case 'p':{
                        this.chessComponents[i][j]=new PawnChessComponent(ChessColor.WHITE,chessboardPoints[i][j]);
                        //White.add('p');
                        chessComponents[i][j].setChessboard(chessComponents);
                        continue;
                    }
                    default:this.chessComponents[i][j]=new EmptySlotComponent(chessboardPoints[i][j]);chessComponents[i][j].setChessboard(chessComponents);
                }
            }
        }
    }

    public ChessColor getCurrentPlayer(){
        return this.currentPlayer;
    }

    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }

    public String getChessboardGraph(){
        String[] chessboardGraph=new String[8];
        char[] temp=new char[8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                temp[j]=chessComponents[i][j].getName();
            }
            chessboardGraph[i]=String.valueOf(temp);
        }

        return chessboardGraph[0]+"\n"+chessboardGraph[1]+"\n"+chessboardGraph[2]+"\n"+chessboardGraph[3]+"\n"+chessboardGraph[4]+"\n"+chessboardGraph[5]+"\n"+chessboardGraph[6]+"\n"+chessboardGraph[7];
    }

    public String getCapturedChess(ChessColor player){
        StringBuilder cC=new StringBuilder();
        if(player==ChessColor.BLACK){
            ArrayList<Character> Black=new ArrayList<>();
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if(chessComponents[i][j].getName()>=65&&chessComponents[i][j].getName()<91)Black.add(chessComponents[i][j].getName());
                }
            }
            if(Collections.frequency(Black,'K')!=1)cC.append("K 1\n");
            if(Collections.frequency(Black,'Q')!=1)cC.append("Q 1\n");
            if(Collections.frequency(Black,'R')!=2)cC.append("R "+(2-Collections.frequency(Black,'R'))+"\n");
            if(Collections.frequency(Black,'B')!=2)cC.append("B "+(2-Collections.frequency(Black,'B'))+"\n");
            if(Collections.frequency(Black,'N')!=2)cC.append("N "+(2-Collections.frequency(Black,'N'))+"\n");
            if(Collections.frequency(Black,'P')!=8)cC.append("P "+(8-Collections.frequency(Black,'P'))+"\n");
        }else {
            ArrayList<Character> White=new ArrayList<>();
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if(chessComponents[i][j].getName()>=97&&chessComponents[i][j].getName()<123)White.add(chessComponents[i][j].getName());
                }
            }
            if(Collections.frequency(White,'k')!=1)cC.append("k 1\n");
            if(Collections.frequency(White,'q')!=1)cC.append("q 1\n");
            if(Collections.frequency(White,'r')!=2)cC.append("r "+(2-Collections.frequency(White,'r'))+"\n");
            if(Collections.frequency(White,'b')!=2)cC.append("b "+(2-Collections.frequency(White,'b'))+"\n");
            if(Collections.frequency(White,'n')!=2)cC.append("n "+(2-Collections.frequency(White,'n'))+"\n");
            if(Collections.frequency(White,'p')!=8)cC.append("p "+(8-Collections.frequency(White,'p'))+"\n");
        }
        return cC.toString();
    }
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
        if(chessComponents[sourceX][sourceY].getChessColor()!=currentPlayer||targetX<0||targetX>7||targetY<0||targetY>7){
            return false;
        }else {
            boolean t=false;
            for (ChessboardPoint c : chessComponents[sourceX][sourceY].canMoveTo()) {
                if(c.getX()==targetX&&c.getY()==targetY)t=true;
            }
            if(!t){
                return false;
            }else {

                if(chessComponents[sourceX][sourceY] instanceof PawnChessComponent)((PawnChessComponent) chessComponents[sourceX][sourceY]).setMoved();
                chessComponents[targetX][targetY]=chessComponents[sourceX][sourceY];
                chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
                chessComponents[sourceX][sourceY]=new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY));
                if(currentPlayer==ChessColor.BLACK){
                    currentPlayer=ChessColor.WHITE;
                }else {currentPlayer=ChessColor.BLACK;}
                return true;
            }
        }
    }
    public ChessComponent getChess(ChessboardPoint source){
        return chessComponents[source.getX()][source.getY()];
    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){
        //if(chessComponents[source.getX()][source.getY()].getChessColor()!=currentPlayer){
            List<ChessboardPoint> cMT=getChess(source).canMoveTo();
            Collections.sort(cMT);
            return cMT;
        //}else return new ArrayList<>();
    }
}
