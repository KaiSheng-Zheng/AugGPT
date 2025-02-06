import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    private final int ID=6;
    private ChessColor chessColor=ChessColor.NONE;

    public EmptySlotComponent(){
        super();
        name='_';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }


    public char getName() {
        return '_';
    }

    public String toString() {return String.valueOf(this.name);}

    public int getID() {
        return ID;
    }

    @Override
    public ChessColor getChessColor() {
        return chessColor;
    }
}
