import java.util.*;

public class KnightChessComponent extends ChessComponent{
    private ConcreteChessGame concreteChessGame;
    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ConcreteChessGame concreteChessGame){
        this.setChessColor(chessColor);
        this.setSource(source);
        this.name=name;
        this.concreteChessGame=concreteChessGame;
    }
    @Override
    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> list=new ArrayList<ChessboardPoint>();
        int x=this.getChessboardPoint().getX();
        int y=this.getChessboardPoint().getY();
        if(!isOutOfBound(x-2,y-1)&&
        this.concreteChessGame.getChess(x-2,y-1).getChessColor()!=this.getChessColor()){
            list.add(new ChessboardPoint(x-2,y-1));
        }
        if(!isOutOfBound(x-2,y+1)&&
        this.concreteChessGame.getChess(x-2,y+1).getChessColor()!=this.getChessColor()){
            list.add(new ChessboardPoint(x-2,y+1));
        }
        if(!isOutOfBound(x+2,y-1)&&
        this.concreteChessGame.getChess(x+2,y-1).getChessColor()!=this.getChessColor()){
            list.add(new ChessboardPoint(x+2,y-1));
        }
        if(!isOutOfBound(x+2,y+1)&&
        this.concreteChessGame.getChess(x+2,y+1).getChessColor()!=this.getChessColor()){
            list.add(new ChessboardPoint(x+2,y+1));
        }
        if(!isOutOfBound(x+1,y-2)&&
        this.concreteChessGame.getChess(x+1,y-2).getChessColor()!=this.getChessColor()){
            list.add(new ChessboardPoint(x+1,y-2));
        }
        if(!isOutOfBound(x-1,y-2)&&
        this.concreteChessGame.getChess(x-1,y-2).getChessColor()!=this.getChessColor()){
            list.add(new ChessboardPoint(x-1,y-2));
        }
        if(!isOutOfBound(x+1,y+2)&&
        this.concreteChessGame.getChess(x+1,y+2).getChessColor()!=this.getChessColor()){
            list.add(new ChessboardPoint(x+1,y+2));
        }
        if(!isOutOfBound(x-1,y+2)&&
        this.concreteChessGame.getChess(x-1,y+2).getChessColor()!=this.getChessColor()){
            list.add(new ChessboardPoint(x-1,y+2));
        }
        return list;
    }
}
