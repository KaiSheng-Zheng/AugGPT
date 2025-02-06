
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class KnightChessComponent extends ChessComponent{

    ChessboardPoint chessboardPoint;
    private ChessComponent[][] chessComponents=new ChessComponent[8][8];
    public ChessColor chessColor;

    protected KnightChessComponent(char name,ChessboardPoint chessboardPoint , ChessComponent[][] chessComponents) {
        this.name=name;
        chessColor=name>'a'&&name<'z'?ChessColor.WHITE:ChessColor.BLACK;
        this.chessboardPoint=chessboardPoint;
        this.chessComponents=chessComponents;
    }
     public boolean moveChess(ChessboardPoint lost){
        int x= lost.getX();int y= lost.getY();
        if(chessComponents[x][y].getChessColor()!=chessColor)
            return true;
        else return false;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint a = chessboardPoint;
        List<ChessboardPoint> u = new ArrayList<>();
        u.add(a.offset(-2, -1));
        u.add(a.offset(-2, 1));
        u.add(a.offset(-1, -2));
        u.add(a.offset(-1, 2));
        u.add(a.offset(1, -2));
        u.add(a.offset(1, 2));
        u.add(a.offset(2, -1));
        u.add(a.offset(2, 1));
        u.removeIf(Objects::isNull);
        Iterator<ChessboardPoint> it = u.iterator();
        while (it.hasNext()) {
        ChessboardPoint lost = it.next();
            if(!moveChess(lost)) {
                it.remove();
            }
        }
 return u;
    }
}
