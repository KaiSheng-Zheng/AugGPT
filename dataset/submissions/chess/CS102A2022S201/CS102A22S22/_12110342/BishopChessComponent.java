import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {

    private ChessboardPoint source;
    private ChessColor chessColor;


    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] chessComponents) {
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
        this.chessComponents = chessComponents;

    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> a = new ArrayList<>();
        for (int i = 1; i <= Math.min(this.source.getX(), this.source.getY()); i++) {
            if (chessComponents[this.getSource().getX() - i][this.getSource().getY() - i].getChessColor().equals(ChessColor.NONE)) {
                a.add(this.getSource().offset(-i, -i));
            } else if (chessComponents[this.getSource().getX() - i][this.getSource().getY() - i].getChessColor().equals(chessComponents[this.getSource().getX()][this.getSource().getY()].getChessColor())) {
                break;
            } else {
                a.add(this.getSource().offset(-i, -i));
                break;
            }
        }

        for (int i = 1; i <= Math.min(7 - this.source.getX(), this.source.getY()); i++) {
            if (chessComponents[this.getSource().getX() + i][this.getSource().getY() - i].getChessColor().equals(ChessColor.NONE)) {
                a.add(this.getSource().offset(i, -i));
            } else if (chessComponents[this.getSource().getX() + i][this.getSource().getY() - i].getChessColor().equals(chessComponents[this.getSource().getX()][this.getSource().getY()].getChessColor())) {
                break;
            } else {
                a.add(this.getSource().offset(i, -i));
                break;
            }
        }

        for (int i = 1; i <= Math.min(7 - this.source.getX(), 7 - this.source.getY()); i++) {
            if (chessComponents[this.getSource().getX() + i][this.getSource().getY() + i].getChessColor().equals(ChessColor.NONE)) {
                a.add(this.getSource().offset(i, i));
            } else if (chessComponents[this.getSource().getX() + i][this.getSource().getY() + i].getChessColor().equals(chessComponents[this.getSource().getX()][this.getSource().getY()].getChessColor())) {
                break;
            } else {
                a.add(this.getSource().offset(i, i));
                break;
            }
        }


        for (int i = 1; i <= Math.min(this.source.getX(), 7 - this.source.getY()); i++) {
            if (chessComponents[this.getSource().getX() - i][this.getSource().getY() + i].getChessColor().equals(ChessColor.NONE)) {
                a.add(this.getSource().offset(-i, i));
            } else if (chessComponents[this.getSource().getX() - i][this.getSource().getY() + i].getChessColor().equals(chessComponents[this.getSource().getX()][this.getSource().getY()].getChessColor())) {
                break;
            } else {
                a.add(this.getSource().offset(-i, i));
                break;
            }
        }
        return a;
    }

    @Override
    public String toString() {
        return String.valueOf(name);
    }
}
