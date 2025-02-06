

import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent {

    private ChessColor empty_color = ChessColor.NONE;
    private List<ChessboardPoint> canmove1 = new ArrayList<>();
    public EmptySlotComponent(int x, int y, char name, List<String> chessboard) {
        setSource(new ChessboardPoint(x, y));
        super.name = name;
        super.chessboard = chessboard;

    }
    public EmptySlotComponent(int x, int y, char name){
        setSource(new ChessboardPoint(x, y));
        super.name = name;
    }


    @Override
    public ChessboardPoint getSource() {
        return super.getSource();
    }

    @Override
    public List<ChessboardPoint> canMoveTo()  {
        return canmove1;
    }

}
