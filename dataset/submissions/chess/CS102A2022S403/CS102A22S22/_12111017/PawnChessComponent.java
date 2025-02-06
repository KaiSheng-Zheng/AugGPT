import java.util.List;

public class PawnChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
    public PawnChessComponent(char name){
        if (Character.isLowerCase(name))
            super.name = 'p';
        else super.name = 'P';
    }
}
