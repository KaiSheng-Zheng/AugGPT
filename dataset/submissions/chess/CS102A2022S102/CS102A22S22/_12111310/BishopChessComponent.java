import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {
    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);

    }

    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] chessComponents) {
        super(source, chessColor, name, chessComponents);
    }

    public BishopChessComponent() {
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> Bishoptrail = new ArrayList<ChessboardPoint>();
        //++
        for (int i = 0; i < 8; i++) {
            if (this.getSource().offset(i, i) != null) {
                ChessColor p = this.getChessComponents()[this.getSource().getX() + i][this.getSource().getY() + i].getChessColor();
                if (p == this.getChessColor()) {
                    break;
                } else if (p != this.getChessColor() && p != ChessColor.NONE) {
                    Bishoptrail.add(this.getSource().offset(i, i));
                    break;
                } else if (p != this.getChessColor() && p == ChessColor.NONE) {
                    Bishoptrail.add(this.getSource().offset(i, i));
                }
            }
        }
        //+-
        for (int i = 0; i < 8; i++) {
            if (this.getSource().offset(i, -i) != null) {
                ChessColor p = this.getChessComponents()[this.getSource().getX() + i][this.getSource().getY() - i].getChessColor();
                if (p == this.getChessColor()) {
                    break;
                } else if (p != this.getChessColor() && p != ChessColor.NONE) {
                    Bishoptrail.add(this.getSource().offset(i, -i));
                    break;
                } else if (p != this.getChessColor() && p == ChessColor.NONE) {
                    Bishoptrail.add(this.getSource().offset(i, -i));
                }
            }
        }
        //-+
        for (int i = 0; i < 8; i++) {
            if (this.getSource().offset(-i, i) != null) {
                ChessColor p = this.getChessComponents()[this.getSource().getX() - i][this.getSource().getY() + i].getChessColor();
                if (p == this.getChessColor()) {
                    break;
                } else if (p != this.getChessColor() && p != ChessColor.NONE) {
                    Bishoptrail.add(this.getSource().offset(-i, i));
                    break;
                } else if (p != this.getChessColor() && p == ChessColor.NONE) {
                    Bishoptrail.add(this.getSource().offset(-i, i));
                }
            }
        }
        //--
        for (int i = 0; i < 8; i++) {
            if (this.getSource().offset(-i, -i) != null) {
                ChessColor p = this.getChessComponents()[this.getSource().getX() - i][this.getSource().getY() - i].getChessColor();
                if (p == this.getChessColor()) {
                    break;
                } else if (p != this.getChessColor() && p != ChessColor.NONE) {
                    Bishoptrail.add(this.getSource().offset(-i, -i));
                    break;
                } else if (p != this.getChessColor() && p == ChessColor.NONE) {
                    Bishoptrail.add(this.getSource().offset(-i, -i));
                }
            }
        }
        return Bishoptrail;
    }
}
