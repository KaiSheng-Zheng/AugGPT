import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {


    public PawnChessComponent(char name, int x, int y) {
        super(name, x, y);

        // be careful with invokingTime,
        // when you first control a pawn to move, does invokingTime == 1 or 0?
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<>();
        List<ChessboardPoint> listSorted = new ArrayList<>(); // to make sure points not offset

        // black
        if (this.getChessColor().equals(ChessColor.BLACK)) {
            // vertical
            if (chessboard[getSource().getX() + 1][getSource().getY()].getChessColor().equals(ChessColor.NONE)) {
                list.add(new ChessboardPoint(this.getSource().getX() + 1, this.getSource().getY()));
                if (this.getSource().getX() == 1
                        && chessboard[3][getSource().getY()].getChessColor().equals(ChessColor.NONE)) {
                    list.add(new ChessboardPoint(3, this.getSource().getY()));
                }
            }
            // diagonal
            if (getSource().getX() + 1 <= 7 && getSource().getY() + 1 <= 7) {
                if (chessboard[getSource().getX() + 1][getSource().getY() + 1].getChessColor().equals(ChessColor.WHITE)) {
                    list.add(new ChessboardPoint(this.getSource().getX() + 1, this.getSource().getY() + 1));
                }
            }
            if (getSource().getX() + 1 <= 7 && getSource().getY() - 1 >= 0) {
                if (chessboard[getSource().getX() + 1][getSource().getY() - 1].getChessColor().equals(ChessColor.WHITE)) {
                    list.add(new ChessboardPoint(this.getSource().getX() + 1, this.getSource().getY() - 1));
                }
            }
        }

        // white
        if (this.getChessColor().equals(ChessColor.WHITE)) {
            // vertical
            if (chessboard[getSource().getX() - 1][getSource().getY()].getChessColor().equals(ChessColor.NONE)) {
                list.add(new ChessboardPoint(this.getSource().getX() - 1, this.getSource().getY()));
                if (this.getSource().getX() == 6
                        && chessboard[4][getSource().getY()].getChessColor().equals(ChessColor.NONE)) {
                    list.add(new ChessboardPoint(4, this.getSource().getY()));
                }
            }
            // diagonal
            if (getSource().getX() - 1 >= 0 && getSource().getY() + 1 <= 7) {
                if (chessboard[getSource().getX() - 1][getSource().getY() + 1].getChessColor().equals(ChessColor.BLACK)) {
                    list.add(new ChessboardPoint(this.getSource().getX() - 1, this.getSource().getY() + 1));
                }
            }
            if (getSource().getX() - 1 >= 0 && getSource().getY() - 1 >= 0) {
                if (chessboard[getSource().getX() - 1][getSource().getY() - 1].getChessColor().equals(ChessColor.BLACK)) {
                    list.add(new ChessboardPoint(this.getSource().getX() - 1, this.getSource().getY() - 1));
                }
            }
        }

        // offset
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (list.contains(new ChessboardPoint(i, j))) {
                    listSorted.add(new ChessboardPoint(i, j));
                }
            }
        }
        // promote (stay in the same place)

        return listSorted;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}