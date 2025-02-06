import java.util.List;
import java.util.ArrayList;

public abstract class ChessComponent {
    ChessboardPoint source;
    ChessColor chessColor;
    ChessComponent[][] chessBoard;

    final int[][] move=new int[][]{
            {-1,-1},{-1,0},{-1,1},{1,1},{1,-1},{1,0},{0,-1},{0,1}
    };

    protected char name;
    char component;
    char board;
    public ChessComponent(){}
    ChessColor getComponentColor(char component){
        return (component=='_')?ChessColor.NONE:((component>='A'&&component<='Z')?ChessColor.BLACK:ChessColor.WHITE);
    }
    void loadCurrentChessboard(ChessComponent[][] chessBoard) {
        this.chessBoard = chessBoard;
    }


    public ChessComponent(ChessboardPoint source , ChessColor chessColor){
        this.chessColor=chessColor;
        this.source=source;

    }


    public abstract List<ChessboardPoint> canMoveTo();

    @Override
    public String toString() {

        return  String.valueOf(this.name);
    }
}

class KingChessComponent extends ChessComponent{
    public KingChessComponent(ChessboardPoint source,ChessColor chessColor){
        super(source,chessColor);
        this.name = chessColor == ChessColor.BLACK?'K':'k';
    }

    @Override
    public List<ChessboardPoint> canMoveTo(){
        ArrayList<ChessboardPoint> moveTo=new ArrayList<>();
        int a = 2;
        int b = 5;
        for(int dir = 0 ; dir <= (a*(b-1)-1) ; dir ++){
            ChessboardPoint newPlace = source.offset(move[dir][0],move[dir][1]);
            if(newPlace != null  || getComponentColor(chessBoard[newPlace.getX()] [newPlace.getY()].toString().charAt(0))!= chessColor)
            {
                moveTo.add(newPlace);
            }
        }
        return moveTo;
    }

}



class QueenChessComponent extends ChessComponent{
    public QueenChessComponent(ChessboardPoint source,ChessColor chessColor){
        super(source,chessColor);
        this.name=chessColor==ChessColor.BLACK?'Q':'q';
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> moveTo = new ArrayList<>();
        int m = 2;
        int n = 5;
        int x=source.getX();
        int y=source.getY();
        for(int dir=0; dir <= (m*(n-1)-1)  ;dir++){
            x = move[dir][0] + 1;
            y = move[dir][1] + 1;
            while(x>=0 && x<=7 && y>=0 && y<= 7){
                if(getComponentColor(chessBoard[x][y].toString().charAt(0))==chessColor){
                    break;
                }
                moveTo.add(new ChessboardPoint(x,y));
                if(getComponentColor(chessBoard[x][y].toString().charAt(0))!=ChessColor.NONE){
                    break;
                }
                x=move[dir][0] + 1;
                y=move[dir][1] + 1;
            }
        }
        return moveTo;
    }

}


