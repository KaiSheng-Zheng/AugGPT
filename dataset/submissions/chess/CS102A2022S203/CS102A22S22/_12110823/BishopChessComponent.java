import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(){}
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> want=new ArrayList<>();
        for (int i = 1; i <8 ; i++) {
            if (this.getSource().offset(-i,-i)==null){continue;}
            if (nowqipan[this.getSource().offset(-i,-i).getX()][this.getSource().offset(-i,-i).getY()].getChessColor()==this.getChessColor()){break;}
            want.add(this.getSource().offset(-i,-i));
            if (nowqipan[this.getSource().offset(-i,-i).getX()][this.getSource().offset(-i,-i).getY()].getChessColor()!=ChessColor.NONE){break;}

        }
        for (int i = 1; i <8 ; i++) {
            if (this.getSource().offset(i,i)==null){continue;}
            if (nowqipan[this.getSource().offset(i,i).getX()][this.getSource().offset(i,i).getY()].getChessColor()==this.getChessColor()){break;}
            want.add(this.getSource().offset(i,i));
            if (nowqipan[this.getSource().offset(i,i).getX()][this.getSource().offset(i,i).getY()].getChessColor()!=ChessColor.NONE){break;}
        }
        for (int i =1 ; i<8 ; i++) {
            if (this.getSource().offset(-i,i)==null){continue;}
            if (nowqipan[this.getSource().offset(-i,i).getX()][this.getSource().offset(-i,i).getY()].getChessColor()==this.getChessColor()){break;}
            want.add(this.getSource().offset(-i,i));
            if (nowqipan[this.getSource().offset(-i,i).getX()][this.getSource().offset(-i,i).getY()].getChessColor()!=ChessColor.NONE){break;}
        }
        for (int i =1 ; i<8 ; i++) {
            if (this.getSource().offset(i,-i)==null){continue;}
            if (nowqipan[this.getSource().offset(i,-i).getX()][this.getSource().offset(i,-i).getY()].getChessColor()==this.getChessColor()){break;}
            want.add(this.getSource().offset(i,-i));
            if (nowqipan[this.getSource().offset(i,-i).getX()][this.getSource().offset(i,-i).getY()].getChessColor()!=ChessColor.NONE){break;}
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
