import java.util.ArrayList;
import java.util.List;
public class KnightChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    public KnightChessComponent(ChessboardPoint source,ChessColor chessColor,char name){
        this.source=source;
        this.chessColor=chessColor;
        this.name=name;
    }
    KnightChessComponent N1=new KnightChessComponent(new ChessboardPoint(0,1),ChessColor.BLACK,'N');
    KnightChessComponent N2=new KnightChessComponent(new ChessboardPoint(0,6),ChessColor.BLACK,'N');
    KnightChessComponent n1=new KnightChessComponent(new ChessboardPoint(7,1),ChessColor.WHITE,'n');
    KnightChessComponent n2=new KnightChessComponent(new ChessboardPoint(7,6),ChessColor.WHITE,'n');
    @Override
    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> list=new ArrayList<>();
        for (int i = -2; i <= 2; i++) {
            if (i==0)continue;
            int j = 3-Math.abs(i);
            if(source.offset(i,-j)!=null){
                list.add(source.offset(i,-j));
            }
            if(source.offset(i,j)!=null){
                list.add(source.offset(i,j));
            }
        }
        return list;
    }
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}