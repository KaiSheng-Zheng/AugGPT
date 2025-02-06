

import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent {
    public QueenChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source, chessColor);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<>();
        int[] dx = {0, 0, 1, -1,-1, -1, 1, 1};
        int[] dy = {1, -1, 0, 0,1, -1, 1, -1};

        for (int i = 0; i < 8; i++) {
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
                System.out.println(cur);
                if (component.getChessColor() != ChessColor.NONE){
                    break;
                }
            }
        }
        return list;
    }
}
