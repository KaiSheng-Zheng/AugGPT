import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    int i = 0;
    private List<ChessboardPoint> canMoveList;

    public PawnChessComponent(char name) {
        i++;
        this.name = name;
    }

    public PawnChessComponent() {
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public boolean validChess() {
        return this.getSource().getX() >= 0 && this.getSource().getX() <= 7 && this.getSource().getY() >= 0 && this.getSource().getY() <= 7;
    }

    public boolean validFrontChess() {
        return this.getSource().getX() + 1 >= 0 && this.getSource().getX() + 1 <= 7 && this.getSource().getY() >= 0 && this.getSource().getY() <= 7;
    }

    public boolean validFront2Chess() {
        return this.getSource().getX() + 2 >= 0 && this.getSource().getX() + 2 <= 7 && this.getSource().getY() >= 0 && this.getSource().getY() <= 7;
    }

    public boolean validLeftFrontChess() {
        return this.getSource().getX() + 1 >= 0 && this.getSource().getX() + 1 <= 7 && this.getSource().getY() - 1 >= 0 && this.getSource().getY() - 1 <= 7;
    }

    public boolean validRightFrontChess() {
        return this.getSource().getX() + 1 >= 0 && this.getSource().getX() + 1 <= 7 && this.getSource().getY() + 1 >= 0 && this.getSource().getY() + 1 <= 7;
    }

    public boolean validFrontChessW() {
        return this.getSource().getX() -1 >= 0 && this.getSource().getX() - 1 <= 7 && this.getSource().getY() >= 0 && this.getSource().getY() <= 7;
    }

    public boolean validFront2ChessW() {
        return this.getSource().getX() - 2 >= 0 && this.getSource().getX() - 2 <= 7 && this.getSource().getY() >= 0 && this.getSource().getY() <= 7;
    }

    public boolean validLeftFrontChessW() {
        return this.getSource().getX() - 1 >= 0 && this.getSource().getX() - 1 <= 7 && this.getSource().getY() - 1 >= 0 && this.getSource().getY() - 1 <= 7;
    }

    public boolean validRightFrontChessW() {
        return this.getSource().getX() - 1 >= 0 && this.getSource().getX() - 1 <= 7 && this.getSource().getY() + 1 >= 0 && this.getSource().getY() + 1 <= 7;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {ChessComponent[][] chessboard = ChessComponent.chessboard;
        canMoveList = new ArrayList<>();
        if (this.getChessColor() == ChessColor.BLACK) {

            if (this.getSource().getX()==1) {
                if (validChess()) {

                    if (validFrontChess()) {

                        ChessComponent frontChess = chessboard[this.getSource().getX() + 1][this.getSource().getY()];

                        if (frontChess.getChessColor() != ChessColor.NONE) {

                            if (validLeftFrontChess()) {

                                ChessComponent leftfrontChess = chessboard[this.getSource().getX() + 1][this.getSource().getY() - 1];

                                if (leftfrontChess.getChessColor() != this.getChessColor() && leftfrontChess.getChessColor() != ChessColor.NONE) {

                                    canMoveList.add(new ChessboardPoint(this.getSource().getX() + 1, this.getSource().getY() - 1));

                                }
                            }

                            if (validRightFrontChess()) {

                                ChessComponent rightfrontChess = chessboard[this.getSource().getX() + 1][this.getSource().getY() + 1];

                                if (rightfrontChess.getChessColor() != this.getChessColor() && rightfrontChess.getChessColor() != ChessColor.NONE) {

                                    canMoveList.add(new ChessboardPoint(this.getSource().getX() + 1, this.getSource().getY() + 1));
                                }
                            }

                        }
                        if (frontChess.getChessColor() == ChessColor.NONE) {

                            canMoveList.add(new ChessboardPoint(this.getSource().getX() + 1, this.getSource().getY()));
                            if (validLeftFrontChess()) {

                                ChessComponent leftfrontChess = chessboard[this.getSource().getX() + 1][this.getSource().getY() - 1];

                                if (leftfrontChess.getChessColor() != this.getChessColor() && leftfrontChess.getChessColor() != ChessColor.NONE) {
                                    canMoveList.add(new ChessboardPoint(this.getSource().getX() + 1, this.getSource().getY() - 1));
                                }

                            }
                            if (validRightFrontChess()) {

                                ChessComponent rightfrontChess = chessboard[this.getSource().getX() + 1][this.getSource().getY() + 1];

                                if (rightfrontChess.getChessColor() != this.getChessColor() && rightfrontChess.getChessColor() != ChessColor.NONE) {
                                    canMoveList.add(new ChessboardPoint(this.getSource().getX() + 1, this.getSource().getY() + 1));
                                }

                            }
                            if (validFront2Chess()) {

                                ChessComponent front2Chess = chessboard[this.getSource().getX() + 2][this.getSource().getY()];

                                if (front2Chess.getChessColor() == ChessColor.NONE) {
                                    canMoveList.add(new ChessboardPoint(this.getSource().getX() + 2, this.getSource().getY()));
                                }

                            }

                        }
                    }
                }
            }
            if (this.getSource().getX() !=1) {
                if (validChess()) {

                    if (validFrontChess()) {

                        ChessComponent frontChess = chessboard[this.getSource().getX() + 1][this.getSource().getY()];

                        if (frontChess.getChessColor() != ChessColor.NONE) {

                            if (validLeftFrontChess()) {

                                ChessComponent leftfrontChess = chessboard[this.getSource().getX() + 1][this.getSource().getY() - 1];

                                if (leftfrontChess.getChessColor() != this.getChessColor() && leftfrontChess.getChessColor() != ChessColor.NONE) {

                                    canMoveList.add(new ChessboardPoint(this.getSource().getX() + 1, this.getSource().getY() - 1));

                                }
                            }

                            if (validRightFrontChess()) {

                                ChessComponent rightfrontChess = chessboard[this.getSource().getX() + 1][this.getSource().getY() + 1];

                                if (rightfrontChess.getChessColor() != this.getChessColor() && rightfrontChess.getChessColor() != ChessColor.NONE) {

                                    canMoveList.add(new ChessboardPoint(this.getSource().getX() + 1, this.getSource().getY() + 1));
                                }
                            }

                        }  if (frontChess.getChessColor() == ChessColor.NONE) {

                            canMoveList.add(new ChessboardPoint(this.getSource().getX() + 1, this.getSource().getY()));
                            if (validLeftFrontChess()) {

                                ChessComponent leftfrontChess = chessboard[this.getSource().getX() + 1][this.getSource().getY() - 1];

                                if (leftfrontChess.getChessColor() != this.getChessColor() && leftfrontChess.getChessColor() != ChessColor.NONE) {
                                    canMoveList.add(new ChessboardPoint(this.getSource().getX() + 1, this.getSource().getY() - 1));
                                }

                            }
                            if (validRightFrontChess()) {

                                ChessComponent rightfrontChess = chessboard[this.getSource().getX() + 1][this.getSource().getY() + 1];

                                if (rightfrontChess.getChessColor() != this.getChessColor() && rightfrontChess.getChessColor() != ChessColor.NONE) {
                                    canMoveList.add(new ChessboardPoint(this.getSource().getX() + 1, this.getSource().getY() + 1));
                                }

                            }


                        }
                    }
                }
            }

        }
        if (this.getChessColor() == ChessColor.WHITE) {
            if (this.getSource().getX() ==6) {
                if (validChess()) {

                    if (validFrontChessW()) {

                        ChessComponent frontChess = chessboard[this.getSource().getX() - 1][this.getSource().getY()];

                        if (frontChess.getChessColor() != ChessColor.NONE) {

                            if (validLeftFrontChessW()) {

                                ChessComponent leftfrontChess = chessboard[this.getSource().getX() - 1][this.getSource().getY() - 1];

                                if (leftfrontChess.getChessColor() != this.getChessColor() && leftfrontChess.getChessColor() != ChessColor.NONE) {

                                    canMoveList.add(new ChessboardPoint(this.getSource().getX() - 1, this.getSource().getY() - 1));

                                }
                            }

                            if (validRightFrontChessW()) {

                                ChessComponent rightfrontChess = chessboard[this.getSource().getX() - 1][this.getSource().getY() + 1];

                                if (rightfrontChess.getChessColor() != this.getChessColor() && rightfrontChess.getChessColor() != ChessColor.NONE) {

                                    canMoveList.add(new ChessboardPoint(this.getSource().getX() - 1, this.getSource().getY() + 1));
                                }
                            }

                        } else if (frontChess.getChessColor() == ChessColor.NONE) {

                            canMoveList.add(new ChessboardPoint(this.getSource().getX() - 1, this.getSource().getY()));
                            if (validLeftFrontChessW()) {

                                ChessComponent leftfrontChess = chessboard[this.getSource().getX() - 1][this.getSource().getY() - 1];

                                if (leftfrontChess.getChessColor() != this.getChessColor() && leftfrontChess.getChessColor() != ChessColor.NONE) {
                                    canMoveList.add(new ChessboardPoint(this.getSource().getX() - 1, this.getSource().getY() - 1));
                                }

                            }
                            if (validRightFrontChessW()) {

                                ChessComponent rightfrontChess = chessboard[this.getSource().getX() - 1][this.getSource().getY() + 1];

                                if (rightfrontChess.getChessColor() != this.getChessColor() && rightfrontChess.getChessColor() != ChessColor.NONE) {
                                    canMoveList.add(new ChessboardPoint(this.getSource().getX() - 1, this.getSource().getY() + 1));
                                }

                            }
                            if (validFront2ChessW()) {

                                ChessComponent front2Chess = chessboard[this.getSource().getX() - 2][this.getSource().getY()];

                                if (front2Chess.getChessColor() == ChessColor.NONE) {
                                    canMoveList.add(new ChessboardPoint(this.getSource().getX() - 2, this.getSource().getY()));
                                }

                            }

                        }
                    }
                }
            }
            if (this.getSource().getX() !=6) {
                if (validChess()) {

                    if (validFrontChessW()) {

                        ChessComponent frontChess = chessboard[this.getSource().getX() - 1][this.getSource().getY()];

                        if (frontChess.getChessColor() != ChessColor.NONE) {

                            if (validLeftFrontChessW()) {

                                ChessComponent leftfrontChess = chessboard[this.getSource().getX() - 1][this.getSource().getY() - 1];

                                if (leftfrontChess.getChessColor() != this.getChessColor() && leftfrontChess.getChessColor() != ChessColor.NONE) {

                                    canMoveList.add(new ChessboardPoint(this.getSource().getX() - 1, this.getSource().getY() - 1));

                                }
                            }

                            if (validRightFrontChessW()) {

                                ChessComponent rightfrontChess = chessboard[this.getSource().getX() - 1][this.getSource().getY() + 1];

                                if (rightfrontChess.getChessColor() != this.getChessColor() && rightfrontChess.getChessColor() != ChessColor.NONE) {

                                    canMoveList.add(new ChessboardPoint(this.getSource().getX() - 1, this.getSource().getY() + 1));
                                }
                            }

                        } else if (frontChess.getChessColor() == ChessColor.NONE) {

                            canMoveList.add(new ChessboardPoint(this.getSource().getX() - 1, this.getSource().getY()));
                            if (validLeftFrontChessW()) {

                                ChessComponent leftfrontChess = chessboard[this.getSource().getX() - 1][this.getSource().getY() - 1];

                                if (leftfrontChess.getChessColor() != this.getChessColor() && leftfrontChess.getChessColor() != ChessColor.NONE) {
                                    canMoveList.add(new ChessboardPoint(this.getSource().getX() - 1, this.getSource().getY() - 1));
                                }

                            }
                            if (validRightFrontChessW()) {

                                ChessComponent rightfrontChess = chessboard[this.getSource().getX() - 1][this.getSource().getY() + 1];

                                if (rightfrontChess.getChessColor() != this.getChessColor() && rightfrontChess.getChessColor() != ChessColor.NONE) {
                                    canMoveList.add(new ChessboardPoint(this.getSource().getX() - 1, this.getSource().getY() + 1));
                                }
                            }

                        }
                    }
                }
            }
        }
        return canMoveList;
    }
}