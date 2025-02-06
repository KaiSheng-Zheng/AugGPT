import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {
    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] chessComponents) {
        super(source, chessColor, name, chessComponents);
    }

    public KnightChessComponent() {
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> Knighttrail = new ArrayList<ChessboardPoint>();
        //8 directions
        //1
        if (this.getSource().offset(2, -1) != null) {
            if (this.getChessComponents()[this.getSource().getX() + 2][this.getSource().getY() - 1].getChessColor() != this.getChessColor()) {
                Knighttrail.add(this.getSource().offset(2, -1));
            }
        }
        //2
        if (this.getSource().offset(1, -2) != null) {
            if (this.getChessComponents()[this.getSource().getX() + 1][this.getSource().getY() - 2].getChessColor() != this.getChessColor()) {
                Knighttrail.add(this.getSource().offset(1, -2));
            }
        }
        //3
        if (this.getSource().offset(-1, -2) != null) {
            if (this.getChessComponents()[this.getSource().getX() - 1][this.getSource().getY() - 2].getChessColor() != this.getChessColor()) {
                Knighttrail.add(this.getSource().offset(-1, -2));
            }
        }
        //4
        if (this.getSource().offset(-2, -1) != null) {
            if (this.getChessComponents()[this.getSource().getX() - 2][this.getSource().getY() - 2].getChessColor() != this.getChessColor()) {
                Knighttrail.add(this.getSource().offset(-2, -2));
            }
        }
        //5
        if (this.getSource().offset(-2, 1) != null) {
            if (this.getChessComponents()[this.getSource().getX() - 2][this.getSource().getY() + 1].getChessColor() != this.getChessColor()) {
                Knighttrail.add(this.getSource().offset(-2, 1));
            }
        }
        //6
        if (this.getSource().offset(-1, 2) != null) {
            if (this.getChessComponents()[this.getSource().getX() - 1][this.getSource().getY() + 2].getChessColor() != this.getChessColor()) {
                Knighttrail.add(this.getSource().offset(-1, 2));
            }
        }
        //7
        if (this.getSource().offset(1, 2) != null) {
            if (this.getChessComponents()[this.getSource().getX() + 1][this.getSource().getY() + 2].getChessColor() != this.getChessColor()) {
                Knighttrail.add(this.getSource().offset(1, 2));
            }
        }
        //8
        if (this.getSource().offset(2, 1) != null) {
            if (this.getChessComponents()[this.getSource().getX() + 2][this.getSource().getY() + 1].getChessColor() != this.getChessColor()) {
                Knighttrail.add(this.getSource().offset(2, 1));
            }
        }
        return Knighttrail;
    }
}

