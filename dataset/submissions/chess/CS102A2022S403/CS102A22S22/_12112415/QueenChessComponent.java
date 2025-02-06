import java.util.ArrayList;
import java.util.List;
public class QueenChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    public QueenChessComponent(ChessboardPoint source,ChessColor chessColor,char name){
        this.source=source;
        this.chessColor=chessColor;
        this.name=name;
    }
    QueenChessComponent Q=new QueenChessComponent(new ChessboardPoint(0,3),ChessColor.BLACK,'Q');
    QueenChessComponent q=new QueenChessComponent(new ChessboardPoint(7,3),ChessColor.WHITE,'q');
    @Override
    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> list=new ArrayList<>();
        for (int i = -source.getX(); i < 8-source.getX(); i++) {
            if (i==0)continue;
            list.add(source.offset(0,i));
            if(source.offset(i,-i)!=null){
                list.add(source.offset(i,-i));
            }
            if(source.offset(i,i)!=null){
                list.add(source.offset(i,i));
            }
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
