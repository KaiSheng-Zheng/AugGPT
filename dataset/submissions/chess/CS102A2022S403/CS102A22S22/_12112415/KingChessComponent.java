import java.util.ArrayList;
import java.util.List;
public class KingChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    public KingChessComponent(ChessboardPoint source,ChessColor chessColor,char name){
        this.source=source;
        this.chessColor=chessColor;
        this.name=name;
    }
    KingChessComponent K=new KingChessComponent(new ChessboardPoint(0,4),ChessColor.BLACK,'K');
    KingChessComponent k=new KingChessComponent(new ChessboardPoint(7,4),ChessColor.WHITE,'k');
    @Override
    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> list=new ArrayList<>();
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (i==0&&j==0)continue;
                if(source.offset(i,j)!=null){
                    list.add(source.offset(i,j));
                }
            }
        }
        return list;
    }
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}
//private ChessboardPoint source=new ChessboardPoint(7,4);
//    private ChessColor chessColor=ChessColor.BLACK;
//    protected char name='K';
