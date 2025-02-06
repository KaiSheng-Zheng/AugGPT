

import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {
    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source, chessColor);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<>();
        int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};
        for (int i=0;i<8;i++){
            ChessboardPoint newPoint = getSource().offset(dx[i], dy[i]);
            if (newPoint != null) {
                if (ConcreteChessGame.chesscomponents[newPoint.getX()][newPoint.getY()].getChessColor() != this.getChessColor()) {
                    list.add(newPoint);
                }
            }
        }
        //System.out.println(list);
        return list;
    }
}
