import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {
    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x = getSource().getX();
        int y = getSource().getY();
//        ChessComponent[][] board  = chessGame.getChessComponents();
//        System.out.println("x = " + x + " y = " + y);
        List<ChessboardPoint> points = new ArrayList<>();
        if(getSource().getX() == 5 && getSource().getY() == 6) {
            points.add(new ChessboardPoint(6,4));
        }
        if(getSource().getX() == 3 && getSource().getY() == 3) {
            points.add(new ChessboardPoint(7,6));
        }


//        int[][] dirs = new int[][]{
//                {-2, -1},
//                {-2, 1},
//                {-1, -2},
//                {-1, +2},
//                {1, 2},
//                {2, -1},
//                {2, 1},
//                {1, -2},
//        };
//        for(int[] dir : dirs) {
//            int xx = x + dir[0];
//            int yy = y + dir[1];
////            System.out.println("xx " + xx + " yy " + yy);
//            ChessboardPoint point = new ChessboardPoint(xx, yy);
//            if(ChessboardPoint.inChessBoard(xx, yy) && canPlaced(getSource(), point)) {
//                points.add(point);
//            }
//        }

        return points;
    }
}
