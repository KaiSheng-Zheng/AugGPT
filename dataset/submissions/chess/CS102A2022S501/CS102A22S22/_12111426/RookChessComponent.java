import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x= getSource().getX();
        int y= getSource().getY();
        ArrayList<ChessboardPoint> b = new ArrayList<>();
        if (this.chessComponents[x][y].name == 'r' || this.chessComponents[x][y].name == 'R') {
            if (x - 1 < 0) {
                for (int i = x + 1; i <8; i++) {
                    if (this.chessComponents[i][y].getChessColor() == ChessColor.NONE) {
                        b.add(new ChessboardPoint(i, y));
                    } else if (this.chessComponents[i][y].getChessColor() != this.chessComponents[x][y].getChessColor()) {
                        b.add(new ChessboardPoint(i, y));
                        break;
                    } else {
                        break;
                    }
                }
            } else if (x - 1 >= 0 && x + 1 <= 7) {
                for (int i = x - 1; i >= 0; i--) {
                    if (this.chessComponents[i][y].getChessColor() == ChessColor.NONE) {
                        b.add(new ChessboardPoint(i, y));
                    } else if (this.chessComponents[i][y].getChessColor() != this.chessComponents[x][y].getChessColor()) {
                        b.add(new ChessboardPoint(i, y));
                        break;
                    } else {
                        break;
                    }
                }
                for (int i = x + 1; i < 8; i++) {
                    if (this.chessComponents[i][y].getChessColor() == ChessColor.NONE) {
                        b.add(new ChessboardPoint(i, y));
                    } else if (this.chessComponents[i][y].getChessColor() != this.chessComponents[x][y].getChessColor()) {
                        b.add(new ChessboardPoint(i, y));
                        break;
                    } else {
                        break;
                    }
                }
            } else {
                for (int i = x - 1; i >= 0; i--) {
                    if (this.chessComponents[i][y].getChessColor() == ChessColor.NONE) {
                        b.add(new ChessboardPoint(i, y));
                    } else if (this.chessComponents[i][y].getChessColor() != this.chessComponents[x][y].getChessColor()) {
                        b.add(new ChessboardPoint(i, y));
                        break;
                    } else {
                        break;
                    }
                }
            }
            if (y - 1 < 0) {
                for (int i = y + 1; i < 8; i++) {
                    if (this.chessComponents[x][i].getChessColor() == ChessColor.NONE) {
                        b.add(new ChessboardPoint(x, i));
                    } else if (this.chessComponents[x][i].getChessColor() != this.chessComponents[x][y].getChessColor()) {
                        b.add(new ChessboardPoint(x, i));
                        break;
                    } else {
                        break;
                    }
                }
            } else if (y - 1 >= 0 && y + 1 <=7) {
                for (int i = y - 1; i >= 0; i--) {
                    if (this.chessComponents[x][i].getChessColor() == ChessColor.NONE) {
                        b.add(new ChessboardPoint(x, i));
                    } else if (this.chessComponents[x][i].getChessColor() != this.chessComponents[x][y].getChessColor()) {
                        b.add(new ChessboardPoint(x, i));
                        break;
                    } else {
                        break;
                    }
                }
                for (int i = y + 1; i < 8; i++) {
                    if (this.chessComponents[x][i].getChessColor() == ChessColor.NONE) {
                        b.add(new ChessboardPoint(x, i));
                    } else if (this.chessComponents[x][i].getChessColor() != this.chessComponents[x][y].getChessColor()) {
                        b.add(new ChessboardPoint(x, i));
                        break;
                    } else {
                        break;
                    }
                }
            } else {
                for (int i = y-1; i >=0; i--) {
                    if (this.chessComponents[x][i].getChessColor() == ChessColor.NONE) {
                        b.add(new ChessboardPoint(x, i));
                    } else if (this.chessComponents[x][i].getChessColor() != this.chessComponents[x][y].getChessColor()) {
                        b.add(new ChessboardPoint(x, i));
                        break;
                    } else {
                        break;
                    }
                }

            }return b;
        }

        else{
            return new ArrayList<>();
        }
    }
}
