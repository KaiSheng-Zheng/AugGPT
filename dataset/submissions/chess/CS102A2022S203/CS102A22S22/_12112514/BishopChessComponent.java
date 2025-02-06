
import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {
    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source, chessColor);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<>();
        int[] dx = {-1, -1, 1, 1};
        int[] dy = {1, -1, 1, -1};
        for (int i = 0; i < 4; i++) {
            ChessboardPoint cur = getSource();
            while (true) {
                cur = cur.offset(dx[i], dy[i]);
                if (cur == null) {
                    break;
                }
                ChessComponent component = ConcreteChessGame.chesscomponents[cur.getX()][cur.getY()];
                if (component.getChessColor() == this.getChessColor()) {
                    break;
                }
                list.add(cur);
                if (component.getChessColor() != ChessColor.NONE){
                    break;
                }
            }
        }
        return list;
    }
}
