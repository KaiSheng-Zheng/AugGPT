import java.util.ArrayList;
import java.util.List;

/**
 * @Date: 2022/5/20 15:34
 */
public class PawnChessComponent extends ChessComponent {

    private ChessComponent[][] chessComponents;
    public void setChessComponents(ChessComponent[][] chessComponents){
        this.chessComponents=chessComponents;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x = this.getSource().getX();
        int y=this.getSource().getY();
        List<ChessboardPoint> list=new ArrayList<>();
        if(this.getChessColor()==ChessColor.BLACK){
            if(x==1){
                ChessboardPoint offset = getSource().offset(2, 0);
                if(offset!=null){
                    list.add(offset);
                }
            }
            ChessboardPoint offset = getSource().offset(1, 0);
            if(offset!=null){
                list.add(offset);
            }
            offset = getSource().offset(1, 1);
            if(offset!=null){
                list.add(offset);
            }
            offset = getSource().offset(1, -1);
            if(offset!=null){
                list.add(offset);
            }
        }else{
            if(x==6){
                ChessboardPoint offset = getSource().offset(-2, 0);
                if(offset!=null){
                    list.add(offset);
                }
            }
            ChessboardPoint offset = getSource().offset(-1, 0);
            if(offset!=null){
                list.add(offset);
            }
            offset = getSource().offset(-1, 1);
            if(offset!=null){
                list.add(offset);
            }
            offset = getSource().offset(-1, -1);
            if(offset!=null){
                list.add(offset);
            }
        }
        List<ChessboardPoint> list1=new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if(this.check(this.getSource().getX(),this.getSource().getY(),list.get(i).getX(),list.get(i).getY())){
                list1.add(list.get(i));
            }
        }
        return list1;

    }
    public boolean check(int sourceX,int sourceY,int targetX,int targetY){
        if(sourceY-targetY==1 || sourceY-targetY==-1) {
            if (this.chessComponents[targetX][targetY].getChessColor()!=this.chessComponents[sourceX][sourceY].getChessColor()&&this.chessComponents[targetX][targetY].getName()!='_') {
                return true;
            } else {
                return false;
            }
        }else{
            if(this.chessComponents[targetX][targetY].getName()=='_'){
                return true;
            }else{
                return false;
            }
        }
    }
}
