import java.util.List;

public class QueenChessComponent extends ChessComponent{
    public QueenChessComponent(char name) {
        if (Character.isLowerCase(name))
            super.name = 'q';
        else super.name = 'Q';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}
