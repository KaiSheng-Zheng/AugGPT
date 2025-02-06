import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    public KingChessComponent(){
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> want=new ArrayList<ChessboardPoint>();
        if (this.getSource().offset(1,0)!=null){
        want.add(this.getSource().offset(1,0));}
        if (this.getSource().offset(0,1)!=null){
        want.add(this.getSource().offset(0,1));}
        if (this.getSource().offset(1,1)!=null){
        want.add(this.getSource().offset(1,1));}
        if (this.getSource().offset(-1,0)!=null){
        want.add(this.getSource().offset(-1,0));}
        if (this.getSource().offset(-1,-1)!=null){
        want.add(this.getSource().offset(-1,-1));}
        if (this.getSource().offset(1,-1)!=null){
        want.add(this.getSource().offset(1,-1));}
        if (this.getSource().offset(-1,1)!=null){
        want.add(this.getSource().offset(-1,1));}
        if (this.getSource().offset(0,-1)!=null){
        want.add(this.getSource().offset(0,-1));}
        List<ChessboardPoint> kong = new ArrayList<>(want);
        for (int i = 0; i < want.size(); i++) {
            if (this.getChessColor()==nowqipan[kong.get(i).getX()][kong.get(i).getY()].getChessColor()){
                want.remove(kong.get(i));
            }
        }
        return want;
    }
}
