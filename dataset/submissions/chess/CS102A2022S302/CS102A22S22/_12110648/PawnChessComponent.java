import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    private ChessColor chessColor;

    @Override
    public ChessColor getChessColor() {
        return chessColor;
    }

    public PawnChessComponent(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> answer=new ArrayList<>();
        if (this.chessColor==ChessColor.WHITE){
            if (getSource().getX()==6){
                for (int i = 1; i <3 ; i++) {
                    if (chessboard[6-i][getSource().getY()].getChessColor()==ChessColor.NONE){
                        answer.add(new ChessboardPoint(6-i, getSource().getY()));
                    }else {break;
                }
            }if ((getSource().getY()+1)<8&&chessboard[5][getSource().getY()+1].getChessColor()==ChessColor.BLACK){
                    answer.add(new ChessboardPoint(5, getSource().getY()+1));
                }
                if ((getSource().getY()-1)>=0&&chessboard[5][getSource().getY()-1].getChessColor()==ChessColor.BLACK){
                    answer.add(new ChessboardPoint(5, getSource().getY()-1));
                }
        }
            else {
                if ((getSource().getX()-1)>=0&&chessboard[getSource().getX()-1][getSource().getY()].getChessColor()==ChessColor.NONE){
                    answer.add(new ChessboardPoint(getSource().getX()-1, getSource().getY()));
                }
            if ((getSource().getX()-1)>=0&&(getSource().getY()+1)<8&&chessboard[getSource().getX()-1][getSource().getY()+1].getChessColor()==ChessColor.BLACK){
                answer.add(new ChessboardPoint(getSource().getX()-1, getSource().getY()+1));
            }
                if ((getSource().getY()-1)>=0&&(getSource().getX()-1)>=0&&chessboard[getSource().getX()-1][getSource().getY()-1].getChessColor()==ChessColor.BLACK){
                    answer.add(new ChessboardPoint(getSource().getX()-1, getSource().getY()-1));
                }
            }}
        else {
            if (getSource().getX()==1){
                for (int i = 1; i <3 ; i++) {
                    if (chessboard[1+i][getSource().getY()].getChessColor()==ChessColor.NONE){
                        answer.add(new ChessboardPoint(1+i, getSource().getY()));
                    }else {break;
                    }
                }if ((getSource().getY()+1)<8&&chessboard[2][getSource().getY()+1].getChessColor()==ChessColor.WHITE){
                    answer.add(new ChessboardPoint(2, getSource().getY()+1));
                }
                if ((getSource().getY()-1)>=0&&chessboard[2][getSource().getY()-1].getChessColor()==ChessColor.WHITE){
                    answer.add(new ChessboardPoint(2, getSource().getY()-1));
                }
            }
            else {
                if ((getSource().getX()+1)<8&&chessboard[getSource().getX()+1][getSource().getY()].getChessColor()==ChessColor.NONE){
                    answer.add(new ChessboardPoint(getSource().getX()+1, getSource().getY()));
                }
            if ((getSource().getX()+1)<8&&(getSource().getY()+1)<8&&chessboard[getSource().getX()+1][getSource().getY()+1].getChessColor()==ChessColor.WHITE){
                answer.add(new ChessboardPoint(getSource().getX()+1, getSource().getY()+1));
            }
            if ((getSource().getX()+1)<8&&(getSource().getY()-1)>=0&&chessboard[getSource().getX()+1][getSource().getY()-1].getChessColor()==ChessColor.WHITE){
                answer.add(new ChessboardPoint(getSource().getX()+1, getSource().getY()-1));
            }
        }}
        return answer;

        }
}