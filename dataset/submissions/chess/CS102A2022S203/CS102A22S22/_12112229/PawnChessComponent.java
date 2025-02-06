import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {

    public PawnChessComponent(ChessColor color, int x, int y) {
        super.setChessColor(color);
        if (color == ChessColor.WHITE) {
            name = 'p';
        } else {
            name = 'P';
        }
        super.setSource(new ChessboardPoint(x, y));
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<>();
        if (super.getChessColor() == ChessColor.BLACK) {
            if (super.getSource().getX() == 1) {
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {

                        if ((super.getSource().getY() == j && ((i - super.getSource().getX() == 1 && Chessboard.chessboard[i][j] instanceof EmptySlotComponent) ||
                                (i - super.getSource().getX() == 2 &&
                                        Chessboard.chessboard[2][j] instanceof EmptySlotComponent && Chessboard.chessboard[3][j] instanceof EmptySlotComponent))) ||
                                (Math.abs(j - super.getSource().getY()) == 1 && i - super.getSource().getX() == 1 &&
                                        Chessboard.chessboard[i][j].getChessColor()==ChessColor.WHITE)) {
                            list.add(Chessboard.chessboard[i][j].getSource());
                        }


                    }
                }
            } else {
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {

                        if ((super.getSource().getY() == j && ((i - super.getSource().getX() == 1 && Chessboard.chessboard[i][j] instanceof EmptySlotComponent) )) ||
                                (Math.abs(j - super.getSource().getY()) == 1 && i - super.getSource().getX() == 1 &&
                                        Chessboard.chessboard[i][j].getChessColor()==ChessColor.WHITE)) {
                            list.add(Chessboard.chessboard[i][j].getSource());
                        }

                    }
                }
            }
        } else {
            if (super.getSource().getX() == 6) {
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {

                        if ((super.getSource().getY() == j && ((i - super.getSource().getX() == -1 && Chessboard.chessboard[i][j] instanceof EmptySlotComponent) ||
                                (i - super.getSource().getX() == -2 &&
                                        Chessboard.chessboard[5][j] instanceof EmptySlotComponent && Chessboard.chessboard[4][j] instanceof EmptySlotComponent))) ||
                                (Math.abs(j - super.getSource().getY()) == 1 && i - super.getSource().getX() == -1 &&
                                        Chessboard.chessboard[i][j].getChessColor()==ChessColor.WHITE)) {
                            list.add(Chessboard.chessboard[i][j].getSource());
                        }


                    }
                }
            } else {
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {

                        if ((super.getSource().getY() == j && ((i - super.getSource().getX() == -1 && Chessboard.chessboard[i][j] instanceof EmptySlotComponent) )) ||
                                (Math.abs(j - super.getSource().getY()) == 1 && i - super.getSource().getX() == -1 &&
                                        Chessboard.chessboard[i][j].getChessColor()==ChessColor.WHITE)) {
                            list.add(Chessboard.chessboard[i][j].getSource());
                        }


                    }
                }
            }
        }
        return list;
    }
}
