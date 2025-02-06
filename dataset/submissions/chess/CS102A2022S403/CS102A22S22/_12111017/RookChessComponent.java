import java.util.List;

public class RookChessComponent extends ChessComponent{
    public RookChessComponent(char name) {
        if (Character.isLowerCase(name))
            super.name = 'r';
        else super.name = 'R';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}
