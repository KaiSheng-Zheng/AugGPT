import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PawnChessComponent extends ChessComponent {


    public PawnChessComponent() {
    }

    public PawnChessComponent(ChessboardPoint chessboardPoint, ChessColor chessColor) {
        super(chessboardPoint, chessColor);
        if (chessColor == ChessColor.WHITE) {
            this.name = 'p';
        }
        if (chessColor == ChessColor.BLACK) {
            this.name = 'P';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> a = new ArrayList<>();
        if (Objects.equals(getChessColor(), ChessColor.BLACK)) {
            if (getSource().getX() == 1) {
                if (yuejie(getSource().getX() + 1, getSource().getY())) {
                    if (chessBoard[getSource().getX() + 1][getSource().getY()].name == '_') {
                        a.add(getSource().offset(1, 0));
                    }
                }
                if (yuejie(getSource().getX() + 2, getSource().getY())) {
                    if (chessBoard[getSource().getX() + 2][getSource().getY()].name == '_') {
                        a.add(getSource().offset(2, 0));
                    }
                }
            } else {
                if (yuejie(getSource().getX() + 1, getSource().getY())) {
                    if (chessBoard[getSource().getX() + 1][getSource().getY()].name == '_') {
                        a.add(getSource().offset(1, 0));
                    }
                }
            }
            if (yuejie(getSource().getX() + 1, getSource().getY() + 1)) {
                if (chessBoard[getSource().getX() + 1][getSource().getY() + 1].name != '_') {

                    if (Objects.equals(getSource().offset(1, 1), null)) {

                    } else {
                        a.add(getSource().offset(1, 1));
                    }
                }
            }
            if (yuejie(getSource().getX() + 1, getSource().getY() - 1)) {
                if (chessBoard[getSource().getX() + 1][getSource().getY() - 1].name != '_') {

                    if (Objects.equals(getSource().offset(1, -1), null)) {

                    } else {
                        a.add(getSource().offset(1, -1));
                    }
                }
            }
        } else {
            if (getSource().getX() == 6) {
                if (yuejie(getSource().getX() - 1, getSource().getY())) {
                    if (chessBoard[getSource().getX() - 1][getSource().getY()].name == '_') {
                        a.add(getSource().offset(-1, 0));
                    }
                }
                if (yuejie(getSource().getX() - 2, getSource().getY())) {
                    if (chessBoard[getSource().getX() - 2][getSource().getY()].name == '_') {
                        a.add(getSource().offset(-2, 0));
                    }
                }
            } else {
                if (yuejie(getSource().getX() - 1, getSource().getY())) {
                    if (chessBoard[getSource().getX() - 1][getSource().getY()].name == '_') {
                        a.add(getSource().offset(-1, 0));
                    }
                }
            }
            if (yuejie(getSource().getX() - 1, getSource().getY() + 1)) {
                if (chessBoard[getSource().getX() - 1][getSource().getY() + 1].name != '_') {

                    if (Objects.equals(getSource().offset(-1, 1), null)) {

                    } else {
                        a.add(getSource().offset(-1, 1));
                    }
                }
            }
            if (yuejie(getSource().getX() - 1, getSource().getY() - 1)) {
                if (chessBoard[getSource().getX() - 1][getSource().getY() - 1].name != '_') {

                    if (Objects.equals(getSource().offset(-1, -1), null)) {

                    } else {
                        a.add(getSource().offset(-1, -1));
                    }
                }
            }
        }
        return a;
    }
}