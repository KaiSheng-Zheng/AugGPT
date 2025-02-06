import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, ChessComponent[][] chessComponents, char name) {
        super(source, chessColor, name);
        this.chessComponents = chessComponents;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> outcome = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (this.getChessColor() == ChessColor.BLACK) {
                    if (getSource().getY() == j) {
                        if (getSource().getX() - i == -1 && chessComponents[i][j] instanceof EmptySlotComponent) {
                            if (chessComponents[i][j].getChessColor() != this.getChessColor() && !(i == getSource().getX() && j == getSource().getY())) {
                                outcome.add(new ChessboardPoint(i, j));
                            }//judgment for the validity of camp
                        } else if (getSource().getX() - i == -2 && getSource().getX() == 1 && chessComponents[i][j] instanceof EmptySlotComponent
                                && chessComponents[i - 1][j] instanceof EmptySlotComponent) {
                            if (chessComponents[i][j].getChessColor() != this.getChessColor() && !(i == getSource().getX() && j == getSource().getY())) {
                                outcome.add(new ChessboardPoint(i, j));
                            }//judgment for the validity of camp
                        } else {
                        }
                    } else if ((Math.abs(getSource().getY() - j) == 1) && (getSource().getX() - i == -1)) {
                        if (!(chessComponents[i][j] instanceof EmptySlotComponent)) {
                            if (chessComponents[i][j].getChessColor() != this.getChessColor() && !(i == getSource().getX() && j == getSource().getY())) {
                                outcome.add(new ChessboardPoint(i, j));
                            }//judgment for the validity of camp
                        } else {
                        }
                    }
                }

                if (this.getChessColor() == ChessColor.WHITE) {
                    if (getSource().getY() == j) {
                        if (getSource().getX() - i == 1 && chessComponents[i][j] instanceof EmptySlotComponent) {
                            if (chessComponents[i][j].getChessColor() != this.getChessColor() && !(i == getSource().getX() && j == getSource().getY())) {
                                outcome.add(new ChessboardPoint(i, j));
                            }//judgment for the validity of camp
                        } else if (getSource().getX() - i == 2 && getSource().getX() == 6 && chessComponents[i][j] instanceof EmptySlotComponent
                                && chessComponents[i + 1][j] instanceof EmptySlotComponent) {
                            if (chessComponents[i][j].getChessColor() != this.getChessColor() && !(i == getSource().getX() && j == getSource().getY())) {
                                outcome.add(new ChessboardPoint(i, j));
                            }//judgment for the validity of camp
                        } else {

                        }
                    } else if ((Math.abs(getSource().getY() - j) == 1) && (getSource().getX() - i == 1)) {
                        if (!(chessComponents[i][j] instanceof EmptySlotComponent)) {
                            if (chessComponents[i][j].getChessColor() != this.getChessColor() && !(i == getSource().getX() && j == getSource().getY())) {
                                outcome.add(new ChessboardPoint(i, j));
                            }//judgment for the validity of camp
                        } else {
                        }
                    }
                }
            }
        }
        return outcome;
    }
}
