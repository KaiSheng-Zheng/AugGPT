import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    public RookChessComponent(){};

    public RookChessComponent(char name, ChessboardPoint where, ChessColor chessColor){
        this.name = name;
        this.setSource(where);
        this.setChessColor(chessColor);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chessPoint = new ArrayList<>();
        int row = this.getSource().getX();
        int col = this.getSource().getY();
        for (int i = this.getSource().getY() - 1; i >= 0; i--) {
            if (i < 0){
                break;
            }
            if (this.chessboard[row][i].getChessColor() == this.getChessColor() ||
                    this.getSource().offset(0, i - this.getSource().getY()) == null){
                break;
            }
            if (this.chessboard[row][i].getChessColor() != this.getChessColor() &&
                    this.chessboard[row][i].getChessColor() != ChessColor.NONE){
                chessPoint.add(new ChessboardPoint(row, i));
                break;
            }
            chessPoint.add(this.getSource().offset(0, i - this.getSource().getY() ));
        }
        for (int i = this.getSource().getY() + 1; i <= 7; i++) {
            if (i > 7){
                break;
            }
            if (this.chessboard[row][i].getChessColor() == this.getChessColor() ||
                    this.getSource().offset(0, i - this.getSource().getY()) == null){
                break;
            }
            if (this.chessboard[row][i].getChessColor() != this.getChessColor() &&
                    this.chessboard[row][i].getChessColor() != ChessColor.NONE){
                chessPoint.add(new ChessboardPoint(row, i));
                break;
            }
            chessPoint.add(this.getSource().offset(0, i - this.getSource().getY() ));
        }
        for (int i = this.getSource().getX() - 1; i >= 0; i--) {
            if (i < 0){
                break;
            }
            if (this.chessboard[i][col].getChessColor() == this.getChessColor() ||
                    this.getSource().offset(i - this.getSource().getX(), 0) == null){
                break;
            }
            if (this.chessboard[i][col].getChessColor() != this.getChessColor() &&
                    this.chessboard[i][col].getChessColor() != ChessColor.NONE){
                chessPoint.add(new ChessboardPoint(i, col));
                break;
            }
            chessPoint.add(this.getSource().offset(i - this.getSource().getX(), 0 ));
        }
        for (int i = this.getSource().getX() + 1; i <= 7; i++) {
            if (i > 7){
                break;
            }
            if (this.chessboard[i][col].getChessColor() == this.getChessColor() ||
                    this.getSource().offset(i - this.getSource().getX(), 0) == null){
                break;
            }
            if (this.chessboard[i][col].getChessColor() != this.getChessColor() &&
                    this.chessboard[i][col].getChessColor() != ChessColor.NONE){
                chessPoint.add(new ChessboardPoint(i, col));
                break;
            }
            chessPoint.add(this.getSource().offset(i - this.getSource().getX(), 0 ));
        }
        return chessPoint;
    }
}
