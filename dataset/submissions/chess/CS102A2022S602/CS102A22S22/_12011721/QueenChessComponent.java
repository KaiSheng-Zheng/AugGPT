import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{

    public QueenChessComponent(ChessColor chessColor, ChessboardPoint source) {
        super.source = source;
        super.chessColor = chessColor;
        super.name = 'Q';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canmove = new ArrayList<>();
        ChessboardPoint move;

        for (int i = 1; i <= 7; i ++)
        {
            move = super.source.offset(i, 0);
            if(move != null)
                canmove.add(move);
            move = super.source.offset(-i, 0);
            if(move != null)
                canmove.add(move);
            move = super.source.offset(0, i);
            if(move != null)
                canmove.add(move);
            move = super.source.offset(0, -i);
            if(move != null)
                canmove.add(move);
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
