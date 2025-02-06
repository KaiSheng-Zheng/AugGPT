import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    public RookChessComponent(ChessColor color){
        if(color.equals(ChessColor.WHITE)) super.name = 'r';
        if(color.equals(ChessColor.BLACK)) super.name = 'R';
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
        return canMoveTo;
    }
}
