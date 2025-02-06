import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{

    public BishopChessComponent(ChessColor chessColor, ChessboardPoint source) {
        super.source = source;
        super.chessColor = chessColor;
        super.name = 'B';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canmove = new ArrayList<>();
        ChessboardPoint move;

        for (int i = 1; i <= 7; i ++)
        {
            move = super.source.offset(i, i);
            if(move != null)
                canmove.add(move);
            move = super.source.offset(-i, -i);
            if(move != null)
                canmove.add(move);
            move = super.source.offset(i, -i);
            if(move != null)
                canmove.add(move);
            move = super.source.offset(-i, i);
            if(move != null)
                canmove.add(move);

        }

        return canmove;
    }
}
