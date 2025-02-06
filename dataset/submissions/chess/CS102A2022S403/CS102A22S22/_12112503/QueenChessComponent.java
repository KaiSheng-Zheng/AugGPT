import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    public QueenChessComponent(char name,ChessColor chessColor,ChessboardPoint source){
        super(name,chessColor,source);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> arrayList = new ArrayList<>();
        ChessComponent chessComponent = new KingChessComponent(getName(),getChessColor(),getSource());
        for (int i=0;i<8;i++){
            arrayList.add(getSource().offset(i,0));
            arrayList.add(getSource().offset(-i,0));
            arrayList.add(getSource().offset(0,i));
            arrayList.add(getSource().offset(0,-i));
            arrayList.add(getSource().offset(i,i));
            arrayList.add(getSource().offset(i,-i));
            arrayList.add(getSource().offset(-i,i));
            arrayList.add(getSource().offset(-i,-i));
        }
        return arrayList;
    }
}