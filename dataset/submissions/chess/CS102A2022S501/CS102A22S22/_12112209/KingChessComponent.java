import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x = getSource().getX();
        int y = getSource().getY();
//        ChessComponent[][] board = chessGame.getChessComponents();
//        System.out.println("x = " + x + " y = " + y);
        List<ChessboardPoint> points = new ArrayList<>();

        int[][] dirs = new int[][]{
                {-1, -1},
                {-1, 1},
                {1, -1},
                {1, 1},

                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1},
        };


        for(int[] dir : dirs) {
            int xx = x + dir[0];
            int yy = y + dir[1];
//            System.out.println("xx " + xx + " yy " + yy);
            ChessboardPoint point = new ChessboardPoint(xx, yy);
            if(ChessboardPoint.inChessBoard(xx, yy) && canPlaced(getSource(), point)) {
                points.add(point);
            }
        }

        return points;
    }
}
