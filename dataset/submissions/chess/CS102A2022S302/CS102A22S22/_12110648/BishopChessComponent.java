import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    private ChessColor chessColor;

    public BishopChessComponent(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    @Override
    public ChessColor getChessColor() {
        return chessColor;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> answer=new ArrayList<>();
        for (int i = 1; i <8 ; i++) {
            int a=getSource().getX()+i;int b= getSource().getY()+i;
            if (a<8&&b<8){
                if (chessboard[getSource().getX()+i][getSource().getY()+i].getChessColor()==ChessColor.NONE){
                    answer.add(new ChessboardPoint(getSource().getX()+i,getSource().getY()+i));continue;
                }else if (chessboard[getSource().getX()+i][getSource().getY()+i].getChessColor()!=this.chessColor)
                {answer.add(new ChessboardPoint(getSource().getX()+i,getSource().getY()+i));break;
                }else {break;}
            }}
        for (int i = 1; i <8 ; i++) {
            int a=getSource().getX()-i;int b= getSource().getY()-i;
            if (a>=0&&b>=0){
                if (chessboard[getSource().getX()-i][getSource().getY()-i].getChessColor()==ChessColor.NONE){
                    answer.add(new ChessboardPoint(getSource().getX()-i,getSource().getY()-i));continue;
                }else if (chessboard[getSource().getX()-i][getSource().getY()-i].getChessColor()!=this.chessColor)
                {answer.add(new ChessboardPoint(getSource().getX()-i,getSource().getY()-i));break;
                }else {break;}
            }}
        for (int i = 1; i <8 ; i++) {
            int a=getSource().getX()-i;int b= getSource().getY()+i;
            if (a>=0&&b<8){
                if (chessboard[getSource().getX()-i][getSource().getY()+i].getChessColor()==ChessColor.NONE){
                    answer.add(new ChessboardPoint(getSource().getX()-i,getSource().getY()+i));continue;
                }else if (chessboard[getSource().getX()-i][getSource().getY()+i].getChessColor()!=this.chessColor)
                {answer.add(new ChessboardPoint(getSource().getX()-i,getSource().getY()+i));break;
                }else {break;}
            }}
        for (int i = 1; i <8 ; i++) {
            int a=getSource().getX()+i;int b= getSource().getY()-i;
            if (b>=0&&a<8){
                if (chessboard[getSource().getX()+i][getSource().getY()-i].getChessColor()==ChessColor.NONE){
                    answer.add(new ChessboardPoint(getSource().getX()+i,getSource().getY()-i));continue;
                }else if (chessboard[getSource().getX()+i][getSource().getY()-i].getChessColor()!=this.chessColor)
                {answer.add(new ChessboardPoint(getSource().getX()+i,getSource().getY()-i));break;
                }else {break;}
            }}
        return answer;}

    }