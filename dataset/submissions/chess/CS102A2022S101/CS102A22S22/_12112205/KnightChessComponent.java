import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {
    public KnightChessComponent(ChessComponent[][] chessboard, ChessColor color, ChessboardPoint point) {
        super.chessboard = chessboard;
        super.setChessColor(color);
        super.setChessPoint(point);
        if (color.equals(ChessColor.BLACK)) {
            super.name = 'N';
        } else {
            super.name = 'n';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<ChessboardPoint>();
        ChessboardPoint source = super.getChessPoint();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (!chessboard[i][j].getChessColor().equals(getChessColor())) {

                    if (Math.abs(source.getX() - i) == 2 && Math.abs(source.getY() - j) == 1) {
                        list.add(new ChessboardPoint(i, j));

                    } else if (Math.abs(source.getX() - i) == 1
                            && Math.abs(source.getY() - j) == 2) {
                        list.add(new ChessboardPoint(i, j));

                    }
                }
            }
        }
        return list;
    }

}
