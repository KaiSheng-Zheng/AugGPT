import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent {
    public EmptySlotComponent(ChessColor chessColor,int x,int y) {
        super();
        setX(x);
        setY(y);
        setChessColor(chessColor);
        name=tochar();
    }
    public List<ChessboardPoint> canMoveTo(){

        List<ChessboardPoint> a = new ArrayList<>();
        return a;
    }

    public String toSting() {
        return "_";
    }
    public char tochar() {
        return '_';
    }
    public int getType(){
        return 6;
    }
}
