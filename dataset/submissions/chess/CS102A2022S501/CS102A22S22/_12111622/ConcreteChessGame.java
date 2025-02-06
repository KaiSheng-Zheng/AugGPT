import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer=ChessColor.WHITE;
    public ConcreteChessGame(ChessColor blackOrWhite){
        chessComponents=new ChessComponent[8][8];
        currentPlayer=blackOrWhite;

    }
    public ConcreteChessGame(){
        chessComponents=new ChessComponent[8][8];
    }
    @Override
    public void loadChessGame(List<String> chessboard) {
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                switch (chessboard.get(i).charAt(j)){
                    case 'R':chessComponents[i][j]=new RookChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j),'R');break;
                    case 'r':chessComponents[i][j]=new RookChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j),'r');break;
                    case 'N':chessComponents[i][j]=new KnightChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j),'N');break;
                    case 'n':chessComponents[i][j]=new KnightChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j),'n');break;
                    case 'B':chessComponents[i][j]=new BishopChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j),'B');break;
                    case 'b':chessComponents[i][j]=new BishopChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j),'b');break;
                    case 'Q':chessComponents[i][j]=new QueenChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j),'Q');break;
                    case 'q':chessComponents[i][j]=new QueenChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j),'q');break;
                    case 'K':chessComponents[i][j]=new KingChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j),'K');break;
                    case 'k':chessComponents[i][j]=new KingChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j),'k');break;
                    case 'P':chessComponents[i][j]=new PawnChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j),'P');break;
                    case 'p':chessComponents[i][j]=new PawnChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j),'p');break;
                    case '_':chessComponents[i][j]=new EmptySlotComponent(new ChessboardPoint(i,j));break;
                }
                chessComponents[i][j].setChessboard(chessComponents);
                chessComponents[i][j].setItsConcreteGame(this);
            }
        }
        currentPlayer=chessboard.get(8).charAt(0)=='w'?ChessColor.WHITE:ChessColor.BLACK;
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return currentPlayer;
    }
    public String getChessboardGraph(){
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(chessComponents[i][j]instanceof RookChessComponent){
                    stringBuilder.append(((RookChessComponent) chessComponents[i][j]).getColor()==ChessColor.BLACK?'R':'r');
                }
                if(chessComponents[i][j]instanceof QueenChessComponent){
                    stringBuilder.append(((QueenChessComponent) chessComponents[i][j]).getColor()==ChessColor.BLACK?'Q':'q');
                }
                if(chessComponents[i][j]instanceof KnightChessComponent){
                    stringBuilder.append(((KnightChessComponent) chessComponents[i][j]).getColor()==ChessColor.BLACK?'N':'n');
                }
                if(chessComponents[i][j]instanceof KingChessComponent){
                    stringBuilder.append(((KingChessComponent) chessComponents[i][j]).getColor()==ChessColor.BLACK?'K':'k');
                }
                if(chessComponents[i][j]instanceof BishopChessComponent){
                    stringBuilder.append(((BishopChessComponent) chessComponents[i][j]).getColor()==ChessColor.BLACK?'B':'b');
                }
                if(chessComponents[i][j]instanceof PawnChessComponent){
                    stringBuilder.append(((PawnChessComponent) chessComponents[i][j]).getColor()==ChessColor.BLACK?'P':'p');
                }
                if(chessComponents[i][j]instanceof EmptySlotComponent){
                    stringBuilder.append('_');
                }
            }
            if(i!=7)
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }


    @Override
    public String getCapturedChess(ChessColor player) {
        int[] eatenNumbers={1,1,2,2,2,8};
        String result="";
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(chessComponents[i][j]instanceof RookChessComponent&&((RookChessComponent)chessComponents[i][j]).getColor()==player){
                    eatenNumbers[2]--;
                }
                if(chessComponents[i][j]instanceof QueenChessComponent&&((QueenChessComponent)chessComponents[i][j]).getColor()==player){
                    eatenNumbers[1]--;
                }
                if(chessComponents[i][j]instanceof KnightChessComponent&&((KnightChessComponent)chessComponents[i][j]).getColor()==player){
                    eatenNumbers[4]--;
                }
                if(chessComponents[i][j]instanceof KingChessComponent&&((KingChessComponent)chessComponents[i][j]).getColor()==player){
                    eatenNumbers[0]--;
                }
                if(chessComponents[i][j]instanceof BishopChessComponent&&((BishopChessComponent)chessComponents[i][j]).getColor()==player){
                    eatenNumbers[3]--;
                }
                if(chessComponents[i][j]instanceof PawnChessComponent&&((PawnChessComponent)chessComponents[i][j]).getColor()==player){
                    eatenNumbers[5]--;
                }
            }
        }
        if(eatenNumbers[0]!=0){
            result+=(player==ChessColor.BLACK)?"K":"k";
            result+=" "+eatenNumbers[0]+"\n";
        }
        if(eatenNumbers[1]!=0){
            result+=(player==ChessColor.BLACK)?"Q":"q";
            result+=" "+eatenNumbers[1]+"\n";
        }
        if(eatenNumbers[2]!=0){
            result+=(player==ChessColor.BLACK)?"R":"r";
            result+=" "+eatenNumbers[2]+"\n";
        }
        if(eatenNumbers[3]!=0){
            result+=(player==ChessColor.BLACK)?"B":"b";
            result+=" "+eatenNumbers[3]+"\n";
        }
        if(eatenNumbers[4]!=0){
            result+=(player==ChessColor.BLACK)?"N":"n";
            result+=" "+eatenNumbers[4]+"\n";
        }
        if(eatenNumbers[5]!=0){
            result+=(player==ChessColor.BLACK)?"P":"p";
            result+=" "+eatenNumbers[5]+"\n";
        }
        return result;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        return chessComponents[source.getX()][source.getY()].canMoveTo();
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if(sourceX<0||sourceX>7||sourceY<0||sourceY>7||targetX<0||targetX>7||targetY<0||targetY>7)
            return false;
        if(chessComponents[sourceX][sourceY].getColor()!=currentPlayer)
            return false;
        List<ChessboardPoint> chessboardPointList=chessComponents[sourceX][sourceY].canMoveTo();
        for(ChessboardPoint c:chessboardPointList){
            if(c.getY()==targetY&&c.getX()==targetX&&chessComponents[targetX][targetY].getColor()!=currentPlayer){
                swapChess(sourceX,sourceY,targetX,targetY);
                currentPlayer=(currentPlayer==ChessColor.BLACK)?ChessColor.WHITE:ChessColor.BLACK;
                return true;
            }
        }
        return false;
    }
   public void swapChess(int sourceX, int sourceY, int targetX, int targetY){
//        if(chessComponents[sourceX][sourceY]instanceof RookChessComponent){
            chessComponents[targetX][targetY]=chessComponents[sourceX][sourceY];
            chessComponents[targetX][targetY].setChessboardPoint(new ChessboardPoint(targetX,targetY));
            chessComponents[sourceX][sourceY]=new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY));
