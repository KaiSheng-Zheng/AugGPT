import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    public RookChessComponent(){}
    @Override
    public List<ChessboardPoint> canMoveTo() {

        List<ChessboardPoint> want=new ArrayList<>();
        for (int i = 1; i <8-this.getSource().getX() ; i++) {
            if (this.getSource().offset(i,0)==null){continue;}
            if (nowqipan[this.getSource().offset(i,0).getX()][this.getSource().offset(i,0).getY()].getChessColor()==this.getChessColor()){break;}
            want.add(this.getSource().offset(i,0));
            if (nowqipan[this.getSource().offset(i,0).getX()][this.getSource().offset(i,0).getY()].getChessColor()!=ChessColor.NONE){break;}

        }
        for (int i = 1; i <8-this.getSource().getY() ; i++) {
            if (this.getSource().offset(0,i)==null){continue;}
            if (nowqipan[this.getSource().offset(0,i).getX()][this.getSource().offset(0,i).getY()].getChessColor()==this.getChessColor()){break;}
            want.add(this.getSource().offset(0,i));
            if (nowqipan[this.getSource().offset(0,i).getX()][this.getSource().offset(0,i).getY()].getChessColor()!=ChessColor.NONE){break;}
        }
        for (int i =1 ; i<this.getSource().getX()+1 ; i++) {
            if (this.getSource().offset(-i,0)==null){continue;}
            if (nowqipan[this.getSource().offset(-i,0).getX()][this.getSource().offset(-i,0).getY()].getChessColor()==this.getChessColor()){break;}
            want.add(this.getSource().offset(-i,0));
            if (nowqipan[this.getSource().offset(-i,0).getX()][this.getSource().offset(-i,0).getY()].getChessColor()!=ChessColor.NONE){break;}
        }
        for (int i =1 ; i<this.getSource().getY()+1 ; i++) {
            if (this.getSource().offset(0,-i)==null){continue;}
            if (nowqipan[this.getSource().offset(0,-i).getX()][this.getSource().offset(0,-i).getY()].getChessColor()==this.getChessColor()){break;}
            want.add(this.getSource().offset(0,-i));
            if (nowqipan[this.getSource().offset(0,-i).getX()][this.getSource().offset(0,-i).getY()].getChessColor()!=ChessColor.NONE){break;}
        }
        List<ChessboardPoint> kong = new ArrayList<>(want);
        for (int i = 0; i < want.size(); i++) {
            if (this.getChessColor()==nowqipan[kong.get(i).getX()][kong.get(i).getY()].getChessColor()){
                want.remove(kong.get(i));
            }
        }
        return want;
    }

}
