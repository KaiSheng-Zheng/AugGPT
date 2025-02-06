import java.util.*;

public class KingChessComponent extends ChessComponent {
    public KingChessComponent(char name, int x, int y) {
        super(name, x, y);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<>();
        // get movable point, i represents x-axis, j represents y-axis
        // but the question itself seems to mix up the coordinate of the array and chessboard.....
        // just be careful bro
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((((Math.abs(i - this.getSource().getX()) == 1) || (Math.abs(i - this.getSource().getX()) == 0)) // vertical 3 rows
                        && ((Math.abs(j - this.getSource().getY()) == 0) || (Math.abs(j - this.getSource().getY()) == 1))) // horizontal 3 cols, and take union.
                        && (!this.getChessColor().equals(chessboard[i][j].getChessColor()))) { // not friend chess
                    list.add(new ChessboardPoint(i, j));
                }
            }
        }
        return list;
    }
    // it is told that you need to override .equals(), and this may cause fault in .contains()

    @Override
    public String toString() {
        return super.toString();
    }
}