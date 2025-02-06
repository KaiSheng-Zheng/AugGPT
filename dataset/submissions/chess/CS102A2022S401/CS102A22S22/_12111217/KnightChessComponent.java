import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(int x,int y,ChessColor chessColor,ConcreteChessGame concreteChessGame){
        this.concreteChessGame=concreteChessGame;
        setSource(new ChessboardPoint(x,y));
        setChessColor(chessColor);
        if (chessColor==ChessColor.BLACK){
            name='N';
        }
        if (chessColor==ChessColor.WHITE){
            name='n';
        }
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> result=new ArrayList<>();
        ChessboardPoint w=this.getSource();
        if (w.offset(1,2)!=null
                &&concreteChessGame.getChess(w.offset(1,2)).getChessColor()!=this.getChessColor()){
            result.add(w.offset(1,2));
        }
        if (w.offset(1,-2)!=null
                &&concreteChessGame.getChess(w.offset(1,-2)).getChessColor()!=this.getChessColor()){
            result.add(w.offset(1,-2));
        }
        if (w.offset(2,-1)!=null
                &&concreteChessGame.getChess(w.offset(2,-1)).getChessColor()!=this.getChessColor()){
            result.add(w.offset(2,-1));
        }
        if (w.offset(2,1)!=null
                &&concreteChessGame.getChess(w.offset(2,1)).getChessColor()!=this.getChessColor()){
            result.add(w.offset(2,1));
        }
        if (w.offset(-1,2)!=null
                &&concreteChessGame.getChess(w.offset(-1,2)).getChessColor()!=this.getChessColor()){
            result.add(w.offset(-1,2));
        }
        if (w.offset(-1,-2)!=null
                &&concreteChessGame.getChess(w.offset(-1,-2)).getChessColor()!=this.getChessColor()){
            result.add(w.offset(-1,-2));
        }
        if (w.offset(-2,1)!=null
                &&concreteChessGame.getChess(w.offset(-2,1)).getChessColor()!=this.getChessColor()){
            result.add(w.offset(-2,1));
        }
        if (w.offset(-2,-1)!=null
                &&concreteChessGame.getChess(w.offset(-2,-1)).getChessColor()!=this.getChessColor()){
            result.add(w.offset(-2,-1));
        }
        return result;
    }
}