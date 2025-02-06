import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    public KingChessComponent(int x,int y,ChessColor chessColor,ConcreteChessGame concreteChessGame){
        this.concreteChessGame=concreteChessGame;
        setSource(new ChessboardPoint(x, y));
        setChessColor(chessColor);
        if (chessColor==ChessColor.BLACK){
            name='K';
        }
        if (chessColor==ChessColor.WHITE){
            name='k';
        }
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> result=new ArrayList<>();
        ChessboardPoint w=this.getSource();
        if (w.offset(1,1)!=null
             &&concreteChessGame.getChess(w.offset(1,1)).getChessColor()!=this.getChessColor()){
            result.add(w.offset(1,1));
        }
        if (w.offset(1,0)!=null
                &&concreteChessGame.getChess(w.offset(1,0)).getChessColor()!=this.getChessColor()){
            result.add(w.offset(1,0));
        }
        if (w.offset(1,-1)!=null
                &&concreteChessGame.getChess(w.offset(1,-1)).getChessColor()!=this.getChessColor()){
            result.add(w.offset(1,-1));
        }
        if (w.offset(0,1)!=null
                &&concreteChessGame.getChess(w.offset(0,1)).getChessColor()!=this.getChessColor()){
            result.add(w.offset(0,1));
        }
        if (w.offset(0,-1)!=null
                &&concreteChessGame.getChess(w.offset(0,-1)).getChessColor()!=this.getChessColor()){
            result.add(w.offset(0,-1));
        }
        if (w.offset(-1,1)!=null
                &&concreteChessGame.getChess(w.offset(-1,1)).getChessColor()!=this.getChessColor()){
            result.add(w.offset(-1,1));
        }
        if (w.offset(-1,0)!=null
                &&concreteChessGame.getChess(w.offset(-1,0)).getChessColor()!=this.getChessColor()){
            result.add(w.offset(-1,0));
        }
        if (w.offset(-1,-1)!=null
                &&concreteChessGame.getChess(w.offset(-1,-1)).getChessColor()!=this.getChessColor()){
            result.add(w.offset(-1,-1));
        }
        return result;
    }
}
