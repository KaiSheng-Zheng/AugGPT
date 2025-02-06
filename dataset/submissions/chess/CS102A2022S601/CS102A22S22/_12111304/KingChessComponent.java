import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{

    public KingChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source, chessColor);
        if (chessColor == ChessColor.BLACK){
            this.name = 'K';
        }else if (chessColor == ChessColor.WHITE){
            this.name = 'k';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<>();
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                ChessboardPoint newPoint = getSource().offset(i, j);
                if (newPoint != null) {
                    ChessComponent component = board[newPoint.getX()][newPoint.getY()];
                    if (component.getChessColor() != this.getChessColor()) {
                        list.add(newPoint);
                    }
                }
            }
        }
        return list;
    }
}
