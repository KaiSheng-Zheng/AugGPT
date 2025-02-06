import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{



    public KnightChessComponent(ChessboardPoint source,ChessColor chessColor){
        if (chessColor.equals(ChessColor.BLACK)) setName('N');
        if (chessColor.equals(ChessColor.WHITE)) setName('n');
        setChessColor(chessColor);
        setSource(source);
    }

    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list=new ArrayList<>();
        int x=this.getSource().getX();int y=this.getSource().getY();
        if (x-2<=7&&x-2>=0&&y-1<=7&&y-1>=0) list.add(new ChessboardPoint(x-2,y-1));
        if (x-2<=7&&x-2>=0&&y+1<=7&&y+1>=0) list.add(new ChessboardPoint(x-2,y+1));
        if (x-1<=7&&x-1>=0&&y-2<=7&&y-2>=0) list.add(new ChessboardPoint(x-1,y-2));
        if (x-1<=7&&x-1>=0&&y+2<=7&&y+2>=0) list.add(new ChessboardPoint(x-1,y+2));
        if (x+1<=7&&x+1>=0&&y-2<=7&&y-2>=0) list.add(new ChessboardPoint(x+1,y-2));
        if (x+1<=7&&x+1>=0&&y+2<=7&&y+2>=0) list.add(new ChessboardPoint(x+1,y+2));
        if (x+2<=7&&x+2>=0&&y-1<=7&&y-1>=0) list.add(new ChessboardPoint(x+2,y-1));
        if (x+2<=7&&x+2>=0&&y+1<=7&&y+1>=0) list.add(new ChessboardPoint(x+2,y+1));
        return list;
    }
}