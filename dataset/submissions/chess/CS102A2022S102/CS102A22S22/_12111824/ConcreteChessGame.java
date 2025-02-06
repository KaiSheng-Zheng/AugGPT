import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents=new ChessComponent[8][8];
    private ChessColor currentPlayer=ChessColor.WHITE;
    @Override
    public void loadChessGame(List<String> chessboard){
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                ChessboardPoint x=new ChessboardPoint(i,j);ChessColor y=ChessColor.WHITE;
                if(chessboard.get(i).charAt(j)>='A'&&chessboard.get(i).charAt(j)<='Z'){
                    y=ChessColor.BLACK;
                }
                if(chessboard.get(i).charAt(j)>='a'&&chessboard.get(i).charAt(j)<='z'){
                    y=ChessColor.WHITE;
                }
                if(chessboard.get(i).charAt(j)=='_') {
                    y=ChessColor.NONE;
                }
               if(chessboard.get(i).charAt(j)=='b'||chessboard.get(i).charAt(j)=='B'){chessComponents[i][j]=new BishopChessComponent(new ChessboardPoint(i,j),y,chessboard.get(i).charAt(j));;}
               if(chessboard.get(i).charAt(j)=='_'){chessComponents[i][j]=new EmptySlotComponent(new ChessboardPoint(i,j),y,chessboard.get(i).charAt(j));;}
               if(chessboard.get(i).charAt(j)=='k'||chessboard.get(i).charAt(j)=='K'){chessComponents[i][j]=new KingChessComponent(new ChessboardPoint(i,j),y,chessboard.get(i).charAt(j));;}
               if(chessboard.get(i).charAt(j)=='n'||chessboard.get(i).charAt(j)=='N'){chessComponents[i][j]=new KnightChessComponent(new ChessboardPoint(i,j),y,chessboard.get(i).charAt(j));;}
               if(chessboard.get(i).charAt(j)=='p'||chessboard.get(i).charAt(j)=='P'){chessComponents[i][j]=new PawnChessComponent(new ChessboardPoint(i,j),y,chessboard.get(i).charAt(j));;}
               if(chessboard.get(i).charAt(j)=='q'||chessboard.get(i).charAt(j)=='Q'){chessComponents[i][j]=new QueenChessComponent(new ChessboardPoint(i,j),y,chessboard.get(i).charAt(j));;}
               if(chessboard.get(i).charAt(j)=='r'||chessboard.get(i).charAt(j)=='R'){chessComponents[i][j]=new RookChessComponent(new ChessboardPoint(i,j),y,chessboard.get(i).charAt(j));;}
            }

        }
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                chessComponents[i][j].setChessComponents(chessComponents);
            }}
        if(chessboard.get(8).charAt(0)=='w'){currentPlayer=ChessColor.WHITE;}
        else {currentPlayer=ChessColor.BLACK;}
    };
    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }
    @Override
    public String getChessboardGraph(){
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                sb.append(chessComponents[i][j].getName());
                if(j==7&&i!=7){
                    sb.append("\n");
                }
            }
        }
        return sb.toString();
    }
    @Override
    public String getCapturedChess(ChessColor player){
        StringBuilder sb=new StringBuilder();
        if(player==ChessColor.BLACK){
            sb.append(seekCapturedChess('K',chessComponents));
            sb.append(seekCapturedChess('Q',chessComponents));
            sb.append(seekCapturedChess('R',chessComponents));
            sb.append(seekCapturedChess('B',chessComponents));
            sb.append(seekCapturedChess('N',chessComponents));
            sb.append(seekCapturedChess('P',chessComponents));
        }
        if (player==ChessColor.WHITE){
            sb.append(seekCapturedChess('k',chessComponents));
            sb.append(seekCapturedChess('q',chessComponents));
            sb.append(seekCapturedChess('r',chessComponents));
            sb.append(seekCapturedChess('b',chessComponents));
            sb.append(seekCapturedChess('n',chessComponents));
            sb.append(seekCapturedChess('p',chessComponents));
        }
        return sb.toString();
    }
    private static String seekCapturedChess(char name,ChessComponent[][] chessComponents){
        int x;
        if(name=='p'||name=='P'){
             x=8;
        }
        if (name=='k'||name=='K'||name=='q'||name=='Q'){
             x=1;
        }
        else {
             x=2;
        }
        if(name=='p'||name=='P'){
            x=8;
        }
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                if(chessComponents[i][j].getName()==name){
                    x--;
                }
            }
        }
        String name1=String.valueOf(name);
        if(x==0){
            return "";
        }
        if(x!=0&&name!='p'&&name!='P') {
            return name1+" "+x+"\n";
        }
        else {
            return name1+" "+x;
        }
    }
    @Override
    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }
    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
       boolean x=false;
       if(chessComponents[sourceX][sourceY].getName()>='A'&&chessComponents[sourceX][sourceY].getName()<='Z'&&currentPlayer==ChessColor.WHITE
       ||chessComponents[sourceX][sourceY].getName()>='a'&&chessComponents[sourceX][sourceY].getName()<='z'&&currentPlayer==ChessColor.BLACK){
           return x;
       }
       else {
             List<ChessboardPoint>  realCanMoveTo=chessComponents[sourceX][sourceY].realCanMoveTo(chessComponents);
             for (int i=0;i<realCanMoveTo.size();i++){
                 if(targetX==realCanMoveTo.get(i).getX()&&targetY==realCanMoveTo.get(i).getY()){
                     chessComponents[targetX][targetY]=chessComponents[sourceX][sourceY];
                     chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
                     chessComponents[sourceX][sourceY]=new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.NONE,'_');
                     x=true;
                     break;
                 }
             }
             for (int i=0;i<1;i++){
             if(currentPlayer==ChessColor.BLACK&&x){
                 currentPlayer=ChessColor.WHITE;break;
             }
             if(currentPlayer==ChessColor.WHITE&&x){
                 currentPlayer=ChessColor.BLACK;break;
             }}
             return x;
       }
    }
    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){
        List<ChessboardPoint> z=chessComponents[source.getX()][source.getY()].realCanMoveTo(chessComponents);
        for (int i=0;i<z.size();i++){
            for (int j=i+1;j< z.size();j++){
                if(z.get(j).getX()<z.get(i).getX()||z.get(j).getX()==z.get(i).getX()&&z.get(j).getY()<z.get(i).getY()){
                    ChessboardPoint ii=z.get(i);
                    ChessboardPoint jj=z.get(j);
                    z.set(i,jj);
                    z.set(j,ii);
                }
            }
        }
        return z;
    }
    public char getName(int x,int y){
        return chessComponents[x][y].getName();
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }
}