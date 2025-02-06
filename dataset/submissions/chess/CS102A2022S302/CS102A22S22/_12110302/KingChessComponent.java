import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    public KingChessComponent(char name, ChessColor chessColor, ChessboardPoint chessboardPoint) {
        this.name = name;
        this.chessColor = chessColor;
        setSource(chessboardPoint);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chessboardPoints = new ArrayList<>();
        if (getSource().getX() - 1 >= 0 && getSource().getY() - 1 >= 0 && chessBoard[getSource().getX() - 1][getSource().getY() - 1].chessColor != this.chessColor) {
            chessboardPoints.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY() - 1));
        }
        if (getSource().getX() - 1 >= 0 && chessBoard[getSource().getX() - 1][getSource().getY()].chessColor != this.chessColor) {
            chessboardPoints.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY()));
        }
        if (getSource().getX() - 1 >= 0 && getSource().getY() + 1 <=7 && chessBoard[getSource().getX() - 1][getSource().getY() + 1].chessColor != this.chessColor) {
            chessboardPoints.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY() + 1));
        }
        if (getSource().getY() - 1 >= 0 && chessBoard[getSource().getX()][getSource().getY() - 1].chessColor != this.chessColor) {
            chessboardPoints.add(new ChessboardPoint(getSource().getX(), getSource().getY() - 1));
        }
        if (getSource().getY() + 1 <=7  && chessBoard[getSource().getX()][getSource().getY() + 1].chessColor != this.chessColor) {
            chessboardPoints.add(new ChessboardPoint(getSource().getX(), getSource().getY() + 1));
        }
        if (getSource().getX() + 1 <=7 && getSource().getY() - 1 >= 0 && chessBoard[getSource().getX() + 1][getSource().getY() - 1].chessColor != this.chessColor) {
            chessboardPoints.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY() - 1));
        }
        if (getSource().getX() + 1 <=7 && chessBoard[getSource().getX() + 1][getSource().getY()].chessColor != this.chessColor) {
            chessboardPoints.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY()));
        }
        if (getSource().getX() + 1 <= 7 && getSource().getY() + 1 <=7  && chessBoard[getSource().getX() + 1][getSource().getY() + 1].chessColor != this.chessColor) {
            chessboardPoints.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY() + 1));
        }
        return chessboardPoints;
    }

}
