import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] chessComponents) {
        super(source, chessColor, name, chessComponents);
    }

    public PawnChessComponent() {
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> Pawntrail = new ArrayList<ChessboardPoint>();
        ChessColor p = this.getChessColor();
        //white pawn
        if (p == ChessColor.WHITE) {
            //first step
            if (this.getSource().getX() == 6) {
                if (this.getChessComponents()[this.getSource().getX() - 1][this.getSource().getY()].getChessColor() == ChessColor.NONE && this.getChessComponents()[this.getSource().getX()][this.getSource().getY() - 2].getChessColor() == ChessColor.NONE) {
                    Pawntrail.add(this.getSource().offset(-2, 0));
                }
                if (this.getChessComponents()[this.getSource().getX() - 1][this.getSource().getY()].getChessColor() == ChessColor.NONE) {
                    Pawntrail.add(this.getSource().offset(-1, 0));
                }
                if (this.getSource().offset(-1, -1) != null && this.getChessComponents()[this.getSource().getX() - 1][this.getSource().getY() - 1].getChessColor() == ChessColor.BLACK) {
                    Pawntrail.add(this.getSource().offset(-1, -1));
                }
                if (this.getSource().offset(-1, 1) != null && this.getChessComponents()[this.getSource().getX() - 1][this.getSource().getY() + 1].getChessColor() == ChessColor.BLACK) {
                    Pawntrail.add(this.getSource().offset(-1, 1));
                }
            }//already moved
            else {
                if (this.getChessComponents()[this.getSource().getX() - 1][this.getSource().getY()].getChessColor() == ChessColor.NONE) {
                    Pawntrail.add(this.getSource().offset(-1, 0));
                }
                if (this.getSource().offset(-1, -1) != null && this.getChessComponents()[this.getSource().getX() - 1][this.getSource().getY() - 1].getChessColor() == ChessColor.BLACK) {
                    Pawntrail.add(this.getSource().offset(-1, -1));
                }
                if (this.getSource().offset(-1, 1) != null && this.getChessComponents()[this.getSource().getX() - 1][this.getSource().getY() + 1].getChessColor() == ChessColor.BLACK) {
                    Pawntrail.add(this.getSource().offset(-1, 1));
                }
            }
        } else if (p == ChessColor.BLACK) {
            //first step
            if (this.getSource().getX() == 1) {
                if (this.getChessComponents()[this.getSource().getX() + 1][this.getSource().getY()].getChessColor() == ChessColor.NONE && this.getChessComponents()[this.getSource().getX()][this.getSource().getY() - 2].getChessColor() == ChessColor.NONE) {
                    Pawntrail.add(this.getSource().offset(2, 0));
                }
                if (this.getChessComponents()[this.getSource().getX() + 1][this.getSource().getY()].getChessColor() == ChessColor.NONE) {
                    Pawntrail.add(this.getSource().offset(1, 0));
                }
                if (this.getSource().offset(1, -1) != null && this.getChessComponents()[this.getSource().getX() + 1][this.getSource().getY() - 1].getChessColor() == ChessColor.BLACK) {
                    Pawntrail.add(this.getSource().offset(-1, -1));
                }
                if (this.getSource().offset(1, 1) != null && this.getChessComponents()[this.getSource().getX() + 1][this.getSource().getY() + 1].getChessColor() == ChessColor.BLACK) {
                    Pawntrail.add(this.getSource().offset(-1, 1));
                }
            }//already moved
            else {
                if (this.getChessComponents()[this.getSource().getX() + 1][this.getSource().getY()].getChessColor() == ChessColor.NONE) {
                    Pawntrail.add(this.getSource().offset(1, 0));
                }
                if (this.getSource().offset(1, -1) != null && this.getChessComponents()[this.getSource().getX() + 1][this.getSource().getY() - 1].getChessColor() == ChessColor.BLACK) {
                    Pawntrail.add(this.getSource().offset(-1, -1));
                }
                if (this.getSource().offset(1, 1) != null && this.getChessComponents()[this.getSource().getX() + 1][this.getSource().getY() + 1].getChessColor() == ChessColor.BLACK) {
                    Pawntrail.add(this.getSource().offset(-1, 1));
                }
            }
        }
        return Pawntrail;
    }
}
