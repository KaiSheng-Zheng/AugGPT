import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    public KingChessComponent(ChessColor color,Character name,ChessboardPoint source){
        super(color,name,source);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List <ChessboardPoint> canMove =new ArrayList<>();
       // if(getSource().getX()!=7&&getSource().getX()!=0&&getSource().getY()!=0&getSource().getY()!=7) {
            if (getSource().getX()+1<=7&&chessboard[getSource().getX() + 1][getSource().getY()].getChessColor() != this.getChessColor()) {
                canMove.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY()));
            }
            if (getSource().getX()<=6&&getSource().getY()<=6&&chessboard[getSource().getX() + 1][getSource().getY() + 1].getChessColor() != this.getChessColor()) {
                canMove.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY() + 1));
            }
            if (getSource().getY()<=6&&chessboard[getSource().getX()][getSource().getY() + 1].getChessColor() != this.getChessColor()) {
                canMove.add(new ChessboardPoint(getSource().getX(), getSource().getY() + 1));
            }
            if (getSource().getX()>=1&&chessboard[getSource().getX() -1][getSource().getY()].getChessColor() != this.getChessColor()) {
                canMove.add(new ChessboardPoint(getSource().getX() -1, getSource().getY()));
            }
            if (getSource().getX()<=6&&getSource().getY()>=1&&chessboard[getSource().getX() +1][getSource().getY()-1].getChessColor() != this.getChessColor()) {
                canMove.add(new ChessboardPoint(getSource().getX() +1, getSource().getY()-1));
            }
            if (getSource().getX()>=1&&getSource().getY()>=1&&chessboard[getSource().getX() -1][getSource().getY()-1].getChessColor() != this.getChessColor()) {
                canMove.add(new ChessboardPoint(getSource().getX() -1, getSource().getY()-1));
            }
            if (getSource().getY()>=1&&chessboard[getSource().getX() ][getSource().getY()-1].getChessColor() != this.getChessColor()) {
                canMove.add(new ChessboardPoint(getSource().getX() , getSource().getY()-1));
            }
            if (getSource().getX()>=1&&getSource().getY()<=6&&chessboard[getSource().getX() -1][getSource().getY()+1].getChessColor() != this.getChessColor()) {
                canMove.add(new ChessboardPoint(getSource().getX() -1, getSource().getY()+1));
            }
        return canMove;
    }


}