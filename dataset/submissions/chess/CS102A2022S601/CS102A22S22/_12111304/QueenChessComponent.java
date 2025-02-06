import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{

    public QueenChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source, chessColor);
        if (chessColor == ChessColor.BLACK){
            this.name = 'Q';
        }else if (chessColor == ChessColor.WHITE){
            this.name = 'q';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<>();
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0){
                    continue;
                }
                ChessboardPoint cur = getSource();
                while (true) {
                    cur = cur.offset(i, j);
                    if (cur == null) {
                        break;
                    }
                    ChessComponent component = board[cur.getX()][cur.getY()];
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
        }
        return list;
    }
}
