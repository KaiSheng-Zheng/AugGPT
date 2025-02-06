
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    private ChessColor color;
    public KnightChessComponent(){
        if (name=='N')
            color=ChessColor.BLACK;
        else if (name=='n')
            color=ChessColor.WHITE;
    }
    public ChessColor getColor() {
        return color;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}
