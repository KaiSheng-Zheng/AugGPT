import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    public KingChessComponent(char name,ChessColor chessColor,ChessboardPoint source){
        super(name,chessColor,source);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> arrayList = new ArrayList<>();
        ChessComponent chessComponent = new KingChessComponent(getName(),getChessColor(),getSource());
            arrayList.add(getSource().offset(1,0));
            arrayList.add(getSource().offset(-1,0));
            arrayList.add(getSource().offset(0,1));
            arrayList.add(getSource().offset(0,-1));
            arrayList.add(getSource().offset(1,1));
            arrayList.add(getSource().offset(1,-1));
            arrayList.add(getSource().offset(-1,1));
            arrayList.add(getSource().offset(-1,-1));
        return arrayList;
    }
}
