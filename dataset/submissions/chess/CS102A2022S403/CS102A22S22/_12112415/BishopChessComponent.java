import java.util.ArrayList;
import java.util.List;
public class BishopChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    public BishopChessComponent(ChessboardPoint source,ChessColor chessColor,char name){
        this.source=source;
        this.chessColor=chessColor;
        this.name=name;
    }
    BishopChessComponent B1=new BishopChessComponent(new ChessboardPoint(0,2),ChessColor.BLACK,'B');
    BishopChessComponent B2=new BishopChessComponent(new ChessboardPoint(0,5),ChessColor.BLACK,'B');
    BishopChessComponent b1=new BishopChessComponent(new ChessboardPoint(7,2),ChessColor.WHITE,'b');
    BishopChessComponent b2=new BishopChessComponent(new ChessboardPoint(7,5),ChessColor.WHITE,'b');
    @Override
    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> list=new ArrayList<>();
        for (int i = -source.getX(); i < 8-source.getX(); i++) {
            if (i==0)continue;
            if(source.offset(i,-i)!=null){
                list.add(source.offset(i,-i));
            }
            if(source.offset(i,i)!=null){
                list.add(source.offset(i,i));
            }
        }
        return list;
    }
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}
