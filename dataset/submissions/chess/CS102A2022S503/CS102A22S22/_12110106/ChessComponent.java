import java.util.ArrayList;
import java.util.List;

public abstract class ChessComponent {
    //should design
 ChessboardPoint source;
 ChessColor chessColor;
    protected char name;
    ChessComponent[][] chessBoard;

 void load(ChessComponent[][] chessBoard){this.chessBoard=chessBoard;}
    public ChessComponent(){}
    public ChessComponent(ChessboardPoint source,ChessColor chessColor){
        this.source=source;
        this.chessColor=chessColor;

    }
    ChessColor getChessColor(char name){
        if(name=='_'){return ChessColor.NONE;}
        else return (name>='A'&&name<='Z')?ChessColor.BLACK:ChessColor.WHITE;
    }


public char getName(){return name;}
    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

}
class KingChessComponent extends ChessComponent{
    public KingChessComponent(ChessboardPoint source,ChessColor chessColor){
        super(source,chessColor);
        this.name=chessColor==ChessColor.BLACK?'K':'k';
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> zero=new ArrayList<>();
        int[] x=new int[8];
        int[] y=new int[8];
        x[0]=1;
        y[0]=1;
        x[1]=1;
        y[1]=-1;
        x[2]=-1;
        y[2]=1;
        x[3]=-1;
        y[3]=-1;
        x[4]=0;
        y[4]=1;
        x[5]=0;
        y[5]=-1;
        x[6]=1;
        y[6]=0;
        x[7]=-1;
        y[7]=0;
        for(int i=0;i<8;i++){
            ChessboardPoint newPlace=source.offset(x[i],y[i]);
            if(newPlace!=null&&getChessColor(chessBoard[newPlace.getX()][newPlace.getY()].toString().charAt(0))!=chessColor){
                zero.add(newPlace);
            }
        }
        return zero;
    }
}



class QueenChessComponent extends ChessComponent{
    public QueenChessComponent(ChessboardPoint source,ChessColor chessColor){
        super(source,chessColor);
        this.name=chessColor==ChessColor.BLACK?'Q':'q';
    }
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> zero=new ArrayList<>();
        int[][] queenGo=new int[][]{{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};
       for(int i=0 ; i<8 ; i++){
         int x;
           x=source.getX()+queenGo[i][0];
         int y;  
           y=source.getY()+queenGo[i][1];
           while(0<=x && x<8 && 0<=y && y<8){
               if(getChessColor(chessBoard[x][y].getName())==chessColor){break;}
               zero.add(new ChessboardPoint(x,y));
               if(getChessColor(chessBoard[x][y].getName())!=ChessColor.NONE){break;}
               x=x+queenGo[i][0];
               y=y+queenGo[i][1];
           }
       }
        return zero;
    }}


class RookChessComponent extends ChessComponent{
    public RookChessComponent(ChessboardPoint source,ChessColor chessColor){
        super(source,chessColor);
        this.name=chessColor==ChessColor.BLACK?'R':'r';
    }
    //final int[][] move=new int[][]{{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> zero=new ArrayList<>();
        int[][] rookGo=new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        int x=source.getX();
        int y=source.getY();
        for(int i=0; i<4 ; i++) {
            x = source.getX() + rookGo[i][0];
            y = source.getY() + rookGo[i][1];
            while(0<=x && x<8 && 0<=y && y<8){
                if(getChessColor(chessBoard[x][y].getName())==chessColor){
                    break;
                }
                zero.add(new ChessboardPoint(x,y));
                if(getChessColor(chessBoard[x][y].getName())==ChessColor.BLACK || getChessColor (chessBoard[x][y].getName())==ChessColor.WHITE){
                    break;
                }
                x=x+rookGo[i][0];
                y=y+rookGo[i][1];
            }
        }
        return zero;
    }

}
class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(ChessboardPoint source,ChessColor chessColor){
        super(source,chessColor);
        this.name=chessColor==ChessColor.BLACK?'B':'b';
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> zero=new ArrayList<>();
        int[][] bishopGo= new int[][]{{-1,-1},{-1,1},{1,-1},{1,1}};
        for(int i=0 ; i<4 ; i++){
            int x;
            x=source.getX()+bishopGo[i][0];
            int y;
            y=source.getY()+bishopGo[i][1];
            while(0<=x && x<8 && 0<=y && y<8){
                if(getChessColor(chessBoard[x][y].getName())==chessColor){break;}
                zero.add(new ChessboardPoint(x,y));
                if(getChessColor(chessBoard[x][y].getName())!=ChessColor.NONE){break;}
                x=x+bishopGo[i][0];
                y=y+bishopGo[i][1];
            }
        }
        return zero;
    }

}
class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(ChessboardPoint source,ChessColor chessColor){
        super(source,chessColor);
        this.name=chessColor==ChessColor.BLACK?'N':'n';
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> zero=new ArrayList<>();
        int[][] knightGo=new int[][]{{-2,-1},{2,-1},{-1,-2},{1,-2},{-2,1},{2,1},{-1,2},{1,2}}   ;
        for(int i=0 ; i<8; i++){
            int x;
            x=source.getX()+knightGo[i][0];
            int y;
            y=source.getY()+knightGo[i][1];
            if(0<=x && x<8 && 0<=y && y<8){
                if(   getChessColor(chessBoard[x][y].getName())!=chessColor){
                    zero.add(new ChessboardPoint(x,y));
                }
            }
        }
        return zero;
    }

}
class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(ChessboardPoint source,ChessColor chessColor){
        super(source,chessColor);
        this.name=chessColor==ChessColor.BLACK?'P':'p';
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> zero=new ArrayList<>();
        int x=source.getX(),y=source.getY();
        if(chessColor==ChessColor.WHITE){
            if(x-1>=0&&getChessColor(chessBoard[x-1][y].toString().charAt(0))==ChessColor.NONE){
                zero.add(new ChessboardPoint(x-1,y));
                if(x==6&&getChessColor(chessBoard[x-2][y].toString().charAt(0))==ChessColor.NONE){
                    zero.add(new ChessboardPoint(x-2,y));
                }
            }
            if(y-1>=0&&getChessColor(chessBoard[x-1][y-1].toString().charAt(0))==ChessColor.BLACK){
                zero.add(new ChessboardPoint(x-1,y-1));
            }
            if(y+1<8&&getChessColor(chessBoard[x-1][y+1].toString().charAt(0))==ChessColor.BLACK){
                zero.add(new ChessboardPoint(x-1,y+1));
            }
        }
        else{
            if(x+1<8&&getChessColor(chessBoard[x+1][y].toString().charAt(0))==ChessColor.NONE){
                zero.add(new ChessboardPoint(x+1,y));
                if(x==1&&getChessColor(chessBoard[x+2][y].toString().charAt(0))==ChessColor.NONE){
                    zero.add(new ChessboardPoint(x+2,y));
                }
            }
            if(y-1>=0&&getChessColor(chessBoard[x+1][y-1].toString().charAt(0))==ChessColor.WHITE){
                zero.add(new ChessboardPoint(x+1,y-1));
            }
            if(y+1<8&&getChessColor(chessBoard[x+1][y+1].toString().charAt(0))==ChessColor.WHITE){
                zero.add(new ChessboardPoint(x+1,y+1));
            }
        }
        return zero;
    }

}
class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent(ChessboardPoint source,ChessColor chessColor){
        super(source,chessColor);
        this.name='_';
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }

}