import java.util.List;

public class PawnChessComponent extends ChessComponent {

    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor) {


        this.chessColor=chessColor;
        super.source = source;
        if (super.chessColor.getName().equals("Black"))
            super.name = 'P';
        if (super.chessColor.getName().equals("White"))
            super.name = 'p';
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }

    public String toString() {
        return String.valueOf(this.name);
    }
}