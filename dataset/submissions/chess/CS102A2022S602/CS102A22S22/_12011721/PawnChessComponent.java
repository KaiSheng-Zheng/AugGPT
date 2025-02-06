import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    private boolean first = true;

    public PawnChessComponent(ChessColor chessColor, ChessboardPoint source) {
        super.source = source;
        super.chessColor = chessColor;
        super.name = 'P';
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public boolean isFirst() {
        return first;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canmove = new ArrayList<>();
        ChessboardPoint move;

        if(first)
        {
            move = super.source.offset(1, 0);
            if(move != null)
                canmove.add(move);
            move = super.source.offset(2, 0);
            if(move != null)
                canmove.add(move);
            first = false;
        }
        else
        {
            move = super.source.offset(1, 0);
            if(move != null)
                canmove.add(move);
        }


        return canmove;
    }
}
