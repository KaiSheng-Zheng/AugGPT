import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    public KingChessComponent(ChessboardPoint chessboardPoint, ChessColor color,char name) {
        super(chessboardPoint, color, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> target = new ArrayList<>();
        ChessboardPoint source = this.getSource();
        int x = source.getX();
        int y = source.getY();
        int[] ox = {x, x, x + 1, x + 1, x + 1, x - 1, x - 1, x - 1};
        int[] oy = {y + 1, y - 1, y, y + 1, y - 1, y, y + 1, y - 1};
        if (this.getChessColor().equals(ChessColor.BLACK)) {
            for (int i = 0; i < 8; i++) {
                int a = ox[i];
                int b = oy[i];
                if (this.getConcreteGame().getChess(a, b) instanceof EmptySlotComponent) {
                    target.add(new ChessboardPoint(a, b));
                } else if (this.getConcreteGame().getChess(a, b).getChessColor().equals(ChessColor.WHITE)){
                    target.add(new ChessboardPoint(a,b));
                }
            }
        } else {
            for (int i = 0; i < 8; i++) {
                int a = ox[i];
                int b = oy[i];
                if (this.getConcreteGame().getChess(a, b) instanceof EmptySlotComponent){
                    target.add(new ChessboardPoint(a, b));
                } else if (this.getConcreteGame().getChess(a, b).getChessColor().equals(ChessColor.BLACK)){
                    target.add(new ChessboardPoint(a,b));
                }
            }
        }
        return target;
    }
}
