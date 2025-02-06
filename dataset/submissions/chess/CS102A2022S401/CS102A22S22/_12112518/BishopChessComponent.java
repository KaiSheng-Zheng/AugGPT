import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(){};

    public BishopChessComponent(char name, ChessboardPoint where, ChessColor chessColor){
        this.name = name;
        this.setSource(where);
        this.setChessColor(chessColor);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chessPoint = new ArrayList<>();
        for (int i = 1; i <= 7 ; i++) {
            if (this.getSource().offset(-i, -i) == null){
                break;
            }
            if (this.chessboard[this.getSource().getX() - i][this.getSource().getY() - i].getChessColor() == this.getChessColor() ){
                break;
            }
            if (this.chessboard[this.getSource().getX() - i][this.getSource().getY() - i].getChessColor() != this.getChessColor() &&
                    this.chessboard[this.getSource().getX() - i][this.getSource().getY() - i].getChessColor() != ChessColor.NONE){
                chessPoint.add(this.getSource().offset( - i,  - i));
                break;
            }
            chessPoint.add(this.getSource().offset(-i, -i));
        }
        for (int i = 1; i <= 7 ; i++) {
            if (this.getSource().offset(i, -i) == null){
                break;
            }
            if (this.chessboard[this.getSource().getX() + i][this.getSource().getY() - i].getChessColor() == this.getChessColor() ){
                break;
            }
            if (this.chessboard[this.getSource().getX() + i][this.getSource().getY() - i].getChessColor() != this.getChessColor() &&
                    this.chessboard[this.getSource().getX() + i][this.getSource().getY() - i].getChessColor() != ChessColor.NONE){
                chessPoint.add(this.getSource().offset( i, - i));
                break;
            }
            chessPoint.add(this.getSource().offset(i, -i));
        }
        for (int i = 1; i <= 7 ; i++) {
            if (this.getSource().offset(i, i) == null){
                break;
            }
            if (this.chessboard[this.getSource().getX() + i][this.getSource().getY() + i].getChessColor() == this.getChessColor() ){
                break;
            }
            if (this.chessboard[this.getSource().getX() + i][this.getSource().getY() + i].getChessColor() != this.getChessColor() &&
                    this.chessboard[this.getSource().getX() + i][this.getSource().getY() + i].getChessColor() != ChessColor.NONE){
                chessPoint.add(this.getSource().offset( i,  i));
                break;
            }
            chessPoint.add(this.getSource().offset(i, i));
        }for (int i = 1; i <= 7 ; i++) {
            if (this.getSource().offset(-i, i) == null){
                break;
            }
            if (this.chessboard[this.getSource().getX() - i][this.getSource().getY() + i].getChessColor() == this.getChessColor() ){
                break;
            }
            if (this.chessboard[this.getSource().getX() - i][this.getSource().getY() + i].getChessColor() != this.getChessColor() &&
                    this.chessboard[this.getSource().getX() - i][this.getSource().getY() + i].getChessColor() != ChessColor.NONE){
                chessPoint.add(this.getSource().offset( - i,  i));

                break;
            }

            chessPoint.add(this.getSource().offset(-i, i));
        }
        return chessPoint;
    }

}