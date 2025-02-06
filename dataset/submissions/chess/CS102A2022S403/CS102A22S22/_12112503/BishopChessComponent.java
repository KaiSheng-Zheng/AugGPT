import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(char name,ChessColor chessColor,ChessboardPoint source){
        super(name,chessColor,source);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> arrayList = new ArrayList<>();
        ChessComponent chessComponent = new BishopChessComponent(getName(),getChessColor(),getSource());
        for (int i=0;i<8;i++){
            arrayList.add(getSource().offset(i,i));
            arrayList.add(getSource().offset(-i,-i));
        }
        return arrayList;
    }
}