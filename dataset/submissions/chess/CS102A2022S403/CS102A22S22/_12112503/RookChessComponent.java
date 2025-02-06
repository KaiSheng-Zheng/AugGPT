import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    public RookChessComponent(char name,ChessColor chessColor,ChessboardPoint source){
        super(name,chessColor,source);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> arrayList = new ArrayList<>();
        ChessComponent chessComponent = new KingChessComponent(getName(),getChessColor(),getSource());
        for (int i=0;i<8;i++){
            if (getSource().offset(i,0)!=null){
                arrayList.add(getSource().offset(i,0));
            }
            if (getSource().offset(0,i)!=null){
                arrayList.add(getSource().offset(0,i));
            }
            if (getSource().offset(0,-i)!=null){
                arrayList.add(getSource().offset(0,-i));
            }
            if (getSource().offset(-i,0)!=null){
                arrayList.add(getSource().offset(-i,0));
            }
        }
        return arrayList;
    }
}