//        }
//        if(chessComponents[sourceX][sourceY]instanceof QueenChessComponent){
//            chessComponents[targetX][targetY]=new QueenChessComponent(chessComponents[sourceX][sourceY].getColor(),new ChessboardPoint(targetX,targetY),chessComponents[sourceX][sourceY].name);
//            chessComponents[sourceX][sourceY]=new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY));
//        }
//        if(chessComponents[sourceX][sourceY]instanceof KingChessComponent){
//            chessComponents[targetX][targetY]=new KingChessComponent(chessComponents[sourceX][sourceY].getColor(),new ChessboardPoint(targetX,targetY),chessComponents[sourceX][sourceY].name);
//            chessComponents[sourceX][sourceY]=new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY));
//        }
//        if(chessComponents[sourceX][sourceY]instanceof KnightChessComponent){
//            chessComponents[targetX][targetY]=new KnightChessComponent(chessComponents[sourceX][sourceY].getColor(),new ChessboardPoint(targetX,targetY),chessComponents[sourceX][sourceY].name);
//            chessComponents[sourceX][sourceY]=new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY));
//        }
//        if(chessComponents[sourceX][sourceY]instanceof BishopChessComponent){
//            chessComponents[targetX][targetY]=new BishopChessComponent(chessComponents[sourceX][sourceY].getColor(),new ChessboardPoint(targetX,targetY),chessComponents[sourceX][sourceY].name);
//            chessComponents[sourceX][sourceY]=new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY));
//        }
//        if(chessComponents[sourceX][sourceY]instanceof PawnChessComponent){
//            chessComponents[targetX][targetY]=new PawnChessComponent(chessComponents[sourceX][sourceY].getColor(),new ChessboardPoint(targetX,targetY),chessComponents[sourceX][sourceY].name);
//            chessComponents[sourceX][sourceY]=new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY));
//        }
    }
}
