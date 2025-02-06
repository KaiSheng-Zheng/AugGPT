import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {

    public PawnChessComponent() {
    }

    

    public PawnChessComponent(char name, ChessboardPoint where, ChessColor chessColor) {
        this.name = name;
        this.setSource(where);
        this.setChessColor(chessColor);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chessPoint = new ArrayList<>();
        if (this.getChessColor() == ChessColor.BLACK) {
            //first
            if (this.getSource().getX() == 1) {
                if (this.getSource().offset(2, 0) != null &&
                        this.chessboard[this.getSource().getX() + 2][this.getSource().getY()].name == '_' &&
                        this.chessboard[this.getSource().getX() + 1][this.getSource().getY()].name == '_') {
                    chessPoint.add(this.getSource().offset(2, 0));
                }

            }
            //normal
            if (this.getSource().offset(1, 0) != null &&
                    this.chessboard[this.getSource().getX() + 1][this.getSource().getY()].name == '_') {
                chessPoint.add(this.getSource().offset(1, 0));

            }
            //eat
            if (this.getSource().offset(1, -1) != null &&
                    this.chessboard[this.getSource().getX() + 1][this.getSource().getY() - 1].getChessColor() == ChessColor.WHITE) {
                chessPoint.add(this.getSource().offset(1, -1));

            }
            if (this.getSource().offset(1, 1) != null &&
                    this.chessboard[this.getSource().getX() + 1][this.getSource().getY() + 1].getChessColor() == ChessColor.WHITE) {
                chessPoint.add(this.getSource().offset(1, 1));

            }
            return chessPoint;
        } else {
            //first
            if (this.getSource().getX() == 6) {
                if (this.getSource().offset(-2, 0) != null &&
                        this.chessboard[this.getSource().getX() - 2][this.getSource().getY()].name == '_' &&
                        this.chessboard[this.getSource().getX() - 1][this.getSource().getY()].name == '_') {
                    chessPoint.add(this.getSource().offset(-2, 0));
                }

            }
            //normal
            if (this.getSource().offset(-1, 0) != null &&
                    this.chessboard[this.getSource().getX() - 1][this.getSource().getY()].name == '_') {
                chessPoint.add(this.getSource().offset(-1, 0));

            }
            //eat
            if (this.getSource().offset(-1, -1) != null &&
                    this.chessboard[this.getSource().getX() - 1][this.getSource().getY() - 1].getChessColor() == ChessColor.BLACK) {
                chessPoint.add(this.getSource().offset(-1, -1));

            }
            if (this.getSource().offset(-1, 1) != null &&
                    this.chessboard[this.getSource().getX() - 1][this.getSource().getY() + 1].getChessColor() == ChessColor.BLACK) {
                chessPoint.add(this.getSource().offset( -1, 1));

            }
        }
        if (chessPoint.size() == 0) {
            return new ArrayList<>();
        }
        return chessPoint;
    }
}
