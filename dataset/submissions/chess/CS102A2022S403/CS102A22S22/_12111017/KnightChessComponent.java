import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(char name) {
        if (Character.isLowerCase(name))
            super.name = 'n';
        else super.name = 'N';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}
