import java.util.ArrayList;
import java.util.List;
public class RookChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    public RookChessComponent(ChessboardPoint source,ChessColor chessColor,char name){
        this.source=source;
        this.chessColor=chessColor;
        this.name=name;
    }
    RookChessComponent R1=new RookChessComponent(new ChessboardPoint(0,0),ChessColor.BLACK,'R');
    RookChessComponent R2=new RookChessComponent(new ChessboardPoint(0,7),ChessColor.BLACK,'R');
    RookChessComponent r1=new RookChessComponent(new ChessboardPoint(7,0),ChessColor.WHITE,'r');
    RookChessComponent r2=new RookChessComponent(new ChessboardPoint(7,7),ChessColor.WHITE,'r');
    @Override
    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> list=new ArrayList<>();
        for (int i = -source.getX(); i < 8-source.getX(); i++) {
            if (i==0)continue;
            list.add(source.offset(0,i));
        }
        for (int i = -source.getY(); i < 8-source.getY(); i++) {
            if (i==0)continue;
            list.add(source.offset(i,0));
        }
        return list;
    }
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}