class RookChessComponent extends ChessComponent{
    public RookChessComponent(ChessboardPoint source,ChessColor chessColor){
        super(source,chessColor);
        this.name=chessColor==ChessColor.BLACK?'R':'r';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> moveTo=new ArrayList<>();
        int x=source.getX();
        int y=source.getY();
        for(int dir=1; dir <= 8; dir+=2){
            x=move[dir][0] + 1;
            y=move[dir][1] + 1;
            int a =2;
            int b =5;
            while(x>=0 && x<=(a*(b-1)-1) && y>=0 && y<=(a*(b-1)-1)){
                if(getComponentColor(chessBoard[x][y].toString().charAt(0))==chessColor){
                    break;
                }
                moveTo.add(new ChessboardPoint(x,y));
                if(getComponentColor(chessBoard[x][y].toString().charAt(0))!=ChessColor.NONE){
                    break;
                }
                x=move[dir][0]+1;
                y=move[dir][1]+1;
            }
        }
        return moveTo;
    }

}
class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(ChessboardPoint source,ChessColor chessColor){
        super(source,chessColor);
        this.name=chessColor==ChessColor.BLACK?'B':'b';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> moveTo=new ArrayList<>();
        int x=source.getX();
        int y=source.getY();
        for(int dir=0; dir<8; dir+=2){
            x=move[dir][0]+1;
            y=move[dir][1]+1;
            int a =2;
            int b =5;
            while(x>=0 && x<=(a*(b-1)-1) && y>=0 && y<=(a*(b-1)-1)){
                if(getComponentColor(chessBoard[x][y].toString().charAt(0))==chessColor){
                    break;
                }
                moveTo.add(new ChessboardPoint(x,y));
                if(getComponentColor(chessBoard[x][y].toString().charAt(0))!=ChessColor.NONE){
                    break;
                }
                x=move[dir][0] +1;
                y=move[dir][1]+1;
            }
        }
        return moveTo;
    }

}
class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(ChessboardPoint source,ChessColor chessColor){
        super(source,chessColor);
        this.name=chessColor==ChessColor.BLACK?'N':'n';
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        int[][] knightMove=new int[][]{
                {-2,-1},{-2,1},{-1,2},{-1,-2},{1,2},{1,-2},{2,1},{2,-1}
        };

        ArrayList<ChessboardPoint> moveTo=new ArrayList<>();
        for(int dir=0; dir<=7 ;dir++){
            ChessboardPoint newPlace=source.offset(knightMove[dir][0],knightMove[dir][1]);
            if(newPlace != null  &&  getComponentColor(chessBoard[newPlace.getX()][newPlace.getY()].toString().charAt(0))!= chessColor){
                moveTo.add(newPlace);
            }
        }
        return moveTo;
    }

}


class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(ChessboardPoint source,ChessColor chessColor){
        super(source,chessColor);
        this.name=chessColor==ChessColor.BLACK?'P':'p';
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> moveTo=new ArrayList<>();
        int x=source.getX();
        int y=source.getY();
        int a =2;
        int b =5;
        if(chessColor==ChessColor.WHITE){
            if(x >= a-1 && getComponentColor(chessBoard[x-1][y].toString().charAt(0))==ChessColor.NONE){
                moveTo.add(new ChessboardPoint(x-1,y));
                if(x==(a+b)-1 && getComponentColor(chessBoard[x-2][y].toString().charAt(0))==ChessColor.NONE){
                    moveTo.add(new ChessboardPoint(x-2,y));
                }
            }
            if(y>=a-1 && getComponentColor(chessBoard[x-1][y-1].toString().charAt(0))==ChessColor.BLACK){
                moveTo.add(new ChessboardPoint(x-1,y-1));
            }
            if(y <= (a+b) && getComponentColor(chessBoard[x-1][y+1].toString().charAt(0))==ChessColor.BLACK){
                moveTo.add(new ChessboardPoint(x-1,y+1));
            }
        }
        else
        {
            if(x<(8-a+1) && getComponentColor(chessBoard[x+1][y].toString().charAt(0))==ChessColor.NONE){
                moveTo.add(new ChessboardPoint(x+1,y));
                if(x==1 && getComponentColor(chessBoard[x+2][y].toString().charAt(0))==ChessColor.NONE){
                    moveTo.add(new ChessboardPoint(x+2,y));
                }
            }
            if(y > 0 && getComponentColor(chessBoard[x+1][y-1].toString().charAt(0))==ChessColor.WHITE){
                moveTo.add(new ChessboardPoint(x+1,y-1));
            }
            if(y<(a+b) && getComponentColor(chessBoard[x+1][y+1].toString().charAt(0))==ChessColor.WHITE){
                moveTo.add(new ChessboardPoint(x+1,y+1));
            }
        }
        return moveTo;
    }

}

class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent(ChessboardPoint source , ChessColor chessColor){
        super(source,chessColor);
        this.name='_';
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }

}