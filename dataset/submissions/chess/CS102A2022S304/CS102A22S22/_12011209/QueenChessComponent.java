import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent {
    public QueenChessComponent(ChessColor color) {
        if (color.equals(ChessColor.WHITE)) super.name = 'q';
        if (color.equals(ChessColor.BLACK)) super.name = 'Q';
        super.setChessColor(color);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMoveTo = new ArrayList<>();
        int x0 = super.getSource().getX();
        int y0 = super.getSource().getY();
        for (int i = x0 - 1; i >= 0; i--) {
            if (super.chessBoard[i][y0].toString().equals("_")) canMoveTo.add(new ChessboardPoint(i, y0));
            else if (super.chessBoard[i][y0].getChessColor().equals(this.getChessColor())) {
                break;
            } else {
                canMoveTo.add(new ChessboardPoint(i, y0));
                break;
            }
        }
        for (int i = x0 + 1; i < 8; i++) {
            if (super.chessBoard[i][y0].toString().equals("_")) canMoveTo.add(new ChessboardPoint(i, y0));
            else if (super.chessBoard[i][y0].getChessColor().equals(this.getChessColor())) {
                break;
            } else {
                canMoveTo.add(new ChessboardPoint(i, y0));
                break;
            }
        }

        for (int i = y0 - 1; i >= 0; i--) {
            if (super.chessBoard[x0][i].toString().equals("_")) canMoveTo.add(new ChessboardPoint(x0, i));
            else if (super.chessBoard[x0][i].getChessColor().equals(this.getChessColor())) {
                break;
            } else {
                canMoveTo.add(new ChessboardPoint(x0, i));
                break;
            }
        }
        for (int i = y0 + 1; i < 8; i++) {
            if (super.chessBoard[x0][i].toString().equals("_")) canMoveTo.add(new ChessboardPoint(x0, i));
            else if (super.chessBoard[x0][i].getChessColor().equals(this.getChessColor())) {
                break;
            } else {
                canMoveTo.add(new ChessboardPoint(x0, i));
                break;
            }
        }

        if (x0 > y0) {
            for (int i = y0 - 1; i >= 0; i--) {
                if (super.chessBoard[i + x0 - y0][i].toString().equals("_"))
                    canMoveTo.add(new ChessboardPoint(i + x0 - y0, i));
                else if (super.chessBoard[i + x0 - y0][i].getChessColor().equals(this.getChessColor())) break;
                else {
                    canMoveTo.add(new ChessboardPoint(i + x0 - y0, i));
                    break;
                }
            }
            for (int i = y0 + 1; i < 8 - x0 + y0; i++) {
                if (super.chessBoard[i + x0 - y0][i].toString().equals("_"))
                    canMoveTo.add(new ChessboardPoint(i + x0 - y0, i));
                else if (super.chessBoard[i + x0 - y0][i].getChessColor().equals(this.getChessColor())) break;
                else {
                    canMoveTo.add(new ChessboardPoint(i + x0 - y0, i));
                    break;
                }
            }
        } else {
            for (int i = x0 - 1; i >= 0; i--) {
                if (super.chessBoard[i][i + y0 - x0].toString().equals("_"))
                    canMoveTo.add(new ChessboardPoint(i, i + y0 - x0));
                else if (super.chessBoard[i][i + y0 - x0].getChessColor().equals(this.getChessColor())) break;
                else {
                    canMoveTo.add(new ChessboardPoint(i, i + y0 - x0));
                    break;
                }
            }
            for (int i = x0 + 1; i < 8 - y0 + x0; i++) {
                if (super.chessBoard[i][i + y0 - x0].toString().equals("_"))
                    canMoveTo.add(new ChessboardPoint(i, i + y0 - x0));
                else if (super.chessBoard[i][i + y0 - x0].getChessColor().equals(this.getChessColor())) break;
                else {
                    canMoveTo.add(new ChessboardPoint(i, i + y0 - x0));
                    break;
                }
            }
        }

        if (x0 + y0 < 7) {
            for (int i = x0 - 1; i >= 0; i--) {
                if (super.chessBoard[i][x0 + y0 - i].toString().equals("_")) {
                    canMoveTo.add(new ChessboardPoint(i, x0 + y0 - i));
                } else if (super.chessBoard[i][x0 + y0 - i].getChessColor().equals(this.getChessColor())) break;
                else {
                    canMoveTo.add(new ChessboardPoint(i, x0 + y0 - i));
                    break;
                }
            }
            for (int i = x0 + 1; i < x0 + y0 + 1; i++) {
                if (super.chessBoard[i][x0 + y0 - i].toString().equals("_")) {
                    canMoveTo.add(new ChessboardPoint(i, x0 + y0 - i));
                } else if (super.chessBoard[i][x0 + y0 - i].getChessColor().equals(this.getChessColor())) break;
                else {
                    canMoveTo.add(new ChessboardPoint(i, x0 + y0 - i));
                    break;
                }
            }
        } else{
            for (int i = x0 - 1; i >= x0 + y0 - 7; i--) {
                    if (super.chessBoard[i][x0 + y0 - i].toString().equals("_")) {
                        canMoveTo.add(new ChessboardPoint(i, x0 + y0 - i));
                    }else if (super.chessBoard[i][x0 + y0 - i].getChessColor().equals(this.getChessColor())) break;
                    else {
                        canMoveTo.add(new ChessboardPoint(i, x0 + y0 - i));
                        break;
                    }
            }
            for (int i = x0 + 1; i < 8; i++) {
                if (super.chessBoard[i][x0 + y0 - i].toString().equals("_")) {
                    canMoveTo.add(new ChessboardPoint(i, x0 + y0 - i));
                }else if (super.chessBoard[i][x0 + y0 - i].getChessColor().equals(this.getChessColor())) break;
                else {
                    canMoveTo.add(new ChessboardPoint(i, x0 + y0 - i));
                    break;
                }
            }
        }


        return canMoveTo;
    }
}
