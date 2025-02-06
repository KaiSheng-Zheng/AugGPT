import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(char name,ChessColor chessColor,ChessboardPoint source){
        super(name,chessColor,source);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> arrayList = new ArrayList<>();
        ChessComponent chessComponent = new PawnChessComponent(getName(),getChessColor(),getSource());
        arrayList.add(getSource().offset(1,0));
        arrayList.add(getSource().offset(2,0));
        return arrayList;
    }
}