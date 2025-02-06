import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{


//    public EmptySlotComponent(ChessColor chessColor,ChessboardPoint source,char name,ChessComponent[][] chessComponents){
//        this.chessColor = chessColor;
//        this.source = source;
//        this.name = name;
//        this.chessComponents = chessComponents;
//    }
    public EmptySlotComponent(){

    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}
