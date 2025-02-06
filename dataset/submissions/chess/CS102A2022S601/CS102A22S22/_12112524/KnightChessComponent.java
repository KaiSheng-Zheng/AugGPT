import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {
    public KnightChessComponent(char name,int x, int y) {
        super(name,x,y);
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<>();
        // get movable points
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (!(this.getChessColor().equals(chessboard[i][j].getChessColor()))) { // check friend chess
                    if (Math.abs(i - this.getSource().getX()) == 2 && Math.abs(j - this.getSource().getY()) == 1) {
                        list.add(new ChessboardPoint(i, j)); // more horizontal rectangular four
                    }
                    if (Math.abs(i - this.getSource().getX()) == 1 && Math.abs(j - this.getSource().getY()) == 2) {
                        list.add(new ChessboardPoint(i, j)); // more vertical rectangular four
                    }
                }
            }
        }

        return list;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
