import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(char name,ChessColor chessColor,ChessboardPoint source){
        super(name,chessColor,source);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> arrayList = new ArrayList<>();
        ChessComponent chessComponent = new KnightChessComponent(getName(),getChessColor(),getSource());
        arrayList.add(getSource().offset(1,2));
        arrayList.add(getSource().offset(2,1));
        arrayList.add(getSource().offset(1,-2));
        arrayList.add(getSource().offset(2,-1));
        arrayList.add(getSource().offset(-1,2));
        arrayList.add(getSource().offset(-2,1));
        arrayList.add(getSource().offset(-1,-2));
        arrayList.add(getSource().offset(-2,-1));
        return arrayList;
    }
}