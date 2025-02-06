import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent {

    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> result=new ArrayList<>();
        return result;
    }
    public EmptySlotComponent(ChessboardPoint chessboardPoint,ChessColor chessColor,Character name){
        super(chessboardPoint,chessColor, name);
    }

     public ChessboardPoint getChessboardPoint(){
        return super.getChessboardPoint();
    }

    public ChessColor getChessColor(){
        return super.getChessColor();
    }
}