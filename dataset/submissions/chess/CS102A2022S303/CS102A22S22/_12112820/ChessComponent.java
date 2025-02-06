import java.util.ArrayList;
import java.util.List; 

public abstract class ChessComponent {
    ChessboardPoint source; // Where the chess is
    ChessColor chessColor;  // What's the color
    ChessComponent[][] chessBoard;//On what board
    final int[][] move=new int[][]{{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};
    protected char name;			// What's the name
    ChessColor getComponentColor(char component){
        return (component=='_')?ChessColor.NONE:((component>='A'&&component<='Z')?ChessColor.BLACK:ChessColor.WHITE);
    }
    void loadCurrentChessboard(ChessComponent[][] chessBoard){
        this.chessBoard=chessBoard;
    }
    public ChessComponent(){}
    public ChessComponent(ChessboardPoint source,ChessColor chessColor){
        this.source=source;
        this.chessColor=chessColor;
    }
    public abstract List<ChessboardPoint> canMoveTo();
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
    public List<ChessboardPoint> canMoveTo(){
        ArrayList<ChessboardPoint> moveTo=new ArrayList<>();
        for(int dir=0;dir<8;dir++){
            ChessboardPoint newPlace=source.offset(move[dir][0],move[dir][1]);
            if(newPlace!=null&&getComponentColor(chessBoard[newPlace.getX()][newPlace.getY()].toString().charAt(0))!=chessColor){
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
        ArrayList<ChessboardPoint> moveTo=new ArrayList<>();
        for(int dir=0,x=source.getX(),y=source.getY();dir<8;dir++,x=source.getX(),y=source.getY()){
            x+=move[dir][0];
            y+=move[dir][1];
            while(x>=0&&x<8&&y>=0&&y<8){
                if(getComponentColor(chessBoard[x][y].toString().charAt(0))==chessColor){
                    break;
                }
                moveTo.add(new ChessboardPoint(x,y));
                if(getComponentColor(chessBoard[x][y].toString().charAt(0))!=ChessColor.NONE){
                    break;
                }
                x+=move[dir][0];
                y+=move[dir][1];
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
        for(int dir=1,x=source.getX(),y=source.getY();dir<8;dir+=2,x=source.getX(),y=source.getY()){
            x+=move[dir][0];
            y+=move[dir][1];
            while(x>=0&&x<8&&y>=0&&y<8){
                if(getComponentColor(chessBoard[x][y].toString().charAt(0))==chessColor){
                    break;
                }
                moveTo.add(new ChessboardPoint(x,y));
                if(getComponentColor(chessBoard[x][y].toString().charAt(0))!=ChessColor.NONE){
                    break;
                }
                x+=move[dir][0];
                y+=move[dir][1];
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
        for(int dir=0,x=source.getX(),y=source.getY();dir<8;dir+=2,x=source.getX(),y=source.getY()){
            x+=move[dir][0];
            y+=move[dir][1];
            while(x>=0&&x<8&&y>=0&&y<8){
                if(getComponentColor(chessBoard[x][y].toString().charAt(0))==chessColor){
                    break;
                }
                moveTo.add(new ChessboardPoint(x,y));
                if(getComponentColor(chessBoard[x][y].toString().charAt(0))!=ChessColor.NONE){
                    break;
                }
                x+=move[dir][0];
                y+=move[dir][1];
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
        int[][] knightMove=new int[][]{{-2,-1},{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2}};
        ArrayList<ChessboardPoint> moveTo=new ArrayList<>();
        for(int dir=0;dir<8;dir++){
            ChessboardPoint newPlace=source.offset(knightMove[dir][0],knightMove[dir][1]);
            if(newPlace!=null&&getComponentColor(chessBoard[newPlace.getX()][newPlace.getY()].toString().charAt(0))!=chessColor){
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
        int x=source.getX(),y=source.getY();
        if(chessColor==ChessColor.WHITE){
            if(x-1>=0&&getComponentColor(chessBoard[x-1][y].toString().charAt(0))==ChessColor.NONE){
                moveTo.add(new ChessboardPoint(x-1,y));
                if(x==6&&getComponentColor(chessBoard[x-2][y].toString().charAt(0))==ChessColor.NONE){
                    moveTo.add(new ChessboardPoint(x-2,y));
                }
            }
            if(y-1>=0&&getComponentColor(chessBoard[x-1][y-1].toString().charAt(0))==ChessColor.BLACK){
                moveTo.add(new ChessboardPoint(x-1,y-1));
            }
            if(y+1<8&&getComponentColor(chessBoard[x-1][y+1].toString().charAt(0))==ChessColor.BLACK){
                moveTo.add(new ChessboardPoint(x-1,y+1));
            }
        }
        else{
            if(x+1<8&&getComponentColor(chessBoard[x+1][y].toString().charAt(0))==ChessColor.NONE){
                moveTo.add(new ChessboardPoint(x+1,y));
                if(x==1&&getComponentColor(chessBoard[x+2][y].toString().charAt(0))==ChessColor.NONE){
                    moveTo.add(new ChessboardPoint(x+2,y));
                }
            }
            if(y-1>=0&&getComponentColor(chessBoard[x+1][y-1].toString().charAt(0))==ChessColor.WHITE){
                moveTo.add(new ChessboardPoint(x+1,y-1));
            }
            if(y+1<8&&getComponentColor(chessBoard[x+1][y+1].toString().charAt(0))==ChessColor.WHITE){
                moveTo.add(new ChessboardPoint(x+1,y+1));
            }
        }
        return moveTo;
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