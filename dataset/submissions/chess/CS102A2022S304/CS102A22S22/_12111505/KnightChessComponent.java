import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    Directions directions = new Directions();
    public KnightChessComponent(ChessColor chessColor, ChessboardPoint source) {
        super(chessColor, source,chessColor.equals(ChessColor.WHITE)?'n':'N');
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int MAS = 1;
        ArrayList<ChessboardPoint> list = new ArrayList<>();
        for (ChessboardPoint direct: directions.knight()) {
            for (int i = 1; i <= MAS; i++) {
                ChessboardPoint nextPosition = new ChessboardPoint(this.getSource().getX() + direct.getX() * i, this.getSource().getY() + direct.getY() * i);
                if (!nextPosition.offset()) {
                    if (this.getGame().getChess(nextPosition.getX(), nextPosition.getY()).getChessColor().equals(this.getChessColor())) {
                        break;
                    }
                    if(this.getGame().getChess(nextPosition.getX(), nextPosition.getY()).getChessColor().equals(ChessColor.NONE)) {
                        list.add(nextPosition);
                    } else {
                        list.add(nextPosition);
                        break;
                    }
                }
                else {
                    break;
                }
            }
        }
        return list;
    }
}