import java.util.ArrayList;
import java.util.List;

public  class KingChessComponent extends ChessComponent{


    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> CanMove=new ArrayList<>();
        for (int i = 0; i <8 ; i++) {
            for (int j = 0; j <8 ; j++) {
                ChessComponent toExam=this.NowBoard[i][j];
                if(toExam.getChessColor()!=getChessColor()&&(Math.abs(toExam.getSource().getX()-this.getSource().getX())<=1)&&(Math.abs(toExam.getSource().getY()-getSource().getY())<=1)&&!(toExam.getSource().getX()== getSource().getX()&&toExam.getSource().getY()==this.getSource().getY())){
                    CanMove.add(toExam.getSource());
                }
            }
        }
        return CanMove;
    }
}
