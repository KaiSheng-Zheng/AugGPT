import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        int factor = getChessColor() == ChessColor.WHITE ? -1 : 1;

        return new ArrayList<>();
    }

    @Override
    public String toString() {
        return getChessColor() == ChessColor.WHITE ? "p" : "P";
    }

    @Override
    public void giveValueTo(ChessComponent target) {
        target = new PawnChessComponent();
        target.setChessColor(this.getChessColor());
        target.setSource(new ChessboardPoint(this.getSource().getX(), this.getSource().getY()));
    }
}
