import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{

    public PawnChessComponent(ChessboardPoint chessboardPoint, ChessColor chessColor, char c) {
        super(chessboardPoint, chessColor, c);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        if (this.name == '_')
            return null;
        ChessboardPoint source = this.getSource();
        ArrayList<ChessboardPoint> CanMoveTo = new ArrayList<>();
        int de = this.isWhite() ? -1 : 1;
        if (source.offset(de, 0) != null)
            if (this.getChessComponent(source.offset(de, 0)).name == '_')
                CanMoveTo.add(source.offset(de, 0));
        if (source.offset(de, -1) != null)
            if (attack(this.getChessComponent(source.offset(de, -1))))
                CanMoveTo.add(source.offset(de, -1));
        if (source.offset(de, 1) != null)
            if (attack(this.getChessComponent(source.offset(de, 1))))
                CanMoveTo.add(source.offset(de, 1));
        if (source.offset(de * 2, 0) != null) {
            if (source.getX() == 1 + (de == 1 ? 0 : 5)
                    && myContains(CanMoveTo, source.offset(de, 0))
                    && this.getChessComponent(source.offset(de * 2, 0)).name == '_')
                CanMoveTo.add(source.offset(de * 2, 0));
        }
        for (int i = 0;i < 3;i++)
            CanMoveTo.remove(null);
        return CanMoveTo;
    }

    private boolean myContains(ArrayList<ChessboardPoint> canMoveTo, ChessboardPoint offset) {
        for (ChessboardPoint i : canMoveTo)
            if (i.getX() == offset.getX() && i.getY() == offset.getY())
                return true;
        return false;
    }

    public void myShowCanMoveTo(){
        List<ChessboardPoint> CanMoveTo = canMoveTo();
        for (ChessboardPoint i : CanMoveTo)
            System.out.print(i);
    }
}
