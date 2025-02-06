import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
//    public EmptySlotComponent(ChessboardPoint chessboardPoint,ChessColor chessColor,char name){
//        super();
//        super.setSource(chessboardPoint);
//        super.setChessColor(chessColor);
//        super.setName(name);
//    }
private ChessComponent[][] chessComponents;

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
    @Override
    public String toString(){
       return "_";
    }

}
