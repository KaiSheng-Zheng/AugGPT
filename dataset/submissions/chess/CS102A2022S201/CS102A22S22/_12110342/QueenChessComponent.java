import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{

    private ChessboardPoint source;
    private ChessColor chessColor;

    ChessComponent[][] chessComponents;

    public QueenChessComponent(ChessboardPoint source,ChessColor chessColor,char name,ChessComponent[][] chessComponents){
        this.source=source;
        this.chessColor=chessColor;
        this.name=name;
        this.chessComponents=chessComponents;

    }
    public void setChessComponents(ChessComponent[][] chessComponents) {
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
        for (int i = 1; i <= this.getSource().getX(); i++) {
            if (chessComponents[this.getSource().getX() - i][this.getSource().getY()].getChessColor().equals(ChessColor.NONE)) {
                a.add(this.getSource().offset(-i, 0));
            } else if (chessComponents[this.getSource().getX() - i][this.getSource().getY()].getChessColor().equals(chessComponents[this.getSource().getX()][this.getSource().getY()].getChessColor())) {
                break;
            } else {
                a.add(this.getSource().offset(-i, 0));
                break;
            }
        }

        for (int i = 1; i <= 7-this.getSource().getX(); i++) {
            if (chessComponents[this.getSource().getX() +i][this.getSource().getY()].getChessColor().equals(ChessColor.NONE)) {
                a.add(this.getSource().offset(i, 0));
            } else if (chessComponents[this.getSource().getX() +i][this.getSource().getY()].getChessColor().equals(chessComponents[this.getSource().getX()][this.getSource().getY()].getChessColor())) {
                break;
            } else {
                a.add(this.getSource().offset(i, 0));
                break;
            }
        }

        for (int i = 1; i <= 7-this.getSource().getY(); i++) {
            if (chessComponents[this.getSource().getX() ][this.getSource().getY()+i].getChessColor().equals(ChessColor.NONE)) {
                a.add(this.getSource().offset(0, i));
            } else if (chessComponents[this.getSource().getX() ][this.getSource().getY()+i].getChessColor().equals(chessComponents[this.getSource().getX()][this.getSource().getY()].getChessColor())) {
                break;
            } else {
                a.add(this.getSource().offset(0, i));
                break;
            }
        }

        for (int i = 1; i <= this.getSource().getY(); i++) {
            if (chessComponents[this.getSource().getX() ][this.getSource().getY()-i].getChessColor().equals(ChessColor.NONE)) {
                a.add(this.getSource().offset(0, -i));
            } else if (chessComponents[this.getSource().getX() ][this.getSource().getY()-i].getChessColor().equals(chessComponents[this.getSource().getX()][this.getSource().getY()].getChessColor())) {
                break;
            } else {
                a.add(this.getSource().offset(0,-i));
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