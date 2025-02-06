import java.util.ArrayList;
import java.util.List;
public class PawnChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    public PawnChessComponent(ChessboardPoint source,ChessColor chessColor,char name){
        this.source=source;
        this.chessColor=chessColor;
        this.name=name;
    }
    PawnChessComponent P1=new PawnChessComponent(new ChessboardPoint(1,0),ChessColor.BLACK,'P');
    PawnChessComponent P2=new PawnChessComponent(new ChessboardPoint(1,1),ChessColor.BLACK,'P');
    PawnChessComponent P3=new PawnChessComponent(new ChessboardPoint(1,2),ChessColor.BLACK,'P');
    PawnChessComponent P4=new PawnChessComponent(new ChessboardPoint(1,3),ChessColor.BLACK,'P');
    PawnChessComponent P5=new PawnChessComponent(new ChessboardPoint(1,4),ChessColor.BLACK,'P');
    PawnChessComponent P6=new PawnChessComponent(new ChessboardPoint(1,5),ChessColor.BLACK,'P');
    PawnChessComponent P7=new PawnChessComponent(new ChessboardPoint(1,6),ChessColor.BLACK,'P');
    PawnChessComponent P8=new PawnChessComponent(new ChessboardPoint(1,7),ChessColor.BLACK,'P');
    PawnChessComponent p1=new PawnChessComponent(new ChessboardPoint(6,0),ChessColor.WHITE,'p');
    PawnChessComponent p2=new PawnChessComponent(new ChessboardPoint(6,1),ChessColor.WHITE,'p');
    PawnChessComponent p3=new PawnChessComponent(new ChessboardPoint(6,2),ChessColor.WHITE,'p');
    PawnChessComponent p4=new PawnChessComponent(new ChessboardPoint(6,3),ChessColor.WHITE,'p');
    PawnChessComponent p5=new PawnChessComponent(new ChessboardPoint(6,4),ChessColor.WHITE,'p');
    PawnChessComponent p6=new PawnChessComponent(new ChessboardPoint(6,5),ChessColor.WHITE,'p');
    PawnChessComponent p7=new PawnChessComponent(new ChessboardPoint(6,6),ChessColor.WHITE,'p');
    PawnChessComponent p8=new PawnChessComponent(new ChessboardPoint(6,7),ChessColor.WHITE,'p');
    @Override
    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> list=new ArrayList<>();
        if(chessColor.equals(ChessColor.BLACK)){
            if (source.getX()==1){
                list.add(source.offset(2,0));
            }
            list.add(source.offset(1,0));
        }
        if (chessColor.equals(ChessColor.WHITE)){
            if (source.getX()==6){
                list.add(source.offset(-2,0));
            }
            list.add(source.offset(-1,0));
        }
        /*if (i==0&&j==0)continue;
        if(source.offset(i,j)!=null){
            list.add(source.offset(i,j));
        }*/
        return list;
    }
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}