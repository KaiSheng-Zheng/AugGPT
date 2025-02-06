import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{

    public KingChessComponent(ChessColor chessColor, ChessboardPoint source) {
        super.source = source;
        super.chessColor = chessColor;
        super.name = 'K';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canmove = new ArrayList<>();
        ChessboardPoint move;

/*        move = super.source.offset(1, 0);
        if(move != null)
        {
            ChessComponent thereC = chessboard.getChess(move);
            if(thereC.getName() != '_')
            {
                if(thereC.getChessColor() == chessColor);
                else
                    canmove.add(move);
            }
            canmove.add((move));
        }*/

        /*for (int i = 1; i <= 1; i ++)
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
        }*/

        return canmove;
    }
}
