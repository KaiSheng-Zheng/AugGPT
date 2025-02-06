import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{


    ChessColor chessColor;
    char name;
    public EmptySlotComponent(ChessboardPoint chessboardPoint,ChessColor chessColor,char name){
        super(chessboardPoint,chessColor,name);
        this.chessColor = chessColor;
        this.name = name;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }


//    @Override
//    public ChessComponent copy(int x, int y) {
//        return new EmptySlotComponent(new ChessboardPoint(x, y), this.chessColor, this.name);
//    }
}
