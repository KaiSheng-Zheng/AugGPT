import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{

    public KnightChessComponent(ChessColor chessColor, ChessboardPoint source) {
        super.source = source;
        super.chessColor = chessColor;
        super.name = 'N';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canmove = new ArrayList<>();
        ChessboardPoint move;

            move = super.source.offset(1, 2);
            if(move != null)
                canmove.add(move);
            move = super.source.offset(-1, 2);
            if(move != null)
                canmove.add(move);
            move = super.source.offset(1, -2);
            if(move != null)
                canmove.add(move);
            move = super.source.offset(-1, -2);
            if(move != null)
                canmove.add(move);
            move = super.source.offset(2, 1);
            if(move != null)
                canmove.add(move);
            move = super.source.offset(-2, -1);
            if(move != null)
                canmove.add(move);
            move = super.source.offset(2, -1);
            if(move != null)
                canmove.add(move);
            move = super.source.offset(-2, 1);
            if(move != null)
                canmove.add(move);


        return canmove;
    }
}
