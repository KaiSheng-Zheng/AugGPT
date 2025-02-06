import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {


    public BishopChessComponent(ChessColor color, int x, int y) {
        super.setChessColor(color);
        if (color == ChessColor.WHITE) {
            name = 'b';
        } else {
            name = 'B';
        }
        super.setSource(new ChessboardPoint(x, y));
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (Chessboard.chessboard[i][j].getChessColor() != super.getChessColor()){
                    boolean can = true;
                    if (Math.abs(i - super.getSource().getX()) == Math.abs(j - super.getSource().getY())) {
                        if (i > super.getSource().getX() && j > super.getSource().getY()) {
                            for (int k = 1; super.getSource().getX() + k < i; k++) {
                                if (!(Chessboard.chessboard[super.getSource().getX() + k][super.getSource().getY() + k] instanceof EmptySlotComponent)) {
                                    can = false;
                                    break;
                                }
                            }
                        } else if (i < super.getSource().getX() && j < super.getSource().getY()) {
                            for (int k = 1; i + k < getSource().getX(); k++) {
                                if (!(Chessboard.chessboard[i + k][j + k] instanceof EmptySlotComponent)) {
                                    can = false;
                                    break;
                                }
                            }
                        } else if (i > super.getSource().getX() && j < super.getSource().getY()) {
                            for (int k = 1; super.getSource().getX() + k < i; k++) {
                                if (!(Chessboard.chessboard[super.getSource().getX() + k][super.getSource().getY() - k] instanceof EmptySlotComponent)) {
                                    can = false;
                                    break;
                                }
                            }
                        } else if (i < super.getSource().getX() && j > super.getSource().getY()) {
                            for (int k = 1; i + k < getSource().getX(); k++) {
                                if (!(Chessboard.chessboard[i + k][j - k] instanceof EmptySlotComponent)) {
                                    can = false;
                                    break;
                                }
                            }
                        }
                    } else {
                        can = false;
                    }
                    if (can) {
                        list.add(Chessboard.chessboard[i][j].getSource());
                    }
                }
            }
        }
        return list;
    }

}
