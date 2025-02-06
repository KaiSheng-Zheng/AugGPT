import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    private ConcreteChessGame concreteChessGame;
    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ConcreteChessGame concreteChessGame) {
        this.setChessColor(chessColor);
        this.setSource(source);
        this.name = name;
        this.concreteChessGame=concreteChessGame;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<ChessboardPoint>();
        int x=this.getChessboardPoint().getX();
        int y=this.getChessboardPoint().getY();
        if(!isOutOfBound(x-1,y) && this.concreteChessGame.getChess(x-1,y).getChessColor()!=this.getChessColor()){
            list.add(new ChessboardPoint(x-1,y));
        }
        if(!isOutOfBound(x+1,y) && this.concreteChessGame.getChess(x+1,y).getChessColor()!=this.getChessColor()){
            list.add(new ChessboardPoint(x+1,y));
        }
        if(!isOutOfBound(x,y-1) && this.concreteChessGame.getChess(x,y-1).getChessColor()!=this.getChessColor()){
            list.add(new ChessboardPoint(x,y-1));
        }
        if(!isOutOfBound(x,y+1) && this.concreteChessGame.getChess(x,y+1).getChessColor()!=this.getChessColor()){
            list.add(new ChessboardPoint(x,y+1));
        }
        if(!isOutOfBound(x+1,y+1) && this.concreteChessGame.getChess(x+1,y+1).getChessColor()!=this.getChessColor()){
            list.add(new ChessboardPoint(x+1,y+1));
        }
        if(!isOutOfBound(x-1,y+1) && this.concreteChessGame.getChess(x-1,y+1).getChessColor()!=this.getChessColor()){
            list.add(new ChessboardPoint(x-1,y+1));
        }
        if(!isOutOfBound(x+1,y-1) && this.concreteChessGame.getChess(x+1,y-1).getChessColor()!=this.getChessColor()){
            list.add(new ChessboardPoint(x+1,y-1));
        }
        if(!isOutOfBound(x-1,y-1) && this.concreteChessGame.getChess(x-1,y-1).getChessColor()!=this.getChessColor()){
            list.add(new ChessboardPoint(x-1,y-1));
        }
        return list;
    }
}
