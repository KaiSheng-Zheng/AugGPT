import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{



    public KingChessComponent(ChessboardPoint source,ChessColor chessColor){
        if (chessColor.equals(ChessColor.BLACK)) setName('K');
        if (chessColor.equals(ChessColor.WHITE)) setName('k');
        setChessColor(chessColor);
        setSource(source);
    }

    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list=new ArrayList<>();
        int x=this.getSource().getX();int y=this.getSource().getY();
        if (x-1<=7&&x-1>=0&&y-1<=7&&y-1>=0) list.add(new ChessboardPoint(x-1,y-1));
        if (x-1<=7&&x-1>=0) list.add(new ChessboardPoint(x-1,y));
        if (x-1<=7&&x-1>=0&&y+1<=7&&y+1>=0) list.add(new ChessboardPoint(x-1,y+1));
        if (y-1<=7&&y-1>=0) list.add(new ChessboardPoint(x,y-1));
        if (y+1<=7&&y+1>=0) list.add(new ChessboardPoint(x,y+1));
        if (x+1<=7&&x+1>=0&&y-1<=7&&y-1>=0) list.add(new ChessboardPoint(x+1,y-1));
        if (x+1<=7&&x+1>=0) list.add(new ChessboardPoint(x+1,y));
        if (x+1<=7&&x+1>=0&&y+1<=7&&y+1>=0) list.add(new ChessboardPoint(x+1,y+1));
        return list;
    }
}