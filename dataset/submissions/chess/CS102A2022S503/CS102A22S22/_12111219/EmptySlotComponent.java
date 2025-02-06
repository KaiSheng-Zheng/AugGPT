import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{

    public EmptySlotComponent(ChessColor chessColor,ChessboardPoint source){
        this.setChessColor(chessColor);
        this.setSource(source);
        this.name ='_';
    }

    public  List<ChessboardPoint> canMoveTo(){

        return new ArrayList<>();
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}
