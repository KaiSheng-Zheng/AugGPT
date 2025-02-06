import java.util.ArrayList;
import java.util.List;

/**
 * @Date: 2022/5/20 15:34
 */
public class KingChessComponent extends ChessComponent {

    private ChessComponent[][] chessComponents;
    public void setChessComponents(ChessComponent[][] chessComponents){
        this.chessComponents=chessComponents;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x = this.getSource().getX();
        int y=this.getSource().getY();
        List<ChessboardPoint> list=new ArrayList<>();
        int arr[][]={{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};
        for (int i = 0; i < arr.length; i++) {
            ChessboardPoint offset = this.getSource().offset(arr[i][0], arr[i][1]);
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
        if(this.chessComponents[sourceX][sourceY].getChessColor()==this.chessComponents[targetX][targetY].getChessColor()){
            return false;
        }else{
            return true;
        }
    }
}
