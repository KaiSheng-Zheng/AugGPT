import java.util.List;

public class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(char name) {
        if (Character.isLowerCase(name))
            super.name = 'b';
        else super.name = 'B';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}
