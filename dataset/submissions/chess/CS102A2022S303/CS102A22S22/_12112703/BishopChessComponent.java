import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BishopChessComponent extends ChessComponent {
    public BishopChessComponent() {
    }

    public BishopChessComponent(ChessboardPoint chessboardPoint, ChessColor chessColor) {
        super(chessboardPoint, chessColor);
        if (chessColor == ChessColor.WHITE) {
            this.name = 'b';
        }
        if (chessColor == ChessColor.BLACK) {
            this.name = 'B';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> a = new ArrayList<>();
        int i = 1;
        while (i < 8) {
            if (Objects.equals(getSource().offset(i, i), null)) {
                break;
            } else {
                a.add(getSource().offset(i, i));
            }
            if (chessBoard[getSource().getX() + i][getSource().getY() + i].name != '_') {
                break;
            }
            i++;
        }
        i = 1;
        while (i < 8) {
            if (Objects.equals(getSource().offset(-i, -i), null)) {
                break;
            } else {
                a.add(getSource().offset(-i, -i));
            }
            if (chessBoard[getSource().getX() - i][getSource().getY() - i].name != '_') {
                break;
            }
            i++;
        }
        i = 1;
        while (i < 8) {
            if (Objects.equals(getSource().offset(i, -i), null)) {
                break;
            } else {
                a.add(getSource().offset(i, -i));
            }
            if (chessBoard[getSource().getX() + i][getSource().getY() - i].name != '_') {
                break;
            }
            i++;
        }
        i = 1;
        while (i < 8) {
            if (Objects.equals(getSource().offset(-i, i), null)) {
                break;
            } else {
                a.add(getSource().offset(-i, i));
            }
            if (chessBoard[getSource().getX() - i][getSource().getY() + i].name != '_') {
                break;
            }
            i++;
        }
        return a;
    }
}
