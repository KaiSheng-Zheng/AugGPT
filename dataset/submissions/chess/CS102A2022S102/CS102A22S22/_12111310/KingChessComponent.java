import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] chessComponents) {
        super(source, chessColor, name, chessComponents);
    }

    public KingChessComponent() {
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> Kingtrail = new ArrayList<ChessboardPoint>();
        //++
        if (this.getSource().offset(1, 1) != null && this.getChessComponents()[this.getSource().getX() + 1][this.getSource().getY() + 1].getChessColor() != this.getChessColor()) {
            Kingtrail.add(this.getSource().offset(1, 1));
        }
        //+-
        if (this.getSource().offset(1, -1) != null && this.getChessComponents()[this.getSource().getX() + 1][this.getSource().getY() - 1].getChessColor() != this.getChessColor()) {
            Kingtrail.add(this.getSource().offset(1, -1));
        }
        //-+
        if (this.getSource().offset(-1, 1) != null && this.getChessComponents()[this.getSource().getX() - 1][this.getSource().getY() + 1].getChessColor() != this.getChessColor()) {
            Kingtrail.add(this.getSource().offset(-1, 1));
        }
        //--
        if (this.getSource().offset(-1, -1) != null && this.getChessComponents()[this.getSource().getX() - 1][this.getSource().getY() - 1].getChessColor() != this.getChessColor()) {
            Kingtrail.add(this.getSource().offset(-1, -1));
        }
        //+x
        if (this.getSource().offset(1, 0) != null && this.getChessComponents()[this.getSource().getX() + 1][this.getSource().getY()].getChessColor() != this.getChessColor()) {
            Kingtrail.add(this.getSource().offset(1, 0));
        }
        //-x
        if (this.getSource().offset(-1, 0) != null && this.getChessComponents()[this.getSource().getX() - 1][this.getSource().getY()].getChessColor() != this.getChessColor()) {
            Kingtrail.add(this.getSource().offset(-1, 0));
        }
        //+y
        if (this.getSource().offset(0, 1) != null && this.getChessComponents()[this.getSource().getX()][this.getSource().getY() + 1].getChessColor() != this.getChessColor()) {
            Kingtrail.add(this.getSource().offset(0, 1));
        }
        //-y
        if (this.getSource().offset(0, -1) != null && this.getChessComponents()[this.getSource().getX()][this.getSource().getY() - 1].getChessColor() != this.getChessColor()) {
            Kingtrail.add(this.getSource().offset(0, -1));
        }
        return Kingtrail;
    }
}
