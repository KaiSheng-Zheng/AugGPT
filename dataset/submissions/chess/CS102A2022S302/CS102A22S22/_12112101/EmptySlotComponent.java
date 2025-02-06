import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent(int x, int y) {
        this.source = new ChessboardPoint(x,y);
        chessColor=ChessColor.NONE;
        name ='_';

    }


    @Override
    public List<ChessboardPoint> canMoveTo() {

        return new ArrayList<>();
    }
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    public boolean canMoveTo1(int x, int y) {
        return false;
    }

    public char getName() {
        return name;
    }
}
