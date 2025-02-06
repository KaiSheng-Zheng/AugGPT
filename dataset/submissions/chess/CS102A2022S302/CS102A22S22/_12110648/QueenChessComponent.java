import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    private ChessColor chessColor;

    @Override
    public ChessColor getChessColor() {
        return chessColor;
    }

    public QueenChessComponent(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> answer=new ArrayList<>();
        for (int i = getSource().getX()+1; i <8 ; i++) {
           if (chessboard[i][getSource().getY()].getChessColor()==ChessColor.NONE){
               answer.add(new ChessboardPoint(i, getSource().getY()));
           }
           else if (this.chessColor!=chessboard[i][getSource().getY()].getChessColor())
           { answer.add(new ChessboardPoint(i, getSource().getY()));break;}
           else {break;
        }
    }
        for (int i = getSource().getX()-1; i>=0 ; i--) {
            if (chessboard[i][getSource().getY()].getChessColor()==ChessColor.NONE){
                answer.add(new ChessboardPoint(i, getSource().getY()));
            }   else if (this.chessColor!=chessboard[i][getSource().getY()].getChessColor())
            { answer.add(new ChessboardPoint(i, getSource().getY()));break;}
            else {break;
            }
        }
        for (int i = getSource().getY()+1; i <8 ; i++) {
            if (chessboard[getSource().getX()][i].getChessColor()==ChessColor.NONE){
                answer.add(new ChessboardPoint(getSource().getX(),i));
            }   else if (this.chessColor!=chessboard[getSource().getX()][i].getChessColor())
            { answer.add(new ChessboardPoint(i, getSource().getY()));break;}  else {break;
            }
        }
        for (int i = getSource().getY()-1; i>=0 ; i--) {
            if (chessboard[getSource().getX()][i].getChessColor()==ChessColor.NONE){
                answer.add(new ChessboardPoint(getSource().getX(), i));
            } else if (this.chessColor!=chessboard[getSource().getX()][i].getChessColor())
            { answer.add(new ChessboardPoint(i, getSource().getY()));break;}   else {break;
            }
        }
        for (int i = 1; i <8 ; i++) {
            int a=getSource().getX()+i;int b= getSource().getY()+i;
            if (a<8&&b<8){
            if (chessboard[getSource().getX()+i][getSource().getY()+i].getChessColor()==ChessColor.NONE){
                answer.add(new ChessboardPoint(getSource().getX()+i,getSource().getY()+i));
            }else if (chessboard[getSource().getX()+i][getSource().getY()+i].getChessColor()!=this.chessColor)
            {answer.add(new ChessboardPoint(getSource().getX()+i,getSource().getY()+i));break;
        }else {break;}
        }}
        for (int i = 1; i <8 ; i++) {
            int a=getSource().getX()-i;int b= getSource().getY()-i;
            if (a>=0&&b>=0){
            if (chessboard[getSource().getX()-i][getSource().getY()-i].getChessColor()==ChessColor.NONE){
                answer.add(new ChessboardPoint(getSource().getX()-i,getSource().getY()-i));
            }else if (chessboard[getSource().getX()-i][getSource().getY()-i].getChessColor()!=this.chessColor)
            {answer.add(new ChessboardPoint(getSource().getX()-i,getSource().getY()-i));break;
            }else {break;}
        }}
        for (int i = 1; i <8 ; i++) {
            int a=getSource().getX()-i;int b= getSource().getY()+i;
            if (a>=0&&b<8){
            if (chessboard[getSource().getX()-i][getSource().getY()+i].getChessColor()==ChessColor.NONE){
                answer.add(new ChessboardPoint(getSource().getX()-i,getSource().getY()+i));
            }else if (chessboard[getSource().getX()-i][getSource().getY()+i].getChessColor()!=this.chessColor)
            {answer.add(new ChessboardPoint(getSource().getX()-i,getSource().getY()+i));break;
            }else {break;}
        }}
        for (int i = 1; i <8 ; i++) {
            int a=getSource().getX()+i;int b= getSource().getY()-i;
            if (b>=0&&a<8){
            if (chessboard[getSource().getX()+i][getSource().getY()-i].getChessColor()==ChessColor.NONE){
                answer.add(new ChessboardPoint(getSource().getX()+i,getSource().getY()-i));
            }else if (chessboard[getSource().getX()+i][getSource().getY()-i].getChessColor()!=this.chessColor)
            {answer.add(new ChessboardPoint(getSource().getX()+i,getSource().getY()-i));break;
            }else {break;}
        }}
    return answer;}}
