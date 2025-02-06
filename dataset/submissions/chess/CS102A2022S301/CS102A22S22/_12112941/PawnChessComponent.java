import java.util.List;

public class PawnChessComponent extends ChessComponent{
    private ChessColor color;
    public PawnChessComponent(){
        if (name=='P')
            color=ChessColor.BLACK;
        else if (name=='p')
            color=ChessColor.WHITE;
    }
    public ChessColor getColor() {
        return color;
    }
    @Override
    public List<ChessboardPoint> canMoveTo(){
        return null;
    }
}
