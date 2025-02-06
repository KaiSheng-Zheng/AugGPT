import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent {


    public QueenChessComponent(ChessColor color, int x, int y) {
        super.setChessColor(color);
        if (color == ChessColor.WHITE) {
            name = 'q';
        } else {
            name = 'Q';
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
                    if (super.getSource().getX() == i) {
                        int row = super.getSource().getX();
                        for (int col = Math.min(super.getSource().getY(), j) + 1;
                             col < Math.max(super.getSource().getY(), j); col++) {
                            if (!(Chessboard.chessboard[row][col] instanceof EmptySlotComponent)) {
                                can = false;
                                break;
                            }
                        }
                    } else if (super.getSource().getY() == j) {
                        int col = super.getSource().getY();
                        for (int row = Math.min(super.getSource().getX(), i) + 1;
                             row < Math.max(super.getSource().getX(), i); row++) {
                            if (!(Chessboard.chessboard[row][col] instanceof EmptySlotComponent)) {
                                can = false;
                                break;
                            }
                        }
                    } else if (Math.abs(i - super.getSource().getX()) == Math.abs(j - super.getSource().getY())) {
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

                    }else {
                        can=false;
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
