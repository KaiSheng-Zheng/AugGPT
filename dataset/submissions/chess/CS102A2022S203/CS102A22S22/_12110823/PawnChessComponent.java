import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(){}
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> want=new ArrayList<>();
             if (this.getChessColor()==ChessColor.BLACK){
                 if (this.getSource().getX()==1){
                     want.add(this.getSource().offset(1,0));
                     want.add(this.getSource().offset(2,0));
                     if (nowqipan[this.getSource().getX()+2][this.getSource().getY()].getChessColor()!=ChessColor.NONE){
                         want.remove(this.getSource().offset(2,0));
                     }
                     if (nowqipan[this.getSource().getX()+1][this.getSource().getY()].getChessColor()!=ChessColor.NONE){
                         want.remove(this.getSource().offset(2,0));
                         want.remove(this.getSource().offset(1,0));
                     }
                 }
                 else {
                     if (this.getSource().offset(1,0)!=null&&nowqipan[this.getSource().getX()+1][this.getSource().getY()].getChessColor()==ChessColor.NONE){
                         want.add(this.getSource().offset(1,0));
                     }
                 }
                 if (this.getSource().offset(1,1)!=null){
                     if (nowqipan[this.getSource().getX()+1][this.getSource().getY()+1].getChessColor()==ChessColor.WHITE){
                         want.add(this.getSource().offset(1,1));
                     }}
                 if (this.getSource().offset(1,-1)!=null){
                     if (nowqipan[this.getSource().getX()-1][this.getSource().getY()+1].getChessColor()==ChessColor.WHITE){
                         want.add(this.getSource().offset(1,-1));
                     }}
             }
        if (this.getChessColor()==ChessColor.WHITE){
            if (this.getSource().getX()==6){
                want.add(this.getSource().offset(-1,0));
                want.add(this.getSource().offset(-2,0));
                if (nowqipan[this.getSource().getX()-2][this.getSource().getY()].getChessColor()!=ChessColor.NONE){
                    want.remove(this.getSource().offset(-2,0));
                }
                if (nowqipan[this.getSource().getX()-1][this.getSource().getY()].getChessColor()!=ChessColor.NONE){
                    want.remove(this.getSource().offset(-2,0));
                    want.remove(this.getSource().offset(-1,0));
                }
            }
            else {
                if (this.getSource().offset(-1,0)!=null&&nowqipan[this.getSource().getX()-1][this.getSource().getY()].getChessColor()==ChessColor.NONE){
                    want.add(this.getSource().offset(-1,0));
                }
            }
            if (this.getSource().offset(-1,1)!=null){
                if (nowqipan[this.getSource().getX()-1][this.getSource().getY()+1].getChessColor()==ChessColor.BLACK){
                    want.add(this.getSource().offset(-1,1));
                }}
            if (this.getSource().offset(-1,-1)!=null){
                if (nowqipan[this.getSource().getX()-1][this.getSource().getY()-1].getChessColor()==ChessColor.BLACK){
                    want.add(this.getSource().offset(-1,-1));
                }}
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
