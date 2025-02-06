import java.util.ArrayList;
import java.util.List;
public abstract class ChessComponent {
     ChessboardPoint source;
     ChessColor chessColor;
    protected char name;
    ChessComponent[][] chessBoard;
    final int[][] move=new int[][]{{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};
    void loadNowChessboard(ChessComponent[][] chessBoard){
        this.chessBoard=chessBoard;
    }
    ChessColor getComponentColor(char component){
        return (component=='_')?ChessColor.NONE:((component>='A'&&component<='Z')?ChessColor.BLACK:ChessColor.WHITE);
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
        if(chessColor==ChessColor.BLACK){
            this.name='Q';
        }else {
            this.name = 'q';
        }
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> canmoveto=new ArrayList<>();
        for(int dir=0,x=source.getX(),y=source.getY();dir<8;dir++,x=source.getX(),y=source.getY()){
            x+=move[dir][0];
            y+=move[dir][1];
            while(x>=0&&x<8&&y>=0&&y<8){
                if(getComponentColor(chessBoard[x][y].toString().charAt(0))==chessColor){
                    break;
                }
                canmoveto.add(new ChessboardPoint(x,y));
                if(getComponentColor(chessBoard[x][y].toString().charAt(0))!=ChessColor.NONE){
                    break;
                }
                x+=move[dir][0];
                y+=move[dir][1];
            }
        }
        return canmoveto;
    }

}
class RookChessComponent extends ChessComponent{
    public RookChessComponent(ChessboardPoint source,ChessColor chessColor){
        super(source,chessColor);
        if(chessColor==ChessColor.BLACK){
            this.name='R';
        }else {
            this.name = 'r';
        }
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> canmoveto=new ArrayList<>();
        for(int dir=1,x=source.getX(),y=source.getY();dir<8;dir+=2,x=source.getX(),y=source.getY()){
            x+=move[dir][0];
            y+=move[dir][1];
            while(x>=0&&x<8&&y>=0&&y<8){
                if(getComponentColor(chessBoard[x][y].toString().charAt(0))==chessColor){
                    break;
                }
                canmoveto.add(new ChessboardPoint(x,y));
                if(getComponentColor(chessBoard[x][y].toString().charAt(0))!=ChessColor.NONE){
                    break;
                }
                x+=move[dir][0];
                y+=move[dir][1];
            }
        }
        return canmoveto;
    }

}
class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(ChessboardPoint source,ChessColor chessColor){
        super(source,chessColor);
        if(chessColor==ChessColor.BLACK){
            this.name='B';
        }else {
            this.name = 'b';
        }
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> canmoveto=new ArrayList<>();
        for(int dir=0,x=source.getX(),y=source.getY();dir<8;dir+=2,x=source.getX(),y=source.getY()){
            x+=move[dir][0];
            y+=move[dir][1];
            while(x>=0&&x<8&&y>=0&&y<8){
                if(getComponentColor(chessBoard[x][y].toString().charAt(0))==chessColor){
                    break;
                }
                canmoveto.add(new ChessboardPoint(x,y));
                if(getComponentColor(chessBoard[x][y].toString().charAt(0))!=ChessColor.NONE){
                    break;
                }
                x+=move[dir][0];
                y+=move[dir][1];
            }
        }
        return canmoveto;
    }

}
class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(ChessboardPoint source,ChessColor chessColor){
        super(source,chessColor);
        if(chessColor==ChessColor.BLACK){
            this.name='N';
        }else {
            this.name = 'n';
        }
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        int[][] knightMove=new int[][]{{-2,-1},{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2}};
        ArrayList<ChessboardPoint> canmoveto=new ArrayList<>();
        for(int dir=0;dir<8;dir++){
            ChessboardPoint newPlace=source.offset(knightMove[dir][0],knightMove[dir][1]);
            if(newPlace!=null&&getComponentColor(chessBoard[newPlace.getX()][newPlace.getY()].toString().charAt(0))!=chessColor){
                canmoveto.add(newPlace);
            }
        }
        return canmoveto;
    }

}
class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(ChessboardPoint source,ChessColor chessColor){
        super(source,chessColor);
        if(chessColor==ChessColor.BLACK){
            this.name='P';
        }else {
            this.name = 'p';
        }
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> canmoveto=new ArrayList<>();
        
        return canmoveto;
    }

}
class EmptyComponent extends ChessComponent{
    public EmptyComponent(ChessboardPoint source,ChessColor chessColor){
        super(source,chessColor);
        this.name='_';
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }

}
