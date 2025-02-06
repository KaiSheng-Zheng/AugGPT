import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
   private ChessColor chessColor;

    public RookChessComponent(ChessColor chessColor) {
        this.chessColor=chessColor;
    }

    @Override
    public ChessColor getChessColor() {
        return chessColor;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> answer=new ArrayList<>();
        for (int i = getSource().getX()+1; i <8 ; i++) {
            if (chessboard[i][getSource().getY()].getChessColor()==ChessColor.NONE){
                answer.add(new ChessboardPoint(i, getSource().getY()));continue;
            }
            else if (this.chessColor!=chessboard[i][getSource().getY()].getChessColor()&&chessboard[i][getSource().getY()].getChessColor()!=ChessColor.NONE)
            { answer.add(new ChessboardPoint(i, getSource().getY()));break;}
            else {break;
            }
        }
        for (int i = getSource().getX()-1; i>=0 ; i--) {
            if (chessboard[i][getSource().getY()].getChessColor()==ChessColor.NONE){
                answer.add(new ChessboardPoint(i, getSource().getY()));continue;
            }   else if (this.chessColor!=chessboard[i][getSource().getY()].getChessColor()&&chessboard[i][getSource().getY()].getChessColor()!=ChessColor.NONE)
            { answer.add(new ChessboardPoint(i, getSource().getY()));break;}
            else {break;
            }
        }
        for (int i = getSource().getY()+1; i <8 ; i++) {
            if (chessboard[getSource().getX()][i].getChessColor()==ChessColor.NONE){
                answer.add(new ChessboardPoint(getSource().getX(),i));continue;
            }   else if (this.chessColor!=chessboard[getSource().getX()][i].getChessColor()&&chessboard[getSource().getX()][i].getChessColor()!=ChessColor.NONE)
            { answer.add(new ChessboardPoint(getSource().getX(), i));break;}  else {break;
            }
        }
        for (int i = getSource().getY()-1; i>=0 ; i--) {
            if (chessboard[getSource().getX()][i].getChessColor()==ChessColor.NONE){
                answer.add(new ChessboardPoint(getSource().getX(), i));continue;
            } else if (this.chessColor!=chessboard[getSource().getX()][i].getChessColor()&&chessboard[getSource().getX()][i].getChessColor()!=ChessColor.NONE)
            { answer.add(new ChessboardPoint(getSource().getX(),i));break;}   else {break;
            }
        }
    return answer;}
}