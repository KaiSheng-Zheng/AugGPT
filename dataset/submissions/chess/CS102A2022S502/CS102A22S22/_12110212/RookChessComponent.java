import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMoveTo = new ArrayList<>();
        for (int i = 1; i < 8 - this.getSource().getX(); i++) {
            if (this.chessComponents[this.getSource().getX() + i][this.getSource().getY()].name == '_') {
                canMoveTo.add(new ChessboardPoint(this.getSource().getX() + i, this.getSource().getY()));
            } else if (this.chessComponents[this.getSource().getX() + i][this.getSource().getY()].name != '_' && this.chessComponents[this.getSource().getX() + i][this.getSource().getY()].getChessColor() != this.getChessColor()) {
                canMoveTo.add(new ChessboardPoint(this.getSource().getX() + i, this.getSource().getY()));
                break;
            } else {
                break;
            }
        }
        for (int i = 1; i <= this.getSource().getX(); i++) {
            if (this.chessComponents[this.getSource().getX() - i][this.getSource().getY()].name == '_') {
                canMoveTo.add(new ChessboardPoint(this.getSource().getX() - i, this.getSource().getY()));
            } else if (this.chessComponents[this.getSource().getX() - i][this.getSource().getY()].name != '_' && this.chessComponents[this.getSource().getX() - i][this.getSource().getY()].getChessColor() != this.getChessColor()) {
                canMoveTo.add(new ChessboardPoint(this.getSource().getX() - i, this.getSource().getY()));
                break;
            } else {
                break;
            }

        }
        for (int i = 1; i < 8 - this.getSource().getY(); i++) {
            if (this.chessComponents[this.getSource().getX()][this.getSource().getY() + i].name == '_') {
                canMoveTo.add(new ChessboardPoint(this.getSource().getX(), this.getSource().getY() + i));
            } else if (this.chessComponents[this.getSource().getX()][this.getSource().getY() + i].name != '_' && this.chessComponents[this.getSource().getX()][this.getSource().getY() + i].getChessColor() != this.getChessColor()) {
                canMoveTo.add(new ChessboardPoint(this.getSource().getX(), this.getSource().getY() + i));
                break;
            } else {
                break;
            }

        }
        for (int i = 1; i <= this.getSource().getY(); i++) {
            if (this.chessComponents[this.getSource().getX()][this.getSource().getY() - i].name == '_') {
                canMoveTo.add(new ChessboardPoint(this.getSource().getX(), this.getSource().getY() - i));
            } else if (this.chessComponents[this.getSource().getX()][this.getSource().getY() - i].name != '_' && this.chessComponents[this.getSource().getX()][this.getSource().getY() - i].getChessColor() != this.getChessColor()) {
                canMoveTo.add(new ChessboardPoint(this.getSource().getX(), this.getSource().getY() - i));
                break;
            } else {
                break;
            }

        }
        return canMoveTo;
    }

    public RookChessComponent(ChessboardPoint point, ChessColor color, char name) {
        this.setSource(point);
        this.setChessColor(color);
        this.setName(name);
    }
}
