import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        this.name = name;
        this.setSource(source);
        this.setChessColor(chessColor);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> pawnsteps = new ArrayList<>();
        ChessboardPoint pawn = new ChessboardPoint(getSource().getX(), getSource().getY());
        if (getChessColor() == ChessColor.BLACK) {
            if (pawn.getX() == 1) {
                pawnsteps.add(pawn.offset(1, 0));
                pawnsteps.add(pawn.offset(2, 0));
            } else if (pawn.offset(1, 0) != null) {
                pawnsteps.add(pawn.offset(1, 0));
            }
        } else {
            if (pawn.getX() == 6) {
                pawnsteps.add(pawn.offset(-1, 0));
                pawnsteps.add(pawn.offset(-1, 0));
            } else if (pawn.offset(-1, 0) != null) {
                pawnsteps.add(pawn.offset(-1, 0));
            }
        }
        return pawnsteps;
    }
}
