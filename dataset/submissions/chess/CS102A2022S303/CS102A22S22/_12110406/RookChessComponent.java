import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{


    public RookChessComponent(char name, ChessColor chessColor, ChessboardPoint source) {
        super(name, chessColor, source);
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chessboardPointArrayList = new ArrayList<>();
        int X = this.getSource().getX();
        int Y = this.getSource().getY();
        for (int i = X + 1; i < 8; i++) {
            if (chessComponents[i][Y].getChessColor() == ChessColor.NONE) {
                chessboardPointArrayList.add(new ChessboardPoint(i, Y));
            }
            else if (chessComponents[i][Y].getChessColor() == this.getChessColor()) {
                break;
            }
            else if (chessComponents[i][Y].getChessColor() != this.getChessColor()) {
                chessboardPointArrayList.add(new ChessboardPoint(i, Y));
                break;
            }
        }
        for (int i = X - 1; i >= 0; i--) {
            if (chessComponents[i][Y].getChessColor() == ChessColor.NONE) {
                chessboardPointArrayList.add(new ChessboardPoint(i, Y));
            }
            else if (chessComponents[i][Y].getChessColor() == this.getChessColor()) {
                break;
            }
            else if (chessComponents[i][Y].getChessColor() != this.getChessColor()) {
                chessboardPointArrayList.add(new ChessboardPoint(i, Y));
                break;
            }
        }
        for (int i = Y + 1; i < 8; i++) {
            if (chessComponents[X][i].getChessColor() == ChessColor.NONE) {
                chessboardPointArrayList.add(new ChessboardPoint(X, i));
            }
            else if (chessComponents[X][i].getChessColor() == this.getChessColor()) {
                break;
            }
            else if (chessComponents[X][i].getChessColor() != this.getChessColor()) {
                chessboardPointArrayList.add(new ChessboardPoint(X, i));
                break;
            }
        }
        for (int i = Y - 1; i >= 0; i--) {
            if (chessComponents[X][i].getChessColor() == ChessColor.NONE) {
                chessboardPointArrayList.add(new ChessboardPoint(X, i));
            }
            else if (chessComponents[X][i].getChessColor() == this.getChessColor()) {
                break;
            }
            else if (chessComponents[X][i].getChessColor() != this.getChessColor()) {
                chessboardPointArrayList.add(new ChessboardPoint(X, i));
                break;
            }
        }
        return chessboardPointArrayList;
    }
}
