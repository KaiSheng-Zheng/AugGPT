import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{

    public KnightChessComponent(){}
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> want=new ArrayList<>();
        if (this.getSource().offset(1,2)!=null){
            want.add(this.getSource().offset(1,2));}
        if (this.getSource().offset(-1,2)!=null){
            want.add(this.getSource().offset(-1,2));}
        if (this.getSource().offset(2,1)!=null){
            want.add(this.getSource().offset(2,1));}
        if (this.getSource().offset(-2,1)!=null){
            want.add(this.getSource().offset(-2,1));}
        if (this.getSource().offset(2,-1)!=null){
            want.add(this.getSource().offset(2,-1));}
        if (this.getSource().offset(-2,-1)!=null){
            want.add(this.getSource().offset(-2,-1));}
        if (this.getSource().offset(1,-2)!=null){
            want.add(this.getSource().offset(1,-2));}
        if (this.getSource().offset(-1,-2)!=null){
            want.add(this.getSource().offset(-1,-2));}
        List<ChessboardPoint> kong = new ArrayList<>(want);
        for (int i = 0; i < want.size(); i++) {
            if (this.getChessColor()==nowqipan[kong.get(i).getX()][kong.get(i).getY()].getChessColor()){
                want.remove(kong.get(i));
            }
        }
        return want;
    }
}
