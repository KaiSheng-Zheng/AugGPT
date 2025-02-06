

import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {
    public RookChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source, chessColor);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<>();
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        for (int i = 0; i < 4; i++) {
            ChessboardPoint nimab = getSource();
            while (true) {
                nimab = nimab.offset(dx[i], dy[i]);
                if (nimab == null) {
                    break;
                }
                ChessComponent component = ConcreteChessGame.chesscomponents[nimab.getX()][nimab.getY()];
                if (component.getChessColor() == this.getChessColor()) {
                    break;
                }
                list.add(nimab);
                if (component.getChessColor() != ChessColor.NONE){
                    break;
                }
            }
        }
        return list;
    }
}
