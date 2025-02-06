import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(){
        super();
        name='B';
    }
    public BishopChessComponent(int x,int y){
        super(x, y);
        name='B';
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> ap=new ArrayList<>();
        {
            int dx=1;int dy=1;
            while (valid(dx,dy)){
                ap.add(source.xinWei(dx,dy));
                if (this.getQiPan().getChess(source.getX()+dx,source.getY()+dy).getChessColor()!=ChessColor.NONE){
                    break;
                }
                dx++;dy++;
            }
        }
        {
            int dx=1;int dy=-1;
            while (valid(dx,dy)){
                ap.add(source.xinWei(dx,dy));
                if (this.getQiPan().getChess(source.getX()+dx,source.getY()+dy).getChessColor()!=ChessColor.NONE){
                    break;
                }
                dx++;dy--;
            }
        }
        {
            int dx=-1;int dy=1;
            while (valid(dx,dy)){
                ap.add(source.xinWei(dx,dy));
                if (this.getQiPan().getChess(source.getX()+dx,source.getY()+dy).getChessColor()!=ChessColor.NONE){
                    break;
                }
                dx--;dy++;
            }
        }
        {
            int dx=-1;int dy=-1;
            while (valid(dx,dy)){
                ap.add(source.xinWei(dx,dy));
                if (this.getQiPan().getChess(source.getX()+dx,source.getY()+dy).getChessColor()!=ChessColor.NONE){
                    break;
                }
                dx--;dy--;
            }
        }
        return ap;
    }
}
