import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{

    public RookChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source, chessColor);
        if (chessColor == ChessColor.BLACK){
            this.name = 'R';
        }else if (chessColor == ChessColor.WHITE){
            this.name = 'r';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<>();
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        for (int i = 0; i < 4; i++) {
            ChessboardPoint cur = getSource();
            while (true) {
                cur = cur.offset(dx[i], dy[i]);
                if (cur == null) {
                    break;
                }
                ChessComponent component = board[cur.getX()][cur.getY()];
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
