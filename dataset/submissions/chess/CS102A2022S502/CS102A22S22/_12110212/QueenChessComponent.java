import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x=this.getSource().getX();
        int y=this.getSource().getY();
        List<ChessboardPoint> canMoveTo=new ArrayList<>();
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
        for (int i = 1; i < 10; i++) {
            if (x + i > 7 || y + i > 7) {
                break;
            }
            if (chessComponents[x + i][y + i].name == '_') {
                canMoveTo.add(new ChessboardPoint(x + i, y + i));
            } else if (chessComponents[x + i][y + i].getChessColor() != this.getChessColor()) {
                canMoveTo.add(new ChessboardPoint(x + i, y + i));
                break;
            } else {
                break;
            }

        }
        for (int i = 1; i < 10; i++) {
            if (x - i < 0 || y + i > 7) {
                break;
            }
            if (chessComponents[x - i][y + i].name == '_') {
                canMoveTo.add(new ChessboardPoint(x - i, y + i));
            } else if (chessComponents[x - i][y + i].getChessColor() != this.getChessColor()) {
                canMoveTo.add(new ChessboardPoint(x - i, y + i));
                break;
            } else {
                break;
            }

        }
        for (int i = 1; i < 10; i++) {
            if (x - i < 0 || y - i < 0) {
                break;
            }
            if (chessComponents[x - i][y - i].name == '_') {
                canMoveTo.add(new ChessboardPoint(x - i, y - i));
            } else if (chessComponents[x - i][y - i].getChessColor() != this.getChessColor()) {
                canMoveTo.add(new ChessboardPoint(x - i, y - i));
                break;
            } else {
                break;
            }
        }
        for (int i = 1; i < 10; i++) {
            if (x + i > 7 || y - i < 0) {
                break;
            }
            if (chessComponents[x + i][y - i].name == '_') {
                canMoveTo.add(new ChessboardPoint(x + i, y - i));
            } else if (chessComponents[x + i][y - i].getChessColor() != this.getChessColor()) {
                canMoveTo.add(new ChessboardPoint(x + i, y - i));
                break;
            } else {
                break;
            }

        }
        return canMoveTo;
    }

    public QueenChessComponent(ChessboardPoint point, ChessColor color, char name) {
        this.setSource(point);
        this.setChessColor(color);
        this.setName(name);
    }
}
