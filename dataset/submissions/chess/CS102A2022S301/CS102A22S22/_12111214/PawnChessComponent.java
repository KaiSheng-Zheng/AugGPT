import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(ChessboardPoint source,ChessColor chessColor,char name){
        super(source, chessColor, name);
    }
    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> canMoveTo=new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessComponents[i][j].getChessColor() != this.getChessColor()) {
                    if (this.getChessColor() == ChessColor.BLACK) {
                        if (this.getSource().getX() == 1) {
                            if (((j == this.getSource().getY() + 1) && (i - this.getSource().getX() == 1)) &&
                                    (chessComponents[this.getSource().getX() + 1][this.getSource().getY() + 1] .getChessColor()==ChessColor.WHITE)) {
                                canMoveTo.add(new ChessboardPoint(i, j));
                            } else if (((j == this.getSource().getY() - 1) && (i - this.getSource().getX() == 1)) &&
                                    (chessComponents[this.getSource().getX() + 1][this.getSource().getY() - 1] .getChessColor()==ChessColor.WHITE)) {
                                canMoveTo.add(new ChessboardPoint(i, j));
                            }else if ((i - this.getSource().getX() == 1 || i - this.getSource().getX() == 2) && (j == this.getSource().getY())
                                    &&(chessComponents[i][j] instanceof EmptySlotComponent)) {
                                canMoveTo.add(new ChessboardPoint(i, j));
                            } else {
                                continue;
                            }
                        } else {
                            if (((j == this.getSource().getY() + 1) && (i - this.getSource().getX() == 1)) &&
                                    (chessComponents[this.getSource().getX() + 1][this.getSource().getY() + 1] .getChessColor()==ChessColor.WHITE)
                            ) {
                                canMoveTo.add(new ChessboardPoint(i, j));
                            } else if (((j == this.getSource().getY() - 1) && (i - this.getSource().getX() == 1)) &&
                                    (chessComponents[this.getSource().getX() + 1][this.getSource().getY() - 1] .getChessColor()==ChessColor.WHITE)) {
                                canMoveTo.add(new ChessboardPoint(i, j));
                            } else if ((j == this.getSource().getY()) && (i - this.getSource().getX() == 1)
                                    &&(chessComponents[i][j] instanceof EmptySlotComponent)) {
                                canMoveTo.add(new ChessboardPoint(i, j));
                            } else {
                                continue;
                            }
                        }
                    }
                    if (this.getChessColor() == ChessColor.WHITE) {
                        if (this.getSource().getX() == 6) {
                            if (((j == this.getSource().getY() + 1) && (i - this.getSource().getX() == -1)) &&
                                    (chessComponents[this.getSource().getX() - 1][this.getSource().getY() + 1] .getChessColor()==ChessColor.BLACK)) {
                                canMoveTo.add(new ChessboardPoint(i, j));
                            } else if (((j == this.getSource().getY() - 1) && (i - this.getSource().getX() == -1)) &&
                                    (chessComponents[this.getSource().getX() - 1][this.getSource().getY() - 1] .getChessColor()==ChessColor.BLACK)) {
                                canMoveTo.add(new ChessboardPoint(i, j));
                            }else if ((i - this.getSource().getX() == -1 || i - this.getSource().getX() == -2) && (j == this.getSource().getY())
                                    &&(chessComponents[i][j] instanceof EmptySlotComponent)) {
                                canMoveTo.add(new ChessboardPoint(i, j));
                            } else {
                                continue;
                            }
                        } else {
                            if (((j == this.getSource().getY() + 1) && (i - this.getSource().getX() == -1)) &&
                                    (chessComponents[this.getSource().getX() - 1][this.getSource().getY() + 1] .getChessColor()==ChessColor.BLACK)) {
                                canMoveTo.add(new ChessboardPoint(i, j));
                            } else if (((j == this.getSource().getY() - 1) && (i - this.getSource().getX() == -1)) &&
                                    (chessComponents[this.getSource().getX() - 1][this.getSource().getY() - 1] .getChessColor()==ChessColor.BLACK)) {
                                canMoveTo.add(new ChessboardPoint(i, j));
                            } else if ((j == this.getSource().getY()) && (i - this.getSource().getX() == -1)
                                    &&(chessComponents[i][j] instanceof EmptySlotComponent)) {
                                canMoveTo.add(new ChessboardPoint(i, j));
                            } else {
                                continue;
                            }
                        }
                    }
                    continue;
                }
            }
        }
        return canMoveTo;
    }
}
