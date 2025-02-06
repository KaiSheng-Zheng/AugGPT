import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{

    public EmptySlotComponent(ChessColor chessColor,ChessboardPoint source) {
        this.name = '_';
        this.setChessColor(chessColor);
        this.setSource(source);
    }

    public List<ChessboardPoint> canMoveTo(){
        ArrayList<ChessboardPoint> coordinates=new ArrayList<>();
        return coordinates;
    }

    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}

